package alloyContra;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.*;

import java.awt.*;
import java.io.File;
public class Enemy1 extends JFrame {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 7010475608136135079L;
	Background back =Background.background;
	 Toolkit kit=Toolkit.getDefaultToolkit(); 
	 
	 
	public static int enemy_x1=900;//敌人坐标
	public static int enemy_x2=600;
	public static int enemy_x3=700;
	public static int enemy_y1=374;
	public static int enemy_y2=473;
	public static int enemy_y3=450;
	public static int enemy_position_x1=1000;
	public static int enemy_position_x2=1000;
	public static int enemy_position_x3=1000;
	public static int enemy_position_y1=1000;
	public static int enemy_position_y2=1000;
	public static int enemy_position_y3=1000;
	public static int enemy_bullet_position_x1=1000;//子弹、手雷坐标
	public static int enemy_bullet_position_x2=1000;
	public static int enemy_bullet_position_x3=1000;
	public static int enemy_bullet_position_y1=1000;
	public static int enemy_bullet_position_y2=1000;
	public static int enemy_bullet_position_y3=1000;
	public static int bullet_e1=0;//子弹坐标增量
	public static int bullet_e2=0;
	public static int bullet_e3=0;
	public static int bullet_y_e3=0;
	public static int bullet_y_e1=0;
	public static int boms_1=0;//手雷增量
	public static boolean bullet_y_is_fired=false;
	public static boolean bairred_bang_fired=false;//控制炮弹火花点着
	public static boolean is_boming=false;//控制手雷弹火花点着
	public static int boms=1;//火花动态增量
	
	public static boolean [] enemy_fired=new boolean[4];
	public static int [] enemy_state=new int[4];//敌人状态，0stand，1run，2attack，3die
	public static boolean [] enemy_life=new boolean[4];//敌人生命状态
	public static int state_1=0,state_2=0,state_3=0;//敌人状态增量
	public static int LR_state_1=0,LR_state_2=0,LR_state_3=0;//左右状态
	private Image[][][] enemy_attack=new Image[3][6][2];
	private Image[][][] enemy_run=new Image[3][6][2];
	private Image[][][] enemy_stand=new Image[3][3][2];
	private Image[][][] enemy_die =new Image[3][6][2]; 
	private Image[] bom= new Image[8];
	private Image[][] bullet=new Image[7][2];{	     //子弹的图片
		for(int i=0;i<7;i++){
			for(int j=0;j<2;j++){
				bullet[i][j]=kit.getImage("img\\bullet"+i+j+".png");
			}
		}
	}
	private Image[] barrier_bang=new Image[6];{	 //火花的图片    
			for(int j=0;j<5;j++){
				barrier_bang[j]=kit.getImage("img\\barrier_bang1"+j+".png");
			}
	}
	
