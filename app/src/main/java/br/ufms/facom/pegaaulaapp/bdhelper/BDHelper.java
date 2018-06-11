package br.ufms.facom.pegaaulaapp.bdhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.ufms.facom.pegaaulaapp.model.Professor;

public class BDHelper extends SQLiteOpenHelper {

    SQLiteDatabase bd;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "appdb";

    //tabelas
    private static final String TABLE_PROFESSOR = "professor";

    //colunas da tabela professor
    private static final String COLUNA_ID_PROFESSOR = "id_professor";
    private static final String COLUNA_NOME_PROFESSOR = "nome_professor";
    private static final String COLUNA_CPF_PROFESSOR = "cpf_professor";
    private static final String COLUNA_IDADE_PROFESSOR = "idade_professor";
    private static final String COLUNA_EMAIL_PROFESSOR = "email_professor";
    private static final String COLUNA_SENHA_PROFESSOR = "senha_professor";


    private static final String TABLE_CREATE_PROFESSOR = "create table professor " +
            "(id_professor integer primary key autoincrement, nome_professor text not null, cpf_professor " +
            "text not null, idade_professor integer, email_professor text, senha_professor text);";


    public BDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE_PROFESSOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABLE_PROFESSOR;
        bd.execSQL(sql);
        onCreate(bd);

        /*String sql2 = "DROP TABLE IS EXISTS "+TABLE_CARGO;
        bd.execSQL(sql2);
        onCreate(bd);*/
    }

    public long salvarProfessor(Professor professor) {

        long retornoBD;
        bd = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME_PROFESSOR,professor.getNome());
        values.put(COLUNA_CPF_PROFESSOR, professor.getCpf());
        values.put(COLUNA_IDADE_PROFESSOR,professor.getTipoProfessor());
        values.put(COLUNA_EMAIL_PROFESSOR, professor.getEmail());
        values.put(COLUNA_SENHA_PROFESSOR, professor.getSenha());

        retornoBD = bd.insert(TABLE_PROFESSOR,null,values);
        bd.close();

        return retornoBD;
    }



    public List<Professor> buscarTodosProfessor() {

        String[] coluns={COLUNA_ID_PROFESSOR,
                COLUNA_NOME_PROFESSOR,
                COLUNA_IDADE_PROFESSOR,
                COLUNA_CPF_PROFESSOR,
                COLUNA_EMAIL_PROFESSOR,
                COLUNA_SENHA_PROFESSOR
        };
        Cursor cursor = getWritableDatabase().query(TABLE_PROFESSOR,
                coluns,null,null,null,
                null,"upper(nome_professor)",null);
        List<Professor> listaProfessores = new ArrayList<Professor>();
        while(cursor.moveToNext()){
            Professor p = new Professor();
            p.setIdProfessor(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setCpf(cursor.getString(2));
            p.setIdade(cursor.getInt(3));
            p.setEmail(cursor.getString(4));
            p.setSenha(cursor.getString(5));

            listaProfessores.add(p);
        }
        return listaProfessores;
    }

    public long excluirProfessor(Professor p) {
        long retornoBD;
        bd = this.getWritableDatabase();
        String[] args = {String.valueOf(p.getIdProfessor())};
        retornoBD=bd.delete(TABLE_PROFESSOR, COLUNA_ID_PROFESSOR+"=?",args);
        return retornoBD;
    }

    public long alterarProfessor(Professor professor){
        long retornoBD;
        bd = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME_PROFESSOR,professor.getNome());
        values.put(COLUNA_CPF_PROFESSOR, professor.getCpf());
        values.put(COLUNA_IDADE_PROFESSOR,professor.getTipoProfessor());
        values.put(COLUNA_EMAIL_PROFESSOR, professor.getEmail());
        values.put(COLUNA_SENHA_PROFESSOR, professor.getSenha());


        String[] args = {String.valueOf(professor.getIdProfessor())};
        retornoBD=bd.update(TABLE_PROFESSOR,values,"id_professor=?",args);
        bd.close();
        return retornoBD;
    }


    public Professor buscarProfessorPorLogin(String email) {
        String[] coluns={COLUNA_ID_PROFESSOR,
                COLUNA_NOME_PROFESSOR,
                COLUNA_IDADE_PROFESSOR,
                COLUNA_CPF_PROFESSOR,
                COLUNA_EMAIL_PROFESSOR,
                COLUNA_SENHA_PROFESSOR
        };
        List<Professor> listaProfessores = new ArrayList<Professor>();
        String[] args = {String.valueOf(email)};
        Cursor cursor = getWritableDatabase().query(TABLE_PROFESSOR,
                coluns,null,args,null,
                null,"upper(nome_professor)",null);
        while(cursor.moveToNext()){
            Professor p = new Professor();
            p.setIdProfessor(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setCpf(cursor.getString(2));
            p.setIdade(cursor.getInt(3));
            p.setEmail(cursor.getString(4));
            p.setSenha(cursor.getString(5));
            listaProfessores.add(p);
        }

        return listaProfessores.get(0);
    }
}
