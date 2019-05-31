package alloyContra;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.*;

import java.awt.*;
import java.io.File;
public class Enemy_boss_lv extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Background back= Background.background;
	public static int boss_x=1700,boss_y=400;
	
	public static int boss_position_x;//画出敌人的坐标x
	public static int boss_position_y;//画出敌人的坐标y
	
	public static int boss_is_fired_cuounts=0;//新增boss被击中次数
	
	public static int boss_type=0,boss_fires=19;
	public static boolean boss_life=true;
	public static int be_fired_counts=0;
	private Image boss_lv [][]=new Image[2][23] ;
	Toolkit kit=Toolkit.getDefaultToolkit(); 
	public Enemy_boss_lv() {
		
		for(int i=0;i<2;i++){
			for(int j=0;j<21;j++)
				boss_lv[i][j]=kit.getImage(".//img//Enemy//boss_lv//打"+i+j+".png");
				
		}
		
	}
	public void paint_boss(Graphics g ){
		boss_position_x=boss_x+Background.x;
		boss_position_y=boss_y;
		g.drawImage(boss_lv[boss_type][boss_fires],boss_x+Background.x,boss_y,back);
		
	}
	public void star_boss(){
		if(true){
			try{
				Thread.sleep(120);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(boss_life&&Leadone.move_x+200>=boss_x+Background.x&&Leadone.move_x+200<=boss_x+Background.x+180){
			boss_type=0;//右方攻击
			Enemy_boss_lv.boss_fires++;
			if(boss_fires>=7&&boss_fires<=13){
				Ldie.is_boss_lv=true;
				if(boss_fires==9){
					try {
						   File f=new File(".\\music\\boss_lv.wav");
						   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
						   p.prefetch();
						   p.start();
					} catch (Exception e){
						e.printStackTrace();
					}
				}
			}
			
			if(Enemy_boss_lv.boss_fires>20)
				Enemy_boss_lv.boss_fires=1;
			//检测是否打死敌人
			if(((Keys.is_space&&boss_position_x+230>=Bullet.bullet_position_x&&boss_position_x<=Bullet.bullet_position_x&&Bullet.bullet_position_y>=boss_y&&Bullet.bullet_position_y<=boss_y+100) ||
					   (Keys.is_zadan&&boss_position_x>=Bomb.bang_zadan_x-230&&boss_position_x<=Bomb.bang_zadan_x+330&&Bomb.bang_zadan_y>=boss_y-40&&Bomb.bang_zadan_y<=boss_y+250) ||
					  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=boss_position_x-50&&Leadone.leadone_position_x<=boss_position_x+250)&&
						(Leadone.leadone_position_y>=boss_y-50&&Leadone.leadone_position_y<=boss_y+250)))){
				
				boss_is_fired_cuounts++;
				if(boss_is_fired_cuounts>=90){
					boss_fires=0;
					boss_life=false;
					boss_is_fired_cuounts=0;
				}
				
			}
		}
		else if(boss_life&&Leadone.move_x+105>=boss_x+Background.x&&Leadone.move_x+200<=boss_x+Background.x+380){
			boss_type=1;//左方攻击
			Enemy_boss_lv.boss_fires++;
			if(boss_fires>=7&&boss_fires<=13){
				Ldie.is_boss_lv=true;
				if(boss_fires==9){
					try {
						   File f=new File(".\\music\\boss_lv.wav");
						   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
						   p.prefetch();
						   p.start();
					} catch (Exception e){
						e.printStackTrace();
					}
				}
			}
			
			if(Enemy_boss_lv.boss_fires>20)
				Enemy_boss_lv.boss_fires=1;
			if(((Keys.is_space&&boss_position_x>=Bullet.bullet_position_x-230&&boss_position_x<=Bullet.bullet_position_x+30&&Bullet.bullet_position_y>=boss_y&&Bullet.bullet_position_y<=boss_y+100) ||
					   (Keys.is_zadan&&boss_position_x>=Bomb.bang_zadan_x-280&&boss_position_x<=Bomb.bang_zadan_x+230&&Bomb.bang_zadan_y>=boss_y-40&&Bomb.bang_zadan_y<=boss_y+240) ||
					  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=boss_position_x-50&&Leadone.leadone_position_x<=boss_position_x+250)&&
						(Leadone.leadone_position_y>=boss_y-50&&Leadone.leadone_position_y<=boss_y+250)))){
				boss_is_fired_cuounts++;
				if(boss_is_fired_cuounts>=50){
					boss_fires=0;
					boss_life=false;
					boss_is_fired_cuounts=0;
				}
			}
		
		}
		else if (boss_life){
			boss_fires++;
			if(boss_fires>20){
				boss_fires=19;
			}
			
		}
		if(boss_life==false&&boss_position_x<=-200){
			boss_type=0;
			boss_x+=1100;
			boss_life=true;
		}
	}
	
}
