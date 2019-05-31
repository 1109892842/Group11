package group11;

import java.awt.*;

import javax.swing.*;

public class Ldie extends JFrame{
	private static final long serialVersionUID = 1L;
	private Background b= Background.background;
	public static int type_die=0,ci_die=0,move_y_backcup=0;//新增，保存y坐标改动前的值
	public static boolean is_enemy_bullet=false,is_boss_bomb=false,is_plane_bomb=false,is_monster_fire=false;
	public static boolean is_boss_lv=false,is_enemy1_bullet=false,is_enemy2_bullet=false,is_enemy_x1=false,is_enemy_x2=false,is_enemy_x3=false;
	public static boolean unbreath=false;//无敌状态
	public static int numbers=5;
	//主角死的图片
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image[][] die=new Image[8][2];{
		for(int i=0;i<8;i++){
			for(int j=0;j<2;j++){
				die[i][j]=kit.getImage("img\\die"+i+j+".png");
			}
		}
	}
	//无敌倒计时图片
	private Image[] L_number=new Image[11];{
		for(int i=9;i>0;i--){
			L_number[i]=kit.getImage("img\\l"+i+".png");
		}
	}
	//主角被击中判断    
	public void L_is_die(){
		if(unbreath==false){
		if(Background.is_die){
			Keys.move=false;
			Keys.jump=false;
			Keys.squat=false;
			Keys.stand=false;
			Keys.space=false;
			Keys.zhadan=false;
		}

		//被敌人小刀击中,已改
		if(Enemy.is_kined&&Leadone.leadone_position_x+80<=Enemy.enemy2_position_x&&Leadone.leadone_position_x+250>=Enemy.enemy2_position_x&&Leadone.leadone_position_y>= Enemy.enemy2_position_y-40&&Leadone.leadone_position_y<=Enemy.enemy2_position_y+130 ){
			Background.is_die=true;
		}
		//被敌人一击中System.out.println(Leadone.leadone_position_x+"主角坐标"+Leadone.leadone_position_y);
		if(is_enemy1_bullet&&Bullet.enemy_position_bullet_x2>=Leadone.leadone_position_x-20&&Bullet.enemy_position_bullet_x2<=Leadone.leadone_position_x+100&&
				Bullet.enemy_position_bullet_y2>=Leadone.leadone_position_y-10&&Bullet.enemy_position_bullet_y2<=Leadone.leadone_position_y+100){
			Background.is_die=true;
			Background.is_enemy_spark=true;
			Bullet.e_x1=0;
		}
		//被敌人二击中
		if(is_enemy2_bullet&&Bullet.enemy_bullet_position_x1>=Leadone.leadone_position_x-20&&Bullet.enemy_bullet_position_x1<=Leadone.leadone_position_x+100&&
				Bullet.enemy_bullet_position_y1>=Leadone.leadone_position_y-10&&Bullet.enemy_bullet_position_y1<=Leadone.leadone_position_y+100){
			Background.is_die=true;
			Background.is_enemy_spark=true;
			Bullet.e_x=0;
		}
		//被敌人三击中
		if(is_enemy_x1&&Enemy1.enemy_bullet_position_x1>=Leadone.leadone_position_x-150&&Enemy1.enemy_bullet_position_x1<=Leadone.leadone_position_x+150&&
				Enemy1.enemy_bullet_position_y1>=Leadone.leadone_position_y-150&&Enemy1.enemy_bullet_position_y1<=Leadone.leadone_position_y+150){
			Background.is_die=true;
			Background.is_enemy_spark=true;
			Enemy1.bullet_e1=0;
		}
		if(is_boss_lv&&Enemy_boss_lv.boss_position_x>=Leadone.leadone_position_x-250&&Enemy_boss_lv.boss_position_x<=Leadone.leadone_position_x+280&&
				Enemy_boss_lv.boss_position_y<=Leadone.leadone_position_y){
			Background.is_die=true;
		}
		
		//被坦克击中
		if(is_boss_bomb&&Leadone.leadone_position_x>=Boss.boss_bomb_position_x-50&&Leadone.leadone_position_x<=Boss.boss_bomb_position_x+80&&
				Leadone.leadone_position_y>=Boss.boss_bomb_position_y-50&&Leadone.leadone_position_y<=Boss.boss_bomb_position_y+100){
			Background.is_die=true;
		}
		//被飞机的击中
		if(is_plane_bomb&&Leadone.leadone_position_x>=Boss.plane_bomb_position_x-50&&Leadone.leadone_position_x<=Boss.plane_bomb_position_x+80&&
				Leadone.leadone_position_y>=Boss.plane_bomb_position_y-50&&Leadone.leadone_position_y<=Boss.plane_bomb_position_y+100){
			Background.is_die=true;
		}
		//被大boss烧了
		if(is_monster_fire&&Leadone.leadone_position_x>=Boss.monster_fire_x-100&&Leadone.leadone_position_x<=Boss.monster_fire_x+100&&
				Leadone.leadone_position_y>=Boss.monster_fire_y-60&&Leadone.leadone_position_y<=Boss.monster_fire_y+130){
			Background.is_die=true;
		}
		}
	}
	//主角死了
	public void dieLeadone(Graphics g){
		//我的改动，
		if(type_die==0){
			move_y_backcup=Leadone.move_y;
		}
		//Keys.move =false;

		g.drawImage(die[type_die][Leadone.type], Leadone.move_x+105,Leadone.move_y+473,b);
		if(type_die<7){
			if(ci_die<50){
				ci_die++;
			}else{
				ci_die=0;
				Leadone.move_y+=13;//我的改动，新增，用以防止主角死时的图片移动
				type_die++;
			}
		}else{
			type_die=0;         
			//Leadone.move_x=100;
			Leadone.move_y=move_y_backcup;//我的改动，新增，复位move_y值
			move_y_backcup=0;
			
			Leadone.leadone_position_x-=100;
			Keys.stand=true;
			//Keys.move =true;
			//主角复活
			Background.is_die=false;      
			is_enemy1_bullet=false;
			is_enemy2_bullet=false;
			is_enemy_x1=false;
			is_enemy_x2=false;
			is_enemy_x3=false;
			is_boss_lv=true;//无敌			
		}
	}
	public void un_bread(Graphics g){
		if(unbreath){
			//System.out.println(numbers);
		g.drawImage(L_number[numbers],500,100,b);
		}
	}
}
