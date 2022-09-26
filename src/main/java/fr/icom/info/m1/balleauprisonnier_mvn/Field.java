package fr.icom.info.m1.balleauprisonnier_mvn;


import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * Classe gerant le terrain de jeu.
 * 
 */
public class Field extends Canvas {
	
	/** Joueurs */
	Player [] joueurs = new Player[2];
	Player p;
	
	ArrayList<Player> equipe1 = new ArrayList<Player>();
	ArrayList<Player> equipe2 = new ArrayList<Player>();
	
	/** Couleurs possibles */
	String[] colorMap = new String[] {"blue", "green", "orange", "purple", "yellow"};
	/** Tableau traçant les evenements */
    ArrayList<String> input = new ArrayList<String>(2);
    

    final GraphicsContext gc;
    final int width;
    final int height;
    
    /**
     * Canvas dans lequel on va dessiner le jeu.
     * 
     * @param scene Scene principale du jeu a laquelle on va ajouter notre Canvas
     * @param w largeur du canvas
     * @param h hauteur du canvas
     */
	public Field(Scene scene, int w, int h) 
	{
		super(w, h); 
		width = w;
		height = h;
		
		/** permet de capturer le focus et donc les evenements clavier et souris */
		this.setFocusTraversable(true);
		
        gc = this.getGraphicsContext2D();
        
        /** On initialise le terrain de jeu */
    	joueurs[0] = new Player(gc, colorMap[0], w/4, h-50, "bottom");
    	joueurs[0].display();

    	joueurs[1] = new Player(gc, colorMap[1], w/4, 20, "top");
    	joueurs[1].display();
    	
    	equipe1.add(0, new Player(gc, colorMap[2], (w/4), h-50, "bottom"));
		equipe1.get(0).display();
		
		equipe2.add(0, new Player(gc, colorMap[2], (w/4), 20, "top"));
		equipe2.get(0).display();
    	
    	for(int i = 1; i < 3 ; i++) {
    		equipe1.add(i, new Computer(gc, colorMap[i+2], (w/4)+(150*i), h-50, "bottom"));
    		equipe1.get(i).display();
    		
    		equipe2.add(i, new Computer(gc, colorMap[i+2], (w/4)+(150*i), 20, "top"));
    		equipe2.get(i).display();
        }
    	
    	System.out.println(equipe1.size());

	    /** 
	     * Event Listener du clavier 
	     * quand une touche est pressee on la rajoute a la liste d'input
	     *   
	     */
	    this.setOnKeyPressed(
	    		new EventHandler<KeyEvent>()
	    	    {
	    	        public void handle(KeyEvent e)
	    	        {
	    	            String code = e.getCode().toString();
	    	            // only add once... prevent duplicates
	    	            if ( !input.contains(code) )
	    	                input.add( code );
	    	        }
	    	    });

	    /** 
	     * Event Listener du clavier 
	     * quand une touche est relachee on l'enleve de la liste d'input
	     *   
	     */
	    this.setOnKeyReleased(
	    	    new EventHandler<KeyEvent>()
	    	    {
	    	        public void handle(KeyEvent e)
	    	        {
	    	            String code = e.getCode().toString();
	    	            input.remove( code );
	    	        }
	    	    });
	    
	    /** 
	     * 
	     * Boucle principale du jeu
	     * 
	     * handle() est appelee a chaque rafraichissement de frame
	     * soit environ 60 fois par seconde.
	     * 
	     */
	    new AnimationTimer() 
	    {
	        public void handle(long currentNanoTime)
	        {	 
	            // On nettoie le canvas a chaque frame
	            gc.setFill( Color.LIGHTGRAY);
	            gc.fillRect(0, 0, width, height);
	        	

	            
	            if (input.contains("LEFT"))
        			equipe1.get(0).moveLeft();
        		if (input.contains("RIGHT")) 
        			equipe1.get(0).moveRight();	        			
        		if (input.contains("UP"))
        			equipe1.get(0).turnLeft();
        		if (input.contains("DOWN")) 
        			equipe1.get(0).turnRight();	        			
        		
        		if (input.contains("SPACE"))
        			equipe1.get(0).shoot();
        		
        		// Touche de controle pour clavier AZERTY
        		if (input.contains("Q"))
        			equipe2.get(0).moveLeft();
        		if (input.contains("D")) 
        			equipe2.get(0).moveRight();	        			
        		if (input.contains("Z"))
        			equipe2.get(0).turnLeft();
        		if (input.contains("S"))
        			equipe2.get(0).turnRight();
        		
        		if (input.contains("A"))
        			equipe2.get(0).shoot();
        		
        		equipe1.get(0).display();
        		equipe2.get(0).display();
        		
	            // Deplacement et affichage des joueurs
	        	for (int i = 1; i < equipe1.size(); i++) 
	        	{
	        		equipe1.get(i).display();
	        		equipe2.get(i).display();
	    	    }
	    	}
	     }.start(); // On lance la boucle de rafraichissement 
	     
	}

	public Player[] getJoueurs() {
		return joueurs;
	}
	public ArrayList<Player> getEquipe(int id) {
		if(id == 1)
			return equipe1;
		else
			return equipe2;
	}
}
