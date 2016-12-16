package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;

import rmi.RemoteHelper;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.createFrame();
		try {
			System.out.println(UnicastRemoteObject.exportObject(new Remote(){},0));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void createFrame() {
		JFrame mainFrame = new JFrame("HotelServer");
		JButton button = new JButton("start");
		
		button.addActionListener(new ButtonActionListener());
		mainFrame.getContentPane().add(button);
		
		mainFrame.setVisible(true);
		mainFrame.setSize(300, 200);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class ButtonActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new RemoteHelper();
		}
		
	}
}
