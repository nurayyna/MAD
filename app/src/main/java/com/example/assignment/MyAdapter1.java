package com.example.assignment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter1 extends ArrayAdapter<String> {

    String[] names;
    int [] icons;
    Context mcontext;

    public MyAdapter1(Context context, String[] routeName, int[] iconRoute ){
        super (context, R.layout.listview_item);
        this.names = routeName;
        this.icons = iconRoute;
        this.mcontext=context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mIcon = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mIcon.setImageResource(icons[position]);
        mViewHolder.mName.setText(names[position]);

        return convertView;
    }

    static class ViewHolder{
        ImageView mIcon ;
        TextView mName;
    }
}
