package com.axity.arquitectura.examen;

 class E {
     public E(){
         System.out.print("E");
     }
}
class F {
    public F(){
        System.out.print("F");
    }
}
class G extends E {
    public G(){
        System.out.print("G");
    }
}
class H extends F {
    public H(){
        System.out.print("H");
    }
}
public class Pregunta3 {
    public static void main(String[] args) {
        E a = new G();
        G c = new G();
        F b = new H();
        H d = new H();
    }
}