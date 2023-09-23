package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.ImageSpan;
import com.boostywannabe.springproj.model.ImageType;
import com.boostywannabe.springproj.model.VideoSpan;
import com.boostywannabe.springproj.model.VideoType;
import com.boostywannabe.springproj.repository.VideoSpanRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class VideoSpanContext implements VideoSpanService {

    private final VideoSpanRepository repository;

    public VideoSpanContext(VideoSpanRepository repository) {
        this.repository = repository;
    }

    @Override
    public VideoSpan getByVideoID(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VideoSpan> getVideos() {
        return repository.findAll();
    }

    @Override
    public void addVideoSpan(VideoSpan img) {
        repository.save(img);
    }

    @Override
    public void addVideoSpan(MultipartFile video) throws IOException {
        repository.save(new VideoSpan(
                Integer.toHexString( Arrays.hashCode( video.getBytes() ) ),
                VideoType.valueOf(video.getContentType()),
                video.getBytes()));
    }

    @Override
    public void deleteVideoSpan(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void editVideoSpan(Long id, VideoSpan newVideo) {
        newVideo.setVideoID(id);
        repository.save(newVideo);
    }
}
