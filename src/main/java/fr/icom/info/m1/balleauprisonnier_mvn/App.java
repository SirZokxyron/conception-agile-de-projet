package fr.icom.info.m1.balleauprisonnier_mvn;

import fr.icom.info.m1.balleauprisonnier_mvn.views.PlayerView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Dodgeball");
		
		Group root = new Group();
		Scene scene = new Scene(root);
		
		Game game = new Game();
		root.getChildren().add(game);
		
		for (PlayerView playerView : game.getPlayerViews()) {
			root.getChildren().add(playerView);
		}
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
	        //System.out.println( "Hello World!" );
	    	Application.launch(args);
	}
}
