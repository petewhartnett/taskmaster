package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazonaws.amplify.generated.graphql.CreateTasksMutation;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import type.CreateTasksInput;

import static com.example.taskmaster.TasksFragment.newDB;

public class AddTasks extends AppCompatActivity {


// I used the 401d7 2/10/2020 class video as a reference for the below code

    private AWSAppSyncClient mAWSAppSyncClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);


        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();


        Button submitTask = findViewById(R.id.submit);
        submitTask.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               EditText userInput = findViewById(R.id.submitText);
                EditText userInput2 = findViewById(R.id.editText3);
               EditText userInput3 = findViewById(R.id.editText);
               String userInputText = userInput.getText().toString();
               String userInputText2 = userInput2.getText().toString();
               String userInputText3 = userInput3.getText().toString();

               Tasks newTask = new Tasks(userInputText, userInputText2, userInputText3 );

              // TextView userItem = AddTasks.this.findViewById(R.id.textView2);
               //userItem.setText("Submitted");



               // newDB.taskDao().save(newTask);

                runMutation(userInputText, userInputText2, userInputText3);

               Intent sentToAddTasksIntent = new Intent(AddTasks.this, MainActivity.class);

               AddTasks.this.startActivity(sentToAddTasksIntent);








           }




        });





  }



    public void runMutation(String title, String body, String state){
        CreateTasksInput createTasksInput = CreateTasksInput.builder().

                title(title).
                body(body).
                state(state).
                build();

        mAWSAppSyncClient.mutate(CreateTasksMutation.builder().input(createTasksInput).build())
                .enqueue(mutationCallback);
    }

    private GraphQLCall.Callback<CreateTasksMutation.Data> mutationCallback = new GraphQLCall.Callback<CreateTasksMutation.Data>() {

        @Override
        public void onResponse(@Nonnull com.apollographql.apollo.api.Response<CreateTasksMutation.Data> response) {
       // Intent sendUserToMain = new Intent(addTasks.this,  )

        }

        @Override
        public void onFailure(@Nonnull ApolloException e) {
            Log.e("Error", e.toString());
        }
    };





}
