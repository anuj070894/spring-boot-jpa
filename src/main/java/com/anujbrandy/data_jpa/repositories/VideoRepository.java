package com.anujbrandy.data_jpa.repositories;

import com.anujbrandy.data_jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
