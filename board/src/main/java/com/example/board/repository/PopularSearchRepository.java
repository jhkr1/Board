package com.example.board.repository;

import com.example.board.entity.PopularSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopularSearchRepository extends JpaRepository<PopularSearchEntity, String> {
}
