

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
/**
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 *  
 */
public class Principal {
	/*Atributos*/
	static String tipo = "";
	public boolean opcion = false, opcion1 = false, opcion2 = false;
	private JButton btnEnviar, btnMostrarResultados;
	private JFrame frame;
	private JTextField txtNombrea;
	private JCheckBox chckbxJava = new JCheckBox("");
	private JCheckBox chckbxWeb = new JCheckBox("");
	private int id = 0;
	

	/**
	 * Correr el programa 
	 */
	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null,
				"Por favor ingrese la implementacion de mapeo que desee utilizar\n"
						+ "Para SplayTree ingrese ''SP''\n"
						+ "Para HashMap ingrese ''HS''\n",
				"Datos necesarios", JOptionPane.INFORMATION_MESSAGE);
		tipo = JOptionPane.showInputDialog("Ingrese el tipo: ");
		defensiva(tipo);
		listo(tipo); 
		Principal window = new Principal();
		window.frame.setVisible(true);

	}

	/**
	 * Crear la aplicacion
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializar componentes graficos
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Ingrese la palabra:");
		lblNombre.setBounds(22, 23, 134, 14);
		frame.getContentPane().add(lblNombre);

		JLabel lblAmbientes = new JLabel("Seleccione la opci\u00F3n eseaa");
		lblAmbientes.setBounds(258, 23, 143, 14);
		frame.getContentPane().add(lblAmbientes);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(164, 162, 86, 35);
		frame.getContentPane().add(btnEnviar);

		btnMostrarResultados = new JButton("Mostrar Resultados");
		btnMostrarResultados.setBounds(10, 162, 146, 35);
		frame.getContentPane().add(btnMostrarResultados);

		chckbxJava = new JCheckBox("Traucir palabra");
		chckbxJava.setBounds(282, 44, 108, 35);
		frame.getContentPane().add(chckbxJava);

		chckbxWeb = new JCheckBox("Traucir oraci\u00F3n");
		chckbxWeb.setBounds(282, 85, 108, 35);
		frame.getContentPane().add(chckbxWeb);

		txtNombrea = new JTextField();
		txtNombrea.setBounds(10, 51, 233, 28);
		frame.getContentPane().add(txtNombrea);
		txtNombrea.setColumns(10);

		// Agregar listeners
		btnEnviar.addActionListener(new ManejadorEventos());
		btnMostrarResultados.addActionListener(new ManejadorEventos());
		chckbxJava.addActionListener(new ManejadorEventos());
		chckbxWeb.addActionListener(new ManejadorEventos());
	}
	/**
	 * Metodo simple para verificar si no se ingreso una opcion de implementacion
	 * adecuada.
	 * @param s contiene el texto ingresado por el usuario
	 */
	static void defensiva(String s) {
		if (s == null) {
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
			System.exit(0);
		} else if (!(s.equalsIgnoreCase("HS") || s.equalsIgnoreCase("SP"))) {
			JOptionPane.showMessageDialog(null,
					"No ha ingresado una opcion valida");
			System.exit(0);
		}
	}
	/**
	 * Metodo para instaciar la coleccion deseada.
	 * @param tipo para seleccionar implementacion a usar
	 */
	static void listo(String tipo){
		MapeoFactory  mapeoFactory = new Factory ();
		Mapeo miMapeo = mapeoFactory.getMapeo(tipo);	
	}

	//Inner class para manejar eventos
	private class ManejadorEventos implements ActionListener {
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//Para enviar datos, y asignar ambientes
			if (e.getSource() == btnEnviar) {

				if (chckbxJava.isSelected()) {
					opcion = true;
				} else {
					opcion = false;

				}
				if (chckbxWeb.isSelected()) {
					opcion1 = true;

				} else {
					opcion1 = false;

				}
				//Anadir elementos a coleccion
				//id++;
				//milogica.anadir(txtNombrea.getText(), opcion1,
						//opcion, opcion2, id);

			}
			//Desplegar resultados
			if (e.getSource() == btnMostrarResultados) {
				//milogica.desplegar();
			}
		}
	}
}

	

