package pairscardgame;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.*;

/**
 * @author Simon
 */
public class PairsCardGame extends JFrame {

    //public instances ---------------------------------------------------------
    static Timer timerForPlacing, timerForMoving;
    int standardY = 10,
            standardX = 50,
            correctCards = 0;
    boolean firstClick = true;
    Card selectedCard = null;
    JLabel lblBg = new JLabel(new ImageIcon("images/background.jpg"));

    //shuffle ------------------------------------------------------------------
    void shuffle(Card[] arr) {
        Collections.shuffle(Arrays.asList(arr));
    }

    //placeCards() method and its wrapper function (placeCardsAux) -------------
    void placeCards(int num, Card[] cards) {
        for (int i = 1; i <= num; i++) {
            placeCardsAux(cards[i - 1], standardY += 100, standardX);
            if (i % 4 == 0) {
                standardX += 100;
                standardY = 10;
            }
        }
    }

    void placeCardsAux(Card card, int x, int y) {

        ActionListener timerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean boolX = false, boolY = false;

                /* When boolX and boolY = true, it means that the card is at the 
                 desired place (which is calculated in placeCard() method and 
                 returned to this wrapper method by x and y). */
                if (card.getX() < x) {
                    card.setLocation(card.getX() + 1, card.getY());
                } else if (card.getX() > x) {
                    card.setLocation(card.getX() - 1, card.getY());
                } else {
                    boolX = true;
                }
                if (card.getY() < y) {
                    card.setLocation(card.getX(), card.getY() + 1);
                } else if (card.getY() > y) {
                    card.setLocation(card.getX(), card.getY() - 1);
                } else {
                    boolY = true;
                }

                if (boolX || boolY) {
                    return;
                }
            }
        };
        timerForPlacing = new Timer(0, null);
        timerForPlacing.addActionListener(timerAction);
        timerForPlacing.start();
    }

    PairsCardGame(int num) {
        correctCards = 0;
        lblBg.setBounds(0, 0, 800, 500);


        /*------------------------------------------------------------------
         Layout managers are used to automatically determine the layout of 
         components in a container. If you want to put components at specific 
         coordinate locations, then you should not use a layout manager at all.
         -------------------------------------------------------------------*/
        this.setLayout(null);

        //--- Set lblText properties: ---------
        JLabel lblText = new JLabel("Click on the deck to begin the game...");
        lblText.setForeground(Color.WHITE);
        lblText.setFont(new Font("Freestyle Script", Font.PLAIN, 40));
        lblText.setBounds(200, 50, 500, 40);
        add(lblText);
        //-------------------------------------

        Card[] cards = new Card[num];

        //---Create the cards
        for (int i = 1; i <= num; i++) {
            cards[i - 1] = new Card(new ImageIcon("images/" + i + ".png"), i);
            cards[i - 1].setBounds(30 - i / 2, i + 320, 100, 90);
            add(cards[i - 1]);
        }

        shuffle(cards);

        for (int i = 1; i <= num; i++) {
            final int selectedCardNum = i - 1;

            cards[i - 1].addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (firstClick) {
                        placeCards(num, cards);
                        lblText.show(false);
                        firstClick = false;

                    } else {

                        cards[selectedCardNum].flip();
                        if (selectedCard == null) {
                            selectedCard = cards[selectedCardNum];

                        } else if (selectedCard == cards[selectedCardNum]) {
                            JOptionPane.showMessageDialog(rootPane, "Select another card");
                            selectedCard = null;
                        } else if ((selectedCard.id - cards[selectedCardNum].id == 1
                                && Math.max(cards[selectedCardNum].id, selectedCard.id) % 2 == 0)
                                || (selectedCard.id - cards[selectedCardNum].id == -1
                                && Math.min(cards[selectedCardNum].id, selectedCard.id) % 2 != 0)) {
                            correctCards += 2;

                            selectedCard.removeMouseListener(selectedCard.getMouseListeners()[0]);
                            cards[selectedCardNum].removeMouseListener(cards[selectedCardNum].getMouseListeners()[0]);

                            selectedCard.removeMouseListener(this);
                            cards[selectedCardNum].removeMouseListener(this);
                            selectedCard = null;

                            if (num == correctCards) {
                                JFrame WinFrame = new JFrame();
                                WinFrame.pack();
                                WinFrame.setSize(400, 200);
                                WinFrame.setTitle("WINNER !!!");
                                WinFrame.setLocationRelativeTo(null);
                                WinFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                JLabel lblwin = new JLabel(new ImageIcon("images/youwin.gif"));
                                WinFrame.setLayout(new BorderLayout());
                                JButton b1 = new JButton("OK");
                                b1.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        WinFrame.hide();
                                    }
                                });
                                WinFrame.add(lblwin, BorderLayout.CENTER);
                                WinFrame.add(b1, BorderLayout.SOUTH);
                                WinFrame.setVisible(true);
                            }
                        } else {
                            Timer timetoflip = new Timer(800, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent es) {
                                    cards[selectedCardNum].flip();
                                    selectedCard.flip();
                                    selectedCard = null;

                                }
                            });
                            timetoflip.setRepeats(false);
                            timetoflip.start();
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            });

        }

        add(lblBg);
    }
}
