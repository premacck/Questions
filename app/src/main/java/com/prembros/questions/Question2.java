package com.prembros.questions;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.prembros.questions.Fragment1.OnFragment1InteractionListener;
import com.prembros.questions.Fragment2.OnFragment2InteractionListener;

public class Question2 extends AppCompatActivity
        implements OnFragment1InteractionListener,
        OnFragment2InteractionListener {

    private FragmentManager fragmentManager;
    private Integer a;
    private Integer b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.question_2);
        }

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.container1, new Fragment1(), "fragment1")
                .add(R.id.container2, new Fragment2(), "fragment1")
                .add(R.id.container3, new Fragment3(), "fragment3")
                .commit();
    }

    @Override
    public void onFragment1Interaction(@Nullable final Integer a) {
        this.a = a;
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                fragmentManager.beginTransaction()
                        .replace(R.id.container3, Fragment3.newInstance(performSum(a, b)), "fragment3")
                        .commit();
            }
        });
    }

    @Override
    public void onFragment2Interaction(@Nullable final Integer b) {
        this.b = b;
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                fragmentManager.beginTransaction()
                        .replace(R.id.container3, Fragment3.newInstance(performSum(a, b)), "fragment3")
                        .commit();
            }
        });
    }

    private Integer performSum(Integer a, Integer b) {
        if (a != null && b != null) {
            return a + b;
        } else return null;
    }
}
