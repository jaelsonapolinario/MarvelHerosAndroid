package br.com.jaelsonapolinario.marvelherosandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.jaelsonapolinario.marvelherosandroid.R;
import br.com.jaelsonapolinario.marvelherosandroid.model.Result;
import br.com.jaelsonapolinario.marvelherosandroid.view.DetailActivity;
import br.com.jaelsonapolinario.marvelherosandroid.viewmodel.HeroesViewModel;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private RecyclerView mRecyclerView;
    private ArrayList<Result> values;
    private Context context;


    public HeroesAdapter(ArrayList<Result> values, Context context) {
        this.values = values;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        mRecyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_heroes, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int itemPosition = mRecyclerView.getChildLayoutPosition(view);
                HeroesViewModel.getInstance().setHeroSelected(values.get(itemPosition));

                Intent intent = new Intent(context,DetailActivity.class);
                context.startActivity(intent);
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTitle.setText(values.get(position).getName());
        holder.txtDesc.setText(values.get(position).getDescription());
        Picasso.get()
                .load(values.get(position).getDescription())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgThumb);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtDesc;
        ImageView imgThumb ;


        ViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
            imgThumb = (ImageView) itemView.findViewById(R.id.imgThumb);
        }
    }

}
