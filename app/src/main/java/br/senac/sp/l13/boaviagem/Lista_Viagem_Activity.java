package br.senac.sp.l13.boaviagem;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lista_Viagem_Activity extends ListActivity
        implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> viagens;

    private List<Map<String, Object>> listarViagens(){
        viagens = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();

        item.put("imagem", R.drawable.negocios);
        item.put("destino","São Paulo");
        item.put("data","02/02/2018 a 04/02/2018");
        item.put("total","Gasto total R$ 314,98");
        viagens.add(item);

        item = new HashMap<String, Object>();
        item.put("imagem", R.drawable.lazer);
        item.put("destino","Maceió");
        item.put("data","14/05/2018 a 22/05/2018");
        item.put("total","Gasto total R$ 25.834,67");
        viagens.add(item);

        return viagens;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] de = {"imagem","destino","data","total"};

        int[] para = {R.id.TipoViagem, R.id.destino, R.id.valor};

        SimpleAdapter adapter =
                new SimpleAdapter(this, listarViagens(), R.layout.lista__viagem_layout, de, para);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String, Object> map = viagens.get(position);
        String destino = (String) map.get("destino");
        String mensagem = "Viagem selecionada: "+ destino;
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Lista_Gasto_Activity.class));

    }
}
