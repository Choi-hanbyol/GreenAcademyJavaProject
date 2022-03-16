package javaProject1;

import java.awt.Color;

import javax.swing.*;

public class ProgressBarTest extends JFrame {

	public ProgressBarTest() {

		super("Test3");
		
		setBounds(200, 100, 600, 800);
		setLayout(null);
		
		JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 20);
		bar.setBounds(100, 100, 400, 50);
		bar.setBackground(Color.pink);
		bar.setForeground(Color.red);
		
		add(bar);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		for (int i = 0; i <=20; i++) {
			bar.setValue(i);
			bar.setString(i+"/20");
			bar.setStringPainted(true);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ProgressBarTest();
	}

}