package org.example.entity;

import lombok.Data;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class Base<ID>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
