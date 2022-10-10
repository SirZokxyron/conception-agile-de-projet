package fr.icom.info.m1.balleauprisonnier_mvn.controllers;

import java.util.Map;

import fr.icom.info.m1.balleauprisonnier_mvn.models.Actions;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerModel;

public class PlayerController
{
	PlayerModel player;
	Map<String, Actions> keybinds;
	
	public PlayerController(PlayerModel player, Map<String, Actions> keybinds) {
		super();
		this.player = player;
		this.keybinds = keybinds;
	}
	
	void processInput(String input) {
		switch(this.keybinds.get(input)) {
		case MOVE_LEFT:
			this.player.hMove(-1);
			break;
		case MOVE_RIGHT:
			this.player.hMove(1);
			break;
		case TURN_LEFT:
			this.player.turn(-1);
			break;
		case TURN_RIGHT:
			this.player.turn(1);
			break;
		case SHOOT:
			this.player.shoot();
			break;
		default:
			break;
		}
	}
	
}
