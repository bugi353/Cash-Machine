package cashMachine.Controller;

import java.math.BigDecimal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

public class PinChangeScreenController {
	
	private CashMachineController CMcontroller;
	
	@FXML
    private Pane pinChangePane;

    @FXML
    private PasswordField pinField1;

    @FXML
    private PasswordField pinField2;

    @FXML
    private Label statusLabel;
    
    @FXML
    void initialize()
    {
    	statusLabel.setVisible(false);
    	pinChangePane.setStyle("-fx-background-color: RGB(57, 135, 201)");
    	pinField2.setOnMouseExited(e->{
    		if(pinField2.getLength()>=4)
    		{
    			ChangePINStatus();
    		}
    		
    	});
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
		CMcontroller.b4P.setOnAction(e->{CMcontroller.loadActionScreen();});
		CMcontroller.buttonCancel.setOnAction(e->{});
		CMcontroller.buttonCorrect.setOnAction(e->{});
		CMcontroller.buttonAccept.setOnAction(e->{});
	}
	
	public void setController(CashMachineController CMcontroller)
	{
		this.CMcontroller = CMcontroller;
	}
	
	public void ChangePINStatus()
	{
		String pass1 = pinField1.getText();
		String pass2 = pinField2.getText();
		
		if(pass1.equals(pass2))
		{
			statusLabel.setText("OK");
			statusLabel.setStyle("-fx-background-color: green");
			statusLabel.setVisible(true);
			CMcontroller.b1P.setOnAction(e->{});
		}
		else
		{
			statusLabel.setText("B³¹d");
			statusLabel.setStyle("-fx-background-color: red");
			statusLabel.setVisible(true);
			CMcontroller.b1P.setOnAction(e->{});
		}
	}
}
