package Domain;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Obstacle {

    private Vector2 pos;
    private double width;
    private double height;

    public Obstacle(double x, double y, double width, double height){
        this.pos = new Vector2(x,y);
        this.width = width;
        this.height = height;
    }

    public void draw(GraphicsContext gtx){
        gtx.setFill(Color.WHITE);
        gtx.fillRect(pos.getX(), pos.getY(),width,height);
    }

    public Vector2 getPos() {
        return pos;
    }

    public void checkCollision(Insect insect){
        if(insect.getPos().getY() > pos.getY() && insect.getPos().getY() < pos.getY()+height){
            if(insect.getPos().getX() >= pos.getX() && insect.getPos().getX() <= pos.getX()+width){
                insect.setCollision(true);
                //System.out.println("collision");
            }
        }
    }

}
