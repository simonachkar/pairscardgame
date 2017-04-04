package pairscardgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartGame extends JFrame {

    JLabel lbl_menu = new JLabel(new ImageIcon("images/menu.jpg"));

    public StartGame() {

        lbl_menu.setBounds(0, 0, 400, 200);

        //--- title Label ---------------------------------------
        JLabel lblTitle = new JLabel("Pairs Card Game");
        lblTitle.setBackground(Color.WHITE);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Forte", Font.PLAIN, 35));
        lblTitle.setBounds(15, 30, 290, 50);
        add(lblTitle);

        //--- subtitle Label ---------------------------------------
        JLabel lblSub = new JLabel("By Simon Achkar");
        lblSub.setBackground(Color.WHITE);
        lblSub.setForeground(Color.WHITE);
        lblSub.setFont(new Font("Forte", Font.PLAIN, 16));
        lblSub.setBounds(25, 60, 290, 50);
        add(lblSub);

        //--- message Label ---------------------------------------
        JLabel lblMessage = new JLabel("Choose a difficulty:");
        lblMessage.setBackground(Color.WHITE);
        lblMessage.setForeground(Color.WHITE);
        lblMessage.setFont(new Font("Forte", Font.PLAIN, 26));
        lblMessage.setBounds(15, 130, 290, 30);
        add(lblMessage);

        //--- Easy Button -----------------------------------------
        JButton btn_easy = new JButton("Easy");
        btn_easy.setBackground(Color.WHITE);
        btn_easy.setForeground(new Color(1, 121, 181));
        btn_easy.setFont(new Font("Cooper Black", Font.PLAIN, 14));
        btn_easy.setBounds(15, 170, 70, 30);
        btn_easy.setToolTipText("Play with eigth cards");
        add(btn_easy);

        //--- Medium Button ---------------------------------------
        JButton btn_medium = new JButton("Medium");
        btn_medium.setBackground(Color.WHITE);
        btn_medium.setForeground(new Color(1, 121, 181));
        btn_medium.setFont(new Font("Cooper Black", Font.PLAIN, 14));
        btn_medium.setBounds(95, 170, 100, 30);
        btn_medium.setToolTipText("Play with twelve cards");
        add(btn_medium);

        //--- Hard Button -----------------------------------------
        JButton btn_hard = new JButton("Hard");
        btn_hard.setBackground(Color.WHITE);
        btn_hard.setForeground(new Color(1, 121, 181));
        btn_hard.setFont(new Font("Cooper Black", Font.PLAIN, 14));
        btn_hard.setBounds(205, 170, 70, 30);
        btn_hard.setToolTipText("Play with sixteen cards");
        add(btn_hard);

        //--- Adding the action listeners -------------------------
        btn_easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                easyFrame();
            }
        });

        btn_medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediumFrame();
            }
        });

        btn_hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hardFrame();
            }
        });

        add(lbl_menu);
    }

    public void easyFrame() {
        JFrame frame = new PairsCardGame(8);
        frame.pack();
        frame.setSize(700, 500);
        frame.setTitle("Pairs Card Game");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void mediumFrame() {
        JFrame frame = new PairsCardGame(12);
        frame.pack();
        frame.setSize(700, 500);
        frame.setTitle("Pairs Card Game");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void hardFrame() {
        JFrame frame = new PairsCardGame(16);
        frame.pack();
        frame.setSize(700, 500);
        frame.setTitle("Pairs Card Game");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        JFrame frame = new StartGame();

        frame.setTitle("Pairs Card Game");
        frame.setSize(500, 260);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
