package com.example.loginapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

public class PrepareDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText stdName,father_Name,rollNo,email,etDate,etContact,etregistr,etCnic,etSubject,etHodRemark;
    Spinner etDepartment,etLang;
    Button btnDone;
    String depart;
    EditText etUsername,etPass;
    String language;
    DBHelper db=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_detail);
        stdName=findViewById(R.id.stdName);
        father_Name=findViewById(R.id.fatherName);
        rollNo=findViewById(R.id.rollNo);
        email=findViewById(R.id.etEmail);
        etDepartment=findViewById(R.id.department);
        etUsername=findViewById(R.id.etUserName);
        etPass=findViewById(R.id.etPassword);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.Department, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        etDepartment.setAdapter(adapter);
        etDepartment.setOnItemSelectedListener(this);
        etLang=findViewById(R.id.lang);
        ArrayAdapter<CharSequence> langadapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.Language, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        etLang.setAdapter(langadapter);
        etLang.setOnItemSelectedListener(this);
        etDate=findViewById(R.id.date);
        etContact=findViewById(R.id.contact);
        etregistr=findViewById(R.id.registrationNo);
        etCnic=findViewById(R.id.cnicNo);
        etSubject=findViewById(R.id.subj);
        etHodRemark=findViewById(R.id.hRemarks);
        btnDone=findViewById(R.id.btnDone);
        language=etLang.getSelectedItem().toString();
        depart=etDepartment.getSelectedItem().toString();
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(stdName.getText().toString().equals("") ||father_Name.getText().toString().equals("")||rollNo.getText().toString().equals("")||email.getText().toString().equals("")||etDate.getText().toString().equals("")||etContact.getText().toString().equals("")||
                        etregistr.getText().toString().equals("")||etCnic.getText().toString().equals("")||etSubject.getText().toString().equals("")||etHodRemark.getText().toString().equals("")){
                    Toast.makeText(PrepareDetailActivity.this, "Please fill out all the fields1...", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Putting data into the intent...
                    Intent intent=new Intent();
                    intent.putExtra("Student Name", stdName.getText().toString());
                    intent.putExtra("Father Name",father_Name.getText().toString());
                    intent.putExtra("Roll No",rollNo.getText().toString());
                    intent.putExtra("Email",email.getText().toString());
                    intent.putExtra("Department",etDepartment.getSelectedItem().toString());
                    intent.putExtra("Language",etLang.getSelectedItem().toString());
                    intent.putExtra("Date",etDate.getText().toString());
                    intent.putExtra("Contact No",etContact.getText().toString());
                    intent.putExtra("Registration",etregistr.getText().toString());
                    intent.putExtra("CNIC No",etCnic.getText().toString());
                    intent.putExtra("Subject",etSubject.getText().toString());
                    intent.putExtra("Hod Remarks",etHodRemark.getText().toString());
                    boolean result=  db.insert(stdName.getText().toString(),father_Name.getText().toString(),rollNo.getText().toString(),email.getText().toString(), (String) etDepartment.getSelectedItem(),etLang.getSelectedItem().toString(),etDate.getText().toString(),etContact.getText().toString(),etregistr.getText().toString(),etCnic.getText().toString(),etSubject.getText().toString(),etHodRemark.getText().toString());
                    if(result==true){
                        Toast.makeText(PrepareDetailActivity.this, "Data is inserted..", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(PrepareDetailActivity.this, "Unsuccessful to insert ", Toast.LENGTH_SHORT).show();
                    }
                    PrepareDetailActivity.this.setResult(RESULT_OK,intent);

                    PrepareDetailActivity.this.finish();
                }

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.context_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                PrepareDetailActivity.this.finish();
                etUsername.setText("");
                etPass.setText("");
                break;
            case R.id.profile:
                break;
            case R.id.setting:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        depart=parent.getItemAtPosition(position).toString();
        language=parent.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}