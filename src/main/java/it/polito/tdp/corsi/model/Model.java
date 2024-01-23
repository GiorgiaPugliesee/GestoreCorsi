package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	public Model() {
		this.corsoDao = new CorsoDAO();
		this.studenteDao = new StudenteDAO();
	}
	
	public List<Corso> getCorsiByPeriod(int periodo) {
		return this.corsoDao.getCorsiByPeriod(periodo);
	}
	
	public Map<Corso, Integer> getCorsiIscritti(int periodo) {
		return this.corsoDao.getCorsiIscritti(periodo);
	}
	
	public List<Studente> getIscrittiCorso(String codins) {
		return this.studenteDao.getIscrittiCorso(codins);
	}
	
	public List<Divisione> getDivisioneStudenti(String codins) {
		return this.studenteDao.getDivisioneStudenti(codins);
	}
	
}
