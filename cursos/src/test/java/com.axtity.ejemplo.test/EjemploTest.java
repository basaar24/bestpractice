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
        for (ArtistaTO artista: artistas) {
            System.out.println(artista.getNombre() + " " + artista.getEdad());
        }
    }
}
