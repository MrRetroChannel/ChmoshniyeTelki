package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.VideoSpan;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoSpanService {
    VideoSpan getByVideoID(Long id);

    List<VideoSpan> getVideos();

    void addVideoSpan(VideoSpan img);

    void addVideoSpan(MultipartFile img) throws IOException;

    void deleteVideoSpan(Long id);

    void editVideoSpan(Long id, VideoSpan newImg);
}