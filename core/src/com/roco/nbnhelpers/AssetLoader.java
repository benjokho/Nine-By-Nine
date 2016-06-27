package com.roco.nbnhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sun.j3d.utils.scenegraph.io.state.javax.media.j3d.Texture2DState;

public class AssetLoader {

    public static Texture texture;
    public static TextureRegion block1, block2, block3, block4, block5, block6, block7, block8, blockSelector;
    public static TextureRegion bigBlock1, bigBlock5;

    public static Sound youWin, youLose, itsATie, objectiveAchieved, congratulations, powerUp;
    public static Sound click1;
    public static Music partySector;
    
    public static BitmapFont font1;
    public static void load() {

        texture = new Texture(Gdx.files.internal("data/block1.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block1 = new TextureRegion(texture);
        block1.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/block2.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block2 = new TextureRegion(texture);
        block2.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/block3.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block3 = new TextureRegion(texture);
        block3.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/block4.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block4 = new TextureRegion(texture);
        block4.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/block5.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block5 = new TextureRegion(texture);
        block5.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/block6.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block6 = new TextureRegion(texture);
        block6.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/block7.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block7 = new TextureRegion(texture);
        block7.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/block8.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        block8 = new TextureRegion(texture);
        block8.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/blockSelector.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        blockSelector = new TextureRegion(texture);
        blockSelector.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/bigblock1.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bigBlock1 = new TextureRegion(texture);
        bigBlock1.flip(false, true);
        
        texture = new Texture(Gdx.files.internal("data/bigblock5.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bigBlock5 = new TextureRegion(texture);
        bigBlock5.flip(false, true);
        
        youWin = Gdx.audio.newSound(Gdx.files.internal("data/you_win.ogg"));
        youLose = Gdx.audio.newSound(Gdx.files.internal("data/you_lose.ogg"));
        itsATie = Gdx.audio.newSound(Gdx.files.internal("data/its_a_tie.ogg"));
        objectiveAchieved = Gdx.audio.newSound(Gdx.files.internal("data/objective_achieved.ogg"));
        congratulations = Gdx.audio.newSound(Gdx.files.internal("data/congratulations.ogg"));
        powerUp = Gdx.audio.newSound(Gdx.files.internal("data/power_up.ogg"));
        click1 = Gdx.audio.newSound(Gdx.files.internal("data/click1.wav"));
        
        partySector = Gdx.audio.newMusic(Gdx.files.internal("data/party_sector.mp3"));
        
        font1 = new BitmapFont(Gdx.files.internal("data/trench.fnt"));
        font1.setScale(1f, -1f);
      
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
        youWin.dispose();
        youLose.dispose();
        itsATie.dispose();
        objectiveAchieved.dispose();
        congratulations.dispose();
        powerUp.dispose();
        click1.dispose();
        partySector.dispose();
        font1.dispose();
    }

}