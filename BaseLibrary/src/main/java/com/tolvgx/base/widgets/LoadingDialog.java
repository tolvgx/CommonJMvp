package com.tolvgx.base.widgets;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tolvgx.base.R;
/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/28
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * 请求加载框
 */

public class LoadingDialog extends Dialog{

    private Context context;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.loadingDialogStyle);
        this.context = context;
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(context);
        ProgressBar progressBar = new ProgressBar(context);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(125, 125);
        params.setMargins(100, 50, 100, 50);
        progressBar.setLayoutParams(params);
        linearLayout.addView(progressBar);

        setContentView(linearLayout);

        //不可触摸边缘取消
        setCanceledOnTouchOutside(false);
    }
}
