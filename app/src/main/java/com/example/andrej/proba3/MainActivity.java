package com.example.andrej.proba3;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static Post post;
    List<Post> postovip = null;
    ArrayAdapter<Post> adapter1p = null;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch(requestCode) {
            case (1) : {
                if (resultCode == Activity.RESULT_OK) {
                    post = new Post(
                            intent.getStringExtra(editPost.IME),
                            intent.getStringExtra(editPost.FAKULTET),
                            R.drawable.froot,
                            intent.getStringExtra(editPost.TEKST));
                    postovip.add(post);
                    adapter1p.notifyDataSetChanged();


                }
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button sendBtn = (Button)findViewById(R.id.sendBtn);
        final EditText msgText = (EditText) findViewById(R.id.msgText);
        final ListView msgList = (ListView)findViewById(R.id.msgList);


        //Nova lista
        final List<Post> postovi = new LinkedList<>();
        final ArrayAdapter<Post> adapter1 = new ArrayAdapter<Post>(
                this, R.layout.post_layout, postovi
        ){
            @NonNull
            @Override
            public View getView(int position, View view, ViewGroup parent) {
                if(view==null){
                    view=getLayoutInflater().inflate(R.layout.post_layout,parent,false);
                }
                Post post = postovi.get(position);
                ((ImageView)view.findViewById(R.id.postImage)).setImageResource(R.drawable.froot);
                ((TextView)view.findViewById(R.id.postName)).setText(post.getIme());
                ((TextView)view.findViewById(R.id.postDesc)).setText(post.getFakultet());
                ((TextView)view.findViewById(R.id.postText)).setText(post.getTekst());
                return view;
            }
        };
        msgList.setAdapter(adapter1);
        postovip=postovi;adapter1p=adapter1; //reference na postovi i adapter za outside

        //Floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, editPost.class);
                startActivityForResult(intent,1);

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
