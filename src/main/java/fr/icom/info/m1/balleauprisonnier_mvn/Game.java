package fr.icom.info.m1.balleauprisonnier_mvn;

import java.util.ArrayList;

import fr.icom.info.m1.balleauprisonnier_mvn.models.FieldModel;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerModel;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerTeam;
import fr.icom.info.m1.balleauprisonnier_mvn.views.FieldView;
import fr.icom.info.m1.balleauprisonnier_mvn.views.PlayerView;

public class Game {

	// ArrayList<AbstractView> viewList;
	// AbstractPlayer
	FieldModel fieldModel;
	FieldView fieldView;
	ArrayList<PlayerModel> playersTOP = new ArrayList<>();
	ArrayList<PlayerModel> playersBOT = new ArrayList<>();
	ArrayList<PlayerView> playerViews = new ArrayList<>();
	// BallModel
	// ListPlayerController
	// BallController

	public Game() {
		fieldModel = new FieldModel(800, 800);
		fieldView = new FieldView(fieldModel);
		
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
	}

	public FieldView getFieldView() {
		return fieldView;
	}

	public ArrayList<PlayerView> getPlayerViews() {
		return playerViews;
	}
}
