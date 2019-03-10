import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javax.swing.*;
import javax.xml.soap.Text;

public class View extends BorderPane {

    IController controller;

    Canvas canvas;

    static GraphicsContext gc;

    Button start,reset;

    TextField left,right,text;

    HBox box;

    public View(){

        canvas=new Canvas();
        canvas.setHeight(600);
        canvas.setWidth(1000);

        gc=canvas.getGraphicsContext2D();

        setCenter(canvas);

        start=new Button();
        start.setMaxSize(100,100);
        start.setText("Start");

        reset=new Button();
        reset.setMaxSize(100,100);
        reset.setText("Reset");

        left=new TextField();
        left.setMaxSize(100,100);
        left.setText("0");

        right=new TextField();
        right.setMaxSize(100,100);
        right.setText("0");

        text=new TextField();
        text.setMaxSize(120,100);

        box=new HBox(start,reset,left,right,text);

        setTop(box);


        start.setOnAction(e-> controller.start());

        reset.setOnAction(e-> controller.reset());

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

    public void setLeftTextField(String s){
        left.setText(s);
    }

    public void setRightTextField(String s){
        right.setText(s);
    }
    public void setTextField(String s){
        text.setText(s);
    }

    public TextField getLeftTextField(){
        return left;
    }

    public TextField getRightTextField(){
        return right;
    }

    public TextField getTextField(){
        return text;
    }
}
