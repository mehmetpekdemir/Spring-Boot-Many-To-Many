package com.mehmetpekdemir.manytomany.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.manytomany.entity.StudentEntity;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

	Optional<StudentEntity> findByStudentNo(String studentNo);

	boolean existsStudentByStudentNo(String studentNo);

}
