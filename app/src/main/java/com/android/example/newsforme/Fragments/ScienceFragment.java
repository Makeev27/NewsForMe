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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.example.newsforme.Adapter.NewsAdapter;
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

public class ScienceFragment extends Fragment {

    RecyclerView recyclerView;
    public IMyApi API;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    ImageView imageView;
    public ArrayList<News> newsList = new ArrayList<>();

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
        imageView = view.findViewById(R.id.imageView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getScienceNews();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (sharedPreferences.getBoolean("language", true)) {
            getActivity().setTitle(R.string.science_ru);
            getScienceNewsRu();
        } else if (sharedPreferences.getBoolean("language", false)) {
            getActivity().setTitle(R.string.science_en);
            getScienceNews();
        }
    }

    public void getScienceNews() {

        compositeDisposable.add(API.getScienceNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Json_Data>() {
                    @Override
                    public void accept(Json_Data json_data) throws Exception {
                        Toast.makeText(getContext(), json_data.getStatus(), Toast.LENGTH_LONG);
                        DisplayData(json_data);
                    }
                }));
    }

    public void getScienceNewsRu() {

        compositeDisposable.add(API.getScienceNewsRu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Json_Data>() {
                    @Override
                    public void accept(Json_Data json_data) throws Exception {
                        Toast.makeText(getContext(), json_data.getStatus(), Toast.LENGTH_LONG);
                        DisplayData(json_data);
                    }
                }));
    }


    public void DisplayData(Json_Data json_data) {
        final NewsAdapter adapter = new NewsAdapter(getContext(), json_data);
        recyclerView.setAdapter(adapter);
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        fragmentTransaction.replace(R.id.flContainer, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
