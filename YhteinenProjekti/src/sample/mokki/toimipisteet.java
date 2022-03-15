package sample.mokki;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class toimipisteet {

    private IntegerProperty mokki_id;
    private IntegerProperty toimintaalue_id;
    private StringProperty postinro;
    private StringProperty mokkinimi;
    private StringProperty katuosoite;
    private StringProperty kuvaus;
    private StringProperty henkilomaara;
    private StringProperty varustelu;
    private IntegerProperty hinta;

    public toimipisteet() {
        this.mokki_id = new SimpleIntegerProperty();;
        this.toimintaalue_id = new SimpleIntegerProperty();;
        this.postinro = new SimpleStringProperty();;
        this.mokkinimi = new SimpleStringProperty();
        this.katuosoite = new SimpleStringProperty();
        this.kuvaus = new SimpleStringProperty();
        this.henkilomaara = new SimpleStringProperty();
        this.varustelu = new SimpleStringProperty();
        this.hinta = new SimpleIntegerProperty();;
    }

    public int getMokki_id() {
        return mokki_id.get();
    }

    public IntegerProperty mokki_idProperty() {
        return mokki_id;
    }

    public void setMokki_id(int mokki_id) {
        this.mokki_id.set(mokki_id);
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

    public String getPostinro() {
        return postinro.get();
    }

    public StringProperty postinroProperty() {
        return postinro;
    }

    public void setPostinro(String postinro) {
        this.postinro.set(postinro);
    }

    public String getMokkinimi() {
        return mokkinimi.get();
    }

    public StringProperty mokkinimiProperty() {
        return mokkinimi;
    }

    public void setMokkinimi(String mokkinimi) {
        this.mokkinimi.set(mokkinimi);
    }

    public String getKatuosoite() {
        return katuosoite.get();
    }

    public StringProperty katuosoiteProperty() {
        return katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite.set(katuosoite);
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

    public String getHenkilomaara() {
        return henkilomaara.get();
    }

    public StringProperty henkilomaaraProperty() {
        return henkilomaara;
    }

    public void setHenkilomaara(String henkilomaara) {
        this.henkilomaara.set(henkilomaara);
    }

    public String getVarustelu() {
        return varustelu.get();
    }

    public StringProperty varusteluProperty() {
        return varustelu;
    }

    public void setVarustelu(String varustelu) {
        this.varustelu.set(varustelu);
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

}
