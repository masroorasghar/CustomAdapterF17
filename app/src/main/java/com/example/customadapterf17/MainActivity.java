package com.example.customadapterf17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.customadapterf17.Adapters.CustomContactAdapter;
import com.example.customadapterf17.Enums.Gender;
import com.example.customadapterf17.Models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ADAPTER VIEW
        listView = (ListView) findViewById(R.id.listView);

        // DATA SOURCE
        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact("Name : Person " + (i + 1), "Phone : +92 " + (i + 1));
            if (Math.random() < 0.5) {
                contact.setGender(Gender.MALE);
                contact.setImage(R.drawable.male_placeholder);
            } else {
                contact.setGender(Gender.FEMALE);
                contact.setImage(R.drawable.female_placeholder);
            }
            contactList.add(contact);
        }

        // CUSTOM CONTACT ADAPTER
        CustomContactAdapter customContactAdapter = new CustomContactAdapter(contactList, this);

        // PLUG THE ADAPTER TO THE ADAPTER VIEW
        listView.setAdapter(customContactAdapter);
    }

}
