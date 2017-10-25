package com.example.abecruz.mvvm_contacts.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abecruz.mvvm_contacts.R;
import com.example.abecruz.mvvm_contacts.databinding.PeopleActivityBinding;
import com.example.abecruz.mvvm_contacts.viewmodel.PeopleViewModel;

import java.util.Observable;
import java.util.Observer;

public class PeopleActivity extends AppCompatActivity implements Observer {

    private PeopleActivityBinding peopleActivityBinding;
    private PeopleViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        //setSupportActionBar(peopleActivityBinding.toolbar);
        setupListPeopleView(peopleActivityBinding.listPeople);
        setupObserver(peopleViewModel);
    }

    private void initDataBinding() {
        peopleActivityBinding = DataBindingUtil.setContentView(this, R.layout.people_activity);
        peopleViewModel = new PeopleViewModel(this);
        peopleActivityBinding.setMainViewModel(peopleViewModel);
    }

    private void setupListPeopleView(RecyclerView listPeople) {
        PeopleAdapter adapter = new PeopleAdapter();
        listPeople.setAdapter(adapter);
        listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        peopleViewModel.reset();
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof PeopleViewModel) {
            PeopleAdapter peopleAdapter = (PeopleAdapter) peopleActivityBinding.listPeople.getAdapter();
            PeopleViewModel peopleViewModel = (PeopleViewModel) observable;
            peopleAdapter.setPeopleList(peopleViewModel.getPeopleList());
        }
    }
}

