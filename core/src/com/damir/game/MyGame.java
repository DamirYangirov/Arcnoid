package com.damir.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends ApplicationAdapter {

	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;

	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(150,180, 10, 15, 8);
		paddle = new Paddle(Gdx.graphics.getWidth()/2-35, 5 ,70,10, 15);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);

		paddle.update();
		shape.end();
	}

	@Override
	public void dispose () {

	}
}
