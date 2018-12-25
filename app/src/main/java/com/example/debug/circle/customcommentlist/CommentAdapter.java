package com.example.debug.circle.customcommentlist;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/24
 * description:
 */

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.debug.circle.R;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter {
    private Context mContext;
    private CommentListView mListview;
    private List<CommentItem> mDatas;

    public CommentAdapter(Context context){
        mContext=context;
        mDatas=new ArrayList();
    }
    public CommentAdapter(Context context,List datas){
        mContext=context;
        mDatas=datas;
    }
    public void bindListView(CommentListView listView){
        if(listView==null){
            throw new IllegalArgumentException("listview is null");
        }
        mListview=listView;
    }
    public void setDatas(List<CommentItem> datas){
        if(datas==null){
            datas=new ArrayList<CommentItem>();
        }
        mDatas=datas;
    }

    private View getView(final int position){
        View convertView=View.inflate(mContext,R.layout.item_social_comment,null);
        TextView commentTv=convertView.findViewById(R.id.commentTv);
        CommentItem bean= mDatas.get(position);
        String name=bean.getUserNickname();
        String toReplyName="";
        if(bean.getAppointUserid()!=null){
            toReplyName=bean.getAppointUserNickname();
        }
        SpannableStringBuilder builder=new SpannableStringBuilder();
        builder.append(setClickableSpan(name,bean.getUserId(),0));
        if(!TextUtils.isEmpty(toReplyName)){
            builder.append("回复");
            builder.append(setClickableSpan(toReplyName,bean.getAppointUserNickname(),1));
        }
        builder.append(":");
        builder.append(bean.getContent());
        commentTv.setMovementMethod(new CircleMovementMethod());
        commentTv.setText(builder);
        return convertView;
    }
    private SpannableString setClickableSpan(String textStr,String userId,int position){
        SpannableString subjectSpanText=new SpannableString(textStr);
        subjectSpanText.setSpan(new NameClickable(new NameClickListener(subjectSpanText,userId),position),0,subjectSpanText.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return subjectSpanText;
    }
}
