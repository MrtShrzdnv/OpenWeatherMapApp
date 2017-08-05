package shiriyazdanov_marat.openweathermapapp.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marat_2 on 28.07.2017.
 */

public class CurrentWeather {
    @SerializedName("main")
    private Main mainData;
    @SerializedName("wind")
    private Wind windData;

    public Main getMainData() {
        return mainData;
    }

    public void setMainData(Main mainData) {
        this.mainData = mainData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentWeather that = (CurrentWeather) o;

        if (!mainData.equals(that.mainData)) return false;
        return windData.equals(that.windData);

    }

    @Override
    public int hashCode() {
        int result = mainData.hashCode();
        result = 31 * result + windData.hashCode();
        return result;
    }
}
