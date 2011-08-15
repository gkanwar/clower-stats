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
        private final static int NUM_COLUMNS = 22;
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
                                double predSal = 0.0, sal = 0.0, posit = 0.0;
                                double pitch = 1.0, catcher = 1.0, firstb= 3.0, secondb= 1.74, thirdb = 2.7,
                                		shortstop = 1.16, leftf = 3.14 , centerf = 1.78, rightf = 3.15;
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
                                	if(i == 20)
                                	{
                                		posit = scanner.nextDouble();
                                		tv = new TextView(this);
                                		tv.setText(Double.toString(predSal));
                                		
                                		
                                		
                                	}
                                	else if(i == 19) //Player value column
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
                               
                                if(posit == 1)
                               {
                            	   
                                if(sal < predSal - pitch)
                                {
                                        tv.setText("Undervalued");
                                        tv.setTextColor(Color.RED);
                                        //Log.v("ClowerStats", "Undervalued");
                                }
                                else if(sal > predSal - pitch && sal < predSal + pitch)
                                {
                                        tv.setText("Well Valued");
                                        tv.setTextColor(Color.BLUE);
                                        //Log.v("ClowerStats", "Well Valued");
                                }
                                else
                                {
                                        tv.setText("Overvalued");
                                        tv.setTextColor(Color.GREEN);
                                        //Log.v("ClowerSxtats", "Overvalued");
                                }
                               }
                               else if(posit == 2)
                               {
                            	   if(sal < predSal - catcher)
                                   {
                                           tv.setText("Undervalued");
                                           tv.setTextColor(Color.RED);
                                           //Log.v("ClowerStats", "Undervalued");
                                   }
                                   else if(sal > predSal - catcher && sal < predSal + catcher)
                                   {
                                           tv.setText("Well Valued");
                                           tv.setTextColor(Color.BLUE);
                                           //Log.v("ClowerStats", "Well Valued");
                                   }
                                   else
                                   {
                                           tv.setText("Overvalued");
                                           tv.setTextColor(Color.GREEN);
                                           //Log.v("ClowerSxtats", "Overvalued");
                                   }
                                  }
                               else if(posit == 3)
                               { 
                            	   if(sal < predSal - firstb )
                               {
                                   tv.setText("Undervalued");
                                   tv.setTextColor(Color.RED);
                                   //Log.v("ClowerStats", "Undervalued");
                           }
                           else if(sal > predSal - firstb && sal < predSal + firstb)
                           {
                                   tv.setText("Well Valued");
                                   tv.setTextColor(Color.BLUE);
                                   //Log.v("ClowerStats", "Well Valued");
                           }
                           else
                           {
                                   tv.setText("Overvalued");
                                   tv.setTextColor(Color.GREEN);
                                   //Log.v("ClowerSxtats", "Overvalued");
                           }
                          }
                               else if(posit == 4)
                               { 
                            	   if(sal < predSal - secondb)
                               {
                                   tv.setText("Undervalued");
                                   tv.setTextColor(Color.RED);
                                   //Log.v("ClowerStats", "Undervalued");
                           }
                           else if(sal > predSal - secondb && sal < predSal + secondb)
                           {
                                   tv.setText("Well Valued");
                                   tv.setTextColor(Color.BLUE);
                                   //Log.v("ClowerStats", "Well Valued");
                           }
                           else
                           {
                                   tv.setText("Overvalued");
                                   tv.setTextColor(Color.GREEN);
                                   //Log.v("ClowerSxtats", "Overvalued");
                           }
                          }
                               else if(posit == 5)
                               { 
                            	   if(sal < predSal - thirdb )
                               {
                                   tv.setText("Undervalued");
                                   tv.setTextColor(Color.RED);
                                   //Log.v("ClowerStats", "Undervalued");
                           }
                           else if(sal > predSal - thirdb && sal < predSal + thirdb)
                           {
                                   tv.setText("Well Valued");
                                   tv.setTextColor(Color.BLUE);
                                   //Log.v("ClowerStats", "Well Valued");
                           }
                           else
                           {
                                   tv.setText("Overvalued");
                                   tv.setTextColor(Color.GREEN);
                                   //Log.v("ClowerSxtats", "Overvalued");
                           }
                          }
                               else if(posit == 6)
                               { 
                            	   if(sal < predSal - shortstop)
                               {
                                   tv.setText("Undervalued");
                                   tv.setTextColor(Color.RED);
                                   //Log.v("ClowerStats", "Undervalued");
                           }
                           else if(sal > predSal - shortstop && sal < predSal + shortstop)
                           {
                                   tv.setText("Well Valued");
                                   tv.setTextColor(Color.BLUE);
                                   //Log.v("ClowerStats", "Well Valued");
                           }
                           else
                           {
                                   tv.setText("Overvalued");
                                   tv.setTextColor(Color.GREEN);
                                   //Log.v("ClowerSxtats", "Overvalued");
                           }
                          }
                               else if(posit == 7)
                               { 
                            	   if(sal < predSal - leftf )
                               {
                                   tv.setText("Undervalued");
                                   tv.setTextColor(Color.RED);
                                   //Log.v("ClowerStats", "Undervalued");
                           }
                           else if(sal > predSal - leftf && sal < predSal + leftf)
                           {
                                   tv.setText("Well Valued");
                                   tv.setTextColor(Color.BLUE);
                                   //Log.v("ClowerStats", "Well Valued");
                           }
                           else
                           {
                                   tv.setText("Overvalued");
                                   tv.setTextColor(Color.GREEN);
                                   //Log.v("ClowerSxtats", "Overvalued");
                           }
                          }
                               else if(posit == 8)
                               { 
                            	   if(sal < predSal - centerf )
                               {
                                   tv.setText("Undervalued");
                                   tv.setTextColor(Color.RED);
                                   //Log.v("ClowerStats", "Undervalued");
                           }
                           else if(sal > predSal - centerf && sal < predSal + centerf)
                           {
                                   tv.setText("Well Valued");
                                   tv.setTextColor(Color.BLUE);
                                   //Log.v("ClowerStats", "Well Valued");
                           }
                           else
                           {
                                   tv.setText("Overvalued");
                                   tv.setTextColor(Color.GREEN);
                                   //Log.v("ClowerSxtats", "Overvalued");
                           }
                          }
                               else if(posit == 9)
                               { 
                            	   if(sal < predSal - rightf )
                               {
                                   tv.setText("Undervalued");
                                   tv.setTextColor(Color.RED);
                                   //Log.v("ClowerStats", "Undervalued");
                           }
                           else if(sal > predSal - rightf && sal < predSal + rightf)
                           {
                                   tv.setText("Well Valued");
                                   tv.setTextColor(Color.BLUE);
                                   //Log.v("ClowerStats", "Well Valued");
                           }
                           else
                           {
                                   tv.setText("Overvalued");
                                   tv.setTextColor(Color.GREEN);
                                   //Log.v("ClowerSxtats", "Overvalued");
                           }
                          }
                               }
                        
                        
                        catch(Exception e)
                        {
                                //Do nothing
                        }
                }
        }
}