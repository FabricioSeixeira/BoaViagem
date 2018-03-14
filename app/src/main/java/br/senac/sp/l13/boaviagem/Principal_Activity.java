package br.senac.sp.l13.boaviagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Principal_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_layout);
    }

    public void selecionarOpcao(View view) {

        switch (view.getId()){
            case R.id.novo_gasto:
                startActivity(new Intent(Principal_Activity.this,Gasto_Activity.class));
                break;

            case R.id.nova_viagem:
                startActivity(new Intent(Principal_Activity.this,Viagem_Activity.class));
                break;

            case R.id.minhas_viagens:
                startActivity(new Intent(Principal_Activity.this,Lista_Viagem_Activity.class));
                break;

            case R.id.configurações:
                startActivity(new Intent(Principal_Activity.this,Configuracoes_Activity.class));
                break;
        }
    }
}
