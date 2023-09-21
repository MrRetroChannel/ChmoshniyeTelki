package com.boostywannabe.springproj.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VideoType {
    AVI("avi"),
    MOV("mov"),
    MP4("mp4"),
    WEBM("webm"),
    OGG("ogg");

    private final String strType;

    private VideoType(String type) {
        strType = type;
    }

    @JsonValue
    public String getType() {
        return this.strType;
    }
}
