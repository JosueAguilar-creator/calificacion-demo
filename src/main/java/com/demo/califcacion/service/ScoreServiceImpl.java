package com.demo.califcacion.service;

import com.demo.califcacion.model.entity.ScoreEntity;
import com.demo.califcacion.repository.ScoreRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/api")
@Service
public class ScoreServiceImpl implements ScoreService {

    private static final String DIRECTORY = "C:\\Users\\josue\\IdeaProjects\\califcacion\\src\\main\\java\\com\\demo\\califcacion\\files\\";

    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/scores")
    @Override
    public List<ScoreEntity> findAllScores() {
        return scoreRepository.findAll();
    }


    @GetMapping(path = "report/columns/{score_id}")
    public ScoreEntity findScoreByScoreId(@PathVariable("score_id") int score_id) {
        return scoreRepository.findByScoreId(score_id);
    }

    @GetMapping(path = "student/scores/{student_code}")
    @Override
    public List<ScoreEntity> findAllScoresByStudentCode(@PathVariable("student_code") String student_code) {
        return scoreRepository.findAllScoresByStudentCode(student_code);
    }

    @GetMapping("/score/xml-file/{score_id}")
    @Override
    public ResponseEntity<byte[]> generateXMLByScoreId(@PathVariable("score_id") int score_id) throws IOException {
        ScoreEntity scoreEntity = scoreRepository.findByScoreId(score_id);


        String pathName = DIRECTORY+ scoreEntity.getStudent_code()+".xml";

        generateXML(scoreEntity, pathName);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setContentDispositionFormData(pathName, scoreEntity.getStudent_code()+".xml");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        byte[] content = Files.readAllBytes(new File(pathName).toPath());
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }


    private void generateXML(ScoreEntity scoreEntity, String pathName) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(ScoreEntity.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File(pathName);
            jaxbMarshaller.marshal(scoreEntity, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
