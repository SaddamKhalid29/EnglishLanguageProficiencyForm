package com.example.loginapplication;

import java.util.Date;

public class Language {

    //Creating Variables
    private int id;
    private String rollNo;
    private String email;
    private String firstName;
    private String  lastName;
    private String date;
    private String Department;
    private String language;
    private String contactNo;
    private String cnicNo;
    private String registrationNo;
    private String subject;
    private String hodRemarks;


    //Getter and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCnicNo() {
        return cnicNo;
    }

    public void setCnicNo(String cnicNo) {
        this.cnicNo = cnicNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHodRemarks() {
        return hodRemarks;
    }

    public void setHodRemarks(String hodRemarks) {
        this.hodRemarks = hodRemarks;
    }
    //Default Constructor
    public Language(){
        rollNo="no roll_no";
        language="Not Known";
        subject ="Unknown";
        hodRemarks="Nothing";
    }
    //Parametrized Constructor
    public Language(String rollNo,String language,String subject,String hodRemarks){
        this.rollNo=rollNo;
        this.language=language;
        this.subject=subject;
        this.hodRemarks=hodRemarks;
    }
    public Language(int ID,String language,String subject,String hodRemarks){
        this.id=ID;
        this.language=language;
        this.subject=subject;
        this.hodRemarks=hodRemarks;
    }
    public Language(String language,String subject,String hodRemarks){
        this.language=language;
        this.subject=subject;
        this.hodRemarks=hodRemarks;
    }
    public Language(String rollNo,String email,String firstName,String  lastName, String date,String Department
            ,String language, String contactNo, String cnicNo, String registrationNo, String subject, String hodRemarks){
        this.rollNo=rollNo;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.date=date;
        this.Department=Department;
        this.language=language;
        this.contactNo=contactNo;
        this.cnicNo=cnicNo;
        this.registrationNo=registrationNo;
        this.subject=subject;
        this.hodRemarks=hodRemarks;
    }
    public Language(int id,String rollNo,String email,String firstName,String  lastName, String date,String Department
            ,String language, String contactNo, String cnicNo, String registrationNo, String subject, String hodRemarks){
        this.id=id;
        this.rollNo=rollNo;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.date=date;
        this.Department=Department;
        this.language=language;
        this.contactNo=contactNo;
        this.cnicNo=cnicNo;
        this.registrationNo=registrationNo;
        this.subject=subject;
        this.hodRemarks=hodRemarks;
    }
    //toString Method
    @Override
    public String toString() {
        return "rollNo="+rollNo+", language= "+language+", subject= " + subject +", hodRemarks= " + hodRemarks +"\n" ;
    }
}
