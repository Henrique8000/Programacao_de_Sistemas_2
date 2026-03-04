package model.entities;

import model.exceptions.FalhaProcessamentoAgenteException;
import model.exceptions.PromptInadequadoException;

public interface IAcaoAgente {
	void processarRequisicao(String prompt) throws PromptInadequadoException, FalhaProcessamentoAgenteException;
}
