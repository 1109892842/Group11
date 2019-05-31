package group11;

import java.awt.Graphics;
import java.awt.Image;

public class MyThread extends Thread{
	public static Graphics g ;	
	Enemy enemy1= new Enemy();
	Enemy_boss_lv boss=new Enemy_boss_lv();
	public MyThread (){
		this.start();
	}
    public void run(){
		while(true){
			boss.star_boss();          //Boss_lv
		}
		/*
		while(true){
			enemy1.Starting();
			enemy1.enemy_star();
			
			Bullet.e_x1+=150;
			Bullet.e_x+=80;
			if(Enemy.a==3){
				Bullet.e_x1=0;
			}
			if(Enemy.a1==15){
				Bullet.e_x=0;
			}
		}
		*/
    }   
}
