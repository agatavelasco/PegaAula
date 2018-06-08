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
            "(funcId integer primary key autoincrement, cargoFk integer, funcNome text not null, salario " +
            "text not null, FOREIGN KEY(cargoFk) REFERENCES cargo(cargoId));";


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
        values.put(COLUNA_TIPO_PROFESSOR,professor.getTipoProfessor());
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
                COLUNA_TIPO_PROFESSOR,
                COLUNA_CPF_PROFESSOR,
                COLUNA_EMAIL_PROFESSOR,
                COLUNA_SENHA_PROFESSOR
        };
        Cursor cursor = getWritableDatabase().query(TABLE_PROFESSOR,
                coluns,null,null,null,
                null,"upper(funcNome)",null);
        List<Professor> listaProfessores = new ArrayList<Professor>();
        while(cursor.moveToNext()){
            Professor p = new Professor();
            p.setIdProfessor(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setCpf(cursor.getString(2));
            p.getEmail(cursor.getString(3))


            listaFuncionario.add(f);
        }
        return listaFuncionario;
    }

    public long excluirFuncionario(Funcionario f) {
        long retornoBD;
        bd = this.getWritableDatabase();
        String[] args = {String.valueOf(f.getIdFuncionario())};
        retornoBD=bd.delete(TABLE_FUNCIONARIO, COLUNA_ID_FUNCIONARIO+"=?",args);
        return retornoBD;
    }

    public long alterarPessoa(Funcionario f){
        long retornoBD;
        bd = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME_FUNCIONARIO,f.getNome());
        values.put(COLUNA_SALARIO,f.getSalario());

        String[] args = {String.valueOf(f.getIdFuncionario())};
        retornoBD=bd.update(TABLE_FUNCIONARIO,values,"funcId=?",args);
        bd.close();
        return retornoBD;
    }

    public List<Cargo> buscarTodosCargos() {
        String[] coluns={COLUNA_ID_CARGO, COLUNA_NOME_CARGO};
        Cursor cursor = getWritableDatabase().query(TABLE_CARGO,
                coluns,null,null,null,
                null,"upper(cargoNome)",null);
        List<Cargo> listaCargos = new ArrayList<Cargo>();
        while(cursor.moveToNext()){
            Cargo c = new Cargo();
            c.setIdCargo(cursor.getInt(0));
            c.setNomeCargo(cursor.getString(1));

            listaCargos.add(c);
        }
        return listaCargos;
    }
}
