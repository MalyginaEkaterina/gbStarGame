package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.BaseButton;
import ru.geekbrains.screen.GameScreen;

public class NewGameButton extends BaseButton {

    private final GameScreen game;

    public NewGameButton(TextureAtlas atlas, GameScreen game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
        setHeightProportion(0.04f);
        setTop(-0.07f);
        destroy();
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (!isDestroyed()) {
            super.draw(batch);
        }
    }

    @Override
    public void action() {
        game.startNewGame();
    }
}
