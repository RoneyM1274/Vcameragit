package com.afollestad.materialdialogs.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: MDUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\t2\b\b\u0003\u0010\u0010\u001a\u00020\tH\u0007J?\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016J?\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u001aH\u0007J,\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\t2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0015H\u0007J;\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0002\u0010#J$\u0010$\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007J$\u0010%\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\tH\u0007J9\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*J9\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010+\u001a\u00020,2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010-J\f\u0010.\u001a\u00020\t*\u00020/H\u0007J%\u00100\u001a\u00020\t\"\b\b\u0000\u00101*\u000202*\u0002H12\b\b\u0001\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0002\u00103J#\u00104\u001a\b\u0012\u0004\u0012\u00020\u000605*\u00020\u000e2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u00106J\u0018\u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t08*\u000209H\u0007J7\u0010:\u001a\u00020\u0004*\u0004\u0018\u00010\t2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00040\u001aH\u0087\b¢\u0006\u0002\u0010=J/\u0010>\u001a\u0002H?\"\b\b\u0000\u0010?*\u000202*\u00020@2\b\b\u0002\u0010A\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020)*\u00020\t2\b\b\u0002\u0010D\u001a\u00020EH\u0007J\f\u0010F\u001a\u00020)*\u00020\u000eH\u0007J3\u0010G\u001a\u00020\u0004*\u0004\u0018\u00010/2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010I\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010JJ \u0010K\u001a\u00020\u0004*\u00020L2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00040\u001aH\u0007JE\u0010N\u001a\u00020\u0004\"\b\b\u0000\u00101*\u000202*\u0004\u0018\u0001H12\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\t2\b\b\u0002\u0010Q\u001a\u00020\t2\b\b\u0002\u0010R\u001a\u00020\tH\u0007¢\u0006\u0002\u0010SJ4\u0010T\u001a\u00020\u0004\"\b\b\u0000\u00101*\u000202*\u0002H12\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\bUH\u0007¢\u0006\u0002\u0010VJ4\u0010W\u001a\u00020\u0004\"\b\b\u0000\u00101*\u000202*\u0002H12\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\bUH\u0007¢\u0006\u0002\u0010V¨\u0006X"}, d2 = {"Lcom/afollestad/materialdialogs/utils/MDUtil;", "", "()V", "assertOneSet", "", "method", "", "b", "a", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Integer;)V", "createColorSelector", "Landroid/content/res/ColorStateList;", "context", "Landroid/content/Context;", "unchecked", "checked", "resolveColor", "res", "attr", "fallback", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)I", "resolveColors", "", "attrs", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forAttr", "resolveDimen", "", "defaultValue", "resolveDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "resolveFloat", "resolveInt", "resolveString", "", "html", "", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/CharSequence;", "materialDialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/CharSequence;", "additionalPaddingForFont", "Landroid/widget/TextView;", "dimenPx", "T", "Landroid/view/View;", "(Landroid/view/View;I)I", "getStringArray", "", "(Landroid/content/Context;Ljava/lang/Integer;)[Ljava/lang/String;", "getWidthAndHeight", "Lkotlin/Pair;", "Landroid/view/WindowManager;", "ifNotZero", "block", "value", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "inflate", "R", "Landroid/view/ViewGroup;", "ctxt", "(Landroid/view/ViewGroup;Landroid/content/Context;I)Landroid/view/View;", "isColorDark", "threshold", "", "isLandscape", "maybeSetTextColor", "attrRes", "hintAttrRes", "(Landroid/widget/TextView;Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;)V", "textChanged", "Landroid/widget/EditText;", "callback", "updatePadding", "left", "top", "right", "bottom", "(Landroid/view/View;IIII)V", "waitForHeight", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "waitForWidth", "core"}, k = 1, mv = {1, 1, 16})
public final class MDUtil {
    public static final MDUtil INSTANCE = new MDUtil();

    private MDUtil() {
    }

    public static /* synthetic */ CharSequence resolveString$default(MDUtil mDUtil, MaterialDialog materialDialog, Integer num, Integer num2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            num = (Integer) null;
        }
        if ((i & 4) != 0) {
            num2 = (Integer) null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return mDUtil.resolveString(materialDialog, num, num2, z);
    }

