package com.boostywannabe.springproj.repository;

import com.boostywannabe.springproj.models.VideoSpan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoSpanRepository extends JpaRepository<VideoSpan, Long> {
}
