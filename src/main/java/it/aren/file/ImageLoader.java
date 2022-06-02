/**
 * 
 */
package it.aren.file;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
    
    public static BufferedImage loadImage(final String fileName, final int ratio) {
        final ImageLoader loader = new ImageLoader();
        return loader.transformImage(loader.loadFile(fileName), ratio);
    }
    
    private BufferedImage transformImage(final BufferedImage texture, final int ratio) {
        final int w = texture.getWidth();
        final int h = texture.getHeight();
        BufferedImage scaled = new BufferedImage(w * ratio, h * ratio, BufferedImage.TYPE_INT_ARGB);
        final AffineTransform at = new AffineTransform();
        at.scale(2.0, 2.0);
        final AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        scaled = ato.filter(texture, scaled);        
        return scaled;
    }
}