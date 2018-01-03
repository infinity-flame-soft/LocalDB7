package net.apkkothon.joy.localdb7;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        builder.setMessage("Delete OR Update ?");
        builder.setTitle("Confirm");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                dbFunction.delete(pos);
                adapter.notifyDataSetChanged();


            }
        });

        builder.setNegativeButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent=new Intent(ShowActivity.this,UpdateActivity.class);
                intent.putExtra("position",pos);
                startActivity(intent);

            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                pos= (int) l;
                //Toast.makeText(ShowActivity.this,String.valueOf(pos),Toast.LENGTH_SHORT).show();
                builder.show();

            }
        });




    }
}
