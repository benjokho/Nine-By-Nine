package nbnhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sun.j3d.utils.scenegraph.io.state.javax.media.j3d.Texture2DState;

public class AssetLoader {

    public static Texture texture;
    public static TextureRegion block1, block2, block3, block4, block5, block6, block7, block8;

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
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
    }

}