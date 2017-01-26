/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic.Tetronomes;

import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.Tshape;

public class Tshape extends Tetronome {

    private Piece[] pieces;
    private Type type;

    public Tshape(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        this.type = Tshape;
        createTetronome();
    }

    

    @Override
    final void createTetronome() {
        int xCord = 4;
        int yCord = 0;

        Piece p = new Piece(xCord, yCord, 'T');
        xCord--;
        yCord++;
        this.pieces[0] = p;

        for (int i = 1; i < 4; i++) {
            p = new Piece(xCord, yCord, 'T');
            this.pieces[i] = p;
            xCord++;
        }
    }

}
