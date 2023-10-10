package com.boostywannabe.springproj.models;

import jakarta.persistence.*;

@Entity
@Table(name = "video")
public class VideoSpan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "videoID")
    private Long videoID;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private VideoType extension;

    @Lob
    @Column(name = "blob")
    private byte[] blob;

    public VideoSpan(Long videoID, String name, VideoType extension, byte[] blob) {
        this.videoID = videoID;
        this.name = name;
        this.extension = extension;
        this.blob = blob;
    }

    public VideoSpan(String name, VideoType extension, byte[] blob) {
        this.name = name;
        this.extension = extension;
        this.blob = blob;
    }

    public VideoSpan() {

    }

    public Long getVideoID() {
        return videoID;
    }

    public void setVideoID(Long videoID) {
        this.videoID = videoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VideoType getExtension() {
        return extension;
    }

    public void setExtension(VideoType extension) {
        this.extension = extension;
    }

    public byte[] getBlob() {
        return blob;
    }

    public void setBlob(byte[] blob) {
        this.blob = blob;
    }
}
