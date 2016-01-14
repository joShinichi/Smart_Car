import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.util.Random;
import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;

import javax.swing.JOptionPane;

import org.w3c.dom.css.Counter;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.GameObject;
import com.golden.gamedev.gui.TButton;
import com.golden.gamedev.gui.TLabel;
import com.golden.gamedev.gui.TPanel;
import com.golden.gamedev.gui.toolkit.FrameWork;
import com.golden.gamedev.gui.toolkit.UIConstants;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.background.ColorBackground;
import com.golden.gamedev.object.background.ImageBackground;
import com.golden.gamedev.object.background.ParallaxBackground;
import com.golden.gamedev.object.background.TileBackground;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.font.SystemFont;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;
import com.golden.gamedev.util.Utility;

public class GamePage extends GameObject {
ColorBackground cb;
boolean show = true;
Sprite jalanan,jalan1,car1, car2, finish,finish2,finish3,life,life1b,life1c,jalan_finish_lose,jalan_finish_win;
SpriteGroup mobil1, mobil2,road1,road2,finish1,life1,life2,life3,finish_life,jalan_finish,jalanan_finish_win;
ImageBackground ib;
PlayField pf;
Timer time,time2;
SystemFont sf;
TPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9;
public TButton button1a,button1b,button1c,button1d,
		button2a,button2b,button2c,button2d,
		button3a,button3b,button3c,button3d,
		button4a,button4b,button4c,button4d,
		button5a,button5b,button5c,button5d,
		button6a,button6b,button6c,button6d,
		button7a,button7b,button7c,button7d,
		button8a,button8b,button8c,button8d,
		button9a,button9b,button9c,button9d;

FrameWork framework;
public int detik = 300;
public int penampung;
public int penampung1,penampung1a,penampung1b;
public int penampung2,penampung2a,penampung2b,penampung2c;
public int penampung3,penampung4,penampung5,penampung3a,penampung3b,penampung3c
,penampung3d,penampung3e,
penampung4a,penampung4b,penampung4c,penampung4d,penampung4e,penampung4f,
penampung4g,penampung4h,penampung4i,
penampung5a,penampung5b,penampung5c,penampung5d,penampung5e,penampung5f,penampung5g,
penampung5h,penampung5i,penampung5j,penampung5k,penampung5l,penampung5m,penampung5n,
penampung5o,penampung5p,penampung5q,penampung5r,penampung5s,penampung6,
penampung6a,penampung6b,penampung6c,penampung6d,penampung6e,penampung6f,
penampung6g,penampung6h,penampung6i,penampung6j,penampung6k;

// yang diatas adalah object yang akan di isi resources....

int counter = 3;
public String skor,skor1;

	public GamePage(Main engine) {
		super(engine);
	}

