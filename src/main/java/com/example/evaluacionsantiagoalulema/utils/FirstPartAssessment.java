package com.example.evaluacionsantiagoalulema.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class FirstPartAssessment {

    public void printNumer1To100() {
        System.out.println(" ----------------- EJERCOCIO 1 ---------------");
        for (int i = 1; i <= 100; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("SOMOS BA");
            } else if (i % 3 == 0) {
                System.out.println("SOMOS");
            } else if (i % 5 == 0) {
                System.out.println("BA");
            } else {
                System.out.println(i);
            }
        }
        System.out.println(" --------------------------------");
    }

    public boolean  anagramsWords(String worldOne, String worldTwo){
        System.out.println(" ----------------- EJERCOCIO 2 ---------------");

        if (worldOne == null || worldTwo == null  ) {
            return false;
        }
        worldOne = worldOne.replaceAll("\\s+", "").toUpperCase();
        worldTwo = worldTwo.replaceAll("\\s+", "").toUpperCase();

        if (worldOne.length() != worldTwo.length()) return false;

        char[] arrA = worldOne.toCharArray();
        char[] arrB = worldTwo.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        return Arrays.equals(arrA, arrB);
    }

    public void orderArray(int[] array, boolean isDescending){
        System.out.println(" ------------- Ejercicio 3 -------------------");

        if(isDescending){
            array = Arrays.stream(array)
                    .boxed()
                    .sorted((a, b) -> b - a)
                    .mapToInt(Integer::intValue)
                    .toArray();
        }else {
            Arrays.sort(array);
        }
        String listOrder = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("Lista ordenada "+listOrder);
        System.out.println(" --------------------------------------------");

    }

}
