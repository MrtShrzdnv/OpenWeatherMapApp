package shiriyazdanov_marat.openweathermapapp.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Marat_2 on 05.08.2017.
 */

public class Wind {

    @SerializedName("speed")
    @Expose
    private Double speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wind wind = (Wind) o;

        if (!speed.equals(wind.speed)) return false;
        return deg.equals(wind.deg);

    }

    @Override
    public int hashCode() {
        int result = speed.hashCode();
        result = 31 * result + deg.hashCode();
        return result;
    }
}
