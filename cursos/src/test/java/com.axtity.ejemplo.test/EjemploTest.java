package com.axtity.ejemplo.test;


import com.axity.arquitectura.bestpractices.artista.ArtistaService;
import com.axity.arquitectura.bestpractices.artista.impl.ArtistaServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class EjemploTest {

    private ArtistaService artistaService;

    @Before
    public void beforeTest(){
        artistaService= new ArtistaServiceImpl();

    }

    @Test
    public void testArtistias(){
        artistaService.buscarPorNombre(" Roger").
                forEach(x->{
                    System.out.println(x.getNombre());
                });
    }
}
