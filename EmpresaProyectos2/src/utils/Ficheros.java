package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {

	public static List<String> cargarFicheroCFG() throws IOException {

			FileReader fichero = new FileReader("DatosConexion.txt");
			BufferedReader b = new BufferedReader(fichero);
			List<String> cfg = new ArrayList<String>();
			cfg.add(b.readLine());
			cfg.add(b.readLine());
			cfg.add(b.readLine());
			cfg.add(b.readLine());
			cfg.add(b.readLine());
			b.close();


		return cfg;

	}

}

