package com.example.rajkumar_vijayan.kidsbpscale;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    String companies[] = {"Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung"};
    String os[]       =  {"Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada"};

    TableLayout tl;
    TableRow tr;
    //TableRow tr50;

    TextView htperc,bp50th,bp90th,bp95th, bp99th;
    TextView companyTV,valueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        //this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String Age = "10";
        ArrayList<String[]> quotes = databaseAccess.getQuotes(Age);
        Log.d("DEBUG", quotes.toString());
        databaseAccess.close();

        tl = (TableLayout) findViewById(R.id.maintable);
        addHeaders();
        addData(quotes);

    }

    public void addHeaders(){

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        TextView htperc = new TextView(this);
        htperc.setText("HtPerc");
        htperc.setTextColor(Color.GRAY);
        htperc.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        htperc.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        htperc.setPadding(1, 1, 1, 1);
        tr.addView(htperc);  // Adding textView to table

        /** Creating a TextView to add to the row **/
        TextView bp50th = new TextView(this);
        bp50th.setText("BP50th");
        bp50th.setTextColor(Color.GRAY);
        bp50th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        bp50th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        bp50th.setPadding(1, 1, 1, 1);
        tr.addView(bp50th);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView bp90th = new TextView(this);
        bp90th.setText("BP90th");
        bp90th.setTextColor(Color.GRAY);
        bp90th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        bp90th.setPadding(1, 1, 1, 1);
        bp90th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(bp90th); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView bp95th = new TextView(this);
        bp95th.setText("BP95th");
        bp95th.setTextColor(Color.GRAY);
        bp95th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        bp95th.setPadding(1, 1, 1, 1);
        bp95th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(bp95th); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView bp99th = new TextView(this);
        bp99th.setText("BP99th");
        bp99th.setTextColor(Color.GRAY);
        bp99th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        bp99th.setPadding(1, 1, 1, 1);
        bp99th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(bp99th); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
//        tr = new TableRow(this);
//        tr.setLayoutParams(new LayoutParams(
//                LayoutParams.MATCH_PARENT,
//                LayoutParams.WRAP_CONTENT));

        /** Creating another textview **/
//        TextView divider = new TextView(this);
//        divider.setText("-----------------");
//        divider.setTextColor(Color.GREEN);
//        divider.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
//        divider.setPadding(4, 2, 2, 2);
//        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(divider); // Adding textView to tablerow.
//
//        TextView divider2 = new TextView(this);
//        divider2.setText("-------------------------");
//        divider2.setTextColor(Color.GREEN);
//        divider2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
//        divider2.setPadding(4, 2, 2, 2);
//        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(divider2); // Adding textView to tablerow.
//
//        TextView divider3 = new TextView(this);
//        divider3.setText("-------------------------");
//        divider3.setTextColor(Color.GREEN);
//        divider3.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
//        divider3.setPadding(4, 2, 2, 2);
//        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(divider3); // Adding textView to tablerow.
//
//        TextView divider4 = new TextView(this);
//        divider4.setText("-------------------------");
//        divider4.setTextColor(Color.GREEN);
//        divider4.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
//        divider4.setPadding(4, 2, 2, 2);
//        divider4.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        tr.addView(divider4); // Adding textView to tablerow.
//
//        // Add the TableRow to the TableLayout
//        tl.addView(tr, new TableLayout.LayoutParams(
//                LayoutParams.FILL_PARENT,
//                LayoutParams.WRAP_CONTENT));
    }

    /** This function add the data to the table **/
    public void addData(ArrayList<String[]> quotes){

        Log.d("DEBUG","INside addData");
        String [] perc = {"perc", "5th","10th","25th","50th","75th","90th","95th"};
         String [] bp50 = quotes.get(0);
        String [] bp90 = quotes.get(1);
        String [] bp95 = quotes.get(2);
        String [] bp99 = quotes.get(3);

        Log.d("DEBUG", bp50.toString());
        for (int i = 0; i < 8; i++)
        {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            htperc = new TextView(this);
            htperc.setText(perc[i]);
            htperc.setTextColor(Color.RED);
            htperc.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            htperc.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            htperc.setPadding(1, 1, 1, 1);
            tr.addView(htperc);  // Adding

            bp50th = new TextView(this);
            bp50th.setText(bp50[i]);
            bp50th.setTextColor(Color.RED);
            bp50th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            bp50th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            bp50th.setPadding(1, 1, 1, 1);
            tr.addView(bp50th);  // Adding

            /** Creating a TextView to add to the row **/
            bp90th = new TextView(this);
            bp90th.setText(bp90[i]);
            bp90th.setTextColor(Color.RED);
            bp90th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            bp90th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            bp90th.setPadding(1, 1, 1, 1);
            tr.addView(bp90th);  // Adding

            bp95th = new TextView(this);
            bp95th.setText(bp95[i]);
            bp95th.setTextColor(Color.RED);
            bp95th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            bp95th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            bp95th.setPadding(1, 1, 1, 1);
            tr.addView(bp95th);  // Adding

            bp99th = new TextView(this);
            bp99th.setText(bp99[i]);
            bp99th.setTextColor(Color.RED);
            bp99th.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            bp99th.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            bp99th.setPadding(1, 1, 1, 1);
            tr.addView(bp99th);  // Adding

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }
    }
}
