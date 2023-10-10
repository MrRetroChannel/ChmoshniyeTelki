package com.boostywannabe.springproj.repository;

import com.boostywannabe.springproj.models.ImageSpan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageSpanRepository extends JpaRepository<ImageSpan, Long> {

}
