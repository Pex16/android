package com.example.gcioffi.helloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import database.DbAdapter;

public class RegisterActivity extends AppCompatActivity {

    // UI References
    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mRptPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mRptPasswordView = (EditText) findViewById(R.id.repeat_password);

    }

    public boolean isValid(String psw) {
        boolean cond = false;
        if(psw.length() > 4)
            cond = true;
        return cond;
    }

    public boolean checkSamePsw(String psw, String rpsw) {
        boolean cond = false;
        if(psw.equals(rpsw))
            cond = true;
        return cond;
    }

    public void attemptRegistration(View view) {

        String email = mEmailView.getText().toString();
        String psw = mPasswordView.getText().toString();
        String rpsw = mRptPasswordView.getText().toString();
        Log.i("Email: ", email);
        Log.i("Password: ", psw);
        Log.i("Ripetizione Password: ", rpsw);

        boolean cancel = true;

        // Check if the password is correct
        if (!isValid(psw) || !checkSamePsw(psw, rpsw)) {
            Log.d("Password: ", "non valida");
            cancel = false;
        }

        if (cancel) {
            registerUser(email, psw);
        } else {
            new AlertDialog.Builder(RegisterActivity.this)
                    .setMessage("Le due password devono coincidere.")
                    .setPositiveButton("Riprova", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                            startActivity(i);
                        }
                    })
                    .show();
        }
    }

    public void registerUser(String email, String psw) {

        DbAdapter dbHelper = new DbAdapter(getApplicationContext());
        dbHelper.open();
        Log.d("Adroid: ", "Connessione al database creata");
        dbHelper.createContact(email, psw);
        Log.d("Android: ", "Utente registrato");
        dbHelper.close();
        Log.d("Adroid: ", "Connessione al database chiusa");

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

}
