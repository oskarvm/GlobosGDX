package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaInicial extends BaseScreen {


    public PantallaInicial(GoblosGDX game) {
        super(game);
    }

    Stage stage;

    @Override
    public void show() {
     BaseButton buttonStart = new BaseButton("button_start_up.png","button_start_over.png",280,200,24*3,10*3, new InputListener() {
         public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
             setScreen(new PantallaJuego(game));
             return true;
         }
     });

        BaseButton buttonQuit = new BaseButton("button_quit_up.png","button_quit_over.png",280,160,24*3,10*3, new InputListener() {
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

        stage.act();
        stage.draw();
    }

}
