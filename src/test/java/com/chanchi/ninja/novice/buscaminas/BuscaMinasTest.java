package com.chanchi.ninja.novice.buscaminas;

import org.junit.Test;

public class BuscaMinasTest {

    @Test
    public void testReadFile() {
        String fileName = "/home/indigo30/git/CNS4_PRUEBAS_LIMON/src/main/resources/board.txt";
        BuscaMinas bm = new BuscaMinas();
        
        try {
            bm.startGame(fileName);
        }catch (Exception e) {
            System.out.println("No encontro el archivo " + e);
        }
    }
}
