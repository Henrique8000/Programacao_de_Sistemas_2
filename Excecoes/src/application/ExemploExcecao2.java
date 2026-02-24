package application;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

//aula Teorica sobre tratamento de Excecoes

public class ExemploExcecao2 {

	public static void main(String[] args) {
		double[] notas = {6.5, 9.5, 7.0};
		
		String s = showInputDialog("Qual a nota deseja consultar? (0, 1 ou 2)");
		int i = Integer.parseInt(s);
		
		try {
			showMessageDialog(null, "A nota é " + notas[i]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

}
