package dl;

import dl.game_world.GameWorld;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("https://www.youtube.com/watch?v=U03XXzcThGU");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dl/META-INF/darkland-spring-context.xml");
        GameWorld gameWorld = applicationContext.getBean(GameWorld.class);

        primaryStage.setScene(gameWorld.gameScene.get());
        primaryStage.setTitle("Darkland");
        primaryStage.show();
    }
}
