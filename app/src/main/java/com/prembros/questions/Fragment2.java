package com.prembros.questions;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Fragment2 extends Fragment {

    private OnFragment2InteractionListener mListener;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        final EditText b = rootView.findViewById(R.id.b);

        b.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mListener != null) {
                    if (!editable.toString().equals(""))
                        mListener.onFragment2Interaction(Integer.parseInt(editable.toString()));
                    else mListener.onFragment2Interaction(null);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2InteractionListener) {
            mListener = (OnFragment2InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    interface OnFragment2InteractionListener {
        void onFragment2Interaction(@Nullable Integer b);
    }
}
