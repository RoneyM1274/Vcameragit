package com.materialdialogs.internal.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.ThemeKt;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J%\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\r2\b\b\u0001\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "disabledColor", "", "enabledColor", "enabledColorOverride", "Ljava/lang/Integer;", "setEnabled", "", "enabled", "", "update", "baseContext", "appContext", "stacked", "update$core", "updateTextColor", "color", "Companion", "core"}, k = 1, mv = {1, 1, 16})
public final class DialogActionButton extends AppCompatButton {
    private static final int CASING_UPPER = 1;
    private int disabledColor;
    private int enabledColor;
    private Integer enabledColorOverride;

    public /* synthetic */ DialogActionButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? (AttributeSet) null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setClickable(true);
        setFocusable(true);
    }

    public final void update$core(Context baseContext, final Context appContext, boolean stacked) {
        int i;
        Intrinsics.checkParameterIsNotNull(baseContext, "baseContext");
        Intrinsics.checkParameterIsNotNull(appContext, "appContext");
        setSupportAllCaps(MDUtil.INSTANCE.resolveInt(appContext, R.attr.md_button_casing, 1) == 1);
        boolean zInferThemeIsLight = ThemeKt.inferThemeIsLight(appContext);
        this.enabledColor = MDUtil.resolveColor$default(MDUtil.INSTANCE, appContext, null, Integer.valueOf(R.attr.md_color_button_text), new Function0<Integer>() { // from class: com.afollestad.materialdialogs.internal.button.DialogActionButton$update$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return MDUtil.resolveColor$default(MDUtil.INSTANCE, appContext, null, Integer.valueOf(R.attr.colorPrimary), null, 10, null);
            }
        }, 2, null);
        if (zInferThemeIsLight) {
            i = R.color.md_disabled_text_light_theme;
        } else {
            i = R.color.md_disabled_text_dark_theme;
        }
        this.disabledColor = MDUtil.resolveColor$default(MDUtil.INSTANCE, baseContext, Integer.valueOf(i), null, null, 12, null);
        Integer num = this.enabledColorOverride;
        setTextColor(num != null ? num.intValue() : this.enabledColor);
        Drawable drawableResolveDrawable$default = MDUtil.resolveDrawable$default(MDUtil.INSTANCE, baseContext, null, Integer.valueOf(R.attr.md_button_selector), null, 10, null);
        if (Build.VERSION.SDK_INT >= 21 && (drawableResolveDrawable$default instanceof RippleDrawable)) {
            MDUtil mDUtil = MDUtil.INSTANCE;
            int iResolveColor$default = MDUtil.resolveColor$default(MDUtil.INSTANCE, baseContext, null, Integer.valueOf(R.attr.md_ripple_color), new Function0<Integer>() { // from class: com.afollestad.materialdialogs.internal.button.DialogActionButton$update$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return ColorsKt.adjustAlpha(MDUtil.resolveColor$default(MDUtil.INSTANCE, appContext, null, Integer.valueOf(R.attr.colorPrimary), null, 10, null), 0.12f);
                }
            }, 2, null);
            if (iResolveColor$default != 0) {
                ((RippleDrawable) drawableResolveDrawable$default).setColor(ColorStateList.valueOf(iResolveColor$default));
            }
        }
        setBackground(drawableResolveDrawable$default);
        if (stacked) {
            ViewsKt.setGravityEndCompat(this);
        } else {
            setGravity(17);
        }
        setEnabled(isEnabled());
    }

    public final void updateTextColor(int color) {
        this.enabledColor = color;
        this.enabledColorOverride = Integer.valueOf(color);
        setEnabled(isEnabled());
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        int iIntValue;
        super.setEnabled(enabled);
        if (enabled) {
            Integer num = this.enabledColorOverride;
            iIntValue = num != null ? num.intValue() : this.enabledColor;
        } else {
            iIntValue = this.disabledColor;
        }
        setTextColor(iIntValue);
    }
}
