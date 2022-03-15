package sample.paaIkkuna;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class paaIkkuna {

    private IntegerProperty varausID;
    private IntegerProperty asiakasID;
    private IntegerProperty toimipisteID;
    private StringProperty etunimi;
    private StringProperty sukunimi;
    private StringProperty toimipiste;
    private StringProperty var_alku;
    private StringProperty var_loppu;
    private IntegerProperty palvelu_lkm;

    public paaIkkuna() {
        this.varausID = new SimpleIntegerProperty();
        this.asiakasID = new SimpleIntegerProperty();
        this.toimipisteID = new SimpleIntegerProperty();
        this.etunimi = new SimpleStringProperty();
        this.sukunimi = new SimpleStringProperty();
        this.toimipiste = new SimpleStringProperty();
        this.var_alku = new SimpleStringProperty();
        this.var_loppu = new SimpleStringProperty();
        this.palvelu_lkm = new SimpleIntegerProperty();
    }

    public int getVarausID() {
        return varausID.get();
    }

    public IntegerProperty varausIDProperty() {
        return varausID;
    }

    public void setVarausID(int varausID) {
        this.varausID.set(varausID);
    }

    public int getAsiakasID() {
        return asiakasID.get();
    }

    public IntegerProperty asiakasIDProperty() {
        return asiakasID;
    }

    public void setAsiakasID(int asiakasID) {
        this.asiakasID.set(asiakasID);
    }

    public int getToimipisteID() {
        return toimipisteID.get();
    }

    public IntegerProperty toimipisteIDProperty() {
        return toimipisteID;
    }

    public void setToimipisteID(int toimipisteID) {
        this.toimipisteID.set(toimipisteID);
    }

    public String getEtunimi() {
        return etunimi.get();
    }

    public StringProperty etunimiProperty() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi.set(etunimi);
    }

    public String getSukunimi() {
        return sukunimi.get();
    }

    public StringProperty sukunimiProperty() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi.set(sukunimi);
    }

    public String getToimipiste() {
        return toimipiste.get();
    }

    public StringProperty toimipisteProperty() {
        return toimipiste;
    }

    public void setToimipiste(String toimipiste) {
        this.toimipiste.set(toimipiste);
    }

    public String getVar_alku() {
        return var_alku.get();
    }

    public StringProperty var_alkuProperty() {
        return var_alku;
    }

    public void setVar_alku(String var_alku) {
        this.var_alku.set(var_alku);
    }

    public String getVar_loppu() {
        return var_loppu.get();
    }

    public StringProperty var_loppuProperty() {
        return var_loppu;
    }

    public void setVar_loppu(String var_loppu) {
        this.var_loppu.set(var_loppu);
    }

    public int getPalvelu_lkm() {
        return palvelu_lkm.get();
    }

    public IntegerProperty palvelu_lkmProperty() {
        return palvelu_lkm;
    }

    public void setPalvelu_lkm(int palvelu_lkm) {
        this.palvelu_lkm.set(palvelu_lkm);
    }
}
