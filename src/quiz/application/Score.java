package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 800, 550);
        getContentPane().setBackground(new Color(253, 236, 206));
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/scor.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 50, 500, 500);
        add(image);
        
        JLabel heading = new JLabel("Thank you " + name + " for playing!");
        heading.setBounds(50, 10, 700, 50);
        heading.setFont(new Font("Georgia", Font.PLAIN, 26));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is: " + score);
        lblscore.setBounds(520, 200, 300, 30);
        lblscore.setFont(new Font("Georgia", Font.PLAIN, 26));
        add(lblscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(520, 270, 150, 70);
        submit.setFont(new Font("Georgia", Font.BOLD, 20));
        submit.setBackground(new Color(126, 80, 158));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
