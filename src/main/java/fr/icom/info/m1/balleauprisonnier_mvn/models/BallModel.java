package fr.icom.info.m1.balleauprisonnier_mvn.models;

public class BallModel {
	private double h_pos;		// Position horizontale
	private double v_pos;		// Position verticale
	private double speed;		// Vitesse de la balle
	private double direction[] = {0, 0};	// Direction de la balle
	private boolean moving = false;			// Est-ce que la balle est en mouvement
	
	private static BallModel instance;

	private BallModel() {
		super();
	}
	
	// Implémentation du pattern singleton
	public static BallModel getInstance() {
		if(BallModel.instance == null)
			BallModel.instance = new BallModel();
		return BallModel.instance;
	}
	
	// Lance la balle depuis une position
	public void launchFrom(double h_pos, double v_pos, double speed, double direction[]) {
		this.h_pos = h_pos;
		this.v_pos = v_pos;
		this.speed = speed;
		this.direction = direction;
		this.moving = true;
	}
	
	// Avance la balle de un pas
	public void step() {
		this.h_pos += this.direction[0] * this.speed;
		this.v_pos += this.direction[1] * this.speed;
	}

	public void setH_pos(double h_pos) {
		this.h_pos = h_pos;
	}
	
	public void setV_pos(double v_pos) {
		this.v_pos = v_pos;
	}

	public double getH_pos() {
		return h_pos;
	}

	public double getV_pos() {
		return v_pos;
	}
}
