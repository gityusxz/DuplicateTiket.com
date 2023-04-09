package com.example.tiketnih;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BerandaAct extends AppCompatActivity {

    public ImageView lyOrder, lyTrain, lyAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        lyOrder = findViewById(R.id.orderLy);
        lyTrain = findViewById(R.id.imgTrain);
        lyAkun = findViewById(R.id.account);

        lyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), OrderAct.class);
                startActivity(itn);
                finish();
            }
        });

        lyTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), TrainAct.class);
                startActivity(itn);
                finish();
            }
        });

        lyAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), AccountAct.class);
                startActivity(itn);
                finish();
            }
        });

    }
}