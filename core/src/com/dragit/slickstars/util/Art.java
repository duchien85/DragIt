package com.dragit.slickstars.util;

import java.io.File;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

import javafx.scene.shape.Rectangle;

public class Art {
	public static final String TEXTURE_PATH = "data/tex";
	
	public static HashMap<String, Texture> textures;
	public static Rectangle leftSide;
	public static Rectangle rightSide;
	
	public static void load() {
		textures = new HashMap<String, Texture>();
		try {
			leftSide = new Rectangle();
			rightSide = new Rectangle();
			
			textures.put("leftBallTexture", loadTexture(TEXTURE_PATH + File.separator + "ball-left.png"));
			textures.put("rightBallTexture", loadTexture(TEXTURE_PATH + File.separator + "ball-right.png"));
			textures.put("upBallTexture", loadTexture(TEXTURE_PATH + File.separator + "ball-up.png"));
			textures.put("downBallTexture", loadTexture(TEXTURE_PATH + File.separator + "ball-down.png"));
			textures.put("lineTexture", loadTexture(TEXTURE_PATH + File.separator + "line.png"));
			
			Logger.log("Art", "textures loaded");
		}
		catch(GdxRuntimeException e) {
			System.err.println("Error loading texture file - " + e.getMessage());
		}
		catch(Exception e) {
			System.err.println("Error loading texture file - " + e);
		}
	}
	
	public static Texture get(String textureName) {
		return textures.get(textureName);
	}
	
	public static Texture loadTexture(String path) {
		 Texture texture = new Texture(Gdx.files.internal(path));
		 return texture;
	}
	
	public static void dispose() {
		for(Texture tex : textures.values()) {
			tex.dispose();
		}
	}
}
