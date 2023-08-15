package com.database.altow.service;

import com.database.altow.entity.Story;
import com.database.altow.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    private StoryRepository repository;

    public Story saveStory(Story story){
        return repository.save(story);
    }
    public List<Story> saveStories(List<Story> stories){
        return repository.saveAll(stories);
    }
    public List<Story> getStories(){
        return repository.findAll();
    }
    public Story findStory(int id){
        return repository.findById(id).orElse(null);
    }
    public String deleteStory (int id){
        repository.deleteById(id);
        return "Story Deleted ! "+id;
    }

    public Story updateStory(Story story ){
         Story existingStory = repository.findById(story.getId()).orElse(null);
         existingStory.setId(story.getId());
        existingStory.setStoryParagraph(story.getStoryParagraph());
        existingStory.setTitle(story.getTitle());
        existingStory.setCoverImageLinks(story.getCoverImageLinks());
        existingStory.setContentImageLinks(story.getContentImageLinks());
        existingStory.setOrganizationName(story.getOrganizationName());
        return  repository.save(existingStory);
    }
}
