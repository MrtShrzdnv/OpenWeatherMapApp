package shiriyazdanov_marat.openweathermapapp.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Marat_2 on 05.08.2017.
 */

public class Main {


    @SerializedName("temp")
    @Expose
    private Double temp;

    public Main(Double t){
        temp = t;
    }

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
}
