package com.example.debug.circle.customcommentlist;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/24
 * description:
 */

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import com.example.debug.circle.MyApp;
import com.example.debug.circle.R;

public class NameClickable extends ClickableSpan implements View.OnClickListener {
    private final ISpanClick mListener;
    private int mPosition;
    public NameClickable(ISpanClick l,int position){
        mListener=l;
        mPosition=position;
    }
    @Override
    public void onClick(View view) {
            mListener.onClick(mPosition);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        int colorValue= R.color.colorAccent;
        ds.setColor(MyApp.mContext.getResources().getColor(colorValue));
        ds.setUnderlineText(false);
        ds.clearShadowLayer();
    }
}
