package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.ImageSpan;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageSpanService {
    ImageSpan getByImageID(Long id);

    List<ImageSpan> getImages();

    void addImageSpan(ImageSpan video);

    void addImageSpan(MultipartFile video) throws IOException;

    void deleteImageSpan(Long id);

    void editImageSpan(Long id, ImageSpan newImg);
}