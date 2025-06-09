package Model;

import java.io.Serializable;

public class Player implements Serializable{
    
    //exemplo generico baseado no codigo do professor
    //está temporario como player para não ter erro no codigo

    int x, y;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
    return "Player{" + "x=" + x + ", y=" + y + '}';
    }
}
