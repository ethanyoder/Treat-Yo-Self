package exr.at.com.googlemapsapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import exr.at.com.googlemapsapi.MainActivity;
import exr.at.com.googlemapsapi.R;

public class Menu extends Activity {

    CheckBox food;
    CheckBox outdoors;
    CheckBox entertainment;
    CheckBox relaxation;
    RadioGroup distances;
    RadioGroup categories;
    final double METERS_TO_MILE = 1609.344;

    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.menu);
        categories = (RadioGroup) findViewById(R.id.categoryGroup);
        distances = (RadioGroup) findViewById(R.id.distanceGroup);
    }

    public void getSelfDate(View v) {
        Log.d("Button", "Clicked");
        Intent places = new Intent(this, MainActivity.class);
        getDistanceRadioValue(distances);
        places.putExtra("radius", getDistanceRadioValue(distances));
        places.putExtra("type", getCategoryRadioValue(categories));
        startActivity(places);
    }

    public double getDistanceRadioValue(RadioGroup rg) {
        int radioId = rg.indexOfChild(rg.findViewById(rg.getCheckedRadioButtonId()));
        RadioButton button = (RadioButton) rg.getChildAt(radioId);
        String selection = (String) button.getText();
        if (selection.equals("less than 5 miles")) {
            Log.d("Radio Button Text", selection);
            return 5 * METERS_TO_MILE;
        }
        else if (selection.equals("less than 15 miles")) {
            Log.d("Radio Button Text", selection);
            return 15 * METERS_TO_MILE;
        }
        else {
            Log.d("Radio Button Text", selection);
            return 30 * METERS_TO_MILE;
        }
    }

    public String getCategoryRadioValue(RadioGroup rg) {
        int radioId = rg.indexOfChild(rg.findViewById(rg.getCheckedRadioButtonId()));
        RadioButton button = (RadioButton) rg.getChildAt(radioId);
        String selection = (String) button.getText();
        if (selection.equals("Food")) {
            return "restaurant";
        }
        else if (selection.equals("Outdoors")) {
            return "park";
        }
        else if (selection.equals("Entertainment")){
            return "amusement_park";
        }
        else {
            return "cafe";
        }
    }

}
