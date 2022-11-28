package fr.icom.info.m1.balleauprisonnier_mvn.views;

import fr.icom.info.m1.balleauprisonnier_mvn.models.BallModel;
import javafx.scene.image.ImageView;

public class BallView extends ImageView {

	BallModel ball;

	public BallView(BallModel ball) {
		super("assets/smallball.png");
		this.ball = ball;

		this.setX(ball.getH_pos());
		this.setY(ball.getV_pos());
	}

	public void display() {
		this.setX(ball.getH_pos());
		this.setY(ball.getV_pos());
	}

	

}
