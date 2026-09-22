package com.simplesearchview.utils;

import android.view.View;

import com.ferfalk.simplesearchview.utils.SimpleAnimationUtils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleAnimationListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/ferfalk/simplesearchview/utils/SimpleAnimationListener;", "Lcom/ferfalk/simplesearchview/utils/SimpleAnimationUtils$AnimationListener;", "()V", "onAnimationCancel", "", "view", "Landroid/view/View;", "onAnimationEnd", "onAnimationStart", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
public abstract class SimpleAnimationListener implements SimpleAnimationUtils.AnimationListener {
    @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.AnimationListener
    public boolean onAnimationCancel(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.AnimationListener
    public boolean onAnimationEnd(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.AnimationListener
    public boolean onAnimationStart(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }
}
