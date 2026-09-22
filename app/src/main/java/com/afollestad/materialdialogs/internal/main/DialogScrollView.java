package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogScrollView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0014J(\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0014R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isScrollable", "", "()Z", "rootView", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getRootView", "()Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "setRootView", "(Lcom/afollestad/materialdialogs/internal/main/DialogLayout;)V", "invalidateDividers", "", "invalidateOverScroll", "onAttachedToWindow", "onScrollChanged", "left", "", "top", "oldl", "oldt", "core"}, k = 1, mv = {1, 1, 16})
public final class DialogScrollView extends ScrollView {
    private DialogLayout rootView;

    public /* synthetic */ DialogScrollView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? (AttributeSet) null : attributeSet);
    }

    public DialogScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final DialogLayout getRootView() {
        return this.rootView;
    }

    public final void setRootView(DialogLayout dialogLayout) {
        this.rootView = dialogLayout;
    }

    private final boolean isScrollable() {
        View childAt = getChildAt(0);
        Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(0)");
        return childAt.getMeasuredHeight() > getHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MDUtil.INSTANCE.waitForWidth(this, new Function1<DialogScrollView, Unit>() { // from class: com.afollestad.materialdialogs.internal.main.DialogScrollView.onAttachedToWindow.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogScrollView dialogScrollView) {
                invoke2(dialogScrollView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DialogScrollView receiver) {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                receiver.invalidateDividers();
                receiver.invalidateOverScroll();
            }
        });
    }

    @Override // android.view.View
    protected void onScrollChanged(int left, int top, int oldl, int oldt) {
        super.onScrollChanged(left, top, oldl, oldt);
        invalidateDividers();
    }

    public final void invalidateDividers() {
        if (getChildCount() == 0 || getMeasuredHeight() == 0 || !isScrollable()) {
            DialogLayout dialogLayout = this.rootView;
            if (dialogLayout != null) {
                dialogLayout.invalidateDividers(false, false);
                return;
            }
            return;
        }
        View view = getChildAt(getChildCount() - 1);
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        int bottom = view.getBottom() - (getMeasuredHeight() + getScrollY());
        DialogLayout dialogLayout2 = this.rootView;
        if (dialogLayout2 != null) {
            dialogLayout2.invalidateDividers(getScrollY() > 0, bottom > 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverScroll() {
        setOverScrollMode((getChildCount() == 0 || getMeasuredHeight() == 0 || !isScrollable()) ? 2 : 1);
    }
}
