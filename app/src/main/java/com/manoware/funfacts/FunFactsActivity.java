package com.manoware.funfacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FunFactsActivity extends ActionBarActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private RelativeLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fun_facts);

        // Had to setup the ID in design mode
        mLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

        // Declare view variables
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int color = mColorWheel.getColor();

            // Update label
            factLabel.setText(mFactBook.getFact());
            mLayout.setBackgroundColor(color);
            showFactButton.setTextColor(color);
            }
        };

        showFactButton.setOnClickListener(listener);


        Toast.makeText(this, "Welcome Toast", Toast.LENGTH_LONG).show();

        Log.d(TAG, "Logging FromOnCreate");
    }

}
