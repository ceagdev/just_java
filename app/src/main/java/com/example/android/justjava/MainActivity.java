package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String orderSumary = createOrderSumuary(price);
        displayMessage(orderSumary);
    }

    public void addCoffee(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void subtractCoffee(View view) {
        if(quantity >0){
            quantity--;
        }
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    private void displayMessage(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.order_sumary_text_view);
        quantityTextView.setText(message);
    }

    private String createOrderSumuary(int orderPrice){
        String sumary = "Name: Kaptain Kunal";
        sumary = sumary + "\nQuantity: " + quantity;
        sumary = sumary + "\nTotal: "+ NumberFormat.getCurrencyInstance().format(orderPrice);
        sumary = sumary + "\nThank You!";

        return sumary;
    }

    private int calculatePrice(){
        int price = quantity * 5;
        return price;
    }

}