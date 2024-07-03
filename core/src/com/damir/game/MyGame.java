package com.damir.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class MyGame extends ApplicationAdapter {

    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;

    Circle circle;
    Rectangle rectangle;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(150, 180, 10, 4, 8);
        paddle = new Paddle(Gdx.graphics.getWidth()/2, 150, 150, 40, 15);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //state = произошел ли удар
        ball.state = CollisionUtils.overlaps(ball.getCircle(), paddle.getRectangle());
        shape.begin(ShapeRenderer.ShapeType.Filled);
        if(ball.state){
            ball.xSpeed = -ball.xSpeed;
            ball.ySpeed = -ball.ySpeed;
            ball.state = false;
        }

        checkCollision(ball.x, ball.y, paddle.getRectangle());
        ball.draw(shape);
        ball.update();
        paddle.draw(shape);
        paddle.update();
        shape.end();


    }

    public void checkCollision(float xBall, float yBall, Rectangle rectangle) {
       /* //if ((xBall > rectangle.x && xBall < rectangle.x + rectangle.width) && (yBall> rectangle.y && yBall < rectangle.height)) {
        if ((xBall >= rectangle.x && xBall <= rectangle.x + rectangle.width) && (yBall>= rectangle.y && yBall <= rectangle.height)) {
            ball.xSpeed = -ball.xSpeed;
            ball.ySpeed = -ball.ySpeed;
            System.out.println("left");
        }*/
    }


    @Override
    public void dispose() {

    }
}
