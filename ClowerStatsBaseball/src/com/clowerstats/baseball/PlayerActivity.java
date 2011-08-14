package com.clowerstats.baseball;

import java.io.InputStream;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
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
				TableLayout tl = (TableLayout) findViewById(R.id.playerLayout);
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
					tv = new TextView(this);
					tv.setText(scanner.next());
					tv.setTextSize(18);
					tv.setTextColor(Color.BLACK);
					tv.setPadding(5, 2, 5, 2);
					tr.addView(tv);
				}
				
				tl.addView(tr);
			}
			catch(Exception e)
			{
				//Do nothing
			}
				for(int i = 0; i <NUM_COLUMNS - 2; i++)
				{
					Scanner scanner
					scanner.next();
				}
				int predSal = scanner.nextInt();
				int sal = scanner.nextInt();
				if(sal < predSal)
				{
					Log.v("ClowerStats","Underpaid");
				}
				else if(sal == predSal)
				{
					Log.v("ClowerStats","Correctly Paid");
				}
				else
				{
					Log.v("ClowerStats","Overpaid");
				}
					
		}
	}
}
