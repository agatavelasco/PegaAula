package br.ufms.facom.pegaaulaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.ufms.facom.pegaaulaapp.bdhelper.BDHelper;

public class LoginActivity extends AppCompatActivity {

    BDHelper bd;
    Button btnEntrar;
    TextView tvRegistrar;
    EditText etEmail;
    EditText etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bd = new BDHelper(LoginActivity.this);
        btnEntrar = findViewById(R.id.btn_entrar);
        tvRegistrar = findViewById(R.id.lv_entrar);
        etEmail = findViewById(R.id.edt_login);
        etSenha = findViewById(R.id.edt_password);

        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bd.buscarProfessorPorLogin();

                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
