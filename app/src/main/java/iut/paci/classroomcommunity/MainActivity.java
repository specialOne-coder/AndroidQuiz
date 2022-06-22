package iut.paci.classroomcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import iut.paci.classroomcommunity.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {

    TextView tview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tview = findViewById(R.id.text);
        Intent i = getIntent();
        String u = i.getStringExtra("name");
        tview.setText("Hello "+u);
    }
};