package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        TextView userItem = Settings.this.findViewById(R.id.username);

        Button submitUsername = findViewById(R.id.usernamebutton);
        submitUsername.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText userInput = findViewById(R.id.username);
                String userInputText = userInput.getText().toString();

//                TextView userItem = Settings.this.findViewById(R.id.username);
//                userItem.setText(userInputText);

                //  ConstraintLayout endResult = AddTasks.this.findViewById(R.id.)

                SharedPreferences username = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                SharedPreferences.Editor editor = username.edit();
                editor.putString("username", userInputText);
                editor.apply();



            }




        });



    }
}