	public void initResources() {
		cb = new ColorBackground(Color.BLACK);
		ib = new ImageBackground(getImage("anu.png"));
		time = new Timer(1000);
		time2 = new Timer(1000);
		sf = new SystemFont(new Font("04b", Font.BOLD, 30),Color.BLACK);
		framework = new FrameWork(bsInput, getWidth(), getHeight());		
		bsInput.setMouseVisible(true);
		panel1 = new TPanel(20, 80, 200, 200);
		panel1.add(new TLabel("ayah budi memiliki buah jeruk", 10, -30, 300, 100));
		panel1.add(new TLabel("sebanyak 10 buah,kemudian", 10, -15, 300, 100));
		panel1.add(new TLabel("di bagikan kepada 3 anak", 10, 0, 300, 100));
		panel1.add(new TLabel("masing - masing 3 buah", 10, 15, 300, 100));
		panel1.add(new TLabel("berapakah sisa buah yang", 10, 30, 300, 100));
		panel1.add(new TLabel("dimiliki ayah budi ?", 10, 45, 300, 100));
		button1a = new TButton("1", 20, 300, 80, 50);
		button1b = new TButton("2", 130, 300, 80, 50);
		button1c = new TButton("3", 20, 400, 80, 50);
		button1d = new TButton("7", 130, 400, 80, 50);
		
		panel2 = new TPanel(20, 80, 200, 200);
		panel2.add(new TLabel("2 + 1 + 3 + 1 + 4 + 1 + 1", 10, -30, 300, 100));
		panel2.add(new TLabel("+ 1 + 5 + 1 + 1 X 0 + 2", 10, -15, 300, 100));
		panel2.add(new TLabel("+ 1 X 0 + 1 + 1 = ?", 10, 0, 300, 100));
		button2a = new TButton("3", 20, 300, 80, 50);
		button2b = new TButton("2", 130, 300, 80, 50);
		button2c = new TButton("25", 20, 400, 80, 50);
		button2d = new TButton("0", 130, 400, 80, 50);
		
		panel3 = new TPanel(20, 80, 205, 230);
		panel3.add(new TLabel("Paman Gapeto dan", 10, -30, 300, 100));
		panel3.add(new TLabel("Paman Sapri mempunyai", 10, -15, 300, 100));
		panel3.add(new TLabel("tanah. Jika Paman", 10, 0, 300, 100));
		panel3.add(new TLabel("Gapeto mempunyai tanah", 10, 15, 300, 100));
		panel3.add(new TLabel("berbentuk persegi panjang", 10, 30, 300, 100));
		panel3.add(new TLabel("dengan panjang 50 m", 10, 45, 300, 100));
		panel3.add(new TLabel("dan lebar 40 m,", 10, 60, 300, 100));
		panel3.add(new TLabel("Serta Paman Sapri", 10, 75, 300, 100));
		panel3.add(new TLabel("mempunyai bentuk yang", 10, 90, 300, 100));
		panel3.add(new TLabel("sama tapi memiliki", 10, 105, 300, 100));
		panel3.add(new TLabel("panjang dan lebar yang", 10, 120, 300, 100));
		panel3.add(new TLabel("berbeda dengan panjang 80 M", 10, 135, 300, 100));
		panel3.add(new TLabel("dan lebar 50 m. berapakah", 10, 150, 300, 100));
		panel3.add(new TLabel("selisih Luas Tanah mereka ?", 10, 165, 300, 100));
		button3a = new TButton("100", 20, 330, 80, 50);
		button3b = new TButton("250", 130, 330, 80, 50);
		button3c = new TButton("20", 20, 400, 80, 50);
		button3d = new TButton("200", 130, 400, 80, 50);
		
		panel4 = new TPanel(20, 80, 210, 200);
		panel4.add(new TLabel("Sebuah keluarga besar", 10, -30, 300, 100));
		panel4.add(new TLabel("terdiri dari suami istri,", 10, -15, 300, 100));
		panel4.add(new TLabel("8 anak laki-laki dan", 10, 0, 300, 100));
		panel4.add(new TLabel("masing-masing anak laki-laki", 10, 15, 300, 100));
		panel4.add(new TLabel("mempunyai satu saudara pere", 10, 30, 300, 100));
		panel4.add(new TLabel("mpuan.Berapa orang yang ada", 10, 45, 300, 100));
		panel4.add(new TLabel("di keluarga tersebut??", 10, 60, 300, 100));
		button4a = new TButton("10", 20, 300, 80, 50)
				{
			public void doAction()
			{
				penampung1 = counter - 1;
				penampung1a = penampung - 1;
				
				if(penampung1 == 2)
				{
					life.setActive(false);
				}
				else if(penampung1 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung1 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung1a == 2)
				{
					life.setActive(false);
				}
				else if(penampung1a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung1a == 0)
				{
					life1c.setActive(false);
				}
				
				
			}
				};
		button4b = new TButton("18", 130, 300, 80, 50)
		{
			public void doAction()
			{
				penampung1 = counter - 1;
				penampung1a = penampung - 1;
				if(penampung1 == 2)
				{
					life.setActive(false);
				}
				else if(penampung1 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung1 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung1a == 2)
				{
					life.setActive(false);
				}
				else if(penampung1a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung1a == 0)
				{
					life1c.setActive(false);
				}
				
				
			}
				};
		button4c = new TButton("11", 20, 400, 80, 50);
		button4d = new TButton("16", 130, 400, 80, 50)
		{
			public void doAction()
			{
				penampung1 = counter - 1;
				penampung1a = penampung - 1;
				if(penampung1 == 2)
				{
					life.setActive(false);
				}
				else if(penampung1 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung1 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung1a == 2)
				{
					life.setActive(false);
				}
				else if(penampung1a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung1a == 0)
				{
					life1c.setActive(false);
				}
				
				
			}
				};
		
		panel5 = new TPanel(20, 80, 200, 200);
		panel5.add(new TLabel("mana yang lebih berat ?", 10, -30, 300, 100));
		panel5.add(new TLabel("50kg kapas ?", 10, -15, 300, 100));
		panel5.add(new TLabel("atau 50Kg besi ?", 10, 0, 300, 100));		
		button5a = new TButton("kapas", 20, 300, 80, 50)
				{
			public void doAction()
			{
				penampung2 = counter - 1;
				penampung2a = penampung1 - 1;
				penampung2b = penampung1a - 1;
				penampung2c = penampung - 1;
				
				if(penampung2 == 2)
				{
					life.setActive(false);
				}
				else if(penampung2 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2 == 1)
				{
					life1c.setActive(false);
				}
				
				if(penampung2a == 2)
				{
					life.setActive(false);
				}
				else if(penampung2a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2a == 1)
				{
					life1c.setActive(false);
				}
				
				if(penampung2b == 2)
				{
					life.setActive(false);
				}
				else if(penampung2b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2b == 1)
				{
					life1c.setActive(false);
				}
				
				if(penampung2c == 2)
				{
					life.setActive(false);
				}
				else if(penampung2c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2c == 1)
				{
					life1c.setActive(false);
				}
				
				
			}
				};
		button5b = new TButton("besi", 130, 300, 80, 50)
		{
			public void doAction()
			{
				penampung2 = counter - 1;
				penampung2a = penampung1 - 1;
				penampung2b = penampung1a - 1;
				penampung2c = penampung - 1;
				
				if(penampung2 == 2)
				{
					life.setActive(false);
				}
				else if(penampung2 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung2a == 2)
				{
					life.setActive(false);
				}
				else if(penampung2a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2a == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung2b == 2)
				{
					life.setActive(false);
				}
				else if(penampung2b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2b == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung2c == 2)
				{
					life.setActive(false);
				}
				else if(penampung2c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2c == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		button5c = new TButton("keduanya", 20, 400, 80, 50);
		button5d = new TButton("....", 130, 400, 80, 50)
		{
			public void doAction()
			{
				penampung2 = counter - 1;
				penampung2a = penampung - 1;
				penampung2b = penampung1 - 1;
				penampung2c = penampung1b - 1;
				
				if(penampung2 == 2)
				{
					life.setActive(false);
				}
				else if(penampung2 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2 == 1)
				{
					life1c.setActive(false);
				}
				
				if(penampung2a == 2)
				{
					life.setActive(false);
				}
				else if(penampung2a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2a == 1)
				{
					life1c.setActive(false);
				}
				
				if(penampung2b == 2)
				{
					life.setActive(false);
				}
				else if(penampung2b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2b == 1)
				{
					life1c.setActive(false);
				}
				
				if(penampung2c == 2)
				{
					life.setActive(false);
				}
				else if(penampung2c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung2c == 1)
				{
					life1c.setActive(false);
				}
			}
				};
		panel6 = new TPanel(20, 80, 210, 200);
		panel6.add(new TLabel("ada 12 bola di atas", 10, -30, 300, 100));
		panel6.add(new TLabel("nampan, dan kamu meng", 10, -15, 300, 100));
		panel6.add(new TLabel("ambil 7 bola dari", 10, 0, 300, 100));
		panel6.add(new TLabel("nampan tersebut,", 10, 15, 300, 100));
		panel6.add(new TLabel("berapa bola yang ada", 10, 30, 300, 100));
		panel6.add(new TLabel("di tangan mu sekarang ?", 10, 45, 300, 100));
		button6a = new TButton("5", 20, 300, 80, 50)
				{
			public void doAction()
			{
				penampung3 = counter - 1;
				penampung3a = penampung2 - 1;
				penampung3b = penampung3 - 1;
				penampung3c = penampung2a - 1;
				penampung3d = penampung2b - 1;
				penampung3e = penampung2c - 1;
				
				if(penampung3 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3 == 2)
				{
					life.setActive(false);
				}
				else if(penampung3 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3a == 2)
				{
					life.setActive(false);
				}
				else if(penampung3a == 0)
				{
					life1c.setActive(false);
				}
//				else if(penampung3a == -1)
//				{
//					life1b.setActive(false);
//				}
				if(penampung3b == 2)
				{
					life.setActive(false);
				}
				else if(penampung3b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3b == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3c == 2)
				{
					life.setActive(false);
				}
				else if(penampung3c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3d == 2)
				{
					life.setActive(false);
				}
				else if(penampung3d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3e == 2)
				{
					life.setActive(false);
				}
				else if(penampung3e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3e == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		button6b = new TButton("7", 130, 300, 80, 50);
		button6c = new TButton("12", 20, 400, 80, 50)
		{
			public void doAction()
			{
				penampung3 = counter - 1;
				penampung3a = penampung2 - 1;
				penampung3b = penampung3 - 1;
				penampung3c = penampung2a - 1;
				penampung3d = penampung2b - 1;
				penampung3e = penampung2c - 1;
				
				if(penampung3 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3 == 2)
				{
					life.setActive(false);
				}
				else if(penampung3 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3a == 2)
				{
					life.setActive(false);
				}
				else if(penampung3a == 0)
				{
					life1c.setActive(false);
				}
//				else if(penampung3a == -1)
//				{
//					life1b.setActive(false);
//				}
				if(penampung3b == 2)
				{
					life.setActive(false);
				}
				else if(penampung3b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3b == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3c == 2)
				{
					life.setActive(false);
				}
				else if(penampung3c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3d == 2)
				{
					life.setActive(false);
				}
				else if(penampung3d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3e == 2)
				{
					life.setActive(false);
				}
				else if(penampung3e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3e == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		button6d = new TButton("6", 130, 400, 80, 50)
		{
			public void doAction()
			{
				penampung3 = counter - 1;
				penampung3a = penampung2 - 1;
				penampung3b = penampung3 - 1;
				penampung3c = penampung2a - 1;
				penampung3d = penampung2b - 1;
				penampung3e = penampung2c - 1;
				
				if(penampung3 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3 == 2)
				{
					life.setActive(false);
				}
				else if(penampung3 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3a == 2)
				{
					life.setActive(false);
				}
				else if(penampung3a == 0)
				{
					life1c.setActive(false);
				}
//				else if(penampung3a == -1)
//				{
//					life1b.setActive(false);
//				}
				if(penampung3b == 2)
				{
					life.setActive(false);
				}
				else if(penampung3b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3b == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3c == 2)
				{
					life.setActive(false);
				}
				else if(penampung3c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3d == 2)
				{
					life.setActive(false);
				}
				else if(penampung3d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung3e == 2)
				{
					life.setActive(false);
				}
				else if(penampung3e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung3e == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		
		panel7 = new TPanel(20, 80, 210, 200);
		panel7.add(new TLabel("planet apakah yang", 10, -30, 300, 100));
		panel7.add(new TLabel("memiliki ciri khas", 10, -15, 300, 100));
		panel7.add(new TLabel("cincin di sekililing", 10, 0, 300, 100));
		panel7.add(new TLabel("planet nya ?", 10, 15, 300, 100));
		button7a = new TButton("Saturnus", 20, 300, 80, 50);
		button7b = new TButton("Uranus", 130, 300, 80, 50)
				{
			public void doAction()
			{
				penampung4 = counter - 1;
				penampung4a = penampung - 1;
				penampung4b = penampung1 - 1;
				penampung4c = penampung2 - 1;
				penampung4d = penampung3 - 1;
				penampung4e = penampung3a - 1;
				penampung4f = penampung3b - 1;
				penampung4g = penampung3c - 1;
				penampung4h = penampung3d - 1;
				penampung4i = penampung3e - 1;
				
				if(penampung4 == 2)
				{
					life.setActive(false);
				}
				else if(penampung4 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4 == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung4a == 2)
				{
					life.setActive(false);
				}
				else if(penampung4a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4a == 0)
				{
					life1c.setActive(false);
				}
			
				
				
				if(penampung4b == 2)
				{
					life.setActive(false);
				}
				else if(penampung4b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4b == 0)
				{
					life1c.setActive(false);
				}
				
				
				if(penampung4c == 2)
				{
					life.setActive(false);
				}
				else if(penampung4c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4c == 0)
				{
					life1c.setActive(false);
				}
			
				
				if(penampung4d == 2)
				{
					life.setActive(false);
				}
				else if(penampung4d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4d == 0)
				{
					life1c.setActive(false);
				}
				
				
				if(penampung4e == 2)
				{
					life.setActive(false);
				}
				else if(penampung4e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4e == 0)
				{
					life1c.setActive(false);
				}
			
				
				
				if(penampung4f == 2)
				{
					life.setActive(false);
				}
				else if(penampung4f == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4f == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung4g == 2)
				{
					life.setActive(false);
				}
				else if(penampung4g == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4g == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung4h == 2)
				{
					life.setActive(false);
				}
				else if(penampung4h == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4h == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung4i == 2)
				{
					life.setActive(false);
				}
				else if(penampung4i == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4i == 0)
				{
					life1c.setActive(false);
				}
			
				
				
			}
				};
		button7c = new TButton("Neptunus", 20, 400, 80, 50)
		{
			public void doAction()
			{
				penampung4 = counter - 1;
				penampung4a = penampung3 - 1;
				penampung4b = penampung2 - 1;
				penampung4c = penampung1 - 1;
				
				if(penampung4 == 2)
				{
					life.setActive(false);
				}
				else if(penampung4 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4 == 0)
				{
					life1c.setActive(false);
				}
				
//				if(penampung4a == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4a == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4a == 0)
//				{
//					life1c.setActive(false);
//				}
//				
				if(penampung4b == 2)
				{
					life.setActive(false);
				}
				else if(penampung4b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4b == 0)
				{
					life1c.setActive(false);
				}
				
//				if(penampung4c == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4c == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4c == 0)
//				{
//					life1c.setActive(false);
//				}
//				else if(penampung4c == -1)
//				{
//					life1c.setActive(false);
//				}
			}
				};
		button7d = new TButton("Jupiter", 130, 400, 80, 50)
		{
			public void doAction()
			{
				penampung4 = counter - 1;
				penampung4a = penampung3 - 1;
				penampung4b = penampung2 - 1;
				penampung4c = penampung1 - 1;
				
				if(penampung4 == 2)
				{
					life.setActive(false);
				}
				else if(penampung4 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4 == 0)
				{
					life1c.setActive(false);
				}
				
//				if(penampung4a == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4a == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4a == 0)
//				{
//					life1c.setActive(false);
//				}
//				
				if(penampung4b == 2)
				{
					life.setActive(false);
				}
				else if(penampung4b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung4b == 0)
				{
					life1c.setActive(false);
				}
				
//				if(penampung4c == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4c == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4c == 0)
//				{
//					life1c.setActive(false);
//				}
//				else if(penampung4c == -1)
//				{
//					life1c.setActive(false);
//				}
			}
				};
		
		panel8 = new TPanel(20, 80, 210, 200);
		panel8.add(new TLabel("ber genre apakah game", 10, -30, 300, 100));
		panel8.add(new TLabel("smart car yang kalian", 10, -15, 300, 100));
		panel8.add(new TLabel("mainkan ?", 10, 0, 300, 100));
		panel8.add(new TLabel("(BONUS) !!", 10, 15, 300, 100));
		button8a = new TButton("FUN !!", 20, 300, 80, 50)
				{
			public void doAction()
			{
				penampung5 = counter - 1;
				penampung5a = penampung - 1;
				penampung5b = penampung1 - 1;
				penampung5c = penampung2 - 1;
				penampung5d = penampung3 - 1;
				penampung5e = penampung4 - 1;
				penampung5f = penampung1a - 1;
				penampung5g = penampung1b - 1;
				penampung5h = penampung2a - 1;
				penampung5i = penampung2b - 1;
				penampung5j = penampung2c - 1;
				penampung5k = penampung3a - 1;
				penampung5l = penampung3b -1 ;
				penampung5m = penampung3c - 1;
				penampung5n = penampung4a - 1;
				penampung5o = penampung4b - 1;
				penampung5p = penampung4c - 1;
				penampung5q = penampung4d - 1;
				penampung5r = penampung4e - 1;
				penampung5s = penampung4f - 1;
				
				if(penampung5 == 2)
				{
					life.setActive(false);
				}
				else if(penampung5 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5 == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung5a == 2)
				{
					life.setActive(false);
				}
				else if(penampung5a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5a == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung5b == 2)
				{
					life.setActive(false);
				}
				else if(penampung5b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5b == 0)
				{
					life1c.setActive(false);
				}

				
				if(penampung5c == 2)
				{
					life.setActive(false);
				}
				else if(penampung5c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5d == 2)
				{
					life.setActive(false);
				}
				else if(penampung5d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5e == 2)
				{
					life.setActive(false);
				}
				else if(penampung5e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5e == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5f == 2)
				{
					life.setActive(false);
				}
				else if(penampung5f == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5f == 0)
				{
					life1c.setActive(false);
				}
				
				
				if(penampung5g == 2)
				{
					life.setActive(false);
				}
				else if(penampung5g == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5g == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5h == 2)
				{
					life.setActive(false);
				}
				else if(penampung5h == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5h == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5i == 2)
				{
					life.setActive(false);
				}
				else if(penampung5i == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5i == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5j == 2)
				{
					life.setActive(false);
				}
				else if(penampung5j == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5j == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5k == 2)
				{
					life.setActive(false);
				}
				else if(penampung5k == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5k == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5l == 2)
				{
					life.setActive(false);
				}
				else if(penampung5l == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5l == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5m == 2)
				{
					life.setActive(false);
				}
				else if(penampung5m == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5m == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5n == 2)
				{
					life.setActive(false);
				}
				else if(penampung5n == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5n == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung5o == 2)
				{
					life.setActive(false);
				}
				else if(penampung5o == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5o == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5p == 2)
				{
					life.setActive(false);
				}
				else if(penampung5p == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5p == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5q == 2)
				{
					life.setActive(false);
				}
				else if(penampung5q == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5q == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5r == 2)
				{
					life.setActive(false);
				}
				else if(penampung5r == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5r == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5s == 2)
				{
					life.setActive(false);
				}
				else if(penampung5s == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5s == 0)
				{
					life1c.setActive(false);
				}
			}
				};
				
		button8b = new TButton("Education", 130, 300, 80, 50)
		{
			public void doAction()
			{
				penampung5 = counter - 1;
				penampung5a = penampung - 1;
				penampung5b = penampung1 - 1;
				penampung5c = penampung2 - 1;
				penampung5d = penampung3 - 1;
				penampung5e = penampung4 - 1;
				penampung5f = penampung1a - 1;
				penampung5g = penampung1b - 1;
				penampung5h = penampung2a - 1;
				penampung5i = penampung2b - 1;
				penampung5j = penampung2c - 1;
				penampung5k = penampung3a - 1;
				penampung5l = penampung3b -1 ;
				penampung5m = penampung3c - 1;
				penampung5n = penampung4a - 1;
				penampung5o = penampung4b - 1;
				penampung5p = penampung4c - 1;
				penampung5q = penampung4d - 1;
				penampung5r = penampung4e - 1;
				penampung5s = penampung4f - 1;
				
				if(penampung5 == 2)
				{
					life.setActive(false);
				}
				else if(penampung5 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5 == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung5a == 2)
				{
					life.setActive(false);
				}
				else if(penampung5a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5a == 0)
				{
					life1c.setActive(false);
				}
				
				
				if(penampung5b == 2)
				{
					life.setActive(false);
				}
				else if(penampung5b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5b == 0)
				{
					life1c.setActive(false);
				}

				
				if(penampung5c == 2)
				{
					life.setActive(false);
				}
				else if(penampung5c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5d == 2)
				{
					life.setActive(false);
				}
				else if(penampung5d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5e == 2)
				{
					life.setActive(false);
				}
				else if(penampung5e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5e == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5f == 2)
				{
					life.setActive(false);
				}
				else if(penampung5f == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5f == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5g == 2)
				{
					life.setActive(false);
				}
				else if(penampung5g == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5g == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5h == 2)
				{
					life.setActive(false);
				}
				else if(penampung5h == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5h == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5i == 2)
				{
					life.setActive(false);
				}
				else if(penampung5i == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5i == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5j == 2)
				{
					life.setActive(false);
				}
				else if(penampung5j == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5j == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5k == 2)
				{
					life.setActive(false);
				}
				else if(penampung5k == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5k == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5l == 2)
				{
					life.setActive(false);
				}
				else if(penampung5l == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5l == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5m == 2)
				{
					life.setActive(false);
				}
				else if(penampung5m == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5m == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5n == 2)
				{
					life.setActive(false);
				}
				else if(penampung5n == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5n == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5o == 2)
				{
					life.setActive(false);
				}
				else if(penampung5o == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5o == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5p == 2)
				{
					life.setActive(false);
				}
				else if(penampung5p == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5p == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5q == 2)
				{
					life.setActive(false);
				}
				else if(penampung5q == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5q == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5r == 2)
				{
					life.setActive(false);
				}
				else if(penampung5r == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5r == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5s == 2)
				{
					life.setActive(false);
				}
				else if(penampung5s == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5s == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		button8c = new TButton("AllChoice", 20, 400, 80, 50);
		button8d = new TButton("Racing", 130, 400, 80, 50)
		{
			public void doAction()
			{
				penampung5 = counter - 1;
				penampung5a = penampung - 1;
				penampung5b = penampung1 - 1;
				penampung5c = penampung2 - 1;
				penampung5d = penampung3 - 1;
				penampung5e = penampung4 - 1;
				penampung5f = penampung1a - 1;
				penampung5g = penampung1b - 1;
				penampung5h = penampung2a - 1;
				penampung5i = penampung2b - 1;
				penampung5j = penampung2c - 1;
				penampung5k = penampung3a - 1;
				penampung5l = penampung3b -1 ;
				penampung5m = penampung3c - 1;
				penampung5n = penampung4a - 1;
				penampung5o = penampung4b - 1;
				penampung5p = penampung4c - 1;
				penampung5q = penampung4d - 1;
				penampung5r = penampung4e - 1;
				penampung5s = penampung4f - 1;
				
				if(penampung5 == 2)
				{
					life.setActive(false);
				}
				else if(penampung5 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5 == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung5a == 2)
				{
					life.setActive(false);
				}
				else if(penampung5a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5a == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung5b == 2)
				{
					life.setActive(false);
				}
				else if(penampung5b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5b == 0)
				{
					life1c.setActive(false);
				}

				
				if(penampung5c == 2)
				{
					life.setActive(false);
				}
				else if(penampung5c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5d == 2)
				{
					life.setActive(false);
				}
				else if(penampung5d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5e == 2)
				{
					life.setActive(false);
				}
				else if(penampung5e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5e == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5f == 2)
				{
					life.setActive(false);
				}
				else if(penampung5f == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5f == 0)
				{
					life1c.setActive(false);
				}
				
				
				if(penampung5g == 2)
				{
					life.setActive(false);
				}
				else if(penampung5g == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5g == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5h == 2)
				{
					life.setActive(false);
				}
				else if(penampung5h == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5h == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5i == 2)
				{
					life.setActive(false);
				}
				else if(penampung5i == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5i == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5j == 2)
				{
					life.setActive(false);
				}
				else if(penampung5j == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5j == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5k == 2)
				{
					life.setActive(false);
				}
				else if(penampung5k == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5k == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5l == 2)
				{
					life.setActive(false);
				}
				else if(penampung5l == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5l == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5m == 2)
				{
					life.setActive(false);
				}
				else if(penampung5m == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5m == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5n == 2)
				{
					life.setActive(false);
				}
				else if(penampung5n == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5n == 0)
				{
					life1c.setActive(false);
				}
				
				
				
				if(penampung5o == 2)
				{
					life.setActive(false);
				}
				else if(penampung5o == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5o == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5p == 2)
				{
					life.setActive(false);
				}
				else if(penampung5p == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5p == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5q == 2)
				{
					life.setActive(false);
				}
				else if(penampung5q == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5q == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5r == 2)
				{
					life.setActive(false);
				}
				else if(penampung5r == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5r == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung5s == 2)
				{
					life.setActive(false);
				}
				else if(penampung5s == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung5s == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		
		panel9 = new TPanel(20, 80, 210, 200);
		panel9.add(new TLabel(".kemanusiaan yang adil", 10, -30, 300, 100));
		panel9.add(new TLabel("dan beradap.", 10, -15, 300, 100));
		panel9.add(new TLabel("persatuan indonesia.", 10, 0, 300, 100));
		panel9.add(new TLabel("sila ke berapakah", 10, 15, 300, 100));
		panel9.add(new TLabel("kutipan pancasila di", 10, 30, 300, 100));
		panel9.add(new TLabel("atas ?", 10, 45, 300, 100));
		button9a = new TButton("1&2", 20, 300, 80, 50)
				{
			public void doAction()
			{
				penampung6 = counter - 1;
				penampung6a = penampung - 1;
				penampung6b = penampung1 - 1;
				penampung6c = penampung2 - 1;
				penampung6d = penampung3 - 1;
				penampung6e = penampung4 - 1;
				penampung6f = penampung5 - 1;
				
				penampung6g = penampung5a - 1;
				penampung6h = penampung5b - 1;
				penampung6i = penampung5c - 1;
				penampung6j = penampung5d - 1;
				penampung6k = penampung5e - 1;
				
				if(penampung6 == 2)
				{
					life.setActive(false);
				}
				else if(penampung6 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6a == 2)
				{
					life.setActive(false);
				}
				else if(penampung6a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6a == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6b == 2)
				{
					life.setActive(false);
				}
				else if(penampung6b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6b == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6c == 2)
				{
					life.setActive(false);
				}
				else if(penampung6c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6d == 2)
				{
					life.setActive(false);
				}
				else if(penampung6d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6e == 2)
				{
					life.setActive(false);
				}
				else if(penampung6e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6e == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6f == 2)
				{
					life.setActive(false);
				}
				else if(penampung6f == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6f == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6g == 2)
				{
					life.setActive(false);
				}
				else if(penampung6g == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6g == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6h == 2)
				{
					life.setActive(false);
				}
				else if(penampung6h == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6h == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6i == 2)
				{
					life.setActive(false);
				}
				else if(penampung6i == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6i == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6j == 2)
				{
					life.setActive(false);
				}
				else if(penampung6j == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6j == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6k == 2)
				{
					life.setActive(false);
				}
				else if(penampung6k == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6k == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		button9b = new TButton("1&3", 130, 300, 80, 50)
		{
			public void doAction()
			{
				penampung6 = counter - 1;
				penampung6a = penampung - 1;
				penampung6b = penampung1 - 1;
				penampung6c = penampung2 - 1;
				penampung6d = penampung3 - 1;
				penampung6e = penampung4 - 1;
				penampung6f = penampung5 - 1;
				
				penampung6g = penampung5a - 1;
				penampung6h = penampung5b - 1;
				penampung6i = penampung5c - 1;
				penampung6j = penampung5d - 1;
				penampung6k = penampung5e - 1;
				
				if(penampung6 == 2)
				{
					life.setActive(false);
				}
				else if(penampung6 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6a == 2)
				{
					life.setActive(false);
				}
				else if(penampung6a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6a == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6b == 2)
				{
					life.setActive(false);
				}
				else if(penampung6b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6b == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6c == 2)
				{
					life.setActive(false);
				}
				else if(penampung6c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6d == 2)
				{
					life.setActive(false);
				}
				else if(penampung6d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6e == 2)
				{
					life.setActive(false);
				}
				else if(penampung6e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6e == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6f == 2)
				{
					life.setActive(false);
				}
				else if(penampung6f == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6f == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6g == 2)
				{
					life.setActive(false);
				}
				else if(penampung6g == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6g == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6h == 2)
				{
					life.setActive(false);
				}
				else if(penampung6h == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6h == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6i == 2)
				{
					life.setActive(false);
				}
				else if(penampung6i == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6i == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6j == 2)
				{
					life.setActive(false);
				}
				else if(penampung6j == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6j == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6k == 2)
				{
					life.setActive(false);
				}
				else if(penampung6k == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6k == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		button9c = new TButton("2&3", 20, 400, 80, 50);
		button9d = new TButton("3&4", 130, 400, 80, 50)
		{
			public void doAction()
			{
				penampung6 = counter - 1;
				penampung6a = penampung - 1;
				penampung6b = penampung1 - 1;
				penampung6c = penampung2 - 1;
				penampung6d = penampung3 - 1;
				penampung6e = penampung4 - 1;
				penampung6f = penampung5 - 1;
				
				penampung6g = penampung5a - 1;
				penampung6h = penampung5b - 1;
				penampung6i = penampung5c - 1;
				penampung6j = penampung5d - 1;
				penampung6k = penampung5e - 1;
				
				if(penampung6 == 2)
				{
					life.setActive(false);
				}
				else if(penampung6 == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6 == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6a == 2)
				{
					life.setActive(false);
				}
				else if(penampung6a == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6a == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6b == 2)
				{
					life.setActive(false);
				}
				else if(penampung6b == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6b == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6c == 2)
				{
					life.setActive(false);
				}
				else if(penampung6c == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6c == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6d == 2)
				{
					life.setActive(false);
				}
				else if(penampung6d == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6d == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6e == 2)
				{
					life.setActive(false);
				}
				else if(penampung6e == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6e == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6f == 2)
				{
					life.setActive(false);
				}
				else if(penampung6f == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6f == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6g == 2)
				{
					life.setActive(false);
				}
				else if(penampung6g == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6g == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6h == 2)
				{
					life.setActive(false);
				}
				else if(penampung6h == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6h == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6i == 2)
				{
					life.setActive(false);
				}
				else if(penampung6i == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6i == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6j == 2)
				{
					life.setActive(false);
				}
				else if(penampung6j == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6j == 0)
				{
					life1c.setActive(false);
				}
				
				if(penampung6k == 2)
				{
					life.setActive(false);
				}
				else if(penampung6k == 1)
				{
					life1b.setActive(false);
				}
				else if(penampung6k == 0)
				{
					life1c.setActive(false);
				}
			}
				};
		
		jalanan = new Sprite(ImageUtil.getImage(bsIO.getURL("3.png"),Transparency.TRANSLUCENT),250,0);
		jalan1 = new Sprite(ImageUtil.getImage(bsIO.getURL("3.png"),Transparency.TRANSLUCENT),250,-468);
		jalan_finish_lose = new Sprite(ImageUtil.getImage(bsIO.getURL("2.png"),Transparency.TRANSLUCENT),5000,5000);
		jalan_finish_win = new Sprite(ImageUtil.getImage(bsIO.getURL("5.png"),Transparency.TRANSLUCENT),5000,5000);
		car1 = new Sprite(ImageUtil.getImage(bsIO.getURL("mobil.png"),Transparency.TRANSLUCENT), 470,300);
		car2 = new Sprite(ImageUtil.getImage(bsIO.getURL("mobil.png"),Transparency.TRANSLUCENT),600,300);
		finish = new Sprite(ImageUtil.getImage(bsIO.getURL("line - Copy.png"),Transparency.TRANSLUCENT),430,-110);
		finish2 = new Sprite(ImageUtil.getImage(bsIO.getURL("fin.png"),Transparency.TRANSLUCENT),390,80);
		finish3 = new Sprite(ImageUtil.getImage(bsIO.getURL("fin.png"),Transparency.TRANSLUCENT),5000,5000);
		life = new Sprite(ImageUtil.getImage(bsIO.getURL("apa.png"),Transparency.TRANSLUCENT),950,20);
		life1b = new Sprite(ImageUtil.getImage(bsIO.getURL("apa.png"),Transparency.TRANSLUCENT),1000,20);
		life1c = new Sprite(ImageUtil.getImage(bsIO.getURL("apa.png"),Transparency.TRANSLUCENT),1050,20);
//		mobil1 = new SpriteGroup("GRP_MOBIL");
//		mobil2 = new SpriteGroup("GRP_MOBIL2");
		road1 = new SpriteGroup("GRP_JALAN1");
		road2 = new SpriteGroup("GRP_JALAN2");
		mobil1 = new SpriteGroup("GRP_MOBIL1");
		mobil2 = new SpriteGroup("GRP_MOBIL2");
		finish1 = new SpriteGroup("GRP_FINISH");
		life1 = new SpriteGroup("GRP_LIFE");
		life2 = new SpriteGroup("GRP_LIFE2");
		life3 = new SpriteGroup("GRP_LIFE3");
		finish_life = new SpriteGroup("GRP_FINISH_LIFE");
		jalan_finish = new SpriteGroup("GRP_FINISH_LOSE");
		jalanan_finish_win = new SpriteGroup("GRP_JALAN_FINISH_WIN");
		
//		mobil1.add(car1);
//		mobil2.add(car2);
		road1.add(jalan1);
		road2.add(jalanan);
		mobil1.add(car1);
		mobil2.add(car2);
		jalan_finish.add(jalan_finish_lose);
		finish1.add(finish);
		life1.add(life);
		life2.add(life1b);
		life3.add(life1c);
		finish_life.add(finish3);
		pf = new PlayField(ib);
//		pf.addGroup(mobil1);
//		pf.addGroup(mobil2);
		pf.addGroup(road1);
		pf.addGroup(road2);
		pf.addGroup(mobil1);
		pf.addGroup(mobil2);
		pf.addGroup(finish1);
		pf.addGroup(life1);
		pf.addGroup(life2);
		pf.addGroup(life3);
		pf.addGroup(jalanan_finish_win);
		pf.addGroup(jalan_finish);
//		pf.add(jalan1);
//		pf.add(jalanan);
		pf.add(car1);
		pf.add(car2);
		pf.add(finish);
		pf.add(life);
		pf.add(life1b);
		pf.add(life1c);
		pf.add(finish3);
		pf.add(jalan_finish_win);
		pf.addCollisionGroup(mobil1, finish1, new BasicCollisionGroup() {
			
			@Override
			public void collided(Sprite mobil, Sprite finish) {
//				pf.add(new VolatileSprite(ImageUtil.getImages(bsIO.getURL("fin.png"), 5, 1, Transparency.TRANSLUCENT),
//						mobil.getX(),mobil.getY()));
				pf.add(finish2);
				mobil.setVerticalSpeed(-0.1);
			}
		});
		
		pf.addCollisionGroup(mobil2, finish1, new BasicCollisionGroup() {
			
			public void collided(Sprite mobil2, Sprite finish) {
				pf.add(finish2);
				mobil2.setVerticalSpeed(-0.1);
			}
		});
		
		framework.add(panel1);
		framework.add(button1a);
		framework.add(button1b);
		framework.add(button1c);
		framework.add(button1d);
		
		framework.add(panel2);
		framework.add(button2a);
		framework.add(button2b);
		framework.add(button2c);
		framework.add(button2d);
		
		framework.add(panel3);
		framework.add(button3a);
		framework.add(button3b);
		framework.add(button3c);
		framework.add(button3d);
		
		framework.add(panel4);
		framework.add(button4a);
		framework.add(button4b);
		framework.add(button4c);
		framework.add(button4d);
		
		framework.add(panel5);
		framework.add(button5a);
		framework.add(button5b);
		framework.add(button5c);
		framework.add(button5d);
		
		framework.add(panel6);
		framework.add(button6a);
		framework.add(button6b);
		framework.add(button6c);
		framework.add(button6d);
		
		framework.add(panel7);
		framework.add(button7a);
		framework.add(button7b);
		framework.add(button7c);
		framework.add(button7d);
		
		framework.add(panel8);
		framework.add(button8a);
		framework.add(button8b);
		framework.add(button8c);
		framework.add(button8d);
		
		framework.add(panel9);
		framework.add(button9a);
		framework.add(button9b);
		framework.add(button9c);
		framework.add(button9d);
		
		panel1.setVisible(false);
		button1a.setVisible(false);
		button1b.setVisible(false);
		button1c.setVisible(false);
		button1d.setVisible(false);
		
		panel2.setVisible(false);
		button2a.setVisible(false);
		button2b.setVisible(false);
		button2c.setVisible(false);
		button2d.setVisible(false);
		
		panel3.setVisible(false);
		button3a.setVisible(false);
		button3b.setVisible(false);
		button3c.setVisible(false);
		button3d.setVisible(false);
		
		panel4.setVisible(false);
		button4a.setVisible(false);
		button4b.setVisible(false);
		button4c.setVisible(false);
		button4d.setVisible(false);
		
		panel5.setVisible(false);
		button5a.setVisible(false);
		button5b.setVisible(false);
		button5c.setVisible(false);
		button5d.setVisible(false);
		
		panel6.setVisible(false);
		button6a.setVisible(false);
		button6b.setVisible(false);
		button6c.setVisible(false);
		button6d.setVisible(false);
		
		panel7.setVisible(false);
		button7a.setVisible(false);
		button7b.setVisible(false);
		button7c.setVisible(false);
		button7d.setVisible(false);
		
		panel8.setVisible(false);
		button8a.setVisible(false);
		button8b.setVisible(false);
		button8c.setVisible(false);
		button8d.setVisible(false);
		
		panel9.setVisible(false);
		button9a.setVisible(false);
		button9b.setVisible(false);
		button9c.setVisible(false);
		button9d.setVisible(false);
		
		
		finish.setActive(false);
		
		
		
		Random r = new Random();
		int rand = r.nextInt(3);
		
		if(r.nextInt(3) == 0)
		{
			
			panel1.setVisible(true);
			button1a.setVisible(true);
			button1b.setVisible(true);
			button1c.setVisible(true);
			button1d.setVisible(true);		
		}
		else if(r.nextInt(3) == 1)
		{

			panel2.setVisible(true);
			button2a.setVisible(true);
			button2b.setVisible(true);
			button2c.setVisible(true);
			button2d.setVisible(true);
			
		}
		else if(r.nextInt(3) == 2)
		{

			panel3.setVisible(true);
			button3a.setVisible(true);
			button3b.setVisible(true);
			button3c.setVisible(true);
			button3d.setVisible(true);
		}
	
	}

	public void render(Graphics2D g) {
		
		pf.render(g);
		sf.drawString(g, "TIME :" + detik, 20, 30);
		if(detik == 0)
		{
			sf.drawString(g, "tekan ESC untuk kembali ke Menu", 200, 250);
			
		}
		if(show)
		{
			finish2.setActive(true);
		}
		
		
		sf.drawString(g, "skor : "+ skor, 100, 100);
		
		
		framework.render(g);
	}

	public void update(long elapsedTime) {
		pf.update(elapsedTime);
		jalanan.setVerticalSpeed(0.2);
		jalan1.setVerticalSpeed(0.2);
		if(jalanan.getY() > 468)
		{
			jalanan.setLocation(250, -468);
		}
		else if(jalan1.getY() > 468)
		{
			jalan1.setLocation(250,-468);
		}
		
		
	
		framework.update();
		
		if(button1a.isSelected())
		{
			car1.setVerticalSpeed(-0.1);
			skor= "100";
			skor1 = skor;
		
		}
		else if(button1b.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		else if(button1c.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		else if(button1d.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		
		
		else if(button2a.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		else if(button2b.isSelected())
		{
			car1.setVerticalSpeed(-0.1);
			skor = "100";
			skor1 = skor;
			
			
		}
		else if(button2c.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		else if(button2d.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		
		
		
		else if(button3a.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		else if(button3b.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		else if(button3c.isSelected())
		{
			skor = "0";
			skor1 = skor;
			car2.setVerticalSpeed(-0.1);
			penampung = counter - 1;
			if(penampung == 2)
			{
				life.setActive(false);
			}
		}
		else if(button3d.isSelected())
		{
			car1.setVerticalSpeed(-0.1);
		skor = "100";
		skor1 = skor;
		}
		
		if(car1.getY() <= 250)
		{
			
			car1.setVerticalSpeed(0);
			panel4.setVisible(true);
			button4a.setVisible(true);
			button4b.setVisible(true);
			button4c.setVisible(true);
			button4d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
//			panel5.setLocation(5000, 5000);
//			button5a.setLocation(5000, 5000);
//			button5b.setLocation(5000, 5000);
//			button5c.setLocation(5000, 5000);
//			button5d.setLocation(5000, 5000);
			
			if(button4a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung1 = counter - 1;
//				penampung1 = penampung - 1;
//				if(penampung1 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung1 == 2)
//				{
//					life.setActive(false);
//				}
				button4a.doAction();
				
			}
			else if(button4b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung1 = counter - 1;
//				penampung1 = penampung - 1;
//				if(penampung1 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung1 == 2)
//				{
//					life.setActive(false);
//				}
				button4b.doAction();
			}
			else if(button4c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
				 if(skor1.equals("0"))
				{
					skor = "100";
				}
				 else
				 {
					 skor = "200";
				 }
				
			}
			else if(button4d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung1 = counter - 1;
//				penampung1 = penampung - 1;
//				if(penampung1 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung1 == 2)
//				{
//					life.setActive(false);
//				}
				button4d.doAction();
			}
			
		}
		
		else if(car2.getY() <= 250)
		{
			car2.setVerticalSpeed(0);
			panel4.setVisible(true);
			button4a.setVisible(true);
			button4b.setVisible(true);
			button4c.setVisible(true);
			button4d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
//			panel5.setLocation(5000, 5000);
//			button5a.setLocation(5000, 5000);
//			button5b.setLocation(5000, 5000);
//			button5c.setLocation(5000, 5000);
//			button5d.setLocation(5000, 5000);
			
			if(button4a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung1 = penampung - 1;
//				if(penampung1 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung1 == 2)
//				{
//					life.setActive(false);
//				}
				button4a.doAction();
				
			}
			else if(button4b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung1 = penampung - 1;
//				if(penampung1 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung1 == 2)
//				{
//					life.setActive(false);
//				}
				button4b.doAction();
				
			}
			else if(button4c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button4d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung1 = penampung - 1;
//				if(penampung1 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung1 == 2)
//				{
//					life.setActive(false);
//				}
				button4d.doAction();
			}
		}
		
		if(car1.getY() <= 220)
		{
			car1.setVerticalSpeed(0);
			panel5.setVisible(true);
			button5a.setVisible(true);
			button5b.setVisible(true);
			button5c.setVisible(true);
			button5d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			if(button5a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung2 = penampung1 - 1;
//				penampung2 = counter - 1;
//				if(penampung2 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung2 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung2 == 0)
//				{
//					life1c.setActive(false);
//				}
				button5a.doAction();
			}
			else if(button5b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung2 = penampung1 - 1;
//				penampung2 = counter - 1;
//				if(penampung2 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung2 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung2 == 0)
//				{
//					life1c.setActive(false);
//				}
				button5b.doAction();
			}
			else if(button5c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button5d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung2 = penampung1 - 1;
//				penampung2 = counter - 1;
//				if(penampung2 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung2 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung2 == 0)
//				{
//					life1c.setActive(false);
//				}
				button5d.doAction();
			}
			
		}
		
		else if(car2.getY() <= 220)
		{
			
			car2.setVerticalSpeed(0);
			panel5.setVisible(true);
			button5a.setVisible(true);
			button5b.setVisible(true);
			button5c.setVisible(true);
			button5d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			if(button5a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung2 = penampung1 - 1;
//				if(penampung2 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung2 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung2 == 0)
//				{
//					life1c.setActive(false);
//				}
				button5a.doAction();
				
			}
			else if(button5b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				if(penampung2 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung2 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung2 == 0)
//				{
//					life1c.setActive(false);
//				}
				button5b.doAction();
			}
			else if(button5c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button5d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				if(penampung2 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung2 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung2 == 0)
//				{
//					life1c.setActive(false);
//				}
				button5d.doAction();
				
			}
			
		}
		
		if(car1.getY() <= 190)
		{
			car1.setVerticalSpeed(0);
			panel6.setVisible(true);
			button6a.setVisible(true);
			button6b.setVisible(true);
			button6c.setVisible(true);
			button6d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			if(button6a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung3 = penampung2 - 1;
//				penampung3 = penampung1 - 1;
//				penampung3 = counter - 1;
//				if(penampung3 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung3 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung3 == 0)
//				{
//					life1c.setActive(false);
//				}
				button6a.doAction();
			}
			else if(button6b.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button6c.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				if(penampung3 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung3 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung3 == 0)
//				{
//					life1c.setActive(false);
//				}
				button6c.doAction();
			}
			else if(button6d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				if(penampung3 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung3 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung3 == 0)
//				{
//					life1c.setActive(false);
//				}
				button6d.doAction();
			}
			
		}
		
		else if(car2.getY() <= 190)
		{
			car2.setVerticalSpeed(0);
			panel6.setVisible(true);
			button6a.setVisible(true);
			button6b.setVisible(true);
			button6c.setVisible(true);
			button6d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			if(button6a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung3 = penampung2 - 1;
//				penampung3 = penampung1 - 1;
//				if(penampung3 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung3 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung3 == 0)
//				{
//					life1c.setActive(false);
//				}
				button6a.doAction();
			}
			else if(button6b.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button6c.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung3 = penampung2 - 1;
//				penampung3 = penampung1 - 1;
//				if(penampung3 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung3 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung3 == 0)
//				{
//					life1c.setActive(false);
//				}
				button6c.doAction();
			}
			else if(button6d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung3 = penampung2 - 1;
//				penampung3 = penampung1 - 1;
//				if(penampung3 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung3 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung3 == 0)
//				{
//					life1c.setActive(false);
//				}
				button6d.doAction();
			}
			
		}
		
		if(car1.getY() <= 160)
		{
			car1.setVerticalSpeed(0);
			finish.setActive(true);
			panel7.setVisible(true);
			button7a.setVisible(true);
			button7b.setVisible(true);
			button7c.setVisible(true);
			button7d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			panel6.setLocation(6000, 6000);
			button6a.setLocation(6000, 6000);
			button6b.setLocation(6000, 6000);
			button6c.setLocation(6000, 6000);
			button6d.setLocation(6000, 6000);
			
			if(button7a.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button7b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung4 = penampung3 - 1;
//				penampung4 = penampung2 - 1;
//				penampung4 = penampung1 - 1;
//				penampung4 = counter - 1;
				
//				if(penampung4 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4 == 0)
//				{
//					life1c.setActive(false);
//				}
				button7b.doAction();
		
			}
			else if(button7c.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung4 = penampung3 - 1;
//				penampung4 = penampung2 - 1;
//				penampung4 = penampung1 - 1;
//				penampung4 = counter - 1;
//				
//				if(penampung4 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4 == 0)
//				{
//					life1c.setActive(false);
//				}
				button7c.doAction();
			}
			else if(button7d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung4 = penampung3 - 1;
//				penampung4 = penampung2 - 1;
//				penampung4 = penampung1 - 1;
//				penampung4 = counter - 1;
//				
//				if(penampung4 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4 == 0)
//				{
//					life1c.setActive(false);
//				}
				button7d.doAction();
			}
			
		}
		
		else if(car2.getY() <= 160)
		{
			car2.setVerticalSpeed(0);
			finish.setActive(true);
			panel7.setVisible(true);
			button7a.setVisible(true);
			button7b.setVisible(true);
			button7c.setVisible(true);
			button7d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			panel6.setLocation(6000, 6000);
			button6a.setLocation(6000, 6000);
			button6b.setLocation(6000, 6000);
			button6c.setLocation(6000, 6000);
			button6d.setLocation(6000, 6000);
			
			if(button7a.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button7b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung4 = penampung3 - 1;
//				penampung4 = penampung2 - 1;
//				penampung4 = penampung1 - 1;
//				penampung4 = counter - 1;
//				
//				if(penampung4 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung4 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung4 == 0)
//				{
//					life1c.setActive(false);
//				}
				button7b.doAction();
			}
			else if(button7c.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button7c.doAction();
			}
			else if(button7d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button7b.doAction();
			}
			
		}
		
		if(car1.getY() <= 130)
		{
			car1.setVerticalSpeed(0);
			panel8.setVisible(true);
			button8a.setVisible(true);
			button8b.setVisible(true);
			button8c.setVisible(true);
			button8d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			panel6.setLocation(6000, 6000);
			button6a.setLocation(6000, 6000);
			button6b.setLocation(6000, 6000);
			button6c.setLocation(6000, 6000);
			button6d.setLocation(6000, 6000);
			
			panel7.setLocation(7000, 7000);
			button7a.setLocation(7000, 7000);
			button7b.setLocation(7000, 7000);
			button7c.setLocation(7000, 7000);
			button7d.setLocation(7000, 7000);
			
			if(button8a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung5 = penampung4 - 1;
//				penampung5 = penampung3 - 1;
//				penampung5 = penampung2 - 1;
//				penampung5 = penampung1 - 1;
//				penampung5 = counter - 1;
//				
//				if(penampung5 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung5 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung5 == 0)
//				{
//					life1c.setActive(false);
//				}
				button8a.doAction();
			}
			else if(button8b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button8b.doAction();
			}
			else if(button8c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button8d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button8d.doAction();
			}
			
		}
		
		else if(car2.getY() <= 130)
		{
			car2.setVerticalSpeed(0);
			panel8.setVisible(true);
			button8a.setVisible(true);
			button8b.setVisible(true);
			button8c.setVisible(true);
			button8d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			panel6.setLocation(6000, 6000);
			button6a.setLocation(6000, 6000);
			button6b.setLocation(6000, 6000);
			button6c.setLocation(6000, 6000);
			button6d.setLocation(6000, 6000);
			
			panel7.setLocation(7000, 7000);
			button7a.setLocation(7000, 7000);
			button7b.setLocation(7000, 7000);
			button7c.setLocation(7000, 7000);
			button7d.setLocation(7000, 7000);
			
			if(button8a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
//				penampung5 = penampung4 - 1;
//				penampung5 = penampung3 - 1;
//				penampung5 = penampung2 - 1;
//				penampung5 = penampung1 - 1;
//				penampung5 = counter - 1;
				
//				if(penampung5 == 2)
//				{
//					life.setActive(false);
//				}
//				else if(penampung5 == 1)
//				{
//					life1b.setActive(false);
//				}
//				else if(penampung5 == 0)
//				{
//					life1c.setActive(false);
//				}
//				else if(penampung5 == -1)
//				{
//					life1c.setActive(false);
//				}
				button8a.doAction();
			}
			else if(button8b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button8b.doAction();
			}
			else if(button8c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button8d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button8d.doAction();
			}
			
		}
		
		if(car1.getY() <= 100)
		{
			car1.setVerticalSpeed(0);
			panel9.setVisible(true);
			button9a.setVisible(true);
			button9b.setVisible(true);
			button9c.setVisible(true);
			button9d.setVisible(true);
			jalan_finish_win.setLocation(255, 0);
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			panel6.setLocation(6000, 6000);
			button6a.setLocation(6000, 6000);
			button6b.setLocation(6000, 6000);
			button6c.setLocation(6000, 6000);
			button6d.setLocation(6000, 6000);
			
			panel7.setLocation(7000, 7000);
			button7a.setLocation(7000, 7000);
			button7b.setLocation(7000, 7000);
			button7c.setLocation(7000, 7000);
			button7d.setLocation(7000, 7000);
			
			panel8.setLocation(8000, 8000);
			button8a.setLocation(8000, 8000);
			button8b.setLocation(8000, 8000);
			button8c.setLocation(8000, 8000);
			button8d.setLocation(8000, 8000);
			
			if(button9a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button9a.doAction();
			}
			else if(button9b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button9b.doAction();
			}
			else if(button9c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button9d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button9d.doAction();
			}
			
		}
		
		else if(car2.getY() <= 100)
		{
			car2.setVerticalSpeed(0);
			jalan_finish_win.setLocation(255, 0);
			panel9.setVisible(true);
			button9a.setVisible(true);
			button9b.setVisible(true);
			button9c.setVisible(true);
			button9d.setVisible(true);
			
			panel1.setLocation(5000, 5000);
			button1a.setLocation(5000, 5000);
			button1b.setLocation(5000, 5000);
			button1c.setLocation(5000, 5000);
			button1d.setLocation(5000, 5000);
			
			panel2.setLocation(5000, 5000);
			button2a.setLocation(5000, 5000);
			button2b.setLocation(5000, 5000);
			button2c.setLocation(5000, 5000);
			button2d.setLocation(5000, 5000);
			
			panel3.setLocation(5000, 5000);
			button3a.setLocation(5000, 5000);
			button3b.setLocation(5000, 5000);
			button3c.setLocation(5000, 5000);
			button3d.setLocation(5000, 5000);
			
			panel4.setLocation(5000, 5000);
			button4a.setLocation(5000, 5000);
			button4b.setLocation(5000, 5000);
			button4c.setLocation(5000, 5000);
			button4d.setLocation(5000, 5000);
			
			panel5.setLocation(5000, 5000);
			button5a.setLocation(5000, 5000);
			button5b.setLocation(5000, 5000);
			button5c.setLocation(5000, 5000);
			button5d.setLocation(5000, 5000);
			
			panel6.setLocation(6000, 6000);
			button6a.setLocation(6000, 6000);
			button6b.setLocation(6000, 6000);
			button6c.setLocation(6000, 6000);
			button6d.setLocation(6000, 6000);
			
			panel7.setLocation(7000, 7000);
			button7a.setLocation(7000, 7000);
			button7b.setLocation(7000, 7000);
			button7c.setLocation(7000, 7000);
			button7d.setLocation(7000, 7000);
			
			panel8.setLocation(8000, 8000);
			button8a.setLocation(8000, 8000);
			button8b.setLocation(8000, 8000);
			button8c.setLocation(8000, 8000);
			button8d.setLocation(8000, 8000);
			
			if(button9a.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button9a.doAction();
			}
			else if(button9b.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button9b.doAction();
			}
			else if(button9c.isSelected())
			{
				car1.setVerticalSpeed(-0.1);
			}
			else if(button9d.isSelected())
			{
				car2.setVerticalSpeed(-0.1);
				button9d.doAction();
			}
			
		}
		
		if(bsInput.getKeyPressed() == KeyEvent.VK_ESCAPE)
		{
			this.parent.nextGameID = Main.MENU_PAGE;
			this.finish();
		}
		
	
		
		
		
		
		if(time2.action(elapsedTime))
		{
			finish2.setActive(false);
		}
	
		
		if(time.action(elapsedTime))
		{
			detik--;
			if(detik == 0)
			{
				jalanan.setActive(false);
				jalan1.setActive(false);
				car1.setActive(false);
				car2.setActive(false);
				finish.setActive(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				panel7.setVisible(false);
				panel8.setVisible(false);
				panel9.setVisible(false);
				
				button1a.setVisible(false);
				button1b.setVisible(false);
				button1c.setVisible(false);
				button1d.setVisible(false);
				
				button2a.setVisible(false);
				button2b.setVisible(false);
				button2c.setVisible(false);
				button2d.setVisible(false);
				
				button3a.setVisible(false);
				button3b.setVisible(false);
				button3c.setVisible(false);
				button3d.setVisible(false);
				
				button4a.setVisible(false);
				button4b.setVisible(false);
				button4c.setVisible(false);
				button4d.setVisible(false);
				
				button5a.setVisible(false);
				button5b.setVisible(false);
				button5c.setVisible(false);
				button5d.setVisible(false);
				
				button6a.setVisible(false);
				button6b.setVisible(false);
				button6c.setVisible(false);
				button6d.setVisible(false);
				
				button7a.setVisible(false);
				button7b.setVisible(false);
				button7c.setVisible(false);
				button7d.setVisible(false);
				
				button8a.setVisible(false);
				button8b.setVisible(false);
				button8c.setVisible(false);
				button8d.setVisible(false);
				
				button9a.setVisible(false);
				button9b.setVisible(false);
				button9c.setVisible(false);
				button9d.setVisible(false);
				time.setActive(false);
			}
		}
		
		if(life1c.isActive())
		{
			
		}
		else
		{
			
			jalan1.setVerticalSpeed(0);
			jalanan.setVerticalSpeed(0);
			
			jalan_finish_lose.setLocation(255, 0);
			
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			panel6.setVisible(false);
			panel7.setVisible(false);
			panel8.setVisible(false);
			panel9.setVisible(false);
			
			button1a.setVisible(false);
			button1b.setVisible(false);
			button1c.setVisible(false);
			button1d.setVisible(false);
			
			button2a.setVisible(false);
			button2b.setVisible(false);
			button2c.setVisible(false);
			button2d.setVisible(false);
			
			button3a.setVisible(false);
			button3b.setVisible(false);
			button3c.setVisible(false);
			button3d.setVisible(false);
			
			button4a.setVisible(false);
			button4b.setVisible(false);
			button4c.setVisible(false);
			button4d.setVisible(false);
			
			button5a.setVisible(false);
			button5b.setVisible(false);
			button5c.setVisible(false);
			button5d.setVisible(false);
			
			button6a.setVisible(false);
			button6b.setVisible(false);
			button6c.setVisible(false);
			button6d.setVisible(false);
			
			button7a.setVisible(false);
			button7b.setVisible(false);
			button7c.setVisible(false);
			button7d.setVisible(false);
			
			button8a.setVisible(false);
			button8b.setVisible(false);
			button8c.setVisible(false);
			button8d.setVisible(false);
			
			button9a.setVisible(false);
			button9b.setVisible(false);
			button9c.setVisible(false);
			button9d.setVisible(false);
			
			time.setActive(false);
		}
		
	
		
		
	}

}