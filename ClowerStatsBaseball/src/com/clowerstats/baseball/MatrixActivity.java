package com.clowerstats.baseball;

import java.io.InputStream;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;



public class MatrixActivity extends Activity
{
        private final static int NUM_COLUMNS = 22;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.matrix);
                Intent intent = getIntent();
                String type = intent.getStringExtra("type");
                
                AssetManager assetManager = getAssets();
                try
                {
                        InputStream is = assetManager.open("firstsaltest.txt");
                        TableLayout tl = (TableLayout) findViewById(R.id.matrixLayout);
                        
                        if(type.equals("position"))
                        {
                                
                                String pos = intent.getStringExtra("position");
                                Scanner scanner = new Scanner(is);
                                int id = 0;
                                while(scanner.hasNext())
                                {
                                        String lName = scanner.next();
                                        String fInitial = scanner.next();
                                        String team = scanner.next();
                                        String playerPos = scanner.next();
                                        
                                        if(playerPos.equals("SP"))
                                        {
                                        	if(pos.equals(playerPos))
                                        {
                                        	TableRow tr = new TableRow(this);
                                        	TextView tv = new TextView(this);
                                        	tv.setText(lName + ", " + fInitial);
                                        	tv.setTextSize(18);
                                        	tv.setTextColor(Color.BLACK);
                                            tv.setPadding(5, 2, 5, 2);
                                            tr.addView(tv);
                                            
                                            tv = new TextView(this);
                                            tv.setText(team);
                                            tv.setTextSize(18);
                                            tv.setTextColor(Color.BLACK);
                                            tv.setPadding(5, 2, 5, 2);
                                            tr.addView(tv);
                                            
                                            tv = new TextView(this);
                                            tv.setText(playerPos);
                                            tv.setTextSize(18);
                                            tv.setTextColor(Color.BLACK);
                                            tv.setPadding(5, 2, 5, 2);
                                            tr.addView(tv);
                                            
                                            for (int i=0; i < NUM_COLUMNS -3; i ++)
                                            {
                                                scanner.next();
                                        }
                                        
                                        tr.setClickable(true);
                                        final int tempId = id;
                                        tr.setOnClickListener(new View.OnClickListener()
                                        {
                                                @Override
                                                public void onClick(View v)
                                                {
                                                        Intent intent = new Intent(MatrixActivity.this, PitcherActivity.class);
                                                        intent.putExtra("id", tempId); //????
                                                        startActivity(intent);
                                                }
                                        });
                                        tl.addView(tr);
                                }
                                    
                                        	
                                        }
                                        else if(pos.equals(playerPos))
                                        {
                                                TableRow tr = new TableRow(this);
                                                TextView tv = new TextView(this);
                                                tv.setText(lName + ", " + fInitial);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(team);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(playerPos);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                for(int i = 0; i < NUM_COLUMNS - 3; i++)
                                                {
                                                        scanner.next();
                                                }
                                                
                                                tr.setClickable(true);
                                                final int tempId = id;
                                                tr.setOnClickListener(new View.OnClickListener()
                                                {
                                                        @Override
                                                        public void onClick(View v)
                                                        {
                                                                Intent intent = new Intent(MatrixActivity.this, PlayerActivity.class);
                                                                intent.putExtra("id", tempId); //????
                                                                startActivity(intent);
                                                        }
                                                });
                                                tl.addView(tr);
                                        }
                                        else
                                        {
                                                for(int i = 0; i < NUM_COLUMNS - 3; i++)
                                                {
                                                        scanner.next();
                                                }
                                        }
                                        
                                        id++;
                                }
                        }
                        else if(type.equals("team"))
                        {
                               
                                String team = intent.getStringExtra("team");
                                Scanner scanner = new Scanner(is);
                                int id = 0;
                                while(scanner.hasNext())
                                {
                                        String lName = scanner.next();
                                        String fInitial = scanner.next();
                                        String playerTeam = scanner.next();
                                        if(team.equals(playerTeam))
                                        {
                                        	String playerPos = scanner.next();
                                        	if(playerPos.equals("SP"))
                                        	{
                                                TableRow tr = new TableRow(this);
                                                TextView tv = new TextView(this);
                                                tv.setText(lName + ", " + fInitial);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(team);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(playerPos);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);

                                                for(int i = 0; i < NUM_COLUMNS - 3; i++)
                                                {
                                                        scanner.next();
                                                }
                                                
                                                tr.setClickable(true);
                                                final int tempId = id;
                                                tr.setOnClickListener(new View.OnClickListener()
                                                {
                                                        @Override
                                                        public void onClick(View v)
                                                        {
                                                                Intent intent = new Intent(MatrixActivity.this, PitcherActivity.class);
                                                                intent.putExtra("id", tempId); //????
                                                                startActivity(intent);
                                                        }
                                                });
                                                
                                                tl.addView(tr);
                                        }
                                        	else {
                                        		TableRow tr = new TableRow(this);
                                                TextView tv = new TextView(this);
                                                tv.setText(lName + ", " + fInitial);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(team);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(playerPos);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);

                                                for(int i = 0; i < NUM_COLUMNS - 3; i++)
                                                {
                                                        scanner.next();
                                                }
                                                
                                                tr.setClickable(true);
                                                final int tempId = id;
                                                tr.setOnClickListener(new View.OnClickListener()
                                                {
                                                        @Override
                                                        public void onClick(View v)
                                                        {
                                                                Intent intent = new Intent(MatrixActivity.this, PlayerActivity.class);
                                                                intent.putExtra("id", tempId); //????
                                                                startActivity(intent);
                                                        }
                                                });
                                                
                                                tl.addView(tr);
                                        }
                                        	}
                                        else
                                        {
                                                for(int i = 0; i < NUM_COLUMNS - 2; i++)
                                                {
                                                        scanner.next();
                                                }
                                        }
                                        
                                        id++;
                                }
                        }
                        else
                        {
                               
                                String player = intent.getStringExtra("player");
                                
                                Scanner scanner = new Scanner(is);
                                int id = 0;
                                while(scanner.hasNext())
                                {
                                        String lName = scanner.next();
                                        String fInitial = scanner.next();
                                        
                                        if(lName.toLowerCase().contains(player.toLowerCase()))
                                        {
                                        	String team = scanner.next();
                                        	String playerPos = scanner.next();
                                        	if(playerPos.equals("SP"))
                                        	{
                                        	
                                                
                                                TableRow tr = new TableRow(this);
                                                TextView tv = new TextView(this);
                                                tv.setText(lName + ", " + fInitial);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(team);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);
                                                
                                                tv = new TextView(this);
                                                tv.setText(playerPos);
                                                tv.setTextSize(18);
                                                tv.setTextColor(Color.BLACK);
                                                tv.setPadding(5, 2, 5, 2);
                                                tr.addView(tv);

                                                for(int i = 0; i < NUM_COLUMNS - 3; i++)
                                                {
                                                        scanner.next();
                                                }
                                                
                                                tr.setClickable(true);
                                                final int tempId = id;
                                                tr.setOnClickListener(new View.OnClickListener()
                                                {
                                                        @Override
                                                        public void onClick(View v)
                                                        {
                                                                Intent intent = new Intent(MatrixActivity.this, PitcherActivity.class);
                                                                intent.putExtra("id", tempId); //????
                                                                startActivity(intent);
                                                        }
                                                });

                                                tl.addView(tr);
                                        }
                                        	else
                                        	{
                                            TableRow tr = new TableRow(this);
                                            TextView tv = new TextView(this);
                                            tv.setText(lName + ", " + fInitial);
                                            tv.setTextSize(18);
                                            tv.setTextColor(Color.BLACK);
                                            tv.setPadding(5, 2, 5, 2);
                                            tr.addView(tv);
                                            
                                            tv = new TextView(this);
                                            tv.setText(team);
                                            tv.setTextSize(18);
                                            tv.setTextColor(Color.BLACK);
                                            tv.setPadding(5, 2, 5, 2);
                                            tr.addView(tv);
                                            
                                            tv = new TextView(this);
                                            tv.setText(playerPos);
                                            tv.setTextSize(18);
                                            tv.setTextColor(Color.BLACK);
                                            tv.setPadding(5, 2, 5, 2);
                                            tr.addView(tv);

                                            for(int i = 0; i < NUM_COLUMNS - 3; i++)
                                            {
                                                    scanner.next();
                                            }
                                            
                                            tr.setClickable(true);
                                            final int tempId = id;
                                            tr.setOnClickListener(new View.OnClickListener()
                                            {
                                                    @Override
                                                    public void onClick(View v)
                                                    {
                                                            Intent intent = new Intent(MatrixActivity.this, PlayerActivity.class);
                                                            intent.putExtra("id", tempId); //????
                                                            startActivity(intent);
                                                    }
                                            });

                                            tl.addView(tr);
                                    }
                                        }
                                        else
                                        {
                                                for(int i = 0; i < NUM_COLUMNS - 1; i++)
                                                {
                                                        scanner.next();
                                                }
                                        }
                                        
                                        id++;
                                }
                        }
                }
                catch(Exception e)
                {
                        //TODO: Error msg
                }
        }
}