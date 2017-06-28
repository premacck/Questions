package com.prembros.questions;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.question_1);
        }

        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);

        List<PageBeans> pageBeansList = new ArrayList<>();

        pageBeansList.add(setPageBeans(R.drawable.hdfc_bank_logo50, "HDFC\nABC Mutual Funds", 3500.00f, 3500.00f));
        pageBeansList.add(setPageBeans(R.drawable.sbi_logo50, "SBI\nXYZ Mutual Funds", 5000.45f, 1500.00f));

        recyclerView.setAdapter(new RecyclerViewAdapter(pageBeansList));
    }

    private PageBeans setPageBeans(int logoSrc, String name, float currentValue, float withdrawalAmount) {
        PageBeans pageBeans = new PageBeans();
        pageBeans.setLogoSrc(logoSrc);
        pageBeans.setName(name);
        pageBeans.setCurrentValue(currentValue);
        pageBeans.setWithdrawalAmount(withdrawalAmount);
        return pageBeans;
    }
}
