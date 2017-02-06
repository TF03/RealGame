package com.eugene.game.objects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.eugene.game.loader.ResourseLoader;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Fly {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private Circle circle;
    private boolean isAlive;

    private float rotation;
    private int width;
    private int height;

    public Fly(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;

        circle = new Circle();
        isAlive = true;

        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void die() {
        isAlive = false;
        velocity.y = 0;
    }

    public boolean isFalling() {
        return velocity.y > 110;
    }

    public boolean notFlap () {
        return velocity.y > 70 || !isAlive;
    }

    public void onClick() {
        if (isAlive) {
            velocity.y = -140;
            ResourseLoader.flap.play();
        }
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

        if (position.y < -13) {
            position.y = -13;
            velocity.y = 0;
        }

        position.add(velocity.cpy().scl(delta));

        circle.set(position.x + 9, position.y + 6, 6.5f);

        if (velocity.y < 0) {
            rotation -= 600 * delta;

            if (rotation < -20) {
                rotation = -20;
            }
        }

        if (isFalling()) {
            rotation += 480 * delta;

            if (rotation > 90) {
                rotation = 90;
            }
        }
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public float getRotation() {
        return rotation;
    }

    public Circle getCircle() {
        return circle;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void cling() {
        acceleration.y = 0;
    }
}
