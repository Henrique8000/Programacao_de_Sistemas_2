package application;

import static javax.swing.JOptionPane.*;

// aula Teorica sobre tratamento de Excecoes

public class Exemplo1 {

	public static void main(String[] args) {
		try {
			
		String s = showInputDialog("Sua idade");
		int idade = Integer.parseInt(s);
		showMessageDialog(null, "Ano que vem você terá " + (idade+1) + " anos");
		
		}
		catch (NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
			showMessageDialog(null, "Erro: " + e.getMessage());
			showMessageDialog(null, "Digite apenas números!");
		}
	}

}
