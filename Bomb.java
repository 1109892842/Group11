package alloyContra;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Bomb {
	private Background b=Background.background;
	public static int zadan_x=Leadone.move_x+110,zadan_y=Leadone.move_y+475;
	public static int move_zadan_x=0,move_zadan_y=0,bang_zadan_x=0,bang_zadan_y=0,type_bang=0,type_zadan=0;
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image[] zadan=new Image[6];{                       //Õ¨µ¯µÄÍ¼Æ¬ 
		for(int i=0;i<6;i++){
			zadan[i]=kit.getImage("img\\zadan"+i+".png");
		}
	}
	private Image[][] bang=new Image[1][6];{               //Õ¨µ¯±¬Õ¨µÄÍ¼Æ¬
		for(int i=0;i<1;i++){
			for(int j=0;j<6;j++){
				bang[i][j]=kit.getImage("img\\bang"+i+j+".png");
			}
		}
	}
	//ÈÓÕ¨µ¯
	public void throw_zadan(Graphics g){
		zadan_x=Leadone.move_x+110 ;zadan_y=Leadone.move_y+475;
		g.drawImage(zadan[type_zadan], zadan_x+move_zadan_x, zadan_y+move_zadan_y, b);
	}
	//Õ¨µ¯±¬Õ¨
	public void bang_zadan(Graphics g){
		g.drawImage(bang[0][type_bang], bang_zadan_x, bang_zadan_y-80, b);
	}
}
