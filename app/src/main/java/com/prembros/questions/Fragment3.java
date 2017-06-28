package com.prembros.questions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment3 extends Fragment {
    private static final String ARG_PARAM1 = "c";

    private Integer mParam1;

    public Fragment3() {
        // Required empty public constructor
    }

    public static Fragment3 newInstance(Integer param1) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        if (param1 != null) args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment3, container, false);

        TextView textView = rootView.findViewById(R.id.c);
        if (mParam1 != null) {
            textView.setText(String.valueOf(mParam1));
        } else textView.setText("");

        return rootView;
    }
}
