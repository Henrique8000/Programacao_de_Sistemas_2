package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import entities.LogEntry;

public class App {

	public static void main(String[] args) {
		
		try {
			System.out.println();
		}
		catch () {
			
		}
		
	}
	
	public static void processarFalhas (Path path) throws IOException {
		try (Stream<String> linhas = Files.lines(path)) {
			OptionalDouble media = linhas
					.map(LogEntry::new)
					.filter(log -> log.getUrl().equalsIgnoreCase("/api/v1/payments"))
					.mapToLong(LogEntry::getLatencia)
					.average();
			
					media.ifPresentOrElse(
							m -> System.out.println("Tempo medio de resposta" + m),
							() -> System.out.println("Nenhum log"));
		}
	}

}
