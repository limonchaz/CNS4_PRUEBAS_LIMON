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
        fileName = "board.txt";
    }
    
    @Test
    public void testFileNotFound() {
        String[][] res = bm.startGame("asd.txt");
        assertEquals("El archivo no se encontro(2)",res[0][0]);
    }
    
    @Test
    public void testFileEmpty() {
        String[][] res = bm.startGame("emptyBoard.txt");
        assertEquals("Archivo incorrecto",res[0][0]);
    }
    
    @Test
    public void testBoardSize() {
        String[][] res = bm.startGame("incorrectBoard.txt");
        assertEquals("El tamaño del tablero no coincide con las dimensiones especificadas en el archivo",res[0][0]);
    }
    
    @Test
    public void testBoard() {
        String[][] res = bm.startGame(fileName);
        Util.printBoard(res);
        assertNotNull(res);
    }
    
    @Test
    public void testOutBoard() {
        String[][] res = bm.startGame(fileName);
        assertEquals("*", res[0][0]);
        assertEquals("1", res[0][1]);
        assertEquals("0", res[0][2]);
        assertEquals("0", res[0][3]);
        assertEquals("2", res[1][0]);
        assertEquals("2", res[1][1]);
        assertEquals("1", res[1][2]);
        assertEquals("0", res[1][3]);
        assertEquals("1", res[2][0]);
        assertEquals("*", res[2][1]);
        assertEquals("1", res[2][2]);
        assertEquals("0", res[2][3]);
        assertEquals("1", res[3][0]);
        assertEquals("1", res[3][1]);
        assertEquals("1", res[3][2]);
        assertEquals("0", res[3][3]);
    }
}
