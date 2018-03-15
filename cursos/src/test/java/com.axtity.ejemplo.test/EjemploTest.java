package com.axtity.ejemplo.test;


import com.axity.arquitectura.bestpractices.artista.ArtistaService;
import com.axity.arquitectura.bestpractices.artista.impl.ArtistaServiceImpl;
import com.axity.arquitectura.bestpractices.data.ArtistaTO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EjemploTest {

    private ArtistaService artistaService;

    @Before
    public void beforeTest(){
        artistaService= new ArtistaServiceImpl();

    }

    @Test
    public void testArtistias(){
        List<ArtistaTO> artistas = artistaService.buscarPorNombre(" Roger");

    }

    @Test
    public void testEliminarArtistas(){
         artistaService.eliminarDuplicados();
    }

    @Test
    public void testAgruparCollecion(){
        artistaService.agruparCollecion();
    }

    @Test
    public void testDivision(){
        int year =2006;
        int bc = year%400;
        boolean isSame = bc==0;
        System.out.println(" resultado ==" + year +" === " + bc + " resutlado "+ isSame + " da "+ (year % 400 == 0));
        boolean isLeap= (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
        System.out.println(" isleap ==" + isLeap);
    }
}
