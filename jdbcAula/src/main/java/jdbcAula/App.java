package jdbcAula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws SQLException {
		
		String url;
		
		url = "jdbc:postgresql://aws-0-us-west-2.pooler.supabase.com:6543/postgres?user=postgres.efbadijdztrmpkjfvsmi&password=HFg013sk81970@#";
		
		Connection conexao;
		conexao = DriverManager.getConnection(url);
		System.out.println("Conectado!");
		
		String sql = "SELECT * FROM contas";
		
		PreparedStatement sentenca;
		
		sentenca = conexao.prepareStatement(sql);
		
		ResultSet resultados;
		
		resultados = sentenca.executeQuery();
		
		while (resultados.next()) {
			long nro;
			double saldo;
			nro = resultados.getLong("nro_conta");
			saldo = resultados.getDouble("saldo");
			System.out.println("Conta " + nro + " tem R$" + saldo);
		}
		
		System.out.println("Fim do programa!");
		
	}

}
