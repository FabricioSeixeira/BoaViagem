package br.senac.sp.l13.boaviagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        usuario = (EditText) findViewById(R.id.usuario);

        senha = (EditText) findViewById(R.id.senha);
    }

    public void entrarOnClick(View view) {

        String usuarioDigitado, senhaDIgitada;

        usuarioDigitado = usuario.getText().toString();

        senhaDIgitada = senha.getText().toString();

        if (usuarioDigitado.equals("senac") && senhaDIgitada.equals("senac")) {
            Intent intent = new Intent(Login_Activity.this,Principal_Activity.class);
                    startActivity(intent);
                    finish();
        } else {
            String mensagem_erro = getString(R.string.mensagem_erro);
            Toast.makeText(Login_Activity.this, mensagem_erro, Toast.LENGTH_SHORT).show();
            limpatela();
        }
    }

    public void limpatela() {
        usuario.setText("");
        senha.setText("");
        usuario.requestFocus();
    }
}
