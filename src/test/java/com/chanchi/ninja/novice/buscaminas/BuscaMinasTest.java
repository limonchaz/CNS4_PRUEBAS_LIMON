package com.chanchi.ninja.novice.buscaminas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.chanchi.ninja.novice.buscaminas.utils.Util;

public class BuscaMinasTest {

    BuscaMinas bm = new BuscaMinas();
    String fileName = "";
    
    @Before
    public void init() {
        fileName = "/home/indigo30/git/CNS4_PRUEBAS_LIMON/src/main/resources/board.txt";
    }
    
    @Test
    public void testFileNotFound() {
        String[][] res = bm.startGame("");
        assertEquals("El archivo no se encontro",res[0][0]);
    }
    
//    @Test
    public void testFileEmpty() {
        String[][] res = bm.startGame(fileName);
        assertEquals("El contenido del archivo es vacio",res[0][0]);
    }
    
//    @Test
    public void testBoardSize() {
        String[][] res = bm.startGame(fileName);
        assertEquals("El tamaño del tablero no coincide con las dimensiones especificadas en el archivo",res[0][0]);
    }
    
    @Test
    public void testBoard() {
        String[][] res = bm.startGame(fileName);
        Util.printBoard(res);
        assertNotNull(res);
    }
}
