package javaProject1;

import java.awt.event.*;
import javax.swing.*;

public class ToggleButtonTest extends JFrame implements KeyListener{

	JToggleButton tb1;
	JToggleButton tb2;
	
	public ToggleButtonTest() {

		super("Test4");
		
		setBounds(200, 100, 600, 800);
		setLayout(null);
		
		tb1 = new JToggleButton();
		tb1.setBounds(250, 200, 100, 100);
		add(tb1);
		tb1.addKeyListener(this);
		
		tb2 = new JToggleButton();
		tb2.setBounds(250, 400, 100, 100);
		add(tb2);
		tb2.addKeyListener(this);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(tb1);
		bg.add(tb2);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new ToggleButtonTest();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_1) {
			tb1.setSelected(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_2) {
			tb2.setSelected(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}