package com.example.revision_class;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText gallonsInput, minutesInput, kilowattsInput;
    TextView waterBillView, electricityBillView, phoneBillView, totalBillView;
    Button calculateButton, newButton, exitButton, infoButton;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallonsInput = findViewById(R.id.gallonsInput);
        minutesInput = findViewById(R.id.minutesInput);
        kilowattsInput = findViewById(R.id.kilowattsInput);
        waterBillView = findViewById(R.id.waterBillView);
        electricityBillView = findViewById(R.id.electricityBillView);
        phoneBillView = findViewById(R.id.phoneBillView);
        totalBillView = findViewById(R.id.totalBillView);
        calculateButton = findViewById(R.id.calculateButton);
        newButton = findViewById(R.id.newButton);
        exitButton = findViewById(R.id.exitButton);
        infoButton = findViewById(R.id.infoButton);

        gallonsInput.setText("0");
        minutesInput.setText("0");
        kilowattsInput.setText("0");
        waterBillView.setText("GHS 0.00");
        electricityBillView.setText("GHS 0.00");
        phoneBillView.setText("GHS 0.00");
        totalBillView.setText("GHS 0.00");


        calculateButton.setOnClickListener(v->{
            try {
                double gallons = Double.parseDouble(gallonsInput.getText().toString());
                double minutes = Double.parseDouble(minutesInput.getText().toString());
                double kilowatts = Double.parseDouble(kilowattsInput.getText().toString());

                MyBills bills =  new MyBills(gallons,kilowatts,minutes);
                waterBillView.setText("GHS " + bills.getWaterBIll());
                phoneBillView.setText("GHS "+ bills.getTelephoneBill());
                electricityBillView.setText("GHS "+ bills.getElectricityBill());

                totalBillView.setText("GHS " + bills.getTotalBill());

                calculateButton.setEnabled(false);
                newButton.setEnabled(true);


            }catch (Exception e){
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            }
        });

        newButton.setOnClickListener(v -> {
            gallonsInput.setText("0");
            minutesInput.setText("0");
            kilowattsInput.setText("0");
            waterBillView.setText("GHS 0.00");
            electricityBillView.setText("GHS 0.00");
            phoneBillView.setText("GHS 0.00");
            totalBillView.setText("GHS 0.00");

            calculateButton.setEnabled(true);
            newButton.setEnabled(false);
        });

        exitButton.setOnClickListener(v-> new AlertDialog.Builder(MainActivity.this)
                .setMessage("Confirm to exit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No",null)
                .show());

        infoButton.setOnClickListener(v->{
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("My Info \n Name: Owusu Rockson \n Index Number: 0321080033 \n Phone Number: 0557533568")
                    .setPositiveButton("OK", null)
                    .show();
        });

        

    }
}