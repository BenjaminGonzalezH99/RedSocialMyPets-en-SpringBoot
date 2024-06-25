package com.generation.redsocialmypets.Repository;

import com.generation.redsocialmypets.Models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}