package com.clowerstats.baseball;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
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
    }
    
    public class OnPositionSelectedListener implements OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        {
        	
        }

        public void onNothingSelected(AdapterView parent)
        {
          // Do nothing.
        }
    }
    public class OnTeamSelectedListener implements OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        {
        	
        }

        public void onNothingSelected(AdapterView parent)
        {
          // Do nothing.
        }
    }
}