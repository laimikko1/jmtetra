package jmtetra.tetralogic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.Squareshape;
import jmtetra.tetralogic.tetronomes.SshapeLeft;
import jmtetra.tetralogic.tetronomes.SshapeRight;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;

/**
 *
 * @author mikko
 */
public class GameboardTest {

    private Gameboard g;

    public GameboardTest() {
        this.g = new Gameboard();
    }

    @Test
    public void gameBoardIsCorrect() {
        char[][] testBoard = new char[][]{
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};
        assertArrayEquals(g.getGameboard(), testBoard);
    }

    @Test
    public void sizeGettersWorkRight() {
        assertEquals(g.getHeight(), 16);
        assertEquals(g.getWidth(), 10);
    }

    @Test
    public void getCharReturnsCorrect() {
        assertEquals(g.getChar(0, 0), '-');
    }

    @Test
    public void setCharWorks() {
        g.setChar(0, 0, 'T');
        assertEquals('T', g.getChar(0, 0));
    }

    @Test
    public void currentTetronomeIsNullAtBeginning() {
        assertNull(g.getCurTetro());
    }

    @Test
    public void currentTetronomeWorksWhenSigned() {
        Ishape i = new Ishape(new Piece[4]);
        g.addTetronome(i);
        assertEquals(g.getCurTetro(), i);
    }

    @Test
    public void addingSquareWorks() {
        Squareshape sq = new Squareshape(new Piece[4]);
        g.addTetronome(sq);

        assertTrue(checkPieces('0', sq));

    }

    @Test
    public void addingTWorks() {
        Tshape t = new Tshape(new Piece[4]);
        g.addTetronome(t);

        assertTrue(checkPieces('T', t));

    }

    @Test
    public void addingLRightWorks() {
        LshapeRight l = new LshapeRight(new Piece[4]);
        g.addTetronome(l);

        assertTrue(checkPieces('L', l));
    }

    @Test
    public void addingLLeftWorks() {
        LshapeLeft l = new LshapeLeft(new Piece[4]);
        g.addTetronome(l);

        assertTrue(checkPieces('L', l));
    }

    @Test
    public void addingIworks() {
        Ishape i = new Ishape(new Piece[4]);
        g.addTetronome(i);

        assertTrue(checkPieces('I', i));
    }

    @Test
    public void addingShapeRightWorks() {
        SshapeRight s = new SshapeRight(new Piece[4]);
        g.addTetronome(s);

        assertTrue(checkPieces('S', s));
    }

    @Test
    public void addingSshapeLeftWorks() {
        SshapeLeft s = new SshapeLeft(new Piece[4]);
        g.addTetronome(s);

        assertTrue(checkPieces('S', s));
    }

    private boolean checkPieces(char c, Tetronome t) {
        for (Piece p : t.getPieces()) {
            if (g.getChar(p.getY(), p.getX()) != c) {
                return false;
            }

        }
        return true;
    }
}