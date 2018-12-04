package Space_Invaders;

import java.awt.Color;
import java.awt.event.KeyEvent;
import jconsole.JConsole;

public class Space_invaders {
	public static void main(String[] args) {
		JConsole console = new JConsole(30, 15);
		console.setCursorVisible(false);

		int x, y, a, b, xe, ye;
		int count=0;
		boolean gameover=true, impact=true, emove = true;
		KeyEvent key;

		x = console.getColumns() / 2;
		y = 14;
		
		xe = 1;
		ye = 0;

		console.setCursorPosition(x-1, y);
		console.setForegroundColor(Color.green);
		console.print("[^]");

		while (gameover && impact){
			if(count%2 == 0) {
				console.setCursorPosition(xe,ye);
				console.setForegroundColor(Color.red);
				console.print("*");

				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {}

				console.setCursorPosition(xe, ye);
				console.print(" ");
				
				if(xe%29 == 0 ) {
					ye= ye+ 2;
					emove= !(emove);
					if(emove)xe++;
					else xe--;
				}
				else {
					if(emove)xe++;
					else xe--;
				}	
			count=0;
			}
			count++;	
			
			
			if(console.keyAvailable()) {
			key = console.readKey(true);
			console.setCursorPosition(x-1, y);
			console.print("   ");
			switch (key.getKeyCode()) {
			case KeyEvent.VK_D:
			if(x >= 28);
			else{
				x++;
				console.setCursorPosition(x-1, y);
			}
				break;
			case KeyEvent.VK_A:
				if(x <= 1);
				else {
				x--;
				console.setCursorPosition(x-1, y);
				}
				break;
			case KeyEvent.VK_W:
				a=x;
				b=y-2;
				console.setCursorPosition(x-1, y);
				console.setForegroundColor(Color.green);
				console.print("[^]");
				impact = bullet(a, b, xe, ye, console);
				console.setCursorPosition(x, y);
				console.print("   ");
				break;
			}

			console.setCursorPosition(x-1, y);
			console.setForegroundColor(Color.green);
			console.print("[^]");
			}
			if(y==ye)gameover = false;
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {}

		}
		console.clear();
		console.setCursorPosition(console.getColumns() / 2, console.getRows() / 2);
		if(ye==y) {
			console.setForegroundColor(Color.red);
			console.print(" You lose ");	
		}
		else {
			console.setForegroundColor(Color.green);
			console.print(" GG !! You win ");	
		}
		console.readKey(true);
		System.exit(0);	
	}

public static boolean bullet(int a, int b, int xe, int ye,  JConsole console ) {
	boolean impact=true , fail=true;
	console.setCursorPosition(xe,ye);
	console.setForegroundColor(Color.red);
	console.print("*");

	while(impact && fail) {
		console.setCursorPosition(a, b);
		console.setForegroundColor(Color.green);
		console.print("|");
		try {
			Thread.sleep(50);
		} catch (InterruptedException ie) {}
		console.setCursorPosition(a, b);
		console.print(" ");
		if(b == 0) fail=false;
		impact = !(impact (a,b,xe,ye));
		b--;
	}
	return impact;
}
public static boolean impact(int a, int b, int x, int y) {
	if(a==x && b==y)return true;
	else return false;
}
}

