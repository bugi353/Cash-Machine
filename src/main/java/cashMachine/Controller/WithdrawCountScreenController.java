package cashMachine.Controller;

import java.math.BigDecimal;

import cashMachine.logicClasses.CashOperation;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class WithdrawCountScreenController {
	
	private CashMachineController CMcontroller;
	
	CashOperation cashOperation = CashOperation.createCashOperationSystem();
	
	@FXML
    private Pane withdrawCountPane;

    @FXML
    private TextField cashCount;

    @FXML
    void initialize()
    {
    	withdrawCountPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
    }

	public void setConfiguration()
	{
		CMcontroller.b1L.setOnAction(e->{});
		CMcontroller.b2L.setOnAction(e->{});
		CMcontroller.b3L.setOnAction(e->{});
		CMcontroller.b4L.setOnAction(e->{});
		CMcontroller.b1P.setOnAction(e->{getCash(Integer.parseInt(cashCount.getText()));});
		CMcontroller.b2P.setOnAction(e->{});
		CMcontroller.b3P.setOnAction(e->{});
		CMcontroller.b4P.setOnAction(e->{CMcontroller.loadWithdrawScreen();});
		CMcontroller.buttonCancel.setOnAction(e->{});
		CMcontroller.buttonCorrect.setOnAction(e->{});
		CMcontroller.buttonAccept.setOnAction(e->{});
	}
	
	public void setController(CashMachineController CMcontroller)
	{
		this.CMcontroller = CMcontroller;
	}
	
	public void getCash(int val)
	{
		if(cashOperation.getCash(new BigDecimal(val), CMcontroller.getIdNumber()).equals("true"))
		{
			CMcontroller.loadFinishScreen();
		}
		if(cashOperation.getCash(new BigDecimal(val), CMcontroller.getIdNumber()).equals("NEM"))
		{
			CMcontroller.loadNotEnoughMoneyScreen();
		}
		else
		{
			CMcontroller.loadErrorScreen();
		}
	}
}
	
