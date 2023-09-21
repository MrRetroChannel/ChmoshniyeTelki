package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.ImageSpan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageSpanService {
    ImageSpan getByImageID(Long id);

    List<ImageSpan> getImages();

    void addImageSpan(ImageSpan img);

    void deleteImageSpan(Long id);

    void editImageSpan(Long id, ImageSpan newImg);
}