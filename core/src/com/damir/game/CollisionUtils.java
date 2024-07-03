package com.damir.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class CollisionUtils {
    public static boolean overlaps (Circle circle, Rectangle rectangle) {
        float closestX = clamp(circle.x, rectangle.x, rectangle.x + rectangle.width);
        float closestY = clamp(circle.y, rectangle.y, rectangle.y + rectangle.height);

    // определяем какая точка ближе к окружности то есть тачало или конец

        float distanceX = (circle.x - closestX);
        float distanceY = (circle.y - closestY);

        float b = circle.radius*circle.radius;

      String str = String.valueOf(distanceX)+" "+ String.valueOf(distanceY)+" "+ String.valueOf(b);
        System.out.println(str);

        return (distanceX*distanceX + distanceY*distanceY)<=(circle.radius*circle.radius);
    }

    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
}
