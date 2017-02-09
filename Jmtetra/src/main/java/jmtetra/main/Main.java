
package jmtetra.main;

import javax.swing.SwingUtilities;
import jmtetra.gameloop.Gameloop;
import jmtetra.gui.GameInterface;
import jmtetra.tetralogic.Gameboard;

public class Main {
    
    public static void main(String[] args) {

        Gameloop gc = new Gameloop();
        GameInterface g = new GameInterface(gc);
        
        SwingUtilities.invokeLater(g);
        
        gc.start();
//        
        
    
    }
    
    public static void printBoard(Gameboard gameboard) {
        
        for (int i = 0; i < gameboard.getHeight(); i++) {
            for (int j = 0; j < gameboard.getWidth(); j++) {
                System.out.print(gameboard.getGameboard()[i][j]);
            }
            System.out.println();
            
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
}
