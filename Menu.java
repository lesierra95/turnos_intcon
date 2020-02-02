package Turnos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class Menu {

	private JFrame frame;
	ListaEnfermeras lc=new ListaEnfermeras();
	private JTable tableEnfermeras;
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private JTextField textFieldTelef;
	private JTextField textFieldTurno;
	private JTextField textFieldEliminar;
	private Date fechaDeEjecucion = new Date();
	private JTextField textFieldInicio;
	private boolean bNueva ;
	JButton btnNuevaEnf = new JButton("Nueva");
	JButton btnGrabaEnf = new JButton("Grabar");		
	JButton btnModificaEnf = new JButton("Modificar");
	JButton btnBuscarEnf = new JButton("Buscar");
	JButton btnCancelar = new JButton("Calcelar");
	EnfermeraNodo Nodo=null;


	/**
	 *   application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 566, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(UIManager.getBorder("DesktopIcon.border"));
		
		DefaultTableModel dtm = new DefaultTableModel();
		String titulos[]={"ID", "Nombre Completo", "Teléfono","Ini.Turno(Sg)","Turno (Sg)","En Turno", "Asignada"};
		dtm.setColumnIdentifiers(titulos);
		
		JPanel panel = new JPanel();
		panel.setBounds(400, 147, -231, -80);
		frame.getContentPane().add(panel);

		pnlInfo.setBounds(10, 11, 421, 137);
		frame.getContentPane().add(pnlInfo);
		pnlInfo.setLayout(null);
		
		JCheckBox ChkAsignada = new JCheckBox("Asignada");
		ChkAsignada.setBounds(327, 72, 84, 23);
		pnlInfo.add(ChkAsignada);
		ChkAsignada.setEnabled(false);
		textFieldID = new JTextField();
		textFieldID.setBounds(83, 11, 56, 20);
		pnlInfo.add(textFieldID);

		textFieldID.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(83, 42, 328, 20);
		pnlInfo.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldTelef = new JTextField();
		textFieldTelef.setBounds(83, 73, 141, 20);
		pnlInfo.add(textFieldTelef);
		textFieldTelef.setColumns(10);
		
		JLabel label = new JLabel("ID");
		label.setBounds(10, 16, 65, 14);
		pnlInfo.add(label);
		
		JLabel label_2 = new JLabel("Nombre Enfermera");
		label_2.setBounds(10, 46, 90, 14);
		pnlInfo.add(label_2);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 76, 90, 14);
		pnlInfo.add(lblTelfono);
		
		textFieldTurno = new JTextField();
		textFieldTurno.setBounds(215, 11, 46, 20);
		pnlInfo.add(textFieldTurno);
		textFieldTurno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Turno(Sg)");
		lblNewLabel.setBounds(149, 16, 56, 14);
		pnlInfo.add(lblNewLabel);
		btnNuevaEnf.setBounds(5, 100, 70, 20);
		pnlInfo.add(btnNuevaEnf);		
		btnGrabaEnf.setBounds(78, 100, 75, 20);
		pnlInfo.add(btnGrabaEnf);
		btnModificaEnf.setBounds(155, 100, 92, 20);
		pnlInfo.add(btnModificaEnf);		
		btnBuscarEnf.setBounds(250, 100, 75, 20);
		pnlInfo.add(btnBuscarEnf);		
		btnCancelar.setBounds(327, 100, 85, 20);
		pnlInfo.add(btnCancelar);		


		textFieldInicio = new JTextField();
		textFieldInicio.setBounds(370, 11, 41, 20);
		pnlInfo.add(textFieldInicio);
		//Inicializar botones
		ControlesEstado("Inicial");		
		JCheckBox ChkEnTurno = new JCheckBox("En turno");
		ChkEnTurno.setEnabled(false);
		ChkEnTurno.setBounds(230, 72, 84, 23);
		pnlInfo.add(ChkEnTurno);
		

		textFieldInicio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ini.Turno(Sg)");
		lblNewLabel_2.setBounds(282, 16, 84, 14);
		pnlInfo.add(lblNewLabel_2);
		pnlInfo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldID, textFieldTurno, textFieldNombre, textFieldTelef, ChkEnTurno, ChkAsignada, label, label_2, lblTelfono, lblNewLabel, btnNuevaEnf, btnGrabaEnf}));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 533, 169);
		frame.getContentPane().add(scrollPane);
		
		tableEnfermeras = new JTable();
		scrollPane.setViewportView(tableEnfermeras);

		tableEnfermeras.setEnabled(false);
		tableEnfermeras.setAutoCreateRowSorter(true);
		tableEnfermeras.setFillsViewportHeight(true);
		tableEnfermeras.setRowSelectionAllowed(false);
		tableEnfermeras.setRequestFocusEnabled(false);
		tableEnfermeras.setUpdateSelectionOnSort(false);
		tableEnfermeras.setVerifyInputWhenFocusTarget(false);
		tableEnfermeras.setFocusTraversalKeysEnabled(false);
		tableEnfermeras.setFocusable(false);
		tableEnfermeras.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		tableEnfermeras.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tableEnfermeras.setName("");
		tableEnfermeras.setSurrendersFocusOnKeystroke(true);
		tableEnfermeras.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tableEnfermeras.setBackground(new Color(255, 255, 255));
		tableEnfermeras.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre Completo", "Teléfono","Turno (Sg)","Ini.Turno(Sg)","En Turno","Asignada"
			}
		) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class ,Long.class ,Long.class ,Boolean.class,Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableEnfermeras.setModel(dtm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBounds(441, 11, 99, 70);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 36, 79, 23);
		panel_1.add(btnEliminar);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(10, 11, 26, 14);
		panel_1.add(lblNewLabel_1);
		
		textFieldEliminar = new JTextField();
		textFieldEliminar.setBounds(28, 8, 61, 20);
		panel_1.add(textFieldEliminar);
		textFieldEliminar.setColumns(10);
		
		JButton btnAsigpaciente = new JButton("Asig.Paciente");
		btnAsigpaciente.setBounds(436, 92, 107, 23);
		
		frame.getContentPane().add(btnAsigpaciente);
		
		//Validaciones para que solo acepte numeros
		textFieldTelef.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c=arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '\b' /*corresponde a BACK_SPACE*/)){
		        //if(Character.isLetter(c)) {
		        	arg0.consume();
		         }	
			}
		});
		//Validaciones para que solo acepte numeros
		textFieldID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c=arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '\b' /*corresponde a BACK_SPACE*/)){
			        //if(Character.isLetter(c)) {
			    	arg0.consume();
		        }	
			}
		});
		//Validaciones para que solo acepte numeros
		textFieldTurno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c=arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '\b' /*corresponde a BACK_SPACE*/)){
			        //if(Character.isLetter(c)) {
			    	arg0.consume();
		        }	
			}
		});
		//Validaciones para que solo acepte numeros
		textFieldInicio.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c=arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '\b' /*corresponde a BACK_SPACE*/)){
			        //if(Character.isLetter(c)) {
			    	arg0.consume();
		        }	
			}
		});
		//Implementacion de los eventos de los botones y preparacion delos campos
		btnNuevaEnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlesEstado("Nuevo");		
				bNueva=true;
			}
		});
		btnAsigpaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  lc.AsignarTurno());
			}
		});
		btnModificaEnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlesEstado("Modifica");
			}
		});
		btnBuscarEnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		    	if (textFieldID.getText().isEmpty()   ) {
		    		JOptionPane.showMessageDialog(null, "Ingrese el ID");	
		    		return;
		    	}
		    	if (lc.existeEnfermera(Integer.parseInt(textFieldID.getText()))==true){
		    		//traer datos
		    		Nodo=null;
		    		Nodo = lc.TraerEnfermera(Integer.parseInt(textFieldID.getText()));
		    		textFieldNombre.setText(Nodo.nombreCompleto);
					textFieldTelef.setText(Double.toString( Nodo.telefonoContacto));
					textFieldTurno.setText (Integer.toString(Nodo.turnoSegundos));
					textFieldTelef.setEnabled(true);
					textFieldTurno.setEnabled(true);
		    		//Preparar para la editar los campos
					ControlesEstado("Nuevo");
					textFieldID.setEnabled(false);
					bNueva=false;
		    	}else{
		    		JOptionPane.showMessageDialog(null, "El ID:" + textFieldID.getText() + " No existe ..");	
		    		textFieldID.setText("");
		    	}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				int confirm = JOptionPane.showOptionDialog(frame,"Se perderan los cambios","Cancelar", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                	ControlesEstado("Inicial");
                }
			}					
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lc.existeEnfermera(Integer.parseInt(textFieldEliminar.getText()))==true){				
					JOptionPane.showMessageDialog(null,  lc.EliminarEnfermera(Integer.parseInt(textFieldEliminar.getText())));
				}else{
					JOptionPane.showMessageDialog(null,  "No se encuentra enfermera en el hospicio");	
				}				
			}
		});
		btnGrabaEnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		    	
				//Validar q los campos este llenos
				{
			    	if (textFieldID.getText().isEmpty()   ) {
			    		JOptionPane.showMessageDialog(null, "Ingrese el ID");	
			    		return;
			    	}
			    	if (textFieldNombre.getText().isEmpty()   ) {
			    		JOptionPane.showMessageDialog(null, "Ingrese Nombre de enfermera");		    		
			    		return;
			    	}
			    	if (textFieldTurno.getText().isEmpty()   ) {
			    		JOptionPane.showMessageDialog(null, "Ingrese el valor de los turnos");		    		
			    		return;
			    	}
			    	if (textFieldInicio.getText().isEmpty()   ) {
			    		JOptionPane.showMessageDialog(null, "Ingrese el valor para iniciar turno");		    		
			    		return;
			    	}
			    	if (textFieldTelef.getText().isEmpty()   ) {
			    		JOptionPane.showMessageDialog(null, "Ingrese el numero de telefono");		    		
			    		return;
			    	}
				}
				// verificar si es nueva
				if (bNueva) {
			    	if (lc.existeEnfermera(Integer.parseInt(textFieldID.getText()))==false){
			    		fechaDeEjecucion=new Date();
			    		EnfermeraNodo eN1=new EnfermeraNodo( Integer.parseInt(textFieldID.getText()), textFieldNombre.getText() ,
				    			Long.parseLong(textFieldTelef.getText()) ,Integer.parseInt(textFieldTurno.getText()),Integer.parseInt(textFieldInicio.getText()),ChkEnTurno.isSelected(),ChkAsignada.isSelected(),fechaDeEjecucion );	    		
				    	lc.insertarUltimo(eN1);
				    	ControlesEstado("Inicial");
			    	}else{
			    		JOptionPane.showMessageDialog(null, "El ID:" + textFieldID.getText() + " Ya existe ..");	
			    		textFieldID.setText("");
			    	}
			    	// cuando es modificacion					
				}else{
					Nodo.setNombreCompleto( textFieldNombre.getText());
					Nodo.setturnoSg(Integer.parseInt(textFieldTurno.getText()) );
					Nodo.setTelefonoContacto(Long.parseLong(textFieldTelef.getText() ));
					if (lc.ModificaEnfermera(Integer.parseInt(textFieldID.getText()), Nodo)){
			    		JOptionPane.showMessageDialog(null, "El ID:" + textFieldID.getText() + " fue modificado con exito");
			    		ControlesEstado("Inicial");
					}
				}
			}
		});
	     // Aquí se pone en marcha el timer .
	    Timer timer = new Timer();
	    // Dentro avísa cada 5000 milisegundos
	    timer.scheduleAtFixedRate(timerTask, 0, 5000); 
	}
	//Evento que se dispara cada 5000miliseg
    TimerTask timerTask = new TimerTask()
    {
        public void run() 
        {        	
        	Actualizar();
        }
    };

    //Funcion para preparar los botones de acuerdo a su estado
	public void ControlesEstado(String Estado){
		if (Estado=="Inicial"){
	    	textFieldNombre.setText("");	
			textFieldID.setText("");
			textFieldTelef.setText("");
			textFieldTurno.setText("");
			textFieldInicio.setText("");
			textFieldNombre.setEnabled(false);
			textFieldID.setEnabled(false);
			textFieldTelef.setEnabled(false);
			textFieldTurno.setEnabled(false);
			textFieldInicio.setEnabled(false);
			btnGrabaEnf.setEnabled(false);
			btnNuevaEnf.setEnabled(true);
			btnModificaEnf.setEnabled(true);
			btnBuscarEnf.setEnabled(false);
		}else{
			if (Estado=="Nuevo"){			    
				textFieldID.setEnabled(true); 
	    		textFieldNombre.setEnabled(true);
				textFieldTelef.setEnabled(true);
				textFieldTurno.setEnabled(true);
				textFieldInicio.setEnabled(true);
				btnGrabaEnf.setEnabled(true);
				btnNuevaEnf.setEnabled(false);
				btnModificaEnf.setEnabled(false);
				btnBuscarEnf.setEnabled(false);
			}else{
				if (Estado=="Modifica"){			    
					textFieldID.setEnabled(true); 				
					btnBuscarEnf.setEnabled(true);
					btnGrabaEnf.setEnabled(false);
					btnNuevaEnf.setEnabled(false);
					btnModificaEnf.setEnabled(false);
				}
			}
		}
	}
    
	// funcion que dispara el timer
	// para llenar el jtable cada 5000 miliseg, con la nueva informacion de enfermeras
	public void Actualizar(){
		int iCantidad = 0;
		int iContador = 1;
		iCantidad =  lc.CantidadEnfermeras();
		//Encabezado del Jtable
		tableEnfermeras.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"ID", "Nombre Completo", "Teléfono","Turno(Sg)","Ini.Turno(Sg)", "En Turno","Asignada" }
		) {Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Long.class, Long.class ,Boolean.class,Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		Object[] datosDeLaFila = null; 
		// Ciclo para adicionar a la table
		while (iContador <=iCantidad){
			lc.ActualizarTurno(iContador);
			datosDeLaFila =  lc.imprimirTable(iContador);		     
	        DefaultTableModel modeloDeLaTabla=(DefaultTableModel)tableEnfermeras.getModel();			     
	        modeloDeLaTabla.addRow(datosDeLaFila);		        
	        tableEnfermeras.setModel(modeloDeLaTabla);           
            iContador++;
        }
	}
}
