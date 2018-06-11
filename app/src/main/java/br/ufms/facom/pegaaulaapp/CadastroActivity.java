package br.ufms.facom.pegaaulaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ufms.facom.pegaaulaapp.bdhelper.BDHelper;

public class CadastroActivity extends AppCompatActivity {

    BDHelper bd;
    Button btnCadastrar;
    EditText edtNome;
    EditText edtCpf;
    EditText edtIdade;
    EditText edtEmail;
    EditText edtSenha1;
    EditText edtSenha2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        bd = new BDHelper(CadastroActivity.this);

        btnCadastrar = findViewById(R.id.btn_cadastrar);
        edtNome = findViewById(R.id.edt_nome);
        edtCpf = findViewById(R.id.edt_cpf);
        edtIdade = findViewById(R.id.edt_idade);
        edtEmail = findViewById(R.id.edt_email);
        edtSenha1 = findViewById(R.id.edt_senha1);
        edtSenha2 = findViewById(R.id.edt_senha2);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
