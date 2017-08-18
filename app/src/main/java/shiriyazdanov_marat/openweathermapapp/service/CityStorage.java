package shiriyazdanov_marat.openweathermapapp.service;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Marat_2 on 18.08.2017.
 */

public class CityStorage {
    public static final String STORAGE_NAME = "CityList";
    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    public static void init(Context cntxt){
        context = cntxt;
    }
    private static void init(){
        settings = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
    }
    public static void addProperty(String name, String value){
        if (settings == null)
            init();
        editor.putString(name, value);
        editor.apply();
    }
    public static String getProperty(String name){
        if (settings == null)
            init();
        return settings.getString(name, null);
    }
    public static void deleteProperty(String name){
        if (settings == null)
            init();
        editor.remove(name);
        editor.apply();
    }
    public static List<String> getAll(){
        if (settings == null)
            init();
        Map <String, ?> map = settings.getAll();
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, ?> entry: map.entrySet()){
            list.add(entry.getValue().toString());
        }
        return list;
    }
}
