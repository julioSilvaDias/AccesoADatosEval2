package ejercicio3_5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		Logger hibernateLogger = Logger.getLogger("org.hibernate");
        hibernateLogger.setLevel(Level.OFF);
        
		Menu menu = new Menu();
		menu.mostrarMenu();
	}

}
