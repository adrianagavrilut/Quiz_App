package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(new Color(42, 3, 70));
        setLayout(null);
        
        JLabel heading = new JLabel("<html>Welcome " + name + " !<br>Before starting, read the rules:</html>");
        heading.setBounds(50, 20, 700, 70);
        heading.setFont(new Font("Calibri", Font.BOLD, 28));
        heading.setForeground(new Color(253, 253, 199));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 110, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rules.setForeground(Color.WHITE);
        rules.setText(
            "<html>"+ 
                "1. Answer like a programmer, not a poet - keep it short and sweet!" + "<br><br>" +
                "2. No smiling at your neighbor - it's a quiz, not a comedy show!" + "<br><br>" +
                "3. All questions are mandatory, just like taxes!" + "<br><br>" +
                "4. Tears are allowed, but please use a tissue." + "<br><br>" +
                "5. Be wise, not otherwise - answer wisely!" + "<br><br>" +
                "6. You may win only if you studied the TAP course!" + "<br><br>" +
                "7. This quiz isn't for the faint-hearted, so buckle up and enjoy the ride!" + "<br><br>" +
            "<html>"        
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(250, 500, 120, 50);
        back.setBackground(new Color(253, 253, 199));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 120, 50);
        start.setBackground(new Color(253, 253, 199));
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}
