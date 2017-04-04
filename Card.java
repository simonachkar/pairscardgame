package pairscardgame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Simon
 */
public class Card extends JLabel {

    //Variables ---------------------------------
    ImageIcon front,
            back = new ImageIcon("images/back.png");
    int id;
    boolean isFront;

    //constructor ---------------------------------------
    Card(ImageIcon image, int num) {
        front = image;
        id = num;
        setIcon(back);
        isFront = false;
    }

    //flip() --------------------------------------------
    public void flip() {
        if (!isFront) {
            setIcon(front);
            isFront = true;
        } else {
            setIcon(back);
            isFront = false;
        }
    }
}
