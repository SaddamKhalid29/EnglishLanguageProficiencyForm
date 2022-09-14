package com.example.loginapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyItemViewHolder>  {
    List<Language> languageList = new ArrayList<>();
    MyItemViewHolder myItemViewHolder;
    public Context context;
    DBHelper dbHelper;
    HomeActivity homeActivity;
    public RVAdapter(Context context) {
        this.context = context;
        dbHelper = new DBHelper(this.context);
       // homeActivity=new HomeActivity(this.context);
    }

    @NonNull
    @Override
    public MyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail, parent, false);
        myItemViewHolder = new MyItemViewHolder(view);
        return myItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvRollNo.setText(languageList.get(position).getRollNo());
        holder.tvLanguage.setText(languageList.get(position).getLanguage());
        holder.tvSubject.setText(languageList.get(position).getSubject());
        holder.tvHodRemarks.setText(languageList.get(position).getHodRemarks());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollNo = languageList.get(position).getRollNo();
                Log.i("RollNo", "This is roll no to delete " + rollNo);
                //Toast.makeText(new HomeActivity(), "The roll no is"+rollNo, Toast.LENGTH_SHORT).show();
                // HomeActivity.dbHelper.deleteData(rollNo);
                dbHelper.deleteData(rollNo);
                languageList.remove(position);

                notifyDataSetChanged();
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position,languageList.size());
//                boolean check=dbHelper.deletData(rollNo);
//                if(check==true){
//                    Log.i("RollNo","Item is removed");
//                }else{
//                    Log.i("RollNo","Item is not removed");
//                }

            }
        });
        holder.Rowid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(v.getContext());
                dialog.setContentView(R.layout.activity_prepare_detail);
                EditText stdName=dialog.findViewById(R.id.stdName);
                EditText fName=dialog.findViewById(R.id.fatherName);
                EditText rollNo=dialog.findViewById(R.id.rollNo);
                EditText email=dialog.findViewById(R.id.etEmail);
                Spinner dep=dialog.findViewById(R.id. department);
                Spinner lang=dialog.findViewById(R.id.lang);
                EditText date=dialog.findViewById(R.id.date);
                EditText contact=dialog.findViewById(R.id.contact);
                EditText registration=dialog.findViewById(R.id.registrationNo);
                EditText cnicNo=dialog.findViewById(R.id.cnicNo);
                EditText subj=dialog.findViewById(R.id.subj);
                EditText hRemarks=dialog.findViewById(R.id.hRemarks);
                Button btnUpdate=dialog.findViewById(R.id.btnDone);
                btnUpdate.setText("Update Record");
                stdName.setText((languageList.get(position)).getFirstName());
                fName.setText((languageList.get(position)).getLastName());
                rollNo.setText((languageList.get(position)).getRollNo());
                email.setText((languageList.get(position)).getEmail());
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(v.getContext(),R.array.Department, android.R.layout.simple_list_item_1);
                adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                dep.setAdapter(adapter);

                ArrayAdapter<CharSequence> langadapter=ArrayAdapter.createFromResource(v.getContext(),R.array.Language, android.R.layout.simple_list_item_1);
                adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                lang.setAdapter(langadapter);
//                String depart=dep.getSelectedItem().toString();
//                String languag=lang.getSelectedItem().toString();
                date.setText((languageList.get(position)).getDate());
                contact.setText((languageList.get(position)).getContactNo());
                registration.setText((languageList.get(position)).getRegistrationNo());
                cnicNo.setText((languageList.get(position)).getCnicNo());
                subj.setText((languageList.get(position)).getSubject());
                hRemarks.setText((languageList.get(position)).getHodRemarks());

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sName,fatherName,rollno,eMail,Date,contactNo,registrations,cnic,Subj,hremarks;
                        sName=stdName.getText().toString();
                        fatherName=fName.getText().toString();
                        rollno=rollNo.getText().toString();
                        eMail=email.getText().toString();
                        Date=date.getText().toString();
                        contactNo=contact.getText().toString();
                        registrations=registration.getText().toString();
                        cnic=cnicNo.getText().toString();
                        Subj=subj.getText().toString();
                        hremarks=hRemarks.getText().toString();
                        languageList.set(position,new Language(position,rollno,eMail,sName,fatherName,Date,dep.getSelectedItem().toString(),lang.getSelectedItem().toString(),contactNo,cnic,registrations,Subj,hremarks));
                        dbHelper.Update(sName,fatherName,rollno,eMail,dep.getSelectedItem().toString(),lang.getSelectedItem().toString(),Date,contactNo,registrations,cnic,Subj,hremarks);
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
//                Intent intent=new Intent(v.getContext(),PrepareDetailActivity.class);
//                startActivity(intent)
//                Intent intent=new Intent(homeActivity.getBaseContext(),PrepareDetailActivity.class);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public static class MyItemViewHolder extends RecyclerView.ViewHolder {
        //References Create
        TextView tvLanguage, tvSubject, tvHodRemarks, tvRollNo;
        Button btnDelete;
        ConstraintLayout Rowid;

        public MyItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRollNo = itemView.findViewById(R.id.delRollNo);
            tvLanguage = itemView.findViewById(R.id.tvLanguage);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            tvHodRemarks = itemView.findViewById(R.id.tvHODRemarks);
            Rowid = itemView.findViewById(R.id.RowId);
            btnDelete = itemView.findViewById(R.id.btnDel);


        }
    }

}


//        holder.Rowid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog dialog=new Dialog(v.getContext());
//                dialog.setContentView(R.layout.activity_prepare_detail);
//                EditText stdName=dialog.findViewById(R.id.stdName);
//                EditText father_Name=dialog.findViewById(R.id.fatherName);
//                EditText rollNo=dialog.findViewById(R.id.rollNo);
//                EditText email=dialog.findViewById(R.id.etEmail);
//                Spinner etDepartment=dialog.findViewById(R.id.department);
//                Spinner etLang=dialog.findViewById(R.id.lang);
//                EditText etDate=dialog.findViewById(R.id.date);
//                EditText etContact=dialog.findViewById(R.id.contact);
//                EditText etregistr=dialog.findViewById(R.id.registrationNo);
//                EditText etCnic=dialog.findViewById(R.id.cnicNo);
//                EditText etSubject=dialog.findViewById(R.id.subj);
//                EditText etHodRemark=dialog.findViewById(R.id.hRemarks);
//                EditText btnUpdate=dialog.findViewById(R.id.btnDone);
//
//                btnUpdate.setText("Update");
//
//
//                stdName.setText((languageList.get(position)).getFirstName());
//                father_Name.setText((languageList.get(position)).getLastName());
//                rollNo.setText((languageList.get(position)).getRollNo());
//                email.setText((languageList.get(position)).getEmail());
//                etDepartment.getSelectedItem().toString();
//                etLang.getSelectedItem().toString();
//                etDate.setText((languageList.get(position)).getDate());
//                etContact.setText((languageList.get(position)).getContactNo());
//                etregistr.setText((languageList.get(position)).getRegistrationNo());
//                etCnic.setText((languageList.get(position)).getCnicNo());
//                etSubject.setText((languageList.get(position)).getSubject());
//                etHodRemark.setText((languageList.get(position)).getHodRemarks());
//                btnUpdate.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                    }
//                });
//                dialog.show();
//            }
//        });