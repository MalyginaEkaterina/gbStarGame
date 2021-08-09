package ru.geekbrains.sprite;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Spaceship extends Sprite {

    private final Vector2 v;
    private Rect worldBounds;
    private static final float PADDING = 0.05f;
    private static final float V_LEN = 0.5f;
    private int left;
    private int right;

    public Spaceship(TextureAtlas atlas) {
        super(getRegion(atlas));
        v = new Vector2();
    }

    private static TextureRegion getRegion(TextureAtlas atlas) {
        TextureRegion tr = atlas.findRegion("main_ship");
        return tr.split(tr.getRegionWidth() / 2, tr.getRegionHeight())[0][0];
    }

    @Override
    public void update(float delta) {
        v.set(left * (-V_LEN) + right * V_LEN, 0);
        pos.mulAdd(v, delta);
        if (getRight() > worldBounds.getRight()) {
            setRight(worldBounds.getRight());
            v.set(0, 0);
            left = 0;
            right = 0;
        }
        if (getLeft() < worldBounds.getLeft()) {
            setLeft(worldBounds.getLeft());
            v.set(0, 0);
            left = 0;
            right = 0;
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (touch.x >= 0) {
            right = 1;
        } else {
            left = 1;
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        left = 0;
        right = 0;
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            left = 1;
        }
        if (keycode == Input.Keys.RIGHT) {
            right = 1;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            left = 0;
        }
        if (keycode == Input.Keys.RIGHT) {
            right = 0;
        }
        return false;
    }
}
