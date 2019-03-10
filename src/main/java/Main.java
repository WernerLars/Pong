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
                    controller.remove();
                    controller.getLeftBat().moveUp();
                    controller.draw();
                }
                if("S".equals(s)){
                    controller.remove();
                    controller.getLeftBat().moveDown();
                    controller.draw();
                }
                if("K".equals(s)){
                    controller.remove();
                    controller.getRightBat().moveUp();
                    controller.draw();
                }
                if("L".equals(s)){
                    controller.remove();
                    controller.getRightBat().moveDown();
                    controller.draw();
                }
            }
        });

    }
}
