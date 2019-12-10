package space.levan.wallpapers.repo.api.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author WangZhiYao
 * @date 2019/12/4
 */
public class Exif {

    private String make;
    private String model;
    @SerializedName("exposure_time")
    private String exposureTime;
    private String aperture;
    @SerializedName("focal_length")
    private String focalLength;
    private int iso;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public String getAperture() {
        return aperture;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public int getIso() {
        return iso;
    }
}
