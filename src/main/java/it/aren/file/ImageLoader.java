/**
 * 
 */
package it.aren.file;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.aren.common.Constant;

/**
 * The file load for image.
 * Implements {@link FileLoader}
 */
public class ImageLoader implements FileLoader<BufferedImage> {
    
    @Override
    /**
     * {@inheritDoc}
     */
    public BufferedImage loadFile(final String fileName) {
        try {
            return ImageIO.read(ImageLoader.class.getResourceAsStream(Constant.TEXTURES_FOLDER + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static BufferedImage loadImage(final String fileName) {
        final ImageLoader loader = new ImageLoader();
        return loader.loadFile(fileName);
    }
}
