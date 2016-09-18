package com.example.puyus.burgercaloriecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button calculate;
    CheckBox checkMushrooms,checkLettuce, checkTomato,
            checkPickles, checkMayo, checkMustard;
    Spinner bunSpinner, meatSpinner;
    EditText numberOfBurgers;
    Burger burger = new Burger();
    BurgerCal calculator = new BurgerCal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfBurgers = (EditText) findViewById(R.id.numberOfBurgers);
        numberOfBurgers.setInputType(InputType.TYPE_CLASS_NUMBER);

        bunSpinner = (Spinner) findViewById(R.id.bunSpinner);
        meatSpinner = (Spinner) findViewById(R.id.meatSpinner);
        calculate = (Button) findViewById(R.id.calculate);

        checkMushrooms = (CheckBox) findViewById(R.id.checkMushrooms);
        checkLettuce = (CheckBox) findViewById(R.id.checkLettuce);
        checkTomato = (CheckBox) findViewById(R.id.checkTomato);
        checkPickles = (CheckBox) findViewById(R.id.checkPickles);
        checkMayo = (CheckBox) findViewById(R.id.checkMayo);
        checkMustard = (CheckBox) findViewById((R.id.checkMustard));


        bunSpinner.setOnItemSelectedListener(new CustomOnItemListener());
        meatSpinner.setOnItemSelectedListener(new CustomOnItemListener());
        calculate.setOnClickListener(this);
    }

    public void onClick(View view) {
        int checkCounter = 0;
        burger.setMeat(meatSpinner.getSelectedItemPosition());
        burger.setBun(bunSpinner.getSelectedItemPosition());

        if (checkMushrooms.isChecked()) {
            burger.setTop(0);
            checkCounter++;
        }

        if (checkLettuce.isChecked()) {
            burger.setTop(1);
            checkCounter++;
        }

        if (checkLettuce.isChecked()) {
            burger.setTop(1);
            checkCounter++;
        }
        if (checkTomato.isChecked()) {
            burger.setTop(2);
            checkCounter++;
        }
        if (checkPickles.isChecked()) {
            burger.setTop(3);
            checkCounter++;
        }
        if (checkMayo.isChecked()) {
            burger.setTop(4);
            checkCounter++;
        }
        if (checkMustard.isChecked()) {
            burger.setTop(5);
            checkCounter++;
        }
        if ( checkCounter >= 5)
        {
            Toast.makeText(MainActivity.this,
                    "Please select topping top be less or equal to 3",
                    Toast.LENGTH_SHORT).show();
            checkCounter = 0;
        }
        try {
            double value = Double.parseDouble(numberOfBurgers.getText().toString());
            if (value > 1000)
            {
                Toast.makeText(MainActivity.this,
                        "Due to supply issues Enter a number less than 1000",
                        Toast.LENGTH_SHORT).show();
            }else {
                burger.setUserInput(value);
            }
        }
        catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this,
                    "Please Enter a number greater than 0",
                    Toast.LENGTH_SHORT).show();
        }
        calculator.calculateTotal(burger.getBunCal(), burger.getMeatCal(), burger.getTotalTopCal(),
                burger.bunPrice, burger.getMeatPrice(), burger.getTotalTopPrice(), burger.getUserInput());

        Toast.makeText(MainActivity.this,
                calculator.toString(),
                Toast.LENGTH_SHORT).show();
        burger.clearTop();
    }
}



class CustomOnItemListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}

