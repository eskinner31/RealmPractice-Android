package com.example.android.realmpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Skinner on 10/10/16.
 */

public class NameListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<NameModel> names = null;

    public NameListAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<NameModel> details) {
        this.names = details;
    }

    @Override
    public int getCount() {
        if (names == null) {
            return 0;
        }
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        if (names == null || names.get(position) == null) {
            return null;
        }
        return names.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        if (currentView == null) {
            currentView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        NameModel name = names.get(position);

        if (name != null) {
            ((TextView) currentView.findViewById(R.id.name)).setText(name.getName());
        }

        return currentView;
    }
}

