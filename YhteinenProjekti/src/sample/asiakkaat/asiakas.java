package sample.asiakkaat;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class asiakas {


    public int getAsiakas_id() {
        return asiakas_id.get();
    }

    public IntegerProperty asiakas_idProperty() {
        return asiakas_id;
    }

    public void setAsiakas_id(int asiakas_id) {
        this.asiakas_id.set(asiakas_id);
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

    public String getLahiosoite() {
        return lahiosoite.get();
    }

    public StringProperty lahiosoiteProperty() {
        return lahiosoite;
    }

    public void setLahiosoite(String lahiosoite) {
        this.lahiosoite.set(lahiosoite);
    }

    public String getPostitoimipaikka() {
        return postitoimipaikka.get();
    }

    public StringProperty postitoimipaikkaProperty() {
        return postitoimipaikka;
    }

    public void setPostitoimipaikka(String postitoimipaikka) {
        this.postitoimipaikka.set(postitoimipaikka);
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

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPuhelinnro() {
        return puhelinnro.get();
    }

    public StringProperty puhelinnroProperty() {
        return puhelinnro;
    }

    public void setPuhelinnro(String puhelinnro) {
        this.puhelinnro.set(puhelinnro);
    }

    private IntegerProperty asiakas_id;
    private StringProperty etunimi;
    private StringProperty sukunimi;
    private StringProperty lahiosoite;
    private StringProperty postitoimipaikka;
    private StringProperty postinro;
    private StringProperty email;
    private StringProperty puhelinnro;

    public asiakas() {
        this.asiakas_id = new SimpleIntegerProperty();
        this.etunimi = new SimpleStringProperty();
        this.sukunimi = new SimpleStringProperty();
        this.lahiosoite = new SimpleStringProperty();
        this.postitoimipaikka = new SimpleStringProperty();
        this.postinro = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.puhelinnro = new SimpleStringProperty();
    }

}
