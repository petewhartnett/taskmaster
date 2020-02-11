package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {


// I used the 401d7 2/10/2020 class video as a reference for the below code


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button sendToAddTasksPage = findViewById(R.id.button);
        sendToAddTasksPage.setOnClickListener(new View.OnClickListener(){

          @Override
          public  void onClick(View view){


            Intent sentToAddTasksIntent = new Intent(MainActivity.this, AddTasks.class);

            MainActivity.this.startActivity(sentToAddTasksIntent);

          }


        });



        Button sendToAllTasksPage = findViewById(R.id.button2);
        sendToAllTasksPage.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View view){


                Intent sentToAllTasksIntent = new Intent(MainActivity.this, AllTasks.class);

                MainActivity.this.startActivity(sentToAllTasksIntent);

            }


        });



    }
}
