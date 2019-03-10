
import javafx.scene.canvas.GraphicsContext;

public class Bat {
    int x=0;
    int y=0;
    static GraphicsContext gc;


    public Bat(GraphicsContext gc){
        this.gc=gc;
    }

    public void draw(){
        gc.fillRect(x,y,20,180);
    }


    public void changeCoordinates(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void moveDown(){
        if(y+180<=600){
            y=y+15;
        }
    }
    public void moveUp(){
        if(y>=0){
            y=y-15;
        }
    }
}
