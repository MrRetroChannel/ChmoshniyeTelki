package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.VideoSpan;

import java.util.List;

public interface VideoSpanService {
    VideoSpan getByVideoID(Long id);

    List<VideoSpan> getVideos();

    void addVideoSpan(VideoSpan img);

    void deleteVideoSpan(Long id);

    void editVideoSpan(Long id, VideoSpan newImg);
}
