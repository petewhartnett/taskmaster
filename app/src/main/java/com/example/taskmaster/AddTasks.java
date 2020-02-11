package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddTasks extends AppCompatActivity {


// I used the 401d7 2/10/2020 class video as a reference for the below code


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);


        Button submitTask = findViewById(R.id.submit);
        submitTask.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               EditText userInput = findViewById(R.id.submitText);
               String userInputText = userInput.getText().toString();

               TextView userItem = AddTasks.this.findViewById(R.id.textView2);
               userItem.setText("Submitted");

             //  ConstraintLayout endResult = AddTasks.this.findViewById(R.id.)




           }




        });




  }
}
