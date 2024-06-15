package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BuyProduct extends AppCompatActivity {

    ImageView product_image;
    TextView product_name,product_offer1,product_offer2,product_price;
    Button brochure,buy_now;

    String[] name = {"Zoriscott (2 Liter)" , "Scott Proof (5 Liter)" , "Scott Proof Tank Seal" , "Mix-N-Fix" , "KrackSeal" , "Zoriscott EWC" , "SuperFlash Strip" , "Brush 4'"};
    String[] offer = {"49% off" , "51% off" , "33% off" , "19% off" , "21% off" , "11% off" , "10% off" , "7% off"};
    String[] offer_price = {"3̶,̶0̶0̶0̶" , "3̶9̶9̶9̶" , "2̶0̶0̶0̶" , "1̶5̶0̶0̶" , "3̶0̶0̶" , "9̶9̶9̶" , "4̶5̶0̶" , "2̶5̶0̶"};
    String[] offer_price2 = {"3,000" , "3,999" , "2,000" , "1,500" , "300" , "999" , "450" , "250"};
    String[] price = {"1530" , "1959" , "1340" , "1215" , "237" , "889" , "405" , "232"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        product_image = findViewById(R.id.product_image);
        product_name = findViewById(R.id.product_name);
        product_offer1 = findViewById(R.id.product_offer1);
        product_offer2 = findViewById(R.id.product_offer2);
        product_price = findViewById(R.id.product_price);

        brochure = findViewById(R.id.brochure);
        buy_now = findViewById(R.id.buy_now);


        Intent i = getIntent();
        String s = i.getStringExtra("product");
        String bro = i.getStringExtra("brochure");

        if(s.equals("1")) {
            product_image.setImageResource(R.drawable.a1);
            product_name.setText(name[0]);
            product_offer1.setText(offer[0]);
            product_offer2.setText(offer_price[0]);
            product_price.setText("₹" + price[0]);
        }
        else if(s.equals("2")) {
            product_image.setImageResource(R.drawable.a2);
            product_name.setText(name[1]);
            product_offer1.setText(offer[1]);
            product_offer2.setText(offer_price[1]);
            product_price.setText("₹" + price[1]);
        }
        else if(s.equals("3")) {
            product_image.setImageResource(R.drawable.a3);
            product_name.setText(name[2]);
            product_offer1.setText(offer[2]);
            product_offer2.setText(offer_price[2]);
            product_price.setText("₹" + price[2]);
        }
        else if(s.equals("4")) {
            product_image.setImageResource(R.drawable.a4);
            product_name.setText(name[3]);
            product_offer1.setText(offer[3]);
            product_offer2.setText(offer_price[3]);
            product_price.setText("₹" + price[3]);
        }
        else if(s.equals("5")) {
            product_image.setImageResource(R.drawable.a5);
            product_name.setText(name[4]);
            product_offer1.setText(offer[4]);
            product_offer2.setText(offer_price[4]);
            product_price.setText("₹" + price[4]);
        }
        else if(s.equals("6")) {
            product_image.setImageResource(R.drawable.a6);
            product_name.setText(name[5]);
            product_offer1.setText(offer[5]);
            product_offer2.setText(offer_price[5]);
            product_price.setText("₹" + price[5]);
        }
        else if(s.equals("7")) {
            product_image.setImageResource(R.drawable.a7);
            product_name.setText(name[6]);
            product_offer1.setText(offer[6]);
            product_offer2.setText(offer_price[6]);
            product_price.setText("₹" + price[6]);
        }
        else if(s.equals("8")) {
            product_image.setImageResource(R.drawable.a8);
            product_name.setText(name[7]);
            product_offer1.setText(offer[7]);
            product_offer2.setText(offer_price[7]);
            product_price.setText("₹" + price[7]);
        }

        brochure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW) ;
                i.setData(Uri.parse(bro)) ;
                startActivity(i);
            }
        });

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyProduct.this,CheckOut.class);
                intent.putExtra("image",s);
                int x = Integer.parseInt(s);
                x = x - 1;
                intent.putExtra("product",name[x]);
                intent.putExtra("dis1",offer[x]);
                intent.putExtra("dis2",offer_price[x]);
                intent.putExtra("dis3",offer_price2[x]);
                intent.putExtra("price",price[x]);
                intent.putExtra("brochure",bro);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(BuyProduct.this, Product.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(BuyProduct.this, Product.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}