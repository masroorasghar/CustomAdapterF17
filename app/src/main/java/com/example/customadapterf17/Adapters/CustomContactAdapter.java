package com.example.customadapterf17.Adapters;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customadapterf17.Models.Contact;
import com.example.customadapterf17.R;

import java.util.List;

public class CustomContactAdapter extends BaseAdapter {

    private List<Contact> list;
    private Context context;

    public CustomContactAdapter(List<Contact> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // View Holder
    private class ContactViewHolder {

        ImageView imageView;
        TextView name;
        TextView phone;
        ImageView call_icon;

        ContactViewHolder(View view) {
            imageView = view.findViewById(R.id.imageView);
            name = view.findViewById(R.id.name);
            phone = view.findViewById(R.id.phone);
            call_icon = view.findViewById(R.id.call_icon);
            call_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri call = Uri.parse("tel: "+phone.getText());
                    Intent intent = new Intent(Intent.ACTION_DIAL, call);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Contact contact = list.get(i);
        View view = convertView;
        ContactViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.simple_contact_list_item, viewGroup,false);
            holder = new ContactViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ContactViewHolder) view.getTag();
        }

        holder.imageView.setImageResource(contact.getImage());
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());

        return view;
    }
}











