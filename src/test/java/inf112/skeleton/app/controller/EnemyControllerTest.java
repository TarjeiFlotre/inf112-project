package inf112.skeleton.app.controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import inf112.skeleton.app.entity.Enemy;
import inf112.skeleton.app.level.Level;
import inf112.skeleton.app.map.Map;

import inf112.skeleton.app.util.GameAssets;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static inf112.skeleton.app.util.GameConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EnemyControllerTest {

    @Mock
    private Level mockLevel;
    @Mock
    private Map mockMap;
    private EnemyController enemyController;
    private static HeadlessApplication application;

    /**
     * Setup headless application
     * Mock textured classes used in HealthBar. Necessary in order to avoid pixmap errors.
     */
    @BeforeAll
    public static void setupBeforeAll() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        application = new HeadlessApplication(new ApplicationAdapter() {}, config);
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
        when(Gdx.gl.glGenTexture()).thenReturn(1);
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Gdx.gl = mock(GL20.class);
        Gdx.gl20 = Gdx.gl;
        when(Gdx.gl.glGenTexture()).thenReturn(1);

        enemyController = new EnemyController(mockLevel);
    }

    @Test
    void newZombieTest() {
        for (int i = 0; i < 5; i++) {
            enemyController.newZombie(new Enemy(
                    'R',
                    START_POS.x,
                    START_POS.y,
                    ENEMY_WIDTH,
                    ENEMY_HEIGHT,
                    5,
                    mockMap.getDirections(),
                    5,
                    5,
                    5,
                    GameAssets.zombieSprite,
                    false
            ));
        }
        assertEquals(5, enemyController.getEnemyList().size(), "List should contain 5 enemies");
    }

    @Test
    void doubleSpeedClickedTest() {
        Enemy enemy = new Enemy('R', START_POS.x, START_POS.y, ENEMY_WIDTH, ENEMY_HEIGHT,ENEMY_REGULAR_START_HP, new LinkedList<>(), ENEMY_REGULAR_BOUNTY, ENEMY_REGULAR_SPEED, 0, null,
                false);

        enemyController.newZombie(enemy);
        enemyController.doubleSpeedClicked();

        assertTrue(enemy.getDoubleSpeed());
    }

    @Test
    void normalSpeedClickedTest() {
        Enemy enemy = new Enemy('R', START_POS.x, START_POS.y, ENEMY_WIDTH, ENEMY_HEIGHT,ENEMY_REGULAR_START_HP, new LinkedList<>(), ENEMY_REGULAR_BOUNTY, ENEMY_REGULAR_SPEED, 0, null,
                true);

        enemyController.newZombie(enemy);
        enemyController.normalSpeedClicked();

        assertFalse(enemy.getDoubleSpeed());
    }

    @Test
    void checkBoundsForEnemyTest() {
        Enemy enemy1 = new Enemy('R', SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, ENEMY_WIDTH, ENEMY_HEIGHT,ENEMY_REGULAR_START_HP, new LinkedList<>(), ENEMY_REGULAR_BOUNTY, ENEMY_REGULAR_SPEED, 0, null, false);
        enemyController.newZombie(enemy1);
        assertFalse(enemyController.boundsPublic(enemy1));
        enemyController.clearEnemies();

        Enemy enemy2 = new Enemy('R', -20, SCREEN_HEIGHT /2, ENEMY_WIDTH, ENEMY_HEIGHT,ENEMY_REGULAR_START_HP, new LinkedList<>(), ENEMY_REGULAR_BOUNTY, ENEMY_REGULAR_SPEED, 0, null, false);
        enemyController.newZombie(enemy2);
        assertTrue(enemyController.boundsPublic(enemy2));
        enemyController.clearEnemies();

        Enemy enemy3 = new Enemy('R', SCREEN_WIDTH + 20, SCREEN_HEIGHT / 2, ENEMY_WIDTH, ENEMY_HEIGHT,ENEMY_REGULAR_START_HP, new LinkedList<>(), ENEMY_REGULAR_BOUNTY, ENEMY_REGULAR_SPEED, 0, null, false);
        enemyController.newZombie(enemy3);
        assertTrue(enemyController.boundsPublic(enemy3));
        enemyController.clearEnemies();

        Enemy enemy4 = new Enemy('R', SCREEN_WIDTH / 2, SCREEN_HEIGHT + 20, ENEMY_WIDTH, ENEMY_HEIGHT,ENEMY_REGULAR_START_HP, new LinkedList<>(), ENEMY_REGULAR_BOUNTY, ENEMY_REGULAR_SPEED, 0, null, false);
        enemyController.newZombie(enemy4);
        assertTrue(enemyController.boundsPublic(enemy4));
        enemyController.clearEnemies();

        Enemy enemy5 = new Enemy('R', SCREEN_WIDTH / 2, -20, ENEMY_WIDTH, ENEMY_HEIGHT,ENEMY_REGULAR_START_HP, new LinkedList<>(), ENEMY_REGULAR_BOUNTY, ENEMY_REGULAR_SPEED, 0, null, false);
        enemyController.newZombie(enemy5);
        assertTrue(enemyController.boundsPublic(enemy5));
        enemyController.clearEnemies();
    }

    /**
     * Dispose application
     * remove texture mock associations
     */
    @AfterAll
    public static void tearDown() {
        if(application != null) {
            application.exit();
            application = null;
        }
        Gdx.gl = null;
        Gdx.gl20 = null;
    }
}