    public final CharSequence resolveString(MaterialDialog materialDialog, Integer res, Integer fallback, boolean html) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "materialDialog");
        return resolveString(materialDialog.getWindowContext(), res, fallback, html);
    }

    public static /* synthetic */ CharSequence resolveString$default(MDUtil mDUtil, Context context, Integer num, Integer num2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            num = (Integer) null;
        }
        if ((i & 4) != 0) {
            num2 = (Integer) null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return mDUtil.resolveString(context, num, num2, z);
    }

    public final CharSequence resolveString(Context context, Integer res, Integer fallback, boolean html) {
        int iIntValue;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (res != null) {
            iIntValue = res.intValue();
        } else {
            iIntValue = fallback != null ? fallback.intValue() : 0;
        }
        if (iIntValue == 0) {
            return null;
        }
        CharSequence text = context.getResources().getText(iIntValue);
        Intrinsics.checkExpressionValueIsNotNull(text, "context.resources.getText(resourceId)");
        return html ? Html.fromHtml(text.toString()) : text;
    }

    public static /* synthetic */ Drawable resolveDrawable$default(MDUtil mDUtil, Context context, Integer num, Integer num2, Drawable drawable, int i, Object obj) {
        if ((i & 2) != 0) {
            num = (Integer) null;
        }
        if ((i & 4) != 0) {
            num2 = (Integer) null;
        }
        if ((i & 8) != 0) {
            drawable = (Drawable) null;
        }
        return mDUtil.resolveDrawable(context, num, num2, drawable);
    }

    public final Drawable resolveDrawable(Context context, Integer res, Integer attr, Drawable fallback) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (attr == null) {
            return res == null ? fallback : ContextCompat.getDrawable(context, res.intValue());
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr.intValue()});
        try {
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable != null || fallback == null) {
                fallback = drawable;
            }
            return fallback;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int resolveColor$default(MDUtil mDUtil, Context context, Integer num, Integer num2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            num = (Integer) null;
        }
        if ((i & 4) != 0) {
            num2 = (Integer) null;
        }
        if ((i & 8) != 0) {
            function0 = (Function0) null;
        }
        return mDUtil.resolveColor(context, num, num2, function0);
    }

    public final int resolveColor(Context context, Integer res, Integer attr, Function0<Integer> fallback) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (attr == null) {
            return ContextCompat.getColor(context, res != null ? res.intValue() : 0);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr.intValue()});
        try {
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            return (color != 0 || fallback == null) ? color : fallback.invoke().intValue();
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int[] resolveColors$default(MDUtil mDUtil, Context context, int[] iArr, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = (Function1) null;
        }
        return mDUtil.resolveColors(context, iArr, function1);
    }

    public final int[] resolveColors(Context context, int[] attrs, Function1<? super Integer, Integer> fallback) {
        Integer numInvoke;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs);
        try {
            IntRange indices = kotlin.collections.ArraysKt.getIndices(attrs);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
            Iterator<Integer> it = indices.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                int iIntValue = 0;
                int color = typedArrayObtainStyledAttributes.getColor(iNextInt, 0);
                if (color != 0) {
                    iIntValue = color;
                } else if (fallback != null && (numInvoke = fallback.invoke(Integer.valueOf(attrs[iNextInt]))) != null) {
                    iIntValue = numInvoke.intValue();
                }
                arrayList.add(Integer.valueOf(iIntValue));
            }
            return CollectionsKt.toIntArray(arrayList);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ int resolveInt$default(MDUtil mDUtil, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return mDUtil.resolveInt(context, i, i2);
    }

    public final int resolveInt(Context context, int attr, int defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr});
        try {
            return typedArrayObtainStyledAttributes.getInt(0, defaultValue);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ float resolveDimen$default(MDUtil mDUtil, Context context, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function0 = (Function0) null;
        }
        return mDUtil.resolveDimen(context, i, function0);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    public final float resolveDimen(Context context, int attr, Function0<Float> defaultValue) {
        float fFloatValue;
        Intrinsics.checkParameterIsNotNull(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr});
        if (defaultValue != null) {
            try {
                Float fInvoke = defaultValue.invoke();
                if (fInvoke != null) {
                    fFloatValue = fInvoke.floatValue();
                } else {
                    fFloatValue = 0.0f;
                }
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } else {
            fFloatValue = 0.0f;
        }
        return typedArrayObtainStyledAttributes.getDimension(0, fFloatValue);
    }

    public static /* synthetic */ float resolveFloat$default(MDUtil mDUtil, Context context, int i, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 0.0f;
        }
        return mDUtil.resolveFloat(context, i, f);
    }

    public final float resolveFloat(Context context, int attr, float defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{attr});
        try {
            return typedArrayObtainStyledAttributes.getFloat(0, defaultValue);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ boolean isColorDark$default(MDUtil mDUtil, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = 0.5d;
        }
        return mDUtil.isColorDark(i, d);
    }

    public final boolean isColorDark(int i, double d) {
        return i != 0 && ((double) 1) - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / ((double) 255)) >= d;
    }

    public final <T extends View> int dimenPx(T dimenPx, int i) {
        Intrinsics.checkParameterIsNotNull(dimenPx, "$this$dimenPx");
        Context context = dimenPx.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return context.getResources().getDimensionPixelSize(i);
    }

    public final boolean isLandscape(Context isLandscape) {
        Intrinsics.checkParameterIsNotNull(isLandscape, "$this$isLandscape");
        Resources resources = isLandscape.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return resources.getConfiguration().orientation == 2;
    }

    public final void textChanged(EditText textChanged, final Function1<? super CharSequence, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(textChanged, "$this$textChanged");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        textChanged.addTextChangedListener(new TextWatcher() { // from class: com.afollestad.materialdialogs.utils.MDUtil.textChanged.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkParameterIsNotNull(s, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Intrinsics.checkParameterIsNotNull(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkParameterIsNotNull(s, "s");
                callback.invoke(s);
            }
        });
    }

    public static /* synthetic */ void maybeSetTextColor$default(MDUtil mDUtil, TextView textView, Context context, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num2 = (Integer) null;
        }
        mDUtil.maybeSetTextColor(textView, context, num, num2);
    }

    public final void maybeSetTextColor(TextView textView, Context context, Integer num, Integer num2) {
        int iResolveColor$default;
        int iResolveColor$default2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (textView != null) {
            if (num == null && num2 == null) {
                return;
            }
            if (num != null && (iResolveColor$default2 = resolveColor$default(this, context, null, num, null, 10, null)) != 0) {
                textView.setTextColor(iResolveColor$default2);
            }
            if (num2 == null || (iResolveColor$default = resolveColor$default(this, context, null, num2, null, 10, null)) == 0) {
                return;
            }
            textView.setHintTextColor(iResolveColor$default);
        }
    }

    public final int additionalPaddingForFont(TextView additionalPaddingForFont) {
        Intrinsics.checkParameterIsNotNull(additionalPaddingForFont, "$this$additionalPaddingForFont");
        TextPaint paint = additionalPaddingForFont.getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "paint");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        if (f > additionalPaddingForFont.getMeasuredHeight()) {
            return (int) (f - additionalPaddingForFont.getMeasuredHeight());
        }
        return 0;
    }

    public final void ifNotZero(Integer num, Function1<? super Integer, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (num == null || num.intValue() == 0) {
            return;
        }
        block.invoke(num);
    }

    public static /* synthetic */ ColorStateList createColorSelector$default(MDUtil mDUtil, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return mDUtil.createColorSelector(context, i, i2);
    }

    public final ColorStateList createColorSelector(Context context, int unchecked, int checked) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int iResolveColor$default = checked == 0 ? resolveColor$default(this, context, null, Integer.valueOf(R.attr.colorControlActivated), null, 10, null) : checked;
        int[][] iArr = {new int[]{-16842912, -16842908}, new int[]{android.R.attr.state_checked}, new int[]{android.R.attr.state_focused}};
        int[] iArr2 = new int[3];
        iArr2[0] = unchecked == 0 ? resolveColor$default(this, context, null, Integer.valueOf(R.attr.colorControlNormal), null, 10, null) : unchecked;
        iArr2[1] = iResolveColor$default;
        iArr2[2] = iResolveColor$default;
        return new ColorStateList(iArr, iArr2);
    }

    public final <T extends View> void waitForWidth(final T waitForWidth, final Function1<? super T, Unit> block) {
        Intrinsics.checkParameterIsNotNull(waitForWidth, "$this$waitForWidth");
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (waitForWidth.getMeasuredWidth() > 0 && waitForWidth.getMeasuredHeight() > 0) {
            block.invoke(waitForWidth);
        } else {
            waitForWidth.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.afollestad.materialdialogs.utils.MDUtil.waitForWidth.1
                private Integer lastWidth;

                public final Integer getLastWidth() {
                    return this.lastWidth;
                }

                public final void setLastWidth(Integer num) {
                    this.lastWidth = num;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Integer num = this.lastWidth;
                    if (num != null) {
                        int measuredWidth = waitForWidth.getMeasuredWidth();
                        if (num != null && num.intValue() == measuredWidth) {
                            waitForWidth.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            return;
                        }
                    }
                    if (waitForWidth.getMeasuredWidth() <= 0 || waitForWidth.getMeasuredHeight() <= 0) {
                        return;
                    }
                    Integer num2 = this.lastWidth;
                    int measuredWidth2 = waitForWidth.getMeasuredWidth();
                    if (num2 != null && num2.intValue() == measuredWidth2) {
                        return;
                    }
                    this.lastWidth = Integer.valueOf(waitForWidth.getMeasuredWidth());
                    block.invoke(waitForWidth);
                }
            });
        }
    }

    public final <T extends View> void waitForHeight(final T waitForHeight, final Function1<? super T, Unit> block) {
        Intrinsics.checkParameterIsNotNull(waitForHeight, "$this$waitForHeight");
        Intrinsics.checkParameterIsNotNull(block, "block");
        if (waitForHeight.getMeasuredWidth() > 0 && waitForHeight.getMeasuredHeight() > 0) {
            block.invoke(waitForHeight);
        } else {
            waitForHeight.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.afollestad.materialdialogs.utils.MDUtil.waitForHeight.1
                private Integer lastHeight;

                public final Integer getLastHeight() {
                    return this.lastHeight;
                }

                public final void setLastHeight(Integer num) {
                    this.lastHeight = num;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Integer num = this.lastHeight;
                    if (num != null) {
                        int measuredHeight = waitForHeight.getMeasuredHeight();
                        if (num != null && num.intValue() == measuredHeight) {
                            waitForHeight.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            return;
                        }
                    }
                    if (waitForHeight.getMeasuredWidth() <= 0 || waitForHeight.getMeasuredHeight() <= 0) {
                        return;
                    }
                    Integer num2 = this.lastHeight;
                    int measuredHeight2 = waitForHeight.getMeasuredHeight();
                    if (num2 != null && num2.intValue() == measuredHeight2) {
                        return;
                    }
                    this.lastHeight = Integer.valueOf(waitForHeight.getMeasuredHeight());
                    block.invoke(waitForHeight);
                }
            });
        }
    }

    public final Pair<Integer, Integer> getWidthAndHeight(WindowManager getWidthAndHeight) {
        Intrinsics.checkParameterIsNotNull(getWidthAndHeight, "$this$getWidthAndHeight");
        Point point = new Point();
        getWidthAndHeight.getDefaultDisplay().getSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static /* synthetic */ void updatePadding$default(MDUtil mDUtil, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view != null ? view.getPaddingLeft() : 0;
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = view != null ? view.getPaddingTop() : 0;
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = view != null ? view.getPaddingRight() : 0;
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = view != null ? view.getPaddingBottom() : 0;
        }
        mDUtil.updatePadding(view, i6, i7, i8, i4);
    }

    public final <T extends View> void updatePadding(T t, int i, int i2, int i3, int i4) {
        if ((t != null && i == t.getPaddingLeft() && i2 == t.getPaddingTop() && i3 == t.getPaddingRight() && i4 == t.getPaddingBottom()) || t == null) {
            return;
        }
        t.setPadding(i, i2, i3, i4);
    }

    public final void assertOneSet(String method, Object b, Integer a) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        if (a == null && b == null) {
            throw new IllegalArgumentException(method + ": You must specify a resource ID or literal value");
        }
    }

    public final String[] getStringArray(Context getStringArray, Integer num) {
        Intrinsics.checkParameterIsNotNull(getStringArray, "$this$getStringArray");
        if (num == null) {
            return new String[0];
        }
        String[] stringArray = getStringArray.getResources().getStringArray(num.intValue());
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray(res)");
        return stringArray;
    }

    public static /* synthetic */ View inflate$default(MDUtil mDUtil, ViewGroup viewGroup, Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = viewGroup.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
        }
        return mDUtil.inflate(viewGroup, context, i);
    }

    public final <R extends View> R inflate(ViewGroup inflate, Context ctxt, int i) {
        Intrinsics.checkParameterIsNotNull(inflate, "$this$inflate");
        Intrinsics.checkParameterIsNotNull(ctxt, "ctxt");
        R r = (R) LayoutInflater.from(ctxt).inflate(i, inflate, false);
        if (r != null) {
            return r;
        }
        throw new TypeCastException("null cannot be cast to non-null type R");
    }
}
