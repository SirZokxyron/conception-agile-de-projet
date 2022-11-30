package fr.icom.info.m1.balleauprisonnier_mvn.controllers;

import java.util.Map;

import fr.icom.info.m1.balleauprisonnier_mvn.models.Actions;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerModel;

public class PlayerController
{
	PlayerModel player;				// Le joueur dont c'est le controlleur
	Map<String, Actions> keybinds;	// Contient un dictionnaire avec des paires ("touche de clavier", "action")
	
	public PlayerController(PlayerModel player, Map<String, Actions> keybinds) {
		super();
		this.player = player;
		this.keybinds = keybinds;
	}
	
	// Fonction qui prend un input et execute l'action appropriée
	public void processInput(String input) {
		if (!this.keybinds.containsKey(input)) {
			return;
		}
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
