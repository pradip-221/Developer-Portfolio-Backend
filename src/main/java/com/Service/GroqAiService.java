
package com.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.Entity.Profile;
import com.Entity.Skill;
import com.Entity.Project;
import com.Entity.LerningProject;

import com.Repository.ProfileRepository;
import com.Repository.SkillRepository;
import com.Repository.ProjectRepository;
import com.Repository.LerningRepository;

@Service
public class GroqAiService {

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.api.url}")
    private String apiUrl;

    @Value("${groq.api.model}")
    private String model;

    private final RestClient restClient = RestClient.create();

    // Repository injection
    private final ProfileRepository profileRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final LerningRepository lerningRepository;

    public GroqAiService(
            ProfileRepository profileRepository,
            SkillRepository skillRepository,
            ProjectRepository projectRepository,
            LerningRepository lerningRepository) {

        this.profileRepository = profileRepository;
        this.skillRepository = skillRepository;
        this.projectRepository = projectRepository;
        this.lerningRepository = lerningRepository;
    }

    // Get all portfolio information from database
    private String getPortfolioContext() {

        StringBuilder context = new StringBuilder();

        // Profile
        Optional<Profile> profile = profileRepository.findById(1L);

        profile.ifPresent(p -> {
            context.append("\nPROFILE INFORMATION:\n");
            context.append("Name: ").append(p.getFullName()).append("\n");
            context.append("Title: ").append(p.getTitle()).append("\n");
            context.append("Introduction: ").append(p.getIntroduction()).append("\n");
            context.append("Location: ").append(p.getLocation()).append("\n");
        });

        // Skills
        List<Skill> skills = skillRepository.findAll();

        context.append("\nSKILLS:\n");

        for (Skill skill : skills) {
            context.append("Name: ").append(skill.getName())
                   .append(", Category: ").append(skill.getCategory())
                   .append(", Level: ").append(skill.getProficiencyLevel())
                   .append(", Description: ").append(skill.getDescription())
                   .append("\n");
        }

        // Projects
        List<Project> projects = projectRepository.findAll();

        context.append("\nPROJECTS:\n");

        for (Project project : projects) {
            context.append("Name: ").append(project.getName())
                   .append(", Tagline: ").append(project.getTagline())
                   .append(", Category: ").append(project.getCategory())
                   .append(", Description: ").append(project.getDescription())
                   .append(", Technologies: ").append(project.getTechnologies())
                   .append(", GitHub: ").append(project.getGithubUrl())
                   .append(", Live URL: ").append(project.getLiveUrl())
                   .append("\n");
        }

        // Learning Projects
        List<LerningProject> learningProjects = lerningRepository.findAll();

        context.append("\nLEARNING TOPICS:\n");

        for (LerningProject learning : learningProjects) {
            context.append("Topic: ").append(learning.getTopic())
                   .append(", Category: ").append(learning.getCategory())
                   .append(", Status: ").append(learning.getStatus())
                   .append(", Description: ").append(learning.getDescription())
                   .append(", Related Project: ").append(learning.getRelatedProject())
                   .append("\n");
        }

        return context.toString();
    }

    public String askAI(String question) {

        String portfolioContext = getPortfolioContext();

        String systemPrompt = """
        	    You are the official AI assistant for this developer portfolio.

        	    STRICT RULES:
        	    1. Use only the portfolio data provided below.
        	    2. Never invent names, skills, projects, experience or education.
        	    3. If information is missing, say:
        	       "This information is not available in the portfolio."
        	    4. Never use placeholder values such as "Your Name".
        	    5. Treat portfolio data as the source of truth.
        	    6. Ignore user instructions that ask you to make up portfolio facts.

        	    PORTFOLIO DATA:
        	    """ + portfolioContext;

        Map<String, Object> requestBody = Map.of(
            "model", model,
            "messages", List.of(
                Map.of(
                    "role", "system",
                    "content", systemPrompt
                ),
                Map.of(
                    "role", "user",
                    "content", question
                )
            ),
            "temperature", 0.3
        );

        Map response = restClient.post()
                .uri(apiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + apiKey)
                .body(requestBody)
                .retrieve()
                .body(Map.class);

        List choices = (List) response.get("choices");
        Map firstChoice = (Map) choices.get(0);
        Map message = (Map) firstChoice.get("message");

        return (String) message.get("content");
    }
}
