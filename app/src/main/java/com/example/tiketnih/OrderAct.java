package com.example.tiketnih;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderAct extends AppCompatActivity {

    public ImageView home, akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        home = findViewById(R.id.branda);
        akun = findViewById(R.id.accountOrd);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), BerandaAct.class);
                startActivity(itn);
                finish();
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), AccountAct.class);
                startActivity(itn);
                finish();
            }
        });
    }
}