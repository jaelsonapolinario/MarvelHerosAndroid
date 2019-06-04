package br.com.jaelsonapolinario.marvelherosandroid.view;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.jaelsonapolinario.marvelherosandroid.R;
import br.com.jaelsonapolinario.marvelherosandroid.adapter.HeroesAdapter;
import br.com.jaelsonapolinario.marvelherosandroid.databinding.ActivityMainBinding;
import br.com.jaelsonapolinario.marvelherosandroid.extension.EndlessRecyclerOnScrollListener;
import br.com.jaelsonapolinario.marvelherosandroid.model.Result;
import br.com.jaelsonapolinario.marvelherosandroid.viewmodel.HeroesViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;
    private HeroesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = HeroesViewModel.getInstance();

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mActivityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
        mActivityMainBinding.recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

        viewModel.setHeroesAdapter(new HeroesAdapter(viewModel.getListHeroes(), this));
        mActivityMainBinding.recyclerView.setAdapter(viewModel.getHeroesAdapter());

        viewModel.setMainProgressBar(mActivityMainBinding.itemProgressBar);

        viewModel.addDataToList();

        mActivityMainBinding.recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                viewModel.addDataToList();
            }
        });
    }

}

