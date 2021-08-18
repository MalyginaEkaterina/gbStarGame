package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.Sprite;

public class GameOver extends Sprite {

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(0.05f);
        destroy();
    }


    @Override
    public void draw(SpriteBatch batch) {
        if (!isDestroyed()) {
            super.draw(batch);
        }
    }
}
