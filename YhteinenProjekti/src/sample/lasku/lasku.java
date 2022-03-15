package sample.lasku;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class lasku {

    private IntegerProperty lasku_id;
    private IntegerProperty varaus_id;
    private IntegerProperty summa;
    private IntegerProperty alv;

    public lasku() {
        this.lasku_id = new SimpleIntegerProperty();
        this.varaus_id = new SimpleIntegerProperty();
        this.alv = new SimpleIntegerProperty();
        this.summa = new SimpleIntegerProperty();;
    }

    public int getLasku_id() {
        return lasku_id.get();
    }

    public IntegerProperty lasku_idProperty() {
        return lasku_id;
    }

    public void setLasku_id(int lasku_id) {
        this.lasku_id.set(lasku_id);
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

    public int getSumma() {
        return summa.get();
    }

    public IntegerProperty summaProperty() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa.set(summa);
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
}
