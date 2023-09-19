package com.boostywannabe.springproj.controllers;

import com.boostywannabe.springproj.model.ImageSpan;
import com.boostywannabe.springproj.service.ImageSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageSpanController  {
    private final ImageSpanService repository;

    ImageSpanController(ImageSpanService repos) {
        this.repository = repos;
    }

    @PostMapping
    public void postImageSpan(@RequestBody ImageSpan img) {
        repository.addImageSpan(img);
    }
}
