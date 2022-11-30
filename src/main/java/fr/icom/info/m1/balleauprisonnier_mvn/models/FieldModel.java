package fr.icom.info.m1.balleauprisonnier_mvn.models;

public class FieldModel {
	int height; // Hauteur du terrain
	int width; // Largeur du terrain
	
	public FieldModel(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
}
