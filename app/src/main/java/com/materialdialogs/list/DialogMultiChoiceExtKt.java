package com.materialdialogs.list;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.list.MultiChoiceDialogAdapter;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogMultiChoiceExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a´\u0001\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2Y\b\u0002\u0010\u0011\u001aS\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0002`\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\n\u0010\u0018\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0094\u0001\u0010\u001c\u001a\u00020\u0002*\u00020\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052Y\b\u0002\u0010\u0011\u001aS\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0002`\u0016¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"checkAllItems", "", "Lcom/afollestad/materialdialogs/MaterialDialog;", "checkItems", "indices", "", "listItemsMultiChoice", "res", "", "items", "", "", "disabledIndices", "initialSelection", "waitForPositiveButton", "", "allowEmptySelection", "selection", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "dialog", "Lcom/afollestad/materialdialogs/list/MultiChoiceListener;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[I[IZZLkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "toggleAllItemsChecked", "toggleItemsChecked", "uncheckAllItems", "uncheckItems", "updateListItemsMultiChoice", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[ILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "core"}, k = 2, mv = {1, 1, 16})
public final class DialogMultiChoiceExtKt {
    public static /* synthetic */ MaterialDialog listItemsMultiChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, int[] iArr2, boolean z, boolean z2, Function3 function3, int i, Object obj) {
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
        int[] iArr3 = iArr;
        if ((i & 8) != 0) {
            iArr2 = new int[0];
        }
        int[] iArr4 = iArr2;
        if ((i & 16) != 0) {
            z = true;
        }
        boolean z3 = z;
        boolean z4 = (i & 32) != 0 ? false : z2;
        if ((i & 64) != 0) {
            function3 = (Function3) null;
        }
        return listItemsMultiChoice(materialDialog, num, list2, iArr3, iArr4, z3, z4, function3);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004e  */
    public static final MaterialDialog listItemsMultiChoice(MaterialDialog listItemsMultiChoice, Integer num, List<? extends CharSequence> list, int[] iArr, int[] initialSelection, boolean z, boolean z2, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        boolean z3;
        Intrinsics.checkParameterIsNotNull(listItemsMultiChoice, "$this$listItemsMultiChoice");
        Intrinsics.checkParameterIsNotNull(initialSelection, "initialSelection");
        MDUtil.INSTANCE.assertOneSet("listItemsMultiChoice", list, num);
        List<? extends CharSequence> list2 = list != null ? list : ArraysKt.toList(MDUtil.INSTANCE.getStringArray(listItemsMultiChoice.getWindowContext(), num));
        if (DialogListExtKt.getListAdapter(listItemsMultiChoice) != null) {
            Log.w("MaterialDialogs", "Prefer calling updateListItemsMultiChoice(...) over listItemsMultiChoice(...) again.");
            return updateListItemsMultiChoice(listItemsMultiChoice, num, list, iArr, function3);
        }
        WhichButton whichButton = WhichButton.POSITIVE;
        if (!z2) {
            z3 = (initialSelection.length == 0) ^ true;
        }
        DialogActionExtKt.setActionButtonEnabled(listItemsMultiChoice, whichButton, z3);
        return DialogListExtKt.customListAdapter$default(listItemsMultiChoice, new MultiChoiceDialogAdapter(listItemsMultiChoice, list2, iArr, initialSelection, z, z2, function3), null, 2, null);
    }

    public static /* synthetic */ MaterialDialog updateListItemsMultiChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, Function3 function3, int i, Object obj) {
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
        return updateListItemsMultiChoice(materialDialog, num, list, iArr, function3);
    }

    public static final MaterialDialog updateListItemsMultiChoice(MaterialDialog updateListItemsMultiChoice, Integer num, List<? extends CharSequence> list, int[] iArr, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(updateListItemsMultiChoice, "$this$updateListItemsMultiChoice");
        MDUtil.INSTANCE.assertOneSet("updateListItemsMultiChoice", list, num);
        if (list == null) {
            list = ArraysKt.toList(MDUtil.INSTANCE.getStringArray(updateListItemsMultiChoice.getWindowContext(), num));
        }
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(updateListItemsMultiChoice);
        if (!(listAdapter instanceof MultiChoiceDialogAdapter)) {
            throw new IllegalStateException("updateListItemsMultiChoice(...) can't be used before you've created a multiple choice list dialog.".toString());
        }
        MultiChoiceDialogAdapter multiChoiceDialogAdapter = (MultiChoiceDialogAdapter) listAdapter;
        multiChoiceDialogAdapter.replaceItems2(list, function3);
        if (iArr != null) {
            multiChoiceDialogAdapter.disableItems(iArr);
        }
        return updateListItemsMultiChoice;
    }

    public static final void checkItems(MaterialDialog checkItems, int[] indices) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(checkItems, "$this$checkItems");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        Object listAdapter = DialogListExtKt.getListAdapter(checkItems);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkItems(indices);
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't check items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final void uncheckItems(MaterialDialog uncheckItems, int[] indices) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(uncheckItems, "$this$uncheckItems");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        Object listAdapter = DialogListExtKt.getListAdapter(uncheckItems);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckItems(indices);
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't uncheck items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final void toggleItemsChecked(MaterialDialog toggleItemsChecked, int[] indices) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(toggleItemsChecked, "$this$toggleItemsChecked");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        Object listAdapter = DialogListExtKt.getListAdapter(toggleItemsChecked);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleItems(indices);
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't toggle checked items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final void checkAllItems(MaterialDialog checkAllItems) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(checkAllItems, "$this$checkAllItems");
        Object listAdapter = DialogListExtKt.getListAdapter(checkAllItems);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkAllItems();
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't check all items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final void uncheckAllItems(MaterialDialog uncheckAllItems) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(uncheckAllItems, "$this$uncheckAllItems");
        Object listAdapter = DialogListExtKt.getListAdapter(uncheckAllItems);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckAllItems();
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't uncheck all items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }

    public static final void toggleAllItemsChecked(MaterialDialog toggleAllItemsChecked) {
        String name;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(toggleAllItemsChecked, "$this$toggleAllItemsChecked");
        Object listAdapter = DialogListExtKt.getListAdapter(toggleAllItemsChecked);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleAllChecked();
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("Can't uncheck all items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (name = cls.getName()) == null) {
            name = "null";
        }
        throw new UnsupportedOperationException(sbAppend.append(name).toString());
    }
}
