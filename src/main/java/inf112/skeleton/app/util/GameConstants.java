package inf112.skeleton.app.util;

import com.badlogic.gdx.math.Vector2;

/**
 * All constants used in the game
 * */
public class GameConstants {

    public static final String PREFERENCES = "My Preferences";
    public static final String TEXTURE_ATLAS_UI = "zombie.atlas";
    public static final String SKIN_UI = "skin.json";
    public static final String PLACEHOLDER_ATLAS = "uiskin.atlas";
    public static final String PLACEHOLDER_UI = "uiskin.json";

    public static float UI_WIDTH = 860;
    public static float UI_HEIGHT = 640;

    public static float TILE_WIDTH = 60;
    public static float TILE_HEIGHT = 60;

    public static int COLUMN_SIZE = 20;

    public static int MAP_ROWS = 10;
    public static int UI_ROWS_BOTTOM = 2;
    public static int UI_ROWS_TOP = 1;

    public static float SCREEN_HEIGHT = TILE_HEIGHT * (MAP_ROWS + UI_ROWS_BOTTOM + UI_ROWS_TOP);
    public static float SCREEN_WIDTH = TILE_WIDTH * COLUMN_SIZE;

    public static float MAP_HEIGHT = TILE_HEIGHT * MAP_ROWS;

    public static float MAP_WIDTH = TILE_WIDTH * COLUMN_SIZE;


    public static float ENEMY_WIDTH = TILE_WIDTH;
    public static float ENEMY_HEIGHT = TILE_HEIGHT;
    public static String ENEMY_TYPES = "RTQ";

    //REGULAR ZOMBIE VALUES:
    public static int ENEMY_REGULAR_SPEED = (int) TILE_WIDTH;
    public static float ENEMY_REGULAR_START_HP = 25f;
    public static int ENEMY_REGULAR_BOUNTY = 75;

    //TANK ZOMBIE VALUES:
    public static float ENEMY_TANK_SPEED = TILE_WIDTH/2.5f;
    public static float ENEMY_TANK_START_HP = 200f;
    public static int ENEMY_TANK_BOUNTY = 125;

    //QUICK ZOMBIE VALUES:
    public static int ENEMY_QUICK_SPEED = (int)TILE_WIDTH*2;
    public static float ENEMY_QUICK_START_HP = 4f;
    public static int ENEMY_QUICK_BOUNTY = 75;

    public static int START_MONEY = 200;
    public static int REMAINING_HEALTH = 6;
    public static int SCORE_INCREASE = 100;
    public static float TOWER_SIZE = TILE_WIDTH;
    public static float TOWER_RANGE = TILE_WIDTH * 2;
    public static int TOWER_ATTACK_PRICE = 15;
    public static int TOWER_RANGE_PRICE = 15;
    public static int TOWER_SPEED_PRICE = 15;
    public static int TOWER_DAMAGE_GUNNER = 5;
    public static final float BOMBER_EXPLOSION_RADIUS = 60;
    public static final float TOWER_DAMAGE_SNIPER = 15;
    public static final float TOWER_RANGE_SNIPER = 999;
    public static final float TOWER_SPEED_SNIPER = 5;
    public static final int TOWER_PRICE_GUNNER = 100;
    public static final int TOWER_PRICE_BOMBER = 400;
    public static final int TOWER_PRICE_SNIPER = 300;


    public static final float TOWER_DAMAGE_BOMBER = 10;

    public static float BULLET_WIDTH = TILE_WIDTH / 8;
    public static float BULLET_HEIGHT = TILE_HEIGHT / 8;

    public static Vector2 START_POS = new Vector2(1 * TILE_WIDTH, TILE_HEIGHT * (UI_ROWS_BOTTOM - 1));
}
