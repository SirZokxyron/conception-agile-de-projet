package fr.icom.info.m1.balleauprisonnier_mvn.views;

import fr.icom.info.m1.balleauprisonnier_mvn.Sprite;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerModel;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class PlayerView extends Sprite {

	PlayerModel player;
	
	public PlayerView(PlayerModel player) {
		super(new Image(player.getImagePath()), 0,0, Duration.seconds(.2), player.getTeam());
		
		this.player = player;
		
		this.setX(player.getH_pos());
		this.setY(player.getV_pos());
	}
	
	public void display() {
		this.setX(player.getH_pos());
		this.setY(player.getV_pos());

		if (this.player.hasBall()) {
			this.player.getBall().setH_pos(this.player.getH_pos() + 38);
			this.player.getBall().setV_pos(this.player.getV_pos() + 38);
		}
	}
}
