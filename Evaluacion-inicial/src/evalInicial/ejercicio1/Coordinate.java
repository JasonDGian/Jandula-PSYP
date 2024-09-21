package evalInicial.ejercicio1;

/**
 * Class that represents the starting location of the insertion of the word.
 * 
 * Attributes:
 * int altitude - The vertical position of the coordinate.
 * int latitude - The horizontal position of the coordinate.
 */
public class Coordinate {

    private int altitude; // The altitude of the coordinate.
    private int latitude; // The latitude of the coordinate.

    /**
     * Constructor to initialize the Coordinate object with specified altitude and latitude.
     * 
     * @param altitude - The altitude value for the coordinate.
     * @param latitude - The latitude value for the coordinate.
     */
    public Coordinate(int altitude, int latitude) {
        super();
        this.altitude = altitude; // Set the altitude value.
        this.latitude = latitude; // Set the latitude value.
    }

    /**
     * Gets the altitude of the coordinate.
     * 
     * @return altitude - The current altitude value.
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * Sets a new altitude for the coordinate.
     * 
     * @param altitude - The new altitude value to set.
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude; // Update the altitude value.
    }

    /**
     * Gets the latitude of the coordinate.
     * 
     * @return latitude - The current latitude value.
     */
    public int getLatitude() {
        return latitude;
    }

    /**
     * Sets a new latitude for the coordinate.
     * 
     * @param latitude - The new latitude value to set.
     */
    public void setLatitude(int latitude) {
        this.latitude = latitude; // Update the latitude value.
    }
}
