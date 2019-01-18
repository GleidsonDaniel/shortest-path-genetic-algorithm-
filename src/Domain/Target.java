package Domain;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Target extends Obstacle{

    private Vector2 pos;
    private double w;
    private double h;

    public Target(double x, double y, double w, double h){
        super(x,y,w,h);
        this.w = w;
        this.h = h;
        this.pos = new Vector2(x,y);
    }

    public void draw(GraphicsContext gtx){
        gtx.setFill(Color.BLUE);
        gtx.fillRect(pos.getX()-w/2, pos.getY()-h/2,w,h);
        //gtx.translate(+pos.getX() / 2, +pos.getY() / 2);
    }

    public Vector2 getPos() {
        return pos;
    }
}
