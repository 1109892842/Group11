package group11;

public class Un_breath extends Thread {

	public Un_breath() {
		this.start();
	}
	public void run(){
		while(true)
		if(Ldie.unbreath){
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
