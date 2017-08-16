package shiriyazdanov_marat.openweathermapapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shiriyazdanov_marat.openweathermapapp.api.WeatherApi;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;

public class SecondActivity extends Activity {
    private EditText editText;
    private String strCityName;
    private ArrayList<CurrentWeatherModel> list;
    private Intent returnIntent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        list = new ArrayList<>();
        returnIntent = new Intent();
        editText = (EditText) findViewById(R.id.et);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)
                        && (!editText.getText().toString().equals(""))) {
                    strCityName = editText.getText().toString();

                    App.getWeatherApi().getData(strCityName,WeatherApi.WEATHER_UNITS, WeatherApi.KEY).enqueue(new Callback<CurrentWeatherModel>(){

                        @Override
                        public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                            if (response.code() == 200){
                                CurrentWeatherModel result = response.body();
                                editText.setText("");
                                list.add(result);
                                returnIntent.putParcelableArrayListExtra("result", list);
                                //returnIntent.putExtras(bundle);
                                Toast.makeText(SecondActivity.this,"ok",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                editText.setText("");
                                Toast.makeText(SecondActivity.this,"bad "+response.code(),Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
                            Log.d("TAG", "FAIL");
                            t.getMessage();
                            editText.setText("");
                            Toast.makeText(SecondActivity.this,"fail",Toast.LENGTH_SHORT).show();
                        }
                    });

                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed(){
        if (list.isEmpty())
            setResult(Activity.RESULT_CANCELED, returnIntent);
        else
            setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
