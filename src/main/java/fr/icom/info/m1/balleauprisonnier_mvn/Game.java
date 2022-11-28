package fr.icom.info.m1.balleauprisonnier_mvn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.icom.info.m1.balleauprisonnier_mvn.controllers.PlayerController;
import fr.icom.info.m1.balleauprisonnier_mvn.models.Actions;
import fr.icom.info.m1.balleauprisonnier_mvn.models.FieldModel;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerModel;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerTeam;
import fr.icom.info.m1.balleauprisonnier_mvn.views.FieldView;
import fr.icom.info.m1.balleauprisonnier_mvn.views.PlayerView;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Game extends Canvas {

	// ArrayList<AbstractView> viewList;
	// AbstractPlayer
	FieldModel fieldModel;
	FieldView fieldView;
	ArrayList<PlayerModel> playersTOP = new ArrayList<>();
	ArrayList<PlayerModel> playersBOT = new ArrayList<>();
	ArrayList<PlayerView> playerViews = new ArrayList<>();
	ArrayList<String> inputs = new ArrayList<String>(2);
	// BallModel
	// ListPlayerController
	// BallController

	public Game() {
		super(800, 800);
		
		this.setFocusTraversable(true);
		GraphicsContext gc = this.getGraphicsContext2D();
		
		fieldModel = new FieldModel(800, 800);
		fieldView = new FieldView(gc, fieldModel);
		
		PlayerModel playerTOP;
		PlayerModel playerBOT;
		for (int i = 0; i < 3; i++) {
			playerTOP = new PlayerModel((i+1)*800/4, PlayerTeam.TOP);
			playerBOT = new PlayerModel((i+1)*800/4, PlayerTeam.BOT);
			playersTOP.add(playerTOP);
			playersBOT.add(playerBOT);
			playerViews.add(new PlayerView(playerTOP));
			playerViews.add(new PlayerView(playerBOT));
			
		}
		
		Map<String, Actions> inputP1 = new HashMap<String, Actions>()
		{
		    {
		        put("Z", Actions.TURN_LEFT);
		        put("Q", Actions.MOVE_LEFT);
		        put("S", Actions.TURN_RIGHT);
		        put("D", Actions.MOVE_RIGHT);
		        put("SPACE", Actions.SHOOT);
		    }
		};
		
		PlayerController P1 = new PlayerController(playersBOT.get(0), inputP1);
		
		this.setOnKeyPressed(
    		new EventHandler<KeyEvent>()
    	    {
    	        public void handle(KeyEvent e)
    	        {
    	            String code = e.getCode().toString();
    	            // only add once... prevent duplicates
    	            P1.processInput(code);
    	        }
    	    }
		);
	    
//	    this.setOnKeyReleased(
//    	    new EventHandler<KeyEvent>()
//    	    {
//    	        public void handle(KeyEvent e)
//    	        {
//    	            String code = e.getCode().toString();
//    	            System.out.println(code);
////    	            input.remove( code );
//    	        }
//    	    }
//	    );
		
		new AnimationTimer() 
	    {
	        public void handle(long currentNanoTime)
	        {
	            // Deplacement et affichage des joueurs
	        	for (int i = 0; i < playerViews.size(); i++) 
	        	{
	        		playerViews.get(i).display();
	    	    }
	    	}
	     }.start(); // On lance la boucle de rafraichissement 
		
	}
	
	public FieldView getFieldView() {
		return fieldView;
	}

	public ArrayList<PlayerView> getPlayerViews() {
		return playerViews;
	}
}
