package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class BaseButton extends ImageButton {
    public BaseButton(ImageButtonStyle style) {
        super(style);
    }

    public BaseButton(String image_up, String image_over, int x, int y, int w, int h, InputListener inputListener) {
        super(new ImageButton.ImageButtonStyle());

        getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture(image_up)));
        getStyle().over = new TextureRegionDrawable(new TextureRegion(new Texture(image_over)));
        setPosition(x, y);
        setSize(w, h);
        addListener(inputListener);

    }
}
