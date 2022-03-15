package sample.var_palvelut;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class var_palvelut {

    private IntegerProperty varaus_id;
    private IntegerProperty palvelu_id;
    private IntegerProperty lkm;

    public var_palvelut() {
        this.varaus_id = new SimpleIntegerProperty();
        this.palvelu_id = new SimpleIntegerProperty();
        this.lkm = new SimpleIntegerProperty();
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

    public int getPalvelu_id() {
        return palvelu_id.get();
    }

    public IntegerProperty palvelu_idProperty() {
        return palvelu_id;
    }

    public void setPalvelu_id(int palvelu_id) {
        this.palvelu_id.set(palvelu_id);
    }

    public int getLkm() {
        return lkm.get();
    }

    public IntegerProperty lkmProperty() {
        return lkm;
    }

    public void setLkm(int lkm) {
        this.lkm.set(lkm);
    }
}
