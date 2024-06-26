package it.aren.graphic.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;

import it.aren.Controller;
import it.aren.Direction;
import it.aren.Entity;
import it.aren.Vector;
import it.aren.core.GameFactory;
import it.aren.graphic.GraphicController;
import it.aren.model.*;
import it.aren.model.game.*;
import it.aren.common.Constant;

/**
 * Class for draw entities with Swing.
 * Implements {@link GraphicController}.
 */
public class GameGraphicController implements Controller<Entity, Object> {

    private static final int FONT_DEFAULT_DIMENSION = 24;
    private Graphics2D g2;
    private ImageObserver io;
    private final PlayerAnimation animation;

     /**
     * Create a SwingGraphic.
     * @param g2 for draw
     * @param io the {@link ImageObserver} to draw
     */
    public GameGraphicController(final Graphics2D g2, final ImageObserver io) {
        this.g2 = g2;
        this.io = io;
        this.animation = new PlayerAnimation();
    }

    public void setG2AndIO(final Graphics2D g2, final ImageObserver io){
        this.g2 = g2;
        this.io = io;
    }

    @Override
    public void update(Entity entity, Object value) {
        if(entity.isDrawable()){
            BufferedImage sprite = null;
            if(entity instanceof Block) {
                sprite = ((Block) entity).getType().getTexture();
            }
            if(entity instanceof GameMap) {
                sprite = ((GameMap) entity).getType().getImage();
            }
            if(entity instanceof GameObject) {
                sprite = ((GameObject) entity).getType().getTexture();
            }
            if(entity instanceof Dialog) {
                this.drawString((Dialog)entity);
            }
            if(entity instanceof Player) {
                final Player tmpPlayer = (Player) entity;
                sprite = tmpPlayer.getVelocity().equals(Direction.NO_DIRECTION.getVector()) ?
                        this.animation.getNextIdle(Direction.valueOfPoint2D(tmpPlayer.getLastDirection()))
                        : this.animation.getNextWalk(Direction.valueOfPoint2D(tmpPlayer.getLastDirection()));
                tmpPlayer.getBackPack().forEach(go -> go.update(GameComponent.GRAPHIC, this));
                this.drawLog(entity.getPosition().toString());
            }
            if(sprite != null){
                this.drawInPosition(entity.getPosition(), sprite);
            }
        }

    }

    private void drawInPosition(final Vector position, final BufferedImage sprite) {
        g2.drawImage(sprite, (int) position.getX(), (int) position.getY(), this.io);
    }

    private void drawLog(final String log){
        this.g2.setColor(Color.white);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(this.getClass()
                    .getResourceAsStream(Constant.FONT_FOLDER + "Minecraft.ttf")));
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            customFont = customFont.deriveFont(Font.PLAIN, FONT_DEFAULT_DIMENSION);
            ge.registerFont(customFont);
            this.g2.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        g2.drawString(log, 20 ,20 );
    }

    private void drawString(final Dialog dialog) {
        final int ratio = GameFactory.loadSettings().scale();
        this.g2.setColor(Color.white);
        this.g2.fillRect((int) dialog.getPosition().getX(), (int) dialog.getPosition().getY(),
                (int) dialog.getHitBox().dimension().getX(), (int) dialog.getHitBox().dimension().getY());
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(this.getClass()
                    .getResourceAsStream(Constant.FONT_FOLDER + "Minecraft.ttf")));
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            customFont = customFont.deriveFont(Font.PLAIN, FONT_DEFAULT_DIMENSION * ratio);
            ge.registerFont(customFont);
            this.g2.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.g2.setColor(Color.black);
        final int lineHeight = this.g2.getFontMetrics().getHeight();
        final int x = (int) dialog.getPosition().getX() + 16 * ratio;
        int y = (int) dialog.getPosition().getY() + 32 * ratio;
        for (final String line : dialog.getText().split("\n")) {
            this.g2.drawString(line, x, y);
            y += lineHeight;
        }
    }
}
