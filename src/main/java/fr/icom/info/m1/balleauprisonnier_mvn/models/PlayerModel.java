package fr.icom.info.m1.balleauprisonnier_mvn.models;

public class PlayerModel
{
	double h_pos;
	final double v_pos;
	double angle = 0;
	double step;
	PlayerTeam team;
	BallModel ball = null;
	
	public PlayerModel(double h_pos, PlayerTeam team) {
		super();
		this.h_pos = h_pos;
		this.team = team;
		this.v_pos = (team == PlayerTeam.TOP) ? 25 : 575;
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
		if (this.angle + delta < -90) this.angle = -90;
		else if (this.angle + delta > 90) this.angle = 90;
		else this.angle += delta;
	}
	
	public void shoot() {
		if (this.ball != null) {
			// TODO
		}
	}
	
}
