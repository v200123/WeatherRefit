package com.example.weatherrefit.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherrefit.R;
import com.example.weatherrefit.bean.Result;
import com.example.weatherrefit.bean.weatherBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class weatherAdapter extends RecyclerView.Adapter<weatherAdapter.ViewHolder> {
    private Context context;
    private ArrayList NameList,iconList,informationList;
    private weatherBean weatherBean;
    private Result result;
    public weatherAdapter(Context context, com.example.weatherrefit.bean.weatherBean weatherBean) {
        this(context);
        this.weatherBean = weatherBean;
            result = weatherBean.getResult();
            initArray();
    }

    private weatherAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.weather_item_other_data, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvShowOtherName.setText(NameList.get(position)+"");
        holder.ivShowIcon.setImageResource((Integer) iconList.get(position%iconList.size()));
        holder.tvShowOtherInformation.setText(informationList.get(position)+"");

    }

    @Override
    public int getItemCount() {
        return NameList==null?0:NameList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvShowOtherName,tvShowOtherInformation;
        private ImageView ivShowIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShowOtherInformation = itemView.findViewById(R.id.tv_showOtherInformation);
            tvShowOtherName = itemView.findViewById(R.id.tv_showOtherName);
            ivShowIcon = itemView.findViewById(R.id.iv_showOtherIcon);
        }
    }

    private void initArray(){
        NameList = new ArrayList(){{add("气压");
        add("风速");
        add("最近的降水带距离");
        add("舒适度指数");add("能见度");}};
        iconList = new ArrayList(){{
            add(R.mipmap.weather_icon_01);add(R.mipmap.weather_distance);add(R.mipmap.weather_pres);
        }};
        informationList = new ArrayList(){
            {
            add(result.getPres()/100+"百帕");
            add(result.getWind().getSpeed()+"m/s");
//            add(result.getWind().getDirection());
            add(result.getPrecipitation().getNearest().getDistance());
            add(result.getComfort().getDesc());
            add(result.getVisibility()+"千米");
            }
        };
    }
}
