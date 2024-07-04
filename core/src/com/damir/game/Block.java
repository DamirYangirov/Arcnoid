package com.damir.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.awt.Shape;

public class Block {
    int x,y, width, height;
    public Block(int x,int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

    public Rectangle getRectangle() {
        return  new Rectangle(x, y, width, height);
    }
}
