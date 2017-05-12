package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017452 on 12/5/2017.
 */

public class customAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> modules;
    private Context context;
    private TextView tvId,tvDesc,tvDate;

    public customAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        modules = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);



        // Get the TextView object
        tvId = (TextView) rowView.findViewById(R.id.textViewID);
        tvDesc = (TextView) rowView.findViewById(R.id.textViewDesc);
        tvDate = (TextView) rowView.findViewById(R.id.textViewDate);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Task current = modules.get(position);
        // Set the TextView to show the food

        tvId.setText(""+current.getId());
        tvDesc.setText(current.getDescription());
        tvDate.setText(current.getDate());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}

