package alloyContra;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class Boss {
	private Background b=Background.background;
	public static int boss_attack_type=0,ci_boss=0,move_bomb_x=0,move_bomb_y=0,bomb_bang_type=0,ci_bang=0,P=0;
	public static int fly_x=-200,fly_type=2,p_x=0,p_y=0,ci_plane=0,plane_x=0,bomb_type=0,ci_bomb=0,bomb_y=0,bang_type=0;
	public static int move_boss_x=0,hit_type=0,ci_hit=0,D_boss_type=1,ci_D=0,D_x=0;
	public static int lost_type=0,ci_lost=0,lost_y=0,lost_time=0,boss_number=0;
	public static int boss_bomb_position_x=0,boss_bomb_position_y=0,plane_bomb_position_x=0,plane_bomb_position_y=0;
	public static boolean is_hit=false,is_attack_plane=true,boss_lifes=true,is_attack_boss=false;
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image[] boss_attack=new Image[6];{                       //boss的图片 
		for(int i=0;i<6;i++){
			boss_attack[i]=kit.getImage("img\\boss_attack"+i+".png");
		}
	}
	private Image[] bomb_bang=new Image[18];{                      //boss的炸弹爆炸图片
		for(int i=0;i<18;i++){
			bomb_bang[i]=kit.getImage("img\\bomb_bang"+i+".png");
		}
	}
	private Image boss_bomb=Toolkit.getDefaultToolkit().getImage("img\\boss_bomb.png");         //boss的炸弹
	
	private Image[] plane_bomb=new Image[5];{                   //飞机炸弹的图片
		for(int i=0;i<5;i++){
			plane_bomb[i]=kit.getImage("img\\plane_bomb"+i+".png");
		}
	}
	private Image[] plane_fly=new Image[5];{                        //飞机的图片
		for(int i=0;i<5;i++){
			plane_fly[i]=kit.getImage("img\\plane_fly"+i+".png");
		}
	}
	private Image[] tank_hit=new Image[20];{                           //坦克被击中图片
		for(int i=0;i<20;i++){
			tank_hit[i]=kit.getImage("img\\tank_hit"+i+".png");
		}
	}
	private Image[] D_boss=new Image[19];{                        //坦克被击毁后的boss图片
		for(int i=0;i<19;i++){
			D_boss[i]=kit.getImage("img\\D_boss ("+i+").png");
		}
	}
	private Image[] lost=new Image[9];{                     //boss 投降图片
		for(int i=0;i<9;i++){
			lost[i]=kit.getImage("img\\lost"+i+".png");
		}
	}
	private Image[] monster=new Image[24];{          //终极大boss图片
		for(int i=0;i<24;i++){ 
			monster[i]=kit.getImage("img\\monster ("+i+").png");
		}
	}
	private Image[] fire=new Image[10];{              //火焰图片
		for(int i=0;i<10;i++){
			fire[i]=kit.getImage("img\\fire"+i+".png");
		}
	}
	private Image[] monster_die=new Image[22];{            //大boss死的图片
		for(int i=0;i<22;i++){
			monster_die[i]=kit.getImage("img\\monster_die ("+i+").png");
		}
	}
	
	//飞机轰炸
	public void attack_plane(Graphics g){
		if(fly_type<=3){
			if(ci_plane<6){
				ci_plane++;
			}else{
				fly_type++;
				ci_plane=0;
			}
		}else{
			fly_type=2;
		}
		if(fly_type==3){
			p_x=-25;
			p_y=0;
		}else if(fly_type==2){
			p_x=55;
			p_y=0;		
		}
		if(fly_x<2000){
			g.drawImage(plane_fly[1], -20+fly_x, 80, b);
			g.drawImage(plane_fly[fly_type], 50+fly_x+p_x, 80+p_y, b);
			fly_x++;		
		}else{
			g.drawImage(plane_fly[0], -20+fly_x-plane_x, 80, b);
			g.drawImage(plane_fly[fly_type], fly_x-plane_x+p_x, 80+p_y, b);
			plane_x++;
			if(plane_x>3000){
				fly_x=-200;
				plane_x=0;
			}
		}
		if(bomb_type<4){
			if(ci_bomb<10){
				ci_bomb++;
			}else{
				bomb_type++;
				ci_bomb=0;
			}
		}else{
			bomb_type=0;
		}	
		if(bomb_y<350){
			if(fly_x<2000){
				g.drawImage(plane_bomb[bomb_type], fly_x+100, 150+bomb_y, b);
			}else{
				g.drawImage(plane_bomb[bomb_type], fly_x-plane_x+80, 150+bomb_y, b);
			}
			bomb_y++;
			P=fly_x-plane_x+90;
		}else{
			plane_bomb_position_x=P; plane_bomb_position_y=450;
			g.drawImage(bomb_bang[bang_type], P, 450, b);
			if(bang_type<17){
				if(ci_bang<20){
					ci_bang++;
				}else{
					ci_bang=0;
					bang_type++;
				}
				Ldie.is_plane_bomb=true;
			}else{
				bang_type=0;
				bomb_y=0;
				Ldie.is_plane_bomb=false;
			}
		}
	}
	
	//boss开炮
	public static int attack_boss_x=1300,attack_boss_y=300;
	public void attack_boss(Graphics g){
		if(Leadone.leadone_position_x>attack_boss_x+b.x+200&&Background.kit_ci<40){
			Background.kit_ci=45;
		}
		g.drawImage(boss_attack[boss_attack_type],attack_boss_x+b.x,attack_boss_y,b);
		if(boss_attack_type<5){
			if(ci_boss<20){
				ci_boss++;
			}else{
				boss_attack_type++;	
				ci_boss=0;
			}
		}else{
			boss_attack_type=0;
		}
		//坦克主角距离判断
		if(Leadone.leadone_position_x>=attack_boss_x+b.x-450&&Leadone.leadone_position_x<=attack_boss_x+b.x+10){
			is_attack_boss=true;
		}else{
			is_attack_boss=false;
		}
		//坦克炸弹爆炸
		if(is_attack_boss){
			if(move_bomb_x<400){
				g.drawImage(boss_bomb,attack_boss_x-move_bomb_x+b.x,attack_boss_y+120+move_bomb_y,b);
				move_bomb_x+=5;
				move_bomb_y++;
			}else{
				boss_bomb_position_x=attack_boss_x-move_bomb_x-20+b.x; boss_bomb_position_y=attack_boss_y+move_bomb_y;
				g.drawImage(bomb_bang[bomb_bang_type], attack_boss_x-move_bomb_x-20+b.x, attack_boss_y+move_bomb_y, b);
				if(bomb_bang_type<17){
					if(ci_bang<30){
						ci_bang++;
					}else{
						ci_bang=0;
						bomb_bang_type++;
					}
					Ldie.is_boss_bomb=true;
				}else{
					bomb_bang_type=0;
					move_bomb_x=0;
					move_bomb_y=0;
					Ldie.is_boss_bomb=false;
				}
			}
		}			
	}
	
	//坦克被击中
	public void hitTank(Graphics g){
		g.drawImage(tank_hit[hit_type],attack_boss_x+50+b.x,attack_boss_y+100,b);
		if(hit_type<19){
			if(ci_hit<10){
				ci_hit++;
			}else{
				hit_type++;
				ci_hit=0;
			}
		}else{
			hit_type=0;
			Background.spark_x=0;
			is_hit=false;
			Keys.is_space=false;
			Keys.is_zadan=false;
		}
	}
	//坦克被击毁
	public void destroy(Graphics g){
		g.drawImage(D_boss[0],attack_boss_x+50+b.x,attack_boss_y+100,b);
		g.drawImage(D_boss[D_boss_type],attack_boss_x-D_x+b.x,attack_boss_y+100,b);
		if(D_boss_type<17){
			if(ci_D<20){
				ci_D++;
			}else{
				ci_D=0;
				D_boss_type++;
			}
		}else{
			D_boss_type=1;
		}
	}
	//boss认输
	public void towel(Graphics g){
		if(lost_type<3){
			g.drawImage(lost[0], attack_boss_x-D_x+b.x,attack_boss_y+100+lost_y, b);
			g.drawImage(lost[1],attack_boss_x-D_x+b.x,attack_boss_y+100,b);
			g.drawImage(lost[2],attack_boss_x-D_x+b.x,attack_boss_y+100,b);
			lost_y++;
			if(lost_y>100){
				lost_type=3;
			}
			fly_x=0;
		}else{		
			g.drawImage(lost[lost_type], attack_boss_x-D_x+b.x, attack_boss_y+100, b);
			if(lost_type<7){
				if(ci_lost<50){
					ci_lost++;
				}else{
					lost_type++;
					ci_lost=0;
					//boss_lifes=false;//新增
				}
			}else{
				lost_type=3;
				if(lost_time>6){//已改
					Background.kit_ci=0;
					Boss.D_x=0;
					Boss.attack_boss_x+=1000;
					Boss.attack_boss_y+=5;
					//Boss.boss_lifes =true;//新增
					Boss.is_hit=false;	
					lost_time=0;
					lost_type=0;
					lost_y=0;
					boss_number++;
				}else{
					lost_time++;
				}
			}
		}
	}
	
	public static int monster_type=1,ci_monster=0,fire_type=0,ci_fire=0,fire_x=0,M_plane_y=0,M_fly_x=0;
	public static int monster_die_type=1,ci_monster_die=0,kit_monster=0;
	public static int monster_fire_x=0,monster_fire_y=0;
	public static boolean is_here=true;
	//大boss驾到
	public void M_here(Graphics g){
		if(fly_type<=3){
			if(ci_plane<6){
				ci_plane++;
			}else{
				fly_type++;
				ci_plane=0;
			}
		}else{
			fly_type=2;
		}
		if(fly_type==3){
			p_x=-25;
			p_y=0;
		}else if(fly_type==2){
			p_x=55;
			p_y=0;		
		}
		if(M_fly_x<700){
			g.drawImage(plane_fly[1], -20+M_fly_x, 80, b);
			g.drawImage(plane_fly[fly_type], 50+M_fly_x+p_x, 80+p_y, b);
			M_fly_x++;
		}else{
			g.drawImage(plane_fly[1], -20+M_fly_x, 80+M_plane_y, b);
			g.drawImage(plane_fly[fly_type], 50+M_fly_x+p_x, 80+p_y+M_plane_y, b);
			if(M_plane_y<300){
				M_plane_y++;
			}else{
				M_fly_x+=1000;
				is_here=false;
			}
		}
	}
	//终极大boss的攻击
	public void M_attack(Graphics g){
		g.drawImage(monster[monster_type], 750, 400, b);
		if(monster_type<23){
			if(ci_monster<30){
				ci_monster++;
			}else{
				ci_monster=0;
				monster_type++;
			}
		}else{
			monster_type=1;
		}
	}
	//大boss喷火焰
	public void spray(Graphics g){
		monster_fire_x=580-fire_x; monster_fire_y=350;
		if(fire_x<300){
			g.drawImage(fire[fire_type],580-fire_x,350,b);		
			fire_x++;
		}else{
			fire_x=0;
		}
		if(fire_type<9){
			if(ci_fire<50){
				ci_fire++;
			}else{
				ci_fire=0;
				fire_type++;
			}
			if(fire_type>3&&fire_type<7){
				Ldie.is_monster_fire=true;
			}else{
				Ldie.is_monster_fire=false;
			}
		}else {
			fire_type=0;	
		}
	}
	//大boss死了
	public void die_monster(Graphics g){
		g.drawImage(monster_die[monster_die_type],750,400,b);
		if(monster_die_type<21){
			if(ci_monster_die<20){
				ci_monster_die++;
			}else{
				ci_monster_die=0;
				monster_die_type++;
			}
		}else{
			monster_die_type=1;
			boss_number=0;
			
			int i=JOptionPane.showOptionDialog(b,null, 
					null, JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,Background.img,Background.str,Background.str[0]);
			if(i==1||i==0){
				System.exit(0);
			}
		}
	}
}
