import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {
    private int score = 0;
    @Override
    public void start(final Stage stage) {
        // Step 1 & 2
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 3
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 4
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 5-8
        Button dessertButton = new Button("Dessert");
        Button desertButton2 = new Button("Desert");
        Button desertButton3 = new Button("Desert");
        Button desertButton4 = new Button("Desert");
        Button desertButton5 = new Button("Desert");
        Button desertButton6 = new Button("Desert");
        Button desertButton7 = new Button("Desert");
        Button desertButton8 = new Button("Desert");
        
        Button[] buttons = new Button[8];
        Random rnd = new Random();
        buttons[0] = dessertButton; buttons[1] = desertButton2; buttons[2] = desertButton3;
        buttons[3] = desertButton4; buttons[4] = desertButton5; buttons[5] = desertButton6;
        buttons[6] = desertButton7; buttons[7] = desertButton8;
        
        for (int i = 0; i < 8; i++) {
          pane.getChildren().add(buttons[i]);
          if ( i != 0 ) {
            buttons[i].setOnAction( (event) -> {
              score--;
              scoreLabel.setText("Score: " + score);
              randomizeButtonPositions(rnd, buttons);
              exitButton.requestFocus();
            });
          }
        }
        
        dessertButton.setOnAction( (event) -> {
          score++;
          scoreLabel.setText("Score: " + score);
          randomizeButtonPositions(rnd, buttons);
          exitButton.requestFocus();
        });
        exitButton.requestFocus();
        randomizeButtonPositions(rnd, buttons);
        stage.setScene(scene);
        stage.show();
    }
    
    private void randomizeButtonPositions(Random rnd, Button[] buttons) {
        for ( int i = 0; i < 8; i++) {
          int x = rnd.nextInt(600);
          int y = rnd.nextInt(400);
          buttons[i].setLayoutX(x);
          buttons[i].setLayoutY(y);
        }
    }

    public static void main(String[] args) {
        Application.launch();
    }
}




