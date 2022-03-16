package javaProject1;

import java.awt.*;
import javax.swing.*;

public class QuestionPanel extends JFrame {
   
   String[] questions = {
      "1. 당신은 ?",
      "질문2"
   };
   
   String[] answers1 = {
      "E 성향",
      "답2_1"
   };

   String[] answers2 = {
         "I 성향",
         "답2_2"
   };

   class QAPanel extends JPanel{
      
      JLabel question;
      JToggleButton answer1;
      JToggleButton answer2;

      public QAPanel() {

         setLayout(new GridLayout(3, 1));
         
         question = new JLabel();
         answer1 = new JToggleButton();
         answer2 = new JToggleButton();
         
         ButtonGroup bg = new ButtonGroup();
         bg.add(answer1);
         bg.add(answer2);
         
         add(question);
         add(answer1);
         add(answer2);
      }
   }
   
   public QuestionPanel() {
      
      super("제목");
      setBounds(200, 100, 600, 800);
      setLayout(null);
      
      JPanel upPanel = new JPanel();
      upPanel.setBounds(0, 0, 600, 650);
      upPanel.setBackground(Color.pink);
      
      CardLayout QACard = new CardLayout();
      upPanel.setLayout(QACard);
      
      add(upPanel);
      
      for (int i = 0; i < questions.length; i++) {
         QAPanel qa = new QAPanel();
         qa.question.setText(questions[i]);
         qa.answer1.setText(answers1[i]);
         qa.answer2.setText(answers2[i]);
         upPanel.add(qa);
      }
      
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args) {
      new QuestionPanel();
      
   }

}