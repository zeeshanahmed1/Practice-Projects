package com.example.developer.coffeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity=1;
    EditText orderer;
    Button button;
    CheckBox whipped;
    CheckBox chclate;
    TextView price_text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view){

        EditText text = (EditText) findViewById(R.id.name_field);
        String value = text.getText().toString();
        CheckBox whipppedCreamCheckBOx = (CheckBox) findViewById(R.id.whipped_cream_checked);
        boolean hasWippedCream = whipppedCreamCheckBOx.isChecked();
        CheckBox chocolateCheckBOx = (CheckBox) findViewById(R.id.choclate_checked);
        boolean hasChocolate = chocolateCheckBOx.isChecked();
        int price = calculatePrice(hasWippedCream,hasChocolate);
        String priceMessage = createOrderSummary(value,price, hasWippedCream, hasChocolate);
        Intent intent =new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT,"for coffe app order" +value);
        intent.putExtra(intent.EXTRA_TEXT, priceMessage);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }

    }
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this,"You Can't have more than 100 cup of coffee ", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            Toast.makeText(this,"You Cant have less than 1 cup of coffee ",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    public void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + numberOfCoffees);
    }



    private int calculatePrice( boolean addWhippedCream, boolean addChocolate) {
        int basePrice =5;
        if(addWhippedCream){
            basePrice = basePrice+1;
        }
        if (addChocolate){
            basePrice =basePrice+2;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(String name,int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Namae:" +name;
        priceMessage += "\nAdd a Whipped cream ?" + addWhippedCream;
        priceMessage += "\nAdd a Chocolate ?" + addChocolate;
        priceMessage += "\nQuantity:" + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    }


