package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class Logo extends Sprite {

    private static final float V_LEN = 0.005f;
    private Vector2 touch;
    private Vector2 v;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        setHeightProportion(0.25f);
        touch = new Vector2();
        v = new Vector2();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(this.touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (touch.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
        super.draw(batch);
    }
}
