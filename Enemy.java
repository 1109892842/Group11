package alloyContra;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.*;

import java.awt.*;
import java.io.File;

public class Enemy extends JFrame  {

	//private static final long serialVersionUID = 1345433247962028349L;
	Background back= Background.background;
	public static int X,x1=600,x2=800,x3=500;
	public static int y1=473,y2=473,y_d1=y1,y_d2=y2;
	
	public static int enemy1_position_x;//第一个敌人的x
	public static int enemy1_position_y;//第一个敌人的y
	public static int enemy2_position_x;//第二个敌人的x
	public static int enemy2_position_y;//第二个敌人的y
	
	
	public static int is_fired_counts=0;
	public static int enemy_type=0,n=0,m=0,d=0,a=0,s=0,a1=7,d_type=0,enemy_s=0,run_type=0,attack_type=0,bb=0,
			boms=0,bomx_way=0,bomy_way=0,fire_y=0;
	public static boolean Enemy_life[] =new boolean [2];//敌人生命状态
	public static int E_type[]=new int[5] ;//敌人状态，站着和走路
	public static boolean e_fired=false,e_fired1=false,isBom=false;
	public static boolean is_fired=false;//是否被打中
	public static boolean is_kined=false;
	 Toolkit kit=Toolkit.getDefaultToolkit(); 
	
