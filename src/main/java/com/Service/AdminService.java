
package com.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Entity.Admin;
import com.Repository.AdminRepository;

@Service
public class AdminService {

    private final AdminRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AdminService(
            AdminRepository repo,
            PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin createAdmin(String username, String rawPassword) {

        if (repo.existsByUsername(username)) {
            throw new IllegalArgumentException("Admin username exists");
        }

        Admin admin = new Admin();

        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(rawPassword));
        admin.setRole("ADMIN");

        return repo.save(admin);
    }
}
