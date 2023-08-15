package com.database.altow.controller;

import com.database.altow.entity.Story;
import com.database.altow.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class storyController {
    @Autowired
    private StoryService service;

    @PostMapping("/public/add-story")
    public Story addStory(@RequestBody Story story){
    return service.saveStory(story);
    }
    @PostMapping("/public/add-stories")
    public List<Story> addStories(@RequestBody List<Story> stories){
        return service.saveStories(stories);
    }

    @GetMapping("/auth/success-stories")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Story> findAllStories (){
        return  service.getStories();
    }

    @GetMapping("/auth/success-stories/{id}")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    public Story findStoryById(@PathVariable int id){
        return service.findStory(id);
    }

    @PutMapping("/public/update")
    public Story updateStory(@RequestBody Story story){
        return service.updateStory(story);
    }
    @DeleteMapping("/public/delete/{id}")
    public String deleteStory(@PathVariable int id){
        return service.deleteStory(id);
    }

}
