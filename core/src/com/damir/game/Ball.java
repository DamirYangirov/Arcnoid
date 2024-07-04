package com.damir.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Circle circle;
    Color color = Color.WHITE;
    Boolean state = false;
    Boolean befor = false;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.circle = getCircle();
    }

    public void update(Paddle paddle, ArrayList<Block> blocks) {
        x += xSpeed;
        y += ySpeed;

        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y - size < 0 || y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }

        if (CollisionUtils.overlaps(getCircle(), paddle.getRectangle())) {
            ySpeed = -ySpeed;
        }
        handleBlockCollisions(blocks);
    }

    private void handleBlockCollisions(ArrayList<Block> blocks) {
        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (CollisionUtils.overlaps(getCircle(), block.getRectangle())) {
                ySpeed = -ySpeed;
                iterator.remove();
            }
        }
    }

    public Circle getCircle() {
        return new Circle(x, y, size);
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
        if (state) {
            shape.setColor(1, 0, 0, 1);
        } else {
            shape.setColor(0, 1, 0, 1);
        }
    }
}
