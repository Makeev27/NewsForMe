package com.android.example.newsforme.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.example.newsforme.Adapter.NewsAdapter;
import com.android.example.newsforme.Data.Json_Data;
import com.android.example.newsforme.Interface.IMyApi;
import com.android.example.newsforme.R;
import com.android.example.newsforme.Retrofit.RetrofitClient;

import java.util.zip.Inflater;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SportsFragment extends Fragment {

    RecyclerView recyclerView;
    public IMyApi API;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SportsFragment() {
        // Required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sports_fragment, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.sport_en);
        Retrofit retrofit = RetrofitClient.getInstance();
        API = retrofit.create(IMyApi.class);
        recyclerView = view.findViewById(R.id.sportsRecyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getSportsNews();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (sharedPreferences.getBoolean("language" , true )){
            getActivity().setTitle(R.string.sport_ru);
            getSportsNewsRu();
        } else if (sharedPreferences.getBoolean("language", false)){
            getActivity().setTitle(R.string.sport_en);
            getSportsNews();
        }
    }

    private void getSportsNewsRu() {
        compositeDisposable.add(API.getSportNewsRu()
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

    public void getSportsNews(){

        compositeDisposable.add(API.getSportNews()
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


    public void DisplayData(Json_Data json_data){
        NewsAdapter adapter = new NewsAdapter(getContext(), json_data);
        recyclerView.setAdapter(adapter);
    }

}
