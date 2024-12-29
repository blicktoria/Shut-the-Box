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
	Die d = new Die();
	
	Die d2 = new Die();
	int faceValue = 0;
	int finalScore = 0;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		//title page
		VBox dieHolder = new VBox(10);
		Label title = new Label("Shut the Box");
		dieHolder.getChildren().add(title);
		
		
		HBox tileBox = new HBox(10);
		
		Button[] tileBtns = new Button[9];
		
		
		//creating 9 numbered tiles for the user to click
		Tile[] tiles = new Tile[9];
		for (int i = 0 ; i<tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i+1));
			tileBtns[i].setStyle("-fx-background-color:white");
			tiles[i] = new Tile(i+1);
			tileBox.getChildren().add(tileBtns[i]);
		}
		
		
		//aligning tileBox and dieHolder
		tileBox.setAlignment(Pos.CENTER);
		dieHolder.getChildren().add(tileBox);
		
		
		//create buttons
		
		
		
		
		
		//labelling
		Button btnRoll = new Button("ROLL 1 DIE");
		Button rollTwo = new Button("ROLL 2 DICE");
		Label result = new Label("ROLL RESULT");
		Label lblValue = new Label(); // output of results
		
		Button submit = new Button("LOCK IN");
		Button endRound = new Button("END ROUND");
		
		Label scoreLabel = new Label("FINAL SCORE");
		Label score = new Label();
		
		
		
		//vbox
		
		dieHolder.getChildren().addAll(rollTwo, btnRoll, result, lblValue, submit, endRound);
		dieHolder.setAlignment(Pos.CENTER);
	
	
		Scene scene = new Scene(dieHolder, 500, 500);
		
		stage.setScene(scene);
		stage.show();
		
		
		btnRoll.setOnAction(e -> {
			faceValue = d.roll();
			lblValue.setText(String.valueOf(faceValue));
		});
		
		rollTwo.setOnAction(e -> {
			faceValue = d.roll2();
			lblValue.setText(String.valueOf(faceValue));
		});
		
		//when buttons are pressed
		for (Button tile : tileBtns) {
			tile.setOnAction(e -> {
				if (tile.getStyle().equals("-fx-background-color:darkgray")) {
					tile.setStyle("-fx-background-color:white");
				}
				else if (tile.getStyle().equals("-fx-background-color:white")) {
					tile.setStyle("-fx-background-color:darkgray");
				}
			});
		}
		
		submit.setOnAction(e -> {
			int userSubmission = 0;
			
			for (int i = 0; i<tileBtns.length; i++) {
				if (tileBtns[i].getStyle().equals("-fx-background-color:darkgray")) {
					userSubmission += (i+1);
				}
			}
			if (userSubmission == faceValue) {
				for (Button tile : tileBtns) {
					if (tile.getStyle().equals("-fx-background-color:darkgray")) {
						tile.setStyle("-fx-background-color:black");
					}
				}
			}
		});
		
		//when user requests to end the round
		
		endRound.setOnAction(e -> {
			for (int i = 0; i<tileBtns.length; i++) {
				if (!tileBtns[i].getStyle().equals("-fx-background-color:black")) {
					finalScore += (i+1);
				}
			}
			score.setText(String.valueOf(finalScore));
			dieHolder.getChildren().addAll(scoreLabel, score);
			dieHolder.getChildren().removeAll(btnRoll, rollTwo, submit, endRound);
		});
	
	}
	
		
	
	//i dont know how to use github
	//help
	//testing testing 
	//this comment is from december 27 2024, 12:39 PM
	
	public static void main(String[] args) {
		launch(args);
	}
}
