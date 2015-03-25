package com.bote795.runner.gameObjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;


/**
 * Created by HULK on 3/24/2015.
 */
public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;
    private boolean isAlive;
    private boolean isJumping;

    //collision
    private Circle boundingCircle;
    public Player(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(460, 0);
        boundingCircle = new Circle();
        isAlive = true;
        isJumping = false;
    }
    public void update(float delta){

    }


    public void onRestart(int y) {
        position.y = y;
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 460;
        acceleration.y = 0;
        isAlive = true;
    }
    public void die() {
        isAlive = false;
        velocity.y = 0;
    }
    public void onClick() {
        if (isAlive && !isJumping) {
           //insert jump animation
            velocity.y = 140;
        }
    }
    public void decelerate() {
        // We want the player to stop accelerating downwards once it is dead.
        acceleration.y = 0;
    }
    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }



    public Circle getBoundingCircle() {
        return boundingCircle;
    }

}
