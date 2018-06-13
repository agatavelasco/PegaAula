package br.ufms.facom.pegaaulaapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufms.facom.pegaaulaapp.adapter.ProfessorAdapter;
import br.ufms.facom.pegaaulaapp.model.ProfessorSubstituto;

public class ListaProfessorActivity extends AppCompatActivity {

    ListView listViewProfessores;
    List<ProfessorSubstituto> professores;
    List<ProfessorSubstituto> professoresFilter;
    private ProfessorAdapter professorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_professor);
        professores = new ArrayList<>();
        professoresFilter = new ArrayList<>();

        professores.add(new ProfessorSubstituto("Maria de Oliveira", "Matemática", null, "67 99817-9887", 45, "Vespertino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("José Felipe Almeida", "Física", null, "67 98477-6700", 45, "Noturno", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Marjory Carla Toledo", "Espanhol", null, "67 99205-6666", 26, "Matutino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Maycon Renato Lisboa", "Matemática", null, "67 99120-4062", 28, "Vespertino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Benvinda Francisca de Oliveira", "Sociologia", null, "67 98417-0000", 45, "Vespertino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Joana Neves Palmeira", "Gramática", null, "67 98401-0667", 32, "Noturno", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Josiel Torres", "Biologia", null, "67 98417-9887", 35, "Matutino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Josefa Farias", "Literatura", null, "67 99817-8766", 40, "Vespertino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Tiago Toledo", "História", null, "67 99112-2100", 33, "Matutino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Renato Palmeira Lisboa", "Química", null, "67 98106-4537", 42, "Noturno", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Rosangela Neves", "Matemática", null, "67 99417-9587", 45, "Vespertino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Maria Inez Souza", "Química", null, "67 99817-9887", 53, "Matutino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("José Augusto Palmenra", "História", null, "67 99817-9887", 45, "Vespertino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Maria Eduarda Galhano", "Artes", null, "67 99217-6767", 31, "Matutino", R.drawable.ic ));
        professores.add(new ProfessorSubstituto("Jaqueline Alves", "Filosofia", null, "67 99457-7231", 29, "Vespertino", R.drawable.ic ));

        listViewProfessores = findViewById(R.id.listview);
        Intent intent = getIntent();

        String periodo = intent.getStringExtra("periodo");
        String materia = intent.getStringExtra("materia");

        for (ProfessorSubstituto p: professores) {
            if(p.getPeriodo().equals(periodo) && p.getMateria().equals(materia)){
                professoresFilter.add(p);
            }
        }

        professorAdapter = new ProfessorAdapter(ListaProfessorActivity.this, professores);
        listViewProfessores.setAdapter(professorAdapter);

        //Toast.makeText(this, "Materia: "+materia+"\nPeriodo: "+periodo, Toast.LENGTH_SHORT).show();
    }
}
