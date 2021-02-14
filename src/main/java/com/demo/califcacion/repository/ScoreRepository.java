package com.demo.califcacion.repository;

import com.demo.califcacion.model.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {

    @Query("select e from ScoreEntity e where e.student_code = :student_code")
    List<ScoreEntity> findAllScoresByStudentCode(@Param("student_code") String student_code);

    @Query("select e from ScoreEntity e where e.scoreId = :score_id")
    ScoreEntity findByScoreId(@Param("score_id") int score_id);
}
