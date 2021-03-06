package com.educacionit.util.persona;

import javax.swing.JOptionPane;

import com.educacionit.modelos.PersonaVO;

public class ObtenerDatosPersona {

	static String RegularExpresion = "[+-]?\\d*(\\.\\d+)?";

	public static Long solicitarIdDePersona() {

		String id = JOptionPane.showInputDialog("Ingresa el id de la persona:");

		while (!id.matches(RegularExpresion) || id.equals("")) {
			JOptionPane.showMessageDialog(null, "Error!! necesitamos un id valido");
			id = JOptionPane.showInputDialog("Ingresa el id de la persona:");
		}
		
		return Long.parseLong(id);

	}

	public static PersonaVO solicitarDatosPersona() {

		String nombre = JOptionPane.showInputDialog("Ingresa el nombre de la persona:");

		while (nombre.matches(RegularExpresion) || nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Error!! necesitamos un nombre valido");
			nombre = JOptionPane.showInputDialog("Ingresa el nombre de la persona:");
		}

		String edad = JOptionPane.showInputDialog("Ingresa la edad de la persona:");

		while (!edad.matches(RegularExpresion) || edad.equals("")) {
			JOptionPane.showMessageDialog(null, "Error!! necesitamos un telefono valido");
			edad = JOptionPane.showInputDialog("Ingresa la edad de la persona:");
		}

		String profesion = JOptionPane.showInputDialog("Ingresa la profesion de la persona:");

		while (profesion.matches(RegularExpresion) || profesion.equals("")) {
			JOptionPane.showMessageDialog(null, "Error!! necesitamos un profesion valida");
			profesion = JOptionPane.showInputDialog("Ingresa la profesion de la persona:");
		}

		String telefono = JOptionPane.showInputDialog("Ingresa el telefono de la persona:");

		while (!telefono.matches(RegularExpresion) || telefono.equals("")) {
			JOptionPane.showMessageDialog(null, "Error!! necesitamos una telefono valido");
			telefono = JOptionPane.showInputDialog("Ingresa el telefono de la persona:");
		}

		return new PersonaVO(nombre, Integer.parseInt(edad), profesion, Integer.parseInt(telefono));
	}
}
