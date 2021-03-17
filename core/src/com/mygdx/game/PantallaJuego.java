package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class PantallaJuego extends BaseScreen {

    public PantallaJuego(GoblosGDX game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    Texture background_sky, globoRojo, globoVerde, globoAzul, globoAmarillo, globoNaranja, globoLila;


    int numerodeclick = 0;
    BitmapFont bitmapFont;
    private int fallos = 0;
    List<Globo> listaGlobos = new ArrayList<>();
    float crearGlobo = 2.5f;

    float gameTime;
    float alarmTime;
    float alarmDuration = 1;  // 1 segundo


    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();

        background_sky = new Texture("sky_background.png");
        /*globoRojo = new Texture("globo_rojo.png");
        globoVerde = new Texture("globo_verde.png");
        globoAzul = new Texture("globo_azul.png");
        globoAmarillo = new Texture("globo_amarillo.png");
        globoNaranja = new Texture("globo_naranja.png");
        globoLila = new Texture("globo_lila.png");*/

        listaGlobos = new ArrayList<>();

        listaGlobos.add(new Globo());
        listaGlobos.add(new Globo());
        listaGlobos.add(new Globo());

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(Globo globo: listaGlobos) globo.update(delta);

        spriteBatch.begin();
        spriteBatch.draw(background_sky, 0, 0, 640, 480);
        for(Globo globo: listaGlobos) globo.render(spriteBatch);


        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                numerodeclick++;
        }

        gameTime += delta;

        if(gameTime > alarmTime){
            alarmTime = gameTime + alarmDuration;
            listaGlobos.add(new Globo());
        }

        bitmapFont.draw(spriteBatch, "clicks" + numerodeclick, 30, 70);
        spriteBatch.end();
    }
}

