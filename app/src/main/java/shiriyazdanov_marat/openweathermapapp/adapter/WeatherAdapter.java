package shiriyazdanov_marat.openweathermapapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import shiriyazdanov_marat.openweathermapapp.R;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;
import shiriyazdanov_marat.openweathermapapp.service.CityStorage;
import shiriyazdanov_marat.openweathermapapp.util.WeatherDataParser;

/**
 * Created by Marat_2 on 07.08.2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private WeatherDataParser parser = new WeatherDataParser();
    private List<CurrentWeatherModel> mDataSet;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        TextView temp;
        TextView speed;
        TextView deg;
        Button button;
        public ViewHolder(View v){
            super(v);
            cityName = (TextView) v.findViewById(R.id.ct);
            temp = (TextView) v.findViewById(R.id.temp);
            speed = (TextView) v.findViewById(R.id.speed);
            deg = (TextView) v.findViewById(R.id.deg);
            button = (Button) v.findViewById(R.id.btn);
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cityName.setText(mDataSet.get(position).getName());
        holder.temp.setText(parser.getTemp(mDataSet.get(position).getMainData().getTemp()));
        holder.speed.setText(parser.getSpeed(mDataSet.get(position).getWindData().getSpeed()));
        holder.deg.setText(parser.getDeg(mDataSet.get(position).getWindData().getDeg()));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityStorage.deleteProperty((mDataSet.get(position).getName()));
                mDataSet.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }


}
