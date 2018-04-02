package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    boolean whippedCream = false;
    boolean chocolate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        whippedCream = ((CheckBox) findViewById(R.id.whipped_cream)).isChecked();
        chocolate = ((CheckBox) findViewById(R.id.chocolate)).isChecked();
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, whippedCream, chocolate);
        displayMessage(priceMessage);
    }

    /**
     * Returns an order summary
     *
     * @param price of the order
     * @param whippedCream is whether the user wants whipped cream
     * @param chocolate is whether the user wants chocolate
     * @return text summary
     */
    private String createOrderSummary (int price, boolean whippedCream, boolean chocolate) {
        String priceMessage = "Name: Sam " +
                               "\nWhipped cream?: " + whippedCream +
                               "\nChocolate?: " + chocolate +
                               "\nQuantity: " + quantity +
                               "\nTotal: $" + price +
                               "\nThank you!";
        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

//    /**
//     * This method displays the given price on the screen.
//     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}