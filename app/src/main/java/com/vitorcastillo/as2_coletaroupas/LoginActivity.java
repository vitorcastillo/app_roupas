package com.vitorcastillo.as2_coletaroupas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginbtButtonOnClick(View v){

    }

    protected void logar2()
    {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);

        startActivity(i);
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        String aux = data.getStringExtra("data");
                        setTitle("MainActivity: "+aux);
                    }

                }
            }
    );

    public void logarButtonOnClick(View v){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

        EditText mEdit   = (EditText)findViewById(R.id.email_login);
        EditText senha = (EditText) findViewById(R.id.senha_login);

        UsuarioController controller = new UsuarioController(getBaseContext());

        Cursor cursor = controller.carregaDadoByEmailSenha(mEdit.getText().toString(),senha.getText().toString());

        if(cursor.getCount() == 1){
            //Toast.makeText(getApplicationContext(), cursor.getString(cursor.getColumnIndexOrThrow(CriaUsuario.NOME)), Toast.LENGTH_LONG).show();
            intent.putExtra("id", cursor.getInt(cursor.getColumnIndexOrThrow(CriaUsuario.ID)));
            activityResultLauncher.launch(intent);

        }
        else{
            Toast.makeText(getApplicationContext(),"Usuário ou Senha incorretos.", Toast.LENGTH_LONG).show();

        }

    }
    public void cadastroButtonOnClick(View v){
        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(intent);


    }

}