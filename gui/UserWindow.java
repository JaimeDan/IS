package is.gui;

import is.Usuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




@SuppressWarnings("serial")
public class UserWindow extends JFrame  {
	
	public void initializeGUI(){
		this.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(quit);
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				CloseApp.quitApp();		
			}
			
		});
		this.setJMenuBar(menuBar);	
		
		ImageIcon kike = createImageIcon("images/kikeHost2.png", "KIKE");
		logo = new JLabel(kike);
		logo.setSize(20, 20);

		this.add(logo, BorderLayout.NORTH);
		front = new JPanel();
		//front.setLayout(new GridLayout(3,1));
		front.setLayout(new FlowLayout(1));
		JPanel usuario = new JPanel();

		usuario.setLayout(new GridLayout(2,1));
		//usuario.setLayout(new FlowLayout(2));
		
		JPanel contrasena = new JPanel();
		contrasena.setLayout(new GridLayout(2,1));
		//contrasena.setLayout(new FlowLayout(2));
		
		JLabel textoUsuario = new JLabel("USUARIO");
		textoUsuario.setOpaque(true);
		usuario.add(textoUsuario, BorderLayout.NORTH);
		user = new JTextField(10);
		usuario.add(user);
		
		JLabel textoContrasena = new JLabel("CONTRASEÑA");
		textoUsuario.setOpaque(true);
		contrasena.add(textoContrasena, BorderLayout.NORTH);
		password = new JPasswordField(10);
		password.getPassword();
		
		contrasena.add(password);
		front.add(usuario);
		front.add(contrasena);

		front.add(new JButton("Entrar") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!user.getText().isEmpty()){
							if(registroCorrecto()) mostrarRestaurante();
							/*
							if (controler.buscaCliente(user.getText())){
								if (controler.getCliente(user.getText()).passWord(password.getPassword())){
									password.setText(null);
									controller.iniciaSesion(user.getText());
								}else showMessage("Usuario o contraseña incorrectos");
								
							}else showMessage("Usuario o contraseña incorrectos");
							*/
						}
						
					}

				
				});
				
			}

		});
		this.add(front);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		RestauranteSwing rest = new RestauranteSwing();

		if (true) { //Si el login es correcto (hay que implementar eso, se borra todo y se muestra la pantalla del restaurante

		}

		
	}
	
	public UserWindow(){
		super("KIKE HOSTELERIA S.A.");
		this.setSize(800, 600);
		initializeGUI();
		usuarios = new Usuario[1];
		usuarios[0] = new Usuario("Scrugo", "huelomal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void mostrarRestaurante(){

		this.remove(logo);

		this.remove(front);
		this.setSize(400,300);
		RestauranteSwing rest = new RestauranteSwing();
		this.add(rest);
		
	}
	private boolean registroCorrecto(){
		boolean b = false;
	//	for (Usuario u : usuarios)
			for (int i = 0; i< usuarios.length && !b; i++){
				if (user.getText().equals(usuarios[i].getId()) && passwordCorrecto(password.getPassword(), usuarios[i].getPassword()))  b = true;
			}
		return b;
	}
	private boolean passwordCorrecto(char[] p1, char[] p2){
		boolean b = true;
		if (p1.length != p2.length) return false;
		else for (int i = 0; i < p1.length && b; i++){
			if (p1[i] != p2[i]) b = false;
	
		}
		return b;
		
		
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	
	private JMenuBar menuBar;
	JTextField user;
	JPasswordField password;
	Usuario[] usuarios;
	JLabel logo;
	JPanel front;
	RestauranteSwing rest;
	
	//Ideas:
	/**
	 * Una clase usuario general de la que hereden las subclases jefe, chef, camarero... aunque solo implementaremos chef.
	 * Cada usuario tendra nombre y contraseña
	 * Para ver si el inicio es valido, recorre los usuarios viendo si su nombre encaja con el introducido
	 * En caso afirmativo se comprueba la contraseña
	 * Si todo encaja, borra los paneles y pone el panel correspondiente al tipo de empleado
	 * En este caso el panel de restaurante con sus botones y tal
	 * 	
	 * A implementar!
	 */
	
	
}