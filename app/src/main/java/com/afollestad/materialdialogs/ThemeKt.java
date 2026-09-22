package com.afollestad.materialdialogs;

import android.content.Context;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\b"}, d2 = {"inferTheme", "", "context", "Landroid/content/Context;", "dialogBehavior", "Lcom/afollestad/materialdialogs/DialogBehavior;", "inferThemeIsLight", "", "core"}, k = 2, mv = {1, 1, 16})
public final class ThemeKt {
    public static final int inferTheme(Context context, DialogBehavior dialogBehavior) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dialogBehavior, "dialogBehavior");
        return dialogBehavior.getThemeRes(!inferThemeIsLight(context));
    }

    public static final boolean inferThemeIsLight(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return MDUtil.isColorDark$default(MDUtil.INSTANCE, MDUtil.resolveColor$default(MDUtil.INSTANCE, context, null, Integer.valueOf(android.R.attr.textColorPrimary), null, 10, null), 0.0d, 1, null);
    }
}
