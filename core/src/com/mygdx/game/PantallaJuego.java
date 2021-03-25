package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PantallaJuego extends BaseScreen {

    public PantallaJuego(GoblosGDX game) {
        super(game);
    }
    SpriteBatch spriteBatch;
    Texture background_sky;
    int contador = 0;
    BitmapFont bitmapFont;
    private int fallos = 0;
    List<Globo> listaGlobos = new ArrayList<>();
    float gameTime;
    float alarmTime;
    float alarmDuration = 1;
    float gameColor;
    float alarmColor;
    float alarmDurationColor = 8;
    String colorTexto;
    Color colorelegido;


    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();

        background_sky = new Texture("fondo_juego.png");

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(Globo globo: listaGlobos) globo.update(delta);

        spriteBatch.begin();
        spriteBatch.draw(background_sky, 0, 0, 640, 480);
        for(Globo globo: listaGlobos) globo.render(spriteBatch);

        //CHECK IF IS PRESSED ONE BALL
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            int mx = Gdx.input.getX();
            int my = Gdx.graphics.getHeight() - Gdx.input.getY();
            for(Globo globo: listaGlobos){
                if (globo.posX <= mx && globo.posX + globo.size >= mx && globo.posY <= my && globo.posY + globo.size >= my){
                    globo.eliminar = true;

                        if(globo.colorglobo.equals(colorTexto)) {
                            contador++;
                        } else {
                            fallos++;
                        }

                    }
                break;
                }

        }
        listaGlobos.removeIf(globito -> globito.eliminar);

        gameTime += delta;
        gameColor += delta;

        if(gameColor > alarmColor){
            cambioColor();
            cambioColorTexto();
            alarmColor = gameColor + alarmDurationColor;
            if (contador > 100){
                alarmDurationColor = 3;
            }
            else if(contador > 75){
                alarmDurationColor = 4;
            }
            else if(contador > 50){
                alarmDurationColor = 5;
            }
            else if(contador > 25){
                alarmDurationColor = 6;
            }
            else if(contador > 10){
                alarmDurationColor = 7;
            }
            else {
                alarmDurationColor = 8;
            }
        }

        if(gameTime > alarmTime){
            alarmTime = gameTime + alarmDuration;
            listaGlobos.add(new Globo(contador));
            if (contador > 100){
                alarmDuration = 0.5f;
            }
            else if(contador > 75){
                alarmDuration = 0.6f;
            }
            else if(contador > 50){
                alarmDuration = 0.7f;
            }
            else if(contador > 25){
                alarmDuration = 0.8f;
            }
            else if(contador > 10){
                alarmDuration = 0.9f;
            }
            else {
                alarmDuration = 1;
            }
        }

        if(gameTime > alarmTime){
            alarmTime = gameTime + alarmDuration;
            if (contador > 100){
                alarmDuration = 0.5f;
            }
            else if(contador > 75){
                alarmDuration = 0.6f;
            }
            else if(contador > 50){
                alarmDuration = 0.7f;
            }
            else if(contador > 25){
                alarmDuration = 0.8f;
            }
            else if(contador > 10){
                alarmDuration = 0.9f;
            }
            else {
                alarmDuration = 1;
            }
        }

        if(fallos == 5){
            setScreen(new PantallaFinal(game, contador));
        }

        bitmapFont.setColor(Color.BLACK);
        bitmapFont.draw(spriteBatch, "Puntos: " + contador, 8, 30);
        bitmapFont.draw(spriteBatch, "Fallos: " + fallos, 350, 30);

        bitmapFont.setColor(colorelegido);
        bitmapFont.draw(spriteBatch, "Color: " + colorTexto, 545, 30);
        spriteBatch.end();
    }

    public void cambioColor(){
        Random random = new Random();

        int color = random.nextInt(6);
        if (color == 0){
            colorTexto = "Amarillo";
        }else if (color==1){
            colorTexto = "Azul";
        }else if (color==2){
            colorTexto = "Lila";
        }else if (color==3){
            colorTexto = "Naranja";
        }else if (color==4){
            colorTexto = "Rojo";
        }else {
            colorTexto = "Verde";
        }
    }

    public void cambioColorTexto(){
        Random random = new Random();

        int color = random.nextInt(6);
        if (color == 0){
            colorelegido=Color.YELLOW;
        }else if (color==1){
            colorelegido=Color.BLUE;
        }else if (color==2){
            colorelegido=Color.PURPLE;
        }else if (color==3){
            colorelegido=Color.ORANGE;
        }else if (color==4){
            colorelegido=Color.RED;
        }else {
            colorelegido=Color.GREEN;
        }
    }

}


