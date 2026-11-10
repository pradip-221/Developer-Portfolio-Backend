
package com.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.GroqAiService;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final GroqAiService groqAiService;

    public AiController(GroqAiService groqAiService) {
        this.groqAiService = groqAiService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> chat(
            @RequestBody Map<String, String> request) {

        String question = request.get("message");

        if (question == null || question.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(
                Map.of("error", "Message cannot be empty")
            );
        }

        String answer = groqAiService.askAI(question);

        return ResponseEntity.ok(
            Map.of("answer", answer)
        );
    }
}
