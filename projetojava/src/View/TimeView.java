package View;

import java.util.Scanner;

public class TimeView {
    
    Scanner scan = new Scanner(System.in);
    
    public void exibirMenuTime(){
        System.out.println("Menu de times");
        System.out.println("1 - Cadastrar time");
        System.out.println("2 - Listar times");
        System.out.println("3 - Remover time");
        System.out.println("4 - Sair");
        int opcao = scan.nextInt();
    }
}