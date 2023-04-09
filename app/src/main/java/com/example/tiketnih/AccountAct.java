package com.example.tiketnih;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tiketnih.adapter.NameAdapter;
import com.example.tiketnih.model.NameAcc;
import com.example.tiketnih.retrofit.GetDataService;
import com.example.tiketnih.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountAct extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private NameAdapter adapter;
    private RecyclerView recyclerView;

    public ImageView lyOrder, home, setting;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //membuat loading
        progressDialog = new ProgressDialog(AccountAct.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        //membuat koneksi api
        GetDataService service = RetrofitClientInstance.getRetrofit().create(GetDataService.class);
        Call<List<NameAcc>> call = service.getNames();

        call.enqueue(new Callback<List<NameAcc>>() {
            @Override
            public void onResponse(Call<List<NameAcc>> call, Response<List<NameAcc>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<NameAcc>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(AccountAct.this, "" + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("error", t.toString());
            }
        });



//        home = findViewById(R.id.branda);
//        lyOrder = findViewById(R.id.orderLy);
//        setting = findViewById(R.id.imageView13);
//
//        lyOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent itn = new Intent(getApplicationContext(), OrderAct.class);
//                startActivity(itn);
//                finish();
//            }
//        });
//
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent itn = new Intent(getApplicationContext(), BerandaAct.class);
//                startActivity(itn);
//                finish();
//            }
//        });
//
//        setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent itn = new Intent(getApplicationContext(), SettingAct.class);
//                startActivity(itn);
//                finish();
//            }
//        });
    }

    private void generateDataList(List<NameAcc> body) {
        recyclerView = findViewById(R.id.custom_rec_view);
        adapter = new NameAdapter(body, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AccountAct.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}