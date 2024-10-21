package com.example.tltdd_bai9;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout bg;
    RadioButton btnLight, btnDark;
    TextView title,info;
    SharedPreferences sharedPreferences;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getMapping();

        sharedPreferences = getSharedPreferences("share", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getResources().getString(R.string.key_info), info.getText().toString().trim());
        editor.commit();


        getEvent();

        String color = sharedPreferences.getString(getResources().getString(R.string.key_color), "light");
        if(color.equals("dark")){
            title.setTextColor(getResources().getColor(R.color.white));
            info.setTextColor(getResources().getColor(R.color.white));
            bg.setBackgroundColor(getResources().getColor(R.color.white));
            btnLight.setTextColor(getResources().getColor(R.color.white));
            btnDark.setTextColor(getResources().getColor(R.color.black));
            btnDark.setChecked(true);
        }
        else {
            btnLight.setTextColor(getResources().getColor(R.color.black));
            btnDark.setTextColor(getResources().getColor(R.color.black));
            title.setTextColor(getResources().getColor(R.color.black));
            info.setTextColor(getResources().getColor(R.color.black));
            bg.setBackgroundColor(getResources().getColor(R.color.white));
            btnDark.setChecked(true);
        }
    }

    private void getEvent() {
        btnDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLight.setTextColor(getResources().getColor(R.color.white));
                btnDark.setTextColor(getResources().getColor(R.color.white));
                title.setTextColor(getResources().getColor(R.color.white));
                bg.setBackgroundColor(getResources().getColor(R.color.black));
                info.setTextColor(getResources().getColor(R.color.white));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("color");
                editor.putString("color", "dark");
                editor.commit();
            }
        });

        btnLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setTextColor(getResources().getColor(R.color.black));
                bg.setBackgroundColor(getResources().getColor(R.color.white));
                info.setTextColor(getResources().getColor(R.color.black));
                btnLight.setTextColor(getResources().getColor(R.color.black));
                btnDark.setTextColor(getResources().getColor(R.color.black));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("color");
                editor.putString(getResources().getString(R.string.key_color), "light");
                editor.commit();
            }
        });
    }

    private void getMapping() {
        bg = findViewById(R.id.layout_main);
        btnLight = findViewById(R.id.btnLight);
        btnDark = findViewById(R.id.btnDark);
        title = findViewById(R.id.tvTitle);
        info = findViewById(R.id.info);
    }

}
