package com.example.todo_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] tasks = {"breakfast", "mobile", "college" , "lunch", "dinner"};
    private TextView textView;
    int currentIndext = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(tasks[currentIndext]);
    }

    public void preButton(View view){
        currentIndext--;
        textView.setText(tasks[currentIndext]);

    }

    public void nextButton(View view){
        currentIndext++;
        textView.setText(tasks[currentIndext]);
    }

}
