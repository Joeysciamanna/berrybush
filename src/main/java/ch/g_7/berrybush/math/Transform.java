package ch.g_7.berrybush.math;

public class Transform {

    private Vector2f position;
    private Vector2f scale;
    private double rotation;


    public Transform(Vector2f position, Vector2f scale) {
        this.position = position;
        this.scale = scale;
    }

    public Transform() {
        this.position = new Vector2f();
        this.scale = new Vector2f();
    }

    public void translate(Vector2f translation){
        position.add(translation);
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Vector2f getScale() {
        return scale;
    }

    public void setScale(Vector2f scale) {
        this.scale = scale;
    }
}
