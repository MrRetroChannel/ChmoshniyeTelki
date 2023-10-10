package com.boostywannabe.springproj.controllers;

import com.boostywannabe.springproj.models.VideoSpan;
import com.boostywannabe.springproj.service.VideoSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/videos")
public class VideoSpanController {
    @Autowired
    VideoSpanService service;

    @PostMapping("/multipart")
    public void postVideoSpan(@RequestBody MultipartFile video) throws IOException {
        service.addVideoSpan(video);
    }

    @PostMapping
    public void postVideoSpan(@RequestBody VideoSpan video) {
        video.setName(Integer.toHexString( Arrays.hashCode( video.getBlob() ) ) );
        service.addVideoSpan(video);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImage(@PathVariable("id") Long id) {
        var video = service.getByVideoID(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf("video/" + video.getExtension().getType()))
                .body(video.getBlob());
    }
}