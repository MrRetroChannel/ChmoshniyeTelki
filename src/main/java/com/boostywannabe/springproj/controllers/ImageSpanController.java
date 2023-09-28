package com.boostywannabe.springproj.controllers;

import com.boostywannabe.springproj.model.ImageSpan;
import com.boostywannabe.springproj.service.ImageSpanContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
@RequestMapping("/images")
public class ImageSpanController  {
    @Autowired
    ImageSpanContext service;

    @PostMapping
    public void postImageSpan(@RequestBody ImageSpan img) {
        img.setName(Integer.toHexString( Arrays.hashCode( img.getBlob() ) ) );
        service.addImageSpan(img);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImage(@PathVariable("id") Long id) {
        var img = service.getByImageID(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/" + img.getExtension().getType()))
                .body(img.getBlob());
    }
}
