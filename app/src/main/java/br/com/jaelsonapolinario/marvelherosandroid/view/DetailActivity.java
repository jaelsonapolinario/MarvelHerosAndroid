package br.com.jaelsonapolinario.marvelherosandroid.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.jaelsonapolinario.marvelherosandroid.R;
import br.com.jaelsonapolinario.marvelherosandroid.adapter.ReferenceAdapter;
import br.com.jaelsonapolinario.marvelherosandroid.model.Result;
import br.com.jaelsonapolinario.marvelherosandroid.viewmodel.HeroesViewModel;

public class DetailActivity extends AppCompatActivity {

    ImageView imgThumb;
    TextView txtDesc;
    ListView listComics;
    ListView listSeries;
    ListView listStories;
    ListView listEvents;
    HeroesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        viewModel = HeroesViewModel.getInstance();

        imgThumb = (ImageView)findViewById(R.id.imgDetailThumb);
        txtDesc = (TextView)findViewById(R.id.txtDetailDesc);
        listComics = (ListView)findViewById(R.id.listComics);
        listSeries = (ListView)findViewById(R.id.listSeries);
        listStories = (ListView)findViewById(R.id.listStories);
        listEvents = (ListView)findViewById(R.id.listEvents);

    }

    @Override
    protected void onResume() {
        super.onResume();

        bindValues();
    }

    private void bindValues()
    {
        Result heroSelected = viewModel.getHeroSelected();

        Picasso.get()
                .load(heroSelected.getThumbnail().getPath())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imgThumb);

        txtDesc.setText(heroSelected.getDescription());

        listComics.setAdapter(new ReferenceAdapter(this, heroSelected.getComics().getItems()));
        changeSizeList(listComics, heroSelected.getComics().getItems().size());
        listSeries.setAdapter(new ReferenceAdapter(this, heroSelected.getSeries().getItems()));
        changeSizeList(listSeries, heroSelected.getSeries().getItems().size());
        listStories.setAdapter(new ReferenceAdapter(this, heroSelected.getStories().getItems()));
        changeSizeList(listStories, heroSelected.getStories().getItems().size());
        listEvents.setAdapter(new ReferenceAdapter(this, heroSelected.getEvents().getItems()));
        changeSizeList(listEvents, heroSelected.getEvents().getItems().size());
    }

    private void changeSizeList(ListView list, int countItems)
    {
        ViewGroup.LayoutParams params = list.getLayoutParams();
        params.height = 80 * countItems;
        list.setLayoutParams(params);
    }
}
