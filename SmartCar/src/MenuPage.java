import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.background.ImageBackground;
import com.golden.gamedev.object.font.SystemFont;
import com.golden.gamedev.util.ImageUtil;

public class MenuPage extends GameObject {
int index = 0;
ImageBackground ib;
SystemFont sf;
BufferedImage menu;
	public MenuPage(Main engine) {
		super(engine);
	}

	public void initResources() {
		ib = new ImageBackground(getImage("anu.png"));
//		bsMusic.play("FindYou.mid");
		sf = new SystemFont(new Font("04b", Font.BOLD, 25), Color.BLACK);
		menu = ImageUtil.getImage(bsIO.getURL("pointer.png"),Transparency.TRANSLUCENT);
	}

	public void render(Graphics2D g) {
		ib.render(g);
		g.drawImage(menu, 400, 210+(index*50),null);
		sf.drawString(g, "PLAY GAME",GameFont.CENTER, 0, 210,getWidth());
		sf.drawString(g, "CREDITS",GameFont.CENTER, 0, 260,getWidth());
		sf.drawString(g, "EXIT GAME",GameFont.CENTER, 0, 310,getWidth());
	}

	public void update(long elapsedTime) {
		ib.update(elapsedTime);
		if(bsInput.getKeyPressed() == KeyEvent.VK_DOWN)
		{
			bsSound.play("fireburning.wav");
			index++;
			if(index > 2) index = 0;
		}
		else if(bsInput.getKeyPressed() == KeyEvent.VK_UP)
		{
			bsSound.play("fireburning.wav");
			index--;
			if(index < 0) index = 2;
		}
		if(bsInput.getKeyPressed() == KeyEvent.VK_ENTER)
		{
			if(index == 0)
			{
				this.parent.nextGameID = Main.GAME_PAGE;
				this.finish();
			}
			else if(index == 1)
			{
				this.parent.nextGameID = Main.CRED_PAGE;
				this.finish();
			}
			else if (index == 2)
			{
				this.finish();
			}
		}
	}

}
