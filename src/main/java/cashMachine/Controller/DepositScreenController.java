package cashMachine.Controller;

import java.math.BigDecimal;

import cashMachine.logicClasses.CashOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class DepositScreenController {
	
	private CashMachineController CMcontroller;
	
	CashOperation cashOperation = CashOperation.createCashOperationSystem();
	
	@FXML
    private Pane depositPane;

    @FXML
    private TextField depositField;
    
    @FXML
    private Label errorLabel;
	
	@FXML
	void initialize()
	{
		depositPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
		errorLabel.setVisible(false);
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
		CMcontroller.buttonAccept.setOnAction(e->{putInCash();});
		
		CMcontroller.button1.setOnAction(e->{depositField.insertText(depositField.getLength(), "1");});
		CMcontroller.button2.setOnAction(e->{depositField.insertText(depositField.getLength(), "2");});
		CMcontroller.button3.setOnAction(e->{depositField.insertText(depositField.getLength(), "3");});
		CMcontroller.button4.setOnAction(e->{depositField.insertText(depositField.getLength(), "4");});
		CMcontroller.button5.setOnAction(e->{depositField.insertText(depositField.getLength(), "5");});
		CMcontroller.button6.setOnAction(e->{depositField.insertText(depositField.getLength(), "6");});
		CMcontroller.button7.setOnAction(e->{depositField.insertText(depositField.getLength(), "7");});
		CMcontroller.button8.setOnAction(e->{depositField.insertText(depositField.getLength(), "8");});
		CMcontroller.button9.setOnAction(e->{depositField.insertText(depositField.getLength(), "9");});
		CMcontroller.button0.setOnAction(e->{depositField.insertText(depositField.getLength(), "0");});
		CMcontroller.buttonCorrect.setOnAction(e->{depositField.deleteText(depositField.getLength()-1, depositField.getLength());});
	}
	
	public void setController(CashMachineController CMcontroller)
	{
		this.CMcontroller = CMcontroller;
	}
	
	public String getDepositFieldProperty()
	{
		return depositField.getText();
	}
	
	public void putInCash()
	{
		errorLabel.setVisible(false);
		int cash = Integer.parseInt(depositField.getText());
		BigDecimal value = new BigDecimal(cash);
		if(cash>0)	
		{
			if(cashOperation.putInCash(value, CMcontroller.getIdNumber()))
			{
				CMcontroller.loadFinishScreen();
			}
			else
			{
				CMcontroller.loadErrorScreen();
			}
			
		}
		else
		{
			errorLabel.setVisible(true);
			depositField.clear();
		}
	}
	
	

}
