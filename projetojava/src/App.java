import View.CampeonatoView;
import View.EstatisticaView;
import View.JogoView;
import View.MenuView;
import View.TimeView;

public class App {
    public static void main(String[] args) throws Exception {

        MenuView mv = new MenuView();
        TimeView tv = new TimeView();
        JogoView jv = new JogoView();
        CampeonatoView cv = new CampeonatoView();
        EstatisticaView ev = new EstatisticaView();

        System.out.println("Bem vindo ao Gerenciador de Campeonatos");

        mv.exibirMenuPrincipal();

    }
}