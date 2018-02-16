package com.chanchi.ninja.novice.buscaminas;

import com.chanchi.ninja.novice.buscaminas.utils.Util;

/**
 *
 */
public class App {
    public static void main( String[] args ) {
       BuscaMinas bm = new BuscaMinas();
       String[][] boardResolve = bm.startGame(args[0]);
       Util.printBoard(boardResolve);
    }
}
