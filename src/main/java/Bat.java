
import javafx.scene.canvas.GraphicsContext;

public class Bat {
    private int x=0;
    private int y=0;
    private static GraphicsContext gc;


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
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
