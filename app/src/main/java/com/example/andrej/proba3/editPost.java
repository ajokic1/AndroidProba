package com.example.andrej.proba3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editPost extends AppCompatActivity {

    public static final String IME = "com.example.andrej.proba3.editPostIme";
    public static final String FAKULTET = "com.example.andrej.proba3.editPostFakultet";
    public static final String TEKST = "com.example.andrej.proba3.editPostTekst";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        Button ok = (Button)findViewById(R.id.editPostBtn);
        final EditText ime = (EditText)findViewById(R.id.editPostIme);
        final EditText fakultet = (EditText)findViewById(R.id.editPostFakultet);
        final EditText tekst = (EditText)findViewById(R.id.editPostTekst);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(IME, ime.getText().toString());
                intent.putExtra(FAKULTET, fakultet.getText().toString());
                intent.putExtra(TEKST, tekst.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });

    }
}
