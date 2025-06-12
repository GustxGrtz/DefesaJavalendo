package View;

import Controller.CampeonatoController;

public class CampeonatoView {
    private CampeonatoController controller;

    public CampeonatoView(CampeonatoController controller) {
        this.controller = controller;
    }

    public void mostrarChaveamento() {
        controller.mostrarJogos();
    }

    public void iniciarChaveamento() {
        controller.gerarChaveamento();
    }

    public void proximaFase() {
        controller.avancarFase();
    }
}