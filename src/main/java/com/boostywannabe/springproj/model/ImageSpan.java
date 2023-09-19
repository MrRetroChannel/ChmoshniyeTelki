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

    @Column(name = "bytes")
    private byte[] bytes;

    public ImageSpan() {

    }

    public ImageSpan(Long ImageID, String name, byte[] bytes) {
        this.ImageID = ImageID;
        this.name = name;
        this.bytes = bytes;
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

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] imagebin) {
        this.bytes = bytes;
    }
}
