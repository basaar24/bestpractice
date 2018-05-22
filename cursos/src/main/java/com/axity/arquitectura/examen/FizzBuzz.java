package com.axity.arquitectura.examen;

public class FizzBuzz {

    public static void main(String[] args) {
            boolean fizzOrBuzz = false;
            int i =10;
            if (i % 3 == 0) {
                System.out.print("Fizz");
                fizzOrBuzz = true;
            }else if (i % 5 == 0) {
                System.out.print("Buzz");
                fizzOrBuzz = true;
            }else{

            }

            if (fizzOrBuzz) {
                System.out.println();
            } else {
                System.out.println(String.valueOf(i));
            }

    }
}
