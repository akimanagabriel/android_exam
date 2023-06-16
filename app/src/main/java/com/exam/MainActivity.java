package com.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e_names,e_regno,e_fa1marks,e_fa2marks;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_names = findViewById(R.id.names);
        e_regno = findViewById(R.id.regno);
        e_fa1marks = findViewById(R.id.fa1marks);
        e_fa2marks = findViewById(R.id.fa2marks);
    }


    public void saveStudent(View v){
        try {
            if(e_names.getText().toString().isEmpty() || e_regno.getText().toString().isEmpty()){
                throw new Exception("All fields are required");
            }
            student = new Student();
            student.setNames(e_names.getText().toString());
            student.setRegNumber(e_regno.getText().toString());
            student.setFa1marks(Float.parseFloat(e_fa1marks.getText().toString()));
            student.setFa2marks(Float.parseFloat(e_fa2marks.getText().toString()));
            new DB(getApplicationContext()).createStudent(student);
            Toast.makeText(this, "Student created", Toast.LENGTH_SHORT).show();
            clearAllFields();
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void viewStudents(View v){
        startActivity(new Intent(MainActivity.this,StudentActivity.class));
    }

    public void clearAllFields(){
        e_names.setText("");
        e_regno.setText("");
        e_fa1marks.setText("");
        e_fa2marks.setText("");
    }


}