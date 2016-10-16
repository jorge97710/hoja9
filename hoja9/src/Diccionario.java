import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * @author JorgeAndres
 * @author carlos calderon
 * @version 1
 * 
 */
public class Diccionario {

	static String textoArray[];

	/**
	 * Metodo que lee el contenido y lo pone en una sola linea. Este es con el
	 * que se lee el texto que viene en ingles
	 * 
	 * @param archivo
	 *            El archivo que tiene el texto en ingles
	 * @return texto variable que tiene como un string todo el texto
	 */
	static String leerContenido2(String archivo) {
		String texto = "", temp = "", bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				temp += bfRead;
			}
			texto = temp;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}

		return texto;
	}

}
