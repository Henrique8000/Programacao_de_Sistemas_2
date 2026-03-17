package application;

import java.util.ArrayList;
import java.util.List;

import entities.Carro;
import entities.CriterioCarro;
import entities.CriterioPrata;
import entities.FiltroCarro;

public class Lambda {

	public static void main(String[] args) {
		
		List<Carro> carros = new ArrayList<>();
		carros = new ArrayList<>();
		
		carros.add(new Carro("Ferrari", "F40", "VERMELHA", 1990));
		carros.add(new Carro("Fiat", "147", "PRATA", 1978));
		carros.add(new Carro("VW", "Passat", "PRETA", 1983));
		carros.add(new Carro("BYD", "Dolphin", "AZUL", 2024));
		carros.add(new Carro("Ford", "Fista", "ROXA", 1997));
		carros.add(new Carro("GM", "Onix", "PRATA", 2015));
		
		FiltroCarro filtro = new FiltroCarro();
		CriterioPrata criterioPrata = new CriterioPrata();
		
		Iterable<Carro> carrosPrata = filtro.filtrar(carros, criterioPrata);
		System.out.println(carrosPrata);
		
		CriterioCarro carrosAzul = new CriterioCarro() {
			public boolean verificarCriterio(Carro c) {
				return c.cor().equals("AZUL");
			}
		};
		System.out.println(carrosAzul);
		
		//Iterable<Carro> carrosVermelhos = filtro.filtrar(carros, carrosVermelhos);
		//System.out.println(carrosVermelhos);
		
		
		
	}

}
