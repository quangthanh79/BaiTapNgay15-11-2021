package com.pqt.phamquangthanh.gmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InboxAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Inbox> inboxList;


    public InboxAdapter(Context context, int layout, ArrayList<Inbox> inboxList) {
        this.context = context;
        this.layout = layout;
        this.inboxList = inboxList;
    }

    @Override
    public int getCount() {
        return inboxList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        CircleImageView ivIcon;
        Inbox inbox = inboxList.get(i);

        TextView tvName,tvTime,tvContent;

        tvName = (TextView)  view.findViewById(R.id.tvName);
        tvTime= (TextView)  view.findViewById(R.id.tvTime);
        tvContent= (TextView)  view.findViewById(R.id.tvContent);
        ivIcon = (CircleImageView) view.findViewById(R.id.ivIcon);

        tvName.setText(inbox.getName_From().toString());
        tvContent.setText(inbox.getContent().toString());
        tvTime.setText(Convert.getFormTime(inbox.getDate()));
        return view;
    }}

