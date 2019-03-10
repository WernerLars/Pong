import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Controller implements IController {


    View view;
    Canvas canvas;
    static GraphicsContext gc;
    Ball ball;
    Bat left,right;
    boolean playing;

    public Controller(){}

    public void link(View view){
        this.view=view;
        view.addController(this);
        canvas=view.getCanvas();
        gc=view.getGraphicsContext();
        gc.setFill(Color.BLACK);
        ball=new Ball(gc);
        left=new Bat(gc);
        right=new Bat(gc);
        reset();
    }
    public void start(){
        while(playing) {
            if (view.getLeftTextField().getText().equals("10")) {
                view.getTextField().setText("Left Player Wins");
                playing = false;
            } else {
                if (view.getRightTextField().getText().equals("10")) {
                    view.getTextField().setText("Right Player Wins");
                    playing = false;
                }
            }

            view.setRightTextField("10");




        }

    }

    public void reset(){
        remove();
        ball.changeCoordinates(450,300);
        ball.draw();
        left.changeCoordinates(50,200);
        left.draw();
        right.changeCoordinates(920,200);
        right.draw();
        view.getLeftTextField().setText("0");
        view.getRightTextField().setText("0");
        view.getTextField().setText("");
        playing=true;
    }


    public void draw(){
        ball.draw();
        left.draw();
        right.draw();
    }



    public void remove(){
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
    }

    public Bat getLeftBat(){
        return left;
    }
    public Bat getRightBat(){
        return right;
    }







}
