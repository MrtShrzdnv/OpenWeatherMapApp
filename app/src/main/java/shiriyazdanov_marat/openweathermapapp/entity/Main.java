package shiriyazdanov_marat.openweathermapapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Marat_2 on 05.08.2017.
 */

public class Main implements Parcelable {
    @SerializedName("temp")
    @Expose
    private Double temp;

    public Main(Double t){
        temp = t;
    }

    public Main(Parcel parcel){
        temp = parcel.readDouble();
    }

    public static final Creator<Main> CREATOR = new Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Main main = (Main) o;

        return temp.equals(main.temp);

    }

    @Override
    public int hashCode() {
        return temp.hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(temp);
    }

}
