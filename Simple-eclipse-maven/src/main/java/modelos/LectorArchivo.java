package modelos;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class LectorArchivo {
	String rutaR;
	String rutaP;
	String rutaE;
	List<Partido> lineasArchivoR;
	List<Pronostico> lineasArchivoP;
	List<Equipo> lineasArchivoE;
	
	public LectorArchivo(String rutaR, String rutaP, String rutaE) {
		this.rutaR=rutaR;
		this.rutaP=rutaP;
		this.rutaE=rutaE;
		this.lineasArchivoP=new ArrayList<Pronostico>();
		this.lineasArchivoR=new ArrayList<Partido>();
		this.lineasArchivoE=new ArrayList<Equipo>();
	}
	
	public List<Partido> getLineaA(){
		return lineasArchivoR;
	}
	
	public List<Pronostico> getLineaP(){
		return lineasArchivoP;
	}
	
	public List<Equipo> getLineaE(){
		return lineasArchivoE;
	}
	
	public void parsearArchivo() {
		List<Partido> partidosJugados=null;
		List<Equipo> equipos=null;
		List<Pronostico> pronosticos=null;
		try {
			equipos=new CsvToBeanBuilder(new FileReader(this.rutaE))
					.withSkipLines(1)
					.withSeparator(';')
					.withType(Equipo.class)
					.build()
					.parse();
			partidosJugados=new CsvToBeanBuilder(new FileReader(this.rutaR))
					.withSkipLines(1)
					.withSeparator(';')
					.withType(Partido.class)
					.build()
					.parse();
			
			int i=1;
			for(Partido part:partidosJugados) {
				for(Equipo equip:equipos) {
					if(part.getIdEquipo1()==equip.getIdEquipo()) {
						part.setEquipo1(equip);
						part.setIdPartido(i);
					}else if(part.getIdEquipo2()==equip.getIdEquipo()) {
						part.setEquipo2(equip);
					}
				}
				i++;
			}
			
			pronosticos=new CsvToBeanBuilder(new FileReader(rutaP))
					.withSkipLines(1)
					.withSeparator(';')
					.withType(Pronostico.class)
					.build()
					.parse();
			
			i=1;
			for(Pronostico pro:pronosticos) {
				for(Partido part:partidosJugados) {
					if(pro.getIdPartido()==part.getIdPartido()) {
						pro.setPartido(part);
						
						if(pro.getGana1()!="") {
							pro.setResultado("Ganador");
							pro.setEquipo(part.getEquipo1());
							
						}else if(pro.getGana2()!="") {
							pro.setResultado("Ganador");
							pro.setEquipo(part.getEquipo2());
							
						}else if(pro.getEmpate()!=""){
							pro.setResultado("Empate");
							pro.setEquipo(part.getEquipo2());
							
						}else {
							pro.setEquipo(null);
							pro.setResultado(null);
						}
						
						pro.setIdPronostico(i);
					}
				}
				i++;
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		this.lineasArchivoR=partidosJugados;
		this.lineasArchivoP=pronosticos;
	}
}
