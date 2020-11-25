package laskin;

public class Sovelluslogiikka {

    private int tulos;
    private int vanha;

    public void plus(int luku) {
        tulos += luku;
        vanha += luku;
    }

    public void miinus(int luku) {
        tulos -= luku;
        vanha -=luku;
    }

    public void nollaa() {
        tulos = 0;
    }

    public int tulos() {
        return tulos;
    }

    public int vanha (int edellinen){
        return tulos = edellinen;
    }
}
