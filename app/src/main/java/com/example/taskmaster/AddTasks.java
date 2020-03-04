package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazonaws.amplify.generated.graphql.CreateTasksMutation;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.exception.ApolloException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nonnull;

import type.CreateTasksInput;

import static com.example.taskmaster.TasksFragment.newDB;

public class AddTasks extends AppCompatActivity {
    String cityName = " ";


// I used the 401d7 2/10/2020, and 3/02/2020 class video as a reference for the below code

    private AWSAppSyncClient mAWSAppSyncClient;
    private FusedLocationProviderClient fusedLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        //intent for sharing image below
        Intent intent = getIntent();
        Uri data = intent.getData();


        //reference - below intent for image adding is from android documents - https://developer.android.com/reference/android/content/Intent#ACTION_SENDTO

        if (intent.getType() != null && intent.getType().contains("image/")) {

            Uri newImage = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);

            if(newImage != null){
                ImageView imageView = findViewById(R.id.addTaskImage);
                imageView.setImageURI(newImage);

            }

        }


        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();








        Button submitTask = findViewById(R.id.submit);
        submitTask.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){



//               Intent sentToAddTasksIntent = new Intent(AddTasks.this, MainActivity.class);
//
//               AddTasks.this.startActivity(sentToAddTasksIntent);


               //Reference for GEOCODER - https://stackoverflow.com/questions/22323974/how-to-get-city-name-by-latitude-longitude-in-android
               // https://developer.android.com/reference/android/location/Geocoder

               fusedLocationClient.getLastLocation()
                       .addOnSuccessListener(AddTasks.this, new OnSuccessListener<Location>() {
                           @Override
                           public void onSuccess(Location location) {

                               if (location != null) {

                                       double lat = location.getLatitude();
                                       double longitude = location.getLongitude();
                                       Geocoder geocoder = new Geocoder(AddTasks.this.getApplicationContext(), Locale.getDefault());


                                       try {
                                           List < Address > addresses = geocoder.getFromLocation(lat, longitude, 1);
                                            cityName = addresses.get(0).getLocality();
                                           Log.i("tag",cityName);
                                          // String stateName = addresses.get(0).getAdminArea();


                                       } catch (IOException e) {
                                           e.printStackTrace();
                                       }
                               }
                           }
                       });


               EditText userInput = findViewById(R.id.submitText);
               EditText userInput2 = findViewById(R.id.editText3);
               EditText userInput3 = findViewById(R.id.editText);
               String userInputTet = userInput.getText().toString();
               String userInputText2 = userInput2.getText().toString();
               String userInputText3 = userInput3.getText().toString();

               //Tasks newTask = new Tasks(userInputText, userInputText2, userInputText3 );

               // TextView userItem = AddTasks.this.findViewById(R.id.textView2);
               //userItem.setText("Submitted");

               // newDB.taskDao().save(newTask);

               runMutation(userInputTet, userInputText2, userInputText3, cityName);




           }




        });





  }



    public void runMutation(String title, String body, String state, String city){
        CreateTasksInput createTasksInput = CreateTasksInput.builder().

                title(title).
                body(body).
                state(state).
                city(city).
                build();

        mAWSAppSyncClient.mutate(CreateTasksMutation.builder().input(createTasksInput).build())
                .enqueue(mutationCallback);
    }

    private GraphQLCall.Callback<CreateTasksMutation.Data> mutationCallback = new GraphQLCall.Callback<CreateTasksMutation.Data>() {

        @Override
        public void onResponse(@Nonnull com.apollographql.apollo.api.Response<CreateTasksMutation.Data> response) {
       // Intent sendUserToMain = new Intent(addTasks.this,  )

            Intent sentToAddTasksIntent = new Intent(AddTasks.this, MainActivity.class);

            AddTasks.this.startActivity(sentToAddTasksIntent);


        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };





}
