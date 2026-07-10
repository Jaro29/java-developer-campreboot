package pl.coderslab.advanced.abstractclass;

public class Train extends Vehicle{

    int trackWidth;

    public int getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(int trackWidth) {
        this.trackWidth = trackWidth;
    }

    public Train(Integer maxSpeed, String model, int trackWidth) {
        super(maxSpeed, model);
        this.trackWidth = trackWidth;
    }

    @Override
    public String getSound() {
        return "CiufCiuf";
    }

    @Override
    public String toString() {
        return super.toString() + ", trackWidth: " + trackWidth;
    }
}
