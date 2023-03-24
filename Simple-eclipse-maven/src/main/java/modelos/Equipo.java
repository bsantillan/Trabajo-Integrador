package modelos;

import com.opencsv.bean.CsvBindByPosition;

public class Equipo {
	@CsvBindByPosition(position=0)
	private int idEquipo;
	@CsvBindByPosition(position=1)
	private String nom;
	
	public Equipo() {}
	
	public Equipo(String nom) {
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}

}
