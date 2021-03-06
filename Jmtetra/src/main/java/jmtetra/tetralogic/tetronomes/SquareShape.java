package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;

public class SquareShape extends Tetronome {

    public Piece[] pieces;

    /**
     * Konstruktorissa luodaan uusi pala, sille annetaan parametrina Piece[]
     * taulukko, johon sen palat laitetaan. Myös yliluokan, eli Tetronomen
     * konstruktoria hyödynnetään asetettaessa tyyppi ja luotaessa yllämainittu
     * taulukko.
     *
     * @param pieces jokainen pala saa Piece[] taulukon, jossa tarvittava tila
     * koordinaateille
     */
    public SquareShape(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        super.setType(Type.Squareshape);
        createTetronome();
    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    public final void createTetronome() {
        int yCord = 0;
        int xCord = 4;
        for (int i = 0; i < 4; i++) {
            Piece p = new Piece(yCord, xCord, 'O');
            this.pieces[i] = p;

            xCord++;
            if (i == 1) {
                yCord++;
                xCord = 4;
            }
        }

    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    Piece[] createRotations() {
        return this.pieces;
    }

}
