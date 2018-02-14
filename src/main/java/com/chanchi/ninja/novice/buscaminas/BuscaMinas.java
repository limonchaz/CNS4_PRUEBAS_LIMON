package com.chanchi.ninja.novice.buscaminas;

import java.io.IOException;

import com.chanchi.ninja.novice.buscaminas.utils.Util;

public class BuscaMinas {

    public void startGame(String fileName) {
        String[] content = {};
        try {
            content = Util.readFile(fileName);
            processContent(content);
        } catch (IOException e) {
           System.out.println("Exception : " + e);
        }
    }
    
    private void processContent(String[] content) {
        int colNumber = 0;
        int rowNumber = 0;
        String[][] matrix = {};
        
        if (content != null) {
            String[] dimension = content[0].split("");
            rowNumber = Integer.parseInt(dimension[0]);
            colNumber = Integer.parseInt(dimension[2]);
            matrix = new String[rowNumber][colNumber];
        }
        
        for (int i = 0; i < content.length; i++) {
            String row = content[i];
            
            if (i > 0) {
                matrix[i-1] = buildNumericBoard(row);
                Util.printLine(matrix[i-1]);
            }
        }
        findMinesInCol(content, rowNumber);
    }
    
    private String[] buildNumericBoard(String line) {
        String[] values = line.split("");
        
        for(int i = 0; i < values.length; i++) {
            if (".".equals(values[i])) {
                values[i] = "0";
            }
        }
        return findMinesInRow(values);
    }
    
    private String[] findMinesInRow(String[] line) {
        for(int col = 0; col < line.length; col++) {
            if ("*".equals(line[col])) {
                if (col == 0) {
                    if (!"*".equals(line[col + 1])) {
                        Integer r = Integer.parseInt(line[col + 1]) + 1;
                        line[col + 1] = r.toString();
                    }
                } else if (col == (line.length - 1)) {
                    if (!"*".equals(line[col - 1])) {
                        Integer l = Integer.parseInt(line[col - 1]) + 1;
                        line[col - 1] = l.toString();
                    }
                } else {
                    if (!"*".equals(line[col + 1])) {
                        Integer r = Integer.parseInt(line[col + 1]) + 1;
                        line[col + 1] = r.toString();
                    }
                    if (!"*".equals(line[col - 1])) {
                        Integer l = Integer.parseInt(line[col - 1]) + 1;
                        line[col - 1] = l.toString();
                    }
                }
            }
        }
        return line;
    }
    
    private void findMinesInCol(String[] line, int maxRows) {
        for(int col = 0; col < line.length; col++) {
            if ("*".equals(line[col])) {
                
            }
        }
    }
}
