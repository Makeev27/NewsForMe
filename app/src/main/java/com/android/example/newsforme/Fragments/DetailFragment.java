package com.android.example.newsforme.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.newsforme.Activities.HomeActivity;
import com.android.example.newsforme.R;
import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.shapeofview.shapes.DiagonalView;

import de.hdodenhof.circleimageview.CircleImageView;


public class DetailFragment extends Fragment {

    private DiagonalView diagonalView;
    private TextView titleTv;
    private TextView contentTv;
    private ImageView detailIv;
    private TextView urlTv;
    private TextView sourceTv;
    private TextView authorTv;
    private TextView publishedAtTv;
    private TextView descriptionTv;
    private TextView categoryTv;
    private CircleImageView circleImageView;
    private KenBurnsView kenBurnsView;


    private String title;
    private String imageUrl;
    private String content;
    private String author;
    private String source;
    private String url;
    private String publishedAt;
    private String category;
    private String description;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kenBurnsView = view.findViewById(R.id.kenBurnsView);
        diagonalView = view.findViewById(R.id.imageView);
        categoryTv = view.findViewById(R.id.detailCategoryTv);
        titleTv = view.findViewById(R.id.detailTitleTv);
        circleImageView = view.findViewById(R.id.detailCircleImageView);
        authorTv = view.findViewById(R.id.detailAuthorTv);
        contentTv = view.findViewById(R.id.detailContentTv);
//        publishedAtTv = view.findViewById(R.id.detailPublishedTv);
        descriptionTv = view.findViewById(R.id.detailDescriptionTv);
        Log.d("Arguments", getArguments().toString());
//        Log.d("Content", getArguments().getString("content"));
        if (getArguments() == null) {
            Toast.makeText(getContext(), "ARGUMENTS IS NULL", Toast.LENGTH_LONG);
        } else {
            categoryTv.setText(getArguments().getString("category"));
            descriptionTv.setText(getArguments().getString("description"));
//            publishedAtTv.setText(getArguments().getString("publishedAt"));
            authorTv.setText(getArguments().getString("source"));
            titleTv.setText(getArguments().getString("title"));
            Glide.with(getContext())
                    .load(getArguments().getString("imageView"))
                    .into(kenBurnsView);
            if (getArguments().getString("content") != null)
                contentTv.setText(getArguments().getString("content"));
            else
                Toast.makeText(getContext(), "There's no content, sorry", Toast.LENGTH_SHORT).show();
            if (getArguments().getString("source").equals("CNN")) {
                circleImageView.setImageResource(R.drawable.ic_cnn);
            } else if (getArguments().getString("source").equals("Bbc.com") ||
                    getArguments().getString("source").equals("BBC Sport")) {
                circleImageView.setImageResource(R.drawable.ic_bbc);
            } else if (getArguments().getString("source").equals("Youtube.com")) {
                circleImageView.setImageResource(R.drawable.ic_youtube);
            } else if (getArguments().getString("source").equals("Fox News")) {
                circleImageView.setImageResource(R.drawable.ic_fox);
            }
            circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = getArguments().getString("url");

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            });
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(getActivity());
        }

        return super.onOptionsItemSelected(item);
    }
}
