package fr.nbrignol.dansmoncoin;

public class Poi {
    protected String title;
    protected double latitude;
    protected double longitude;

    public Poi(String title) {
        setTitle(title);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
