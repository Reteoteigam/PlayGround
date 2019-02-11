package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.parser.input.ImportUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ImportView implements Initializable {

	@FXML
	private Button IMPORT_BTN_IMPORT;

	@FXML
	private TextArea IMPORT_INPUTFIELD;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void importData(ActionEvent event) {
		String text = IMPORT_INPUTFIELD.getText();
		System.out.println(text);

		ImportUtils.parseRawData(text);

//		//do something long
//		
//		for (int i = 0; i < 10000; i++) {
//			for (int j = 0; j < 10000; j++) {
//				for (int k = 0; k < 10000; k++) {
//					for (int l = 0; l < 10000; l++) {
//						
//					}	
//				}	
//			}	
//		}
	}

}