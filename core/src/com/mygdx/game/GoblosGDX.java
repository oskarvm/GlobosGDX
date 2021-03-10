package com.mygdx.game;

import com.badlogic.gdx.*;

public class GoblosGDX extends Game {
	@Override
	public void create() {
		setScreen(new PantallaInicial(this));
	}

	@Override
	public void render() {
		super.render();
	}
}