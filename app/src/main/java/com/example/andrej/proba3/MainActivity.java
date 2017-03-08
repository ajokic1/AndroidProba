package com.example.andrej.proba3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button sendBtn = (Button)findViewById(R.id.sendBtn);
        final EditText msgText = (EditText) findViewById(R.id.msgText);
        final ListView msgList = (ListView)findViewById(R.id.msgList);




        final List<ChatMessage> messages = new LinkedList<>();
        final ArrayAdapter<ChatMessage> adapter = new ArrayAdapter<ChatMessage>(
                this, android.R.layout.two_line_list_item, messages
        ){
            @NonNull
            @Override
            public View getView(int position, View view, ViewGroup parent) {
                if(view==null){
                    view=getLayoutInflater().inflate(android.R.layout.two_line_list_item,parent,false);
                }
                ChatMessage chat = messages.get(position);
                ((TextView)view.findViewById(android.R.id.text1)).setText(chat.getName());
                ((TextView)view.findViewById(android.R.id.text2)).setText(chat.getMessage());
                return view;
            }
        };
        msgList.setAdapter(adapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatMessage chat = new ChatMessage("andy", msgText.getText().toString());
                msgText.setText("");
                messages.add(chat);
                adapter.notifyDataSetChanged();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
