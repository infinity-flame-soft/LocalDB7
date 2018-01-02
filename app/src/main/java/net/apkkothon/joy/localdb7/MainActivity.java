package net.apkkothon.joy.localdb7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name,profession;
    private Button btnADD,btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //----initialize------------------
        name=findViewById(R.id.et_name);
        profession=findViewById(R.id.et_profession);
        btnADD=findViewById(R.id.button_add);
        btnShow=findViewById(R.id.button_show);


        //---onClick-------------------
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Model model=new Model();

                model.setName(name.getText().toString());
                model.setProfession(profession.getText().toString());

                DBFunction dbFunction=new DBFunction(MainActivity.this);
                dbFunction.addDataToTable(model);

                Toast.makeText(MainActivity.this,"Data added ! ",Toast.LENGTH_SHORT).show();

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this,ShowActivity.class));


            }
        });




    }
}
