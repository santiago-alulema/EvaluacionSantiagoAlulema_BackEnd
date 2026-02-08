package com.example.evaluacionsantiagoalulema;

import com.example.evaluacionsantiagoalulema.utils.FirstPartAssessment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EvaluacionSantiagoAlulemaApplication {

    private final FirstPartAssessment firstPartAssessment;

    public EvaluacionSantiagoAlulemaApplication(FirstPartAssessment firstPartAssessment) {
        this.firstPartAssessment = firstPartAssessment;
    }

    public static void main(String[] args) {
        SpringApplication.run(EvaluacionSantiagoAlulemaApplication.class, args);
    }

    @Bean
    CommandLineRunner holaMundo() {
        return args -> {

            firstPartAssessment.printNumer1To100();

            String wordOne = "Ecuador";
            String wordSecond = "ACUERDO2";

            boolean isAnagram = firstPartAssessment.anagramsWords(wordOne, wordSecond);
            if(!isAnagram){
                System.out.println("No es Anagrama");
            }else{
                System.out.println("Es Anagrama");
            }
            System.out.println(" --------------------------------------------");

            int[] array = {50,5,10,36,25,85,23,65};
            firstPartAssessment.orderArray(array, true);

        };
    }

}
