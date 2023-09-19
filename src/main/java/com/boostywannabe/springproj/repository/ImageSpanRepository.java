package com.boostywannabe.springproj.repository;

import com.boostywannabe.springproj.model.ImageSpan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageSpanRepository extends JpaRepository<ImageSpan, Long> {

}
