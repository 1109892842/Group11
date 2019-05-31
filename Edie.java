package group11;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.media.Manager;
import javax.media.Player;
import javax.swing.JFrame;

public class Edie extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Background b= Background.background;
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image[] spark=new Image[3];{  //射击产生的火花
		for(int i=0;i<3;i++){
			spark[i]=kit.getImage("img\\spark"+i+".png");
		}
	}
	
	//敌人被击中判断
	public void E_is_die(){
		//检查是否近距离
		if((Leadone.leadone_position_x>=Enemy.enemy1_position_x-30&&Leadone.leadone_position_x<=Enemy.enemy1_position_x+50)&&
				(Leadone.leadone_position_y>=Enemy.enemy1_position_y-20&&Leadone.leadone_position_y<=Enemy.enemy1_position_y+50)){
			Leadone.is_knife=true;
		}
		//第一个敌人击中判断
		if((Keys.is_space&&Bullet.bullet_position_x>=Enemy.enemy1_position_x-10&&Bullet.bullet_position_x<=Enemy.enemy1_position_x+15&&Bullet.bullet_position_y>=Enemy.enemy1_position_y-10&&Bullet.bullet_position_y<=Enemy.enemy1_position_y+35) ||
				   (Keys.is_zadan&&Bomb.bang_zadan_x>=Enemy.enemy1_position_x-40&&Bomb.bang_zadan_x<=Enemy.enemy1_position_x+60&&Bomb.bang_zadan_y>=Enemy.enemy1_position_y-40&&Bomb.bang_zadan_y<=Enemy.enemy1_position_y+60) ||
				  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=Enemy.enemy1_position_x-30&&Leadone.leadone_position_x<=Enemy.enemy1_position_x+50)&&
					(Leadone.leadone_position_y>=Enemy.enemy1_position_y-20&&Leadone.leadone_position_y<=Enemy.enemy1_position_y+50))){
			Enemy.Enemy_life[0]=false;
			Background.is_spark=true;
		}
		//检查是否近距离
		if((Leadone.leadone_position_x>=Enemy.enemy2_position_x-30&&Leadone.leadone_position_x<=Enemy.enemy2_position_x+50)&&
				(Leadone.leadone_position_y>=Enemy.enemy2_position_y-20&&Leadone.leadone_position_y<=Enemy.enemy2_position_y+50)){
			Leadone.is_knife=true;
		}
		//第二个敌人击中判断
		if((Keys.is_space&&Bullet.bullet_position_x>=Enemy.enemy2_position_x-10&&Bullet.bullet_position_x<=Enemy.enemy2_position_x+15&&Bullet.bullet_position_y>=Enemy.enemy2_position_y-10&&Bullet.bullet_position_y<=Enemy.enemy2_position_y+35) ||
				   (Keys.is_zadan&&Bomb.bang_zadan_x>=Enemy.enemy2_position_x-40&&Bomb.bang_zadan_x<=Enemy.enemy2_position_x+60&&Bomb.bang_zadan_y>=Enemy.enemy2_position_y-40&&Bomb.bang_zadan_y<=Enemy.enemy2_position_y+60) ||
				  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=Enemy.enemy2_position_x-30&&Leadone.leadone_position_x<=Enemy.enemy2_position_x+50)&&
					(Leadone.leadone_position_y>=Enemy.enemy2_position_y-20&&Leadone.leadone_position_y<=Enemy.enemy2_position_y+50))){
			Enemy.Enemy_life[1]=false;
			Background.is_spark=true;
		}
		//检查是否近距离
		if((Leadone.leadone_position_x>=Enemy1.enemy_position_x1-30&&Leadone.leadone_position_x<=Enemy1.enemy_position_x1+50)&&
				(Leadone.leadone_position_y>=Enemy1.enemy_position_y1-20&&Leadone.leadone_position_y<=Enemy1.enemy_position_y1+50)){
			Leadone.is_knife=true;
		}
		//第三个敌人击中判断
		if((Keys.is_space&&Bullet.bullet_position_x>=Enemy1.enemy_position_x1-10&&Bullet.bullet_position_x<=Enemy1.enemy_position_x1+15&&Bullet.bullet_position_y>=Enemy1.enemy_position_y1-5&&Bullet.bullet_position_y<=Enemy1.enemy_position_y1+35) ||
				   (Keys.is_zadan&&Bomb.bang_zadan_x>=Enemy1.enemy_position_x1-40&&Bomb.bang_zadan_x<=Enemy1.enemy_position_x1+60&&Bomb.bang_zadan_y>=Enemy1.enemy_position_y1-40&&Bomb.bang_zadan_y<=Enemy1.enemy_position_y1+60) ||
				  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=Enemy1.enemy_position_x1-30&&Leadone.leadone_position_x<=Enemy1.enemy_position_x1+50)&&
					(Leadone.leadone_position_y>=Enemy1.enemy_position_y1-20&&Leadone.leadone_position_y<=Enemy1.enemy_position_y1+50))){
			Enemy1.enemy_state[0]=3;
			try {
				   File f=new File(".\\music\\music (34).mp3");
				   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
				   p.prefetch();
				   p.start();
			} catch (Exception e){
				e.printStackTrace();
			}
			Background.is_spark=true;
		}
		//检查是否近距离
		if((Leadone.leadone_position_x>=Enemy1.enemy_position_x2-30&&Leadone.leadone_position_x<=Enemy1.enemy_position_x2+50)&&
				(Leadone.leadone_position_y>=Enemy1.enemy_position_y2-20&&Leadone.leadone_position_y<=Enemy1.enemy_position_y2+50)){
			Leadone.is_knife=true;
		}
		//第四个敌人击中判断
		if((Keys.is_space&&Bullet.bullet_position_x>=Enemy1.enemy_position_x2-10&&Bullet.bullet_position_x<=Enemy1.enemy_position_x2+15&&Bullet.bullet_position_y>=Enemy1.enemy_position_y2-10&&Bullet.bullet_position_y<=Enemy1.enemy_position_y2+35) ||
				   (Keys.is_zadan&&Bomb.bang_zadan_x>=Enemy1.enemy_position_x2-40&&Bomb.bang_zadan_x<=Enemy1.enemy_position_x2+60&&Bomb.bang_zadan_y>=Enemy1.enemy_position_y2-40&&Bomb.bang_zadan_y<=Enemy1.enemy_position_y2+60) ||
				  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=Enemy1.enemy_position_x2-30&&Leadone.leadone_position_x<=Enemy1.enemy_position_x2+50)&&
					(Leadone.leadone_position_y>=Enemy1.enemy_position_y2-20&&Leadone.leadone_position_y<=Enemy1.enemy_position_y2+50))){
			Enemy1.enemy_state[1]=3;
			try {
				   File f=new File(".\\music\\music (34).mp3");
				   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
				   p.prefetch();
				   p.start();
			} catch (Exception e){
				e.printStackTrace();
			}
			Background.is_spark=true;
		}
		//检查是否近距离
		if((Leadone.leadone_position_x>=Enemy1.enemy_position_x3-30&&Leadone.leadone_position_x<=Enemy1.enemy_position_x3+50)&&
				(Leadone.leadone_position_y>=Enemy1.enemy_position_y3-20&&Leadone.leadone_position_y<=Enemy1.enemy_position_y3+50)){
			Leadone.is_knife=true;
		}
		//第五个敌人击中判断
		if((Keys.is_space&&Bullet.bullet_position_x>=Enemy1.enemy_position_x3-10&&Bullet.bullet_position_x<=Enemy1.enemy_position_x3+15&&Bullet.bullet_position_y>=Enemy1.enemy_position_y3-10&&Bullet.bullet_position_y<=Enemy1.enemy_position_y3+35) ||
				   (Keys.is_zadan&&Bomb.bang_zadan_x>=Enemy1.enemy_position_x3-40&&Bomb.bang_zadan_x<=Enemy1.enemy_position_x3+60&&Bomb.bang_zadan_y>=Enemy1.enemy_position_y3-40&&Bomb.bang_zadan_y<=Enemy1.enemy_position_y3+60) ||
				  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=Enemy1.enemy_position_x3-30&&Leadone.leadone_position_x<=Enemy1.enemy_position_x3+50)&&
					(Leadone.leadone_position_y>=Enemy1.enemy_position_y3-20&&Leadone.leadone_position_y<=Enemy1.enemy_position_y3+50))){
			Enemy1.enemy_state[2]=3;
			try {
				   File f=new File(".\\music\\music (34).mp3");
				   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
				   p.prefetch();
				   p.start();
			} catch (Exception e){
				e.printStackTrace();
			}
			Background.is_spark=true;
		}
		//检查是否近距离
		if((Leadone.leadone_position_x>=Enemy_boss_lv.boss_position_x-50&&Leadone.leadone_position_x<=Enemy_boss_lv.boss_position_x+50)&&
				(Leadone.leadone_position_y>=Enemy_boss_lv.boss_position_y-20&&Leadone.leadone_position_y<=Enemy_boss_lv.boss_position_y+50)){
			Leadone.is_knife=true;
		}
		//boss_lv击中判断
		if((Keys.is_space&&Bullet.bullet_position_x>=Enemy_boss_lv.boss_position_x-10&&Bullet.bullet_position_x<=Enemy_boss_lv.boss_position_x+15&&Bullet.bullet_position_y>=Enemy_boss_lv.boss_position_y-10&&Bullet.bullet_position_y<=Enemy_boss_lv.boss_position_y+35) ||
				   (Keys.is_zadan&&Bomb.bang_zadan_x>=Enemy_boss_lv.boss_position_x-40&&Bomb.bang_zadan_x<=Enemy_boss_lv.boss_position_x+60&&Bomb.bang_zadan_y>=Enemy_boss_lv.boss_position_y-40&&Bomb.bang_zadan_y<=Enemy_boss_lv.boss_position_y+60) ||
				  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=Enemy_boss_lv.boss_position_x-50&&Leadone.leadone_position_x<=Enemy_boss_lv.boss_position_x+50)&&
					(Leadone.leadone_position_y>=Enemy_boss_lv.boss_position_y-50&&Leadone.leadone_position_y<=Enemy_boss_lv.boss_position_y+50))){
			Background.is_spark=true;
		}
	}
}
