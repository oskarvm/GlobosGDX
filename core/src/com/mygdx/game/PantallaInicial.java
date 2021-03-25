package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaInicial extends BaseScreen {

    public PantallaInicial(GoblosGDX game) {
        super(game);
    }

    Stage stage;
    Texture fondo;
    SpriteBatch spriteBatch;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        fondo = new Texture("fondo_inicial.jpg");

        BaseButton buttonStart = new BaseButton("globo_start_up.png","globo_start_over.png",30,210,128,128, new InputListener() {
         public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
             Gdx.input.setInputProcessor(null);
             setScreen(new PantallaJuego(game));
             return true;
         }
     });

        BaseButton buttonQuit = new BaseButton("globo_quit_up.png","globo_quit_over.png",80,120,128,128, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                System.exit(0);
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage = new Stage());
        stage.addActor(buttonStart);
        stage.addActor(buttonQuit);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(fondo, 0, 0, 640, 480);
        spriteBatch.end();
        stage.act();
        stage.draw();
    }

}
