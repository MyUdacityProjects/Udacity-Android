package com.example.android.androidcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    String countries[] = {"lego","reco","santa","promise","digital","seller"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindListeners();
    }

    public void bindListeners(){
        listenToToggleButtonEvents();

        AutoCompleteTextView teamAutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.teamSuggest);
        final ArrayAdapter<String> teamList = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,countries);
        teamAutoCompleteTextView.setThreshold(1);
        teamAutoCompleteTextView.setAdapter(teamList);

        Spinner teamSpinner = (Spinner)findViewById(R.id.teamDropList);
        teamSpinner.setAdapter(teamList);

        teamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Button clickButton = (Button) findViewById(R.id.btnDisplay);
                //clickButton.performClick();
                Toast.makeText(getApplicationContext(), countries[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "You did not select anything", Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup superHeroGroup = (RadioGroup) findViewById(R.id.superhero_group);

        superHeroGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton superHeroRB = (RadioButton) findViewById(checkedId);
                if (superHeroRB != null && checkedId > -1) {
                    Toast.makeText(getApplicationContext(), superHeroRB.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView superheroTextView = (TextView) findViewById(R.id.my_fav_superhero_text);
        superheroTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Not a long press!",Toast.LENGTH_SHORT).show();
            }
        });

        superheroTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Yayee long press!",Toast.LENGTH_SHORT).show();
                return true;
            }
        });



    }

    public void listenToToggleButtonEvents(){
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        Button clickButton = (Button) findViewById(R.id.btnDisplay);

        final PopupMenu popupMenu = new PopupMenu(this,clickButton);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
                Toast.makeText(getApplicationContext(),"Toggle button is checked "+toggleButton.isChecked(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
