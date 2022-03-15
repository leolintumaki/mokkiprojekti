package sample.varaus;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class varaukset {

    private IntegerProperty varaus_id;
    private IntegerProperty asiakas_id;
    private IntegerProperty mokki_id;
    private StringProperty varattu_pvm;
    private StringProperty vahvistus_pvm;
    private StringProperty varattu_alkupvm;
    private StringProperty varattu_loppupvm;

    public varaukset() {
        this.varaus_id = new SimpleIntegerProperty();
        this.asiakas_id = new SimpleIntegerProperty();
        this.mokki_id = new SimpleIntegerProperty();
        this.varattu_pvm = new SimpleStringProperty();
        this.vahvistus_pvm = new SimpleStringProperty();
        this.varattu_alkupvm = new SimpleStringProperty();
        this.varattu_loppupvm = new SimpleStringProperty();
    }

    public int getVaraus_id() {
        return varaus_id.get();
    }

    public IntegerProperty varaus_idProperty() {
        return varaus_id;
    }

    public void setVaraus_id(int varaus_id) {
        this.varaus_id.set(varaus_id);
    }

    public int getAsiakas_id() {
        return asiakas_id.get();
    }

    public IntegerProperty asiakas_idProperty() {
        return asiakas_id;
    }

    public void setAsiakas_id(int asiakas_id) {
        this.asiakas_id.set(asiakas_id);
    }

    public int getMokki_id() {
        return mokki_id.get();
    }

    public IntegerProperty mokki_idProperty() {
        return mokki_id;
    }

    public void setMokki_id(int toimipiste_id) {
        this.mokki_id.set(toimipiste_id);
    }

    public String getVarattu_pvm() {
        return varattu_pvm.get();
    }

    public StringProperty varattu_pvmProperty() {
        return varattu_pvm;
    }

    public void setVarattu_pvm(String varattu_pvm) {
        this.varattu_pvm.set(varattu_pvm);
    }

    public String getVahvistus_pvm() {
        return vahvistus_pvm.get();
    }

    public StringProperty vahvistus_pvmProperty() {
        return vahvistus_pvm;
    }

    public void setVahvistus_pvm(String vahvistus_pvm) {
        this.vahvistus_pvm.set(vahvistus_pvm);
    }

    public String getVarattu_alkupvm() {
        return varattu_alkupvm.get();
    }

    public StringProperty varattu_alkupvmProperty() {
        return varattu_alkupvm;
    }

    public void setVarattu_alkupvm(String varattu_alkupvm) {
        this.varattu_alkupvm.set(varattu_alkupvm);
    }

    public String getVarattu_loppupvm() {
        return varattu_loppupvm.get();
    }

    public StringProperty varattu_loppupvmProperty() {
        return varattu_loppupvm;
    }

    public void setVarattu_loppupvm(String varattu_loppupvm) {
        this.varattu_loppupvm.set(varattu_loppupvm);
    }
}
