
import javafx.scene.canvas.GraphicsContext;

public class Ball {
    private int x,y;
    private int xDirection=1;
    private int yDirection=1;
    private static GraphicsContext gc;


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

    public void move(){
        if(y<=0 || y+40>=600){
            yDirection=yDirection*(-1);
        }

        this.x= x + xDirection;
        this.y= y + yDirection;

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setxDirection(int xDirection){
        this.xDirection=xDirection;
    }

    public int getxDirection(){
        return xDirection;
    }

}
