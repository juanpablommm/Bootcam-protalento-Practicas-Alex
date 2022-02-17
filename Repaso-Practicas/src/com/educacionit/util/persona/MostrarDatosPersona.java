package com.educacionit.util.persona;

import javax.swing.JOptionPane;

import com.educacionit.modelos.PersonaVO;

public class MostrarDatosPersona {

	public static void motrarPersona(PersonaVO persona) {
		
		JOptionPane.showMessageDialog(null, "---------------------"
				+ "\n\"PERSONA\"+"
				+ "\n---------------------"
				+ "\nId = " + persona.getIdPersona()
				+ "\nNombre = " + persona.getNombrePersona() 
				+ "\nEdad = " + persona.getEdadPersona()
				+ "\nProfesion = " + persona.getProfesionPersona()
				+ "\nTelefono = " + persona.getTelefonoPersona());
		
	}
}
