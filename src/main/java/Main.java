import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        View view=new View();
        Controller controller=new Controller();

        controller.link(view);

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String s=""+event.getCode();
                if("A".equals(s)){

                    controller.getLeftBat().moveUp();

                }
                if("S".equals(s)){

                    controller.getLeftBat().moveDown();

                }
                if("K".equals(s)){

                    controller.getRightBat().moveUp();

                }
                if("L".equals(s)){

                    controller.getRightBat().moveDown();

                }
            }
        });

    }
}
