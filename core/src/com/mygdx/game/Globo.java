package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

class Globo {

    float gameTime;
    float alarmTime;
    float alarmDuration = 0.5f;
    Texture textura;
    boolean eliminar = false;
    String colorglobo;
    static Texture globoAmarillo = new Texture("globo_amarillo.png");
    static Texture globoAzul = new Texture("globo_azul.png");
    static Texture globoLila = new Texture("globo_lila.png");
    static Texture globoNaranja = new Texture("globo_naranja.png");
    static Texture globoRojo = new Texture("globo_rojo.png");
    static Texture globoVerde = new Texture("globo_verde.png");
    float posX, posY, speedX, speedY, size;


    public Globo(int nivel){
        Random random = new Random();

        int color = random.nextInt(6);
        if (color == 0){
            this.textura = globoAmarillo;
            colorglobo = "Amarillo";
        }else if (color==1){
            this.textura = globoAzul;
            colorglobo = "Azul";
        }else if (color==2){
            this.textura = globoLila;
            colorglobo = "Lila";
        }else if (color==3){
            this.textura = globoNaranja;
            colorglobo = "Naranja";
        }else if (color==4){
            this.textura = globoRojo;
            colorglobo = "Rojo";
        }else {
            this.textura = globoVerde;
            colorglobo = "Verde";
        }

        this.posX = random.nextInt(610)+5;
        this.posY = random.nextInt(10)+5;
        this.speedX = random.nextInt(60)-30;
        this.size =  random.nextInt(20)+50;

        if (nivel > 100){
            this.speedY = random.nextInt(120) + 100;
        }
        else if(nivel > 75){
            this.speedY = random.nextInt(100) + 80;
        }
        else if(nivel > 50){
            this.speedY = random.nextInt(80) + 60;
        }
        else if(nivel > 25){
            this.speedY = random.nextInt(60) + 40;
        }
        else if(nivel > 10){
            this.speedY = random.nextInt(40) + 20;
        }
        else {
            this.speedY = random.nextInt(30) + 10;
        }
    }

    public void update(float delta) {
        Random random = new Random();

        posX += speedX * delta;
        posY += speedY * delta;


        // cuando la alarma suene, poner una speedX random
        gameTime += delta;
        if(gameTime > alarmTime){
            alarmTime = gameTime + alarmDuration;
            speedX = random.nextInt(60)-30;
        }

    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(textura, posX, posY, size , size);
    }


}
