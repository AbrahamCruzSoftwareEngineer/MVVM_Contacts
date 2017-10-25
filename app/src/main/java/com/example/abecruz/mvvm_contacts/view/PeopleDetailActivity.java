package com.example.abecruz.mvvm_contacts.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abecruz.mvvm_contacts.R;
import com.example.abecruz.mvvm_contacts.databinding.PeopleDetailActivityBinding;
import com.example.abecruz.mvvm_contacts.model.People;
import com.example.abecruz.mvvm_contacts.viewmodel.PeopleDetailViewModel;

public class PeopleDetailActivity extends AppCompatActivity {

    private static final String EXTRA_PEOPLE = "EXTRA_PEOPLE";

    private PeopleDetailActivityBinding peopleDetailActivityBinding;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        peopleDetailActivityBinding =
                DataBindingUtil.setContentView(this, R.layout.people_detail_activity);
        setSupportActionBar(peopleDetailActivityBinding.toolbar);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
    }

    public static Intent launchDetail(Context context, People people) {
        Intent intent = new Intent(context, PeopleDetailActivity.class);
        intent.putExtra(EXTRA_PEOPLE, people);
        return intent;
    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void getExtrasFromIntent() {
        People people = (People) getIntent().getSerializableExtra(EXTRA_PEOPLE);
        PeopleDetailViewModel peopleDetailViewModel = new PeopleDetailViewModel(people);
        peopleDetailActivityBinding.setPeopleDetailViewModel(peopleDetailViewModel);
        setTitle(people.name.title + "." + people.name.firts + " " + people.name.last);
    }
}
