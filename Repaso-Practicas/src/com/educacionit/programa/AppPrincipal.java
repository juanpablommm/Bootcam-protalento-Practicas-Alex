package com.educacionit.programa;

import javax.swing.JOptionPane;

import com.educacionit.daos.PersonaDAO;
import com.educacionit.exceptions.GenricExceptions;
import com.educacionit.util.persona.MostrarDatosPersona;
import com.educacionit.util.persona.ObtenerDatosPersona;

public class AppPrincipal {

	public static void main(String[] args) {
		int opcionIngresada;
		PersonaDAO pdao = new PersonaDAO();

		do {

			opcionIngresada = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese la opcion deseaada \n 1)Crear persona\n 2)Borrar Persona\n 3)Bucar Persona \n 4)Salir"));

			switch (opcionIngresada) {

			case 1:
				try {
					pdao.registrar(ObtenerDatosPersona.solicitarDatosPersona());
				} catch (GenricExceptions e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					pdao.elimnar(ObtenerDatosPersona.solicitarIdDePersona());
				} catch (GenricExceptions e) {
					System.err.println(e);
				}
				break;
			case 3:
				try {
					MostrarDatosPersona.motrarPersona(pdao.buscarID(ObtenerDatosPersona.solicitarIdDePersona()));
				} catch (GenricExceptions e) {
					System.err.println(e);
				}
				break;
			case 4:
				System.exit(0);
				break;
			}

		} while (opcionIngresada != 1 && opcionIngresada != 2);
	}
}
