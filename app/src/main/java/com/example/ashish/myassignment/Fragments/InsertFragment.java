package com.example.ashish.myassignment.Fragments;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ashish.myassignment.R;
import com.example.ashish.myassignment.Subject;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFragment extends Fragment {

    EditText name, description;
    Button add;

    DatabaseReference databaseReference;

    public InsertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot=inflater.inflate(R.layout.fragment_insert, container, false);

        databaseReference= FirebaseDatabase.getInstance().getReference("subjects");

        name=viewRoot.findViewById(R.id.name_text);
        description=viewRoot.findViewById(R.id.description_text);
        add=viewRoot.findViewById(R.id.add_button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSubject();
            }
        });

        return viewRoot;
    }

    private void addSubject(){
        String sname=name.getText().toString().trim();
        String sdes=description.getText().toString().trim();

        AssignmentFragment assignmentFragment=new AssignmentFragment();

        if(!TextUtils.isEmpty(sname)&& !TextUtils.isEmpty(sdes))
        {
            String sid=databaseReference.push().getKey();

            Subject subject=new Subject(sid,sname,sdes);

            databaseReference.child(sid).setValue(subject);

            Toast.makeText(getActivity(),"Assignment added",Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getActivity(),"Enter name and description",Toast.LENGTH_LONG).show();
        }
    }


}
