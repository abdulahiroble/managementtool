package com.managementtool.demo.models;

public class Category {
    private String categoryname;
    private int idcategory;

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public Category(int idcategory, String categoryname) {
        this.categoryname = categoryname;
        this.idcategory = idcategory;
    }

    public Category() {

    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }
}
