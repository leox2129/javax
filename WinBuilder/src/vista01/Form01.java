package vista01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//using
import modelo.Persona;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

enum modo {
	  EDIT,
	  NORMAL
	}

public class Form01 extends JFrame {
	//private A
	private modo modoForm;
	private int filaSel;
	private static ArrayList<Persona> listaPersonas =new ArrayList<Persona>();
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	String[] columnNames = new String[] {
			"Id", "Nombre", "Apellido", "Edad"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form01 frame = new Form01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form01() {
		this.filaSel = -1;
		modoForm = modoForm.NORMAL;
		//inicializo el arreglo de personas
//		listaPersonas = new ArrayList<Persona>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1027, 351);
		contentPane = new JPanel();
		contentPane.setToolTipText("hola");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 28, 376, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Agregar Persona", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setToolTipText("Hola");
		panel.setBounds(428, 44, 573, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(22, 27, 55, 14);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(104, 24, 179, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(22, 69, 55, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(104, 66, 179, 20);
		panel.add(txtApellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(22, 117, 55, 14);
		panel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(104, 114, 179, 20);
		panel.add(txtEdad);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//programas el agregar persona a ArrayList	
				try {
					String nombreStr = txtNombre.getText();
					String apellidoStr = txtApellido.getText();
					String edadStr = txtEdad.getText();
					int edadInt = Integer.parseInt(edadStr);
					Persona persona= new Persona(nombreStr, apellidoStr, edadInt);
					listaPersonas.add(persona);
					actualizarTabla();					
				} catch (NumberFormatException e) {					
					// TODO: handle exception
//					error de convertir 
					
			
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}

			
		});
		btnAgregar.setBounds(323, 23, 89, 23);
		panel.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//programar edicion				
				try {
					filaSel = table.getSelectedRow();
					Persona persona = listaPersonas.get(filaSel);					
					txtApellido.setText(persona.getApellido());
					txtNombre.setText(persona.getNombre());				
					txtEdad.setText(String.valueOf(persona.getEdad()));
					modoForm = modo.EDIT;
					btnEditar.setText("Eitando"+persona.getId());
					
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "seleciona fila a editar");
				}
								
				
				/*id = Integer.parseInt((String)modelo.getValueAt(table.getSelectedRow(), 0));
				 = table.getSelectedRow();
				int dialogResult = JOptionPane.showConfirmDialog (null, 
						"Desea eliminar id:" + id,
						"Warning",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION) {				
					modelo.removeRow(this.indiceEdit);
					JOptionPane.showMessageDialog(null, "Exitosamente elimanda");
				}*/
				
			}
		});
		btnEditar.setBounds(323, 65, 89, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEliminar.setBounds(323, 113, 89, 23);
		panel.add(btnEliminar);
		
		//actualiza la tabla.
		actualizarTabla();
		
		
	}//end constructor
	
	
	private void actualizarTabla() {
		// TODO Auto-generated method stu
		
		int largo = listaPersonas.size();
		//cantidad de columnas de la laprimera fila 0, salida: 2 
		//int largo = datosAux[0].length;
        /*for (Integer i = 0; i < largo; i++) {
        	indice = (Integer) i;
            String mensaje = i + " producto";

            // Creamos un nuevo renglon para la tabla
            String[] datos = {(String)datosAux[i][0] , (String)datosAux[i][1] };
            // Agregamos los datos a la tabla
            modelo.addRow(datos);
        }*/
		
		
//		String[]  = new String[] {"ID", "Name"};
		
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(this.columnNames);		
		table.setModel(modelo);		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.setModel(modelo);
		
		for (int i = 0; i<largo ; i++) {
        	//indice = (Integer) i;
            String mensaje = i + " producto";
//            listaPersonas

            // Creamos un nuevo renglon para la tabla
//            String[] datos = {(String)datosAux[i][0] , (String)datosAux[i][1],
//            		string};
            
            
           //obtenemos la persona de la posicion 
           //i en el ArrayList personas.
           Persona persona = listaPersonas.get(i);
           //Persona(nombreStr, apellidoStr, edadInt)
           

           int idInt=persona.getId();
       	   String nombreStr= persona.getNombre();
       	   String apellidoStr=persona.getApellido();
       	   int edadInt=persona.getEdad();
           String idStr = String.valueOf(idInt);
           String edadStr= String.valueOf(edadInt);
       	   
//           "Id", "Nombre", "Apellido", "Edad"};
           
           String[] datos = { idStr,nombreStr ,apellidoStr,edadStr};
            
//            		string};
            // Agregamos los datos a la tabla
            modelo.addRow(datos);
        }
		
		
		/*table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Nombre", "Apellido", "Edad"
				}
			));*/
	}
}
