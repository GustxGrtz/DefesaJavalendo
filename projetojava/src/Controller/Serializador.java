package Controller;

import Model.Log;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializador {

    public static void salvarLista(String caminho, List<?> lista) {
        try {
            File file = new File(caminho);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
                os.writeObject(lista);
                Log.registrar("Lista salva com sucesso em: " + caminho);
            }
        } catch (Exception e) {
            Log.registrar("Erro ao salvar lista em '" + caminho + "': " + e.getMessage());
        }
    }

    public static <T> List<T> carregarLista(String caminho) {
        File file = new File(caminho);
        if (!file.exists()) {
            Log.registrar("Arquivo não encontrado: " + caminho);
            return new ArrayList<>();
        }

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) is.readObject();
        } catch (Exception e) {
            Log.registrar("Erro ao carregar lista de '" + caminho + "': " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
