package group11;
import java.awt.*;
import java.awt.image.ImageObserver; 
import javax.swing.*;
public class Bullet extends JFrame implements ImageObserver{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Background b=Background.background;
	public static int x=0,y=0,bullet_type =0,bullet_position_x=0,bullet_position_y=0;
	public static int enemy_bullet_position_x=0,enemy_bullet_position_y=0;
	public static int e_x=0,e_x1=0,enemy_bullet_position_x1,enemy_bullet_position_y1,enemy_position_bullet_x2,enemy_position_bullet_y2;
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image[][] bullet=new Image[7][2];{	     //子弹的图片
		for(int i=0;i<7;i++){
			for(int j=0;j<2;j++){
				bullet[i][j]=kit.getImage("img\\bullet"+i+j+".png");
			}
		}
	}
	//主角子弹飞
	public void fly(Graphics g){
		if(Leadone.type ==1){
			bullet_position_x=Leadone.move_x+200+x; bullet_position_y=Leadone.move_y+Leadone.squat_y+490;	
			g.drawImage(bullet[bullet_type][Leadone.type], Leadone.move_x+200+x, Leadone.move_y+Leadone.squat_y+490, b);
		}else{
			bullet_position_x=Leadone.move_x+80-x; bullet_position_y=Leadone.move_y+Leadone.squat_y+490;	
			g.drawImage(bullet[bullet_type][Leadone.type], Leadone.move_x+80-x, Leadone.move_y+Leadone.squat_y+490, b);
		}
	}
	//敌人子弹飞
	public void enemy_bullet(Graphics g){        //画出敌人子弹
		if(Enemy.e_fired&&Enemy.Enemy_life[0]){
			enemy_bullet_position_x=Enemy.x3+b.x-30-e_x;	enemy_bullet_position_y=473+20;
			g.drawImage(bullet[4][0], Enemy.x3+b.x-30-e_x,473+20, b);
			enemy_bullet_position_x1=Enemy.x3+Background.x-50-e_x;//第二个敌人的子弹坐标
			enemy_bullet_position_y1=473+20;//第二个敌人的子弹y
		}
		if(Enemy.e_fired1&&Enemy.Enemy_life[1]){
			if(Enemy.attack_type==0){
				enemy_bullet_position_x=Enemy.x2+b.x-30-e_x1;	enemy_bullet_position_y=473+20;
				g.drawImage(bullet[0][0], Enemy.x2+b.x-30-e_x1,473+20, b);
				enemy_position_bullet_x2=Enemy.x2+Background.x-30-e_x1;//第一个敌人的子弹x
				enemy_position_bullet_y2=473+20;//第一个敌人的子弹y
			}else if(Enemy.attack_type==1){
				enemy_bullet_position_x=Enemy.x2+b.x+130+e_x1;	enemy_bullet_position_y=473+20;
				g.drawImage(bullet[0][1], Enemy.x2+b.x+130+e_x1,473+20, b);
				enemy_position_bullet_x2=Enemy.x2+Background.x+130+e_x1;//
				enemy_position_bullet_y2=473+20;//第一个敌人的子弹坐标y
			}
		}
	}
}
