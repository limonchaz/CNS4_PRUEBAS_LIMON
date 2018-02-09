package com.chanchi.ninja.novice.buscaminas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuscaMinas {

    public void startGame(String fileName) {
        try {
            readFile(fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        
        String linea =  br.readLine();
        
        String[] rows = {};
        
        while(linea != null) {
            int val = 0;
            int left = 0;
            int right = 0;
            boolean flag = false;
            rows = linea.split("");

            for (int i = 0; i < rows.length; i++) {
                String[] newRow = buildNumericBoard(rows);
            }
            System.out.println("");
            linea = br.readLine();
        }
        
        br.close();
    }
    
    
    public String[] buildNumericBoard(String[] row) {
        String[] newRow = {};
        for (int i = 0; i < row.length; i++) {
            if (".".equals(row[i])) {
                row[i] = "0";
            }
        }
        return newRow;
    }
    
    public void countMines(String val) {
        if ("*".equals(val)) {
            //obtener la posicion a la izquierda y la posicion a la derecha y sumarle un 1
        }
    }
}
