package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://aws-0-us-west-2.pooler.supabase.com:6543/postgres?user=postgres.vahhblgaglgkwegumlux&password=HFg013sk81970@#";
		
		
		try (Connection conexao = DriverManager.getConnection(url)) {
			
			System.out.println("Conectado!");
			
			String insercaoDeNovoProprietario = "INSERT INTO proprietario (id, nome, cpf) VALUES (2, 'Messi', '12354354532')";
			String insercaoDeNovoVeiculo = "INSERT INTO veiculo (id, proprietario_id, placa) VALUES (2, 2, 'DFC1265')";
			
			String listaProprietarios = "SELECT * FROM proprietario";
			String listaVeiculos = "SELECT * FROM veiculo";
			
			String atualizaNomeProprietario = "UPDATE proprietario SET nome = 'Cristiano Ronaldo' WHERE id = 2";
			
			String removaoDeProprietario = "DELETE FROM proprietario WHERE id = 2";
			
			PreparedStatement sentenca;
			ResultSet resultados;
			
			// Inserção / Create
			sentenca = conexao.prepareStatement(insercaoDeNovoProprietario);
			sentenca.executeUpdate();
			
			// Listagem / Read
			sentenca = conexao.prepareStatement(listaProprietarios);
			resultados = sentenca.executeQuery(); 
			
			System.out.println("====(Lista de proprietários)====");
			while (resultados.next()) {
				Integer id;
				String nome;
				String cpf;
				
				id = resultados.getInt("id");
				nome = resultados.getString("nome");
				cpf = resultados.getString("cpf");
				
				System.out.println("id: " + id + ", nome: " + nome + ", cpf: " + cpf);
				
			}
			
			System.out.println();
			
			// Atualizacao / Update
			sentenca = conexao.prepareStatement(atualizaNomeProprietario);
			sentenca.executeUpdate();
			
			sentenca = conexao.prepareStatement(listaProprietarios);
			resultados = sentenca.executeQuery();
			
			System.out.println("====(Lista de proprietários [ATUALIZADO])====");
			while (resultados.next()) {
				Integer id;
				String nome;
				String cpf;
				
				id = resultados.getInt("id");
				nome = resultados.getString("nome");
				cpf = resultados.getString("cpf");
				
				System.out.println("id: " + id + ", nome: " + nome + ", cpf: " + cpf);
				
			}
			
			System.out.println();
			
			// Remoção / Delete 
			sentenca = conexao.prepareStatement(removaoDeProprietario);
			sentenca.executeUpdate();
			
			sentenca = conexao.prepareStatement(listaProprietarios);
			resultados = sentenca.executeQuery();
			
			System.out.println("====(Lista de proprietários [APÓS REMOÇÃO])====");
			while (resultados.next()) {
				Integer id;
				String nome;
				String cpf;
				
				id = resultados.getInt("id");
				nome = resultados.getString("nome");
				cpf = resultados.getString("cpf");
				
				System.out.println("id: " + id + ", nome: " + nome + ", cpf: " + cpf);
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
