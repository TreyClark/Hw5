package com.example.hw4;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import  com.google.android.material.button.MaterialButtonToggleGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MaterialButtonToggleGroup bgroup = findViewById(R.id.buttonGroup);
        bgroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {

               if(isChecked){
                   ImageView nImageView = findViewById(R.id.pizzaImage);
                    switch (checkedId) {
                        case R.id.buttonCircle:
                            nImageView.setImageResource(R.drawable.ic_round_pizza);
                            System.out.println("circle");
                            break;
                        case R.id.buttonSquare:
                            nImageView.setImageResource(R.drawable.ic_squared_pizza);
                            System.out.println("square");
                            break;
                    }
                }
            }
        });

        final ChipGroup cGroup = findViewById(R.id.chipGroup);

        final CheckBox pCheckBox = findViewById(R.id.checkBoxPepperoni);
        final Chip pChip = findViewById(R.id.chipPepperoni);
        cGroup.removeView(pChip);

        pCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCheckBox(pCheckBox, cGroup,pChip);
            }
        });

        final CheckBox mCheckBox = findViewById(R.id.checkBoxMushrooms);
        final Chip mChip = findViewById(R.id.chipMushrooms);
        cGroup.removeView(mChip);

        mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCheckBox(mCheckBox, cGroup,mChip);
            }
        });

        final CheckBox vCheckBox = findViewById(R.id.checkBoxVeggies);
        final Chip vChip = findViewById(R.id.chipVeggies);
        cGroup.removeView(vChip);

        vCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCheckBox(vCheckBox, cGroup,vChip);
            }
        });

        final CheckBox aCheckBox = findViewById(R.id.checkBoxAnchovies);
        final Chip aChip = findViewById(R.id.chipAnchovies);
        cGroup.removeView(aChip);

        aCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCheckBox(aCheckBox, cGroup,aChip);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()){
                    Snackbar.make(view, "Your order has been sent", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
                else{
                    Snackbar.make(view, "Please complete the entire form to submit your order", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
        }});
    }

    void checkCheckBox(CheckBox checkBox, ChipGroup chipGroup, Chip chip){
        if(checkBox.isChecked()){
            chipGroup.addView(chip);
        }
        else{
            chipGroup.removeView(chip);
        }
    };

    public boolean check(){
        boolean check = validateName();
            if (check){
                check = validateNumber();
            }
        return(check);
    };

    public boolean validateName(){
        EditText name = findViewById(R.id.userName);
        String sUsername = name.getText().toString();
        if(sUsername.matches("")) {
            name.setError("Please enter your name");
            return false;
        }
        else
            return true;

    };

    public boolean validateNumber(){
        EditText number = findViewById(R.id.userPhoneNumber);
        String sNumber = number.getText().toString();
        if(sNumber.length()!=10) {
            number.setError("Your phone number must be 10 digits long");
            return false;
        }
        else
            return true;

    };

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


