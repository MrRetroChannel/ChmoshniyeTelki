package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.VideoSpan;
import com.boostywannabe.springproj.model.VideoType;
import com.boostywannabe.springproj.repository.VideoSpanRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class VideoSpanContext{

    private final VideoSpanRepository repository;

    public VideoSpanContext(VideoSpanRepository repository) {
        this.repository = repository;
    }

    public VideoSpan getByVideoID(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<VideoSpan> getVideos() {
        return repository.findAll();
    }

    public void addVideoSpan(VideoSpan img) {
        repository.save(img);
    }

    public void addVideoSpan(MultipartFile video) throws IOException {
        repository.save(new VideoSpan(
                Integer.toHexString( Arrays.hashCode( video.getBytes() ) ),
                VideoType.valueOf(video.getContentType()),
                video.getBytes()));
    }

    public void deleteVideoSpan(Long id) {
        repository.deleteById(id);
    }

    public void editVideoSpan(Long id, VideoSpan newVideo) {
        newVideo.setVideoID(id);
        repository.save(newVideo);
    }
}
