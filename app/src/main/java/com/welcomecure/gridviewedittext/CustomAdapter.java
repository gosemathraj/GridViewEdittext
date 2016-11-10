package com.welcomecure.gridviewedittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshG on 09-11-2016.
 */
public class CustomAdapter extends BaseAdapter {

    private List<String> list;
    private List<String> names = new ArrayList<>();
    private Context context;

    public CustomAdapter(List<String> list, Context context) {
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final String[] temp = {null};
        ViewHolder holder = null;
        if(view == null){

            view = LayoutInflater.from(context).inflate(R.layout.gridview_item,viewGroup,false);
            holder = new ViewHolder();
            holder.editText = (EditText) view.findViewById(R.id.edittext);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.ref = i;
        final ViewHolder finalHolder = holder;
        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                names.add(finalHolder.ref,editable.toString());
                Constants.getInstance().setEditTextValues(names);
            }

        });
        return view;
    }

    static class ViewHolder{

        private EditText editText;
        int ref;
    }
}
