
package com.example.abecruz.mvvm_contacts.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Name implements Serializable {

  @SerializedName("title") public String title;

  @SerializedName("first") public String firts;

  @SerializedName("last") public String last;
}
