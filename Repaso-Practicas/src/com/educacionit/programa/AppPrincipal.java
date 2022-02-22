package com.educacionit.programa;

import javax.swing.JOptionPane;

import com.educacionit.daos.PersonaDAO;
import com.educacionit.exceptions.GenricExceptions;
import com.educacionit.util.persona.MostrarDatosPersona;
import  static com.educacionit.util.persona.ObtenerDatosPersona.solicitarDatosPersona;
import  static com.educacionit.util.persona.ObtenerDatosPersona.solicitarIdDePersona;

public class AppPrincipal {

	public static void main(String[] args) {
		boolean salir = false;
		PersonaDAO pdao = new PersonaDAO();

		do {

			var opcionIngresada = Integer.parseInt(JOptionPane.showInputDialog(
					"Ingrese la opcion deseaada \n 1)Crear persona\n 2)Borrar Persona\n "
					+ "3)Actualizar Persona \n 4)Bucar Persona \n 5)Salir"));
			
			switch (opcionIngresada) {

			case 1:
				try {
					pdao.registrar(solicitarDatosPersona());
				} catch (GenricExceptions e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					pdao.elimnar(solicitarIdDePersona());
				} catch (GenricExceptions e) {
					System.err.println(e);
				}
				break;
			case 3:
				try {
					pdao.actulizar(solicitarIdDePersona());
				} catch (GenricExceptions e1) {
					e1.printStackTrace();
				}
				break;
			case 4:
				try {
					MostrarDatosPersona.motrarPersona(pdao.buscarID(solicitarIdDePersona()));
				} catch (GenricExceptions e) {
					System.err.println(e);
				}
				break;
			case 5:
//				System.exit(0);
				salir = true;
				
				break;
			}

		} while (!salir);
	}
}
