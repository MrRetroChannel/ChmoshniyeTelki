package com.boostywannabe.springproj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class ImageSpan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long ImageID;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private ImageType extension;

    @Lob
    @Column(name = "bytes")
    private byte[] blob;

    public ImageSpan() {

    }
    public ImageSpan(Long ImageID, String name, ImageType extension, byte[] blob) {
        this.ImageID = ImageID;
        this.name = name;
        this.extension = extension;
        this.blob = blob;
    }

    public ImageSpan(String name, ImageType extension, byte[] blob) {
        this.name = name;
        this.extension = extension;
        this.blob = blob;
    }

    public Long getImageID() {
        return ImageID;
    }

    public void setImageID(Long imageID) {
        ImageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageType getExtension() {
        return extension;
    }

    public void setExtension(ImageType extension) {
        this.extension = extension;
    }

    public byte[] getBlob() {
        return blob;
    }

    public void setBlob(byte[] bytes) {
        this.blob = bytes;
    }
}
