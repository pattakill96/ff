package gioco.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persona.utente.UtenteManager;
import persona.utente.model.Utente;
import gioco.GiocoManager;

public class JDBCGiocoController implements GiocoManager {

	public JDBCGiocoController() {
	}

	@Override
	public void getGiochi() {
		// TODO Auto-generated method stub
		
	}

}
