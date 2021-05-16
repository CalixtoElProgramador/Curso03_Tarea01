package com.example.curso03_tarea01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.getSerializable(getString(R.string.KEY_USER));

        TextView textView_name = findViewById(R.id.text_name);
        TextView textView_phone = findViewById(R.id.text_phone);
        TextView textView_email = findViewById(R.id.text_email);
        TextView textView_birthday = findViewById(R.id.text_birthday);
        TextView textView_description = findViewById(R.id.text_description);
        Button button_edit = findViewById(R.id.button_edit);

        textView_name.setText(user.getName());
        textView_phone.setText(user.getPhone());
        textView_email.setText(user.getEmail());

        if (user.getBirthday() != null)
            textView_birthday.setText(user.getBirthday());
        else
            textView_birthday.setVisibility(View.GONE);

        if (user.getDescription() != null)
            textView_description.setText(user.getDescription());
        else
            textView_description.setVisibility(View.GONE);

        button_edit.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}