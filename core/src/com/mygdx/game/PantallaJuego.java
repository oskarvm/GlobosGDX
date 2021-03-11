package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Globo {
    int posX, posY, speed, size;

    public Globo(int posX, int posY, int speed, int size) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.size = size;
    }
}

public class PantallaJuego extends BaseScreen {

    public PantallaJuego(GoblosGDX game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    Texture background_sky, globoRojo, globoVerde, globoAzul, globoAmarillo, globoNaranja, globoLila;
    private int posicionX;
    private int posicionY;
    int numerodeclick;
    BitmapFont bitmapFont;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();

        background_sky = new Texture("sky_background.png");
        globoRojo = new Texture("globo_rojo.png");
        globoVerde = new Texture("globo_verde.png");
        globoAzul = new Texture("globo_azul.png");
        globoAmarillo = new Texture("globo_amarillo.png");
        globoNaranja = new Texture("globo_naranja.png");
        globoLila = new Texture("globo_lila.png");

    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        spriteBatch.draw(background_sky, 0, 0, 640, 480);
        spriteBatch.draw(globoVerde, posicionX, posicionY, 40, 40);

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            numerodeclick++;
        }

        posicionX++;
        bitmapFont.draw(spriteBatch, "clicks" + numerodeclick, 30, 70);
        spriteBatch.end();
    }
}

