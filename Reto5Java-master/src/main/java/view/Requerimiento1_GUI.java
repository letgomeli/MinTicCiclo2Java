package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientos;
import model.vo.Requerimiento_1;
import java.util.ArrayList;

public class Requerimiento1_GUI extends JFrame {

	// private JButton btnRequerimiento1;
	// private JButton btnRequerimiento2;
	// private JButton btnRequerimiento3;
	// private Component add;
	private JTable Requerimiento1;

	public Requerimiento1_GUI(ArrayList<Requerimiento_1> requerimiento_1s, ControladorRequerimientos controlador) {

		// Propiedades del frame
		setTitle("-----Requerimiento1 - Numero de líderes por ciudad-----");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//Construccion de la tabla que presentará los proyectos
		String[] encabezado = {"Nro Líderes", "Ciudad Residencia"}
		this.Requerimiento1 = new JTable(this.formatoRegistros(requerimiento_1s, encabezado.length), encabezado);
		JScrollPane sp = new JScrollPane(this.jtRequerimiento_1s);

		 //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking Mayor Gasto Por Compras"));
        panel.add(sp);

		// Contenedor
		getContentPane().add(panel);

		// Mostrar ventana/frame
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private ImageIcon redimensionarIcono(ImageIcon icono, int pixeles) {
		Image image = icono.getImage();
		Image newimg = image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}

	private String[][] formatoRegistros(ArrayList<Requerimiento_1> requerimiento_1s, int numeroEncabezados){
        
        //Declaración del contenedor de retorno
    String[][] registros = new String[requerimiento_1s.size()][numeroEncabezados];        

        //Desenvolver los objetos de la colección
    for (int i = 0; i < requerimiento_1s.size(); i++) {
            registros[i][0] = String.valueOf(requerimiento_1s.get(i).getNumLideres()); 
            registros[i][1] = requerimiento_1s.get(i).getCiudadResidencia();            
          
    }

        //Retornar registros en formato JTable
    return registros;




}
