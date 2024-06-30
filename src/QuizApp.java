import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class QuizApp extends JFrame implements ActionListener {
    String questions[][]=new String[10][5];
    String answers[][]=new String[10][2];
    String userAns[][]=new String[10][1];
    JLabel questionNo,question;
    JRadioButton option1,option2,option3,option4;
    ButtonGroup group;
    JButton next,submit;
    public static int timer=15, ans=0, count=0,score=0,correctAnswers=0,incorrectAnswers=0;

    QuizApp(){
        setBounds(50, 0, 1200, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        questionNo=new JLabel();
        questionNo.setBounds(50, 50, 50, 30);
        questionNo.setFont(new Font("Sans-serif",Font.PLAIN,24));
        questionNo.setForeground(Color.BLUE);
        add(questionNo);

        question=new JLabel();
        question.setBounds(100, 50, 1400, 30);
        question.setFont(new Font("Sans-serif",Font.PLAIN,24));
        question.setForeground(Color.BLUE);
        add(question);

        questions[0][0]="Who invented Java Programming?";
        questions[0][1]="Guido van Rossum";
        questions[0][2]="James Gosling";
        questions[0][3]="Dennis Ritchie";
        questions[0][4]="Bjarne Stroustrup";

        questions[1][0]="Which statement is true about Java?";
        questions[1][1]="Java is a sequence-dependent programming language";
        questions[1][2]="Java is a code dependent programming language";
        questions[1][3]="Java is a platform-dependent programming language";
        questions[1][4]="Java is a platform-independent programming language";

        questions[2][0]="Which component is used to compile, debug and execute the java programs?";
        questions[2][1]="JRE";
        questions[2][2]="JIT";
        questions[2][3]="JDK";
        questions[2][4]="JVM";

        questions[3][0]="Which one of the following is not a Java feature?";
        questions[3][1]="Object-oriented";
        questions[3][2]="Use of pointers";
        questions[3][3]="Portable";
        questions[3][4]="Dynamic and Extensible";

        questions[4][0]="Which of these cannot be used for a variable name in Java?";
        questions[4][1]="identifier & keyword";
        questions[4][2]="identifier";
        questions[4][3]="keyword";
        questions[4][4]="none of the mentioned";

        questions[5][0]="What is the extension of java code files?";
        questions[5][1]=".js";
        questions[5][2]=".txt";
        questions[5][3]=".class";
        questions[5][4]=".java";

        questions[6][0]="Which environment variable is used to set the java path?";
        questions[6][1]="MAVEN_Path";
        questions[6][2]="JavaPATH";
        questions[6][3]="JAVA";
        questions[6][4]="JAVA_HOME";

        questions[7][0]="Which of the following is not an OOPS concept in Java?";
        questions[7][1]="Polymorphism";
        questions[7][2]="Inheritance";
        questions[7][3]="Compilation";
        questions[7][4]="Encapsulation";

        questions[8][0]="What is not the use of “this” keyword in Java?";
        questions[8][1]="Referring to the instance variable when a local variable has the same name";
        questions[8][2]="Passing itself to the method of the same class";
        questions[8][3]="Passing itself to another method";
        questions[8][4]="Calling another constructor in constructor chaining";

        questions[9][0]="Which of the following is a type of polymorphism in Java Programming?";
        questions[9][1]="Multiple polymorphism";
        questions[9][2]="Compile time polymorphism";
        questions[9][3]="Multilevel polymorphism";
        questions[9][4]="Execution time polymorphism";

        answers[0][1]="James Gosling";
        answers[1][1]="Java is a platform-independent programming language";
        answers[2][1]="JDK";
        answers[3][1]="Use of pointers";
        answers[4][1]="keyword";
        answers[5][1]=".java";
        answers[6][1]="JAVA_HOME";
        answers[7][1]="Compilation";
        answers[8][1]="Passing itself to the method of the same class";
        answers[9][1]="Compile time polymorphism";

        option1=new JRadioButton();
        option1.setBounds(120, 120, 500, 30);
        option1.setBackground(Color.WHITE);
        option1.setFont(new Font("Diolog",Font.PLAIN,20));
        add(option1);

        option2=new JRadioButton();
        option2.setBounds(120, 160, 500, 30);
        option2.setBackground(Color.WHITE);
        option2.setFont(new Font("Diolog",Font.PLAIN,20));
        add(option2);

        option3=new JRadioButton();
        option3.setBounds(120, 200, 500, 30);
        option3.setBackground(Color.WHITE);
        option3.setFont(new Font("Diolog",Font.PLAIN,20));
        add(option3);

        option4=new JRadioButton();
        option4.setBounds(120, 240, 500, 30);
        option4.setBackground(Color.WHITE);
        option4.setFont(new Font("Diolog",Font.PLAIN,20));
        add(option4);

        group=new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        next=new JButton("NEXT");
        next.setBounds(850, 200, 200, 40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit=new JButton("SUBMIT");
        submit.setBounds(850, 280, 200, 40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();
            ans=1;
            if(group.getSelection()==null){
                userAns[count][0]="";
            }
            else{
                userAns[count][0]=group.getSelection().getActionCommand();
            }
        

        if (count==8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        } 

        count++;
        start(count);
        }
        else if(ae.getSource()==submit){
            ans=1;
            if (group.getSelection()==null) {
                userAns[count][0]="";
            } 
            else {
                userAns[count][0]=group.getSelection().getActionCommand();
            }

            int i;
            for (i=0;i<userAns.length;i++) {
                if (userAns[i][0].equals(answers[i][1])) {
                    score+=10;
                    correctAnswers++;
                } 
                else {
                    incorrectAnswers++;
                }                
            }
            setVisible(false);
            new Score(score,correctAnswers,incorrectAnswers);
        }
    }

    public void paint(Graphics g){
        super.paint(g);

        String time="Time Left: "+timer+" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,25));

        if (timer>0) {
            g.drawString(time, 800, 150);
        } 
        else {
            g.drawString("Ooops, Timed out...!", 800, 150);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        if (ans==1) {
            ans=0;
            timer=15;
        } 
        else if (timer<0) {
            timer=15;
            if (count==8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count==9) {
                if (group.getSelection()==null) {
                    userAns[count][0]=" ";
                } 
                else {
                    userAns[count][0]=group.getSelection().getActionCommand();
                }

                int i;
                for (i=0; i<userAns.length;i++) {
                    if (userAns[i][0].equals(answers[i][1])) {
                        score+=10;
                    }
                }
                setVisible(false);
                new Score(score,correctAnswers,incorrectAnswers);
            } 
            else {
                if (group.getSelection()==null) {
                    userAns[count][0]=" ";
                }
                else {
                    userAns[count][0]=group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count){
        questionNo.setText(""+(count+1)+"");
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);

        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);

        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
    
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
