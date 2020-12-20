package com.training.android_formularios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText Name,DatePicker,Phone,Email,Desc;
    private Button BtnNext;
    public final Calendar C = Calendar.getInstance();
    final int month = C.get(Calendar.MONTH);
    final int year = C.get(Calendar.YEAR);
    final int day = C.get(Calendar.DAY_OF_MONTH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name        = (EditText) findViewById(R.id.idName);
        DatePicker  = (EditText) findViewById(R.id.idDatePicker);
        Phone       = (EditText) findViewById(R.id.idPhone);
        Email       = (EditText) findViewById(R.id.idEmail);
        Desc        = (EditText) findViewById(R.id.idDesc);
        BtnNext     = (Button) findViewById(R.id.idBtnNext);

        DatePicker.setOnClickListener(v -> {
            switch (v.getId()){
                case R.id.idDatePicker:
                    obtenerFecha();
                    break;
        }
    });

        BtnNext.setOnClickListener(v -> {
            String Names = Name.getText().toString();
            String Phones = Phone.getText().toString();
            String Emails = Email.getText().toString();
            String Descs = Desc.getText().toString();
            Intent intent = new Intent(MainActivity.this, ConfirmData.class);
            intent.putExtra("Name", Names);
            intent.putExtra("Phone", Phones);
            intent.putExtra("Email", Emails);
            intent.putExtra("Desc", Descs);

            finish();

        });
}
        private void obtenerFecha(){
            DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                    final int mesActual = month + 1;
                    //Formateo el día obtenido: antepone el 0 si son menores de 10
                    String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                    //Formateo el mes obtenido: antepone el 0 si son menores de 10
                    String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);
                    //Muestro la fecha con el formato deseado<
                    DatePicker.setText(diaFormateado + "/" + mesFormateado + "/" + year);


                }
                //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
                /**
                 *También puede cargar los valores que usted desee
                 */
            },year, month, day);
            //Muestro el widget
            recogerFecha.show();

        }
}