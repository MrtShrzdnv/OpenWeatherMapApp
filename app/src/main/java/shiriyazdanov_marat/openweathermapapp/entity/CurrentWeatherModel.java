package shiriyazdanov_marat.openweathermapapp.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marat_2 on 28.07.2017.
 */

public class CurrentWeatherModel {
    @SerializedName("main")
    private Main mainData;
    @SerializedName("wind")
    private Wind windData;
    @SerializedName("name")
    private String name;

    public Main getMainData() {
        return mainData;
    }

    public void setMainData(Main mainData) {
        this.mainData = mainData;
    }

    public Wind getWindData() {
        return windData;
    }

    public void setWindData(Wind windData) {
        this.windData = windData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentWeatherModel that = (CurrentWeatherModel) o;

        if (!mainData.equals(that.mainData)) return false;
        if (!windData.equals(that.windData)) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = mainData.hashCode();
        result = 31 * result + windData.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
