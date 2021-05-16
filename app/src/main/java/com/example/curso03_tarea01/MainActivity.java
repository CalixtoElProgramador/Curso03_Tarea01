package com.example.curso03_tarea01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutName, inputLayoutPhone, inputLayoutEmail, inputLayoutBirthday;
    private TextInputEditText inputName, inputPhone, inputEmail, inputBirthday, inputDescription;
    private Button buttonDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewId();
        datePicker();
        inputsChangesListeners();
        pressButton();
    }

    private void findViewId() {
        inputLayoutName = findViewById(R.id.inputLayout_name);
        inputLayoutPhone = findViewById(R.id.inputLayout_phone);
        inputLayoutEmail = findViewById(R.id.inputLayout_email);
        inputLayoutBirthday = findViewById(R.id.inputLayout_birthday);

        inputName = findViewById(R.id.input_name);
        inputPhone = findViewById(R.id.input_phone);
        inputEmail = findViewById(R.id.input_email);
        inputBirthday = findViewById(R.id.input_birthday);
        inputDescription = findViewById(R.id.input_description);

        buttonDone = findViewById(R.id.button_done);
    }

    private void datePicker() {
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(getString(R.string.select_date));
        final MaterialDatePicker materialDatePicker = builder.build();
        inputBirthday.setEnabled(false);

        inputLayoutBirthday.setEndIconOnClickListener(view -> {
            materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
        });

        materialDatePicker.addOnPositiveButtonClickListener(selection -> inputBirthday.setText(materialDatePicker.getHeaderText()));
    }

    private void pressButton() {
        buttonDone.setOnClickListener(view -> checkInputs());
    }

    private void checkInputs() {
        if (Objects.requireNonNull(inputName.getText()).toString().trim().isEmpty()) {
            inputLayoutName.setErrorEnabled(true);
            inputLayoutName.setError(getString(R.string.error_input_empty));
        } else if (Objects.requireNonNull(inputPhone.getText()).toString().trim().isEmpty()) {
            inputLayoutPhone.setErrorEnabled(true);
            inputLayoutPhone.setError(getString(R.string.error_input_empty));
        } else if (Objects.requireNonNull(inputEmail.getText()).toString().trim().isEmpty()) {
            inputLayoutEmail.setErrorEnabled(true);
            inputLayoutEmail.setError(getString(R.string.error_input_empty));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString()).matches()) {
            inputLayoutEmail.setErrorEnabled(true);
            inputLayoutEmail.setError(getString(R.string.error_email_false));
        } else {
            sendParameters();
        }
    }

    public void sendParameters() {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        String name = Objects.requireNonNull(inputName.getText()).toString();
        String phone = Objects.requireNonNull(inputPhone.getText()).toString();
        String email = Objects.requireNonNull(inputEmail.getText()).toString();
        String birthday = Objects.requireNonNull(inputBirthday.getText()).toString();
        String description = Objects.requireNonNull(inputDescription.getText()).toString();

        User user = new User(name, phone, email, birthday, description);

        intent.putExtra(getString(R.string.KEY_USER), user);
        startActivity(intent);
    }

    public void inputsChangesListeners() {
        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inputLayoutName.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inputLayoutPhone.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inputLayoutEmail.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}