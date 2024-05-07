package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PdfProjectApplication implements CommandLineRunner {
    @Autowired
    PdfRepository pr;

    public static void main(String[] args) {
        SpringApplication.run(PdfProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(pr.count()==0) {
            pr.saveAll(Arrays.asList(
                    new PdfEntity("Ravi","Accounts","9486324457"),
                    new PdfEntity("Selva","Admin","8056375525"),
                    new PdfEntity("Ashok","Finance","7856312245"),
                    new PdfEntity("Vinoth","Security","8122868955"),
                    new PdfEntity("Guru","Tech","8456312278")));
        }
    }
}
