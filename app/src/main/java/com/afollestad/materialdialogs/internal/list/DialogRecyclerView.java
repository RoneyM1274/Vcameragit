package com.afollestad.materialdialogs.internal.list;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.utils.DialogsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: DialogRecyclerView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0014J\b\u0010\u001c\u001a\u00020\u000eH\u0014J(\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0014RF\u0010\u0007\u001a:\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\u0004\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006#"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "invalidateDividersDelegate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "scrolledDown", "atBottom", "", "Lcom/afollestad/materialdialogs/internal/list/InvalidateDividersDelegate;", "scrollListeners", "com/afollestad/materialdialogs/internal/list/DialogRecyclerView$scrollListeners$1", "Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView$scrollListeners$1;", "attach", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "invalidateDividers", "invalidateOverScroll", "isAtBottom", "isAtTop", "isScrollable", "onAttachedToWindow", "onDetachedFromWindow", "onScrollChanged", "left", "", "top", "oldl", "oldt", "core"}, k = 1, mv = {1, 1, 16})
public final class DialogRecyclerView extends RecyclerView {
    private Function2<? super Boolean, ? super Boolean, Unit> invalidateDividersDelegate;
    private final DialogRecyclerView$scrollListeners$1 scrollListeners;

    /* JADX INFO: renamed from: com.afollestad.materialdialogs.internal.list.DialogRecyclerView$attach$1, reason: invalid class name */
    /* JADX INFO: compiled from: DialogRecyclerView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "showTop", "p2", "showBottom", "invoke"}, k = 3, mv = {1, 1, 16})
    static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function2<Boolean, Boolean, Unit> {
        AnonymousClass1(MaterialDialog materialDialog) {
            super(2, materialDialog);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "invalidateDividers";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinPackage(DialogsKt.class, "core");
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "invalidateDividers(Lcom/afollestad/materialdialogs/MaterialDialog;ZZ)V";
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
            invoke(bool.booleanValue(), bool2.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z, boolean z2) {
            DialogsKt.invalidateDividers((MaterialDialog) this.receiver, z, z2);
        }
    }

    public /* synthetic */ DialogRecyclerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? (AttributeSet) null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.afollestad.materialdialogs.internal.list.DialogRecyclerView$scrollListeners$1] */
    public DialogRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.scrollListeners = new RecyclerView.OnScrollListener() { // from class: com.afollestad.materialdialogs.internal.list.DialogRecyclerView$scrollListeners$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                this.this$0.invalidateDividers();
            }
        };
    }

    public final void attach(MaterialDialog dialog) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        this.invalidateDividersDelegate = new AnonymousClass1(dialog);
    }

    public final void invalidateDividers() {
        Function2<? super Boolean, ? super Boolean, Unit> function2;
        if (getChildCount() == 0 || getMeasuredHeight() == 0 || (function2 = this.invalidateDividersDelegate) == null) {
            return;
        }
        function2.invoke(Boolean.valueOf(!isAtTop()), Boolean.valueOf(!isAtBottom()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MDUtil.INSTANCE.waitForWidth(this, new Function1<DialogRecyclerView, Unit>() { // from class: com.afollestad.materialdialogs.internal.list.DialogRecyclerView.onAttachedToWindow.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogRecyclerView dialogRecyclerView) {
                invoke2(dialogRecyclerView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DialogRecyclerView receiver) {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                receiver.invalidateDividers();
                receiver.invalidateOverScroll();
            }
        });
        addOnScrollListener(this.scrollListeners);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeOnScrollListener(this.scrollListeners);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onScrollChanged(int left, int top, int oldl, int oldt) {
        super.onScrollChanged(left, top, oldl, oldt);
        invalidateDividers();
    }

    private final boolean isAtTop() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                return true;
            }
        } else if ((layoutManager instanceof GridLayoutManager) && ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
            return true;
        }
        return false;
    }

    private final boolean isAtBottom() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(adapter, "adapter!!");
        int itemCount = adapter.getItemCount() - 1;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == itemCount) {
                return true;
            }
        } else if ((layoutManager instanceof GridLayoutManager) && ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == itemCount) {
            return true;
        }
        return false;
    }

    private final boolean isScrollable() {
        return isAtBottom() && isAtTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverScroll() {
        int i = 2;
        if (getChildCount() != 0 && getMeasuredHeight() != 0 && !isScrollable()) {
            i = 1;
        }
        setOverScrollMode(i);
    }
}
