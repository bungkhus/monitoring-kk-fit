package com.jahtra.monitoringkkfit.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.jahtra.monitoringkkfit.Adapters.ContactsAdapter;
import com.jahtra.monitoringkkfit.Base.Base;
import com.jahtra.monitoringkkfit.Models.Contact;
import com.jahtra.monitoringkkfit.Models.Penelitian;
import com.jahtra.monitoringkkfit.Models.User;
import com.jahtra.monitoringkkfit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DummyFragment extends Fragment {

    private ArrayList<Contact> contacts;
    private Base base;

    public DummyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);
        base = new Base(getActivity());
        RecyclerView rvContacts = (RecyclerView) view.findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        ContactsAdapter adapter = new ContactsAdapter(getContext(), contacts);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));

        base.firebaseDatabase().child("penelitian").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    Log.d("penelitian key", child.getKey());
                    Penelitian penelitian = dataSnapshot.child(child.getKey()).getValue(Penelitian.class);
                    if (penelitian != null) {
                        System.out.println("judul = "+penelitian.getJudul());
                        System.out.println("judul = "+penelitian.getJudul());
                        for (DataSnapshot subChild: child.child("anggota").getChildren()) {
                            Log.d("anggota key", subChild.getKey());
                            System.out.println("anggota name = "+penelitian.getAnggota().get(subChild.getKey()).getName());
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        base.firebaseDatabase().child("penelitian").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }
}
