package modelos;
import com.opencsv.bean.CsvBindByPosition;

public class Pronostico {
		private int idPronostico;
		private Partido part;
		private Equipo equip;
		private String resultado;
		
		@CsvBindByPosition(position=0)
		private int idPartido;
		@CsvBindByPosition(position=1)
		private String gana1;
		@CsvBindByPosition(position=2)
		private String empate;
		@CsvBindByPosition(position=3)
		private String gana2;
		
		public Pronostico() {}
		
		public Pronostico(int idPronostico, int idPartido, Equipo equip) {
			this.idPronostico=idPronostico;
			this.idPartido=idPartido;
			this.equip=equip;
		}
		
		public int getIdPronostico() {
			return idPronostico;
		}
		
		public Partido getPartido() {
			return part;
		}
		
		public Equipo getEquipo() {
			return equip;
		}
		
		public int getIdPartido() {
			return idPartido;
		}
		
		public String getGana1() {
			return gana1;
		}
		
		public String getEmpate() {
			return empate;
		}
		
		public String getGana2() {
			return gana2;
		}
		
		public String getResultado() {
			return resultado;
		}
		
		public void setIdPronostico(int otroIdPronostico) {
			this.idPronostico=otroIdPronostico;
		}
		
		public void setPartido(Partido otroPartido) {
			this.part=otroPartido;
		}
		
		public void setEquipo(Equipo otroEquip) {
			this.equip=otroEquip;
		}
		
		public void setResultado(String otroResu) {
			this.resultado=otroResu;
		}
		public int puntos() {
			int cont=0;
			String rta=this.part.resultado(equip).toUpperCase();
			if(resultado.toUpperCase().equals(rta)) {
				cont++;
				return cont;
			}else {return cont;}
		}
	}