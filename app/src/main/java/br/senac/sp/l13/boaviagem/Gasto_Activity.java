package br.senac.sp.l13.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

public class Gasto_Activity extends Activity {
    private int ano, mes, dia;
    private Button dataGasto;
    private Spinner categoria;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gasto_layout);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataGasto = (Button) findViewById(R.id.data);
        dataGasto.setText(dia + "/" + (mes + 1) + "/" + ano);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.categoria_gasto,
                android.R.layout.simple_spinner_item);
        categoria = (Spinner) findViewById(R.id.categoria);

        categoria.setAdapter(adapter);


    }

    public void selecionarData(View view) {

        showDialog(view.getId());
    }

    protected Dialog onCreateDialog(int id){
        if (R.id.data == id){
            return new DatePickerDialog(this, listener, ano, mes, dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            ano = year;
            mes = month;
            dia = dayOfMonth;
            dataGasto.setText(dia + "/" + (mes + 1) + "/" + ano);
        }
    };

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gasto_menu, menu);
        return true;
    }

    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        finish();
        return true;
    }

    public void registrarGasto(View view) {
    }
}
