package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log {
    public static void registrar(String mensagem){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))){
            bw.write(LocalDateTime.now() + " - " + mensagem);
            bw.newLine();
        }catch(IOException e){
            System.out.println("Erro ao gravar");
        }
    }
}
