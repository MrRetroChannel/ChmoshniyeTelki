package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.model.ImageSpan;
import java.util.List;

public interface ImageSpanService {
    ImageSpan getByImageID(Long id);

    List<ImageSpan> getImages();

    void addImageSpan(ImageSpan img);
}