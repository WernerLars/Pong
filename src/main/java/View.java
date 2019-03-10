import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.swing.*;

public class View extends BorderPane {

    IController controller;

    Canvas canvas;

    static GraphicsContext gc;

    Button button;

    public View(){

        canvas=new Canvas();

        canvas.setHeight(400);
        canvas.setWidth(400);

        gc.getCanvas().getGraphicsContext2D();

        setCenter(canvas);

        button=new Button();

        button.setMaxSize(10,10);

        setTop(button);
        button.setOnAction(e-> controller.draw());


    }

    public void addController(IController con){
        this.controller=con;

    }

    public Canvas getCanvas(){
        return canvas;
    }
    public GraphicsContext getGraphicsContext(){
        return gc;
    }

}
