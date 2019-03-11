import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements IController {


    private View view;
    private Canvas canvas;
    private static GraphicsContext gc;
    private Ball ball;
    private Bat left,right;
    private Timer timer;

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

        timer=new Timer(2,new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                remove();
                ball.move();
                draw();

                if (view.getLeftTextField().getText().equals("10")) {
                    view.getTextField().setText("Left Player Wins");
                    timer.stop();
                } else {
                    if (view.getRightTextField().getText().equals("10")) {
                        view.getTextField().setText("Right Player Wins");
                        timer.stop();
                    }
                }


                if(left.getX()==ball.getX()){

                    if(left.getY()<=ball.getY()){


                        if(left.getY()+180>=ball.getY()) {

                            ball.setxDirection(ball.getxDirection() * (-1));
                        }
                    }
                }


                if(right.getX()-80==ball.getX()-80){

                    if(right.getY()<=ball.getY()){


                        if(right.getY()+180>=ball.getY()) {

                            ball.setxDirection(ball.getxDirection() * (-1));
                        }
                    }
                }



                if(ball.getX()<=0){
                    int rightText=Integer.parseInt(view.getRightTextField().getText())+1;
                    view.setRightTextField(""+rightText);
                    softReset();
                }
                if(ball.getX()+40>=1000){
                    int leftText=Integer.parseInt(view.getLeftTextField().getText())+1;
                    view.setLeftTextField(""+leftText);
                    softReset();
                }





            }

        });

        reset();
    }
    public void start(){
        timer.start();

    }

    public void reset(){
        timer.stop();
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
    }
    public void softReset(){
        remove();
        ball.changeCoordinates(450,300);
        ball.draw();
        left.changeCoordinates(50,200);
        left.draw();
        right.changeCoordinates(920,200);
        right.draw();
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


    public class BallThread implements Runnable{

        public void run(){
                timer.start();
                if (view.getLeftTextField().getText().equals("10")) {
                    view.getTextField().setText("Left Player Wins");
                    timer.stop();
                } else {
                    if (view.getRightTextField().getText().equals("10")) {
                        view.getTextField().setText("Right Player Wins");
                        timer.stop();
                    }
                }
                if(left.getX()==ball.getX()){
                    if(left.getY()>=ball.getY() && left.getY()+180<=ball.getY()){
                        ball.setxDirection(ball.getxDirection()*(-1));
                    }
                }
                if(right.getX()==ball.getX()){
                      if(right.getY()>=ball.getY() && right.getY()+180<=ball.getY()){
                          ball.setxDirection(ball.getxDirection()*(-1));
                      }
                }
                if(ball.getY()<=0){
                     int rightText=Integer.parseInt(view.getRightTextField().getText())+1;
                     view.setRightTextField(""+rightText);
                }
                if(ball.getY()+40>=1000){
                     int leftText=Integer.parseInt(view.getLeftTextField().getText())+1;
                     view.setRightTextField(""+leftText);
                }


        }
    }


}
