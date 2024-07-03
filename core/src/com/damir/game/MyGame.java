package com.damir.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends ApplicationAdapter {

	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;

	Circle circle;
	Rectangle rectangle;
	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(150,180, 10, 4, 8);
		paddle = new Paddle(Gdx.graphics.getWidth(), 5 ,70,10, 15);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//state = произошел ли удар
		ball.state = CollisionUtils.overlaps(ball.getCircle(), paddle.getRectangle());
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		ball.update();
		paddle.draw(shape);
		paddle.update();
		shape.end();

	}

	@Override
	public void dispose () {

	}
}
