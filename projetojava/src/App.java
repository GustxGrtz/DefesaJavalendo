import Controller.Serializador;
import Model.Time;
import View.EstatisticaView;
import View.MenuView;

public class App {
    public static void main(String[] args) throws Exception {

        MenuView mv = new MenuView();
        EstatisticaView ev = new EstatisticaView();

        System.out.println("Bem vindo ao Gerenciador de Campeonatos");

        Time t1 = new Time(0, "Coritiba", "Alef Manga");
        Time t2 = new Time(1, "Athletico-PR", "Fernandinho");

        Serializador.salvarObjeto("times.ser", new Object[]{t1, t2});
        
        //testes de serialização

        //escreve direto da serialização
        Object[] times = Serializador.carregarObjeto("times.ser", 2);
        for (Object obj : times) {
            System.out.println(obj);

        //puxa o normal criado na main
        // System.out.println(t1);
        // System.out.println(t2);

    }
}
}