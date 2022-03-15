package sample.toimintaAlue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class toimintaAlue {

    private IntegerProperty toimintaalue_id;
    private StringProperty nimi;

    public toimintaAlue() {
        this.toimintaalue_id = new SimpleIntegerProperty();
        this.nimi = new SimpleStringProperty();

    }

    public int getToimintaAlue_id() {
        return toimintaalue_id.get();
    }

    public IntegerProperty toimintaAlue_idProperty() {
        return toimintaalue_id;
    }

    public void setToimintaAlue_id(int toimintaAlue_id) {
        this.toimintaalue_id.set(toimintaAlue_id);
    }

    public String getNimi() {
        return nimi.get();
    }

    public StringProperty nimiProperty() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi.set(nimi);
    }
}
