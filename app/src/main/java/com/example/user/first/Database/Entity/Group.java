package com.example.user.first.Database.Entity;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


@DatabaseTable
public class Group  implements Serializable {


    @Expose
    @DatabaseField(generatedId = true, columnName = "id", allowGeneratedIdInsert = true, index = true)
    private int id;

    @Expose
    @DatabaseField
    private String first;

    @Expose
    @DatabaseField
    private String second;

    @Expose
    @DatabaseField
    private String result;

    @Expose
    @DatabaseField
    private String operation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
