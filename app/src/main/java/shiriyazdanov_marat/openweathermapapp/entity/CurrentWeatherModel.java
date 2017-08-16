package shiriyazdanov_marat.openweathermapapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marat_2 on 28.07.2017.
 */

public class CurrentWeatherModel implements Parcelable {
    @SerializedName("main")
    private Main mainData;
    @SerializedName("wind")
    private Wind windData;
    @SerializedName("name")
    private String name;

    public CurrentWeatherModel(Main m, Wind w, String n){
        mainData = m;
        windData = w;
        name = n;
    }

    public CurrentWeatherModel(Parcel parcel) {
        mainData = parcel.readParcelable(Main.class.getClassLoader());
        windData = parcel.readParcelable(Wind.class.getClassLoader());
        name = parcel.readString();
    }

    public static final Creator<CurrentWeatherModel> CREATOR = new Creator<CurrentWeatherModel>() {
        @Override
        public CurrentWeatherModel createFromParcel(Parcel in) {
            return new CurrentWeatherModel(in);
        }

        @Override
        public CurrentWeatherModel[] newArray(int size) {
            return new CurrentWeatherModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mainData, i);
        parcel.writeParcelable(windData, i);
        parcel.writeString(name);
    }
}
