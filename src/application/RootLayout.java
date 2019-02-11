package application;

import java.io.IOException;

import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootLayout extends Application {

	@Override
	public void start(Stage primaryStage) {

		BorderPane rootLayout = initRootLayout(primaryStage);
		AnchorPane anchorPane = initImport(rootLayout);
	}

	/**
	 * Initializes the root layout.
	 * 
	 * @return
	 */
	public BorderPane initRootLayout(Stage primaryStage) {
		primaryStage.setTitle("XhodonCalculator");
		BorderPane rootLayout = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootLayout.class.getResource("views/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

		} catch (Exception e) {
			// TODO: handle exception
			// Load root layout from fxml file.
		}

		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		return rootLayout;
	}

	/**
	 * Shows the person overview inside the root layout.
	 * 
	 * @param rootLayout
	 * @return
	 */
	public AnchorPane initImport(BorderPane rootLayout) {
		AnchorPane anchroPane = null;
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootLayout.class.getResource("views/Import.fxml"));
			anchroPane = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(anchroPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return anchroPane;
	}

	public static void main(String[] args) {
		
		launch(args);
	}
}
