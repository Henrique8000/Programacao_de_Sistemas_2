package entities;

import java.util.ArrayList;
import java.util.List;

public class FiltroCarro {
	
	public Iterable<Carro> filtrar(Iterable<Carro> carros, CriterioCarro criterio) {
		
		List<Carro> resposta = new ArrayList<>();
		
		for (Carro c : carros) {
			if (criterio.verificarCriterio(c)) {
				resposta.add(c);
			}
		}
		
		return resposta;
	}
	
}
