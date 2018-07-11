package cashMachine.Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ErrorScreenController {
	
	private CashMachineController CMcontroller;
	
	@FXML
    private Pane errorPane;
	
	@FXML
	void initialize()
	{
		errorPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
	}
	
	public void setConfiguration()
	{
		CMcontroller.b1L.setOnAction(e->{});
		CMcontroller.b2L.setOnAction(e->{});
		CMcontroller.b3L.setOnAction(e->{});
		CMcontroller.b4L.setOnAction(e->{});
		CMcontroller.b1P.setOnAction(e->{});
		CMcontroller.b2P.setOnAction(e->{});
		CMcontroller.b3P.setOnAction(e->{});
		CMcontroller.b4P.setOnAction(e->{});
		CMcontroller.buttonCancel.setOnAction(e->{});
		CMcontroller.buttonCorrect.setOnAction(e->{});
		CMcontroller.buttonAccept.setOnAction(e->{});
	}
	
	public void setController(CashMachineController CMcontroller)
	{
		this.CMcontroller = CMcontroller;
	}

}
