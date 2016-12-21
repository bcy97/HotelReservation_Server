package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import rmi.RemoteHelper;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		
		stage.setResizable(false);
		stage.setTitle("步客酒店预订系统");
		
		GridPane grid = new GridPane();
		Image image = new Image("图标.png", 250, 200, false, true);
		ImageView imageView = new ImageView(image);
		grid.add(imageView, 0, 0);
		
		Button button = new Button("START");
		button.setId("button-style");
		button.setPrefSize(250, 30);
		button.setFocusTraversable(false);
		grid.add(button, 0, 1);
		button.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				AutoChangeState.setRoomAutoJob();
				new RemoteHelper();
			}
			
		});
		grid.getStylesheets().add("/CSS/button.css");
		Scene scene = new Scene(grid, 240, 220);
		stage.setScene(scene);
		stage.show();
		
	}
	
//	public void createFrame() {
//		JFrame mainFrame = new JFrame("HotelServer");
//		JButton button = new JButton("start");
//		
//		button.addActionListener(new ButtonActionListener());
//		button.setSize(150, 20);
//		mainFrame.getContentPane().add(button);
//		
//		mainFrame.setVisible(true);
//		mainFrame.setSize(300, 200);
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//	
//	
//	private class ButtonActionListener implements ActionListener{
//
//		public void actionPerformed(ActionEvent e) {
//			AutoChangeState.setRoomAutoJob();
//			new RemoteHelper();
//		}
//		
//	}
}
