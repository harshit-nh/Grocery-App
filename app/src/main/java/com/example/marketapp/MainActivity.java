package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    //1- AdapterView
    RecyclerView recyclerView;

    //2- Data Source
    List<Item> itemList;

    //3- Adapter
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        itemList = new ArrayList<>();
        Item i1= new Item(R.drawable.fruit,"Fruits","Fresh Fruits from the garden");
        Item i2 = new Item(R.drawable.vegitables,"Vegetables","Fresh Vegetables from the farm");
        Item i3 = new Item(R.drawable.bread,"Bakery","Bread, Wheat and Beans");
        Item i4 = new Item(R.drawable.beverage,"Beverages","Juice, Tea, Coffee and Soda");
        Item i5 = new Item(R.drawable.milk,"Dairy","Milk, Shakes and Yogurt");
        Item i6 = new Item(R.drawable.popcorn,"Snacks","Pop-Corn, Donuts and Cookies");

        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);
        itemList.add(i4);
        itemList.add(i5);
        itemList.add(i6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);



        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.action_bar_color)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status_bar_color));
    }

    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(this, "You choose: "+itemList.get(pos).getItemName(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }
}