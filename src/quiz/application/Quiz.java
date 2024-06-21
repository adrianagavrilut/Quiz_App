package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banner.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, screenSize.width, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        
        initializeQuestions();
        
        initializeComponents();
        
        start(count);

        setVisible(true);
    }
    
    private void initializeComponents() {
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
    }
    
    private void initializeQuestions() {
        questions[0][0] = "Which keyword is used to declare a variable that cannot be reassigned?";
        questions[0][1] = "void";
        questions[0][2] = "static";
        questions[0][3] = "final";
        questions[0][4] = "const";

        questions[1][0] = "What is the primary purpose of the 'public' access modifier?";
        questions[1][1] = "To allow access only within the same class";
        questions[1][2] = "To allow access from any other class";
        questions[1][3] = "To restrict access within the same package";
        questions[1][4] = "To hide the class implementation details";

        questions[2][0] = "Which Java keyword is used to create a subclass?";
        questions[2][1] = "implements";
        questions[2][2] = "super";
        questions[2][3] = "abstract";
        questions[2][4] = "extends";

        questions[3][0] = "What does the 'new' keyword do in Java?";
        questions[3][1] = "Defines a new method";
        questions[3][2] = "Instantiates an abstract class";
        questions[3][3] = "Allocates memory and creates an object";
        questions[3][4] = "Returns the length of an array";

        questions[4][0] = "Which loop is suitable when the number of iterations is known?";
        questions[4][1] = "for";
        questions[4][2] = "while";
        questions[4][3] = "do-while";
        questions[4][4] = "foreach";

        questions[5][0] = "Which keyword is used for accessing the features of a package?";
        questions[5][1] = "extends";
        questions[5][2] = "package";
        questions[5][3] = "import";
        questions[5][4] = "export";

        questions[6][0] = "An interface with no fields or methods is known as?";
        questions[6][1] = "Runnable Interface";
        questions[6][2] = "Marker Interface";
        questions[6][3] = "Abstract Interface";
        questions[6][4] = "CharSequence Interface";

        questions[7][0] = "What is the result of 'true && false' in Java?";
        questions[7][1] = "truefalse";
        questions[7][2] = "true";
        questions[7][3] = "error";
        questions[7][4] = "false";

        questions[8][0] = "Which statement is used to exit from a loop in Java?";
        questions[8][1] = "break";
        questions[8][2] = "continue";
        questions[8][3] = "exit";
        questions[8][4] = "return";

        questions[9][0] = "Which method is called automatically when an object is created?";
        questions[9][1] = "initializer";
        questions[9][2] = "destructor";
        questions[9][3] = "constructor";
        questions[9][4] = "main";

        answers[0][1] = "final";
        answers[1][1] = "To allow access from any other class";
        answers[2][1] = "extends";
        answers[3][1] = "Allocates memory and creates an object";
        answers[4][1] = "for";
        answers[5][1] = "import";
        answers[6][1] = "Marker Interface";
        answers[7][1] = "false";
        answers[8][1] = "break";
        answers[9][1] = "constructor";
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            
            enableOptions(true);
            
            ans_given = 1;
            
            saveUserAnswer();
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            
            disableOptions();
            
            lifeline.setEnabled(false);
            
        } else if (ae.getSource() == submit) {
            
            saveUserAnswer();

            calculateScore();
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        drawTimer(g);
        
        updateTimer();       
    }
    
    private void enableOptions(boolean enabled) {
        opt1.setEnabled(enabled);
        opt2.setEnabled(enabled);
        opt3.setEnabled(enabled);
        opt4.setEnabled(enabled);
    }
    
     private void saveUserAnswer() {
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
    }
     
    private void disableOptions() {
        if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
            opt2.setEnabled(false);
            opt3.setEnabled(false);
        } else {
            opt1.setEnabled(false);
            opt4.setEnabled(false);
        }
    }
    
    private void calculateScore() {
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            } else {
                score += 0;
            }
        }
        setVisible(false);
        new Score(name, score);
    }
    
    private void drawTimer(Graphics g) {
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
    }
    
    private void updateTimer() {
        timer--;
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            
            enableOptions(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                
                saveUserAnswer();
                calculateScore();
                
            } else { // next button
                
                saveUserAnswer();
                count++; // 0 // 1
                start(count);
            }
        }
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
