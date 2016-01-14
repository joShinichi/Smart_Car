import java.awt.Dimension;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.GameObject;

public class Main extends GameEngine {
	{
		distribute = true;
	}

	public final static int GAME_PAGE = 1;
	public final static int MENU_PAGE = 2;
	public final static int CRED_PAGE = 3;

	public GameObject getGame(int ID) {
		switch (ID)

		{
		case GAME_PAGE:
			return new GamePage(this);
		case MENU_PAGE:
			return new MenuPage(this);
		case CRED_PAGE:
			return new CreditsPage(this);
		}
		return new MenuPage(this);
	}

	public static void main(String[] args) {
		GameLoader gl = new GameLoader();
		gl.setup(new Main(), new Dimension(640, 480), true);
		gl.start();
	}

}
