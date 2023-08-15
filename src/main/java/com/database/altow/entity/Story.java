package com.database.altow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "story")
public class Story {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "title", columnDefinition = "LONGTEXT")
    private String title;

    @Column(name = "organization_name", columnDefinition = "LONGTEXT")
    private String organizationName;

    @Column(name = "cover_image_links", columnDefinition = "BLOB")
    private List<String> coverImageLinks;

    @Column(name = "content_image_links", columnDefinition = "BLOB")
    private List<String> contentImageLinks;

    @Column(name = "story_paragraph", columnDefinition = "LONGTEXT")
    private String storyParagraph;
}
