package lee.victoria;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Purpose: Recreation of a "Shut the Box" game with JavaFX
 * @author V. Lee
 * @date December 29 2024
 */

public class DriverGUI extends Application {
	
	//initializing dice
	Die d = new Die();
	Die d2 = new Die();
	
	
	int faceValue = 0;//value of di(c)e roll
	int finalScore = 0;//score after counting remaining tiles
	boolean oneDie = false;//if 7, 8, and 9 are down, only roll 1 die



	@Override
	public void start(Stage stage) throws Exception {

		// initializing VBox and heading
		VBox dieHolder = new VBox(10);
		Label title = new Label("Shut the Box");
		dieHolder.getChildren().add(title);
		
		
		// creating 9 numbered tiles for the user to click
		HBox tileBox = new HBox(10);
		Button[] tileBtns = new Button[9];
		//Tile[] tiles = new Tile[9];
		
		for (int i = 0; i < tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i + 1));
			tileBtns[i].setStyle("-fx-background-color:white");
			//tiles[i] = new Tile(i + 1);
			tileBox.getChildren().add(tileBtns[i]);
		}

		// aligning tileBox, adding to VBox
		tileBox.setAlignment(Pos.CENTER);
		dieHolder.getChildren().add(tileBox);

		

		//dice rolling buttons
		
		HBox rollDice = new HBox(10);
		
		Button btnRoll = new Button("ROLL 1 DIE");
		Button rollTwo = new Button("ROLL 2 DICE");
		
		rollDice.getChildren().addAll(rollTwo, btnRoll);
		rollDice.setAlignment(Pos.CENTER);
		
		//dice roll results
		Label result = new Label("ROLL RESULT");
		Label lblValue = new Label(); // output of results
		
		//buttons to submit and end the game
		Button submit = new Button("LOCK IN");
		Button endRound = new Button("END ROUND");
		endRound.setStyle("-fx-focus-color:transparent; -fx-faint-focus-color:transparent");
		Label invalid = new Label("INVALID SUBMISSION, TRY AGAIN OR END THE GAME");
		invalid.setAlignment(Pos.CENTER);
		
		
		//displaying final score
		HBox endScoreBox = new HBox(10);
		Label scoreLabel = new Label("SCORE:");
		Label score = new Label();
		endScoreBox.getChildren().addAll(scoreLabel, score);
		endScoreBox.setAlignment(Pos.CENTER);
		Label gameOver = new Label("GAME OVER - THANKS FOR PLAYING");

		
		//adding all to VBox
		dieHolder.getChildren().addAll(rollDice, result, lblValue, submit, endRound, invalid);
		invalid.setVisible(false);
		dieHolder.setAlignment(Pos.CENTER);
		Scene scene = new Scene(dieHolder, 500, 500);
		stage.setScene(scene);
		stage.show();

		// rolling 1 die
		btnRoll.setDisable(true);
		btnRoll.setOnAction(e -> {
			faceValue = d.roll();
			lblValue.setText(String.valueOf(faceValue));
			btnRoll.setDisable(true);
			submit.setDisable(false);
		});

		// rolling two dice
		rollTwo.setOnAction(e -> {
			faceValue = d.roll() + d2.roll();
			lblValue.setText(String.valueOf(faceValue));
			rollTwo.setDisable(true);
			submit.setDisable(false);
		});

		// when tiles are pressed
		for (Button tile : tileBtns) {
			tile.setOnAction(e -> {
				if (tile.getStyle().equals("-fx-background-color:lightblue")) {
					tile.setStyle("-fx-background-color:white");
				} else if (tile.getStyle().equals("-fx-background-color:white")) {
					tile.setStyle("-fx-background-color:lightblue");
				}
			});
		}
		// when user locks in
		submit.setDisable(true);
		submit.setOnAction(e -> {
			
			//clearing previous dice roll text
			lblValue.setText("");
			
			
			//sum of tiles user has put down
			int userSubmission = 0;
			
			//adding selected tiles to sum
			for (int i = 0; i < tileBtns.length; i++) {
				if (tileBtns[i].getStyle().equals("-fx-background-color:lightblue")) {
					userSubmission += (i + 1);
				}
			}
			//if sum of tiles matches roll value, "put down" tiles and disable those buttons
			if (userSubmission == faceValue) {
				invalid.setVisible(false);
				for (Button tile : tileBtns) {
					if (tile.getStyle().equals("-fx-background-color:lightblue")) {
						tile.setStyle("-fx-background-color:black");
						tile.setDisable(true);
						submit.setDisable(true);

					}
					//if 7, 8 and 9 are down, only allow the user to roll 1 die. otherwise, roll 2 dice
					if (tileBtns[6].getStyle().equals("-fx-background-color:black")
							&& tileBtns[7].getStyle().equals("-fx-background-color:black")
							&& tileBtns[8].getStyle().equals("-fx-background-color:black")) {
						rollTwo.setDisable(true);
						btnRoll.setDisable(false);
					}else {
						rollTwo.setDisable(false);
						btnRoll.setDisable(true);
					}
				}
				
			}else {
				invalid.setVisible(true);
			}
		});

		
		// when user requests to end the round, remove buttons and display final score
		endRound.setOnAction(e -> {
			rollTwo.setDisable(true);
			btnRoll.setDisable(true);
			invalid.setVisible(false);
			for (int i = 0; i < tileBtns.length; i++) {
				if (!tileBtns[i].getStyle().equals("-fx-background-color:black")) {
					finalScore += (i + 1);
				}
			}
			score.setText(String.valueOf(finalScore));
			dieHolder.getChildren().add(gameOver);
			dieHolder.getChildren().add(endScoreBox);
			dieHolder.getChildren().removeAll(btnRoll, rollTwo, submit, endRound);
			
		});

	}


	public static void main(String[] args) {
		launch(args);
	}
}
