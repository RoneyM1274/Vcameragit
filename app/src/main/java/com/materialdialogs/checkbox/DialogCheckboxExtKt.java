package com.materialdialogs.checkbox;

import android.graphics.Typeface;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogCheckboxExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0002`\u000b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0001H\u0007\u001a\f\u0010\u000e\u001a\u00020\u0007*\u00020\u0001H\u0007*&\u0010\u000f\"\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\t¨\u0006\u0010"}, d2 = {"checkBoxPrompt", "Lcom/afollestad/materialdialogs/MaterialDialog;", "res", "", "text", "", "isCheckedDefault", "", "onToggle", "Lkotlin/Function1;", "", "Lcom/afollestad/materialdialogs/checkbox/BooleanCallback;", "getCheckBoxPrompt", "Landroid/widget/CheckBox;", "isCheckPromptChecked", "BooleanCallback", "core"}, k = 2, mv = {1, 1, 16})
public final class DialogCheckboxExtKt {
    public static final CheckBox getCheckBoxPrompt(MaterialDialog getCheckBoxPrompt) {
        AppCompatCheckBox checkBoxPrompt;
        Intrinsics.checkParameterIsNotNull(getCheckBoxPrompt, "$this$getCheckBoxPrompt");
        DialogActionButtonLayout buttonsLayout = getCheckBoxPrompt.getView().getButtonsLayout();
        if (buttonsLayout == null || (checkBoxPrompt = buttonsLayout.getCheckBoxPrompt()) == null) {
            throw new IllegalStateException("The dialog does not have an attached buttons layout.");
        }
        return checkBoxPrompt;
    }

    public static final boolean isCheckPromptChecked(MaterialDialog isCheckPromptChecked) {
        Intrinsics.checkParameterIsNotNull(isCheckPromptChecked, "$this$isCheckPromptChecked");
        return getCheckBoxPrompt(isCheckPromptChecked).isChecked();
    }

    public static /* synthetic */ MaterialDialog checkBoxPrompt$default(MaterialDialog materialDialog, int i, String str, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            str = (String) null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return checkBoxPrompt(materialDialog, i, str, z, function1);
    }

    public static final MaterialDialog checkBoxPrompt(final MaterialDialog checkBoxPrompt, final int i, final String str, final boolean z, final Function1<? super Boolean, Unit> function1) {
        AppCompatCheckBox checkBoxPrompt2;
        Intrinsics.checkParameterIsNotNull(checkBoxPrompt, "$this$checkBoxPrompt");
        MDUtil.INSTANCE.assertOneSet("checkBoxPrompt", str, Integer.valueOf(i));
        DialogActionButtonLayout buttonsLayout = checkBoxPrompt.getView().getButtonsLayout();
        if (buttonsLayout != null && (checkBoxPrompt2 = buttonsLayout.getCheckBoxPrompt()) != null) {
            checkBoxPrompt2.setVisibility(0);
            checkBoxPrompt2.setText(str != null ? str : MDUtil.resolveString$default(MDUtil.INSTANCE, checkBoxPrompt, Integer.valueOf(i), (Integer) null, false, 12, (Object) null));
            checkBoxPrompt2.setChecked(z);
            checkBoxPrompt2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.afollestad.materialdialogs.checkbox.DialogCheckboxExtKt$checkBoxPrompt$$inlined$run$lambda$1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    Function1 function2 = function1;
                    if (function2 != null) {
                    }
                }
            });
            MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, checkBoxPrompt2, checkBoxPrompt.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
            Typeface bodyFont = checkBoxPrompt.getBodyFont();
            if (bodyFont != null) {
                checkBoxPrompt2.setTypeface(bodyFont);
            }
            int[] iArrResolveColors$default = ColorsKt.resolveColors$default(checkBoxPrompt, new int[]{R.attr.md_color_widget, R.attr.md_color_widget_unchecked}, null, 2, null);
            CompoundButtonCompat.setButtonTintList(checkBoxPrompt2, MDUtil.INSTANCE.createColorSelector(checkBoxPrompt.getWindowContext(), iArrResolveColors$default[1], iArrResolveColors$default[0]));
        }
        return checkBoxPrompt;
    }
}
