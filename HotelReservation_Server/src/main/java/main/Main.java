package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import rmi.RemoteHelper;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.createFrame();
	}
	
	public void createFrame() {
		JFrame mainFrame = new JFrame("HotelServer");
		JButton button = new JButton("start");
		
		button.addActionListener(new ButtonActionListener());
		button.setSize(150, 20);
		mainFrame.getContentPane().add(button);
		
		mainFrame.setVisible(true);
		mainFrame.setSize(300, 200);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private class ButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			AutoChangeState.setRoomAutoJob();
			new RemoteHelper();
		}
		
	}
}
