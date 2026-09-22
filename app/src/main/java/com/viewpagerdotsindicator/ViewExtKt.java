package com.viewpagerdotsindicator;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"setPaddingHorizontal", "", "Landroid/view/View;", "padding", "", "setPaddingVertical", "viewpagerdotsindicator_release"}, k = 2, mv = {1, 4, 2})
public final class ViewExtKt {
    public static final void setPaddingHorizontal(View setPaddingHorizontal, int i) {
        Intrinsics.checkNotNullParameter(setPaddingHorizontal, "$this$setPaddingHorizontal");
        setPaddingHorizontal.setPadding(i, setPaddingHorizontal.getPaddingTop(), i, setPaddingHorizontal.getPaddingBottom());
    }

    public static final void setPaddingVertical(View setPaddingVertical, int i) {
        Intrinsics.checkNotNullParameter(setPaddingVertical, "$this$setPaddingVertical");
        setPaddingVertical.setPadding(setPaddingVertical.getPaddingLeft(), i, setPaddingVertical.getPaddingRight(), i);
    }
}
