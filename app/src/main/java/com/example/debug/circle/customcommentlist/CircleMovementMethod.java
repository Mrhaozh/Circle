package com.example.debug.circle.customcommentlist;
/*
 * @author xy
 * @emil 384813636@qq.com
 * create at 2018/12/25
 * description:
 */

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

import com.example.debug.circle.MyApp;
import com.example.debug.circle.R;

public class CircleMovementMethod extends BaseMovementMethod {
    public final String TAG = CircleMovementMethod.class.getSimpleName();
    public final static int DEFAULT_COLOR = R.color.transparent;
    private int mTextViewBgColorId;
    private int mClickableSpanBgColorId;
    private BackgroundColorSpan mBgSpan;
    private ClickableSpan[] mClickLinks;
    private boolean isPassToTv = true;

    public boolean isPassToTv() {
        return isPassToTv;
    }

    public void setPassToTv(boolean passToTv) {
        isPassToTv = passToTv;
    }

    public CircleMovementMethod() {
        mTextViewBgColorId = DEFAULT_COLOR;
        mClickableSpanBgColorId = DEFAULT_COLOR;
    }

    public CircleMovementMethod(int clickableSpanBgColorId) {
        mClickableSpanBgColorId = clickableSpanBgColorId;
        mTextViewBgColorId = DEFAULT_COLOR;
    }

    public CircleMovementMethod(int clickableSpanBgColorId, int textViewBgColorId) {
        mClickableSpanBgColorId = clickableSpanBgColorId;
        mTextViewBgColorId = textViewBgColorId;
    }

    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();

            x += widget.getScrollX();
            y += widget.getScrollY();
            Layout layout = widget.getLayout();
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);
            mClickLinks = buffer.getSpans(off, off, ClickableSpan.class);
            if (mClickLinks.length > 0) {
                setPassToTv(false);
                Selection.setSelection(buffer, buffer.getSpanStart(mClickLinks[0]), buffer.getSpanEnd(mClickLinks[0]));
                mBgSpan=new BackgroundColorSpan(MyApp.mContext.getResources().getColor(mClickableSpanBgColorId));
                buffer.setSpan(mBgSpan,buffer.getSpanStart(mClickLinks[0]),buffer.getSpanEnd(mClickLinks[0]),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else{
                setPassToTv(true);
                widget.setBackgroundResource(mTextViewBgColorId);
            }

        }else if(action==MotionEvent.ACTION_UP){
            if(mClickLinks.length>0){
                mClickLinks[0].onClick(widget);
                if(mBgSpan!=null){
                    buffer.removeSpan(mBgSpan);
                }
            }else{
                if(mBgSpan !=null){
                    buffer.removeSpan(mBgSpan);
                }
            }
            Selection.removeSelection(buffer);
            widget.setBackgroundResource(DEFAULT_COLOR);
        }else if(action==MotionEvent.ACTION_MOVE){

        }else{
            if(mBgSpan!=null){
                buffer.removeSpan(mBgSpan);
            }
            widget.setBackgroundResource(DEFAULT_COLOR);
        }
        return Touch.onTouchEvent(widget,buffer,event);
    }
}
