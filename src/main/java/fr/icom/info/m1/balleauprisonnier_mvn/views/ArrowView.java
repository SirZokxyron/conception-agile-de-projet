package fr.icom.info.m1.balleauprisonnier_mvn.views;

import fr.icom.info.m1.balleauprisonnier_mvn.models.PlayerModel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class ArrowView {
	PlayerModel player;
	Image directionArrow;
	ImageView PlayerDirectionArrow;
	GraphicsContext gc;

	public ArrowView(GraphicsContext gc, PlayerModel player) {
		this.gc = gc;
		this.player = player;

		directionArrow = new Image("assets/PlayerArrowRight.png");

		PlayerDirectionArrow = new ImageView();
        PlayerDirectionArrow.setImage(directionArrow);
        PlayerDirectionArrow.setFitWidth(10);
        PlayerDirectionArrow.setPreserveRatio(true);
        PlayerDirectionArrow.setSmooth(true);
        PlayerDirectionArrow.setCache(true);
	}

	public void display() {
		gc.save();
		rotate(gc, this.player.getAngle(), this.player.getH_pos()-38 + directionArrow.getWidth()/2, this.player.getV_pos() + directionArrow.getHeight()/2);
		gc.drawImage(directionArrow, this.player.getH_pos(), this.player.getV_pos());
		gc.restore(); // back to original state (before rotation)
	}

	private void rotate(GraphicsContext gc, double angle, double px, double py) {
		Rotate r = new Rotate(angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}
}
