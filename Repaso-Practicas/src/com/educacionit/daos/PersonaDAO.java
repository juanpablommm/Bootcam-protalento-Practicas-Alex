
//		ATAJOS UTILES
//		ctrl + shift + f = identado de codigo
//		ctrl + shift + o = auto import
//		ctrl + shift +c = comentario
//		ctrl + m = cerrar y abrir package explorer
//		alt + shift + s : abrir pestaña para crear contructores , toString , get /set ...etc
//		ctrl + d = delete line
//		ctrl + space = intelisense
//		ctrl +shift + r = atajo para buscar una clase 
//		alt + Flecha arriba o abajo = mover codigo seleccionado
//		Shift + alt + A escribir en varias líneas :)
//		ctrl + shift + L = listado de atajos 
//		ctrl + f11, corres la app,
//		ctrl + t, para ver las clases con las que estas relacionadas también sirven
//		ctrl + m abrir y cerrar project explorer
package com.educacionit.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;

import com.educacionit.database.Conexion;
import com.educacionit.exceptions.GenricExceptions;
import com.educacionit.modelos.PersonaVO;


public class PersonaDAO {

	public void registrar(PersonaVO persona) throws GenricExceptions {
		try (PreparedStatement preparedStatement = Conexion.conexion().prepareStatement("INSERT INTO persona(Nombre, Edad, Profesion, Telefono) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)){
			preparedStatement.setString(1, persona.getNombrePersona());
			preparedStatement.setInt(2, persona.getEdadPersona());
			preparedStatement.setString(3, persona.getProfesionPersona());
			preparedStatement.setInt(4, persona.getTelefonoPersona());
			preparedStatement.execute();
			ResultSet resultSet_ID = preparedStatement.getGeneratedKeys();
			if (resultSet_ID.next()) {
				JOptionPane.showMessageDialog(null, "Registro exitoso para la persona con id \"" + resultSet_ID.getLong(1) + "\"");
			}
		} catch (Exception e) {
			throw new GenricExceptions("Error!!, no se pude registrar la persona: ", e);
		}
	}
	
	
	public PersonaVO buscarID(Long id) throws GenricExceptions {
		try (PreparedStatement preparedStatement = Conexion.conexion().prepareStatement("SELECT *FROM persona WHERE Id_persona = ?")){
			if (validarID(id) == false) {
				preparedStatement.setLong(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					return new PersonaVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
				}
			}else {
				JOptionPane.showMessageDialog(null, "No existe un registro con el id \"" + id + "\"");
			}
		} catch (Exception e) {
			throw new GenricExceptions("Error!! no se pude buscar es id: ", e);		}
		return null;
	}
	
	
	public void elimnar(Long id) throws GenricExceptions {
		try (PreparedStatement preparedStatement = Conexion.conexion().prepareStatement("DELETE FROM persona WHERE Id_Persona = ?");){
			if (validarID(id) == false) {
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				JOptionPane.showMessageDialog(null, "Registro elimnado");
			}else {
				JOptionPane.showMessageDialog(null, "No existe un registro para el id \"" + id + "\"");
			}
		} catch (Exception e) {
			throw new GenricExceptions("Error!! no se pudo eliminar: ", e);
		}	
	}
	
	
//	retorna true si el resgistro no existe, de lo contrario retonra false
	public boolean validarID(Long id) throws GenricExceptions {
		
		if(id != null) {
			try (PreparedStatement preparedStatement = Conexion.conexion().prepareStatement("SELECT COUNT(*) FROM persona WHERE Id_Persona = ?")){
				preparedStatement.setLong(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					return (resultSet.getLong(1) == 0); 
				}
			} catch (SQLException | GenricExceptions e) {
				throw new GenricExceptions("Error!! no se pude validar el id: ", e);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Pasastes un id nulo no se puede vereficar en la db");
		}
		return true;
	}
}
