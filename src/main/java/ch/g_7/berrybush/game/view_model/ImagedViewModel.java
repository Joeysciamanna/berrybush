package ch.g_7.berrybush.game.view_model;

import ch.g_7.berrybush.main.Resource;
import ch.g_7.berrybush.math.Vector2f;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ImagedViewModel extends BasicViewModel {

    private ImageType imageType;

    public ImagedViewModel(Vector2f position, ImageType imageType) {
        super(position, new Vector2f((float) imageType.getImage().getWidth(), (float) imageType.getImage().getHeight()));
        this.imageType = imageType;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(imageType.getImage(), 0, 0, getTransform().getScale().x, getTransform().getScale().y);
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
        getTransform().setScale(new Vector2f((float) imageType.getImage().getWidth(), (float) imageType.getImage().getHeight()));
    }


}
