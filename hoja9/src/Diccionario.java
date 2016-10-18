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

	// private SplayBST<String,String> cole = new SplayBST<String,String>();
	// private Asociacion<String,String> cole2 = new
	// Asociacion<String,String>();
	private ArrayList<String> array = new ArrayList<String>();
	private ArrayList<String> array2 = new ArrayList<String>();
	static String textoArray[];
	private MapeoFactory mapeoFactory;
	private Mapeo<String, String> miMapeo;

	/**
	 * Metodo para instaciar la coleccion deseada.
	 * 
	 * @param tipo
	 *            para seleccionar implementacion a usar
	 */
	void listo(String tipo) {
		mapeoFactory = new Factory();
		miMapeo = mapeoFactory.getMapeo(tipo);
	}

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

	/**
	 * LeerContenido recibe como parametro el archivo donde estan los datos.
	 * devuelve el texto que esta en la linea. si no se encuentra el archivo
	 * muesta error
	 * 
	 * @param archivo
	 *            Este es el archivo que contiene las palabras de forma
	 *            (ingles,espanol)
	 * @return array este es un array que tiene las palabras
	 */
	ArrayList<String> leerContenido(String archivo) {
		String bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				array.add(bfRead);
				System.out.println(bfRead);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}

		// pruebas

		return array;
	}

	/**
	 * Metodo que crea el arbol o hashmap (segun seleccionado) lleno de las
	 * palabras con key=palabra en ingles value=palabra en espa�ol ignorando a
	 * partir de cuando hay un corchete para mostrar en la traduccion solo la
	 * palabra y no el tipo de esta
	 * 
	 * @param archivo
	 */
	void crear(String archivo) {
		for (String i : leerContenido(archivo)) {
			String[] parts;
			int co = 0;
			String part1 = "", part2 = "";

			for (int j = 0; j < i.length(); j++) {
				char c = i.charAt(j);
				if (Character.isLetter(c)) {
					part1 += c;
				} else {
					co = j;
					break;

				}
			}

			int coma = 0, espacio = 0, corchete = 0, diagonal = 0, primero = 0;

			i.trim();

			corchete = i.indexOf("[");

			if (corchete > 0) {
				part2 = i.substring(co, corchete);
			} else {
				part2 = i.substring(co);
			}

			part2.trim();

			System.out.println("1" + part1);
			System.out.println("2" + part2);
			miMapeo.put(part1, part2);
			part1 = "";
			part2 = "";

		}

		// pruebas

	}

	/**
	 * Llena el SplayTree
	 */
	// void llenarArbol() {
	// System.out.println("se llena");
	//
	// String[] parts;
	// int co = 0;
	// String part1 = "", part2 = "";
	// for (String i : array) {
	//
	// for (int j = 0; j < i.length(); j++) {
	// char c = i.charAt(j);
	// if (Character.isLetter(c)) {
	// part1 += c;
	// } else {
	// co = j;
	// break;
	//
	// }
	// }
	//
	// int coma = 0, espacio = 0, corchete = 0, diagonal = 0, primero = 0;
	//
	// i.trim();
	// coma = i.indexOf(",");
	// espacio = i.indexOf(" ");
	// corchete = i.indexOf("[");
	// diagonal = i.indexOf("/");
	// primero = Math.min(Math.min(Math.min(coma, espacio), corchete),
	// diagonal);
	// part2 = i.substring(co, primero - 1);
	// part2.trim();
	//
	// // System.out.println("1"+part1);
	// // System.out.println("2"+part2);
	// miMapeo.put(part1, part2);
	// part1 = "";
	// }
	// }

	/**
	 * @param key
	 * @return
	 */
	String buscarArbol(String key) {
		if (miMapeo.contains(key)) {
			return miMapeo.get(key);
		} else {
			return "No esta en el iccionario";
		}
	}

	/**
	 * Llena el Hashmap
	 */
	// void llenarHash() {
	// System.out.println("se llena");
	//
	// String[] parts;
	// int co = 0;
	// String part1 = "", part2 = "";
	// for (String i : array) {
	//
	// for (int j = 0; j < i.length(); j++) {
	// char c = i.charAt(j);
	// if (Character.isLetter(c)) {
	// part1 += c;
	// } else {
	// co = j;
	// break;
	//
	// }
	// }
	// int coma = 0, espacio = 0, corchete = 0, diagonal = 0, primero = 0;
	//
	// i.trim();
	// coma = i.indexOf(",");
	// espacio = i.indexOf(" ");
	// corchete = i.indexOf("[");
	// diagonal = i.indexOf("/");
	// primero = Math.min(Math.min(Math.min(coma, espacio), corchete),
	// diagonal);
	// part2 = i.substring(co, primero - 1);
	// part2.trim();
	//
	// // System.out.println("1"+part1);
	// // System.out.println("2"+part2);
	// miMapeo.put(part1, part2);
	// part1 = "";
	// // parts = i.split(" ",2);
	//
	// // part1 = parts[0];
	// // System.out.println("1"+part1);
	// // System.out.println(parts[1]);
	// // part2 = parts[1];
	// // System.out.println("2"+part2);
	//
	// }
	// }

	/**
	 * @param key
	 * @return
	 */
	String buscarHash(String key) {
		if (miMapeo.contains(key)) {
			return miMapeo.get(key);
		} else {
			return "No esta en el Diccionario";
		}
	}

	/**
	 * Metodo para traducir la oracion
	 * 
	 * @param dir
	 */
	String traducir(String dir) {
		String texto = "", traduccion = "";
		int j = 0;
		texto = leerContenido2(dir);
		textoArray = texto.split(" ");
		for (String i : textoArray) {
			array2.add(i);

		}

		for (String i : textoArray) {
			if (miMapeo.contains(array2.get(j))) {
				traduccion += miMapeo.get(array2.get(j)).trim() + " ";
			} else {
				traduccion += "*" + array2.get(j).trim() + "*" + " ";

			}
			j++;
		}
		System.out.println(traduccion);

		return traduccion;

	}

}
