
package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SampleDB")
@Data
public class PdfEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String dept;
    private String phoneNumber;

    
    public PdfEntity() {}

    public PdfEntity(String name, String dept, String phoneNumber) {
        this.name = name;
        this.dept = dept;
        this.phoneNumber = phoneNumber;
    }
}
