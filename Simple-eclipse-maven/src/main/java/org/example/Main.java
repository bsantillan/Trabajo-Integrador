package org.example;
import java.nio.file.Files;
import java.nio.file.Paths;

import modelos.LectorArchivo;
import modelos.Partido;
import modelos.Pronostico;

public class Main {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.print("No se pasaron parametros");
		}else if(args.length>3) {
			System.out.print("Hay mas de 2 parametros");
		}else if(args.length<2) {
			System.out.print("Faltan pasar parametros");
		}else if(Files.exists(Paths.get(args[0]))!=true | Files.exists(Paths.get(args[1]))!=true) {
			System.out.print("Alguno de los tres parametros no existe");
		}else {
			
		LectorArchivo lector=new LectorArchivo(args[0],args[1], args[2]);
		
		lector.parsearArchivo();
		
		for(Partido part:lector.getLineaA()) {
			System.out.print("Partido: "+part.getIdPartido()+"\n");
			System.out.print("Equipo 1--> "+part.getEquipo1().getNom()+"\n");
			System.out.print("Equipo 2--> "+part.getEquipo2().getNom()+"\n");
			System.out.print("Goles equipo 1:"+part.getCantGol1()+"\n");
			System.out.print("Goles equipo 1:"+part.getCantGol2()+"\n");
			System.out.print("\n");
		}
		
		for(Pronostico pro:lector.getLineaP()) {
			System.out.print("\t\t"+"Pronostico "+pro.getIdPronostico()+"\n");
			System.out.print("Partido: "+pro.getIdPartido()+"\t"+pro.getPartido().getEquipo1().getNom()+"   Vs   "+pro.getPartido().getEquipo2().getNom()+"\n");
			System.out.print("Equipo: "+pro.getEquipo().getNom()+"\n");
			System.out.print("Resultado: "+pro.getResultado()+"\n");
			System.out.print("Puntos: "+pro.puntos()+"\n");
			System.out.print("\n");
		}
		
	}
	}
}
