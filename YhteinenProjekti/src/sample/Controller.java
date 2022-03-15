package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import sample.asiakkaat.asiakas;
import sample.asiakkaat.asiakasDAO;
import sample.lasku.lasku;
import sample.lasku.laskuDAO;
import sample.palvelu.palvelu;
import sample.palvelu.palveluDAO;
import sample.mokki.toimipisteet;
import sample.mokki.toimipisteetDAO;
import sample.toimintaAlue.toimintaAlue;
import sample.toimintaAlue.toimintaAlueDAO;
import sample.var_palvelut.var_palvelut;
import sample.var_palvelut.var_palvelutDAO;
import sample.varaus.varaukset;
import sample.varaus.varauksetDAO;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class Controller {

    //asiakaskenttiä

    @FXML
    private TextField as_id;
    @FXML
    private TextField as_etunimi;
    @FXML
    private TextField as_sukunimi;
    @FXML
    private TextField as_lahiOsoite;
    @FXML
    private TextField as_postiToimiPaikka;
    @FXML
    private TextField as_postiNumero;
    @FXML
    private TextField as_email;
    @FXML
    private TextField as_puhelinNro;
    @FXML
    private TextArea as_konsoli;
    @FXML
    private Button btnAddAsiakas;
    @FXML
    private Button btnDelAsiakas;
    @FXML
    private Button btnListAsiakas;
    @FXML
    private Button btnUpdAsiakas;

    //toimipistekenttiä

    @FXML
    private TextField tp_id;
    @FXML
    private TextField tp_Nimi;
    @FXML
    private TextField tp_lahiOsoite;
    @FXML
    private TextField tp_PostiToimiPaikka;
    @FXML
    private TextField tp_Postinro;
    @FXML
    private TextField tp_Email;
    @FXML
    private TextField tp_Puhelinnro;
    @FXML
    private TextField tp_varustelu;
    @FXML
    private TextField tp_hinta;
    @FXML
    private TextArea tp_konsoli;
    @FXML
    private Button btnAddToimipiste;
    @FXML
    private Button btnDelToimipiste;
    @FXML
    private Button btnListToimipiste;
    @FXML
    private Button btnUpdToimipiste;

    //varauskenttiä

    @FXML
    private TextField va_id;
    @FXML
    private TextField va_asid;
    @FXML
    private TextField va_tpid;
    @FXML
    private TextField va_varPvm;
    @FXML
    private TextField va_vahvPvm;
    @FXML
    private TextField va_varAlku;
    @FXML
    private TextField va_varLoppu;
    @FXML
    private TextArea va_konsoli;
    @FXML
    private Button btnAddVaraus;
    @FXML
    private Button btnDelVaraus;
    @FXML
    private Button btnListVaraus;
    @FXML
    private Button btnUpdVaraus;

    //palvelukenttiä

    @FXML
    private TextField pa_id;
    @FXML
    private TextField pa_tpid;
    @FXML
    private TextField pa_nimi;
    @FXML
    private TextField pa_tyyppi;
    @FXML
    private TextField pa_kuvaus;
    @FXML
    private TextField pa_hinta;
    @FXML
    private TextField pa_alv;
    @FXML
    private TextArea pa_konsoli;
    @FXML
    private Button btnAddPalvelu;
    @FXML
    private Button btnDelPalvelu;
    @FXML
    private Button btnListPalvelu;
    @FXML
    private Button btnUpdPalvelu;

    // var_palvelukenttiä

    @FXML
    private TextField vp_varaus_id;
    @FXML
    private TextField vp_palvelu_id;
    @FXML
    private TextField vp_lkm;
    @FXML
    private TextArea vp_konsoli;
    @FXML
    private Button btnAddvp;
    @FXML
    private Button btnDelvp;
    @FXML
    private Button btnListvp;
    @FXML
    private Button btnUpdvp;

    // laskukenttiä

    @FXML
    private TextField lasku_id;
    @FXML
    private TextField la_varaus_id;
    @FXML
    private TextField la_summa;
    @FXML
    private TextField la_alv;
    @FXML
    private TextArea la_konsoli;
    @FXML
    private Button btnAddLasku;
    @FXML
    private Button btnDelLasku;
    @FXML
    private Button btnListLasku;
    @FXML
    private Button btnUpdLasku;
    @FXML
    private Button btnRaport;

    //toimintaaluekenttiä

    @FXML
    private TextField ta_id;
    @FXML
    private TextField ta_nimi;
    @FXML
    private TextArea ta_konsoli;

    //asiakastaulu
    @FXML
    private TableView<asiakas> asiakasTaulu;
    @FXML
    private TableColumn<asiakas, Integer> as_idColumn;
    @FXML
    private TableColumn<asiakas, String> as_etunimiColumn;
    @FXML
    private TableColumn<asiakas, String> as_sukunimiColumn;
    @FXML
    private TableColumn<asiakas, String> as_lahiOsoiteColumn;
    @FXML
    private TableColumn<asiakas, String> as_postiToimiPaikkaColumn;
    @FXML
    private TableColumn<asiakas, String> as_postiNumeroColumn;
    @FXML
    private TableColumn<asiakas, String> as_emailColumn;
    @FXML
    private TableColumn<asiakas, String> as_puhelinNroColumn;

    //toimipistetaulu
    @FXML
    private TableView<toimipisteet> toimipisteTaulu;
    @FXML
    private TableColumn<toimipisteet, Integer> tp_idColumn;
    @FXML
    private TableColumn<toimipisteet, Integer> tp_NimiColumn;
    @FXML
    private TableColumn<toimipisteet, String> tp_LahiOsoiteColumn;
    @FXML
    private TableColumn<toimipisteet, String> tp_PostiToimiPaikkaColumn;
    @FXML
    private TableColumn<toimipisteet, String> tp_PostinroColumn;
    @FXML
    private TableColumn<toimipisteet, String> tp_EmailColumn;
    @FXML
    private TableColumn<toimipisteet, String> tp_PuhelinnroColumn;
    @FXML
    private TableColumn<toimipisteet, String> tp_varusteluColumn;
    @FXML
    private TableColumn<toimipisteet, Integer> tp_hintaColumn;

    //varaustaulu
    @FXML
    private TableView<varaukset> varausTaulu;
    @FXML
    private TableColumn<varaukset, Integer> va_idColumn;
    @FXML
    private TableColumn<varaukset, Integer> va_asidColumn;
    @FXML
    private TableColumn<varaukset, Integer> va_tpidColumn;
    @FXML
    private TableColumn<varaukset, String> va_varPvmColumn;
    @FXML
    private TableColumn<varaukset, String> va_vahvPvmColumn;
    @FXML
    private TableColumn<varaukset, String> va_varAlkuColumn;
    @FXML
    private TableColumn<varaukset, String> va_varLoppuColumn;

    //palvelutaulu

    @FXML
    private TableView<palvelu> palveluTaulu;
    @FXML
    private TableColumn<palvelu, Integer> pa_idColumn;
    @FXML
    private TableColumn<palvelu, Integer> pa_tpidColumn;
    @FXML
    private TableColumn<palvelu, String> pa_nimiColumn;
    @FXML
    private TableColumn<palvelu, String> pa_tyyppiColumn;
    @FXML
    private TableColumn<palvelu, String> pa_kuvausColumn;
    @FXML
    private TableColumn<palvelu, Integer> pa_hintaColumn;
    @FXML
    private TableColumn<palvelu, Integer> pa_alvColumn;

    //varausten palvelut taulu

    @FXML
    private TableView<var_palvelut> vpTaulu;
    @FXML
    private TableColumn<var_palvelut, Integer> vp_varaus_idColumn;
    @FXML
    private TableColumn<var_palvelut, Integer> vp_palvelu_idColumn;
    @FXML
    private TableColumn<var_palvelut, Integer> vp_lkmColumn;

    // laskutaulu

    @FXML
    private TableView<lasku> laskuTaulu;
    @FXML
    private TableColumn<lasku, Integer> lasku_idColumn;
    @FXML
    private TableColumn<lasku, Integer> la_varaus_idColumn;
    @FXML
    private TableColumn<lasku, Integer> la_summaColumn;
    @FXML
    private TableColumn<lasku, Integer> la_alvColumn;

    //toimintaalue taulu

    @FXML
    private TableView<toimintaAlue> toimintaAlueTaulu;
    @FXML
    private TableColumn<toimintaAlue, Integer> ta_idColumn;
    @FXML
    private TableColumn<toimintaAlue, String> ta_nimiColumn;


    //alustaa taulukot
    @FXML
    private void initialize () {


        //asiakas
        as_idColumn.setCellValueFactory(cellData -> cellData.getValue().asiakas_idProperty().asObject());
        as_etunimiColumn.setCellValueFactory(cellData -> cellData.getValue().etunimiProperty());
        as_sukunimiColumn.setCellValueFactory(cellData -> cellData.getValue().sukunimiProperty());
        as_lahiOsoiteColumn.setCellValueFactory(cellData -> cellData.getValue().lahiosoiteProperty());
        as_postiToimiPaikkaColumn.setCellValueFactory(cellData -> cellData.getValue().postitoimipaikkaProperty());
        as_postiNumeroColumn.setCellValueFactory(cellData -> cellData.getValue().postinroProperty());
        as_emailColumn.setCellValueFactory(CellData -> CellData.getValue().emailProperty());
        as_puhelinNroColumn.setCellValueFactory(CellData -> CellData.getValue().puhelinnroProperty());

        // toimipiste
        tp_idColumn.setCellValueFactory(cellData -> cellData.getValue().mokki_idProperty().asObject());
        tp_NimiColumn.setCellValueFactory(cellData -> cellData.getValue().toimintaalue_idProperty().asObject());
        tp_LahiOsoiteColumn.setCellValueFactory(cellData -> cellData.getValue().postinroProperty());
        tp_PostiToimiPaikkaColumn.setCellValueFactory(cellData -> cellData.getValue().mokkinimiProperty());
        tp_PostinroColumn.setCellValueFactory(cellData -> cellData.getValue().katuosoiteProperty());
        tp_EmailColumn.setCellValueFactory(cellData -> cellData.getValue().kuvausProperty());
        tp_PuhelinnroColumn.setCellValueFactory(cellData -> cellData.getValue().henkilomaaraProperty());
        tp_varusteluColumn.setCellValueFactory(cellData -> cellData.getValue().varusteluProperty());
        tp_hintaColumn.setCellValueFactory(cellData -> cellData.getValue().hintaProperty().asObject());

        //varaukset
        va_idColumn.setCellValueFactory(cellData -> cellData.getValue().varaus_idProperty().asObject());
        va_asidColumn.setCellValueFactory(cellData -> cellData.getValue().asiakas_idProperty().asObject());
        va_tpidColumn.setCellValueFactory(cellData -> cellData.getValue().mokki_idProperty().asObject());
        va_varPvmColumn.setCellValueFactory(cellData -> cellData.getValue().varattu_pvmProperty());
        va_vahvPvmColumn.setCellValueFactory(cellData -> cellData.getValue().vahvistus_pvmProperty());
        va_varAlkuColumn.setCellValueFactory(cellData -> cellData.getValue().varattu_alkupvmProperty());
        va_varLoppuColumn.setCellValueFactory(cellData -> cellData.getValue().varattu_loppupvmProperty());

        //palvelut
        pa_idColumn.setCellValueFactory(cellData -> cellData.getValue().palvelu_idProperty().asObject());
        pa_tpidColumn.setCellValueFactory(cellData -> cellData.getValue().toimintaalue_idProperty().asObject());
        pa_nimiColumn.setCellValueFactory(cellData -> cellData.getValue().nimiProperty());
        pa_tyyppiColumn.setCellValueFactory(cellData -> cellData.getValue().tyyppiProperty());
        pa_kuvausColumn.setCellValueFactory(cellData -> cellData.getValue().kuvausProperty());
        pa_hintaColumn.setCellValueFactory(cellData -> cellData.getValue().hintaProperty().asObject());
        pa_alvColumn.setCellValueFactory(cellData -> cellData.getValue().alvProperty().asObject());

        //varausten palvelut
        vp_varaus_idColumn.setCellValueFactory(cellData -> cellData.getValue().varaus_idProperty().asObject());
        vp_palvelu_idColumn.setCellValueFactory(cellData -> cellData.getValue().palvelu_idProperty().asObject());
        vp_lkmColumn.setCellValueFactory(cellData -> cellData.getValue().lkmProperty().asObject());

        //laskut

        lasku_idColumn.setCellValueFactory(cellData -> cellData.getValue().lasku_idProperty().asObject());
        la_varaus_idColumn.setCellValueFactory(cellData -> cellData.getValue().varaus_idProperty().asObject());
        la_summaColumn.setCellValueFactory(cellData -> cellData.getValue().summaProperty().asObject());
        la_alvColumn.setCellValueFactory(cellData -> cellData.getValue().alvProperty().asObject());

        //toimintaAlue

        ta_idColumn.setCellValueFactory(cellData -> cellData.getValue().toimintaAlue_idProperty().asObject());
        ta_nimiColumn.setCellValueFactory(cellData -> cellData.getValue().nimiProperty());


    }

    //ASIAKAS

    @FXML
    private void etsiAsiakas (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            asiakas as = asiakasDAO.etsiAsiakas(as_id.getText());
            populateAndShowAsiakas(as);
        } catch (SQLException e){
            System.out.println("Error" + e);
            throw e;
        }
    }
    @FXML
    private void etsiAsiakkaat(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<asiakas> asData = asiakasDAO.etsiAsiakkaat();
            populateAsiakas(asData);
        } catch (SQLException e){
            System.out.println("Virhe: \n" + e);
            throw e;
        }

    }



    @FXML
    private void populateAsiakas (asiakas as) throws ClassNotFoundException {
        ObservableList<asiakas> asData = FXCollections.observableArrayList();
        asData.add(as);
        asiakasTaulu.setItems(asData);
    }




    // täyttää asiakastaulun
    @FXML
    private void populateAndShowAsiakas(asiakas as) throws ClassNotFoundException {
        if (as != null) {
            populateAsiakas(as);
        } else {
            as_konsoli.setText("Asiakasta ei löytynyt.\n");
        }
    }


    @FXML
    private void populateAsiakas (ObservableList<asiakas> asData) throws ClassNotFoundException {
        asiakasTaulu.setItems(asData);
    }

    // lisää asiakas
    @FXML
    private void insertAsiakas (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            asiakasDAO.insertAsiakas(as_id.getText(), as_etunimi.getText(),as_sukunimi.getText(),as_lahiOsoite.getText(), as_postiToimiPaikka.getText(),as_postiNumero.getText(), as_email.getText(), as_puhelinNro.getText());
            as_konsoli.setText("Asiakas lisätty! \n");
        } catch (SQLException e) {
            as_konsoli.setText("Virhe lisätessä asiakasta " + e);
            throw e;
        }
    }


    // poista asiakas id:n perusteella
    @FXML
    private void deleteAsiakas (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            asiakasDAO.deleteAsiakas(as_id.getText());
            as_konsoli.setText("Asiakas poistettu! " + as_id.getText() + "\n");
        } catch (SQLException e) {
            as_konsoli.setText("Virhe poistaessa asiakasta " + e);
            throw e;
        }
    }

    //muokkaa asiakkaan tietoja
    @FXML
    private void updateAsiakas (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            asiakasDAO.updateAsiakas(as_id.getText(), as_etunimi.getText(), as_sukunimi.getText(), as_lahiOsoite.getText(), as_postiToimiPaikka.getText(),as_postiNumero.getText(), as_email.getText(), as_puhelinNro.getText());
            as_konsoli.setText("Tiedot tallennettu! id: " + tp_id.getText() + "\n");
        } catch (SQLException e) {
            as_konsoli.setText("Virhe tietoja tallentaessa. " + e);
            throw e;
        }
    }

    //TOIMIPISTE

    @FXML
    private void etsiToimipiste (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            toimipisteet tp = toimipisteetDAO.etsiToimipiste(tp_id.getText());
            populateAndShowToimipiste(tp);
        } catch (SQLException e){
            System.out.println("Error" + e);
            throw e;
        }
    }
    @FXML
    private void etsiToimipisteet(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<toimipisteet> tpData = toimipisteetDAO.etsiToimipisteet();
            populateToimipiste(tpData);
        } catch (SQLException e){
            System.out.println("Virhe: \n" + e);
            throw e;
        }

    }

    @FXML
    private void populateToimipiste (toimipisteet tp) throws ClassNotFoundException {
        ObservableList<toimipisteet> tpData = FXCollections.observableArrayList();
        tpData.add(tp);
        toimipisteTaulu.setItems(tpData);
    }


    // täyttää toimipistetaulun
    @FXML
    private void populateAndShowToimipiste(toimipisteet tp) throws ClassNotFoundException {
        if (tp != null) {
            populateToimipiste(tp);
        } else {
            tp_konsoli.setText("Toimipistettä ei löytynyt.\n");
        }
    }


    @FXML
    private void populateToimipiste (ObservableList<toimipisteet> tpData) throws ClassNotFoundException {
        toimipisteTaulu.setItems(tpData);
    }

    //
    @FXML
    private void insertToimipiste (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            toimipisteetDAO.insertToimipiste(tp_id.getText(), tp_Nimi.getText(),tp_lahiOsoite.getText(), tp_PostiToimiPaikka.getText(),tp_Postinro.getText(), tp_Email.getText(), tp_Puhelinnro.getText(), tp_varustelu.getText(), tp_hinta.getText());
            tp_konsoli.setText("Toimipiste lisätty! \n");
        } catch (SQLException e) {
            tp_konsoli.setText("Virhe lisätessä toimipistettä " + e);
            throw e;
        }
    }


    // poista toimipiste id:n perusteella
    @FXML
    private void deleteToimipiste (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            toimipisteetDAO.deleteToimipiste(tp_id.getText());
            tp_konsoli.setText("Toimipiste poistettu! " + tp_id.getText() + "\n");
        } catch (SQLException e) {
            tp_konsoli.setText("Virhe poistaessa toimipistettä " + e);
            throw e;
        }
    }

    //muokkaa toimipisteen tietoja
    @FXML
    private void updateToimipiste (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            toimipisteetDAO.updateToimipiste(tp_id.getText(), tp_Nimi.getText(),tp_lahiOsoite.getText(), tp_PostiToimiPaikka.getText(),tp_Postinro.getText(), tp_Email.getText(), tp_Puhelinnro.getText(), tp_varustelu.getText(), tp_hinta.getText());
            tp_konsoli.setText("Tiedot tallennettu toimipisteelle" + tp_id.getText() + "\n");
        } catch (SQLException e) {
            tp_konsoli.setText("Virhe tietoja tallentaessa. " + e);
            throw e;
        }
    }

    //VARAUKSET

    @FXML
    private void etsiVaraus (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            varaukset va = varauksetDAO.etsiVaraus(va_id.getText());
            populateAndShowVaraus(va);
        } catch (SQLException e){
            System.out.println("Virhe" + e);
            throw e;
        }
    }
    @FXML
    private void etsiVaraukset(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<varaukset> vaData = varauksetDAO.etsiVaraukset();
            populateVaraus(vaData);
        } catch (SQLException e){
            System.out.println("Virhe: \n" + e);
            throw e;
        }

    }

    @FXML
    private void populateVaraus (varaukset va) throws ClassNotFoundException {
        ObservableList<varaukset> vaData = FXCollections.observableArrayList();
        vaData.add(va);
        varausTaulu.setItems(vaData);
    }



    @FXML
    private void populateAndShowVaraus(varaukset va) throws ClassNotFoundException {
        if (va != null) {
            populateVaraus(va);
        } else {
            va_konsoli.setText("Varausta ei löytynyt.\n");
        }
    }


    @FXML
    private void populateVaraus (ObservableList<varaukset> vaData) throws ClassNotFoundException {
        varausTaulu.setItems(vaData);
    }

    //
    @FXML
    private void insertVaraus (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            varauksetDAO.insertVaraus(va_id.getText(), va_asid.getText(), va_tpid.getText(), va_varPvm.getText(),va_vahvPvm.getText(), va_varAlku.getText(),va_varLoppu.getText());
            va_konsoli.setText("Varaus lisätty! \n");
        } catch (SQLException e) {
            va_konsoli.setText("Virhe lisätessä varausta!! " + e);
            throw e;
        }
    }


    // poista varaus id:n perusteella
    @FXML
    private void deleteVaraus (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            varauksetDAO.deleteVaraus(va_id.getText());
            va_konsoli.setText("Varaus poistettu! " + va_id.getText() + "\n");
        } catch (SQLException e) {
            va_konsoli.setText("Virhe poistaessa varausta!! " + e);
            throw e;
        }
    }

    //muokkaa varauksen tietoja
    @FXML
    private void updateVaraus (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            varauksetDAO.updateVaraus(va_id.getText(), va_asid.getText(), va_tpid.getText(), va_varPvm.getText(),va_vahvPvm.getText(), va_varAlku.getText(),va_varLoppu.getText());
            va_konsoli.setText("Tiedot tallennettu varaukselle" + va_id.getText() + "\n");
        } catch (SQLException e) {
            va_konsoli.setText("Virhe tietoja tallentaessa. " + e);
            throw e;
        }
    }

    //PALVELUT

    @FXML
    private void etsiPalvelu (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            palvelu pa = palveluDAO.etsiPalvelu(pa_id.getText());
            populateAndShowPalvelu(pa);
        } catch (SQLException e){
            System.out.println("Virhe" + e);
            throw e;
        }
    }
    @FXML
    private void etsiPalvelut(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<palvelu> paData = palveluDAO.etsiPalvelut();
            populatePalvelu(paData);
        } catch (SQLException e){
            System.out.println("Virhe: \n" + e);
            throw e;
        }

    }

    @FXML
    private void populatePalvelu (palvelu pa) throws ClassNotFoundException {
        ObservableList<palvelu> paData = FXCollections.observableArrayList();
        paData.add(pa);
        palveluTaulu.setItems(paData);
    }


    // täyttää palvelutaulun
    @FXML
    private void populateAndShowPalvelu(palvelu pa) throws ClassNotFoundException {
        if (pa != null) {
            populatePalvelu(pa);
        } else {
            pa_konsoli.setText("Palvelua ei löytynyt.\n");
        }
    }


    @FXML
    private void populatePalvelu (ObservableList<palvelu> paData) throws ClassNotFoundException {
        palveluTaulu.setItems(paData);
    }

    //
    @FXML
    private void insertPalvelu (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            palveluDAO.insertPalvelu(pa_id.getText(), pa_tpid.getText(), pa_nimi.getText(),pa_tyyppi.getText(), pa_kuvaus.getText(),pa_hinta.getText(), pa_alv.getText());
            pa_konsoli.setText("Palvelu lisätty! \n");
        } catch (SQLException e) {
            pa_konsoli.setText("Virhe lisätessä palvelua!! " + e);
            throw e;
        }
    }


    // poista palvelu id:n perusteella
    @FXML
    private void deletePalvelu (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            palveluDAO.deletePalvelu(pa_id.getText());
            pa_konsoli.setText("Palvelu poistettu! " + pa_id.getText() + "\n");
        } catch (SQLException e) {
            pa_konsoli.setText("Virhe poistaessa palvelua!! " + e);
            throw e;
        }
    }

    //muokkaa palvelun tietoja
    @FXML
    private void updatePalvelu (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            palveluDAO.updatePalvelu(pa_id.getText(),pa_tpid.getText(), pa_nimi.getText(),pa_tyyppi.getText(), pa_kuvaus.getText(),pa_hinta.getText(),pa_alv.getText());
            pa_konsoli.setText("Tiedot tallennettu! id: " + tp_id.getText() + "\n");
        } catch (SQLException e) {
            pa_konsoli.setText("Virhe tietoja tallentaessa. " + e);
            throw e;
        }
    }

    //VARAUSTEN PALVELUT

    @FXML
    private void etsiVarPal (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            var_palvelut vp = var_palvelutDAO.etsiVarPal(vp_varaus_id.getText());
            populateAndShowVP(vp);
        } catch (SQLException e){
            System.out.println("Virhe" + e);
            throw e;
        }
    }

    @FXML
    private void etsiVarPalv(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<var_palvelut> vpData = var_palvelutDAO.etsiVarPalv();
            populateVP(vpData);
        } catch (SQLException e){
            System.out.println("Virhe: \n" + e);
            throw e;
        }

    }

    @FXML
    private void populateVP (var_palvelut vp) throws ClassNotFoundException {
        ObservableList<var_palvelut> vpData = FXCollections.observableArrayList();
        vpData.add(vp);
        vpTaulu.setItems(vpData);
    }


    // täyttää palvelutaulun
    @FXML
    private void populateAndShowVP(var_palvelut vp) throws ClassNotFoundException {
        if (vp != null) {
            populateVP(vp);
        } else {
            vp_konsoli.setText("Palvelua ei löytynyt.\n");
        }
    }


    @FXML
    private void populateVP (ObservableList<var_palvelut> vpData) throws ClassNotFoundException {
        vpTaulu.setItems(vpData);
    }

    //
    @FXML
    private void insertVp (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            var_palvelutDAO.insertVp(vp_varaus_id.getText(), vp_palvelu_id.getText(), vp_lkm.getText());
            vp_konsoli.setText("Palvelu lisätty! \n");
        } catch (SQLException e) {
            vp_konsoli.setText("Virhe!! " + e);
            throw e;
        }
    }


    // poista palvelu id:n perusteella
    @FXML
    private void deleteVP (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            var_palvelutDAO.deleteVP(vp_varaus_id.getText());
            vp_konsoli.setText("Palvelu poistettu! " + vp_varaus_id.getText() + "\n");
        } catch (SQLException e) {
            vp_konsoli.setText("Virhe!! " + e);
            throw e;
        }
    }

    //muokkaa palvelun tietoja
    @FXML
    private void updateVp (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            var_palvelutDAO.updateVp(vp_varaus_id.getText(),vp_palvelu_id.getText(), vp_lkm.getText());
            vp_konsoli.setText("Tiedot tallennettu! id: " + vp_varaus_id.getText() + "\n");
        } catch (SQLException e) {
            vp_konsoli.setText("Virhe tietoja tallentaessa. " + e);
            throw e;
        }
    }

    //LASKU

    @FXML
    private void etsiLasku (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            lasku la = laskuDAO.etsiLasku(lasku_id.getText());
            populateAndShowLasku(la);
        } catch (SQLException e){
            System.out.println("Virhe" + e);
            throw e;
        }
    }

    @FXML
    private void etsiLaskut(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<lasku> laskuData = laskuDAO.etsiLaskut();
            populateLasku(laskuData);
        } catch (SQLException e){
            System.out.println("Virhe: \n" + e);
            throw e;
        }

    }

    @FXML
    private void populateLasku (lasku la) throws ClassNotFoundException {
        ObservableList<lasku> laskuData = FXCollections.observableArrayList();
        laskuData.add(la);
        laskuTaulu.setItems(laskuData);
    }


    // täyttää palvelutaulun
    @FXML
    private void populateAndShowLasku(lasku la) throws ClassNotFoundException {
        if (la != null) {
            populateLasku(la);
        } else {
            la_konsoli.setText("Laskua ei löytynyt.\n");
        }
    }


    @FXML
    private void populateLasku (ObservableList<lasku> laskuData) throws ClassNotFoundException {
        laskuTaulu.setItems(laskuData);
    }

    //
    @FXML
    private void insertLasku (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            laskuDAO.insertLasku(lasku_id.getText(), la_varaus_id.getText(), la_summa.getText(), la_alv.getText());
            la_konsoli.setText("Lasku lisätty! \n");
        } catch (SQLException e) {
            vp_konsoli.setText("Virhe!! " + e);
            throw e;
        }
    }


    // poista lasku id:n perusteella
    @FXML
    private void deleteLasku (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            laskuDAO.deleteLasku(lasku_id.getText());
            la_konsoli.setText("Lasku poistettu! " + lasku_id.getText() + "\n");
        } catch (SQLException e) {
            la_konsoli.setText("Virhe!! " + e);
            throw e;
        }
    }

    //muokkaa palvelun tietoja
    @FXML
    private void updateLasku (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            laskuDAO.updateLasku(lasku_id.getText(), la_varaus_id.getText(), la_summa.getText(), la_alv.getText());
            la_konsoli.setText("Tiedot tallennettu! id: " + vp_varaus_id.getText() + "\n");
        } catch (SQLException e) {
            la_konsoli.setText("Virhe tietoja tallentaessa. " + e);
            throw e;
        }
    }

    //TOIMINTAALUE

    @FXML
    private void etsiToimintaAlue (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            toimintaAlue ta = toimintaAlueDAO.etsiToimintaAlue(ta_id.getText());
            populateAndShowToimintaAlue(ta);
        } catch (SQLException e){
            System.out.println("Error" + e);
            throw e;
        }
    }
    @FXML
    private void etsiToimintaAlueet(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<toimintaAlue> taData = toimintaAlueDAO.etsitoimintaalue();
            populateToimintaAlue(taData);
        } catch (SQLException e){
            System.out.println("Virhe: \n" + e);
            throw e;
        }

    }



    @FXML
    private void populateToimintaAlue (toimintaAlue ta) throws ClassNotFoundException {
        ObservableList<toimintaAlue> taData = FXCollections.observableArrayList();
        taData.add(ta);
        toimintaAlueTaulu.setItems(taData);
    }




    // täyttää toimintaalue taulun
    @FXML
    private void populateAndShowToimintaAlue(toimintaAlue ta) throws ClassNotFoundException {
        if (ta != null) {
            populateToimintaAlue(ta);
        } else {
            ta_konsoli.setText("Toimintaaluetta ei löytynyt.\n");
        }
    }


    @FXML
    private void populateToimintaAlue (ObservableList<toimintaAlue> taData) throws ClassNotFoundException {
        toimintaAlueTaulu.setItems(taData);
    }

    // lisää toimintaalue
    @FXML
    private void insertToimintaAlue (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            toimintaAlueDAO.insertToimintaAlue(ta_id.getText(), ta_nimi.getText());
            as_konsoli.setText("Asiakas lisätty! \n");
        } catch (SQLException e) {
            as_konsoli.setText("Virhe lisätessä asiakasta " + e);
            throw e;
        }
    }


    // poista toimintaalue id:n perusteella
    @FXML
    private void deleteToimintaAlue (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            toimintaAlueDAO.deleteToimintaAlue(ta_id.getText());
            ta_konsoli.setText("Toiminta alue poistettu! " + ta_id.getText() + "\n");
        } catch (SQLException e) {
            ta_konsoli.setText("Virhe poistaessa toimintaaluetta " + e);
            throw e;
        }
    }

    //muokkaa toimintaalueen tietoja
    @FXML
    private void updateToimintaAlue (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            toimintaAlueDAO.updateToimintaAlue(ta_id.getText(), ta_nimi.getText());
            ta_konsoli.setText("Tiedot tallennettu! id: " + tp_id.getText() + "\n");
        } catch (SQLException e) {
            ta_konsoli.setText("Virhe tietoja tallentaessa. " + e);
            throw e;
        }
    }

}
