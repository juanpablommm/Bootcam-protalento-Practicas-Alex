package com.educacionit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.print.attribute.standard.PrinterState;

import com.educacionit.exceptions.GenricExceptions;

public class Conexion {

	private static String login = "root";
	private static String password = "060900";
	private static String url = "jdbc:mysql://localhost:3306/practicas_Alex";

	public static Connection conexion() throws GenricExceptions {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			throw new GenricExceptions("Errror!! no se pudeo establcer conexcion a la db ", e);
		}
		return conexion;
	}
}
