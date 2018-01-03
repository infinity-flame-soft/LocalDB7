package net.apkkothon.joy.localdb7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UpdateActivity extends AppCompatActivity {


    private EditText etName;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etName=findViewById(R.id.et_name);
        btnUpdate=findViewById(R.id.button_update);

        final int position=getIntent().getIntExtra("position",99999999);

        final DBFunction dbFunction=new DBFunction(this);

        etName.setText(dbFunction.fetch_name(position));




        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbFunction.name_update(etName.getText().toString(),position);

            }
        });



    }
}
