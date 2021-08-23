package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientos;

public class MenuPrincipalGUI extends JFrame {

	private JButton btnRequerimiento1;
	private JButton btnRequerimiento2;
	private JButton btnRequerimiento3;
	// private Component add;

	public MenuPrincipalGUI() {

	}

	private ImageIcon redimensionarIcono(ImageIcon icono, int pixeles) {
		Image image = icono.getImage();
		Image newimg = image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}

	// Metodo para composición
	public void iniciarGUI(ControladorRequerimientos controlador) {

		// Propiedades del frame
		setTitle("Menu Principal Reto 5");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Agregar componentes
		btnRequerimiento1 = new JButton(redimensionarIcono(new ImageIcon("img/ciudadano.png"), 64));
		btnRequerimiento1.setText("Requerimiento1");
		// Quien me va a escuchar
		btnRequerimiento1.addActionListener(controlador);
		// Qué voy a decir para que se haga lo que tengo asociado
		btnRequerimiento1.setActionCommand("Requerimiento1");

		btnRequerimiento2 = new JButton(redimensionarIcono(new ImageIcon("img/inventario.png"), 64));
		btnRequerimiento2.setText("Requerimiento2");
		btnRequerimiento2.addActionListener(controlador);
		btnRequerimiento2.setActionCommand("Requerimiento2");

		btnRequerimiento3 = new JButton(redimensionarIcono(new ImageIcon("img/deuda.png"), 64));
		btnRequerimiento3.setText("Requerimiento3");
		btnRequerimiento3.addActionListener(controlador);
		btnRequerimiento3.setActionCommand("Requerimiento3");

		// componente intermedio
		JPanel panel = new JPanel(new GridLayout(3, 1));
		panel.add(btnRequerimiento1);
		panel.add(btnRequerimiento2);
		panel.add(btnRequerimiento3);

		// Contenedor
		getContentPane().add(panel);

		// Mostrar ventana/frame
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
