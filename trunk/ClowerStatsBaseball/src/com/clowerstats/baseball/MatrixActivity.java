package com.clowerstats.baseball;

import java.io.InputStream;
import java.util.Scanner;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MatrixActivity extends Activity
{
	private final static int NUM_COLUMNS = 21;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.matrix);
		Intent intent = getIntent();
		String type = intent.getStringExtra("type");
		Log.v("ClowerStats", "Type: " + type);
		AssetManager assetManager = getAssets();
		try
		{
			InputStream is = assetManager.open("firstsaltest.txt");
			TableLayout tl = (TableLayout) findViewById(R.id.matrixLayout);
			
			if(type.equals("position"))
			{
				Log.v("ClowerStats", "Type: position");
				String pos = intent.getStringExtra("position");
				Scanner scanner = new Scanner(is);
				while(scanner.hasNext())
				{
					String lName = scanner.next();
					String fInitial = scanner.next();
					String team = scanner.next();
					String playerPos = scanner.next();
					if(pos.equals(playerPos))
					{
						TableRow tr = new TableRow(this);
						TextView tv = new TextView(this);
						tv.setText(lName + ", " + fInitial);
						tr.addView(tv);
						tv = new TextView(this);
						tv.setText(team);
						tr.addView(tv);
						tv = new TextView(this);
						tv.setText(playerPos);
						tr.addView(tv);
						for(int i = 0; i < NUM_COLUMNS - 3; i++)
						{
							tv = new TextView(this);
							tv.setText(scanner.next());
							tr.addView(tv);
						}
						tl.addView(tr);
					}
					else
					{
						for(int i = 0; i < NUM_COLUMNS - 3; i++)
						{
							scanner.next();
						}
					}
				}
			}
			else if(type.equals("team"))
			{
				Log.v("ClowerStats", "Type: team");
				String team = intent.getStringExtra("team");
				Scanner scanner = new Scanner(is);
				while(scanner.hasNext())
				{
					String lName = scanner.next();
					String fInitial = scanner.next();
					String playerTeam = scanner.next();
					if(team.equals(playerTeam))
					{
						TableRow tr = new TableRow(this);
						TextView tv = new TextView(this);
						tv.setText(lName + ", " + fInitial);
						tr.addView(tv);
						tv = new TextView(this);
						tv.setText(team);
						tr.addView(tv);
						for(int i = 0; i < NUM_COLUMNS - 2; i++)
						{
							tv = new TextView(this);
							tv.setText(scanner.next());
							tr.addView(tv);
						}
						tl.addView(tr);
					}
					else
					{
						for(int i = 0; i < NUM_COLUMNS - 2; i++)
						{
							scanner.next();
						}
					}
				}
			}
			else
			{
				Log.v("ClowerStats", "Type: player");
				String player = intent.getStringExtra("player");
				Log.v("ClowerStats", "Search: " + player);
				Scanner scanner = new Scanner(is);
				while(scanner.hasNext())
				{
					String lName = scanner.next();
					String fInitial = scanner.next();
					Log.v("ClowerStats", "Testing: lName = " + lName + " and player = " + player);
					if(lName.toLowerCase().contains(player.toLowerCase()))
					{
						Log.v("ClowerStats", "Matched!");
						TableRow tr = new TableRow(this);
						TextView tv = new TextView(this);
						tv.setText(lName + ", " + fInitial);
						tr.addView(tv);
						for(int i = 0; i < NUM_COLUMNS - 1; i++)
						{
							tv = new TextView(this);
							tv.setText(scanner.next());
							tr.addView(tv);
						}
						tl.addView(tr);
					}
					else
					{
						for(int i = 0; i < NUM_COLUMNS - 1; i++)
						{
							scanner.next();
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			//TODO: Error msg
		}
	}
}
