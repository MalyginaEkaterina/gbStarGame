package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Health extends Sprite {

    private final Rect worldBounds;
    private final Vector2 v0;
    private int hp;

    public Health(TextureRegion region, Rect worldBounds) {
        super(region);
        this.worldBounds = worldBounds;
        v0 = new Vector2();
        setHeightProportion(0.05f);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v0, delta);
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }

    public void set(Vector2 v0, int hp, float x, float y) {
        this.v0.set(v0);
        this.hp = hp;
        pos.set(x, y);
    }

    public int getHp() {
        return hp;
    }
}
