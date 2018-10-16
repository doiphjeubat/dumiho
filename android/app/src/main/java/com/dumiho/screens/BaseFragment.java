package com.dumiho.screens;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dumiho.MainActivity;

import butterknife.ButterKnife;

/**
 * Created by ThuanNH4 on 10/17/18.
 */

public abstract class BaseFragment extends Fragment {

    protected MainActivity context;

    protected FragmentManager fm;

    protected SharedPreferences pref;

    public abstract View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = (MainActivity) getActivity();
        fm = ((MainActivity) getActivity()).getFM();
        pref = ((MainActivity) getActivity()).getSaved();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = onCreateFragmentView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);

        return view;
    }

}
