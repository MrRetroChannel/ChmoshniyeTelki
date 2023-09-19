package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.ImageSpan;
import com.boostywannabe.springproj.repository.ImageSpanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageSpanContext implements ImageSpanService {

    private final ImageSpanRepository repository;

    ImageSpanContext(ImageSpanRepository repository) {
        this.repository = repository;
    }

    @Override
    public ImageSpan getByImageID(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<ImageSpan> getImages() {
        return repository.findAll();
    }

    @Override
    public void addImageSpan(ImageSpan img) {
        repository.save(img);
    }
}
