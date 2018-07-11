package cashMachine.Controller;

import cashMachine.logicClasses.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginScreenController {
	private String pin;	//zdefiniowaæ pole do pinu które bedzie przechwytywa³o dane z pola tekstowego has³a po wcisniêciu pliku akceptuj
	// muszê równie¿ zdefiniowaæ ¿eby akceptuj wywo³ywa³o t¹ funkcjê tylko gdy wyœwietla siê pane z logowaniem
	private CashMachineController CMcontroller;
	
	@FXML
	Pane loginScreen;
	
	@FXML
	private PasswordField pinField;
	
	@FXML
    private TextField idField;

    @FXML
    private Label badId;

    @FXML
    private Label badPIN;
	
	@FXML
	void initialize()
	{
		loginScreen.setStyle("-fx-background-color: RGB(57, 135, 201)");
		badId.setVisible(false);
		badPIN.setVisible(false);
		badId.setText("Z³y numer ID");
		badPIN.setText("Z³y PIN");	
	}
	
	public void setConfiguration()
	{	
		pinField.setOnMouseClicked(f->{
		CMcontroller.button1.setOnAction(e->{pinField.insertText(pinField.getLength(), "1");});
		CMcontroller.button2.setOnAction(e->{pinField.insertText(pinField.getLength(), "2");});
		CMcontroller.button3.setOnAction(e->{pinField.insertText(pinField.getLength(), "3");});
		CMcontroller.button4.setOnAction(e->{pinField.insertText(pinField.getLength(), "4");});
		CMcontroller.button5.setOnAction(e->{pinField.insertText(pinField.getLength(), "5");});
		CMcontroller.button6.setOnAction(e->{pinField.insertText(pinField.getLength(), "6");});
		CMcontroller.button7.setOnAction(e->{pinField.insertText(pinField.getLength(), "7");});
		CMcontroller.button8.setOnAction(e->{pinField.insertText(pinField.getLength(), "8");});
		CMcontroller.button9.setOnAction(e->{pinField.insertText(pinField.getLength(), "9");});
		CMcontroller.button0.setOnAction(e->{pinField.insertText(pinField.getLength(), "0");});
		CMcontroller.buttonCorrect.setOnAction(e->{pinField.deleteText(pinField.getLength()-1, pinField.getLength());});
		});
		idField.setOnMouseClicked(f->{
		CMcontroller.button1.setOnAction(e->{idField.insertText(idField.getLength(), "1");});
		CMcontroller.button2.setOnAction(e->{idField.insertText(idField.getLength(), "2");});
		CMcontroller.button3.setOnAction(e->{idField.insertText(idField.getLength(), "3");});
		CMcontroller.button4.setOnAction(e->{idField.insertText(idField.getLength(), "4");});
		CMcontroller.button5.setOnAction(e->{idField.insertText(idField.getLength(), "5");});
		CMcontroller.button6.setOnAction(e->{idField.insertText(idField.getLength(), "6");});
		CMcontroller.button7.setOnAction(e->{idField.insertText(idField.getLength(), "7");});
		CMcontroller.button8.setOnAction(e->{idField.insertText(idField.getLength(), "8");});
		CMcontroller.button9.setOnAction(e->{idField.insertText(idField.getLength(), "9");});
		CMcontroller.button0.setOnAction(e->{idField.insertText(idField.getLength(), "0");});
		CMcontroller.buttonCorrect.setOnAction(e->{idField.deleteText(idField.getLength()-1, idField.getLength());});	
		});
		
		CMcontroller.buttonCancel.setOnAction(e->{});
		CMcontroller.buttonAccept.setOnAction(e->{login();});	
	}
	
	public String getPinFieldProperty()
	{
		return pinField.getText();
	}
	
	public String getIdFieldProperty()
	{
		return idField.getText();
	}
	
	public void setController(CashMachineController CMcontroller)
	{
		this.CMcontroller = CMcontroller;
	}
	
	public void login()
	{
		Login login = Login.createLoginSystem();
		String cond = login.login(getIdFieldProperty(), getPinFieldProperty());
		badId.setVisible(false);
		badPIN.setVisible(false);
		
		if(cond.equals("badId"))
		{
			badId.setVisible(true);
		}
		if(cond.equals("badPIN"))
		{
			badPIN.setVisible(true);
		}
		if(cond.equals("OK"))
		{
			CMcontroller.setIdNumber(getIdFieldProperty());
			CMcontroller.loadActionScreen();
		}
	}
}
