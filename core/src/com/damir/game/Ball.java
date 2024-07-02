package com.damir.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.Color;
import java.awt.Shape;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;

    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        /*x += xSpeed;
        y += ySpeed;
        if (x-size < 0 || x+size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y-size < 0 || y+size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }*/
    }
    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)){
            color = Color.GREEN;
        }
        else{
            color = Color.WHITE;
        }
    }
    private boolean collidesWith(Paddle paddle) {
        return Math.random()>.5;
    }


    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }


}
