package fr.icom.info.m1.balleauprisonnier_mvn.views;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import fr.icom.info.m1.balleauprisonnier_mvn.models.FieldModel;

public class FieldView {
	FieldModel field;
	GraphicsContext gc;

	public FieldView(GraphicsContext gc, FieldModel field) {
		this.field = field;
		this.gc = gc;

		gc.setFill( Color.LIGHTGRAY);
	    gc.fillRect(0, 0, field.getWidth(), field.getHeight());
	}

	public void display() {
		this.gc.setFill( Color.LIGHTGRAY);
	    this.gc.fillRect(0, 0, field.getWidth(), field.getHeight());
	}

//	public ArrayList<String> getInput() {
//		return input;
//	}

}
