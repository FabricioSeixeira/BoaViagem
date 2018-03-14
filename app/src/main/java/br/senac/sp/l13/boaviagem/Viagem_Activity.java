package br.senac.sp.l13.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Viagem_Activity extends Activity {
    private Date dataChegada, dataSaida;
    private int ano, mes, dia;
    private Button dataChegadaButton, dataSaidaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viagem_layout);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataChegadaButton = (Button) findViewById(R.id.dataChegada);
        dataSaidaButton = (Button) findViewById(R.id.dataSaida);
    }

    public void selecionarData(View view) {
        showDialog(view.getId());
    }


    public  void criarViagem(View view){
        Toast.makeText(this, "Em construção", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case R.id.dataChegada:
                return new DatePickerDialog(this, dataChegadaListener, ano, mes, dia);
            case R.id.dataSaida:
                return new DatePickerDialog(this, dataSaidaListener, ano, mes, dia );
        }
        return null;
    }

    private  DatePickerDialog.OnDateSetListener dataChegadaListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int anoSelecionado, int mesSelecionado, int diaSelecionado) {
            dataChegada = criarData(anoSelecionado, mesSelecionado, diaSelecionado);
            dataChegadaButton.setText(dia + "/" + (mes + 1) + "/" + ano);

        }
    };


    private Date criarData(int anoSelecionado, int mesSelecionado, int diaSelecionado) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(anoSelecionado, mesSelecionado, diaSelecionado);

        return calendar.getTime();
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.viagem_menu, menu);
        return true;
    }

    private  DatePickerDialog.OnDateSetListener dataSaidaListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int anoSelecionado, int mesSelecionado, int diaSelecionado) {
            dataSaida = criarData (anoSelecionado, mesSelecionado, diaSelecionado);
            dataSaidaButton.setText(dia + "/" + (mes + 1) + "/" + ano);
        }
    };
}
