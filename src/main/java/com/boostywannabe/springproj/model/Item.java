package com.boostywannabe.springproj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long ItemID;

    public Item() {

    }

    public Item(Long id) {
        ItemID = id;
    }
}
