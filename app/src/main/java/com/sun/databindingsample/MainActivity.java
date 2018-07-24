package com.sun.databindingsample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sun.databindingsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        /* Binding data */
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        User user = new User("Test", "User");
        User user = new User(null, "User");
        binding.setUser(user);

        /* Event handing */
        EventHandlers handlers = new EventHandlers();
        binding.setHandlers(handlers);
    }

    public void onClick(View view) {
        startActivity(new Intent(this, CollectionsActivity.class));
    }

}
