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
import jmtetra.tetralogic.tetronomes.SquareShape;
import jmtetra.tetralogic.tetronomes.ZshapeLeft;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import jmtetra.tetralogic.tetronomes.ZshapeRight;

/**
 *
 * @author mikko
 */
public class GameboardTest {

    private Gameboard g;
    private Tetronome tetronome;

    public GameboardTest() {
        this.g = new Gameboard();
        this.tetronome = new Ishape(new Piece[4]);
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
        SquareShape sq = new SquareShape(new Piece[4]);
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
        ZshapeLeft s = new ZshapeLeft(new Piece[4]);
        g.addTetronome(s);

        assertTrue(checkPieces('Z', s));
    }

    @Test
    public void addingSshapeLeftWorks() {
        ZshapeRight s = new ZshapeRight(new Piece[4]);
        g.addTetronome(s);

        assertTrue(checkPieces('Z', s));
    }

    private boolean checkPieces(char c, Tetronome t) {
        for (Piece p : t.getPieces()) {
            if (g.getChar(p.getY(), p.getX()) != c) {
                return false;
            }

        }
        return true;
    }

    @Test
    public void checkIfOccupiedReturnsFalseWhenPieceTakenOnLeft() {
        g.setChar(0, 2, 'x');
        g.addTetronome(this.tetronome);
        assertFalse(g.checkIfOccupied(this.tetronome.moveLeftOrRight(-1)));
    }

    @Test
    public void checkIfOccupiedReturnsTrueWhenPieceNotTakenOnLeft() {
        g.addTetronome(this.tetronome);
        assertTrue(g.checkIfOccupied(this.tetronome.moveLeftOrRight(-1)));
    }

    @Test
    public void checkIfOccupiedReturnsFalseWhenPieceTakenOnRight() {
        g.setChar(0, 7, 'x');
        g.addTetronome(this.tetronome);
        assertFalse(g.checkIfOccupied(this.tetronome.moveLeftOrRight(1)));
    }

    @Test
    public void checkIfOccupiedReturnsTrueWhenPieceNotTakenOnRight() {
        g.addTetronome(tetronome);
        assertTrue(g.checkIfOccupied(this.tetronome.moveLeftOrRight(1)));
    }

    @Test
    public void checkIfOccupiedReturnsFalseWhenPieceTakenBelow() {
        g.setChar(1, 4, 'x');
        g.addTetronome(this.tetronome);
        assertFalse(g.checkIfOccupied(this.tetronome.moveDown()));
    }

    @Test
    public void checkIfOccupiedReturnsTrueWhenPieceNotTakenBelow() {
        g.addTetronome(tetronome);
        assertTrue(g.checkIfOccupied(this.tetronome.moveDown()));
    }

    @Test
    public void updateBoardMovesPiecesCorrectly() {
        g.addTetronome(tetronome);

        char[][] testBoard = new char[][]{
            {'-', '-', '-', 'I', 'I', 'I', 'I', '-', '-', '-'},
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

        g.updateBoard(this.tetronome.moveLeftOrRight(-1));

        testBoard = new char[][]{
            {'-', '-', 'I', 'I', 'I', 'I', '-', '-', '-', '-'},
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
    public void updateBoardDoesntGoOutOfBoundsOnLeft() {
        g.addTetronome(tetronome);

        for (int i = 0; i < 5; i++) {
            g.updateBoard(tetronome.moveLeftOrRight(-1));
        }

        char[][] testBoard = new char[][]{
            {'I', 'I', 'I', 'I', '-', '-', '-', '-', '-', '-'},
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
    public void updateBoardDoesntGoOutOfBoundMovingRIght() {
            g.addTetronome(tetronome);
        char[][] testBoard = new char[][]{
            {'-', '-', '-', '-', '-', '-', 'I', 'I', 'I', 'I'},
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

        for (int i = 0; i < 5; i++) {
            g.updateBoard(tetronome.moveLeftOrRight(1));

        }
        assertArrayEquals(g.getGameboard(), testBoard);

    }
    
     @Test
    public void updateBoardDoesntGoOutOfBoundMovingDown() {
            g.addTetronome(tetronome);
           
            for (int i = 0; i < 20; i++) {
                g.updateBoard(this.tetronome.moveDown());
             
         }
           
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
            {'-', '-', '-', 'I', 'I', 'I', 'I', '-', '-', '-'},};

       
        assertArrayEquals(g.getGameboard(), testBoard);

    }
    


}
