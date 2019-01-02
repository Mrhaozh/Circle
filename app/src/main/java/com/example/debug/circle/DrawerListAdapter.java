package com.example.debug.circle;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2019/1/2
 * description:
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DrawerListAdapter extends BaseAdapter {
    private Context context;
    public DrawerListAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return 4;
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
        ViewHolder viewHolder;
        if(view==null){
            viewHolder=new ViewHolder();
            view =LayoutInflater.from(context).inflate(R.layout.item_drawerlist,viewGroup,false);
            viewHolder.title=view.findViewById(R.id.title);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.title.setText("个人设置"+i);
        return view;
    }
    private class ViewHolder{
        TextView title;
    }
}
