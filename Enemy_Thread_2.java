package group11;

public class Enemy_Thread_2 extends Thread{
	Enemy1 enemy1=new Enemy1();
	public Enemy_Thread_2() {
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
			enemy1.enemy_start_3();
		}
	}

}
