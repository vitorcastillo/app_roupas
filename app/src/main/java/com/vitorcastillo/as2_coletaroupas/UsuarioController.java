package com.vitorcastillo.as2_coletaroupas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioController {

    private SQLiteDatabase db;
    private CriaUsuario usuario;

    public UsuarioController(Context context){
        usuario = new CriaUsuario(context);
    }

    //CRIA USUÁRIO
    public String insereDado(String nome, String cpf, String telefone, String email, String senha, String endereco){
        ContentValues valores;
        long resultado;

        db = usuario.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaUsuario.NOME, nome);
        valores.put(CriaUsuario.CPF, cpf);
        valores.put(CriaUsuario.TELEFONE, telefone);
        valores.put(CriaUsuario.EMAIL, email);
        valores.put(CriaUsuario.SENHA, senha);
        valores.put(CriaUsuario.ENDERECO, endereco);

        resultado = db.insert(CriaUsuario.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir usuário";
        else
            return "Usuário criado com sucesso";

    }

    public Cursor carregaDadoByEmailSenha(String email, String senha){
        Cursor cursor;
        String[] campos =  {usuario.ID,usuario.NOME,usuario.CPF,usuario.TELEFONE,usuario.EMAIL,usuario.SENHA, usuario.ENDERECO};
        String where = CriaUsuario.EMAIL + "='" + email + "' AND " + CriaUsuario.SENHA + "='" + senha + "'";
        db = usuario.getReadableDatabase();
        cursor = db.query(CriaUsuario.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {usuario.ID,usuario.NOME,usuario.CPF,usuario.TELEFONE,usuario.EMAIL,usuario.SENHA, usuario.ENDERECO};
        String where = CriaUsuario.ID + "=" + id;
        db = usuario.getReadableDatabase();
        cursor = db.query(CriaUsuario.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String nome, String cpf, String telefone, String endereco, String email, String senha){
        ContentValues dados;
        String where;

        db = usuario.getWritableDatabase();

        where = CriaUsuario.ID + "=" + id;

        dados = new ContentValues();
        dados.put(CriaUsuario.NOME, nome);
        dados.put(CriaUsuario.CPF, cpf);
        dados.put(CriaUsuario.TELEFONE, telefone);
        dados.put(CriaUsuario.ENDERECO, endereco);
        dados.put(CriaUsuario.EMAIL, email);
        dados.put(CriaUsuario.SENHA, senha);

        db.update(CriaUsuario.TABELA,dados,where,null);
        db.close();
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {usuario.ID,usuario.NOME,usuario.CPF,usuario.TELEFONE,usuario.EMAIL,usuario.SENHA, usuario.ENDERECO};
        db = usuario.getReadableDatabase();
        cursor = db.query(CriaUsuario.TABELA, campos, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void deletaRegistro(int id){
        String where = CriaUsuario.ID + "=" + id;
        db = usuario.getReadableDatabase();
        db.delete(CriaUsuario.TABELA,where,null);
        db.close();
    }
}
