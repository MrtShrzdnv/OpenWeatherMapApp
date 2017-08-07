package shiriyazdanov_marat.openweathermapapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shiriyazdanov_marat.openweathermapapp.adapter.WeatherAdapter;
import shiriyazdanov_marat.openweathermapapp.api.WeatherApi;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;
import shiriyazdanov_marat.openweathermapapp.service.CurrentWeatherService;


public class MainActivity extends Activity {

    RecyclerView recyclerView;
    List<CurrentWeatherModel> list;
    CurrentWeatherService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        service = new CurrentWeatherService();

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        WeatherAdapter adapter = new WeatherAdapter(list);
        recyclerView.setAdapter(adapter);
        list.add(service.getData("Kazan","metric",WeatherApi.KEY));
        recyclerView.getAdapter().notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
