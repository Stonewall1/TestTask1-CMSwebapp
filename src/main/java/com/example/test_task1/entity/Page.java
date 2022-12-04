package com.example.test_task1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(length = 5000)
    private String description;
    private String slug;
    private String menu_label;
    private String h1;
    private String content;
    private LocalDateTime published_at;
    private int priority;

    public Page(String title, String description, String menu_label, String h1, LocalDateTime published_at, int priority) {
        this.title = title;
        this.description = description;
        this.menu_label = menu_label;
        this.h1 = h1;
        this.published_at = published_at;
        this.priority = priority;
    }
}
