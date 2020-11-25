package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 

    private int kasvatuskoko;
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin tai koko väärin");
        }
        ljono = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm >= ljono.length) {

                kopioiTaulukko(ljono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;

    }

    public void kopioiTaulukko(int[] taulu) {

        ljono = new int[alkioidenLkm + kasvatuskoko];
        for (int i = 0; i < taulu.length; i++) {
            ljono[i] = taulu[i];
        }

    }

    public boolean poista(int luku) {

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {

                ljono[i] = 0;

                muokkaaTaulukko(i);

                alkioidenLkm--;

                return true;
            }

        }
        return false;
    }

    public void muokkaaTaulukko(int i) {
        int apuMuuttuja;
        for (int j = i; j < alkioidenLkm - 1; j++) {
            apuMuuttuja = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apuMuuttuja;

        }
    }

    public int getAlkioLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {

        String tuotos = "{";
        if (alkioidenLkm != 0) {

            for (int i = 0; i < alkioidenLkm; i++) {

                tuotos += ljono[i];
                if (i < alkioidenLkm - 1) {
                    tuotos += ", ";
                }
            }
        }

        tuotos += "}";
        return tuotos;

    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdisteJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdisteJoukko.lisaa(bTaulu[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkausJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkausJoukko;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(bTaulu[i]);
        }

        return erotusJoukko;
    }

}
