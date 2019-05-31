package alloyContra;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Truck{
	private Background b= Background.background;
	public static int plane_x=0,plane_y=0,p_x=0,p_y=0,plane_type=1,ci_plane=0;
	public static boolean is_plane=true;
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image[] plane=new Image[7];{                   //·É»úÍ¼Æ¬
		for(int i=0;i<7;i++){
			plane[i]=kit.getImage("img\\plane"+i+".png");
		}
	}
	//·É»ú·É
	public void fly_plane(Graphics g){
		if(plane_x<300){
			plane_x++;
		}else{
			if(plane_y<300){
				g.drawImage(plane[5], plane_x+100, 160, b);
				g.drawImage(plane[6], plane_x+100, 100+plane_y, b);
				plane_y++;
			}else{
				Keys.stand=true;
				if(plane_x>1000){
					is_plane=false;
				}
				plane_x++;
			}
		}
		g.drawImage(plane[0], -20+plane_x, 80, b);
		if(plane_type==1){
			p_x=-25;
			p_y=0;
		}else if(plane_type==2){
			p_x=55;
			p_y=0;		
		}
		g.drawImage(plane[plane_type], 50+plane_x+p_x, 80+p_y, b);
		if(plane_type<3){
			if(ci_plane<6){
				ci_plane++;
			}else{
				plane_type++;
				ci_plane=0;
			}
		}else{
			plane_type=1;
		}
	}
}
