package fr.icom.info.m1.balleauprisonnier_mvn.views;

import fr.icom.info.m1.balleauprisonnier_mvn.Sprite;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerModel;
import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerTeam;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class PlayerView extends Sprite {

	PlayerModel player;
	
	public PlayerView(PlayerModel player) {
		super(new Image(player.getImagePath()), 0,0, Duration.seconds(.2), player.getTeam());
		// TODO Auto-generated constructor stub
		
		this.player = player;
		
		this.setX(player.getH_pos());
		this.setY(player.getV_pos());
	}
	
	public void display() {
		this.setX(player.getH_pos());
		this.setY(player.getV_pos());
	}
}
