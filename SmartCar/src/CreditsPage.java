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

public class CreditsPage extends GameObject {
ImageBackground ib;
SystemFont sf;
BufferedImage menu;
	public CreditsPage(Main engine) {
		super(engine);
	}

	public void initResources() {
		ib = new ImageBackground(getImage("anu.png"));
		bsMusic.play("FindYou.mid");
		sf = new SystemFont(new Font("Copperlate Gothic Bold", Font.BOLD, 20), Color.BLACK);
		menu = ImageUtil.getImage(bsIO.getURL("pointer.png"),Transparency.TRANSLUCENT);
	}

	public void render(Graphics2D g) {
		ib.render(g);
		sf.drawString(g, "CREDITS", GameFont.CENTER, 0, 150,getWidth());
		sf.drawString(g, "Hai, SMART RIDER !,selamat datang di smart car Game", GameFont.CENTER, 0, 190,getWidth());
		sf.drawString(g, "disini kamu akan mengendalikan mobil yang GAS nya", GameFont.CENTER, 0, 215,getWidth());
		sf.drawString(g, "diatur oleh server mobil masa depan !", GameFont.CENTER, 0, 240,getWidth());
		sf.drawString(g, "kamu harus menjawab pertanyaan dari server agar", GameFont.CENTER, 0, 265,getWidth());
		sf.drawString(g, "kamu bisa menang dari Mobil Computer yang canggih !", GameFont.CENTER, 0, 290,getWidth());
		sf.drawString(g, "So, Let's Thinking SMART RIDER !!! :D", GameFont.CENTER, 0, 315,getWidth());
		sf.drawString(g, "GAME BY : JODDY, AJI, WARYADI, AGUNG", GameFont.CENTER, 0, 340,getWidth());
		sf.drawString(g, "BACK", GameFont.CENTER, 0, 410,getWidth());
	}

	public void update(long elapsedTime) {
		if(bsInput.getKeyPressed() == KeyEvent.VK_ENTER)
		{
			bsSound.play("fireburning.wav");
			this.parent.nextGameID = Main.MENU_PAGE;
			this.finish();
		}
	}

}
