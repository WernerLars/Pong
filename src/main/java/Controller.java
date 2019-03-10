import javafx.scene.paint.Color;

public class Controller implements IController {


    View view;

    public Controller(){
    }

    public void link(View view){
        this.view=view;
        view.addController(this);
    }

    public void draw(){
        view.getGraphicsContext().setFill(Color.BLACK);
        view.getGraphicsContext().fillOval(30,30,180,180);


    }
    public void remove(){
        view.getGraphicsContext().clearRect(0,0,view.getCanvas().getHeight(),view.getCanvas().getWidth());
    }
}
