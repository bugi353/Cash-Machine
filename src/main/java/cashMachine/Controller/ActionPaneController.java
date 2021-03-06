package cashMachine.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

public class ActionPaneController {
	
	
	private CashMachineController CMcontroller;
	
	@FXML
	Pane actionPane;
	
	@FXML
	void initialize()
	{
		
		actionPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
	}
	
	public void setConfiguration()
	{
		CMcontroller.b1L.setOnAction(e->{CMcontroller.loadDepositScreen();});
		CMcontroller.b2L.setOnAction(e->{CMcontroller.loadWithdrawScreen();});
		CMcontroller.b3L.setOnAction(e->{CMcontroller.loadLastTransactionScreen();});
		CMcontroller.b4L.setOnAction(e->{CMcontroller.loadPinChangeScreen();});
		CMcontroller.b1P.setOnAction(e->{CMcontroller.loadBalanceScreen();});
		CMcontroller.b2P.setOnAction(e->{});
		CMcontroller.b3P.setOnAction(e->{});
		CMcontroller.b4P.setOnAction(e->{CMcontroller.loadFinishScreen();});
		CMcontroller.buttonCancel.setOnAction(e->{});
		CMcontroller.buttonCorrect.setOnAction(e->{});
		CMcontroller.buttonAccept.setOnAction(e->{});
	}
	
	public void setController(CashMachineController CMcontroller)
	{
		this.CMcontroller = CMcontroller;
	}
}
