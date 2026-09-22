package com.floatingview;

import android.content.Context;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class EnFloatingView extends FloatingMagnetView {
    private final ImageView mIcon;

    public EnFloatingView(Context context) {
        this(context, R.layout.en_floating_view);
    }

    public EnFloatingView(Context context, int i) {
        super(context, null);
        inflate(context, i, this);
        this.mIcon = (ImageView) findViewById(R.id.icon);
    }

    public void setIconImage(int i) {
        this.mIcon.setImageResource(i);
    }
}
