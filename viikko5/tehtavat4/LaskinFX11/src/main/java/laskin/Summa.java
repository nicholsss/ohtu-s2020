/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    int edellinen;
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        
        this.edellinen = Integer.parseInt(tuloskentta.getText());
        try {

            this.sovellus.plus(Integer.parseInt(syotekentta.getText()));

        } catch (Exception e) {

        }

        this.syotekentta.setText("");
        int laskunTulos = sovellus.tulos();

        this.tuloskentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }
        this.undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        int laskunTulos = this.sovellus.vanha(edellinen);
        this.tuloskentta.setText("" + laskunTulos);
        
        if (laskunTulos == 0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }
        this.undo.disableProperty().set(true);
        
    }
    
}
