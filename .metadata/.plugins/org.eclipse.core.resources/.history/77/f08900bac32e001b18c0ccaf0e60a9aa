package vista01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class WinBuilder {

	private JFrame frame;
	private JTextField txtNombre;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinBuilder window = new WinBuilder();
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
	public WinBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 644, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(24, 11, 73, 39);
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(107, 11, 184, 39);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("AgregarPersona");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				JOptionPane.showMessageDialog(new JFrame(), 
						"seleccionado:" +nombre, 
						"título de la ventana", 
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAgregar.setBounds(24, 72, 267, 31);
		frame.getContentPane().add(btnAgregar);
		
		table = new JTable();
		table.setBounds(272, 244, -175, -109);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(310, 212, 184, -77);
		frame.getContentPane().add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(366, 127, 154, -56);
		frame.getContentPane().add(table_2);
	}
}
