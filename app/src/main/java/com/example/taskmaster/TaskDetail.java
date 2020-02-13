package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);



        String getTask = getIntent().getStringExtra("mTitleView");
        String getTask2 = getIntent().getStringExtra("mBodyView");
        String getTask3 = getIntent().getStringExtra("mAssignedView");

        TextView taskText = findViewById(R.id.textView6);
        taskText.setText(getTask);

        TextView taskText2 = findViewById(R.id.textView9);
        taskText2.setText(getTask2);

        TextView taskText3 = findViewById(R.id.textView10);
        taskText3.setText(getTask3);




    }
}
