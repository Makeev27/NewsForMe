package com.android.example.newsforme.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.example.newsforme.Activities.HomeActivity;
import com.android.example.newsforme.Adapter.NewsAdapter;
import com.android.example.newsforme.Data.Constants;
import com.android.example.newsforme.Data.Json_Data;
import com.android.example.newsforme.Interface.IMyApi;
import com.android.example.newsforme.Model.News;
import com.android.example.newsforme.R;
import com.android.example.newsforme.Retrofit.RetrofitClient;
import com.bumptech.glide.Glide;
import com.github.florent37.shapeofview.shapes.DiagonalView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.support.constraint.Constraints.TAG;

public class ScienceFragment extends Fragment implements NewsAdapter.OnItemClickListener {

    RecyclerView recyclerView;
    public IMyApi API;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    public ArrayList<News> newsList = new ArrayList<>();
    String imageViewUrl;
    String title;
    String content;
    String url;
    String source;
    String publishedAt;
    String author;
    String description;

    public void ScienceFragments() {
        // Required empty constructor for links in another fragments/activity(ies)
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.science_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.science_en);
        Retrofit retrofit = RetrofitClient.getInstance();
        API = retrofit.create(IMyApi.class);
        recyclerView = view.findViewById(R.id.scienceRecyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (Constants.LANGUAGE == true) {
            getScienceNewsRu();
        } else if (Constants.LANGUAGE == false) {
            getScienceNews();
        }
    }

    public void getScienceNews() {

        compositeDisposable.add(API.getScienceNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Json_Data>() {
                    @Override
                    public void accept(final Json_Data json_data) throws Exception {
                        Toast.makeText(getContext(), json_data.getStatus(), Toast.LENGTH_LONG);
                        final NewsAdapter adapter = new NewsAdapter(getContext(), json_data);
                        recyclerView.setAdapter(adapter);
                        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Bundle bundle = new Bundle();
                                imageViewUrl = json_data.getArticles().get(position).getUrlToImage();
                                title = json_data.getArticles().get(position).getTitle();
                                content = json_data.getArticles().get(position).getContent();
                                url = json_data.getArticles().get(position).getUrl();
                                source = json_data.getArticles().get(position).getSource().getName();
                                publishedAt = json_data.getArticles().get(position).getPublishedAt();
                                author = json_data.getArticles().get(position).getAuthor();
                                description = json_data.getArticles().get(position).getDescription();
                                bundle.putString("category", "Science");
                                bundle.putString("imageView" , imageViewUrl);
                                bundle.putString("title" , title);
                                bundle.putString("content" , content);
                                bundle.putString("url", url);
                                bundle.putString("source", source);
                                bundle.putString("publishedAt", publishedAt);
                                bundle.putString("author", author);
                                bundle.putString("description", description);
                                DetailFragment detailFragment = new DetailFragment();
                                detailFragment.setArguments(bundle);
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.flContainer,detailFragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                }
                            });
//                        DisplayData(json_data);
                    }
                }));
    }

    public void getScienceNewsRu() {

        compositeDisposable.add(API.getScienceNewsRu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Json_Data>() {
                    @Override
                    public void accept(final Json_Data json_data) throws Exception {
                        Toast.makeText(getContext(), json_data.getStatus(), Toast.LENGTH_LONG);
                        final NewsAdapter adapter = new NewsAdapter(getContext(), json_data);
                        recyclerView.setAdapter(adapter);
                        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Bundle bundle = new Bundle();
                                imageViewUrl = json_data.getArticles().get(position).getUrlToImage();
                                title = json_data.getArticles().get(position).getTitle();
                                content = json_data.getArticles().get(position).getContent();
                                url = json_data.getArticles().get(position).getUrl();
                                source = json_data.getArticles().get(position).getSource().getName();
                                publishedAt = json_data.getArticles().get(position).getPublishedAt();
                                author = json_data.getArticles().get(position).getAuthor();
                                description = json_data.getArticles().get(position).getDescription();
                                bundle.putString("category", "science");
                                bundle.putString("imageView" , imageViewUrl);
                                bundle.putString("title" , title);
                                bundle.putString("url", url);
                                bundle.putString("source", source);
                                bundle.putString("publishedAt", publishedAt);
                                bundle.putString("author", author);
                                bundle.putString("description", description);
                                DetailFragment detailFragment = new DetailFragment();
                                detailFragment.setArguments(bundle);
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.flContainer,detailFragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        });
//                        DisplayData(json_data);
                    }
                }));
    }


//    public void DisplayData(Json_Data json_data) {
//        final NewsAdapter adapter = new NewsAdapter(getContext(), json_data);
//        recyclerView.setAdapter(adapter);
//    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        fragmentTransaction.replace(R.id.flContainer, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClick(int position) {

    }
}
