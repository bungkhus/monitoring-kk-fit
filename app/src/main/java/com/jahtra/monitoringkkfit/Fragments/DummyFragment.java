package com.jahtra.monitoringkkfit.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return view;
    }
}
