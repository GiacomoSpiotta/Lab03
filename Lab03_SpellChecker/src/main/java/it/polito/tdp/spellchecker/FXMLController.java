package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	Dictionary dizionario = new Dictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combobox;

    @FXML
    private TextArea txtarea1;

    @FXML
    private TextArea txtarea2;

    @FXML
    private Label numeroErrori;

    @FXML
    void DoChoice(ActionEvent event) {
    	String language = combobox.getSelectionModel().getSelectedItem().toString();
    	dizionario.loadDictionary(language);
    }

    @FXML
    void DoSpellCheck(ActionEvent event) {
    	int numErrori = 0;
    	String testo = txtarea1.getText().toLowerCase();
    	String error = "";
    	List<String> word = new LinkedList<>();
    	List <RichWord> RichWord = new LinkedList<>();
    	testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_()\\[\\]\"]", " ");
    	String[] s = testo.split(" ");
    	for(String si : s) {
    		word.add(si);
    	}
    	RichWord = dizionario.spellCheckTest(word);
    	
    	for(RichWord rwi : RichWord) {
    		if(!rwi.isCorrect) {
    			error += rwi.getWord()+"\n";
    			numErrori++;
    		}
    	}
    	
    	txtarea2.setText(error);
    	this.numeroErrori.setText("ERRORI TOTALI: "+numErrori);
    	
    }

    @FXML
    void doClear(ActionEvent event) {
    	txtarea1.clear();
    	txtarea2.clear();
    }

    @FXML
    void initialize() {
        assert combobox != null : "fx:id=\"combobox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtarea1 != null : "fx:id=\"txtarea1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtarea2 != null : "fx:id=\"txtarea2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert numeroErrori != null : "fx:id=\"numeroErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        ObservableList <String> language = FXCollections.observableArrayList("English" , "Italiano");
        combobox.setItems(language);

    }
}
