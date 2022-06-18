package com.vitorcastillo.as2_coletaroupas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LocalAdapter adapter = new LocalAdapter();
    int id_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id_usuario = this.getIntent().getIntExtra("id",0);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(HomeActivity.this)
        );
    }

    public void alterarCadastro(View v){
        Intent intent = new Intent(HomeActivity.this, EditarDados.class);
        //Toast.makeText(getApplicationContext(),String.valueOf(id_usuario), Toast.LENGTH_LONG).show();
        intent.putExtra("id", id_usuario);
        startActivity(intent);
    }

    public void logarButtonOnClick(View v){
        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
    }
}