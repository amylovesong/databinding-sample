package com.sun.databindingsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sun.databindingsample.databinding.ActivityObservableDataBinding;

/**
 * Work with observable data objects
 */
public class ObservableDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityObservableDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable_data);

        // Observable fields
        User user = new User();
        user.firstName.set("Google");
        user.lastName.set("Inc.");
        user.age.set(17);

        binding.setUser(user);

        // Observable collections
        ObservableArrayMap<String, Object> userMap = new ObservableArrayMap<>();
        userMap.put("firstName", "Google-->");
        userMap.put("lastName", "Inc.-->");
        userMap.put("age", 19);

        binding.setUserMap(userMap);


        ObservableArrayList<Object> userList = new ObservableArrayList<>();
        userList.add("Xiaoling");
        userList.add("Sun");
        userList.add(28);

        binding.setUserList(userList);

        // Observable objects
        ObservableUser observableUser = new ObservableUser();
        observableUser.setFirstName("Object");
        observableUser.lastName = "xxx";

        binding.setObservableUser(observableUser);

        observableUser.lastName = "---";
    }

    public static class User {
        public final ObservableField<String> firstName = new ObservableField<>();
        public final ObservableField<String> lastName = new ObservableField<>();
        public final ObservableInt age = new ObservableInt();
    }

    public static class Fields {
        public static final int FIRST_NAME = 0;
        public static final int LAST_NAME = 1;
        public static final int AGE = 2;
    }

    public static class ObservableUser extends BaseObservable {
        private String firstName;
        private String lastName;

        @Bindable
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
            notifyPropertyChanged(BR.firstName);
        }

        @Bindable
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
            notifyPropertyChanged(BR.lastName);
        }
    }
}
