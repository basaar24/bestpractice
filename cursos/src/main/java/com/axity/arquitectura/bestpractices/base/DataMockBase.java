package com.axity.arquitectura.bestpractices.base;

import com.axity.arquitectura.bestpractices.data.ArtistaTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public abstract class DataMockBase {

    private static final int DIEZ_MILL=10000;
    public  List<ArtistaTO> artistas = new ArrayList<ArtistaTO>(10000);
    public DataMockBase() {
        generarDatosMock();
    }

    private void generarDatosMock(){
        Random randomGenerator = new Random();

        Calendar fechaNacimiento = Calendar.getInstance();
        for (int index=0;index<DIEZ_MILL;index++){
            int edad = randomGenerator.nextInt(100);
            ArtistaTO artista = new ArtistaTO();
            artista.setNombre("Alberto Said " + edad);
            artista.setApellidos(" Ruminege " + index);

            fechaNacimiento.add(Calendar.DATE,1);
            artista.setFechaNacimiento(fechaNacimiento.getTime());
            Random rand = new Random();

            if(index>100 && (index%100)==1){
                artista.setEdad( null);
            }else{
                artista.setEdad( edad);
            }

            artistas.add(artista);
        }
        System.out.println(" artistas :::" +artistas.size());
    }
}
