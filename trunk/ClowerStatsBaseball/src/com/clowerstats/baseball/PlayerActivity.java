package com.clowerstats.baseball;

import java.io.InputStream;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PlayerActivity extends Activity
{
	private final static int NUM_COLUMNS = 21;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player);
		
		Intent intent = getIntent();
		int id = intent.getIntExtra("id", -1);
		if(id != -1)
		{
			//Successfully retrieved id
			AssetManager assetManager = getAssets();
			try
			{
				double predSal = 0.0, sal = 0.0;
				InputStream is = assetManager.open("firstsaltest.txt");
				int curr = 0;
				while(curr < id)
				{
					if(is.read() == '\n')
					{
						curr++;
					}
				}
				Scanner scanner = new Scanner(is);
				TableLayout tl = (TableLayout) findViewById(R.id.playerTableLayout);
				TableRow tr = new TableRow(this);
				
				String lName = scanner.next();
				String fInitial = scanner.next();
				TextView tv = new TextView(this);
				tv.setText(lName + ", " + fInitial);
				tv.setTextSize(18);
				tv.setTextColor(Color.BLACK);
				tv.setPadding(5, 2, 5, 2);
				tr.addView(tv);
				
				for(int i = 0; i < NUM_COLUMNS - 1; i++)
				{
					if(i == 19) //Player value column
					{
						predSal = scanner.nextDouble();
						tv = new TextView(this);
						tv.setText(Double.toString(predSal));
						tv.setTextSize(18);
						tv.setTextColor(Color.BLACK);
						tv.setPadding(5, 2, 5, 2);
						tr.addView(tv);
					}
					else if(i == 18) //Salary column
					{
						sal = scanner.nextDouble();
						tv = new TextView(this);
						tv.setText(Double.toString(sal));
						tv.setTextSize(18);
						tv.setTextColor(Color.BLACK);
						tv.setPadding(5, 2, 5, 2);
						tr.addView(tv);
					}
					else
					{
						tv = new TextView(this);
						tv.setText(scanner.next());
						tv.setTextSize(18);
						tv.setTextColor(Color.BLACK);
						tv.setPadding(5, 2, 5, 2);
						tr.addView(tv);
					}
				}
				
				tl.addView(tr);

				tv = (TextView) findViewById(R.id.playerSalState);
				if(sal < predSal)
				{
					tv.setText("Underpaid");
					tv.setTextColor(Color.RED);
					//Log.v("ClowerStats", "Underpaid");
				}
				else if(sal == predSal)
				{
					tv.setText("Perfect");
					tv.setTextColor(Color.BLUE);
					//Log.v("ClowerStats", "Perfect");
				}
				else
				{
					tv.setText("Overpaid");
					tv.setTextColor(Color.GREEN);
					//Log.v("ClowerSxtats", "Overpaid");
				}
			}
			catch(Exception e)
			{
				//Do nothing
			}
		}
	}
}
