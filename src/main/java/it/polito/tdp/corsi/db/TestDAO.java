package it.polito.tdp.corsi.db;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class TestDAO {

	public static void main(String[] args) {
		
		CorsoDAO dao = new CorsoDAO();
		
		List<Corso> result = new ArrayList<>();
		
		result = dao.getCorsiByPeriod(1);
		
		for (Corso c : result) {
			System.out.println("" + c );
		}
		
	}

}
