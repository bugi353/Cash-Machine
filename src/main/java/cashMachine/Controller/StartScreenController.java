package cashMachine.Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class StartScreenController {

	private CashMachineController CMcontroller;
	
	 @FXML
	    private Pane StartPane;
	 
	 @FXML
	 void initialize()
	 {
		 StartPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
	 }
	 
	 public void setController(CashMachineController CMcontroller)
	 {
			this.CMcontroller = CMcontroller;
	 }
	 
	 public void setConfiguration()
	 {
		 CMcontroller.buttonAccept.setOnAction(e->{CMcontroller.loadLoginScreen();});
	 }
		
}
