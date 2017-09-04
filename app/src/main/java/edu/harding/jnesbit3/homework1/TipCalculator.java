package edu.harding.jnesbit3.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.text.NumberFormat;

public class TipCalculator extends AppCompatActivity {

    private float Total;
    private float TipAmount;
    private EditText bill;
    private EditText tip;
    private TextView TVtotal;
    private TextView TVtipAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        bill = (EditText) findViewById(R.id.editTextBill);
        tip = (EditText) findViewById(R.id.editTextTP);
        TVtotal =  (TextView) findViewById(R.id.textViewTotal);
        TVtipAmount =  (TextView) findViewById(R.id.textViewTipAmount);
    }
    public void buttonClick(View view)
    {
        try {
            TipAmount = Float.parseFloat(tip.getText().toString());
            Total = Float.parseFloat(bill.getText().toString());
            TipAmount = (TipAmount * Total) / 100;
            Total += TipAmount;
            NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
            String TotalAmount = moneyFormat.format(Total);
            String TipAmountString = moneyFormat.format(TipAmount);
            TVtotal.setText(TotalAmount);
            TVtipAmount.setText(TipAmountString);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Enter numbers for bill and tip percent.", Toast.LENGTH_SHORT).show();
            Total = 0;
            TipAmount = 0;
        }
    }
}
