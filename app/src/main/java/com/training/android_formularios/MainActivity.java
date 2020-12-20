package com.training.android_formularios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText Name,DatePicker,Phone,Email,Desc;
    Button BtnNext;
    public String thisDate ="";
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

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String name = getIntent().getExtras().getString("Name");
            String phone = getIntent().getExtras().getString("Phone");
            String email = getIntent().getExtras().getString("Email");
            String desc = getIntent().getExtras().getString("Desc");
            String date = getIntent().getExtras().getString("Date");
            Name.setText(name);
            DatePicker.setText(date);
            Phone.setText(phone);
            Email.setText(email);
            Desc.setText(desc);
        }
        else{
            Name.setText("");
            DatePicker.setText("");
            Phone.setText("");
            Email.setText("");
            Desc.setText("");
        }

        DatePicker.setOnClickListener(v -> {
            switch (v.getId()){
                case R.id.idDatePicker:
                    obtenerFecha();
                    break;
        }

    });



        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Names = Name.getText().toString();
                String Phones = Phone.getText().toString();
                String Emails = Email.getText().toString();
                String Descs = Desc.getText().toString();
                String Dates = DatePicker.getText().toString();


               if(!Names.isEmpty() && !Phones.isEmpty() && !Emails.isEmpty() && !Descs.isEmpty() && !Dates.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, ConfirmData.class);
                    intent.putExtra("Name", Names);
                    intent.putExtra("Phone", Phones);
                    intent.putExtra("Email", Emails);
                    intent.putExtra("Desc", Descs);
                    intent.putExtra("Date",Dates);
                    startActivity(intent);
                    finish();}
                else{
                    Toast.makeText(MainActivity.this, getString(R.string.fill), Toast.LENGTH_LONG).show();
                }
            }
        }


        );
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
                    thisDate = diaFormateado + "/" + mesFormateado + "/" + year;
                    DatePicker.setText(thisDate);


                }
                //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
                /*
                 *También puede cargar los valores que usted desee
                 */
            },year, month, day);
            //Muestro el widget
            recogerFecha.show();

        }
}