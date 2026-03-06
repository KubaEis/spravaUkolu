package com.example.demo1;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label info;
    @FXML
    private Button odeslani, uprava, smazani, detail, dokoncit;
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
    private MenuItem ukoncit, vse, dokoncene, nedokoncene;
    @FXML
    protected void initialize() {
        lstUkolu.setItems(lstUkoluItems);
    }
    private List<Ukol> listUkolu = new ArrayList<>();

    @FXML
    protected void onOdeslatButtonClick() {
        boolean nazev = true;
        boolean predmet = true;
        boolean priorita = true;
        if (nazevUkolu.getText().equals("")) {
            System.out.println("Ukol nema nazev");
            info.setText(info.getText()+"Ukol nema nazev\n");
            nazev = false;
        }
        if(!ANJ.isSelected() && !MAT.isSelected() && !CES.isSelected()) {
            System.out.println("Ukol nema predmet");
            info.setText(info.getText()+"Ukol nema predmet\n");
            predmet = false;
        }
        if(!specha.isSelected() && !mamCas.isSelected() && !bezTerminu.isSelected()){
            System.out.println("Ukol nema prioritu");
            info.setText(info.getText()+"Ukol nema prioritu\n");
            priorita = false;
        }
        if (nazev && predmet && priorita) {
            String splnenoS = "";
            String predmet = "";
            String prioritaS = "";

            if (ANJ.isSelected()) {
                predmet = ANJ.getText();
            }else if (MAT.isSelected()) {
                predmet = MAT.getText();
            }else if (CES.isSelected()) {
                predmet = CES.getText();
            }

            if (specha.isSelected()) {
                prioritaS = specha.getText();
            }else if (mamCas.isSelected()) {
                prioritaS = mamCas.getText();
            }else if (bezTerminu.isSelected()) {
                prioritaS = bezTerminu.getText();
            }

            if (checkUkolu.isSelected()) {
                splneno = "Ano";
            }else{
                splneno = "Ne";
            }

            lstUkoluItems.add(new Ukol(nazevUkolu.getText(),predmet, prioritaS,splneno));
            listUkolu.add(new Ukol(nazevUkolu.getText(),predmet, prioritaS,splneno));
            lstUkolu.setItems(lstUkoluItems);
            nazevUkolu.setText("");
            ANJ.setSelected(false);
            MAT.setSelected(false);
            CES.setSelected(false);
            specha.setSelected(false);
            mamCas.setSelected(false);
            bezTerminu.setSelected(false);
            checkUkolu.setSelected(false);}
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
            listUkolu.add(new Ukol(nazevUkolu.getText(),predmet,priorita,splneno));
            lstUkolu.setItems(lstUkoluItems);
            nazevUkolu.setText("");
            ANJ.setSelected(false);
            MAT.setSelected(false);
            CES.setSelected(false);
            specha.setSelected(false);
            mamCas.setSelected(false);
            bezTerminu.setSelected(false);
            checkUkolu.setSelected(false);
        }

    }
    @FXML
    protected void onClick(){
        try{
            uprava.setDisable(false);
            smazani.setDisable(false);
            Ukol u = lstUkoluItems.get(lstUkolu.getSelectionModel().getSelectedIndex());
            lstUkolu.setItems(lstUkoluItems);
            info.setText("Informace:\nÚkol: " + u.getNazevUkolu()+"\n Předmět: "+u.getPredmet()+"\n Priorita: "+u.getPriorita()+"\n Splněno: "+u.getSplneno());
        }catch(IndexOutOfBoundsException e){
            System.out.println("Nemate pridany zadny ukol");
        }
    }
    @FXML
    protected void onUpravitButtonClick(){
        smazani.setDisable(true);
        uprava.setDisable(true);
        odeslani.setDisable(true);
        dokoncit.setDisable(false);
        Ukol u = lstUkoluItems.get(lstUkolu.getSelectionModel().getSelectedIndex());
        nazevUkolu.setText(u.getNazevUkolu());
        ANJ.setSelected(false);
        MAT.setSelected(false);
        CES.setSelected(false);
        specha.setSelected(false);
        mamCas.setSelected(false);
        bezTerminu.setSelected(false);
        checkUkolu.setSelected(false);
    }
    @FXML
    protected void onDokoncitButtonClick(){
        Ukol u = lstUkoluItems.get(lstUkolu.getSelectionModel().getSelectedIndex());
        smazani.setDisable(true);
        uprava.setDisable(true);
        dokoncit.setDisable(true);
        odeslani.setDisable(false);
        if (ANJ.isSelected()) {
            u.setPredmet(ANJ.getText());
        }else if (MAT.isSelected()) {
            u.setPredmet(MAT.getText());
        }else if (CES.isSelected()) {
            u.setPredmet(CES.getText());
        }

        if (specha.isSelected()) {
            u.setPriorita(specha.getText());
        }else if (mamCas.isSelected()) {
            u.setPriorita(mamCas.getText());
        }else if (bezTerminu.isSelected()) {
            u.setPriorita(bezTerminu.getText());
        }

        if (checkUkolu.isSelected()) {
            u.setSplneno("Ano");
        }else{
            u.setSplneno("Ne");
        }
        u.setNazevUkolu(nazevUkolu.getText());
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
    protected void onSmaatButtonClick(){
        odeslani.setDisable(true);
        Ukol u = lstUkoluItems.get(lstUkolu.getSelectionModel().getSelectedIndex());
        lstUkoluItems.remove(u);
        lstUkolu.setItems(lstUkoluItems);
    }
    @FXML
    protected void onUkoncitClick(){
        Platform.exit();
    }
    @FXML
    protected void onVseClick(){
        lstUkoluItems.clear();
        for (Ukol u : listUkolu) {
            lstUkoluItems.add(u);
            lstUkolu.setItems(lstUkoluItems);
        }

    }
    @FXML
    protected void onNedkonceneClick(){
        lstUkoluItems.clear();
        for(Ukol u : listUkolu){
            if (u.getSplneno().equals("Ne")){
                lstUkoluItems.add(u);
            }
        }
        lstUkolu.setItems(lstUkoluItems);
    }
    @FXML
    protected void onDokonceneClick(){
        lstUkolu.getItems().clear();
        for(Ukol u : listUkolu){
            if (u.getSplneno().equals("Ano")){
                lstUkoluItems.add(u);
            }
        }
        lstUkolu.setItems(lstUkoluItems);
    }
    @FXML
    protected void onNapovedaClick(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Napoveda");
        alert.setHeaderText("Napoveda pro spravu uzivatelu");
        alert.setContentText("Pridej a spravuj uzivatele");
        alert.showAndWait();
    }
}
