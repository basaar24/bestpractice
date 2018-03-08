package com.axity.arquitectura.bestpractices.artista;

import com.axity.arquitectura.bestpractices.data.ArtistaTO;

import java.util.List;

public interface ArtistaService {

    /*
    *
    * Metodo encargado de buscar los artitas por nombres
    * */
    List<ArtistaTO> buscarPorNombre(String nombre);

    /*
     *
     * Ejemplo de metodo que elimina los duplicados.
     * */
    void eliminarDuplicados();

    /**
     * Ejemplo de agrupar una colleccion
     *
     * */
    void agruparCollecion();
}
