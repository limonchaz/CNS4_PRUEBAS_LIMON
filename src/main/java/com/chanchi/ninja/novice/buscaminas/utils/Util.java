package com.chanchi.ninja.novice.buscaminas.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static String[] readFile(InputStream is) throws IOException {
        String[] arr = null;
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();
            List<String> content = new ArrayList<String>();
            
            while(linea != null) {
                content.add(linea);
                linea = br.readLine();
            }
            br.close();
            
            if (content.size() > 0) {
                arr = new String[content.size()];
                arr = content.toArray(arr);
            }
        }
        return arr;
    }
    
    public static void printBoard(String[][] matrix) {
        for (String[] row: matrix) {
            for(String val : row) {
                System.out.print(val);
            }
            System.out.println("");
        }
    }
}
