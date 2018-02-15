package com.chanchi.ninja.novice.buscaminas.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static String[] readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        List<String> content = new ArrayList<String>();

        while(linea != null) {
            content.add(linea);
            linea = br.readLine();
        }
        br.close();
        
        String[] arr = new String[content.size()];
        arr = content.toArray(arr);
        
        return arr;
    }
    
    public static void printLine(String[][] matrix) {
        for (String[] row: matrix) {
            for(String val : row) {
                System.out.print(val);
            }
            System.out.println("");
        }
    }
}
