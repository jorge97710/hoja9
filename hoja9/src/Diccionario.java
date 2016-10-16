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
	
	//private SplayBST<String,String> cole = new SplayBST<String,String>();
	//private Asociacion<String,String> cole2 = new Asociacion<String,String>();
	private ArrayList<String> array = new ArrayList<String>();
	static String textoArray[];
	private MapeoFactory  mapeoFactory;
	private  Mapeo <String,String> miMapeo;
	
	/**
	 * Metodo para instaciar la coleccion deseada.
	 * @param tipo para seleccionar implementacion a usar
	 */
	 void listo(String tipo){
		mapeoFactory = new Factory ();
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
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}
		return array;
	}
	
	/**
	 * Llena el SplayTree
	 */
	void llenarArbol(){
		String string = "004-034556";
		String[] parts = string.split(" ");
		String part1,part2;
		for (String i: array){
			parts = i.split(" ");
			part1 = parts[0];
			part2 = parts[1];
			miMapeo.put(part1,part2);
		}
	}
	/**
	 * @param key
	 * @return
	 */
	String buscarArbol(String key){
		if (miMapeo.contains(key)){
			return miMapeo.get(key);
		}
		else{
			return "No esta en el iccionario";
		}
	}
	
	/**
	 * Llena el Hashmap
	 */
	void llenarHash(){
		String[] parts;
		int co=0;
		String part1="",part2="";
		for (String i: array){
			
			for (int j=0;j<i.indexOf(" ");j++){
				char c = i.charAt(j);
				if (Character.isLetter(c)){
					part1+=c;
				}
				else{	
				}
			}
			part2=i.substring(i.indexOf(" "));
			System.out.println("1"+part1);
			System.out.println("2"+part2);
			//parts = i.split(" ",2);
			
			//part1 = parts[0];
			//System.out.println("1"+part1);
			//System.out.println(parts[1]);
			//part2 = parts[1];
			//System.out.println("2"+part2);
			//miMapeo.put(part1,part2);
		}
	}
	
	/**
	 * @param key
	 * @return
	 */
	String buscarHash(String key){
		if (miMapeo.contains(key)){
			return miMapeo.get(key);
		}
		else{
			return "No esta en el iccionario";
		}
	}
}
