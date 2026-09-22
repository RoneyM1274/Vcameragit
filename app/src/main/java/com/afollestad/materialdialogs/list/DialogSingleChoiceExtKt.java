package com.afollestad.materialdialogs.list;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.list.SingleChoiceDialogAdapter;
import com.afollestad.materialdialogs.utils.MDUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogSingleChoiceExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a¤\u0001\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00062S\b\u0002\u0010\u0010\u001aM\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0002`\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u008e\u0001\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2S\b\u0002\u0010\u0010\u001aM\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0002`\u0016¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"checkItem", "", "Lcom/afollestad/materialdialogs/MaterialDialog;", "index", "", "isItemChecked", "", "listItemsSingleChoice", "res", "items", "", "", "disabledIndices", "", "initialSelection", "waitForPositiveButton", "selection", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "dialog", "text", "Lcom/afollestad/materialdialogs/list/SingleChoiceListener;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[IIZLkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "toggleItemChecked", "uncheckItem", "updateListItemsSingleChoice", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[ILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "core"}, k = 2, mv = {1, 1, 16})
public final class DialogSingleChoiceExtKt {
    public static /* synthetic */ MaterialDialog listItemsSingleChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, int i, boolean z, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = (Integer) null;
        }
        if ((i2 & 2) != 0) {
            list = (List) null;
        }
        List list2 = list;
        if ((i2 & 4) != 0) {
            iArr = (int[]) null;
        }
        int[] iArr2 = iArr;
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            function3 = (Function3) null;
        }
        return listItemsSingleChoice(materialDialog, num, list2, iArr2, i3, z2, function3);
    }

    public static final MaterialDialog listItemsSingleChoice(MaterialDialog listItemsSingleChoice, Integer num, List<? extends CharSequence> list, int[] iArr, int i, boolean z, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(listItemsSingleChoice, "$this$listItemsSingleChoice");
        MDUtil.INSTANCE.assertOneSet("listItemsSingleChoice", list, num);
        List<? extends CharSequence> list2 = list != null ? list : ArraysKt.toList(MDUtil.INSTANCE.getStringArray(listItemsSingleChoice.getWindowContext(), num));
        if (!(i >= -1 || i < list2.size())) {
            throw new IllegalArgumentException(("Initial selection " + i + " must be between -1 and the size of your items array " + list2.size()).toString());
        }
        if (DialogListExtKt.getListAdapter(listItemsSingleChoice) != null) {
            Log.w("MaterialDialogs", "Prefer calling updateListItemsSingleChoice(...) over listItemsSingleChoice(...) again.");
            return updateListItemsSingleChoice(listItemsSingleChoice, num, list, iArr, function3);
        }
        DialogActionExtKt.setActionButtonEnabled(listItemsSingleChoice, WhichButton.POSITIVE, i > -1);
        return DialogListExtKt.customListAdapter$default(listItemsSingleChoice, new SingleChoiceDialogAdapter(listItemsSingleChoice, list2, iArr, i, z, function3), null, 2, null);
    }

    public static /* synthetic */ MaterialDialog updateListItemsSingleChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, Function3 function3, int i, Object obj) {
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
        return updateListItemsSingleChoice(materialDialog, num, list, iArr, function3);
    }

    public static final MaterialDialog updateListItemsSingleChoice(MaterialDialog updateListItemsSingleChoice, Integer num, List<? extends CharSequence> list, int[] iArr, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(updateListItemsSingleChoice, "$this$updateListItemsSingleChoice");
        MDUtil.INSTANCE.assertOneSet("updateListItemsSingleChoice", list, num);
        if (list == null) {
            list = ArraysKt.toList(MDUtil.INSTANCE.getStringArray(updateListItemsSingleChoice.getWindowContext(), num));
        }
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(updateListItemsSingleChoice);
        if (!(listAdapter instanceof SingleChoiceDialogAdapter)) {
            throw new IllegalStateException("updateListItemsSingleChoice(...) can't be used before you've created a single choice list dialog.".toString());
        }
        SingleChoiceDialogAdapter singleChoiceDialogAdapter = (SingleChoiceDialogAdapter) listAdapter;
        singleChoiceDialogAdapter.replaceItems2(list, function3);
        if (iArr != null) {
            singleChoiceDialogAdapter.disableItems(iArr);
        }
        return updateListItemsSingleChoice;
    }

    public static final void checkItem(MaterialDialog checkItem, int i) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(checkItem, "$this$checkItem");
        Object listAdapter = DialogListExtKt.getListAdapter(checkItem);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkItems(new int[]{i});
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't check item on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final void uncheckItem(MaterialDialog uncheckItem, int i) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(uncheckItem, "$this$uncheckItem");
        Object listAdapter = DialogListExtKt.getListAdapter(uncheckItem);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckItems(new int[]{i});
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't uncheck item on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final void toggleItemChecked(MaterialDialog toggleItemChecked, int i) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(toggleItemChecked, "$this$toggleItemChecked");
        Object listAdapter = DialogListExtKt.getListAdapter(toggleItemChecked);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleItems(new int[]{i});
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't toggle checked item on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final boolean isItemChecked(MaterialDialog isItemChecked, int i) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(isItemChecked, "$this$isItemChecked");
        Object listAdapter = DialogListExtKt.getListAdapter(isItemChecked);
        if (listAdapter instanceof DialogAdapter) {
            return ((DialogAdapter) listAdapter).isItemChecked(i);
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't check if item is checked on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }
}
