package cashMachine.application;

import cashMachine.Controller.CashMachineController;
import cashMachine.logicClasses.Login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/fxml/CashMachinePanel.fxml"));
		StackPane stackPane = loader.load();
		CashMachineController controller = loader.getController();
		
		
		Login log = new Login();
		
		Scene scene = new Scene(stackPane);
		
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		
		stage.setResizable(false);
		stage.show();
		
		
		
	}

}
