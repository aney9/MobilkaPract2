package com.example.pract3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        ArrayList<Products> listpro = new ArrayList<Products>();

        listpro.add(new Products("УРА ЕДА", "150",R.drawable.korm, "это вискас, он топ, опыт имеется"));
        listpro.add(new Products("Корм для черепаха", "550", R.drawable.kormchepa, "черепаха быть довольна"));
        listpro.add(new Products("Сырое мясо", "11150", R.drawable.myaso, "вкуснейшее сырое мясо"));
        listpro.add(new Products("Мышь живая честно", "50", R.drawable.mysh, "чисто червяка заморить"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerAdapter(this, listpro));



    }
}