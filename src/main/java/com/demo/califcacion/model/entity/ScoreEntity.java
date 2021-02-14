package com.demo.califcacion.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Table(name="calificacion")
@Entity
@XmlRootElement(name="violationReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScoreEntity {
    @Column(name = "scoreId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreId;

    @Column(name = "student_code")
    @XmlElement(name = "codigo")
    private String student_code;

    @Column(name = "ciclo")
    @XmlElement(name = "ciclo")
    private String ciclo;

    @Column(name = "clave_materia")
    @XmlElement(name = "clave-de-materia")
    private String clave_materia;

    @Column(name = "score")
    @XmlElement(name = "calificación")
    private float score;

    @Column(name = "score_type")
    @XmlElement(name = "tipo-de-calificación")
    private String score_type;

}
