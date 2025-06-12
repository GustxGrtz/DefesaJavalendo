import View.MenuView;

public class App {
    public static void main(String[] args) throws Exception {

        MenuView.exibirMenuPrincipal();

        // Time t1 = new Time(0, "Coritiba", "Alef Manga");
        // Time t2 = new Time(1, "Athletico-PR", "Fernandinho");
        // Time t3 = new Time(2, "Paraná", "Diego Tavares");
        // Time t4 = new Time(3, "Operário", "Thiaguinho");

        // Serializador.salvarObjeto("times.ser", new Object[]{t1, t2, t3, t4});
        
        // //testes de serialização

        // //escreve direto da serialização
        // Object[] times = Serializador.carregarObjeto("times.ser", 4);
        // for (Object obj : times) {
        //     System.out.println(obj);

        // //puxa o normal criado na main
        // // System.out.println(t1);
        // // System.out.println(t2);

    }
}
