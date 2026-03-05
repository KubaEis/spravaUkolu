package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label info;
    @FXML
    private Button odeslani;
    @FXML
    private TextField nazevUkolu;
    @FXML
    private ListView<Ukol> lstUkolu;
    @FXML
    private ObservableList<Ukol> lstUkoluItems = FXCollections.observableArrayList();
    @FXML
    private RadioButton ANJ, MAT, CES, specha, mamCas, bezTerminu;
    @FXML
    private CheckBox checkUkolu;


    @FXML
    protected void initialize() {
        lstUkolu.setItems(lstUkoluItems);
    }

    @FXML
    protected void onOdeslatButtonClick() {
        String splneno = "";
        String predmet = "";
        String priorita = "";

        if (ANJ.isSelected()) {
            predmet = ANJ.getText();
        }else if (MAT.isSelected()) {
            predmet = MAT.getText();
        }else if (CES.isSelected()) {
            predmet = CES.getText();
        }

        if (specha.isSelected()) {
            priorita = specha.getText();
        }else if (mamCas.isSelected()) {
            priorita = mamCas.getText();
        }else if (bezTerminu.isSelected()) {
            priorita = bezTerminu.getText();
        }

        if (checkUkolu.isSelected()) {
            splneno = "Ano";
        }else{
            splneno = "Ne";
        }

        lstUkoluItems.add(new Ukol(nazevUkolu.getText(),predmet,priorita,splneno));
        nazevUkolu.setText("");
        ANJ.setSelected(false);
        MAT.setSelected(false);
        CES.setSelected(false);
        specha.setSelected(false);
        mamCas.setSelected(false);
        bezTerminu.setSelected(false);
        checkUkolu.setSelected(false);
    }
    @FXML
    protected void onClick(){
        Ukol u = lstUkoluItems.get(lstUkolu.getSelectionModel().getSelectedIndex());
        lstUkolu.setItems(lstUkoluItems);
        info.setText("Informace:\nÚkol: " + u.getNazevUkolu()+"\n Předmět: "+u.getPredmet()+"\n Priorita: "+u.getPriorita()+"\n Splněno: "+u.getSplneno());
    }
}
