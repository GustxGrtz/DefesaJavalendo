package Controller;

import Model.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {

public static void salvarObjeto(String caminho, Object[] objetos) {
    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(caminho))) {
        for(Object o : objetos) os.writeObject(o);
            Log.registrar("Objetos salvos com sucesso.");
    } catch(Exception e) {
            Log.registrar("Erro ao salvar objetos: " + e.getMessage());
    }
}

public static Object[] carregarObjeto(String caminho, int quantidade) {
    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(caminho))) {
        Object[] objs = new Object[quantidade];
        for (int i = 0; i < quantidade; i++) {
            objs[i] = is.readObject();
        }
        Log.registrar("Objetos carregados com sucesso.");
        return objs;
    } catch(Exception e) {
        Log.registrar("Erro ao carregar objetos: " + e.getMessage());
            return new Object[0];
        }
    }
}