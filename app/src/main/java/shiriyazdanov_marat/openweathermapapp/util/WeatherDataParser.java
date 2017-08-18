package shiriyazdanov_marat.openweathermapapp.util;

/**
 * Created by Marat_2 on 16.08.2017.
 */

public class WeatherDataParser {
    public String getDeg(int i){
        if (i == 0 || i == 360)
            return "north";
        else if (0 < i && i < 45)
            return "north-northeast";
        else if (i == 45)
            return "northeast";
        else if (45 < i && i < 90)
            return "east-northeast";
        else if (i == 90)
            return "east";
        else if (90 < i && i < 135)
            return "east-southeast";
        else if (i == 135)
            return "southheast";
        else if (135 < i && i < 180)
            return "south-southeast";
        else if (i == 180)
            return "south";
        else if (180 < i && i < 225)
            return "south-southwest";
        else if (i == 225)
            return "southwest";
        else if (225 < i && i < 270)
            return "west-southwest";
        else if (i == 270)
            return "west";
        else if (270 < i && i < 315)
            return "west-northwest";
        else if (i == 315)
            return "northwest";
        else if (315 < i && i < 360)
            return "north-northwest";
        else if (i == -1)
            return "no info";
        else
            return "error";
    }
    public String getSpeed(Double i){
        if (i == -1.0)
            return "no info";
        else
            return String.valueOf(i)+"m/s";
    }
    public String getTemp(Double i){
        if (i == -999.9)
            return "no info";
        else
            return String.valueOf(i)+"\u00B0";
    }
}
