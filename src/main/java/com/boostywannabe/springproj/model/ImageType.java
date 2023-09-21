package com.boostywannabe.springproj.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ImageType {
    JPEG("jpeg"),
    JPG("jpeg"),
    PNG("png"),
    WEBP("webp"),
    GIF("gif"),
    BMP("bmp");

    private final String strType;

    private ImageType(final String str) {
        strType = str;
    }

    @JsonValue
    public String getType() {
        return this.strType;
    }
}
