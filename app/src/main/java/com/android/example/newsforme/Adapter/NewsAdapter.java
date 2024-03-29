package com.android.example.newsforme.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.newsforme.Data.Constants;
import com.android.example.newsforme.Data.Json_Data;
import com.android.example.newsforme.Model.News;
import com.android.example.newsforme.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    private CheckBox checkBox;
    private Context context;
    private Json_Data json_data;
    private final SparseBooleanArray array = new SparseBooleanArray();
    private ArrayList<News> newsArrayList;
    private OnItemClickListener aListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        aListener = listener;
    }

    public NewsAdapter(Context context, Json_Data json_data) {
        this.context = context;
        this.json_data = json_data;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item,
                viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
//        News currentNews = newsArrayList.get(i);
//
//        String title = currentNews.getTitle();
//        String content = currentNews.getContent();
//        String source = currentNews.getSource();
//        String posterUrl = currentNews.getPosterUrl();

        newsViewHolder.titleTv.setText(json_data.getArticles().get(i).getTitle());
        if (json_data.getArticles().get(i).getContent() != null && Constants.LANGUAGE == false) newsViewHolder.contentTv.setText(json_data.getArticles().get(i).getContent());
        else newsViewHolder.contentTv.setText(json_data.getArticles().get(i).getDescription());
        newsViewHolder.sourceTv.setText(json_data.getArticles().get(i).getSource().getName());
        Glide.with(context)
                .load(json_data.getArticles().get(i).getUrlToImage())
                .into(newsViewHolder.posterIv);
        if (array.get(i)) newsViewHolder.checkBox.setChecked(true);
        else newsViewHolder.checkBox.setChecked(false);

    }

    @Override
    public int getItemCount() {
        return json_data.getArticles().size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        TextView contentTv;
        TextView sourceTv;
        TextView authorTv;
        ImageView posterIv;
        CheckBox checkBox;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    array.put(getAdapterPosition(), true);
                    notifyDataSetChanged();
                }
            });
            titleTv = itemView.findViewById(R.id.titleTv);
            contentTv = itemView.findViewById(R.id.contentTv);
            sourceTv = itemView.findViewById(R.id.sourceTv);
            posterIv = itemView.findViewById(R.id.posterIv);
            checkBox = itemView.findViewById(R.id.checkbox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(aListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            aListener.onItemClick(position);
                        }
                    }
                }
            });
        }


    }


}
