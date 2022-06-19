package com.vitorcastillo.as2_coletaroupas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class DadosActivity extends Activity {
    EditText nome;
    EditText cpf;
    EditText telefone;
    EditText endereco;
    EditText email;
    EditText senha;
    Button gravar;
    Button deletar;
    Cursor cursor;
    UsuarioController crud;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        id = this.getIntent().getStringExtra("Identificação");

        crud = new UsuarioController((getBaseContext()));

        nome = (EditText)findViewById(R.id.nome_dados);
        cpf = (EditText)findViewById(R.id.cpf_dados);
        telefone = (EditText)findViewById(R.id.telefone_dados);
        endereco = (EditText)findViewById(R.id.endereco_dados);
        email = (EditText)findViewById(R.id.email_dados);
        senha = (EditText)findViewById(R.id.senha_dados);


        gravar = (Button)findViewById(R.id.button_atualizar);

        cursor = crud.carregaDadoById(Integer.parseInt(id));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaUsuario.NOME)));
        cpf.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaUsuario.CPF)));
        telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaUsuario.TELEFONE)));
        endereco.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaUsuario.ENDERECO)));
        email.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaUsuario.EMAIL)));
        senha.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaUsuario.SENHA)));

    }
}