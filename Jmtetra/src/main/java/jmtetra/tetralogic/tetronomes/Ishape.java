package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
/**
 * Ishape on yksi Tetrispelin palamuodoista.
 * 
 * @author mikko
 */
public class Ishape extends Tetronome {
    
    private Piece[] pieces;
   /**
    * Konstruktorissa luodaan uusi pala, sille annetaan parametrina Piece[] taulukko, johon
    * sen palat laitetaan. Myös yliluokan, eli Tetronomen konstruktoria hyödynnetään asetettaessa tyyppi ja luotaessa yllämainittu
    * taulukko.
    * @param pieces jokainen pala saa Piece[] taulukon, jossa tarvittava tila koordinaateille
    */ 
    public Ishape(Piece[] pieces) {
        super(pieces);
        super.setType(Type.Ishape);
        this.pieces = pieces;
        createTetronome();
        createRotations();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public final void createTetronome() {
        int yCord = 0;
        int xCord = 3;
        
        for (int i = 0; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'I');
            xCord++;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    
    @Override
    final Piece[] createRotations() {
        
        if (super.getRotation() == 1) {
            return updateRightCords();
        }
        if (super.getRotation() == 2) {
            return updateDownCords();
        }
        if (super.getRotation() == 3) {
            return updateLeftCords();
        }
        
        return updateUpCords();
        
    }
    
    private Piece[] updateDownCords() {
        Piece[] down = new Piece[4];
        down[0] = this.generatePiece(-1, 0);
        down[1] = this.pieces[1];
        down[2] = this.generatePiece(1, 0);
        down[3] = this.generatePiece(2, 0);
        
        return down;
    }
    
    private Piece[] updateLeftCords() {
        Piece[] left = new Piece[4];
        left[0] = this.generatePiece(0, 1);
        left[1] = this.pieces[1];
        left[2] = this.generatePiece(0, -1);
        left[3] = this.generatePiece(0, -2);
        return left;
    }
    
    private Piece[] updateRightCords() {
        Piece[] right = new Piece[4];
        right[0] = this.generatePiece(0, -1);
        right[1] = this.pieces[1];
        right[2] = this.generatePiece(0, 1);
        right[3] = this.generatePiece(0, 2);
        return right;
    }
    
    private Piece[] updateUpCords() {
        Piece[] up = new Piece[4];
        up[0] = this.generatePiece(1, 0);
        up[1] = this.pieces[1];
        up[2] = this.generatePiece(-1, 0);
        up[3] = this.generatePiece(-2, 0);
        return up;
    }
    
}
