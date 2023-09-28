package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.ImageSpan;
import com.boostywannabe.springproj.model.ImageType;
import com.boostywannabe.springproj.repository.ImageSpanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ImageSpanContext{

    private final ImageSpanRepository repository;

    ImageSpanContext(ImageSpanRepository repository) {
        this.repository = repository;
    }

    public ImageSpan getByImageID(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ImageSpan> getImages() {
        return repository.findAll();
    }

    public void addImageSpan(ImageSpan img) {
        repository.save(img);
    }

    public void addImageSpan(MultipartFile img) throws IOException {
        repository.save(new ImageSpan(
                Integer.toHexString( Arrays.hashCode( img.getBytes() ) ),
                ImageType.valueOf(img.getContentType()),
                img.getBytes()));
    }

    public void deleteImageSpan(Long id) {
        repository.deleteById(id);
    }

    public void editImageSpan(Long id, ImageSpan newImg) {
        newImg.setImageID(id);
        repository.save(newImg);
    }
}
