package com.roco.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.roco.nbnhelpers.AssetLoader;
import com.roco.nbnhelpers.GameInputHandler;
import com.roco.ninebynine.NineByNine;

public class MenuScreen implements Screen {
	private static final float BUTTON_WIDTH = 300f;
	private static final float BUTTON_HEIGHT = 60f;
	private static final float BUTTON_SPACING = 50f;
	
	private NineByNine nbn;
	
	private Skin skin;
	private Stage stage;
	private Table table;
	private TextButton onePlayerButton, twoPlayerButton, instructionsButton;
	private Label titleLabel, madeByLabel;
	
	public MenuScreen(final NineByNine nbn) {
		this.nbn = nbn;
		
		skin = new Skin(Gdx.files.internal("data/skin_ui/uiskin.json"));
		stage = new Stage(new ScreenViewport());
		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center | Align.top);
		
		table.setPosition(0, Gdx.graphics.getHeight());
		
		onePlayerButton = new TextButton("One Player", skin);
		onePlayerButton.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				nbn.setScreen(new GameScreen());	//XXX change with AI			
			}
		});
		
		twoPlayerButton = new TextButton("Two Players", skin);
		twoPlayerButton.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				nbn.setScreen(new GameScreen());				
			}
		});
		
		instructionsButton = new TextButton("Instructions", skin);
		instructionsButton.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//nbn.setScreen(new InstructionsScreen());				
			}
		});
		
		titleLabel = new Label("Nine by Nine", skin);
		madeByLabel = new Label("made by Remtaine", skin);
		
		table.padTop(BUTTON_SPACING);
		table.add(titleLabel);
		
		table.row();
		table.add(onePlayerButton);
		table.row();
		table.row();
		table.add(twoPlayerButton);
		table.padBottom(BUTTON_SPACING);

		/*
		table.row();
		table.add(instructionsButton);
		*/
		
		table.row();
		table.add(madeByLabel);
		
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void show() {

	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    stage.act(delta);
	    stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public NineByNine getGame() {
		return nbn;
	}
}
