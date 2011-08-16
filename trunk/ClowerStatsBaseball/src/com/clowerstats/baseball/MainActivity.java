package com.clowerstats.baseball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Spinner positionSpinner = (Spinner) findViewById(R.id.positionSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.positionArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        positionSpinner.setAdapter(adapter);
        
        Spinner teamSpinner = (Spinner) findViewById(R.id.teamSpinner);
        adapter = ArrayAdapter.createFromResource(
                        this, R.array.teamArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamSpinner.setAdapter(adapter);
        
        positionSpinner.setOnItemSelectedListener(new OnPositionSelectedListener());
        teamSpinner.setOnItemSelectedListener(new OnTeamSelectedListener());
              
        Button button = (Button) findViewById(R.id.searchButton);
        
        button.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                        EditText et = (EditText) findViewById(R.id.searchBar);
                        Intent intent = new Intent(MainActivity.this, MatrixActivity.class);
                        intent.putExtra("type", "player");
                        intent.putExtra("player", et.getText().toString());
                        startActivity(intent);
                        }
                });
        
        
        
    }
    
        
        
        
    public class OnPositionSelectedListener implements OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        {
                if(pos != 0)
                {
                        Intent intent = new Intent(MainActivity.this, MatrixActivity.class);
                        intent.putExtra("type", "position");
                        intent.putExtra("position", parent.getItemAtPosition(pos).toString());
                        startActivity(intent);
                }
        }

        public void onNothingSelected(AdapterView<?> parent)
        {
          // Do nothing.
        }
    }
    public class OnTeamSelectedListener implements OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        {
                if(pos != 0)
                {
                        Intent intent = new Intent(MainActivity.this, MatrixActivity.class);
                        intent.putExtra("type", "team");
                        intent.putExtra("team", parent.getItemAtPosition(pos).toString());
                        startActivity(intent);
                }
        }

        public void onNothingSelected(AdapterView<?> parent)
        {
          // Do nothing.
        }
    }
}