package com.materialdialogs.input;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogInputExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0007\u001a\u008d\u0001\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0002`\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a-\u0010\u0018\u001a\u00020\u0014*\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\u00020\u0014*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u001b*2\u0010\u001c\"\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¨\u0006\u0005"}, d2 = {"getInputField", "Landroid/widget/EditText;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "input", "hint", "", "hintRes", "", "prefill", "", "prefillRes", "inputType", "maxLength", "waitForPositiveButton", "", "allowEmpty", "callback", "Lkotlin/Function2;", "", "Lcom/afollestad/materialdialogs/input/InputCallback;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/Integer;ILjava/lang/Integer;ZZLkotlin/jvm/functions/Function2;)Lcom/afollestad/materialdialogs/MaterialDialog;", "lookupInputLayout", "prefillInput", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/CharSequence;Ljava/lang/Integer;Z)V", "styleInput", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/String;Ljava/lang/Integer;I)V", "InputCallback"}, k = 2, mv = {1, 1, 16})
public final class DialogInputExtKt {
    public static final TextInputLayout getInputLayout(MaterialDialog getInputLayout) {
        Intrinsics.checkParameterIsNotNull(getInputLayout, "$this$getInputLayout");
        Object obj = getInputLayout.getConfig().get("[custom_view_input_layout]");
        if (!(obj instanceof TextInputLayout)) {
            obj = null;
        }
        TextInputLayout textInputLayout = (TextInputLayout) obj;
        if (textInputLayout != null) {
            return textInputLayout;
        }
        TextInputLayout textInputLayoutLookupInputLayout = lookupInputLayout(getInputLayout);
        getInputLayout.getConfig().put("[custom_view_input_layout]", textInputLayoutLookupInputLayout);
        return textInputLayoutLookupInputLayout;
    }

    private static final TextInputLayout lookupInputLayout(MaterialDialog materialDialog) {
        View viewFindViewById = DialogCustomViewExtKt.getCustomView(materialDialog).findViewById(R.id.md_input_layout);
        if (!(viewFindViewById instanceof TextInputLayout)) {
            viewFindViewById = null;
        }
        TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById;
        if (textInputLayout != null) {
            return textInputLayout;
        }
        throw new IllegalStateException("You have not setup this dialog as an input dialog.");
    }

    public static final EditText getInputField(MaterialDialog getInputField) {
        Intrinsics.checkParameterIsNotNull(getInputField, "$this$getInputField");
        EditText editText = getInputLayout(getInputField).getEditText();
        if (editText != null) {
            return editText;
        }
        throw new IllegalStateException("You have not setup this dialog as an input dialog.");
    }

    public static final MaterialDialog input(final MaterialDialog input, String str, Integer num, CharSequence charSequence, Integer num2, int i, final Integer num3, final boolean z, final boolean z2, final Function2<? super MaterialDialog, ? super CharSequence, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(input, "$this$input");
        DialogCustomViewExtKt.customView$default(input, Integer.valueOf(R.layout.md_dialog_stub_input), null, false, false, false, false, 62, null);
        DialogCallbackExtKt.onPreShow(input, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.input.DialogInputExtKt.input.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                invoke2(materialDialog);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                InputUtilExtKt.showKeyboardIfApplicable(input);
            }
        });
        if (!DialogActionExtKt.hasActionButtons(input)) {
            MaterialDialog.positiveButton$default(input, Integer.valueOf(android.R.string.ok), null, null, 6, null);
        }
        if (function2 != null && z) {
            MaterialDialog.positiveButton$default(input, null, null, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.input.DialogInputExtKt.input.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                    invoke2(materialDialog);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    Function2 function3 = function2;
                    MaterialDialog materialDialog = input;
                    CharSequence text = DialogInputExtKt.getInputField(materialDialog).getText();
                    if (text == null) {
                        text = "";
                    }
                    function3.invoke(materialDialog, text);
                }
            }, 3, null);
        }
        prefillInput(input, charSequence, num2, z2);
        styleInput(input, str, num, i);
        if (num3 != null) {
            TextInputLayout inputLayout = getInputLayout(input);
            inputLayout.setCounterEnabled(true);
            inputLayout.setCounterMaxLength(num3.intValue());
            InputUtilExtKt.invalidateInputMaxLength(input, z2);
        }
        MDUtil.INSTANCE.textChanged(getInputField(input), new Function1<CharSequence, Unit>() { // from class: com.afollestad.materialdialogs.input.DialogInputExtKt.input.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence2) {
                invoke2(charSequence2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence it) {
                Function2 function3;
                Intrinsics.checkParameterIsNotNull(it, "it");
                if (!z2) {
                    DialogActionExtKt.setActionButtonEnabled(input, WhichButton.POSITIVE, it.length() > 0);
                }
                Integer num4 = num3;
                if (num4 != null) {
                    num4.intValue();
                    InputUtilExtKt.invalidateInputMaxLength(input, z2);
                }
                if (z || (function3 = function2) == null) {
                    return;
                }
                function3.invoke(input, it);
            }
        });
        return input;
    }

    private static final void prefillInput(MaterialDialog materialDialog, final CharSequence charSequence, Integer num, boolean z) {
        Resources resources = materialDialog.getWindowContext().getResources();
        final EditText inputField = getInputField(materialDialog);
        if (charSequence == null) {
            String string = num != null ? resources.getString(num.intValue()) : "";
            Intrinsics.checkExpressionValueIsNotNull(string, "if (prefillRes != null) …tring(prefillRes) else \"\"");
            charSequence = string;
        }
        boolean z2 = true;
        if (charSequence.length() > 0) {
            inputField.setText(charSequence);
            DialogCallbackExtKt.onShow(materialDialog, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.input.DialogInputExtKt.prefillInput.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog2) {
                    invoke2(materialDialog2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    inputField.setSelection(charSequence.length());
                }
            });
        }
        WhichButton whichButton = WhichButton.POSITIVE;
        if (!z) {
            if (!(charSequence.length() > 0)) {
                z2 = false;
            }
        }
        DialogActionExtKt.setActionButtonEnabled(materialDialog, whichButton, z2);
    }

    private static final void styleInput(MaterialDialog materialDialog, String str, Integer num, int i) {
        Resources resources = materialDialog.getWindowContext().getResources();
        EditText inputField = getInputField(materialDialog);
        if (str == null) {
            str = num != null ? resources.getString(num.intValue()) : null;
        }
        inputField.setHint(str);
        inputField.setInputType(i);
        MDUtil.INSTANCE.maybeSetTextColor(inputField, materialDialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), Integer.valueOf(R.attr.md_color_hint));
        Typeface bodyFont = materialDialog.getBodyFont();
        if (bodyFont != null) {
            inputField.setTypeface(bodyFont);
        }
    }
}
