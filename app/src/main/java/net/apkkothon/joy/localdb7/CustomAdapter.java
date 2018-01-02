package net.apkkothon.joy.localdb7;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by joy on 1/2/18.
 */

public class CustomAdapter extends CursorAdapter{



    public CustomAdapter(Context context, Cursor c) {
        super(context,c);


    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        View view= LayoutInflater.from(context).inflate(R.layout.list_view_item,viewGroup,false);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        TextView tvName,tvProfession;

        tvName=view.findViewById(R.id.tv_name);
        tvProfession=view.findViewById(R.id.tv_profession);


        tvName.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
        tvProfession.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));


    }
}
