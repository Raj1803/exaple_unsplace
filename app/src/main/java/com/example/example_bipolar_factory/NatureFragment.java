package com.example.example_bipolar_factory;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NatureFragment extends Fragment {
    private PhotoAdapter adapter;

    private int page = 1;

    ApiInterface dataService;
    RecyclerView recyclerView;

    public NatureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nature, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.nature_fragment_recycler);

        dataService = UnsplashClient.getUnsplashClient().create(ApiInterface.class);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PhotoAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadPhotos();
            }
        });

        loadPhotos();

        return view;
    }

    private void loadPhotos() {

        dataService.getPhotos()
                .enqueue(new Callback<List<Photo>>() {
                    @Override
                    public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {

                        List<Photo> photos = response.body();
                        Log.d("Photos", "Photos Fetched " + photos.size());
                        //add to adapter
                        page++;
                        System.out.println("phoos :" + photos);
                        adapter.addPhotos(photos);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Photo>> call, Throwable t) {

                    }
                });


    }

}
