
import javafx.scene.canvas.GraphicsContext;

public class Ball {
    int x=0;
    int y=0;
    static GraphicsContext gc;


    public Ball(GraphicsContext gc){
        this.gc=gc;
    }

    public void draw(){
        gc.fillOval(x,y,40,40);
    }
    public void changeCoordinates(int x,int y){
        this.x=x;
        this.y=y;
    }

}
