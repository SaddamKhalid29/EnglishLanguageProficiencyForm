package com.example.loginapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyItemViewHolder> {
    List<Language> languageList=new ArrayList<>();
    MyItemViewHolder myItemViewHolder;
    DBHelper db;
    @NonNull
    @Override
    public MyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         db=new DBHelper(parent.getContext());
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail,parent,false);
        myItemViewHolder=new MyItemViewHolder(view);
        return myItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvLanguage.setText(languageList.get(position).getLanguage());
        holder.tvSubject.setText(languageList.get(position).getSubject());
        holder.tvHodRemarks.setText(languageList.get(position).getHodRemarks());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageList.remove(position);
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public static class MyItemViewHolder extends RecyclerView.ViewHolder{
        //References Create
        TextView tvLanguage,tvSubject,tvHodRemarks;
        Button btnDelete;
        ConstraintLayout Rowid;
        public MyItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLanguage=itemView.findViewById(R.id.tvLanguage);
            tvSubject=itemView.findViewById(R.id.tvSubject);
            tvHodRemarks=itemView.findViewById(R.id.tvHODRemarks);
            Rowid=itemView.findViewById(R.id.RowId);
            btnDelete=itemView.findViewById(R.id.btnDel);

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