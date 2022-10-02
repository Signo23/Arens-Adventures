package it.aren.file;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import it.aren.common.Constant;
import it.aren.model.FileLoader;

/**
 * The file loader for image.
 * Implements {@link FileLoader}
 */
public class ImageLoader implements FileLoader<BufferedImage> {

     /**
     * {@inheritDoc} 
     */
    @Override
    public BufferedImage loadFile(final String fileName) {
        try {
            return this.transformImage(ImageIO.read(Objects.requireNonNull(ImageLoader.class.getResourceAsStream(
                    Constant.TEXTURES_FOLDER + fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BufferedImage transformImage(final BufferedImage texture) {
        final SettingsLoader settingsLoader = new SettingsLoader();
        final int ratio = settingsLoader.loadFile(Constant.SETTINGS_FILE).scale();
        final int w = texture.getWidth();
        final int h = texture.getHeight();
        BufferedImage scaled = new BufferedImage(w * ratio, h * ratio, BufferedImage.TYPE_INT_ARGB);
        final AffineTransform at = new AffineTransform();
        at.scale(ratio, ratio);
        final AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        scaled = ato.filter(texture, scaled);
        return scaled;
    }
}