package com.lfte.catalogo_videojuego;

import com.lfte.catalogo_videojuego.model.Desarrollador;
import com.lfte.catalogo_videojuego.repository.DesarrolladorRepository;
import com.lfte.catalogo_videojuego.service.DesarrolladorService;
import com.lfte.catalogo_videojuego.service.impl.DesarrolladorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DesarrolladorTest {

    @Mock
    DesarrolladorRepository repo;

    @InjectMocks
    DesarrolladorService desarrolladorService = new DesarrolladorServiceImpl();


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getDesarrollador(){
        Long desarrolladorId = 1L;
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.setIdDesarrollador(desarrolladorId);
        desarrollador.setNombre("IBM");

        when(repo.findById(desarrolladorId)).thenReturn(Optional.of(desarrollador));
        Desarrollador developer =desarrolladorService.findById(desarrolladorId);
        assertEquals(developer.getIdDesarrollador(), developer);
        assertEquals(developer.getNombre(), "IBM");


    }
}
