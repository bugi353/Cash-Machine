package cashMachine.Controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import cashMachine.dataClasses.AccountData;
import cashMachine.logicClasses.CashOperation;
import cashMachine.logicClasses.DBConfig;
import cashMachine.logicClasses.Login;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class CashMachineController {
	
	private String idNumber;
	
	@FXML
	Button button1;
	
	@FXML
	Button button2;
	
	@FXML
	Button button3;
	
	@FXML
	Button button4;
	
	@FXML
	Button button5;
	
	@FXML
	Button button6;
	
	@FXML
	Button button7;
	
	@FXML
	Button button8;
	
	@FXML
	Button button9;
	
	@FXML
	Button button0;
	
	@FXML
	Button buttonCancel;
	
	@FXML
	Button buttonCorrect;
	
	@FXML
	Button buttonAccept;
	
	@FXML
    Button b1L;

    @FXML
    Button b2L;

    @FXML
    Button b3L;

    @FXML
    Button b4L;
    
    @FXML
    Button b1P;

    @FXML
    Button b2P;

    @FXML
    Button b3P;

    @FXML
    Button b4P;
    
    @FXML
    Pane paneCenter;

    @FXML
    private Pane startScreen;
    
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@FXML
	void initialize()
	{
		setColorB();
		startScreen.setStyle("-fx-background-color: RGB(57, 135, 201)");
		loadStartScreen();
		
	}
	
	void setColorB()
	{
		b1P.setStyle("-fx-color: red");
		b2P.setStyle("-fx-color: red");
		b3P.setStyle("-fx-color: red");
		b4P.setStyle("-fx-color: red");
		b1L.setStyle("-fx-color: red");
		b2L.setStyle("-fx-color: red");
		b3L.setStyle("-fx-color: red");
		b4L.setStyle("-fx-color: red");
	}
	
	public void loadLoginScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/LoginScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		LoginScreenController lSController = loader.getController();
		lSController.setController(this);
		lSController.setConfiguration();
		setScreen(pane);	
	}
	
	public void loadStartScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/StartScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		StartScreenController sSController = loader.getController();
		sSController.setController(this);
		sSController.setConfiguration();
		setScreen(pane);
		
		
	}
	
	public void loadActionScreen() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ActionScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		ActionPaneController aPController = new ActionPaneController();
		aPController.setController(this);
		aPController.setConfiguration();
		setScreen(pane);
	}
	
	public void loadWithdrawScreen() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/WithdrawScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		WithdrawScreenController wSController = new WithdrawScreenController();
		wSController.setController(this);
		wSController.setConfiguration();
		setScreen(pane);
	}
	
	public void loadBalanceScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BalanceScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		BalanceScreenController bSController = loader.getController();
		bSController.setController(this);
		bSController.setConfiguration();
		setScreen(pane);	
	}
	
	public void loadDepositScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DepositScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		DepositScreenController dSController = loader.getController();
		dSController.setController(this);
		dSController.setConfiguration();
		setScreen(pane);	
	}
	
	public void loadFinishScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/FinishScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		FinishScreenController fSController = loader.getController();
		fSController.setController(this);
		fSController.setConfiguration();
		setScreen(pane);
		
		
		this.loadStartScreen();	
	}
	
	public void loadNotEnoughMoneyScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/NotEnoughMoneyScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		NotEnoughMoneyScreenController nEMController = loader.getController();
		nEMController.setController(this);
		nEMController.setConfiguration();
		setScreen(pane);
	}
	
	public void loadLastTransactionScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/LastTransactionScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		LastTransactionScreenController lTSController = loader.getController();
		lTSController.setController(this);
		lTSController.setConfiguration();
		setScreen(pane);	
	}
	
	public void loadPinChangeScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/PinChangeScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		PinChangeScreenController pCController = loader.getController();
		pCController.setController(this);
		pCController.setConfiguration();
		setScreen(pane);	
	}
	
	public void loadWithdrawCountScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/WithdrawCountScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		WithdrawCountScreenController wCController = loader.getController();
		wCController.setController(this);
		wCController.setConfiguration();
		setScreen(pane);	
	}
	
	public void loadErrorScreen() {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ErrorScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		ErrorScreenController eSController = loader.getController();
		eSController.setController(this);
		eSController.setConfiguration();
		setScreen(pane);
		
	}
	
	

	public void setScreen(Pane pane) {
		paneCenter.getChildren().clear();
		paneCenter.getChildren().add(pane);
	}
}
