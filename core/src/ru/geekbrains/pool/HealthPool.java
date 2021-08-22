package ru.geekbrains.pool;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Health;

public class HealthPool extends SpritesPool<Health> {

    private final Rect worldBounds;
    private final TextureRegion region;

    public HealthPool(Rect worldBounds, TextureRegion region) {
        this.worldBounds = worldBounds;
        this.region = region;
    }

    @Override
    protected Health newSprite() {
        return new Health(region, worldBounds);
    }
}
