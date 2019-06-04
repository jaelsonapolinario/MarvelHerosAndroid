package br.com.jaelsonapolinario.marvelherosandroid.viewmodel;

import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import java.math.BigInteger;
import java.net.URI;
import java.security.MessageDigest;
import java.util.ArrayList;

import br.com.jaelsonapolinario.marvelherosandroid.adapter.HeroesAdapter;
import br.com.jaelsonapolinario.marvelherosandroid.model.Result;

public class HeroesViewModel {

    private static HeroesViewModel instance;
    private Result heroSelected;
    private ProgressBar mainProgressBar;
    private HeroesAdapter heroesAdapter;
    private ArrayList<Result> listHeroes;
    private int mLoadedItems;

    public static HeroesViewModel getInstance() {
        if(instance == null) {
            instance = new HeroesViewModel();
        }
        return instance;
    }

    private static final String PUBLICKEY = "93586130237477dd2b726ca0a411ff82";
    private static final String PRIVATEKEY = "b91b03bf463f750eff38826f78558bad7e3a642a";

    public HeroesViewModel() {
        this.listHeroes = new ArrayList<Result>();
    }

    public ProgressBar getMainProgressBar() {
        return mainProgressBar;
    }

    public void setMainProgressBar(ProgressBar mainProgressBar) {
        this.mainProgressBar = mainProgressBar;
    }

    public HeroesAdapter getHeroesAdapter() {
        return heroesAdapter;
    }

    public void setHeroesAdapter(HeroesAdapter heroesAdapter) {
        this.heroesAdapter = heroesAdapter;
    }

    public ArrayList<Result> getListHeroes() {
        return listHeroes;
    }


    public void setHeroSelected(Result heroSelected) {
        this.heroSelected = heroSelected;
    }

    public Result getHeroSelected()
    {
        return this.heroSelected;
    }

    //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public String getHashApi(String timestamp){
        String sen = "";
        MessageDigest md = null;
        String toConvert = timestamp + PRIVATEKEY + PUBLICKEY;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(toConvert.getBytes()));
        sen = hash.toString(16);
        return sen;
    }


    public void getHeroes()
    {
        //TODO
    }

    //MOCK Result
    public void addDataToList() {
        mainProgressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 30; i++) {
                    listHeroes.add(new Result(mLoadedItems, "Af" + mLoadedItems, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1hfi1KSpULc5Ejz5uFbvX4MNJgig15w0yOznruOp1HBiGkJXyhA", null));;
                    mLoadedItems++;
                }
                heroesAdapter.notifyDataSetChanged();
                mainProgressBar.setVisibility(View.GONE);
            }
        }, 1500);

    }

}
