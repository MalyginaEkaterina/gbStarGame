package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 posCur;
    private Vector2 posDest;
    private Float speed = 200.0f;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        posCur = new Vector2(0, 0);
        posDest = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (!posCur.equals(posDest)) {
            Vector2 vPoint = new Vector2(posDest);
            vPoint.sub(posCur);
            Vector2 move = new Vector2(vPoint);
            move.nor().scl(speed * delta);
            if (move.len() >= vPoint.len()) {
                posCur.set(posDest);
            } else {
                posCur.add(move);
            }
        }
        batch.begin();
        batch.draw(img, posCur.x, posCur.y);
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        posDest.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("posDest = " + posDest);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
