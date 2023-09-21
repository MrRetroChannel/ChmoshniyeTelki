package com.boostywannabe.springproj.controllers;

import com.boostywannabe.springproj.model.VideoSpan;
import com.boostywannabe.springproj.service.VideoSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/videos")
public class VideoSpanController {
    private final VideoSpanService service;

    VideoSpanController(VideoSpanService service) {
        this.service = service;
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
