package uiDesktop;

import java.awt.EventQueue;

import negocio.*;
import entidades.*;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import org.omg.CORBA.portable.ApplicationException;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
public class ABMCPersonaje {

	private JFrame frame;
	private JTextField cod;
	private JTextField nom;
	private JTextField energia;
	private JTextField vida;
	private JTextField evasion;
	private JTextField def;
	private JTextField ptosTot;
	
	private CtrlABMPersonaje ctrl;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaje window = new ABMCPersonaje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMCPersonaje() {
		initialize();
		ctrl = new CtrlABMPersonaje();
		
	};

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cod = new JTextField();
		cod.setBounds(84, 59, 40, 20);
		frame.getContentPane().add(cod);
		cod.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:  ");
		lblCodigo.setBounds(30, 62, 55, 14);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:  ");
		lblNombre.setBounds(150, 62, 55, 14);
		frame.getContentPane().add(lblNombre);
		
		nom = new JTextField();
		nom.setBounds(200, 59, 145, 20);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(42, 107, 46, 14);
		frame.getContentPane().add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(42, 132, 46, 14);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(42, 157, 46, 14);
		frame.getContentPane().add(lblVida);
		
		JLabel lblEvasion = new JLabel("Evasion");
		lblEvasion.setBounds(42, 180, 46, 14);
		frame.getContentPane().add(lblEvasion);
		
		energia = new JTextField();
		energia.setBounds(94, 104, 34, 20);
		frame.getContentPane().add(energia);
		energia.setColumns(10);
		
		vida = new JTextField();
		vida.setColumns(10);
		vida.setBounds(94, 154, 34, 20);
		frame.getContentPane().add(vida);
		
		evasion = new JTextField();
		evasion.setColumns(10);
		evasion.setBounds(94, 177, 34, 20);
		frame.getContentPane().add(evasion);
		
		def = new JTextField();
		def.setBounds(93, 129, 35, 20);
		frame.getContentPane().add(def);
		def.setColumns(10);
		
		ptosTot = new JTextField();
		ptosTot.setBounds(94, 210, 34, 20);
		frame.getContentPane().add(ptosTot);
		//textField_6.setText("200");
		ptosTot.setColumns(10);
		
		
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setBounds(73, 233, 104, 20);
		frame.getContentPane().add(lblPuntosTotales);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(344, 104, 89, 23);
		frame.getContentPane().add(btnCrear);
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(344, 150, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(344, 192, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(344, 232, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JTextPane condDef = new JTextPane();
		condDef.setFont(new Font("Tahoma", Font.BOLD, 11));
		condDef.setBackground(SystemColor.control);
		condDef.setBounds(139, 129, 98, 20);
		frame.getContentPane().add(condDef);
		
		JTextPane condEv = new JTextPane();
		condEv.setFont(new Font("Tahoma", Font.BOLD, 11));
		condEv.setBackground(SystemColor.control);
		condEv.setBounds(139, 177, 98, 20);
		frame.getContentPane().add(condEv);
		
		JRadioButton newPers = new JRadioButton("Nuevo Personaje");
		newPers.setBounds(351, 58, 123, 23);
		//rdbtnNuevoPersonaje.setText("Nuevo Personaje");
		//newPers.setSelected(true);
		frame.getContentPane().add(newPers);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setBounds(199, 261, 89, 23);
		frame.getContentPane().add(exit);
		newPers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					if (newPers.isSelected()==true)
						{ptosTot.setText("200");
						energia.setText("0");
						def.setText("0");
						vida.setText("0");
						evasion.setText("0");
						nom.setText("Ingrese nombre");
						 condEv.setText("Max 80 puntos");
						 condDef.setText("Max 20 puntos");
						 }
					else{	ptosTot.setText("");
							energia.setText("");
							def.setText("");
							vida.setText("");
							evasion.setText("");
							nom.setText("");
							condEv.setText("");
							condDef.setText("");
						};
			}
		});
		

	};
///METODOS/////////////////////	
			protected void agregar() {
				
				
				if(datosValidos()){
					JOptionPane.showMessageDialog(null, "TODO OK");
						/*Personaje p=MapearDeFormulario();
						ctrl.add(p);
						MapearAFormulario(p);
						//limpiarCampos();*/
					 
						
					
				}
			}
			public Personaje MapearDeFormulario(){
				Personaje p = new Personaje();
				
				p.setEnergia(Integer.parseInt(energia.getText()));
				p.setDefensa(Integer.parseInt(def.getText()));
				p.setVida(Integer.parseInt(vida.getText()));
				p.setEvasion(Integer.parseInt(evasion.getText()));
				p.setNombre(nom.getText());
				
				
				return p;
			}
			
			
			public boolean datosValidos(){
				boolean valido=true;
				int suma=0;
				suma= Integer.parseInt(def.getText()) + Integer.parseInt(evasion.getText()) + Integer.parseInt(vida.getText()) + Integer.parseInt(energia.getText());
				
				if(!energia.getText().matches("[0-9]*"))
				{
				JOptionPane.showMessageDialog(null, "LA ENERGIA NO ES UN NUMERO");
				 valido=false;
				 energia.setText("0");
				
				if((!def.getText().matches("[0-9]*")) || Integer.parseInt(def.getText())>=20 )
				{
					JOptionPane.showMessageDialog(null, "DEFENSA MAYOR A 20 O NO ES UN NUMERO");
					 valido=false;
					 def.setText("0"); 
				}
				
				if(!evasion.getText().matches("[0-9]*") || Integer.parseInt(evasion.getText())>=80)
				{
				JOptionPane.showMessageDialog(null, "EVASION MAYOR A 80 o NO ES UN NUMERO");
				 valido=false;
				 evasion.setText("0");
				}
				
				
				}
				if(!vida.getText().matches("[0-9]*"))
				{
				JOptionPane.showMessageDialog(null, "LA VIDA NO ES UN NUMERO");
				 valido=false;
				 vida.setText("0");
				}
				
				
				if(suma>200)
				{
				JOptionPane.showMessageDialog(null, "PUNTOS ASIGNADOS MAYORES A LOS TOTALES");
				 valido=false;
				 energia.setText("0");
				 def.setText("0");
				 vida.setText("0");
				 evasion.setText("0");
				 
				}
				return valido;
				
			}

///METODOS/////////////////////		
			
};
		
	
		
	

	

