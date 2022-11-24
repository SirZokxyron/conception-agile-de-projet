package fr.icom.info.m1.balleauprisonnier_mvn.views;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import fr.icom.info.m1.balleauprisonnier_mvn.models.FieldModel;

public class FieldView extends Canvas {
	FieldModel field;
	
	public FieldView(FieldModel field) {
		super(field.getWidth(), field.getHeight());
		this.field = field;
		
		GraphicsContext gc = this.getGraphicsContext2D();
		
		 gc.setFill( Color.LIGHTGRAY);
         gc.fillRect(0, 0, field.getWidth(), field.getHeight());
	}

}
