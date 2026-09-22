package com.afollestad.materialdialogs.utils;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.checkbox.DialogCheckboxExtKt;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.internal.message.DialogContentLayout;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Dialogs.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u001a/\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\u0010\u000e\u001aQ\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0003\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u001b"}, d2 = {"hideKeyboard", "", "Lcom/afollestad/materialdialogs/MaterialDialog;", "invalidateDividers", "showTop", "", "showBottom", "populateIcon", "imageView", "Landroid/widget/ImageView;", "iconRes", "", "icon", "Landroid/graphics/drawable/Drawable;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/widget/ImageView;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)V", "populateText", "textView", "Landroid/widget/TextView;", "textRes", "text", "", "fallback", "typeface", "Landroid/graphics/Typeface;", "textColor", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/CharSequence;ILandroid/graphics/Typeface;Ljava/lang/Integer;)V", "preShow", "core"}, k = 2, mv = {1, 1, 16})
public final class DialogsKt {
    public static final void invalidateDividers(MaterialDialog invalidateDividers, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(invalidateDividers, "$this$invalidateDividers");
        invalidateDividers.getView().invalidateDividers(z, z2);
    }

    public static final void preShow(MaterialDialog preShow) {
        Intrinsics.checkParameterIsNotNull(preShow, "$this$preShow");
        Object obj = preShow.getConfig().get(DialogCustomViewExtKt.CUSTOM_VIEW_NO_VERTICAL_PADDING);
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        boolean zAreEqual = Intrinsics.areEqual(obj, (Object) true);
        DialogCallbackExtKt.invokeAll(preShow.getPreShowListeners$core(), preShow);
        DialogLayout view = preShow.getView();
        if (view.getTitleLayout().shouldNotBeVisible() && !zAreEqual) {
            view.getContentLayout().modifyFirstAndLastPadding(view.getFrameMarginVertical(), view.getFrameMarginVertical());
        }
        if (ViewsKt.isVisible(DialogCheckboxExtKt.getCheckBoxPrompt(preShow))) {
            DialogContentLayout.modifyFirstAndLastPadding$default(view.getContentLayout(), 0, 0, 1, null);
        } else if (view.getContentLayout().haveMoreThanOneChild()) {
            DialogContentLayout.modifyScrollViewPadding$default(view.getContentLayout(), 0, view.getFrameMarginVerticalLess(), 1, null);
        }
    }

    public static final void populateIcon(MaterialDialog populateIcon, ImageView imageView, Integer num, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(populateIcon, "$this$populateIcon");
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        Drawable drawableResolveDrawable$default = MDUtil.resolveDrawable$default(MDUtil.INSTANCE, populateIcon.getWindowContext(), num, null, drawable, 4, null);
        if (drawableResolveDrawable$default != null) {
            Object parent = imageView.getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
            }
            ((View) parent).setVisibility(0);
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawableResolveDrawable$default);
            return;
        }
        imageView.setVisibility(8);
    }

    public static final void populateText(MaterialDialog populateText, TextView textView, Integer num, CharSequence charSequence, int i, Typeface typeface, Integer num2) {
        Intrinsics.checkParameterIsNotNull(populateText, "$this$populateText");
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        if (charSequence == null) {
            charSequence = MDUtil.resolveString$default(MDUtil.INSTANCE, populateText, num, Integer.valueOf(i), false, 8, (Object) null);
        }
        if (charSequence != null) {
            Object parent = textView.getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
            }
            ((View) parent).setVisibility(0);
            textView.setVisibility(0);
            textView.setText(charSequence);
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, textView, populateText.getWindowContext(), num2, null, 4, null);
            return;
        }
        textView.setVisibility(8);
    }

    public static final void hideKeyboard(MaterialDialog hideKeyboard) {
        IBinder windowToken;
        Intrinsics.checkParameterIsNotNull(hideKeyboard, "$this$hideKeyboard");
        Object systemService = hideKeyboard.getWindowContext().getSystemService("input_method");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View currentFocus = hideKeyboard.getCurrentFocus();
        if (currentFocus != null) {
            windowToken = currentFocus.getWindowToken();
        } else {
            windowToken = hideKeyboard.getView().getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
    }
}
