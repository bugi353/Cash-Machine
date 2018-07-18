package cashMachine.Controller;

import java.math.BigDecimal;

import cashMachine.logicClasses.CashOperation;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class WithdrawScreenController {

	private CashMachineController CMcontroller;
	
	CashOperation cashOperation = CashOperation.createCashOperationSystem();
	
	@FXML
    private Pane withdrawPane;
	
	@FXML
	void initialize() {
		withdrawPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
	}
	
	public void setConfiguration()
	{
		CMcontroller.b1L.setOnAction(e->{
			getCash(50);
		});
		CMcontroller.b2L.setOnAction(e->{
			getCash(100);
		});
		CMcontroller.b3L.setOnAction(e->{
			getCash(200);
		});
		CMcontroller.b4L.setOnAction(e->{
			getCash(500);
		});
		CMcontroller.b1P.setOnAction(e->{
			CMcontroller.loadWithdrawCountScreen();
		});
		CMcontroller.b2P.setOnAction(e->{});
		CMcontroller.b3P.setOnAction(e->{});
		CMcontroller.b4P.setOnAction(e->{
			CMcontroller.loadActionScreen();
		});
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
		String cond;
		cond = cashOperation.getCash(new BigDecimal(val), CMcontroller.getIdNumber());
		if(cond.equals("true")) // tu do poprawy bo operacja wykonuje siê podwójnie
		{
			CMcontroller.loadFinishScreen(); //trzeba obmyœleæ to inaczej ¿eby raz siê wykona³o i coœ zwróci³o
		}
		if(cond.equals("NEM"))
		{
			CMcontroller.loadNotEnoughMoneyScreen();
		}
		else if(cond.equals("false"))
		{
			CMcontroller.loadErrorScreen();
		}
		
	}
}
