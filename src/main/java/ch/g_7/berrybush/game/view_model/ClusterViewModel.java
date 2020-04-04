package ch.g_7.berrybush.game.view_model;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.math.Vector2f;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;

public class ClusterViewModel extends BasicViewModel {

    private transient ImageType[] images;
    private transient float clusterDensity;

    private Cluster[] clusters;

    public ClusterViewModel(int id, float clusterDensity, Vector2f scale, ImageType... images) {
        super(id);
        this.images = images;
        this.clusterDensity = clusterDensity;
        this.getTransform().setScale(scale);
        genClusters();
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Cluster cluster : clusters) {
            gc.drawImage(cluster.image.getImage(), cluster.position.x, cluster.position.y);
        }
    }

    private void genClusters() {
        int scaleX = (int) getTransform().getScale().x;
        int scaleY = (int) getTransform().getScale().y;
        int clusterCount = (int) (scaleX*scaleY*clusterDensity);

        clusters = new Cluster[clusterCount];

        for (int i = 0; i < clusterCount; i++) {
            Vector2f pos = Util.randomPosition(0, scaleX, 0, scaleY);
            clusters[i] = new Cluster(Util.randomFormList(images), pos);
        }
    }

    public void setImages(ImageType[] images) {
        this.images = images;
        genClusters();
    }


    private int delta;
    public void setClusterDensity(float clusterDensity) {
        int scaleX = (int) getTransform().getScale().x;
        int scaleY = (int) getTransform().getScale().y;

        delta += Math.abs(this.clusterDensity - clusterDensity);
        this.clusterDensity = clusterDensity;

        if(delta > 1/(scaleX*scaleY)){
            genClusters();
            delta = 0;
        }
    }

    public float getClusterDensity() {
        return clusterDensity;
    }

    private static class Cluster implements Serializable{
        private ImageType image;
        private Vector2f position;

        public Cluster(ImageType image, Vector2f position) {
            this.image = image;
            this.position = position;
        }
    }
}
