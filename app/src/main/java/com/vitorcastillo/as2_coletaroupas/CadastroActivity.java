package com.vitorcastillo.as2_coletaroupas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button)findViewById(R.id.button_cadastro);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioController crud = new UsuarioController(getBaseContext());
                EditText nome = (EditText)findViewById(R.id.nome_cadastro);
                EditText cpf = (EditText)findViewById(R.id.cpf_cadastro);
                EditText telefone = (EditText)findViewById(R.id.telefone_cadastro);
                EditText email = (EditText)findViewById(R.id.email_cadastro);
                EditText senha = (EditText)findViewById(R.id.senha_cadastro);
                EditText endereco = (EditText)findViewById(R.id.endereço_cadastro);

                String nomeString = nome.getText().toString();
                String cpfString = cpf.getText().toString();
                String telefoneString = telefone.getText().toString();
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String enderecoString = endereco.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString,cpfString,telefoneString,emailString,senhaString,enderecoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}