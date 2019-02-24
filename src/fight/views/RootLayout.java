package fight.views;

import fight.views.utils.LayoutBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootLayout extends Application {

  @Override
  public void start(Stage primaryStage) {

    BorderPane rootLayout = initRootLayout(primaryStage);

    initCenter(rootLayout);

  }

  /**
   * Initializes the root layout.
   * 
   * @return
   */
  public BorderPane initRootLayout(Stage primaryStage) {
    primaryStage.setTitle("Xhodon Fight Simulation");
    BorderPane rootLayout = null;
    rootLayout = LayoutBuilder.createLayoutFrom(RootLayout.class, "RootLayout.fxml");
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
  public void initCenter(BorderPane rootLayout) {
    TabPane mainView = LayoutBuilder.createLayoutFrom(RootLayout.class, "MainView.fxml");
    rootLayout.setCenter(mainView);
  }

}
