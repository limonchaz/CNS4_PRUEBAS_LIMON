package com.chanchi.ninja.novice.buscaminas;

import java.io.IOException;

import com.chanchi.ninja.novice.buscaminas.utils.Util;

public class BuscaMinas {

    public String[][] startGame(String fileName) {
        String[] content = {};
        String[][] resolve = null;
        try {
            content = Util.readFile(fileName);
            if (content != null) {
                resolve = processContent(content);
            } else {
                resolve = new String[1][1];
                resolve[0][0] = "El contenido del archivo es vacio";
            }
        } catch (IOException e) {
            resolve = new String[1][1];
            resolve[0][0] = "El archivo no se encontro";
        }
        return resolve;
    }
    
    private String[][] processContent(String[] content) {
        int colNumber = 0;
        int rowNumber = 0;
        String[][] matrix = {};
        
        String[] dimension = content[0].split("");
        rowNumber = Integer.parseInt(dimension[0]);
        colNumber = Integer.parseInt(dimension[2]);
        
        if ((content.length - 1) == rowNumber && content[1].split("").length == colNumber) {
            matrix = new String[rowNumber][colNumber];
            
            /* Dado que la primer linea es la de la dimension la descartamos del tablero */
            for (int i = 1; i < content.length; i++) {
                String row = content[i];
                
                matrix[i-1] = buildNumericBoard(row);
            }
            matrix = findMines(matrix, rowNumber, colNumber);
        } else {
            matrix = new String[1][1];
            matrix[0][0] = "El tamaño del tablero no coincide con las dimensiones especificadas en el archivo";
        }
        return matrix;
    }
    
    private String[] buildNumericBoard(String line) {
        String[] values = line.split("");
        
        for(int i = 0; i < values.length; i++) {
            if (".".equals(values[i])) {
                values[i] = "0";
            }
        }
        return values;
    }
    
    private String[][] findMines(String[][] board, int maxRows, int maxCols){
        for (int rowNum = 0; rowNum < maxRows; rowNum++) {
            for (int colNum = 0; colNum < maxCols; colNum++) {
                if ("0".equals(board[rowNum][colNum])) {
                    searchRightMine(board, rowNum, colNum, maxCols);
                    searchLeftMine(board, rowNum, colNum);
                    searchMinesDown(board, rowNum, colNum, maxRows, maxCols);
                    searchMinesUp(board, rowNum, colNum, maxCols);
                }
            }
        }
        return board;
    }
    
    private void searchRightMine(String[][] board, int row, int col, int colMax) {
        if ((col + 1) < colMax) {
            addMine(board, row, col, row, col + 1);
        }
    }
    
    private void searchLeftMine(String[][] board, int row, int col) {
        if ((col - 1) > -1) {
            addMine(board, row, col, row, col - 1);
        }
    }
    
    private void searchMinesDown(String[][] board, int row, int col, int rowMax, int colMax) {
        if ((row + 1) < rowMax) {
            addMine(board, row, col, row + 1, col);
            if ((col + 1) < colMax) {
                addMine(board, row, col, row + 1, col + 1);
            }
            if ((col - 1) > -1) {
                addMine(board, row, col, row + 1, col - 1);
            }
        }
    }
    
    private void searchMinesUp(String[][] board, int row, int col, int colMax) {
        if ((row - 1) > -1) {
            addMine(board, row, col, row - 1, col);
            if ((col + 1) < colMax) {
                addMine(board, row, col, row - 1, col + 1);
            }
            if ((col - 1) > -1) {
                addMine(board, row, col, row - 1, col - 1);
            }
        }
    }
    
    private void addMine(String[][] board, int row, int col, int sideRow, int sideCol) {
        if ("*".equals(board[sideRow][sideCol])) {
            board[row][col] = String.valueOf(Integer.parseInt(board[row][col]) + 1);
        }
    }
}
