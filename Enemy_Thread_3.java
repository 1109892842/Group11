package group11;
public class Enemy_Thread_3 extends Thread{
	Enemy enemy=new Enemy();
	
	public Enemy_Thread_3() {
		this.start();
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(0);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			enemy.Starting();
			enemy.enemy_star();
			Bullet.e_x+=80;
			if(Bullet.e_x1<450&&Enemy.e_fired1){
				Bullet.e_x1+=30;
				Enemy.E_type[1]=0;
			}
			if(Bullet.e_x1>=450||(Background.is_found&&Bullet.enemy_bullet_position_x>=Leadone.leadone_position_x-20&&Bullet.enemy_bullet_position_x <=Leadone.leadone_position_x+150&&Bullet.enemy_bullet_position_y >=Leadone.leadone_position_y-10&&Bullet.enemy_bullet_position_y<=Leadone.leadone_position_y+100)){
				Enemy.E_type[1]=3;
				Bullet.e_x1=0;
				if(!Ldie.unbreath&&(Background.is_found&&Bullet.enemy_bullet_position_x>=Leadone.leadone_position_x-20&&Bullet.enemy_bullet_position_x <=Leadone.leadone_position_x+150&&Bullet.enemy_bullet_position_y >=Leadone.leadone_position_y-10&&Bullet.enemy_bullet_position_y<=Leadone.leadone_position_y+100) ){
					Background.is_die=true;
					Background.is_enemy_spark=true;
					Enemy1.bullet_e1=0;
				}
			}
			if(Enemy.a1==15){
				Bullet.e_x=0;
			}
			
		}
	}

}