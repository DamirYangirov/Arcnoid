package com.damir.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Paddle {
    float x;
    float y;
    float width;
    float height;
    float speedX;
    Rectangle rectangle;



    Paddle(float x, float y, float width, float height, float speedX){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.rectangle =getRectangle();
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    public void update() {
        rightMove();
        leftMove();
        /*mouseMove();*/

    }

    public boolean checkRight() {
        return x + width+2 > Gdx.graphics.getWidth();  // Проверяем, если правый край выходит за границу экрана
    }

    public boolean checkLeft() {
        return x-2 < 0;  // Проверяем, если левый край выходит за границу экрана
    }
    public void rightMove() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (checkRight()) {
                x = Gdx.graphics.getWidth() - width;  // Устанавливаем x так, чтобы правый край был на границе экрана
            } else {
                x += speedX;
            }
        }
    }
    public void leftMove(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (checkLeft()) {
                x = 0;  // Устанавливаем x так, чтобы левый край был на границе экрана
            } else {
                x -= speedX;
            }
        }
    }
    /*public void mouseMove(){
        y =Gdx.graphics.getHeight()-Gdx.input.getY()-height/2;
        x = Gdx.input.getX()-width/2;
    }*/

    public Rectangle getRectangle() {
        return  new Rectangle(x, y, width, height);
    }

}
