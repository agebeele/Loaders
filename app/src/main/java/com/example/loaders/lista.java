package com.example.loaders;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class lista extends AppCompatActivity {
    RecyclerView recyclerView;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        // Inicializar RecyclerView y ShimmerFrameLayout
        recyclerView = findViewById(R.id.recyclerView);
        shimmerFrameLayout = findViewById(R.id.shimmer);

        // Configurar el RecyclerView con un LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());  // Asegúrate de implementar MyAdapter correctamente

        // Mostrar el shimmer mientras simulamos la carga de datos
        shimmerFrameLayout.startShimmer();

        // Simulación de retardo de carga de datos (3 segundos)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Detener el shimmer y mostrar los datos
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        }, 3000);  // 3000ms = 3 segundos de retardo
    }
}