package com.example.abecruz.mvvm_contacts.model.data;

import com.example.abecruz.mvvm_contacts.model.People;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleResponse {

  @SerializedName("results") private List<People> peopleList;

  public List<People> getPeopleList() {
    return peopleList;
  }

  public void setPeopleList(List<People> mPeopleList) {
    this.peopleList = mPeopleList;
  }
}
