/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic;

import tetralogic.Tetronomes.Tetronome;

/**
 *
 * @author laimikko
 */
public class Gameboard {

    private int height;
    private int width;
    private char[][] gameboard;

    public Gameboard() {
        this.width = 10;
        this.height = 16;

        this.gameboard = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameboard[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();

        }
    }

    public void addTetronome(Tetronome t) {
        for (Piece p : t.getPieces()) {
            gameboard[p.getX()][p.getY()] = p.getMark();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getGameboard() {
        return gameboard;
    }
    
    public char getChar(int x, int y) {
        return this.gameboard[x][y];
    }
    
    

}
