package service;

import java.util.LinkedList;

import ModelDao.RecorridoDao;
import model.Recorrido;

public interface RecorridoService {

	private RecorridoDao recDao;
	
	public Recorrido buscarRecorrido();
	
	
	public Recorrido getById(Recorrido r) {
		return recDao.getById(r);
	}
	
	public List<Recorrido> listar(){
		return recDao.listar();
	}
	
}
