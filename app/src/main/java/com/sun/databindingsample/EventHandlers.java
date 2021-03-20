package com.sun.databindingsample;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

/**
 * @author sxl
 * @date 2018/7/22 23:38
 */
public class EventHandlers {
    public void onClickFriend(View view) {
        Toast.makeText(view.getContext(), "EventHandlers: onClickFriend method invoked.", Toast.LENGTH_SHORT).show();
    }

    public void onSaveClick(View view, User user) {
        Toast.makeText(
                view.getContext(),
                "EventHandlers: onSaveClick method invoked with user: " + user.getFirstName() + ".",
                Toast.LENGTH_SHORT
        ).show();
    }

    public void onClickObservable(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), ObservableDataActivity.class));
    }
}
