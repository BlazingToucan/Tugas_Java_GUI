package main;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	BorderPane bp;
	VBox vb,vb2;
	Label randomGeneratorLabel, rewardLabel;
	Button randomButton;
	Spinner<Integer> spinner;
//	ImageView
	BackgroundImage vbg;
	int num;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		vb=new VBox();
		randomGeneratorLabel=new Label("LA05 Gacha Reward");
		randomGeneratorLabel.setFont(new Font(30));
		randomGeneratorLabel.setMaxHeight(50);
		
		
		
		spinner = new Spinner<>();											
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,0);//parameter value = min,max,initial value
		spinner.setValueFactory(valueFactory);
		spinner.editorProperty().get().setAlignment(Pos.CENTER);
//		spinner.setStyle(".spinner .increment-arrow-button .increment-arrow { -fx-padding: 0;} ");
		spinner.getStyleClass().clear();
		
		
		
		randomButton = new Button("GACHAAA!!!!!!");
		randomButton.setMaxHeight(50);
		randomButton.setPrefWidth(200);
		randomButton.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
		randomButton.setTextFill(Color.WHITESMOKE);
		
		rewardLabel = new Label("1.  Nilai UTS += 5\n"
				+ "2.  Nilai UTS+=10\n"
				+ "3.  Nilai UAS+=5\n"
				+ "4.  Nilai UAS+=10\n"
				+ "5.  Nilai Assignment +=5\n"
				+ "6.  Nilai Assignment +=10\n"
				+ "7.  G304\n"
				+ "8.  XTRFY M42\n"
				+ "9.  Raze Viper Ultimate \n"
				+ "10. G773\n");
		rewardLabel.setFont(new Font(20));
		randomGeneratorLabel.setTextFill(Color.WHITESMOKE);
		rewardLabel.setTextFill(Color.WHITESMOKE);
		
		
		vb2=new VBox(spinner,randomButton);
		vb.getChildren().addAll(randomGeneratorLabel,rewardLabel,vb2);
		vb.setCenterShape(true);
		vb.setAlignment(Pos.TOP_CENTER);
		vb2.setAlignment(Pos.CENTER);
		
		
		vb.setMargin(randomGeneratorLabel, new Insets(50,0,100,0));
		vb.setMargin(rewardLabel, new Insets(0,0,100,0));
		vb2.setMargin(spinner, new Insets(0,0,20,0));
		
		
		bp=new BorderPane(vb);
		
		
		Image img = new Image("file:src/assets/space.jpg");
		vbg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		bp.setBackground(new Background(vbg));
		
		Image imgLogo = new Image("file:src/assets/Binus_SOCS.png");		

		randomButton.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				num=(int) ((Math.random()*10)%10+1);
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(num,num);//parameter value = min,max,initial value
				spinner.setValueFactory(valueFactory);
			}
			
		});
		
		randomButton.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				randomButton.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
				randomButton.setTextFill(Color.BLACK);
			}
		});
		
		randomButton.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				randomButton.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
				randomButton.setTextFill(Color.WHITESMOKE);
			}
			
		});
		
		
		Scene sc = new Scene(bp,1080,720);
		
		primaryStage.setTitle("LA05 Gacha Assignment");
		primaryStage.getIcons().add(imgLogo);
		primaryStage.setScene(sc);
		primaryStage.show();
	}

}
