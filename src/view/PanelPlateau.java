package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Category;
import model.Game;
import model.Piece;

/**
 * This class show the board game
 * @author Thomas
 *
 */
class PanelPlateau extends JPanel
{
	
	private static final long serialVersionUID = 1L;



	public PanelPlateau()
	{
		
	}
	
	
	
	
	public void paintComponent(Graphics g)
	{
		//nettoie le contenu de la fenêtre pour éviter des traces des précédents paint
		//g.clearRect(0, 0, getWidth(), getHeight());
		
		//correspond aux coordonnées x de toutes les cases du plateau
		int x[][]= CoordonneePlateau.getPlateauX();
		
		//correspond aux coordonnées y de toutes les cases du plateau
		int y[][]= CoordonneePlateau.getPlateauY();
		
		//correpond aux coordonnées x des formes dans la case centrale
		int caseDepx[][]= CoordonneePlateau.getCaseDepX();
		
		//correpond aux coordonnées y des formes dans la case centrale
		int caseDepy[][]= CoordonneePlateau.getCaseDepY();
		
		//correspond aux coordonnées x des curseurs
		int curseurX[][]=CoordonneePlateau.getCurseurX();
		
		//correspond aux coordonnées y des curseurs
		int curseurY[][]=CoordonneePlateau.getCurseurY();
		
		//variable compteur utilisé pour la sélection des catégories des cases camemberts
		int j=1;
		
		//dessine la case centrale		
		//dessine les formes à l'intérieur de la case centrale
		for(int i=0;i<6;i++){
			for(Category c:Category.values()){
				if(i+1==c.getId()){
					g.setColor(c.getColor());
				}
			}    
			g.fillPolygon(caseDepx[i],caseDepy[i],3);
			g.setColor(Color.BLACK);
			g.drawPolygon(caseDepx[i],caseDepy[i],3);
		}
		
		//dessine les 72 cases du plateau
		for(int i=1;i<=72;i++){
			//dessine les cases camembert du plateau
			if(i==6 || i==18 || i==30 || i==42 || i==54 || i==66){
					for(Category c:Category.values()){
						if(j==c.getId()){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],5);
						}
					}    
				g.setColor(Color.BLACK);
				g.drawPolygon(x[i],y[i],5);
				j++;
				
			}
			else{	
				//couleur blanche pour les cases rejoués
				if(i==8 || i==11 || i==20 || i==23 || i==32 || i==35 || i==44 || i==47 || i==56 || i==59 || i==68 || i==71){
					g.setColor(Color.WHITE);
					g.fillPolygon(x[i],y[i],4);
				}
				//couleur case Geography
				if(i==13 || i==22 || i==28 || i==36 || i==41 || i==43 || i==51 || i==57 || i==62){
					for(Category c:Category.values()){
						if(c.getId()==1){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Entertainement
				if(i==2 || i==25 || i==34 || i==40 || i==48 || i==53 || i==55 || i==63 || i==69){
					for(Category c:Category.values()){
						if(c.getId()==2){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case History
				if(i==3 || i==9 || i==14 || i==37 || i==46 || i==52 || i==60 || i==65 || i==67){
					for(Category c:Category.values()){
						if(c.getId()==3){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Business
				if(i==5 || i==7 || i==15 || i==21 || i==26 || i==49 || i==58 || i==64 || i==72){
					for(Category c:Category.values()){
						if(c.getId()==4){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Science Nature
				if(i==4 || i==12 || i==17 || i==19 || i==27 || i==33 || i==38 || i==61 || i==70){
					for(Category c:Category.values()){
						if(c.getId()==5){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Sport Leisure
				if(i==1 || i==10 || i==16 || i==24 || i==29 || i==31 || i==39 || i==45 || i==50 ){
					for(Category c:Category.values()){
						if(c.getId()==6){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				g.setColor(Color.BLACK);
				g.drawPolygon(x[i],y[i],4);
				
				
				// id représente l'id de la case où se situe le joueur
				int id = Game.getInstance().getGameBoard().getIdSquareContainsPiece(Piece.getInstance());
				g.setColor(Color.GREEN);
				g.fillPolygon(curseurX[id], curseurY[id], 3);
				g.setColor(Color.BLACK);
				g.drawPolygon(curseurX[id],curseurY[id],3);
			}
		}
	}

}
