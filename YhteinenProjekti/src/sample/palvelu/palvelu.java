package sample.palvelu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class palvelu {

    private IntegerProperty palvelu_id;
    private IntegerProperty toimintaalue_id;
    private StringProperty nimi;
    private StringProperty tyyppi;
    private StringProperty kuvaus;
    private IntegerProperty hinta;
    private IntegerProperty alv;

    public palvelu() {
        this.palvelu_id = new SimpleIntegerProperty();
        this.toimintaalue_id = new SimpleIntegerProperty();
        this.nimi = new SimpleStringProperty();
        this.tyyppi = new SimpleStringProperty();
        this.kuvaus = new SimpleStringProperty();
        this.hinta = new SimpleIntegerProperty();
        this.alv = new SimpleIntegerProperty();
    }

    public int getPalvelu_id() {
        return palvelu_id.get();
    }

    public IntegerProperty palvelu_idProperty() {
        return palvelu_id;
    }

    public void setPalvelu_id(int palvelu_id) {
        this.palvelu_id.set(palvelu_id);
    }

    public int getToimintaalue_id() {
        return toimintaalue_id.get();
    }

    public IntegerProperty toimintaalue_idProperty() {
        return toimintaalue_id;
    }

    public void setToimintaalue_id(int toimintaalue_id) {
        this.toimintaalue_id.set(toimintaalue_id);
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

    public String getTyyppi() {
        return tyyppi.get();
    }

    public StringProperty tyyppiProperty() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi.set(tyyppi);
    }

    public String getKuvaus() {
        return kuvaus.get();
    }

    public StringProperty kuvausProperty() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus.set(kuvaus);
    }

    public int getHinta() {
        return hinta.get();
    }

    public IntegerProperty hintaProperty() {
        return hinta;
    }

    public void setHinta(int hinta) {
        this.hinta.set(hinta);
    }

    public int getAlv() {
        return alv.get();
    }

    public IntegerProperty alvProperty() {
        return alv;
    }

    public void setAlv(int alv) {
        this.alv.set(alv);
    }

    public void setPa_tpid(int toimintaalue_id) {
        this.toimintaalue_id.set(toimintaalue_id);
    }



}
