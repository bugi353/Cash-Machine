package cashMachine.Controller;

import java.math.BigDecimal;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class FinishScreenController {
	
	private CashMachineController CMcontroller;
	
	@FXML
    private Pane finishPane;
	
	@FXML
	void initialize()
	{
		finishPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
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
