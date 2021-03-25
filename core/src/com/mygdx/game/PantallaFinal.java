package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaFinal extends BaseScreen {

int puntuacion;
    public PantallaFinal(GoblosGDX game, int puntuacion) {
        super(game);
        this.puntuacion=puntuacion;
    }

    Stage stage;
    Texture fondo;
    Texture game_over;
    SpriteBatch spriteBatch;
    BitmapFont bitmapFont;
    PantallaJuego pantallaJuego;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();

        fondo = new Texture("fondo_final.png");
        game_over = new Texture("game_over.png");

        BaseButton buttonStart = new BaseButton("globo_return_up.png","globo_return_over.png",30,100,128,128, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.setInputProcessor(null);
                setScreen(new PantallaJuego(game));
                return true;
            }
        });

        BaseButton buttonQuit = new BaseButton("globo_menu_up.png","globo_menu_over.png",80,10,128,128, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.setInputProcessor(null);
                setScreen(new PantallaInicial(game));
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
        bitmapFont.setColor(Color.BLACK);
        bitmapFont.draw(spriteBatch, "Tu puntuación ha sido de " + puntuacion + " globos explotados",8, 30);
        spriteBatch.draw(game_over, 40, 200, 256, 256);
        spriteBatch.end();
        stage.act();
        stage.draw();
    }

}
