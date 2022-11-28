package fr.icom.info.m1.balleauprisonnier_mvn.views;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import fr.icom.info.m1.balleauprisonnier_mvn.models.FieldModel;

public class FieldView {
	FieldModel field;
	
	public FieldView(GraphicsContext gc, FieldModel field) {
		this.field = field;
		
		gc.setFill( Color.LIGHTGRAY);
	    gc.fillRect(0, 0, field.getWidth(), field.getHeight());
	    
	}

//	public ArrayList<String> getInput() {
//		return input;
//	}

}
