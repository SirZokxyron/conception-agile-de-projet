package fr.icom.info.m1.balleauprisonnier_mvn.models;

// Classe qui représente les non joueurs
public class ComputerModel extends PlayerModel {

	public ComputerModel(double h_pos, PlayerTeam team) {
		super(h_pos, team);
	}

	public void strategy() {
		// Ici serait où on implémente la stratégie de l'ordinateur.
	}
}
