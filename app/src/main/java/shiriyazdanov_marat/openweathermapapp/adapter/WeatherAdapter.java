package shiriyazdanov_marat.openweathermapapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import shiriyazdanov_marat.openweathermapapp.R;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;

/**
 * Created by Marat_2 on 07.08.2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<CurrentWeatherModel> mDataSet;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        TextView temp;
        TextView speed;
        TextView deg;
        public ViewHolder(View v){
            super(v);
            cityName = (TextView) v.findViewById(R.id.ct);
            temp = (TextView) v.findViewById(R.id.temp);
            speed = (TextView) v.findViewById(R.id.speed);
            deg = (TextView) v.findViewById(R.id.deg);
        }
    }
    public WeatherAdapter(List<CurrentWeatherModel> list){
        mDataSet = list;
    }
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cityName.setText(mDataSet.get(position).getName());
        holder.temp.setText(String.valueOf(mDataSet.get(position).getMainData().getTemp()));
        holder.speed.setText(String.valueOf(mDataSet.get(position).getWindData().getSpeed()));
        holder.deg.setText(String.valueOf(mDataSet.get(position).getWindData().getDeg()));
    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }
}
