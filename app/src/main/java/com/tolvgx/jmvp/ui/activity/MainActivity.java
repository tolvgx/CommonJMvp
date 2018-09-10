package com.tolvgx.jmvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tolvgx.base.ui.activity.BaseActivity;
import com.tolvgx.base.utils.GlideUtils;
import com.tolvgx.jmvp.R;
import com.tolvgx.usercenter.event.MessageEvent;
import com.tolvgx.usercenter.ui.activity.LoginActivity;
import org.greenrobot.eventbus.EventBus;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);

                EventBus.getDefault().postSticky(new MessageEvent("测试"));
            }
        });

        GlideUtils.loadRoundImage(this, "http://info.flycua.com/jcms/upimg/1531286039086_201803222.png", imageView, 50);
    }
}
