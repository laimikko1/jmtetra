/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import jmtetra.gameloop.Gameloop;

/**
 *
 * @author mikko
 */
public class GameInterface implements Runnable {

    private DrawedGameboard gameboard;
    private Gameloop gameclass;
    private JFrame frame;

    public GameInterface(Gameloop gameclass) {
        this.gameclass = gameclass;
        this.gameboard = new DrawedGameboard(this.gameclass);
        this.gameclass.setDrawboard(gameboard);
    }

    @Override
    public void run() {
        frame = new JFrame("Tetris");
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container contentPane) {
        contentPane.add(this.gameboard);
        frame.addKeyListener(new InputListener(this.gameclass.getGameboard()));
    }

    public DrawedGameboard getDrawedGameboard() {
        return gameboard;
    }

    public Gameloop getGame() {
        return this.gameclass;
    }

}