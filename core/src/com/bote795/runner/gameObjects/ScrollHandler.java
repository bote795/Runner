package com.bote795.runner.gameObjects;

import com.bote795.runner.GameWorld.GameWorld;

/**
 * Created by HULK on 3/24/2015.
 */
public class ScrollHandler {
    private Floor platform1, platform2, platform3;

    // Capital letters are used by convention when naming constants.
    public static final int SCROLL_SPEED = -59;
    public static final int Platform_GAP = 49;

    private GameWorld gameWorld;
    public ScrollHandler(GameWorld gameWorld,float yPos) {
        this.gameWorld = gameWorld;


        //creating platforms
        platform1 = new Floor(210, 0 , 22, 60, SCROLL_SPEED, yPos);
        platform2 = new Floor(platform1.getTailX() + Platform_GAP, 0 , 22, 70, SCROLL_SPEED, yPos);
        platform3 = new Floor(platform2.getTailX() + Platform_GAP, 0, 22, 60, SCROLL_SPEED, yPos);

    }
}
