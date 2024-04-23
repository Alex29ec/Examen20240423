package principal.vistas;

import javax.swing.JPanel;

import principal.Principal;
import principal.controladores.ControladorContratoJPA;
import principal.controladores.ControladorUsuarios;
import principal.entidades.Contrato;
import principal.entidades.Usuario;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class PanelGestionContrato extends JPanel {

	static PanelGestionContrato instance = null;
	

	public static PanelGestionContrato getInstance() {
		if (instance == null) {
			instance = new PanelGestionContrato();
		}
		return instance;
	}
	
	private static final long serialVersionUID = 1L;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtflimite;
	private JTextField jtfFecha;
	private JTextField jtfId;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnCuentaB;
	JRadioButton rdbtnTarjetaC;
	JRadioButton rdbtnTarjetaD;
	JRadioButton rdbtnPrestamo;
	JComboBox<Usuario> jcbUsuarios;
	/**
	 * Create the panel.
	 */
	public PanelGestionContrato(Contrato c) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion de Contratos");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField(String.valueOf(c.getId()));
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato:");
		GridBagConstraints gbc_lblTipoDeContrato = new GridBagConstraints();
		gbc_lblTipoDeContrato.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeContrato.gridx = 0;
		gbc_lblTipoDeContrato.gridy = 2;
		add(lblTipoDeContrato, gbc_lblTipoDeContrato);
		
		rdbtnCuentaB = new JRadioButton("Cuenta Bancaria");
		buttonGroup.add(rdbtnCuentaB);
		GridBagConstraints gbc_rdbtnCuentaB = new GridBagConstraints();
		gbc_rdbtnCuentaB.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCuentaB.gridx = 1;
		gbc_rdbtnCuentaB.gridy = 2;
		add(rdbtnCuentaB, gbc_rdbtnCuentaB);
		
		 rdbtnTarjetaC = new JRadioButton("Tarjeta Credito");
		buttonGroup.add(rdbtnTarjetaC);
		GridBagConstraints gbc_rdbtnTarjetaC = new GridBagConstraints();
		gbc_rdbtnTarjetaC.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnTarjetaC.gridx = 2;
		gbc_rdbtnTarjetaC.gridy = 2;
		add(rdbtnTarjetaC, gbc_rdbtnTarjetaC);
		
		 rdbtnTarjetaD = new JRadioButton("Tarjeta Debito");
		buttonGroup.add(rdbtnTarjetaD);
		GridBagConstraints gbc_rdbtnTarjetaD = new GridBagConstraints();
		gbc_rdbtnTarjetaD.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTarjetaD.gridx = 1;
		gbc_rdbtnTarjetaD.gridy = 3;
		add(rdbtnTarjetaD, gbc_rdbtnTarjetaD);
		
		 rdbtnPrestamo = new JRadioButton("Prestamo");
		buttonGroup.add(rdbtnPrestamo);
		GridBagConstraints gbc_rdbtnPrestamo = new GridBagConstraints();
		gbc_rdbtnPrestamo.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPrestamo.gridx = 2;
		gbc_rdbtnPrestamo.gridy = 3;
		add(rdbtnPrestamo, gbc_rdbtnPrestamo);
		
		JLabel lblNewLabel_1 = new JLabel(" Descripcion :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfDescripcion = new JTextField(c.getDescripcion());
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 4;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbUsuarios = new JComboBox<Usuario>();
		GridBagConstraints gbc_jcbUsuarios = new GridBagConstraints();
		gbc_jcbUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuarios.gridx = 1;
		gbc_jcbUsuarios.gridy = 5;
		add(jcbUsuarios, gbc_jcbUsuarios);
		
		JButton btnGestionarUsuarios = new JButton("Gestionar Usuario");
		btnGestionarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelUsuarios pu = new PanelUsuarios((Usuario) jcbUsuarios.getSelectedItem());
				abrirNuevoDialogo(pu);
				
			}
		});
		GridBagConstraints gbc_btnGestionarUsuarios = new GridBagConstraints();
		gbc_btnGestionarUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestionarUsuarios.gridx = 2;
		gbc_btnGestionarUsuarios.gridy = 5;
		add(btnGestionarUsuarios, gbc_btnGestionarUsuarios);
		
		JLabel lblSaldo = new JLabel("Saldo (€) :");
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.anchor = GridBagConstraints.EAST;
		gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldo.gridx = 0;
		gbc_lblSaldo.gridy = 6;
		add(lblSaldo, gbc_lblSaldo);
		
		jtfSaldo = new JTextField(String.valueOf(c.getSaldo()));
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 6;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblLimite = new JLabel("Limite (€) :");
		GridBagConstraints gbc_lblLimite = new GridBagConstraints();
		gbc_lblLimite.anchor = GridBagConstraints.EAST;
		gbc_lblLimite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimite.gridx = 0;
		gbc_lblLimite.gridy = 7;
		add(lblLimite, gbc_lblLimite);
		
		jtflimite = new JTextField(String.valueOf(c.getLimite()));
		GridBagConstraints gbc_jtflimite = new GridBagConstraints();
		gbc_jtflimite.gridwidth = 2;
		gbc_jtflimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtflimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtflimite.gridx = 1;
		gbc_jtflimite.gridy = 7;
		add(jtflimite, gbc_jtflimite);
		jtflimite.setColumns(10);
		
		JLabel lblFechaDeFirma = new JLabel("Fecha de Firma :");
		GridBagConstraints gbc_lblFechaDeFirma = new GridBagConstraints();
		gbc_lblFechaDeFirma.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFirma.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFirma.gridx = 0;
		gbc_lblFechaDeFirma.gridy = 8;
		add(lblFechaDeFirma, gbc_lblFechaDeFirma);
		
		jtfFecha = new JTextField(dateToString(c.getFechaFirma()));
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 8;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 9;
		add(btnGuardar, gbc_btnGuardar);
		cargarTipoContrato(c);
		cargarUsuarios();
		selUsuario(c);
	}
	
	public PanelGestionContrato() {
		// TODO Auto-generated constructor stub
	}

	public void abrirNuevoDialogo(JPanel panel) {
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión de Usuarios");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(panel);
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
	
	public void selUsuario(Contrato o) {
		for (int i = 0; i < this.jcbUsuarios.getItemCount(); i++) {
			if (this.jcbUsuarios.getItemAt(i).getId() == o.getId()) {
				this.jcbUsuarios.setSelectedIndex(i);
			}
		}
	}
	
	private void cargarTipoContrato(Contrato c){
		if(c.getIdTipoContrato()==1) {
			this.rdbtnCuentaB.setSelected(true);
		}
		if(c.getIdTipoContrato()==2) {
			this.rdbtnTarjetaD.setSelected(true);
		}
		if(c.getIdTipoContrato()==3) {
			this.rdbtnTarjetaC.setSelected(true);
		}
		if(c.getIdTipoContrato()==4) {
			this.rdbtnPrestamo.setSelected(true);
		}
			
	}
	private void guardar() {
		if (this.jtfId.getText().isEmpty()) {
			if (isCodigoValido()) {
				if (esPrecioFloat()) {
						Contrato o = new Contrato();
						Usuario p = (Usuario) this.jcbUsuarios.getSelectedItem();
						o.setDescripcion(String.valueOf(jtfDescripcion.getText()));
						o.setFechaFirma(deStringADate(this.jtfFecha.getText()));
						
						o.setId(Integer.valueOf(jtfId.getText()));
						if (rdbtnCuentaB.isSelected()) {
							o.setIdTipoContrato(1);
						}
						if (rdbtnTarjetaD.isSelected()) {
							o.setIdTipoContrato(2);
						}
						if (rdbtnTarjetaC.isSelected()) {
							o.setIdTipoContrato(3);
						}
						if (rdbtnPrestamo.isSelected()) {
							o.setIdTipoContrato(4);
						}

						
						o.setIdUsuario(p.getId());
						o.setLimite(Float.valueOf(jtflimite.getText()));
						o.setSaldo(Float.valueOf(jtfSaldo.getText()));
						
						ControladorContratoJPA.insert(o);

						JOptionPane.showMessageDialog(null, "Articulo creado con éxito");
						
						Contrato a = ControladorContratoJPA.findArtById(o.getId());
						this.jtfDescripcion.setText(a.getDescripcion());
						this.jtflimite.setText(String.valueOf(a.getLimite()));
						this.jtfId.setText(String.valueOf(a.getId()));
						this.jtfSaldo.setText(String.valueOf(a.getSaldo()));
						this.jtfFecha.setText(dateToString(a.getFechaFirma()));
						selUsuario(o);
						cargarTipoContrato(o);
					} else {
						JOptionPane.showMessageDialog(null, "Error al guardar, el stock no es válido");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Error al guardar, el precio no es válido");
				}

			

		} else {
			Contrato o = ControladorContratoJPA.findArtById(Integer.valueOf(this.jtfId.getText()));
			if (isCodigoValido()) {
				if (esPrecioFloat()) {
						Contrato c = new Contrato();
						Usuario p = (Usuario) this.jcbUsuarios.getSelectedItem();
						c.setDescripcion(String.valueOf(jtfDescripcion.getText()));
						c.setFechaFirma(deStringADate(this.jtfFecha.getText()));
						
						c.setId(Integer.valueOf(jtfId.getText()));
						if (rdbtnCuentaB.isSelected()) {
							c.setIdTipoContrato(1);
						}
						if (rdbtnTarjetaD.isSelected()) {
							c.setIdTipoContrato(2);
						}
						if (rdbtnTarjetaC.isSelected()) {
							c.setIdTipoContrato(3);
						}
						if (rdbtnPrestamo.isSelected()) {
							c.setIdTipoContrato(4);
						}

						
						c.setIdUsuario(p.getId());
						c.setLimite(Float.valueOf(jtflimite.getText()));
						c.setSaldo(Float.valueOf(jtfSaldo.getText()));
						
						ControladorContratoJPA.update(c);
						JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
					} else {
						JOptionPane.showMessageDialog(null, "Error al guardar, el stock no es valido");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Error al guardar, el precio no es valido");
				}

			

		}

	}
	
	private boolean isCodigoValido() {
		String str = this.jtfDescripcion.getText();
		if (str.length() < 3) {
			return false;
		}
		return true;
	}
	
	public boolean esPrecioFloat() {
		try {
			Float.parseFloat(this.jtfSaldo.getText());
			Float.parseFloat(this.jtflimite.getText());
			
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	private void cargarUsuarios() {
		List<Usuario> l = ControladorUsuarios.findAll();
		for (Usuario proveedor : l) {
			this.jcbUsuarios.addItem(proveedor);
			;
		}

	}
	public static String dateToString(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
	}
	
	public static Date deStringADate(String texto) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date fecha = sdf.parse(texto);
			return fecha; // Si la cadena se puede parsear como fecha, entonces tiene el formato correcto
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Error, la fecha no tiene un formato valido");
			return null; // Si hay una excepción al parsear, significa que no tiene el formato correcto
		}
	}
}
