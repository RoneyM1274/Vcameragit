package com.materialdialogs.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.internal.list.PlainListDialogAdapter;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogListExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0012\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0007\u001a\u009a\u0001\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142S\b\u0002\u0010\u0015\u001aM\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016j\u0002`\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\u008e\u0001\u0010\u001f\u001a\u00020\u0001*\u00020\u00012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122S\b\u0002\u0010\u0015\u001aM\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016j\u0002`\u001d¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"customListAdapter", "Lcom/afollestad/materialdialogs/MaterialDialog;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getItemSelector", "Landroid/graphics/drawable/Drawable;", "getListAdapter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "listItems", "res", "", "items", "", "", "disabledIndices", "", "waitForPositiveButton", "", "selection", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "dialog", "index", "text", "", "Lcom/afollestad/materialdialogs/list/ItemListener;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[IZLkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "updateListItems", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[ILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "core"}, k = 2, mv = {1, 1, 16})
public final class DialogListExtKt {
    public static final RecyclerView getRecyclerView(MaterialDialog getRecyclerView) {
        Intrinsics.checkParameterIsNotNull(getRecyclerView, "$this$getRecyclerView");
        DialogRecyclerView recyclerView = getRecyclerView.getView().getContentLayout().getRecyclerView();
        if (recyclerView != null) {
            return recyclerView;
        }
        throw new IllegalStateException("This dialog is not a list dialog.");
    }

    public static final RecyclerView.Adapter<?> getListAdapter(MaterialDialog getListAdapter) {
        Intrinsics.checkParameterIsNotNull(getListAdapter, "$this$getListAdapter");
        DialogRecyclerView recyclerView = getListAdapter.getView().getContentLayout().getRecyclerView();
        if (recyclerView != null) {
            return recyclerView.getAdapter();
        }
        return null;
    }

    public static /* synthetic */ MaterialDialog customListAdapter$default(MaterialDialog materialDialog, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutManager = (RecyclerView.LayoutManager) null;
        }
        return customListAdapter(materialDialog, adapter, layoutManager);
    }

    public static final MaterialDialog customListAdapter(MaterialDialog customListAdapter, RecyclerView.Adapter<?> adapter, RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkParameterIsNotNull(customListAdapter, "$this$customListAdapter");
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        customListAdapter.getView().getContentLayout().addRecyclerView(customListAdapter, adapter, layoutManager);
        return customListAdapter;
    }

    public static /* synthetic */ MaterialDialog listItems$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = (Integer) null;
        }
        if ((i & 2) != 0) {
            list = (List) null;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            iArr = (int[]) null;
        }
        int[] iArr2 = iArr;
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            function3 = (Function3) null;
        }
        return listItems(materialDialog, num, list2, iArr2, z2, function3);
    }

    public static final MaterialDialog listItems(MaterialDialog listItems, Integer num, List<? extends CharSequence> list, int[] iArr, boolean z, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(listItems, "$this$listItems");
        MDUtil.INSTANCE.assertOneSet("listItems", list, num);
        List<? extends CharSequence> list2 = list != null ? list : ArraysKt.toList(MDUtil.INSTANCE.getStringArray(listItems.getWindowContext(), num));
        if (getListAdapter(listItems) != null) {
            Log.w("MaterialDialogs", "Prefer calling updateListItems(...) over listItems(...) again.");
            return updateListItems(listItems, num, list, iArr, function3);
        }
        return customListAdapter$default(listItems, new PlainListDialogAdapter(listItems, list2, iArr, z, function3), null, 2, null);
    }

    public static /* synthetic */ MaterialDialog updateListItems$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = (Integer) null;
        }
        if ((i & 2) != 0) {
            list = (List) null;
        }
        if ((i & 4) != 0) {
            iArr = (int[]) null;
        }
        if ((i & 8) != 0) {
            function3 = (Function3) null;
        }
        return updateListItems(materialDialog, num, list, iArr, function3);
    }

    public static final MaterialDialog updateListItems(MaterialDialog updateListItems, Integer num, List<? extends CharSequence> list, int[] iArr, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(updateListItems, "$this$updateListItems");
        MDUtil.INSTANCE.assertOneSet("updateListItems", list, num);
        if (list == null) {
            list = ArraysKt.toList(MDUtil.INSTANCE.getStringArray(updateListItems.getWindowContext(), num));
        }
        RecyclerView.Adapter<?> listAdapter = getListAdapter(updateListItems);
        if (!(listAdapter instanceof PlainListDialogAdapter)) {
            throw new IllegalStateException("updateListItems(...) can't be used before you've created a plain list dialog.".toString());
        }
        PlainListDialogAdapter plainListDialogAdapter = (PlainListDialogAdapter) listAdapter;
        plainListDialogAdapter.replaceItems2(list, function3);
        if (iArr != null) {
            plainListDialogAdapter.disableItems(iArr);
        }
        return updateListItems;
    }

    public static final Drawable getItemSelector(MaterialDialog getItemSelector) {
        Intrinsics.checkParameterIsNotNull(getItemSelector, "$this$getItemSelector");
        MDUtil mDUtil = MDUtil.INSTANCE;
        Context context = getItemSelector.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        Drawable drawableResolveDrawable$default = MDUtil.resolveDrawable$default(mDUtil, context, null, Integer.valueOf(R.attr.md_item_selector), null, 10, null);
        if (Build.VERSION.SDK_INT >= 21 && (drawableResolveDrawable$default instanceof RippleDrawable)) {
            MDUtil mDUtil2 = MDUtil.INSTANCE;
            int iResolveColor$default = ColorsKt.resolveColor$default(getItemSelector, null, Integer.valueOf(R.attr.md_ripple_color), null, 5, null);
            if (iResolveColor$default != 0) {
                ((RippleDrawable) drawableResolveDrawable$default).setColor(ColorStateList.valueOf(iResolveColor$default));
            }
        }
        return drawableResolveDrawable$default;
    }
}
