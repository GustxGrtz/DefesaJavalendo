package Controller;

import Model.Time;
import java.util.ArrayList;
import java.util.List;

public class TimeController {
    private List<Time> times = new ArrayList<>();
    private int proximoId = 1;

    // Criar um time com nome
    public void criar(String nome) {
        // Time novoTime = new Time(proximoId, nome); TIRAR COMENTARIO DEPOIS
        // times.add(novoTime); TIRAR COMENTARIO DEPOIS
        proximoId++;
    }

    // Listar todos os times
    public List<Time> listar() {
        return times;
    }

    // Buscar time pelo ID
    public Time buscarPorId(int id) {
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).getId() == id) {
                return times.get(i);
            }
        }
        return null;
    }

    // Editar o nome de um time
    public boolean editar(int id, String novoNome) {
        Time time = buscarPorId(id);
        if (time != null) {
            time.setNome(novoNome);
            return true;
        }
        return false;
    }

    // Remover um time
    public boolean remover(int id) {
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).getId() == id) {
                times.remove(i);
                return true;
            }
        }
        return false;
    }
}