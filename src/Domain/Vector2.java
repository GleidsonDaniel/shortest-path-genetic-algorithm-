package Domain;

public class Vector2 {

    private double x,y;

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void random(double amount){
        this.x = Math.random() * (amount * 2) - amount;
        this.y = Math.random() * (amount * 2) - amount;
    }

    public void add(Vector2 v){
        this.x+= v.getX();
        this.y+= v.getY();
    }

    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    public String toString(){
        return String.format("(%.1f, %.1f)",x,y);
    }
}
