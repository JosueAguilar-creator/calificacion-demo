package com.demo.califcacion.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
public class ScoreXmlExample {

        @XmlElement(name = "codigo")
        private String student_code;

        @XmlElement(name = "ciclo")
        private String ciclo;

        @XmlElement(name = "clave-de-materia")
        private String clave_materia;

        @XmlElement(name = "calificación")
        private float score;

        @XmlElement(name = "tipo-de-calificación")
        private String score_type;

    }