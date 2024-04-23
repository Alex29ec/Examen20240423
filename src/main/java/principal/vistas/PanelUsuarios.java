package principal.vistas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import principal.controladores.ControladorUsuarios;
import principal.entidades.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JTextField jtfEmail;
	private JPasswordField JtfContraseña;
	JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public PanelUsuarios(Usuario u) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion de Usuarios");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblId = new JLabel("Id: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField(String.valueOf(u.getId()));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 2;
		add(lblUsuario, gbc_lblUsuario);
		
		jtfUsuario = new JTextField(u.getNombreUsuario());
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 2;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña: ");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 3;
		add(lblContrasea, gbc_lblContrasea);
		
		JtfContraseña = new JPasswordField(u.getPassword());
		GridBagConstraints gbc_jtfContraseña = new GridBagConstraints();
		gbc_jtfContraseña.insets = new Insets(0, 0, 5, 0);
		gbc_jtfContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfContraseña.gridx = 1;
		gbc_jtfContraseña.gridy = 3;
		add(JtfContraseña, gbc_jtfContraseña);
		
		JLabel lblEmail = new JLabel("Email :");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField(u.getEmail());
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 4;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblColorPreferido = new JLabel("Color Preferido :");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 5;
		add(lblColorPreferido, gbc_lblColorPreferido);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		add(comboBox, gbc_comboBox);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		add(btnNewButton, gbc_btnNewButton);
		CargarNotas();
		selectColor(u);
	}
	
	public void CargarNotas() {
		comboBox.addItem("#FF00FF");

		comboBox.addItem("#9890A5");

		comboBox.addItem("#765456");

		comboBox.addItem("#879876");
		
	}
	
	
	private void guardar() {

		Usuario p = (Usuario) ControladorUsuarios.findArtById(Integer.parseInt(this.jtfId.getText()));

		if (!this.jtfId.equals("") || !this.JtfContraseña.equals("")) {
			p.setColorPreferido(String.valueOf(comboBox.getSelectedItem()));
			p.setEmail(String.valueOf(jtfEmail.getText()));
			p.setId(Integer.valueOf(jtfId.getText()));
			p.setNombreUsuario(String.valueOf(jtfUsuario.getText()));
			ControladorUsuarios.update(p);
			JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
		}
		else {
			JOptionPane
		.showMessageDialog(null, "No se ha podido guardar, la fecha no es válida");
		}
		selectColor(p);
	}
	
	private void selectColor(Usuario o) {
		Color color = Color.decode(o.getColorPreferido());
		this.setBackground(color);
	}

}
