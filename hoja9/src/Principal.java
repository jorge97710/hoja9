

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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

/**
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 *  
 */
public class Principal {
	/*Atributos*/
	static String tipo = "",tipo2="",tipo3="";
	public boolean opcion = false, opcion1 = false, opcion2 = false;
	private JButton btnEnviar;
	private JFrame frame;
	private JTextField txtNombrea;
	private JCheckBox chckbxJava = new JCheckBox("");
	private JCheckBox chckbxWeb = new JCheckBox("");
	private int id = 0;
	private static  Diccionario dic = new Diccionario()  ;
	private JTextField textField;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	
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
		frame.setBounds(100, 100, 537, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNombre = new JLabel("Ingrese el directorio del diccionario:");

		btnEnviar = new JButton("Enviar");

		txtNombrea = new JTextField();
		txtNombrea.setColumns(10);
		 //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
		btnEnviar.addActionListener(new ManejadorEventos());
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblIngreseElDirectorio = new JLabel("Ingrese el directorio de oracion/palabra:");
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		scrollPane = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIngreseElDirectorio, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombrea, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(268, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(196))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(394, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNombre)
					.addGap(14)
					.addComponent(txtNombrea, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblIngreseElDirectorio)
					.addGap(7)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(305, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(68))
		);
		frame.getContentPane().setLayout(groupLayout);

		// Agregar listeners
		btnEnviar.addActionListener(new ManejadorEventos());
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

	
						//tipo2 = JOptionPane.showInputDialog("Ingrese el Directorio del diccionario : ");
						//tipo3 = JOptionPane.showInputDialog("Ingrese el Directorio de la oracion : ");

						dic.leerContenido(txtNombrea.getText());
						if(tipo.equals("HS")){
							dic.llenarHash();
							textPane.setText(dic.traducir(textField.getText()));	
						}
						else if(tipo.equals("SP")){
							dic.llenarArbol();
							textPane.setText(dic.traducir(textField.getText()));
						}			
			}
		}
	}
}

	

