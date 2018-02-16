package com.chanchi.ninja.novice.buscaminas.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.chanchi.ninja.novice.buscaminas.BuscaMinas;

public class UtilTest {

    @Test
    public void testReadFile() {
        InputStream is = BuscaMinas.class.getClassLoader().getResourceAsStream("board.txt");
        try {
            String[] obj = Util.readFile(is);
            assertNotNull(obj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testFileNotFound() {
        InputStream is = BuscaMinas.class.getClassLoader().getResourceAsStream("boards.txt");
        try {
            String[] obj = Util.readFile(is);
            assertNull(obj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testPrintBoard() {
        String[][] matrix = {{"0","*","*"},{"1","3","1"},{"*","1","0"}};
        
        Util.printBoard(matrix);
    }
}
