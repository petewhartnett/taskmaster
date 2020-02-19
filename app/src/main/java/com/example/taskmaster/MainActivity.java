package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.sql.SQLOutput;
import java.util.List;


public class MainActivity extends AppCompatActivity {


// I used the 401d7 2/10/2020, 2/18/2020 class video as a reference for the below code
// reference - https://developer.android.com/training/data-storage/room


  // public List<Tasks> listOfTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Tasks a = new Tasks("Set alarm", "for wake up", "Assigned");

        RecyclerView recyclerView = findViewById(R.id.fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  recyclerView.setAdapter(new MyTasksRecyclerViewAdapter(new MyTasksRecyclerViewAdapter(this.listOfTasks, this)));

        Button sendToAddTasksPage = findViewById(R.id.button);
        sendToAddTasksPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent sentToAddTasksIntent = new Intent(MainActivity.this, AddTasks.class);

                MainActivity.this.startActivity(sentToAddTasksIntent);

            }


        });


        Button sendToAllTasksPage = findViewById(R.id.button2);
        sendToAllTasksPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent sentToAllTasksIntent = new Intent(MainActivity.this, AllTasks.class);

                MainActivity.this.startActivity(sentToAllTasksIntent);

            }


        });

//
//        Button sendToDetailsPage = findViewById(R.id.taskbutton);
//        sendToDetailsPage.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//
//                Intent sentToDetailsPage = new Intent(MainActivity.this, TaskDetail.class);
//                sentToDetailsPage.putExtra("task", "Task One");
//
//                MainActivity.this.startActivity(sentToDetailsPage);
//
////                TextView userItem = MainActivity.this.findViewById(R.id.textView6);
////                userItem.setText("TEST");
//
//
//            }
//
//
//        });

//
//        Button sendToDetailsPage2 = findViewById(R.id.taskbutton2);
//        sendToDetailsPage2.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//
//                Intent sentToDetailsPage = new Intent(MainActivity.this, TaskDetail.class);
//                sentToDetailsPage.putExtra("task", "Task Two");
//
//                MainActivity.this.startActivity(sentToDetailsPage);
//
////                TextView userItem = MainActivity.this.findViewById(R.id.textView6);
////                userItem.setText("TEST");
//
//
//            }
//
//
//        });





//        Button sendToDetailsPage3 = findViewById(R.id.taskbutton3);
//        sendToDetailsPage3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//
//                Intent sentToDetailsPage = new Intent(MainActivity.this, TaskDetail.class);
//                sentToDetailsPage.putExtra("task", "Task Three");
//
//                MainActivity.this.startActivity(sentToDetailsPage);
//
////                TextView userItem = MainActivity.this.findViewById(R.id.textView6);
////                userItem.setText("TEST");
//
//
//            }
//
//
//        });



        Button sendToSettingsPage = findViewById(R.id.settings);
        sendToSettingsPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent sentToSettingsPage = new Intent(MainActivity.this, Settings.class);
               // sentToSettingsPage.putExtra("task", "Task One");

                MainActivity.this.startActivity(sentToSettingsPage);

//                TextView userItem = MainActivity.this.findViewById(R.id.textView6);
//                userItem.setText("TEST");



            }


        });






    }


    @Override
    public void onStart(){
        super.onStart();

        TextView textView = findViewById(R.id.textView);


        textView.setText("WELCOME");
        textView.setVisibility(View.VISIBLE);



    }


    @Override
    public void onResume(){
        super.onResume();

        TextView textView = findViewById(R.id.textView);
        //TextView settingsupdate = findViewById(R.id.settingsupdated);

        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String username = p.getString("username", "default");

        textView.setText(username + "'s Task List");
        textView.setVisibility(View.VISIBLE);


    }


}
