package com.example.ashish.myassignment.Fragments;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

import com.example.ashish.myassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment {

    FloatingActionButton fa;


    public AssignmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View viewRoot= inflater.inflate(R.layout.fragment_assignment, container, false);

        fa=viewRoot.findViewById(R.id.floatingActionButton);
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertFragment insertFragment=new InsertFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, insertFragment).commit();
            }
        });
        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Assignments");
    }


}
