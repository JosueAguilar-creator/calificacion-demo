package com.demo.califcacion.service;

import com.demo.califcacion.model.entity.ScoreEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

public interface ScoreService {

    public List<ScoreEntity> findAllScores();

    ScoreEntity findScoreByScoreId(@PathVariable("score_id") int score_id);

    public List<ScoreEntity> findAllScoresByStudentCode(String student_code);

    ResponseEntity<byte[]> generateXMLByScoreId(@PathVariable("score_id") int score_id) throws IOException, Exception;
}
