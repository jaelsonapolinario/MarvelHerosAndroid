package br.com.jaelsonapolinario.marvelherosandroid.adapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;;
import android.widget.TextView;
import java.util.ArrayList;
import br.com.jaelsonapolinario.marvelherosandroid.R;

public class ReferenceAdapter extends ArrayAdapter<br.com.jaelsonapolinario.marvelherosandroid.model.Reference> {

    private Activity context;
    private ArrayList<br.com.jaelsonapolinario.marvelherosandroid.model.Reference> values;

    public ReferenceAdapter(Activity context, ArrayList<br.com.jaelsonapolinario.marvelherosandroid.model.Reference> values) {
        super(context, R.layout.list_attachments, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if(convertView == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.list_attachments,null);
            view.setTag(view.findViewById(R.id.txtReference));
        }
        else
        {
            view = convertView;
        }

        TextView txtReference = view.findViewById(R.id.txtReference);

        txtReference.setText(values.get(position).getName());

        return view;
    }
}
