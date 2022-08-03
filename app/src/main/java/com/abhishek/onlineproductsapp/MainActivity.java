package com.abhishek.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abhishek.onlineproductsapp.adapter.ProductAdapter;
import com.abhishek.onlineproductsapp.adapter.ProductCategoryAdapter;
import com.abhishek.onlineproductsapp.model.ProductCategory;
import com.abhishek.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.form_redirect);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Checkout_form.class);
                startActivity(intent);
            }
        });

        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Trending"));
        productCategoryList.add(new ProductCategory(2, "Most Popular"));
        productCategoryList.add(new ProductCategory(3, "Latest Tech"));
        productCategoryList.add(new ProductCategory(4, "Laptops"));
        productCategoryList.add(new ProductCategory(5, "Cameras"));
        productCategoryList.add(new ProductCategory(6, "Mobile"));
        productCategoryList.add(new ProductCategory(7, "Headset"));

        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Oppo A74", "6.7-inch", "$ 300.00", R.drawable.prod2));
        productsList.add(new Products(2, "iPhone 11", "6.7-inch", "$ 600.00", R.drawable.prod1));
        productsList.add(new Products(1, "iPhone 12", "7-inch", "$ 650.00", R.drawable.prod3));
        productsList.add(new Products(2, "iPhone 13", "6.7-inch", "$ 750.00", R.drawable.prod4));
        productsList.add(new Products(1, "Samsung Galaxy", "6.7-inch", "$ 600.00", R.drawable.prod5));
        productsList.add(new Products(2, "Samsung Note", "7-inch", "$ 640.00", R.drawable.prod6));

        setProdItemRecycler(productsList);

    }

    private void setProductRecycler(List<ProductCategory> productCategoryList) {

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList) {

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }

}