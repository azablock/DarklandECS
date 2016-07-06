package dl;

import javafx.application.Application;
import javafx.stage.Stage;

import static dl.game_world.GameWorld.GAME_WORLD;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("https://www.youtube.com/watch?v=U03XXzcThGU");

        primaryStage.setScene(GAME_WORLD.scene);
        primaryStage.show();
    }
}
