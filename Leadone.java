package alloyContra;

import java.awt.*;
import javax.swing.*;

public class Leadone extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int type=1, type_knife=0,type_bullet=0,type_stand=0,type_jump=0,type_squat=0,move_x=0,move_y=0,squat_y=0;
	public static int body_type=0,attack_type=0,jump_body_type=0,leadone_position_x=0,leadone_position_y=0;
	private Toolkit kit=Toolkit.getDefaultToolkit();
	//主角用刀时上半身
	private Image[][] knife=new  Image[6][2];{
		for(int i=0;i<6;i++){
			for(int j=0;j<2;j++){
				knife[i][j]=kit.getImage("img\\knife"+i+j+".png");	
			}
		}
	}
	//主角开枪时上半身
	private Image[][][] attack=new Image[2][6][2];{        
		for(int i=0;i<2;i++){
			for(int j=0;j<6;j++){
				for(int k=0;k<2;k++){
					attack[i][j][k]=kit.getImage("img\\attack"+i+j+k+".png");
				}
			}
		}
	}
	//主角站着时上半身
	private Image[][][] body=new Image[2][7][2];{          
		for(int i=0;i<2;i++){
			for(int j=0;j<7;j++){
				for(int k=0;k<2;k++){
					body[i][j][k]=kit.getImage("img\\body"+i+j+k+".png");
				}
			}
		}
	}
    //主角跳跃时上半身
	private Image[][][] jump_body=new Image[2][8][2];{    
		for(int i=0;i<2;i++){
			for(int j=0;j<8;j++){
				for(int k=0;k<2;k++){
					jump_body[i][j][k]=kit.getImage("img\\jump_body"+i+j+k+".png");
				}
			}
		}
	}
	  //跳跃的图片
	private Image[][] jump_leg=new Image[8][2];{           
		for(int i=0;i<8;i++){
			for(int j=0;j<2;j++){
				jump_leg[i][j]=kit.getImage("img\\jump_leg"+i+j+".png");
			}
		}
	}
	//蹲下的图片
	private Image[] squat_stand=new Image[2];{            
		for(int i=0;i<2;i++){
			squat_stand[i]=kit.getImage("img\\squat_stand"+i+".png");
		}
	}
    //蹲下跑的图片
	private Image[][] squat_run=new Image[6][2];{       
		for(int i=0;i<6;i++){
			for(int j=0;j<2;j++){
				squat_run[i][j]=kit.getImage("img\\squat_run"+i+j+".png");
			}
		}
	}
	  //跑的图片
	private Image[][] run=new Image[10][2];{        
		for(int i=0;i<10;i++){
			for(int j=0;j<2;j++){
				run[i][j]=kit.getImage("img\\run"+i+j+".png");
			}
		}
	}	
	//站着的图片
	private Image[] stand=new Image[2];{          
		for(int i=0;i<2;i++){
			stand[i]=kit.getImage("img\\stand"+i+".png");
		}
	}	
	
	public Leadone(){	
		
	}

	
	//站着
	public void stand(Graphics g){             
		int body_width,leg_width;
		body_width=body[body_type][type_stand][type].getWidth(this);
		leg_width=stand[type].getWidth(this);
		if(type==1)
			g.drawImage(body[body_type][type_stand][type],move_x+105,move_y+squat_y+473,b);
		else
			g.drawImage(body[body_type][type_stand][type],move_x+78,move_y+squat_y+473,b);
		if(Keys.squat)
			g.drawImage(squat_stand[type], move_x+100+(body_width-leg_width-16)/2,move_y+473+45,b);
		else
			g.drawImage(stand[type], move_x+100+(body_width-leg_width-16)/2,move_y+473+45,b);          //优化位置
		
	}
	//主角移动
	public void move(Graphics g){              
		int body_width,leg_width;
		body_width=body[body_type][type_stand][type].getWidth(this);
		leg_width=run[Keys.buzi][type].getWidth(this);
		if(type==1){
			g.drawImage(body[body_type][type_stand][type],move_x+105,move_y+squat_y+473,b);
		}else
			g.drawImage(body[body_type][type_stand][type],move_x+78,move_y+squat_y+473,b);
		if(Keys.squat){
			leg_width=squat_run[Keys.squat_buzi][type].getWidth(this);
			g.drawImage(squat_run[Keys.squat_buzi][type], move_x+103+(body_width-leg_width-16)/2,move_y+473+45,b);        	
		}
		else
			g.drawImage(run[Keys.buzi][type], move_x+100+(body_width-leg_width-16)/2,move_y+473+45,b);          //优化位置
		leadone_position_x=move_x+100+(body_width-leg_width-16)/2;
		leadone_position_y=move_y+473+45;
	}
	//主角开枪
	public void  attack(Graphics g){
		int body_width,leg_width;
		leg_width=stand[type].getWidth(this);
		if(is_knife){
				body_width=knife[type_knife][type].getWidth(this);
				if(type==1){
					g.drawImage(knife[type_knife][type],move_x+100,move_y+squat_y+482,b);
				}else{
					g.drawImage(knife[type_knife][type],move_x+54,move_y+squat_y+482,b);
				}
		}else{
			body_width=attack[attack_type][type_bullet][type].getWidth(this);
			if(type==1){
				g.drawImage(attack[attack_type][type_bullet][type],move_x+96,move_y+squat_y+473,b);
			}else{
				g.drawImage(attack[attack_type][type_bullet][type],move_x+50,move_y+squat_y+473,b);	
			}
		}
		if(Keys.squat)
			g.drawImage(squat_stand[type], move_x+84+(body_width-leg_width-16)/2,move_y+473+45,b);
		else
			g.drawImage(stand[type], move_x+84+(body_width-leg_width-16)/2,move_y+473+45,b);     //优化位置
	}
	//主角跳跃
	public void jump(Graphics g){
		int body_width,leg_width;
		body_width=jump_body[jump_body_type][type_jump][type].getWidth(this);
		leg_width=jump_leg[type_jump][type].getWidth(this);
		if(type==1){
			g.drawImage(jump_body[jump_body_type][type_jump][type],move_x+75,move_y+473,b);
		}else
			g.drawImage(jump_body[jump_body_type][type_jump][type],move_x+75,move_y+473,b);
			
		g.drawImage(jump_leg[type_jump][type], move_x+84+(body_width-leg_width-16)/2,move_y+473+45,b);     //优化位置
	}
}

