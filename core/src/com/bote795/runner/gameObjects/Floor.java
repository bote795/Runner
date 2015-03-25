package com.bote795.runner.gameObjects;

/**
 * Created by HULK on 3/24/2015.
 */
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Floor extends Scrollable {
    private Random r;
    private Rectangle platformArea;

    private float groundY;
    private boolean isScored = false;

    public Floor(float x, float y, int width, int height, float scrollSpeed, float groundY){
        super(x,y, width, height, scrollSpeed);
        r = new Random();
        this.groundY = groundY;
        platformArea = new Rectangle();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        // The set() method allows you to set the top left corner's x, y
        // coordinates,
        // along with the width and height of the rectangle
        platformArea.set(position.x, position.y, width, height);


    }
    @Override
    public void reset(float newX) {
        // Call the reset method in the superclass (Scrollable)
        super.reset(newX);
        // Change the height to a random number
        width = r.nextInt(90) + 15;
        isScored = false;
    }
    public boolean isScored() {
        return isScored;
    }
    public void setScored(boolean b) {
        isScored = b;
    }

    public void onRestart(float x, float scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }
    public boolean collides(Player p) {
        //TODO setup collision to set player to stay up
        if(position.y < p.getX() + p.getWidth())
            return Intersector.overlaps(p.getBoundingCircle(),platformArea);
       return false;
    }
    public Rectangle getPlatformArea(){ return  platformArea; }
}
