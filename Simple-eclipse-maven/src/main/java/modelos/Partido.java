package modelos;

import com.opencsv.bean.CsvBindByPosition;

public class Partido {
	private int idPartido;
	private Equipo equip1;
	private Equipo equip2;
	
	@CsvBindByPosition(position=0)
	private int idEquipo1;
	
	@CsvBindByPosition(position=1)
	private int cantGol1;
	
	@CsvBindByPosition(position=2)
	private int cantGol2;
	
	@CsvBindByPosition(position=3)
	private int idEquipo2;
	
	public Partido() {}
	
	public Partido(int idPartido, Equipo equip1, Equipo equip2) {
		this.idPartido=idPartido;
		this.equip1=equip1;
		this.equip2=equip2;
	}
	
	public int getIdPartido(){
		return idPartido;
	}
	
	public Equipo getEquipo1() {
		return equip1;
	}
	
	public Equipo getEquipo2() {
		return equip2;
	}
	
	public int getIdEquipo1() {
		return idEquipo1;
	}
	
	public int getIdEquipo2() {
		return idEquipo2;
	}
	
	public int getCantGol1() {
		return cantGol1;
	}
	
	public int getCantGol2() {
		return cantGol2;
	}
	
	public void setIdPartido(int otroIdPartido) {
		this.idPartido=otroIdPartido;
	}
	
	public void setEquipo1(Equipo otroEquip1) {
		this.equip1=otroEquip1;
	}
	
	public void setEquipo2(Equipo otroEquip2) {
		this.equip2=otroEquip2;
	}
	
	public String resultado(Equipo equip) {
		
		if(equip.getNom().equals(equip1.getNom())) {
			if(this.cantGol1==(this.cantGol2|this.cantGol2)) {
				return "Empate";
			}else if(this.cantGol1<this.cantGol2) {
				return "Perdedor";
			}else {return "Ganador";}
			
		}else if(equip.getNom().equals(equip2.getNom())) {
			if(this.cantGol1==(this.cantGol2|this.cantGol2)) {
				return "Empate";
			}else if(this.cantGol1<this.cantGol2) {
				return "Perdedor";
			}else {return "Ganador";}
		}else {return null;}
	}
}