	 private Image[][][] imageEnemy_run= new Image[3][5][2];
	 private Image[] imageEnemy_sca= new Image[12];
	 private Image[][] imageEnemy_die= new Image[3][6];
	 private Image[][][] imageEnemy_attack= new Image[2][6][2];
	 private Image[][] imageEnemy_stand= new Image[3][4];
	 private Image[] imageEnemy_attack1= new Image[19];
	 private Image[][] E_bullet= new Image[7][2];
	 private Image[] Enemy_bom= new Image[6];
	 private Image[] bom= new Image[7];
	 public Enemy() {
		 E_type[0]=4;
		 E_type[1]=0;
		 Enemy_life[0]=true;
		 Enemy_life[1]=true;
		 for(int k=0;k<2;k++){
			 for(int j=0;j<=2;j++){
					for(int i=0;i<=4;i++){
							imageEnemy_run[j][i][k]=kit.getImage(".//img//Enemy//R//enemy_run"+j+i+k+".png");
					}	
				}
		 }
		for(int i=0;i<3;i++){
			for(int j=0;j<2;j++){
				imageEnemy_stand[i][j]=kit.getImage(".//img//Enemy//R//enemy_stand"+i+j+"0.png");
			}
		}
		for(int j=0;j<=2;j++){
			for(int i=0;i<=4;i++){
					imageEnemy_die[j][i]=kit.getImage(".//img//Enemy//R//enemy_die"+j+i+"0.png");
			}	
		}
		for(int j=0;j<2;j++){
			for(int i=0;i<5;i++){
				for(int k=0;k<2;k++)
					imageEnemy_attack[j][i][k]=kit.getImage(".//img//Enemy//R//enemy_attack"+j+i+k+".png");
			}	
		}
		for(int i=0;i<10;i++){
			imageEnemy_sca[i]=kit.getImage(".//img//Enemy//R//sca//enemy_sca"+i+".png");
		}
		for(int i=0;i<16;i++){
			imageEnemy_attack1[i]=kit.getImage(".//img//Enemy//R//enemy_attack"+i+".png");
		}
		for(int j=0;j<6;j++){
			for(int i=0;i<2;i++){
					E_bullet[j][i]=kit.getImage(".//img//bullet"+j+i+".png");
			}	
		}
		for(int i=0;i<4;i++){
			Enemy_bom[i]=kit.getImage(".//img//Enemy//R//Enemy_bom//Enemy_bom"+i+".png");
		}
		for(int i=0;i<7;i++){
			bom[i]=kit.getImage(".//img//Enemy//R//Enemy_bom//bom"+i+".png");
		}
	 }	
	public void paintEnemy (Graphics g){
		enemy_copy();//控制敌人增加
		//敌人生命状态
		if(Enemy_life[0]){
			enemy2_position_x=x3+Background.x;//第1个敌人的x
			enemy2_position_y=y1;//第1个敌人的y
			
		switch(E_type[0]){
		case 1:
			g.drawImage(imageEnemy_run[0][n][run_type],x3+Background.x,y1,back);
			guns(x3+Background.x);
		break;
		case 2:
			switch(d_type){
			case 0:
				g.drawImage(imageEnemy_die[1][d],X,y_d1,back);
			break;
			case 2:
				g.drawImage(imageEnemy_die[2][d],X,y_d1,back);
			break;
			case 1:
				g.drawImage(imageEnemy_die[0][d],X,y_d1,back);
			break;
			}
			break;
		case 4:
			g.drawImage(imageEnemy_sca[s],x3+Background.x,y1,back);	
			//guns(x3+Background.x);
			break;
		case 5:
			g.drawImage(imageEnemy_attack1[a1],x3+Background.x,y1,back);
			guns(x3+Background.x);
			break;
		}
		}
	}
	public void Starting()
	{
		if(E_type[0]!=5)
			e_fired=false;
		if(E_type[0]!=2){//活着状态
			if(E_type[0]==3||E_type[0]==5||E_type[0]==4||E_type[1]==3){
				try{
					Thread.sleep(250);
				}catch(Exception ei){
					ei.printStackTrace();
				}
			}
			else if(E_type[1]==4&&boms==0){
				try{
					Thread.sleep(350);
				}catch(Exception ei){
					ei.printStackTrace();
				}
			}
			
			else{
				try{
					Thread.sleep(100);
				}catch(Exception ei){
					ei.printStackTrace();
				}
			}
			//控制敌人自动走动
			n++;
			m++;
			a++;
			s++;
			
			if(	E_type[1]!=0)
			bb++;
			
			if(bb>3)
				bb=0;
			/*if(boms>6)
				boms=1;*/
			if(a==3&&E_type[1]==3){
				a=0;
				Enemy.E_type[1]=0;
				try {
					   File f=new File(".\\music\\music (30).mp3");
					   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
					   p.prefetch();
					   p.start();
				} catch (Exception e){
					e.printStackTrace();
				}
				//y2+=13;
			}
			if(E_type[0]==5){//敌人进入攻击状态
				a1++;
				if(a1==12)//通过调整坐标来调整画面
				x3=x3-20;
				if(a1==13)
					x3=x3-5;
				if(a1==14){
					x3=x3-6;	
				}	
				if(a1==15){
					e_fired=true;
					//System.out.println(Enemy.x3-30-Bullet.e_x);
					x3=x3+4;//坐标复位
				}
				if(a1==1)
				x3=x3-6;
				if(a1==2)
					x3=x3-5;
				if(a1==4)
					x3=x3-29;
				if(a1==5)
					x3=x3-21;
				if(a1==6)
					x3=x3+6;
			}
			if(m>1)
				m=0;
			if(n>4)
				n=0;
			if(a>3){
				a=0;
			}
				
			//敌人发现主角
			if(Leadone.leadone_position_x+200>=x3+Background.x){
				enemy_s=1;//敌人发现
				if(s==7&&E_type[0]==4){
					try {
						   File f=new File(".\\music\\music (26).mp3");
						   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
						   p.prefetch();
						   p.start();
					} catch (Exception e){
						e.printStackTrace();
					}
				}
				
				//我的改动
				Background.is_found=true;            //主角被发现
			}
			
			//主角进入敌人肉搏范围
			if(Leadone.move_x+170>=x3+Background.x&&Leadone.move_x+170<=x3+Background.x+100&&E_type[0]!=2){
				enemy_s=0;
				E_type[0]=5;
				is_kined=true;//开启小刀
				if(a1>15||a1>6){
					a1=0;
					x3=x3+55;
				}
			}
			if(E_type[0]!=5){
				is_kined=false;//关闭小刀
			}
			//主角进入敌人射击范围
			else if(Leadone.move_x+450>=x3+Background.x&&Leadone.move_x-100<=x3+Background.x&&E_type[0]!=2){
				//我的改动
				Ldie.is_enemy1_bullet=true;
				
				if(a1>15){
					a1=11;
					if(a1==11){
						try {
							   File f=new File(".\\music\\music (2).mp3");
							   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
							   p.prefetch();
							   p.start();
						} catch (Exception e){
							e.printStackTrace();
						}
					}
					x3=x3+31;
				}
			}
			else {//预防溢出
				if(a1>15)
					a1=6;
			}
			
			switch(enemy_s){
				case 0:
					if(s>6)//数落别人
					s=0;
				break;
				case 1:
					if(E_type[0]==4){
						if(s>9){
							E_type[0]=1;//落荒而逃
							run_type=1;//往右跑
							s=0;
						}
					}
					 if(E_type[0]==1&&run_type==0&&Leadone.move_x+400>=x3+Background.x&&Leadone.move_x-100<=x3+Background.x){
						E_type[0]=5;
					}
					 if(E_type[0]==5&&run_type==0&&(Leadone.move_x+400<=x3+Background.x||Leadone.move_x-100>=x3+Background.x)){
						 E_type[0]=1;
					 }
					enemy_s=0;
					break;
			}
			//来回跑
			if((E_type[0]==1||E_type[1]==1)){
				if(run_type==0){
					if(E_type[2]==1)
					x1=x1-11;
					if(E_type[1]==1)
					x2=x2-11;
					if(E_type[0]==1)
					x3=x3-11;
					if (x1<-100)
						run_type=1;
					if (x2<-100)
						run_type=1;
					if (x3+Background.x<-50)
						run_type=1;
				}
				else if(run_type==1){
					if(E_type[2]==1)
					x1=x1+11;
					if(E_type[1]==1)
					x2=x2+11;
					if(E_type[0]==1)
					x3=x3+11;
					if (x1>900)
						run_type=0;
					if (x2>900)
						run_type=0;
					if (x3+Background.x>950)
						run_type=0;
				}
			}
		}
		if((E_type[0]==2&&Enemy_life[0])||(E_type[1]==2&&Enemy_life[1])){//死亡状态
			try{
				Thread.sleep(250);
			}catch(Exception ei){
				ei.printStackTrace();
			}
			if(E_type[0]==2){
				a1++;
				a1=7;
				y_d1+=15;
			}
			if(E_type[1]==2){
				y_d2+=15;
			}
			d++;
			
			if(y_d1>=548){
				//E_type[0]=1;
				y_d1=473;
			}
			if(y_d2>=548){
				y_d2=473;
			}
			if(d>4){
				d=0;
				//E_type[0]=0;
				if(E_type[0]==2)
					Enemy_life[0]=false;
				if(E_type[1]==2)
					Enemy_life[1]=false;
			}
		}
		
	}
	//枪支，判断敌人是否中枪
	public void guns(int e_x){
		if(((Keys.is_space&&is_fired&&x3+Background.x>=Bullet.bullet_position_x-10&&x3+Background.x<=Bullet.bullet_position_x+10&&Bullet.bullet_position_y>=y1-25&&Bullet.bullet_position_y<=y1+25) ||
			   (Keys.is_zadan&&x3+Background.x>=Bomb.bang_zadan_x-30&&x3+Background.x<=Bomb.bang_zadan_x+30&&Bomb.bang_zadan_y>=y1-40&&Bomb.bang_zadan_y<=y1+40) ||
			  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=x3+Background.x-50&&Leadone.leadone_position_x<=x3+Background.x+50)&&
				(Leadone.leadone_position_y>=y1-50&&Leadone.leadone_position_y<=y1+50)))){
			X=e_x;
		//	System.out.println(Leadone.move_x+200+Bullet.x+"x3"+x3);
			is_fired_counts++;
			if(is_fired_counts==3){
				E_type[0]=2;
				try {
					   //System.out.println("ksjdfsd");
					   File f=new File(".\\music\\music (34).mp3");
					   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
					   p.prefetch();
					   p.start();
				} catch (Exception e){
					e.printStackTrace();
				}
				is_fired_counts=0;
				d_type++;
				if(d_type>2)
					d_type=0;
			}
			
			is_fired=false;
		}
	}
	//画出第2个敌人
	public void enemy_1(Graphics g){
		enemy_copy();//增加敌人
		if(Enemy_life[1]){
			enemy1_position_x=x2+Background.x;//第2个敌人的x
			enemy1_position_y=y2;//第2个敌人的y
		switch(E_type[1]){
		case 0://站着
			g.drawImage(imageEnemy_stand[1][m],x2+Background.x,y2,back);
		break;
		case 1://跑
			g.drawImage(imageEnemy_run[1][n][run_type],x2+Background.x,473,back);
		break;
		case 2://死忙
			switch(d_type){
			case 0:
				g.drawImage(imageEnemy_die[1][d],x2+Background.x,y_d2,back);
			break;
			case 2:
				g.drawImage(imageEnemy_die[2][d],x2+Background.x,y_d2,back);
			break;
			case 1:
				g.drawImage(imageEnemy_die[0][d],x2+Background.x,y_d2,back);
			break;
			}
			break;
		case 3://攻击
			g.drawImage(imageEnemy_attack[1][a][attack_type],x2+Background.x,y2,back);
			//我的改动
			Ldie.is_enemy2_bullet=true;
		break;
		case 4://手雷
			g.drawImage(Enemy_bom[bb],x2+Background.x,y2,back);
		break;
			
		}
		if(isBom)
		g.drawImage(bom[boms],x2+Background.x+50-bomx_way,y2-bomy_way-fire_y,back);
		}
	}
	public void enemy_star(){
		if(Leadone.move_x+450>=x2+Background.x&&Leadone.move_x<=x2+Background.x&&E_type[1]!=2&&y2-bomy_way<553){
			isBom=true;
			e_fired1=false;
			//我的改动
			Background.is_found=true;            //主角被发现
			//System.out.println(Leadone.move_x+"  "+(x2+Background.x));
			if(bb<3){
				E_type[1]=4;
			}
			else if(bb==3){
				E_type[1]=0;
			if(y2-bomy_way<y2+40)
			bomx_way+=80;
			if(bomy_way<161&&x2+Background.x+50-bomx_way>=548)
				bomy_way+=80;
			else if(bomy_way>160||(Background.x+50-bomx_way<548&&y2-bomy_way<y2+40)){
				bomy_way-=80;
			
			}
			
			//System.out.println((x2+Background.x+50-bomx_way)+"y:"+(y2-bomy_way));
			}
		}
		else if(Leadone.move_x+550>=x2+Background.x&&Leadone.move_x<=x2+Background.x&&E_type[1]!=2){
			E_type[1]=3;//攻击
			Enemy.e_fired1=true;
			//我的改动
			Background.is_found=true;            //主角被发现
			//检测是否打中敌人
			if(((Keys.is_space&&x2+Background.x>=Bullet.bullet_position_x-10&&x2+Background.x<=Bullet.bullet_position_x+10&&Bullet.bullet_position_y>=y2-25&&Bullet.bullet_position_y<=y2+25) ||
					   (Keys.is_zadan&&x2+Background.x>=Bomb.bang_zadan_x-50&&x2+Background.x<=Bomb.bang_zadan_x+50&&Bomb.bang_zadan_y>=y2-40&&Bomb.bang_zadan_y<=y2+40) ||
					  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=x2+Background.x-50&&Leadone.leadone_position_x<=x2+Background.x+50)&&
						(Leadone.leadone_position_y>=y2-50&&Leadone.leadone_position_y<=y2+50)))){
				E_type[1]=2;//死亡
				try {
					   //System.out.println("ksjdfsd");
					   File f=new File(".\\music\\music (34).mp3");
					   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
					   p.prefetch();
					   p.start();
				} catch (Exception e){
					e.printStackTrace();
				}
				e_fired1=false;
			}
		}
		else if(Leadone.move_x>=x2+Background.x&&Leadone.move_x<=x2+Background.x+400&&E_type[1]!=2){
			E_type[1]=3;//攻击
			attack_type=1;
			Enemy.e_fired1=true;
			//我的改动
			Background.is_found=true;            //主角被发现
			//检测是否打中敌人
			if(((Keys.is_space&&x2+Background.x>=Bullet.bullet_position_x-10&&x2+Background.x<=Bullet.bullet_position_x+10&&Bullet.bullet_position_y>=y2-25&&Bullet.bullet_position_y<=y2+25) ||
					   (Keys.is_zadan&&x2+Background.x>=Bomb.bang_zadan_x-30&&x2+Background.x<=Bomb.bang_zadan_x+30&&Bomb.bang_zadan_y>=y2-40&&Bomb.bang_zadan_y<=y2+40) ||
					  (Leadone.is_knife&&Keys.space&&(Leadone.leadone_position_x>=x2+Background.x-50&&Leadone.leadone_position_x<=x2+Background.x+50)&&
						(Leadone.leadone_position_y>=y2-50&&Leadone.leadone_position_y<=y2+50)))){
				E_type[1]=2;
				try {
					   //System.out.println("ksjdfsd");
					   File f=new File(".\\music\\music (34).mp3");
					   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
					   p.prefetch();
					   p.start();
				} catch (Exception e){
					e.printStackTrace();
				}
				e_fired1=false;
			}
		
		}
		else if(E_type[1]!=2) {
			E_type[1]=0;
			Enemy.e_fired1=false;
		}
		if(y2-bomy_way>=553&&isBom){
			fire_y=50;
			try{
				Thread.sleep(0);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			boms++;
			if(boms==2){
				try {
					   //System.out.println("ksjdfsd");
					   File f=new File(".\\music\\music (27).mp3");
					   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
					   p.prefetch();
					   p.start();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			if(boms>5){
				isBom=false;
				boms=0;
			}
		}
	}
	//复制敌人函数
	public void enemy_copy(){
		if(!Enemy_life[0]||enemy2_position_x<-100){
			Enemy_life[0]=true;
			x3+=800;
			E_type[0]=4;
			n=0;
			d=0;
			s=0;
			a1=7;
			d_type=0;
			enemy_s=0;
			run_type=0;
		}
		if(!Enemy_life[1]||enemy1_position_x<-70){
			Enemy_life[1]=true;
			x2+=530;
			E_type[1]=0;
			m=0;
			a=0;
			attack_type=0;
			bb=0;
			boms=0;
			bomx_way=0;
			bomy_way=0;
			fire_y=0;
		}
	}
}
