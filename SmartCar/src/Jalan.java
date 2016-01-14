import java.awt.Graphics2D;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.AnimatedSprite;

public class Jalan extends Game {
	{
		distribute = true;
	}
AnimatedSprite jalan;

	public void initResources() {
		jalan = new AnimatedSprite(getImages("jalanan.png",8,2),150,200);
		jalan.setAnimate(true);
		jalan.setLoopAnim(true);
		jalan.setAnimationFrame(0, 7);
	}

	public void render(Graphics2D g) {
		jalan.render(g);
	}

	public void update(long elapsedTime) {
		jalan.update(elapsedTime);
	}

}