	public Enemy1() {
		for(int i=0;i<4;i++){
			enemy_state[i]=0;
			enemy_life[i]=true;
			enemy_fired[i]=false;
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<5;j++){
				for(int k=0;k<2;k++)
					enemy_attack[i][j][k]=kit.getImage(".\\img\\Enemy\\R\\enemy_attack"+i+j+k+".png");
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<5;j++){
				for(int k=0;k<2;k++)
					enemy_run[i][j][k]=kit.getImage(".\\img\\Enemy\\R\\enemy_run"+i+j+k+".png");
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<5;j++){
				for(int k=0;k<2;k++)
					enemy_die[i][j][k]=kit.getImage(".\\img\\Enemy\\R\\enemy_die"+i+j+k+".png");
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<2;k++)
					enemy_stand[i][j][k]=kit.getImage(".\\img\\Enemy\\R\\enemy_stand"+i+j+k+".png");
			}
		}
		for(int i=0;i<7;i++){
			bom[i]=kit.getImage(".//img//Enemy//R//Enemy_bom//bom"+i+".png");
		}
		
	}
	public void paint_enemy_all(Graphics g){//画出所有敌人
		paint_enemy_0(g);
		paint_enemy_1(g);
		paint_enemy_2(g);
	}
	public void paint_enemy_0(Graphics g){//画出第一个敌人
		enemy_copy();//增加敌人数量
		if(enemy_life[0]){
		enemy_position_x1=enemy_x1+Background.x;//追踪敌人坐标
		enemy_position_y1=enemy_y1;
		switch(enemy_state[0]){
			case 0:
				g.drawImage(enemy_stand[0][state_1][LR_state_1],enemy_x1+Background.x,enemy_y1,back);
				break;
			case 1:
				g.drawImage(enemy_attack[0][state_1][LR_state_1],enemy_x1+Background.x,enemy_y1,back);
				break;
			case 2:
				g.drawImage(enemy_run[0][state_1][LR_state_1],enemy_x1+Background.x,enemy_y1,back);
				break;
			case 3:
				g.drawImage(enemy_die[0][state_1][LR_state_1],enemy_x1+Background.x,enemy_y1,back);
				break;
		}
		}
	}
	public void paint_enemy_1(Graphics g){//画出第二个敌人
		if(enemy_life[1]){
			enemy_position_x2=enemy_x2+Background.x;//追踪敌人坐标
			enemy_position_y2=enemy_y2;
			switch(enemy_state[1]){
				case 0:
					g.drawImage(enemy_stand[1][state_2][LR_state_2],enemy_x2+Background.x,enemy_y2,back);
					break;
				case 1:
					g.drawImage(enemy_attack[1][state_2][LR_state_2],enemy_x2+Background.x,enemy_y2,back);
					break;
				case 2:
					g.drawImage(enemy_run[1][state_2][LR_state_2],enemy_x2+Background.x,enemy_y2,back);
					break;
				case 3:
					g.drawImage(enemy_die[1][state_2][LR_state_2],enemy_x2+Background.x,enemy_y2,back);
					break;
			}
		}
		
	}
	public void paint_enemy_2(Graphics g){//画出第三个敌人
		if(enemy_life[2]){
			enemy_position_x3=enemy_x3+Background.x;//追踪敌人坐标
			enemy_position_y3=enemy_y3;
			switch(enemy_state[2]){
				case 0:
					g.drawImage(enemy_stand[2][state_3][LR_state_3],enemy_x3+Background.x,enemy_y3,back);
					break;
				case 1:
					g.drawImage(enemy_attack[2][state_3][LR_state_3],enemy_x3+Background.x,enemy_y3,back);
					break;
				case 2:
					g.drawImage(enemy_run[2][state_3][LR_state_3],enemy_x3+Background.x,enemy_y3,back);
					break;
				case 3:
					g.drawImage(enemy_die[2][state_3][LR_state_3],enemy_x3+Background.x,enemy_y3,back);
					break;
			}
		}
		
	}
	//启动敌人状态1
	public void enemy_start_1(){
			//判断敌人状态
		//System.out.println(((enemy_x1+Background.x-Leadone.leadone_position_x)/2));
			switch(enemy_state[0]){
			//stand状态
			case 0:
				try{
					Thread.sleep(150);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				state_1++;
				if(state_1>1)
					state_1=0;
				if(!enemy_fired[0]&&Leadone.leadone_position_x+400>=enemy_position_x1&&Leadone.leadone_position_x<=enemy_position_x1+100){
					LR_state_1=0;
					enemy_state[0]=1;
				}
				if(enemy_fired[0]){
					if(((enemy_x1+Background.x+500)/2)<=enemy_x1+Background.x+50+bullet_e1){
						bullet_e1-=20;
						bullet_y_e1-=20;
					}
					else if(!is_boming&&((enemy_x1+Background.x+500)/2)>enemy_x1+Background.x+50+bullet_e1){
						bullet_e1-=20;
						bullet_y_e1+=20;
					}
						if(enemy_y1+20+bullet_y_e1>=Leadone.leadone_position_y-20&&enemy_y1+20+bullet_y_e1<=Leadone.leadone_position_y+50){
							is_boming=true;
							boms_1++;
							if(boms_1==2){
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
							if(boms_1>=6){
								boms_1=0;
								bullet_e1=0;
								bullet_y_e1=0;	
								enemy_fired[0]=false;
								is_boming=false;
							}
						}
					
				}
			break;
				//attack状态
			case 1:
				try{
					Thread.sleep(250);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				state_1++;
				if(state_1==2){
					enemy_fired[0]=true;
				}
				if(state_1>3){
					state_1=0;
					enemy_state[0]=0;
				}
					
				if(Leadone.leadone_position_x-650>=enemy_position_x1&&Leadone.leadone_position_x-650<=enemy_position_x1+100&&LR_state_1==1){
					enemy_state[0]=2;
				}
				else if(Leadone.leadone_position_x+650>=enemy_position_x1&&Leadone.leadone_position_x+700<=enemy_position_x1+100&&LR_state_1==0){
					enemy_state[0]=2;
				}
				else if(!enemy_fired[0]&&Leadone.leadone_position_x+190>=enemy_position_x1&&Leadone.leadone_position_x+190<=enemy_position_x1+100){
					LR_state_1=1;
					enemy_state[0]=2;
					state_1=0;
				}
			break;
				//run状态
			case 2:
				try{
					Thread.sleep(150);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				state_1++;
				if(state_1>4){
					state_1=0;
				}
				if(LR_state_1==1)
					enemy_x1+=7;	
				else if(LR_state_1==0){
					enemy_x1-=8;
				}
				if(Leadone.leadone_position_x-350>=enemy_position_x1&&Leadone.leadone_position_x-350<=enemy_position_x1+100&&LR_state_1==1){
					enemy_state[0]=1;
				}
				else if(Leadone.leadone_position_x+380>=enemy_position_x1&&Leadone.leadone_position_x+380<=enemy_position_x1+100&&LR_state_1==0){
					enemy_state[0]=1;
				}
				else if(Leadone.leadone_position_x+480>=enemy_position_x1&&Leadone.leadone_position_x+480<=enemy_position_x1+100){
					LR_state_1=0;
					
				}
			break;
				//die状态
			case 3:
				try{
					Thread.sleep(200);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			
				state_1++;
				enemy_y1+=15;
				if(state_1>4){
					state_1=0;
					enemy_life[0]=false;
					enemy_fired[0]=false;//死忙没收武器功能
				}
					
			break;
			}
		}
	//启动敌人状态2
		public void enemy_start_2(){
				//判断敌人状态
				//System.out.println(enemy_state[2]);
				switch(enemy_state[1]){
				//stand状态
				case 0:
					try{
						Thread.sleep(150);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					state_2++;
					if(state_2>1)
						state_2=0;
					if(!enemy_fired[1]&&Leadone.leadone_position_x+350>=enemy_position_x2&&Leadone.leadone_position_x<=enemy_position_x2+100){
						LR_state_2=0;
						enemy_state[1]=1;
						try {
							   //System.out.println("ksjdfsd");
							   File f=new File(".\\music\\music (30).mp3");
							   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
							   p.prefetch();
							   p.start();
						} catch (Exception e){
							e.printStackTrace();
						}
					}
					if(enemy_fired[1]){
						bullet_e2-=50;
						if(bullet_e2<=-480||(enemy_x2+Background.x-50+bullet_e2<=Leadone.leadone_position_x&&enemy_y2+20>=Leadone.leadone_position_y-30&&enemy_y2+20<=Leadone.leadone_position_y+50)){
							enemy_fired[1]=false;//子弹撞击消失
							//判断打死主角
							if(!Ldie.unbreath&&(enemy_x2+Background.x-50+bullet_e2<=Leadone.leadone_position_x&&enemy_y2+20>=Leadone.leadone_position_y-30&&enemy_y2+20<=Leadone.leadone_position_y+50)){
								Background.is_die=true;
								Background.is_enemy_spark=true;
								Enemy1.bullet_e2=0;
							}
							bullet_e2=0;
							
						}
					}
				break;
					//attack状态
				case 1:
					try{
						Thread.sleep(250);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					state_2++;
					if(state_2==3){
						try {
							   //System.out.println("ksjdfsd");
							   File f=new File(".\\music\\music (3).mp3");
							   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
							   p.prefetch();
							   p.start();
						} catch (Exception e){
							e.printStackTrace();
						}
					}
					if(state_2>3){
						state_2=0;
						enemy_fired[1]=true;
						enemy_state[1]=0;
					}
						
					if(Leadone.leadone_position_x-650>=enemy_position_x2&&Leadone.leadone_position_x-650<=enemy_position_x2+100&&LR_state_2==1){
						enemy_state[1]=2;
					}
					else if(Leadone.leadone_position_x+650>=enemy_position_x2&&Leadone.leadone_position_x+700<=enemy_position_x2+100&&LR_state_2==0){
						enemy_state[1]=2;
					}
					else if(!enemy_fired[1]&&Leadone.leadone_position_x+280>=enemy_position_x2&&Leadone.leadone_position_x<=enemy_position_x2+100){
						LR_state_2=1;
						enemy_state[1]=2;
						state_2=0;
					}
					else if(!enemy_fired[1]&&Leadone.leadone_position_x-180>=enemy_position_x2&&Leadone.leadone_position_x<=enemy_position_x2+180){
						LR_state_2=1;
						enemy_state[1]=1;
						state_2=0;
					}
				break;
					//run状态
				case 2:
					try{
						Thread.sleep(150);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					state_2++;
					if(state_2>4){
						state_2=0;
					}
					if(LR_state_2==1)
						enemy_x2+=10;	
					else if(LR_state_2==0){
						enemy_x2-=10;
					}
					if(Leadone.leadone_position_x-350>=enemy_position_x2&&Leadone.leadone_position_x-350<=enemy_position_x2+100&&LR_state_2==1){
						enemy_state[1]=1;
					}
					else if(Leadone.leadone_position_x+400>=enemy_position_x2&&Leadone.leadone_position_x+400<=enemy_position_x2+100&&LR_state_2==0){
						enemy_state[1]=1;
					}
					else if(Leadone.leadone_position_x+480>=enemy_position_x2&&Leadone.leadone_position_x+480<=enemy_position_x2+100){
						LR_state_2=0;
						
					}
				break;
					//die状态
				case 3:
					try{
						Thread.sleep(200);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					state_2++;
					enemy_y2+=13;
					if(state_2>4){
						state_2=0;
						enemy_life[1]=false;
						enemy_fired[0]=false;//死忙没收武器功能
					}
						
				break;
				}
			}
		//启动敌人状态3
		public void enemy_start_3(){
				//判断敌人状态
				//System.out.println(enemy_state[2]);
				switch(enemy_state[2]){
				//stand状态
				case 0:
					try{
						Thread.sleep(150);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					state_3++;
					if(state_3>1)
						state_3=0;
					if(!enemy_fired[2]&&!bairred_bang_fired&&Leadone.leadone_position_x+450>=enemy_position_x3&&Leadone.leadone_position_x<=enemy_position_x3+100){
						LR_state_3=0;
						enemy_state[2]=1;
					}
					if(enemy_fired[2]){

						if(bullet_e3==0){
							try {
								   //System.out.println("ksjdfsd");
								   File f=new File(".\\music\\music (4).mp3");
								   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
								   p.prefetch();
								   p.start();
							} catch (Exception e){
								e.printStackTrace();
							}
						}
						bullet_e3-=50;//炮弹发射
						if(enemy_y3+20+bullet_y_e3<Leadone.leadone_position_y){
							bullet_y_e3+=15;//追踪主角
							bullet_y_is_fired=true;//y轴坐标追踪成功
						}
						else if(enemy_y3+20+bullet_y_e3>Leadone.leadone_position_y){
							bullet_y_e3-=15;//追踪主角
							bullet_y_is_fired=true;//y轴坐标追踪成功
						}
						if((bullet_e3<-500||((bullet_y_is_fired||enemy_y3+20+bullet_y_e3==Leadone.leadone_position_y)&&enemy_x3+Background.x-80+bullet_e3<=Leadone.leadone_position_x))){
							enemy_fired[2]=false;
							enemy_bullet_position_x3=enemy_x3+Background.x-50+bullet_e3;
							enemy_bullet_position_y3=enemy_y3+20+bullet_y_e3;
							bairred_bang_fired=true;
							//从Ldie中转移
							if(!Ldie.unbreath&&((bullet_y_is_fired||enemy_y3+20+bullet_y_e3==Leadone.leadone_position_y)&&enemy_x3+Background.x-80+bullet_e3<=Leadone.leadone_position_x)){
								Background.is_die=true;
							}
							
							bullet_e3=0;
							bullet_y_e3=0;
						}
						
					}
					if(bairred_bang_fired){//火花爆炸
						boms++;
						if(boms==2){
							try {
								   //System.out.println("ksjdfsd");
								   File f=new File(".\\music\\music (5).mp3");
								   Player p=Manager.createRealizedPlayer(f.toURI().toURL());
								   p.prefetch();
								   p.start();
							} catch (Exception e){
								e.printStackTrace();
							}
						}
						if(boms>4){
							bairred_bang_fired=false;
							boms=1;
						}
					}
				break;
					//attack状态
				case 1:
					try{
						Thread.sleep(250);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					state_3++;
					//调整坐标控制图片位置
					if(state_3==1){
						//enemy_x3-=2;
						enemy_y3+=2;
					}	
					if(state_3==2){
						//enemy_x3-=4;
						enemy_y3-=18;
					}	
					if(state_3==3){
						//enemy_x3-=10;
						enemy_y3-=1;
						
					}
					if(state_3==4){
						enemy_y3+=7;
					}
					if(state_3>4){
						state_3=0;
						enemy_y3+=10;
						enemy_fired[2]=true;
						enemy_state[2]=0;
					}
				
					if(Leadone.leadone_position_x-650>=enemy_position_x3&&Leadone.leadone_position_x-650<=enemy_position_x3+100&&LR_state_3==1){
						enemy_state[2]=2;
					}
					else if(Leadone.leadone_position_x+750>=enemy_position_x3&&Leadone.leadone_position_x+750<=enemy_position_x3+100&&LR_state_3==0){
						enemy_state[2]=2;
					}
					else if(!enemy_fired[2]&&Leadone.leadone_position_x+280>=enemy_position_x3&&Leadone.leadone_position_x+280<=enemy_position_x3+100){
						LR_state_3=1;
						enemy_state[2]=2;
						state_3=0;
					}
				break;
					//run状态
				case 2:
					try{
						Thread.sleep(150);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					state_3++;
					if(state_3>4){
						state_3=0;
					}
					if(LR_state_3==1)
						enemy_x3+=12;	
					else if(LR_state_3==0){
						enemy_x3-=11;
					}
					if(Leadone.leadone_position_x-350>=enemy_position_x3&&Leadone.leadone_position_x-350<=enemy_position_x3+100&&LR_state_3==1){
						enemy_state[2]=1;
					}
					else if(Leadone.leadone_position_x+520>=enemy_position_x3&&Leadone.leadone_position_x+520<=enemy_position_x3+100&&LR_state_3==0){
						enemy_state[2]=1;
					}
					else if(Leadone.leadone_position_x+580>=enemy_position_x3&&Leadone.leadone_position_x+580<=enemy_position_x3+100){
						LR_state_3=0;
						
					}
				break;
					//die状态
				case 3:
					try{
						Thread.sleep(200);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					state_3++;
					enemy_y3+=15;
					if(state_3>4){
						state_3=0;
						enemy_life[2]=false;
						enemy_fired[0]=false;//死忙没收武器功能
					}
						
				break;
				}
			}
		// 敌人生产器
	public void enemy_copy(){
		if(!enemy_life[0]||enemy_position_x1<-100){
			enemy_life[0]=true;
			enemy_x1+=900;
			enemy_y1=374;
			enemy_state[0]=0;
			state_1=0;
			LR_state_1=0;
			}
		if(!enemy_life[1]||enemy_position_x2<-100){
			enemy_life[1]=true;
			enemy_x2+=750;
			enemy_y2=473;
			enemy_state[1]=0;
			state_2=0;
			LR_state_2=0;
			}
		if(!enemy_life[2]||enemy_position_x3<-100){
			enemy_life[2]=true;
			enemy_x3+=600;
			enemy_y3=450;
			enemy_state[2]=0;
			state_3=0;
			LR_state_3=0;
			enemy_fired[2]=false;
			}
		
	}
	//子弹绘
	public void paint_bullet(Graphics g){
		if(enemy_fired[0]){//手雷
			enemy_bullet_position_x1=enemy_x1+Background.x+50+bullet_e1;
			enemy_bullet_position_y1=enemy_y1+10+bullet_y_e1;
			g.drawImage(bom[boms_1],enemy_x1+Background.x+50+bullet_e1,enemy_y1+10+bullet_y_e1,back);
		}
		if(enemy_fired[2]){
			//大炮子弹
			//System.out.println(LR_state_3);
			enemy_bullet_position_x3=enemy_x3+Background.x-50+bullet_e3;
			enemy_bullet_position_y3=enemy_y3+20+bullet_y_e3;
			g.drawImage(bullet[3][LR_state_3],enemy_x3+Background.x-80+bullet_e3,enemy_y3+20+bullet_y_e3,back);
		}
		if(enemy_fired[1]){
			//步枪子弹
			enemy_bullet_position_x2=enemy_x2+Background.x-50+bullet_e2;
			enemy_bullet_position_y2=enemy_y2+20;
			g.drawImage(bullet[0][LR_state_2],enemy_x2+Background.x-50+bullet_e2,enemy_y2+20,back);
		}
		//爆炸
		if(bairred_bang_fired){
			g.drawImage(barrier_bang[boms],enemy_bullet_position_x3,enemy_bullet_position_y3-30,back);
		}
	}

}
