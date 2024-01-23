package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getIscrittiCorso(String codins) {
		String sql = " SELECT s.matricola, s.cognome, s.nome, s.CDS "
		 		+ " FROM studente s, iscrizione i "
		 		+ " WHERE s.matricola = i.matricola AND i.codins = ? ";
		 
		List<Studente> result = new ArrayList<Studente>();
			
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
		
			st.setString(1, codins);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Studente studente = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
				result.add(studente);
			}
			
			st.close();
			rs.close();
			conn.close();

			return result;
			
		} catch (SQLException e) {
			System.out.println("Error in CorsoDAO");
			e.printStackTrace();
			
			return null;
		}
		 		
	}
	
	public List<Divisione> getDivisioneStudenti(String codins) {
		
		String sql = " SELECT s.CDS, COUNT(*) AS iscritti "
		 		+ " FROM studente s, iscrizione i "
		 		+ " WHERE s.matricola = i.matricola AND i.codins = ? "
		 		+ " GROUP BY s.CDS ";
		 
		List<Divisione> result = new ArrayList<Divisione>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
		
			st.setString(1, codins);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Divisione divisione = new Divisione(rs.getString("CDS"), rs.getInt("iscritti"));
				result.add(divisione);
			}
			
			st.close();
			rs.close();
			conn.close();

			return result;
			
		} catch (SQLException e) {
			System.out.println("Error in CorsoDAO");
			e.printStackTrace();
			
			return null;
		}
	}

}
