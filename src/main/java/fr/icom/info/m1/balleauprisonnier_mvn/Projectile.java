package fr.icom.info.m1.balleauprisonnier_mvn;

public class Projectile {
	private Player joueur;
	private double speed = 1;
	private double x;
	private double y;
	
	private double delta_x;
	private double delta_y;
	
	
	public Projectile(Player joueur) {
		this.joueur = joueur;
		this.x = joueur.x;
		this.y = joueur.y;
		this.delta_x = Math.sin(joueur.angle);
		this.delta_y = -Math.cos(joueur.angle);
		
		System.out.println(delta_x+" "+delta_y+" "+x+" "+y);
	}
	
	
	
}
