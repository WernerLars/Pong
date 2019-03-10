import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javax.swing.*;

public class View extends BorderPane {

    IController controller;

    Canvas canvas;

    static GraphicsContext gc;

    Button draw,remove;

    HBox box;

    public View(){

        canvas=new Canvas();
        canvas.setHeight(400);
        canvas.setWidth(400);

        gc=canvas.getGraphicsContext2D();

        setCenter(canvas);

        draw=new Button();
        draw.setMaxSize(100,100);
        draw.setText("Draw");

        remove=new Button();
        remove.setMaxSize(100,100);
        remove.setText("Remove");

        box=new HBox(draw,remove);

        setTop(box);


        draw.setOnAction(e-> controller.draw());

        remove.setOnAction(e-> controller.remove());
    }

    public void addController(IController con){
        this.controller=con;

    }

    public Canvas getCanvas() {
        return canvas;
    }
    public GraphicsContext getGraphicsContext(){
        return gc;
    }

}
