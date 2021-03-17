package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

class Globo {
    Texture textura;

    static Texture globoAmarillo = new Texture("globo_amarillo.png");
    static Texture globoAzul = new Texture("globo_azul.png");
    static Texture globoLila = new Texture("globo_lila.png");
    static Texture globoNaranja = new Texture("globo_naranja.png");
    static Texture globoRojo = new Texture("globo_rojo.png");
    static Texture globoVerde = new Texture("globo_verde.png");
    float posX, posY, speedX, speedY, size;

    public Globo(){
        Random random = new Random();

        int color = random.nextInt(6);
        System.out.println(color);
        if (color == 0){
            this.textura = globoAmarillo;
        }else if (color==1){
            this.textura = globoAzul;
        }else if (color==2){
            this.textura = globoLila;
        }else if (color==3){
            this.textura = globoNaranja;
        }else if (color==4){
            this.textura = globoRojo;
        }else if (color==5){
            this.textura = globoVerde;
        }

        this.posX = random.nextInt(610)+5;
        this.posY = random.nextInt(10)+5;
        this.speedX = 10f;
        this.speedY = random.nextInt(30)+10;
        this.size =  random.nextInt(20)+50;
    }

    public void update(float delta) {

        posX += speedX * delta;
        posY += speedY * delta;

        for(int i = 0; i < 3; i++) {
            speedX -= 10f;
        }
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(textura, posX, posY, size , size);
    }

}
