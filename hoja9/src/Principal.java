

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 *  
 */
public class Principal {
	/*Atributos*/
	static String tipo = "",tipo2="";
	public boolean opcion = false, opcion1 = false, opcion2 = false;
	private JButton btnEnviar, btnMostrarResultados;
	private JFrame frame;
	private JTextField txtNombrea;
	private JCheckBox chckbxJava = new JCheckBox("");
	private JCheckBox chckbxWeb = new JCheckBox("");
	private int id = 0;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private static Diccionario dic = new Diccionario()  ;
	
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
		dic.listo(tipo); 
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

		JLabel lblNombre = new JLabel("Ingrese la palabra:");

		JLabel lblAmbientes = new JLabel("Seleccione la opci\u00F3n eseaa");

		btnEnviar = new JButton("Enviar");

		btnMostrarResultados = new JButton("Mostrar Resultados");

		txtNombrea = new JTextField();
		txtNombrea.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Traucir palabra");
		
		rdbtnNewRadioButton_1 = new JRadioButton("Traucir oraci\u00F3n");
		 //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
		// Agregar listeners
		btnMostrarResultados.addActionListener(new ManejadorEventos());
		btnEnviar.addActionListener(new ManejadorEventos());
		rdbtnNewRadioButton.addActionListener(new ManejadorEventos());
		rdbtnNewRadioButton_1.addActionListener(new ManejadorEventos());

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(btnMostrarResultados, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(rdbtnNewRadioButton_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(txtNombrea, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(22)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addGap(102)
								.addComponent(lblAmbientes, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblAmbientes))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombrea, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton))
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMostrarResultados, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		frame.getContentPane().setLayout(groupLayout);

		// Agregar listeners
		btnEnviar.addActionListener(new ManejadorEventos());
		btnMostrarResultados.addActionListener(new ManejadorEventos());
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


	//Inner class para manejar eventos
	private class ManejadorEventos implements ActionListener {
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//Para enviar datos, y asignar ambientes
			if (e.getSource() == btnEnviar) {

				if (rdbtnNewRadioButton.isSelected()) {
					opcion = true;
				} else {
					opcion = false;

				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					opcion1 = true;

				} else {
					opcion1 = false;

				}
				if (opcion==false &&opcion1==false){
					JOptionPane.showMessageDialog(null, "Seleccione una opcion a traucir");
				}
				else {
						tipo2 = JOptionPane.showInputDialog("Ingrese el irectorio: ");
						dic.leerContenido(tipo2);
						if(tipo.equals("HS")){
							dic.llenarHash();
						}
						else if(tipo.equals("SP")){
							dic.llenarArbol();
						}
						
					
				}
			}
			//Desplegar resultados
			if (e.getSource() == btnMostrarResultados) {
				if(tipo.equals("HS")){
					System.out.println(dic.buscarHash(txtNombrea.getText()));	
				}
				else if (tipo.equals("SP")){
					System.out.println(dic.buscarArbol(txtNombrea.getText()));	
				}
				
			}
		}
	}
}

	

