package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
 
    JButton rules, back;
    JTextField tfname;
    
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/intro.jpeg"));
        Image img = i1.getImage().getScaledInstance(screenSize.width/2, screenSize.height, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(img);
        JLabel image = new JLabel(imageIcon);
        image.setBounds(0, 0, screenSize.width/2, screenSize.height-50);
        add(image);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(screenSize.width/2, 0, screenSize.width/2, screenSize.height);
        panel.setBackground(new Color(253, 253, 199));
        add(panel);
        
        JLabel heading = new JLabel("<html>Welcome to ...<br>the Java Quiz!</html>");
        heading.setBounds(10, 100, 500, 100);
        heading.setFont(new Font("Georgia", Font.BOLD, 50));
        heading.setForeground(new Color(70, 5, 117));
        panel.add(heading);
        
        JLabel name = new JLabel("Enter your name:");
        name.setBounds(10, 350, 300, 50);
        name.setFont(new Font("Georgia", Font.BOLD, 30));
        name.setForeground(new Color(70, 5, 117));
        panel.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(10, 400, 300, 35);
        tfname.setFont(new Font("Georgia", Font.PLAIN, 18));
        panel.add(tfname);
        
        rules = new JButton("Start Quiz");
        rules.setBounds(10, 700, 160, 60);
        rules.setBackground(new Color(126, 80, 158));
        rules.setForeground(Color.WHITE);
        rules.setFont(new Font("Georgia", Font.BOLD, 16));
        rules.addActionListener(this);
        panel.add(rules);
        
        back = new JButton("Quit");
        back.setBounds(250, 700, 160, 60);
        back.setBackground(new Color(163, 130, 186));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Georgia", Font.BOLD, 16));
        back.addActionListener(this);
        panel.add(back);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
