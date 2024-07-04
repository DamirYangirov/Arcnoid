package com.damir.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class MyGame extends ApplicationAdapter {

    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;
    Circle circle;
    Rectangle rectangle;
    ArrayList<Block> blocks = new ArrayList<>();

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(150, 180, 10, 5, 5);
        paddle = new Paddle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - 100, 200, 20, 15);

        int blockWidth = 70;
        int blockHeight = 20;

        for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight() - 150; y += blockHeight + 10) {
            for (int x = 5; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        ball.update(paddle, blocks);
        paddle.draw(shape);
        paddle.update();
        for (Block b : blocks) {
            b.draw(shape);
        }
        shape.end();
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}