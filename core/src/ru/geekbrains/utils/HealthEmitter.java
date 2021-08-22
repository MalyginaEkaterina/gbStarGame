package ru.geekbrains.utils;

import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;
import ru.geekbrains.pool.HealthPool;
import ru.geekbrains.sprite.Health;

public class HealthEmitter {
    private final Rect worldBounds;
    private final HealthPool healthPool;
    private float generateTimer;
    private float generateInterval;

    private final Vector2 v0 = new Vector2(0f, -0.3f);
    private final int hp1 = 5;
    private final int hp2 = 10;
    private final int hp3 = 20;

    public HealthEmitter(Rect worldBounds, HealthPool healthPool) {
        this.worldBounds = worldBounds;
        this.healthPool = healthPool;
        setGenerateInterval();
    }

    public void generate(float delta) {
        generateTimer += delta;
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            setGenerateInterval();
            Health health = healthPool.obtain();
            float type = (float) Math.random();
            int hp;
            if (type < 0.5f) {
                hp = hp1;
            } else if (type < 0.8f) {
                hp = hp2;
            } else {
                hp = hp3;
            }
            health.set(v0,
                    hp,
                    Rnd.nextFloat(worldBounds.getLeft() + health.getHalfWidth(), worldBounds.getRight() - health.getHalfWidth()),
                    worldBounds.getTop());
        }
    }

    private void setGenerateInterval() {
        generateInterval = Rnd.nextFloat(10f, 20f);
    }
}
