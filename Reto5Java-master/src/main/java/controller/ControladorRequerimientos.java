package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;

//Requerimiento 1
import model.vo.Requerimiento_1;
import model.dao.Requerimiento_1Dao;

//Requerimiento 2
import model.vo.Requerimiento_2;
import model.dao.Requerimiento_2Dao;

//Requerimiento 3
import model.vo.Requerimiento_3;
import model.dao.Requerimiento_3Dao;

//View
import view.MenuPrincipalGUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Alojar objetos del modelo
public class ControladorRequerimientos implements ActionListener {
	private final Requerimiento_1Dao requerimiento1;
	private final Requerimiento_2Dao requerimiento2;
	private final Requerimiento_3Dao requerimiento3;

	// Alojar objetos de la vista
	private final MenuPrincipalGUI menuPrincipalGUI;

	// Constructor
	public ControladorRequerimientos() {

		this.requerimiento1 = new Requerimiento_1Dao();
		this.requerimiento2 = new Requerimiento_2Dao();
		this.requerimiento3 = new Requerimiento_3Dao();
		// Instanciamos las interfaces
		this.menuPrincipalGUI = new MenuPrincipalGUI();
	}

	// Cada requerimiento solicitado -> Casos de Uso

	public ArrayList<Requerimiento_1> consultarRequerimiento1() throws SQLException {
		return this.requerimiento1.requerimiento1();
	}

	public ArrayList<Requerimiento_2> consultarRequerimiento2() throws SQLException {
		return this.requerimiento2.requerimiento2();
	}

	public ArrayList<Requerimiento_3> consultarRequerimiento3() throws SQLException {
		return this.requerimiento3.requerimiento3();
	}

	// Controlador iniciando la aplicacion
	public void iniciarAplicacion() {
		this.menuPrincipalGUI.iniciarGUI(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Obtener el evento asociado al botón
		String actionCommand = ((JButton) e.getSource()).getActionCommand();

		switch (actionCommand) {

			case "Requerimiento 1":
				System.out.println("Interfaz LIDERES en contrucción!");
				break;

			case "Requerimiento 2":
				System.out.println("Interfaz INVENTARIO Homecenter!");
				break;

			case "Requerimiento 3":
				System.out.println("Interfaz DEUDAS Materiales en construcción!");
				break;

		}

	}

}
