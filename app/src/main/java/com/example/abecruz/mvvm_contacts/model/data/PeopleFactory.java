
package com.example.abecruz.mvvm_contacts.model.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleFactory {

  private final static String BASE_URL = "http://api.randomuser.me/";

  public static PeopleService create() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    return retrofit.create(PeopleService.class);
  }
}
