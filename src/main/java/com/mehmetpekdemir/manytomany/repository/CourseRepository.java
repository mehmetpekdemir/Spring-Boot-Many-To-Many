package com.mehmetpekdemir.manytomany.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.manytomany.entity.CourseEntity;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

	Optional<CourseEntity> findByCourseName(String courseName);

}
