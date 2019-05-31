package group11;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Keys implements KeyListener {
	private Background b=Background.background;
	public static boolean right=true;
	public static boolean left=true;
	public static boolean space=false,move=false,jump=false,squat=false,stand=false,zhadan=false,is_space=false,is_zadan=false;
	public static int buzi=0,squat_buzi=0,ci=2,ci_body=10,ci_space=0;
	
	public void keyPressed(KeyEvent e) {
		//主角发射子弹
		if(e.getKeyCode()==KeyEvent.VK_D){     
			if(!Background.is_die){
				space=true;
				is_space=true;
			}
			move=false;
			jump=false;
			//检测主角开枪
			if((Bullet.bullet_position_x>=Enemy.x1&&Bullet.bullet_position_x<=Enemy.x1+100)||(Bullet.bullet_position_x>=Enemy.x3&&Bullet.bullet_position_x<=Enemy.x3+100)||(Bullet.bullet_position_x>=Enemy.x2&&Bullet.bullet_position_x<=Enemy.x2+100)){
				Enemy.is_fired=true;
			}
			
			if(ci_space>20){
				Leadone.body_type=0;
				Leadone.attack_type=0;
				Leadone.jump_body_type=0;
				Bullet.bullet_type=0;
				ci_space=0;
			}else{
				ci_space++;		
			}			
		}
		 //主角向右走	
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&Leadone.move_x<800 && b.x>-4000){  
			if(!Background.is_die){
				move=true;
			}
			space=false;
			stand=false;
			Leadone.type=1;
			if(Leadone.type_stand<2){
				if(ci_body<0){
					ci_body=10;
					Leadone.type_stand++;
				}else{
					ci_body--;
				}
			}else{
				Leadone.type_stand=0;
			}
			if(buzi<9)	{
				if(ci<0){
					ci=2;
					buzi++;
				}else{  
					ci--;
				}
			}else{
				buzi=0;
			}
			if(squat_buzi<5){
				if(ci<0){
					ci=2;
					squat_buzi++;
				}else{
					ci--;
				}
			}else{
				squat_buzi=0;
			}
			if(!Background.is_die){
				if(Leadone.move_x<300){
					Leadone.move_x+=6;
				}
				//System.out.println(b.x);
				//System.out.println(Enemy_boss_lv.boss_life);
				if((Enemy_boss_lv.boss_life&&(Background.x==-1260||Background.x==-2532||Background.x==-1276))){
					
					Leadone.move_x+=6;
				}
				else  if(Leadone.move_x>200){
					b.x-=4;
				}
				if(b.x<-3900){
					b.x+=4;
					Leadone.move_x+=6;
				} 
			}
			
		}
		 //主角向左走
		else if(e.getKeyCode()==KeyEvent.VK_LEFT&&Leadone.move_x>-80){       
			if(!Background.is_die){
				move=true;
			}
			space=false;
			stand=false;
			Leadone.type=0;
			if(Leadone.type_stand<2){
				if(ci_body<0){
					ci_body=10;
					Leadone.type_stand++;
				}else{
					ci_body--;
				}
			}else{
				Leadone.type_stand=0;
			}
			if(buzi<9)	{
				if(ci<0){
					ci=2;
					buzi++;
				}
				else{  
					ci--;
				}
			}else buzi=0;
			if(squat_buzi<5){
				if(ci<0){
					ci=2;
					squat_buzi++;
				}else{
					ci--;
				}
			}else{
				squat_buzi=0;
			}
			if(!Background.is_die)
				Leadone.move_x-=5;
		}
		  //主角跳跃
		else if(e.getKeyCode()==KeyEvent.VK_UP){   
			if(!Background.is_die){
				jump=true;
			}
			move=false;
			space=false;
			stand=false;
			squat=false;
		}
		//主角蹲下
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){     
			if(!Background.is_die){
				squat=true;	
			}
			Leadone.squat_y=15;
		}
		//主角扔炸弹
		if(e.getKeyCode()==KeyEvent.VK_F){
			if(!Background.is_die){
				zhadan=true;
				is_zadan=true;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE ){
			if(!Background.is_die){
				stand=true;	
			}
			move=false;
			Enemy.is_fired=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN ){
			squat=false;
			Leadone.squat_y=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP ){
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT ){
			if(!Background.is_die){
				stand=true;	
			}
			move=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(!Background.is_die){
				stand=true;	
			}
			move=false;
		}
	}
	public void keyTyped(KeyEvent e) {	
	}
}
