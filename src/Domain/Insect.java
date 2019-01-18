package Domain;

import GUI.MainScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Date;

public class Insect {

    private final Vector2 pos;
    private final Vector2 vel;
    private final Vector2 acc;
    private boolean collision = false;

    private DNA dna;

    private double fintess;

    public Insect(int lifeSpan){
        this.pos = new Vector2(10,MainScreen.height / 2);
        this.vel = new Vector2();
        this.acc = new Vector2();
        this.dna = new DNA(lifeSpan);
    }

    public Insect(int lifeSpan, boolean alreadyHasDNA){
        this.pos = new Vector2(10,MainScreen.height / 2);
        this.vel = new Vector2();
        this.acc = new Vector2();
    }



    public void move(Vector2 force){
        acc.add(force);
    }



    public void calculateFitness(Target target) {

            double x1 = pos.getX();
            double x2 = target.getPos().getX();
            double y1 = pos.getY();
            double y2 = target.getPos().getY();

            double distance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));

            this.fintess = 1 / distance;
    }

    public double getFintess() {
        return fintess;
    }

    public void setFintess(double fintess){
        this.fintess = fintess;
    }

    public DNA getDna() {
        return dna;
    }

    public void setDna(DNA dna) {
        this.dna = dna;
    }



    public Vector2 getPos() {
        return pos;
    }

    public Vector2 getAcc() {
        return acc;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void update(int counter){



        if(pos.getX() < 0 || pos.getX() > 1900 || pos.getY() < 0 ||pos.getY() > 1000){
            collision = true;

        }

        if(collision){
            this.vel.set(0,0);
            this.acc.set(0,0);
        }else{
            move(dna.getGenes()[counter]);

            this.vel.add(this.acc);
            this.pos.add(this.vel);
            this.acc.set(0,0);
        }

        counter++;
    }

    public void draw(GraphicsContext gtx){
        gtx.setFill(Color.RED);
        gtx.fillOval(pos.getX(), pos.getY(), 5,5);
    }
}
