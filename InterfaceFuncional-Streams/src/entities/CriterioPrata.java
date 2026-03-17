package entities;

public class CriterioPrata implements CriterioCarro{

	@Override
	public boolean verificarCriterio(Carro c) {
		
		return c.cor().equals("PRATA");
	}

}
