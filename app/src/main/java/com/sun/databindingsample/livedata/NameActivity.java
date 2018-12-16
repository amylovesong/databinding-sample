package com.sun.databindingsample.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sun.databindingsample.R;

public class NameActivity extends AppCompatActivity {
    private static final String TAG = "NameActivity";

    private NameViewModel mModel;

    private TextView mNameTextView;
    private Button mUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        initViews();

//        mModel = ViewModelProvider.

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String newName) {
                Log.d(TAG, "onChanged: newName=" + newName);
                mNameTextView.setText(newName);
            }
        };

        mModel.getCurrentName().observe(this, nameObserver);
    }

    private void initViews() {
        mNameTextView = findViewById(R.id.tv_name);
        mUpdateButton = findViewById(R.id.btn_update);

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String anotherName = "Sun";
                mModel.getCurrentName().setValue(anotherName);
            }
        });
    }
}
