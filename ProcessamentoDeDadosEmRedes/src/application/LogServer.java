package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class LogServer {
    public static void main(String[] args) {
        int porta = 12345;

        try (ServerSocket server = new ServerSocket(porta)) {
            System.out.println("🚀 Servidor de Logs rodando na porta " + porta);

            while (true) {
                // Aguarda conexão de um cliente
                try (Socket client = server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("\n--- Nova conexão de: " + client.getInetAddress() + " ---");

                    // DEFINIÇÃO DA LÓGICA FUNCIONAL
                    // Filtro: Apenas linhas que contenham a palavra "ERROR"
                    Predicate<String> apenasErros = linha -> linha.contains("ERROR");
                    Predicate<String> apenasInfos = linha -> linha.contains("INFO");
                    Predicate<String> apenasDebugs = linha -> linha.contains("DEBUG");
                    
                    List<String> logs = in.lines().collect(Collectors.toList());
                  
                    int countErros = (int) logs.stream().filter(apenasErros).count();
                    int countInfos = (int) logs.stream().filter(apenasInfos).count();
                    int countDebugs = (int) logs.stream().filter(apenasDebugs).count();
                    
                    Map<String, Integer> contadores = new HashMap<>();
                    
                    contadores.put("ERROR", countErros);
                    contadores.put("INFO", countInfos);
                    contadores.put("DEBUG", countDebugs);
           
                    // PROCESSAMENTO COM STREAMS
                    logs.stream() // Transforma as linhas recebidas em um Stream<String>
                      .filter(apenasErros)                   // Intermediário: Filtra
                      .map(String::toUpperCase)              // Intermediário: Transforma
                      .map(s -> "🚨 NOTIFICAÇÃO: " + s)       // Intermediário: Formata
                      .forEach(System.out::println);         // Terminal: Consome e exibe
                    
                    
                    for (String key : contadores.keySet()) {
                    	System.out.println("TOTAL " + key + ": " + contadores.get(key));
                    	
                    }
                    
                } catch (IOException e) {
                    System.err.println("Erro na comunicação com o cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Não foi possível iniciar o servidor: " + e.getMessage());
        }
    }
}