package com.chanchi.ninja.novice.buscaminas;

import java.io.IOException;

import com.chanchi.ninja.novice.buscaminas.utils.Util;

public class BuscaMinas {

    public void startGame(String fileName) {
        String[] content = {};
        try {
            content = Util.readFile(fileName);
            if (content != null) {
                processContent(content);
            } else {
                System.out.println("El contenido es nulo");
            }
        } catch (IOException e) {
           System.out.println("Exception : " + e);
        }
    }
    
    private void processContent(String[] content) {
        int colNumber = 0;
        int rowNumber = 0;
        String[][] matrix = {};
        
        String[] dimension = content[0].split("");
        rowNumber = Integer.parseInt(dimension[0]);
        colNumber = Integer.parseInt(dimension[2]);
        matrix = new String[rowNumber][colNumber];
        
        /* Dado que la primer linea es la de la dimension la descartamos del tablero */
        for (int i = 1; i < content.length; i++) {
            String row = content[i];
            
            matrix[i-1] = buildNumericBoard(row);
//            Util.printLine(matrix[i-1]);
        }
        findMinesInCol(matrix, rowNumber, colNumber);
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
    
    private void findMinesInCol(String[][] board, int maxRows, int maxCols) {
        for (int rowNum = 0; rowNum < maxRows; rowNum++) {
            String[] row = board[rowNum];
            for (int colNum = 0; colNum < maxCols; colNum++) {
                String value = row[colNum];
                if ("*".equals(value)) {
                    if (rowNum == 0 && colNum == 0) {
                        if (!"*".equals(board[1][colNum])) {
                            Integer r = Integer.parseInt(board[1][colNum]) + 1;
                            board[1][colNum] = r.toString();
                        }
                        if (!"*".equals(board[1][colNum + 1])) {
                            Integer r = Integer.parseInt(board[1][colNum + 1]) + 1;
                            board[1][colNum + 1] = r.toString();
                        }
                    } else if (rowNum == (maxRows - 1) && colNum == 0) {
                        if (!"*".equals(board[maxRows - 2][colNum])) {
                            Integer r = Integer.parseInt(board[maxRows - 2][colNum]) + 1;
                            board[maxRows - 2][colNum] = r.toString();
                        }
                        if (!"*".equals(board[maxRows - 2][colNum + 1])) {
                            Integer r = Integer.parseInt(board[maxRows - 2][colNum + 1]) + 1;
                            board[maxRows - 2][colNum + 1] = r.toString();
                        }
                    } else if (rowNum == 0 && colNum == (maxCols - 1)) {
                        if (!"*".equals(board[1][maxCols - 2])) {
                            Integer r = Integer.parseInt(board[1][maxCols - 2]) + 1;
                            board[1][maxCols - 2] = r.toString();
                        }
                        if (!"*".equals(board[1][maxCols - 1])) {
                            Integer r = Integer.parseInt(board[1][maxCols - 1]) + 1;
                            board[1][maxCols - 1] = r.toString();
                        }
                    } else if (rowNum == (maxRows - 1) && colNum == (maxCols - 1)) {
                        if (!"*".equals(board[maxRows - 2][maxCols - 2])) {
                            Integer r = Integer.parseInt(board[maxRows - 2][maxCols - 2]) + 1;
                            board[maxRows - 2][maxCols - 2] = r.toString();
                        }
                        if (!"*".equals(board[maxRows - 2][maxCols - 1])) {
                            Integer r = Integer.parseInt(board[maxRows - 2][maxCols - 1]) + 1;
                            board[maxRows - 2][maxCols - 1] = r.toString();
                        }  
                    } else if (rowNum == 0) {
                        if (!"*".equals(board[1][colNum])) {
                            Integer r = Integer.parseInt(board[1][colNum]) + 1;
                            board[1][colNum] = r.toString();
                        }
                        if (!"*".equals(board[1][colNum + 1])) {
                            Integer r = Integer.parseInt(board[1][colNum + 1]) + 1;
                            board[1][colNum + 1] = r.toString();
                        }
                        if (!"*".equals(board[1][colNum - 1])) {
                            Integer r = Integer.parseInt(board[1][colNum - 1]) + 1;
                            board[1][colNum - 1] = r.toString();
                        }
                    } else if (rowNum == (maxRows - 1)) {
                        if (!"*".equals(board[maxRows - 2][colNum])) {
                            Integer r = Integer.parseInt(board[maxRows - 2][colNum]) + 1;
                            board[maxRows - 2][colNum] = r.toString();
                        }
                        if (!"*".equals(board[maxRows - 2][colNum + 1])) {
                            Integer r = Integer.parseInt(board[maxRows - 2][colNum + 1]) + 1;
                            board[maxRows - 2][colNum + 1] = r.toString();
                        }
                        if (!"*".equals(board[maxRows - 2][colNum - 1])) {
                            Integer r = Integer.parseInt(board[maxRows - 2][colNum - 1]) + 1;
                            board[maxRows - 2][colNum - 1] = r.toString();
                        }
                    } else {
                        if (!"*".equals(board[rowNum - 1][colNum])) {
                            Integer r = Integer.parseInt(board[rowNum - 1][colNum]) + 1;
                            board[rowNum - 1][colNum] = r.toString();
                        }
                        if (!"*".equals(board[rowNum - 1][colNum + 1])) {
                            Integer r = Integer.parseInt(board[rowNum - 1][colNum + 1]) + 1;
                            board[rowNum - 1][colNum + 1] = r.toString();
                        }
                        if (!"*".equals(board[rowNum - 1][colNum - 1])) {
                            Integer r = Integer.parseInt(board[rowNum - 1][colNum - 1]) + 1;
                            board[rowNum - 1][colNum - 1] = r.toString();
                        }
                        if (!"*".equals(board[rowNum + 1][colNum])) {
                            Integer r = Integer.parseInt(board[rowNum + 1][colNum]) + 1;
                            board[rowNum + 1][colNum] = r.toString();
                        }
                        if (!"*".equals(board[rowNum + 1][colNum + 1])) {
                            Integer r = Integer.parseInt(board[rowNum + 1][colNum + 1]) + 1;
                            board[rowNum + 1][colNum + 1] = r.toString();
                        }
                        if (!"*".equals(board[rowNum + 1][colNum - 1])) {
                            Integer r = Integer.parseInt(board[rowNum + 1][colNum - 1]) + 1;
                            board[rowNum + 1][colNum - 1] = r.toString();
                        }
                    }
                }
            }
        }
        Util.printLine(board);
    }
}
