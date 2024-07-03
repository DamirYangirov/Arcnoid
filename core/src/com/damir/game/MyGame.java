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
        ball = new Ball(150, 180, 20, 4, 8);
        paddle = new Paddle(Gdx.graphics.getWidth()/2, 15, 150, 90, 15);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //state = произошел ли удар
        ball.state = CollisionUtils.overlaps(ball.getCircle(), paddle.getRectangle());
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        ball.update();
        paddle.draw(shape);
        paddle.update();
        shape.end();
        checkCollision(ball.x, ball.y, paddle.getRectangle());

    }

    public void checkCollision(float xBall, float yBall, Rectangle rectangle) {
        //if ((xBall > rectangle.x && xBall < rectangle.x + rectangle.width) && (yBall> rectangle.y && yBall < rectangle.height)) {
        if ((xBall+ ball.size >= rectangle.x && xBall+ ball.size <= rectangle.x + rectangle.width) && (yBall+ball.size>= rectangle.y && yBall+ball.size <= rectangle.height)) {
            ball.xSpeed = -ball.xSpeed;
            ball.ySpeed = -ball.ySpeed;
            System.out.println("left");
        }
    }


    @Override
    public void dispose() {

    }
}
