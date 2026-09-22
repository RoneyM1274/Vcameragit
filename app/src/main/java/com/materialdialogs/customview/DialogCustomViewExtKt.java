package com.materialdialogs.customview;

import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogCustomViewExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aO\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u0007*\u00020\u0003H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"CUSTOM_VIEW_NO_VERTICAL_PADDING", "", "customView", "Lcom/afollestad/materialdialogs/MaterialDialog;", "viewRes", "", "view", "Landroid/view/View;", "scrollable", "", "noVerticalPadding", "horizontalPadding", "dialogWrapContent", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Landroid/view/View;ZZZZ)Lcom/afollestad/materialdialogs/MaterialDialog;", "getCustomView", "core"}, k = 2, mv = {1, 1, 16})
public final class DialogCustomViewExtKt {
    public static final String CUSTOM_VIEW_NO_VERTICAL_PADDING = "md.custom_view_no_vertical_padding";

    public static final View getCustomView(MaterialDialog getCustomView) {
        Intrinsics.checkParameterIsNotNull(getCustomView, "$this$getCustomView");
        View customView = getCustomView.getView().getContentLayout().getCustomView();
        if (customView != null) {
            return customView;
        }
        throw new IllegalStateException("You have not setup this dialog as a customView dialog.".toString());
    }

    public static /* synthetic */ MaterialDialog customView$default(MaterialDialog materialDialog, Integer num, View view, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = (Integer) null;
        }
        if ((i & 2) != 0) {
            view = (View) null;
        }
        return customView(materialDialog, num, view, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) == 0 ? z4 : false);
    }

    public static final MaterialDialog customView(final MaterialDialog customView, Integer num, View view, boolean z, boolean z2, boolean z3, final boolean z4) {
        Intrinsics.checkParameterIsNotNull(customView, "$this$customView");
        MDUtil.INSTANCE.assertOneSet("customView", view, num);
        customView.getConfig().put(CUSTOM_VIEW_NO_VERTICAL_PADDING, Boolean.valueOf(z2));
        if (z4) {
            MaterialDialog.maxWidth$default(customView, null, 0, 1, null);
        }
        View viewAddCustomView = customView.getView().getContentLayout().addCustomView(num, view, z, z2, z3);
        if (z4) {
            MDUtil.INSTANCE.waitForWidth(viewAddCustomView, new Function1<View, Unit>() { // from class: com.afollestad.materialdialogs.customview.DialogCustomViewExtKt$customView$$inlined$also$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View receiver) {
                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                    MaterialDialog.maxWidth$default(customView, null, Integer.valueOf(receiver.getMeasuredWidth()), 1, null);
                }
            });
        }
        return customView;
    }
}
