package br.ufms.facom.pegaaulaapp;


import android.content.Intent;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    RadioGroup group;

    RadioButton rbMatutino, rbVespertino, rbNoturno;
    Button btnBuscar;
    String periodo = "";
    String materia = "";
    Spinner combo_materias;
    private String[] materias = new String[]{"Selecione","Português","Matemática","Artes","Física", "História", "Quimica", "Ed. Física", "Biologia", "Ingles", "Espanhol", "Literatura", "Filosofia", "Gramática", "Socliologia"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group        = findViewById(R.id.rd_group);
        rbMatutino   = findViewById(R.id.rb_matutino);
        rbVespertino = findViewById(R.id.rb_vespertino);
        rbNoturno    = findViewById(R.id.rb_noturno);
        btnBuscar      = findViewById(R.id.btn_buscar);
        combo_materias = findViewById(R.id.spinner_materias);

        rbMatutino.isChecked();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) group.findViewById(checkedId);
                periodo = button.getText().toString();
                Toast.makeText(MainActivity.this, ""+periodo, Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,materias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo_materias.setAdapter(adapter);


        combo_materias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (combo_materias.getSelectedItem().toString().equals(null)) {
                    ((TextView) parent.getChildAt(0)).setText("Selecione uma matéria");
                }
                materia = combo_materias.getSelectedItem().toString();
                //Toast.makeText(CadastroFuncionarioActivity.this, ""+cargo, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaProfessorActivity.class);
                intent.putExtra("periodo", periodo);
                intent.putExtra("materia", materia);
                startActivity(intent);
            }
        });


    }
}
