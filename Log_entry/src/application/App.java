package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.LogEntry;

public class App {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("C:\\Users\\Henri\\OneDrive\\Área de Trabalho\\ProgramacaoDeSistemas2\\Log_entry\\src\\access.log");

        try{
            System.out.println("Iniciando o processamento");
            processarFalhas(path);
            processarMedia(path);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public static void processarFalhas(Path path)throws IOException{
        try(Stream<String> linhas = Files.lines(path)){
            List<LogEntry> falhas = linhas
                .map(LogEntry::new) // convertendo uma linha num objeto LogEntry
                .filter(log -> log.getStatus() >=400) //Predicate: condicao de erro
                .collect(Collectors.toList());

            falhas.forEach(System.out::println);
            System.out.println("total de falhas encontradas: "+falhas.size());

        }
    }

    public static void processarMedia(Path path)throws IOException{
        try(Stream<String> linhas = Files.lines(path)){
            OptionalDouble media = linhas
            .map(LogEntry::new)
            .filter(log -> log.getUrl().equalsIgnoreCase("/api/v1/payments"))
            .mapToLong(LogEntry::getLatencia) //transformando para log por causa do calculo
            .average(); //operacao final calculando a media

            media.ifPresentOrElse(
                m ->System.out.println("Tempo medio de resposta "+m), 
                ()->System.out.println("Nenhum log processado")
            );

        }
    }
}
