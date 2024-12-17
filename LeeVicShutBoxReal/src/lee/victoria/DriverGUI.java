package lee.victoria;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DriverGUI extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		//title page
		VBox dieHolder = new VBox();
		Label title = new Label("Shut the Box");
		dieHolder.getChildren().add(title);
		
		
		HBox tileBox = new HBox(10);
		
		Button[] tileBtns = new Button[9];
		
		
		//creating 9 numbered tiles for the user to click
		Tile[] tiles = new Tile[9];
		for (int i = 0 ; i<tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i+1));
			tiles[i] = new Tile(i+1);
			tileBox.getChildren().add(tileBtns[i]);
		}
		
		
		//aligning tileBox and dieHolder
		tileBox.setAlignment(Pos.CENTER);
		dieHolder.getChildren().add(tileBox);
		
		
		//create buttons
		Button rollTwo = new Button("ROLL 2 DICE");
		
		
		//labelling
		Button btnRoll = new Button("ROLL DICE");
		Label result = new Label("Result");
		Label lblValue = new Label(); // output of results
		
		Die d = new Die();
		
		Die d2 = new Die();
		//vbox
		
		dieHolder.getChildren().addAll(rollTwo, btnRoll, result, lblValue);
		dieHolder.setAlignment(Pos.CENTER);
	
	
		Scene scene = new Scene(dieHolder, 500, 500);
		
		stage.setScene(scene);
		stage.show();
		
		//btnRoll.setOnAction(e -> lblValue.setText(String.valueOf(d.roll())));
		btnRoll.setOnAction(e -> {
			int faceValue = d.roll();
			lblValue.setText(String.valueOf(faceValue));
		});
		
		rollTwo.setOnAction(e -> {
			int faceValue = d.roll2();
			lblValue.setText(String.valueOf(faceValue));
		});
	
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
