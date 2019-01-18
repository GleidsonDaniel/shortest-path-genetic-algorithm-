package Engine;

import Domain.Insect;
import Domain.Obstacle;
import Domain.Population;
import Domain.Target;
import GUI.MainScreen;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.List;

public class Logic {

    private final int lifeSpan = 400;
    private final int size = 7_000;

    private MainScreen mainScreen;
    private Population population;
    private Target target;
    private List<Obstacle> obstacles;


    private int counter;

    public Logic(MainScreen mainScreen){
        this.mainScreen = mainScreen;
        this.population = new Population(size, lifeSpan);
        this.target = new Target(1900, MainScreen.height / 2, 50,50);
        this.obstacles = new ArrayList<>();
        obstacles.add(target);
        for(int i = 0; i < 10; i++){
            double x = (Math.random() * MainScreen.width)+ 100;
            double y = Math.random() * MainScreen.height;
            double w = 200;
            double h = Math.random() * 700;
            obstacles.add(new Obstacle(x,y,w,h));
        }

        counter = 0;




    }

    public void update(){

        population.getInsects().forEach(i -> {
            i.update(counter);
            obstacles.forEach(o -> o.checkCollision(i));
        });



        if(counter == lifeSpan-1){
            counter = 0;

            population.evaluate(target);
            Population newPop = new Population(size,lifeSpan,population.selection());
            this.population = newPop;
        }else{
            counter++;

        }

    }

    public void draw(){
        mainScreen.clearScreen();
        population.getInsects().forEach(i ->
        {
            i.draw(mainScreen.getGtx());
            mainScreen.getGtx().setStroke(Color.rgb(0,0,255,.5));
                //mainScreen.getGtx().strokeLine(i.getPos().getX(), i.getPos().getY(), target.getPos().getX(), target.getPos().getY());

        });

        target.draw(mainScreen.getGtx());
        obstacles.forEach(o -> o.draw(mainScreen.getGtx()));

        //draw line to target

    }

}
