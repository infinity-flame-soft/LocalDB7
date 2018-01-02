package net.apkkothon.joy.localdb7;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ShowActivity extends AppCompatActivity {

    private ListView listView;

    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        //-----init----------------------
        listView=findViewById(R.id.list_view);

        //----db--------------
        final DBFunction dbFunction=new DBFunction(ShowActivity.this);


        //----adapter-----------------------
        final CustomAdapter adapter=new CustomAdapter(ShowActivity.this,dbFunction.my_data());
        listView.setAdapter(adapter);


        //-----alert----------
        builder=new AlertDialog.Builder(ShowActivity.this);

        builder.setMessage("Are you sure to delete this ?");
        builder.setTitle("Deletion");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                dbFunction.delete(pos+1);
                adapter.notifyDataSetChanged();


            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                builder.show();

                pos=i;


            }
        });




    }
}
