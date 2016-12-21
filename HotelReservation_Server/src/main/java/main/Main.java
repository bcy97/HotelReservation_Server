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
	
	private boolean label = true;
	
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
		
		if(label == true){
			button.setOnAction(new EventHandler<ActionEvent>(){
				
				public void handle(ActionEvent event){
					AutoChangeState.setRoomAutoJob();
					new RemoteHelper();
					label = false;
				}
				
			});
		}
		grid.getStylesheets().add("/CSS/button.css");
		Scene scene = new Scene(grid, 240, 220);
		stage.setScene(scene);
		stage.show();
		
	}
}
