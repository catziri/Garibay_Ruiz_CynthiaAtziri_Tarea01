package iteso.com.tarea01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Arrays;

public class ActivityMain extends AppCompatActivity {
        AlertDialog.Builder builder;
        AutoCompleteTextView textView;
        ArrayAdapter<String> adapter;
        String[] libro;
        RadioButton fem;
        RadioButton mas;
        EditText nombre;
        EditText telefono;
        Spinner escolaridad;
        CheckBox deporte;
        RadioGroup radio;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            fem=findViewById(R.id.activity_main_fem);
            mas=findViewById(R.id.activity_main_mas);
            nombre=findViewById(R.id.activity_main_nombre);
            telefono=findViewById(R.id.activity_main_telefono);
            escolaridad=findViewById(R.id.spinner);
            deporte=findViewById(R.id.activity_main_check);
            radio=findViewById(R.id.activity_main_radio);
            fem.setChecked(true);

            builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                           clean();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });


            textView = findViewById(R.id.auto_libro);
            libro = getResources().getStringArray(R.array.libroFavorito);
            adapter =
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, libro);
            textView.setAdapter(adapter);

        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.menu,menu);
            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_save:
                    guardar();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

       public void limpiar(View v){
        builder.show();
       }
       public void clean(){
           fem.setChecked(true);
           mas.setChecked(false);
           nombre.setText("");
           telefono.setText("");
           deporte.setChecked(false);
           textView.setText("");
           escolaridad.setSelection(0);
       }

       public void guardar(){
           Alumno alumn=new Alumno();
           alumn.Nombre=nombre.getText().toString();
           alumn.Telefono=telefono.getText().toString();
           alumn.Escolaridad=escolaridad.getSelectedItem().toString();
           if(fem.isChecked())
               alumn.Genero="Femenino";
           else
               alumn.Genero="Masculino";
           alumn.Libro= textView.getText().toString();
           if(deporte.isChecked()) {
               alumn.Deporte = "Si";
           } else
               alumn.Deporte="No";
           Toast toast;
           toast=Toast.makeText(this, alumn.toString(),Toast.LENGTH_LONG);
           toast.show();
           clean();
       }
    }


