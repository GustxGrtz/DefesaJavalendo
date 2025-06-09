import View.EstatisticaView;
import View.MenuView;

public class App {
    public static void main(String[] args) throws Exception {

        MenuView mv = new MenuView();
        EstatisticaView ev = new EstatisticaView();

        System.out.println("Bem vindo ao Gerenciador de Campeonatos");

        // mv.exibirMenuPrincipal();

        //teste serialização (nao funciona)

        // Serializador s = new Serializador();
        // s.lerArquivoTexto();
    }
}