package com.axity.arquitectura.examen;

import java.util.Arrays;
import java.util.Stack;

public class Pregunta4 {

    static int max;
    static int min;

    public static void max_min(int my_array[]) {
        Arrays.sort(my_array);
        max = my_array[(my_array.length-1)];
        min = my_array[0];
        Stack<String> stack = new Stack<>();
    }

    public static void main(String[] args) {
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        max_min(my_array);
        System.out.println(" Original Array: "+Arrays.toString(my_array));
        System.out.println(" Maximum value for the above array = " + max);
        System.out.println(" Minimum value for the above array = " + min);
    }
}
