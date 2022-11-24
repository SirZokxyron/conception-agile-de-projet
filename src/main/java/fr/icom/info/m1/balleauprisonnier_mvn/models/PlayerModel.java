package fr.icom.info.m1.balleauprisonnier_mvn.models;

import javafx.scene.image.Image;

public class PlayerModel
{
	private double h_pos;
	private final double v_pos;
	private double angle = 0;
	private double step;
	PlayerTeam team;
	BallModel ball = null;
	
	public PlayerModel(double h_pos, PlayerTeam team) {
		super();
		this.h_pos = h_pos;
		this.team = team;
		this.v_pos = (team == PlayerTeam.TOP) ? 25 : 700;
		this.angle = (team == PlayerTeam.TOP) ? 90 : -90;
		this.step = Math.random()*3+1;
	}
	
	public void hMove(int direction) {
		double delta = (direction > 0) ? step : -step;
		if (this.h_pos + delta < 5) this.h_pos = 5;
		else if (this.h_pos + delta > 595) this.h_pos = 595;
		else this.h_pos += delta;
	}
	
	public void turn(int direction) {
		int delta = (direction > 0) ? 1 : -1;
		if(this.team == PlayerTeam.TOP) {
			if (this.angle + delta < 0 ) this.angle = 0;
			else if (this.angle + delta > 180) this.angle = 180;
			else this.angle += delta;
		}else {
			if (this.angle + delta > 0 ) this.angle = 0;
			else if (this.angle + delta < -180) this.angle = -180;
			else this.angle += delta;
		}
		
		
		
		int sign = (int) Math.signum(this.angle + delta);
		if (Math.abs(this.angle + delta) < 180) this.angle = 180 * sign;
		else if (this.angle + delta < 0) this.angle = 0;
		else this.angle += delta;
	}
	
	public void shoot() {
		if (this.ball != null) {
			double[] direction = {Math.cos(this.angle), Math.sin(this.angle)};
			this.ball.launchFrom(this.h_pos, this.v_pos, 0.2, direction);
		}
	}

	public double getH_pos() {
		return h_pos;
	}

	public double getV_pos() {
		return v_pos;
	}

	public double getAngle() {
		return angle;
	}

	public PlayerTeam getTeam() {
		return team;
	}
	
	public String getImagePath() {
		return (this.getTeam() == PlayerTeam.TOP) ? "assets/PlayerRed.png" : "assets/PlayerBlue.png";
	}
}
