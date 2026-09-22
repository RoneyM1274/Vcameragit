package com.materialdialogs.internal.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.internal.list.CheckPayload;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder;
import com.afollestad.materialdialogs.internal.list.UncheckPayload;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.IntArraysKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiChoiceDialogAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012_\u0012\u0004\u0012\u00020\u0004\u0012U\u0012S\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000f0\u0003B\u0096\u0001\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012W\u0010\u0015\u001aS\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000f¢\u0006\u0002\u0010\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020(H\u0016J\u0015\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020(H\u0000¢\u0006\u0002\b,J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020(H\u0016J&\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020(2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020(H\u0016J\b\u00107\u001a\u00020\u000eH\u0016Jo\u00108\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2W\u00109\u001aS\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000fH\u0016J\b\u0010:\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\u000eH\u0016J\u0010\u0010=\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRk\u0010\u0015\u001aS\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/MultiChoiceDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/internal/list/MultiChoiceViewHolder;", "Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "", "Lkotlin/Function3;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "name", "dialog", "", "indices", "", "items", "", "Lcom/afollestad/materialdialogs/list/MultiChoiceListener;", "disabledItems", "initialSelection", "waitForActionButton", "", "allowEmptySelection", "selection", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;[I[IZZLkotlin/jvm/functions/Function3;)V", "value", "currentSelection", "setCurrentSelection", "([I)V", "disabledIndices", "getItems$core", "()Ljava/util/List;", "setItems$core", "(Ljava/util/List;)V", "getSelection$core", "()Lkotlin/jvm/functions/Function3;", "setSelection$core", "(Lkotlin/jvm/functions/Function3;)V", "checkAllItems", "checkItems", "disableItems", "getItemCount", "", "isItemChecked", "index", "itemClicked", "itemClicked$core", "onBindViewHolder", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "positiveButtonClicked", "replaceItems", "listener", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems", "core"}, k = 1, mv = {1, 1, 16})
public final class MultiChoiceDialogAdapter extends RecyclerView.Adapter<com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder> implements DialogAdapter<CharSequence, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, ? extends Unit>> {
    private final boolean allowEmptySelection;
    private int[] currentSelection;
    private MaterialDialog dialog;
    private int[] disabledIndices;
    private List<? extends CharSequence> items;
    private Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> selection;
    private final boolean waitForActionButton;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public /* bridge */ /* synthetic */ void replaceItems(List<? extends CharSequence> list, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, ? extends Unit> function3) {
        replaceItems2(list, (Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit>) function3);
    }

    public final List<CharSequence> getItems$core() {
        return this.items;
    }

    public final void setItems$core(List<? extends CharSequence> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    public final Function3<MaterialDialog, int[], List<? extends CharSequence>, Unit> getSelection$core() {
        return this.selection;
    }

    public final void setSelection$core(Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        this.selection = function3;
    }

    public MultiChoiceDialogAdapter(MaterialDialog dialog, List<? extends CharSequence> items, int[] iArr, int[] initialSelection, boolean z, boolean z2, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        Intrinsics.checkParameterIsNotNull(items, "items");
        Intrinsics.checkParameterIsNotNull(initialSelection, "initialSelection");
        this.dialog = dialog;
        this.items = items;
        this.waitForActionButton = z;
        this.allowEmptySelection = z2;
        this.selection = function3;
        this.currentSelection = initialSelection;
        this.disabledIndices = iArr == null ? new int[0] : iArr;
    }

    private final void setCurrentSelection(int[] iArr) {
        int[] iArr2 = this.currentSelection;
        this.currentSelection = iArr;
        for (int i : iArr2) {
            if (!ArraysKt.contains(iArr, i)) {
                notifyItemChanged(i, com.afollestad.materialdialogs.internal.list.UncheckPayload.INSTANCE);
            }
        }
        for (int i2 : iArr) {
            if (!ArraysKt.contains(iArr2, i2)) {
                notifyItemChanged(i2, com.afollestad.materialdialogs.internal.list.CheckPayload.INSTANCE);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void itemClicked$core(int index) {
        boolean z;
        List<Integer> mutableList = ArraysKt.toMutableList(this.currentSelection);
        if (mutableList.contains(Integer.valueOf(index))) {
            mutableList.remove(Integer.valueOf(index));
        } else {
            mutableList.add(Integer.valueOf(index));
        }
        setCurrentSelection(CollectionsKt.toIntArray(mutableList));
        if (this.waitForActionButton && DialogActionExtKt.hasActionButtons(this.dialog)) {
            MaterialDialog materialDialog = this.dialog;
            WhichButton whichButton = WhichButton.POSITIVE;
            if (!this.allowEmptySelection) {
                z = ((this.currentSelection.length == 0) ^ true) == true;
            }
            DialogActionExtKt.setActionButtonEnabled(materialDialog, whichButton, z);
            return;
        }
        List<? extends CharSequence> list = this.items;
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(list.get(i));
        }
        Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3 = this.selection;
        if (function3 != null) {
            function3.invoke(this.dialog, this.currentSelection, arrayList);
        }
        if (!this.dialog.getAutoDismissEnabled() || DialogActionExtKt.hasActionButtons(this.dialog)) {
            return;
        }
        this.dialog.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder multiChoiceViewHolder = new com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder(MDUtil.INSTANCE.inflate(parent, this.dialog.getWindowContext(), R.layout.md_listitem_multichoice), this);
        MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, multiChoiceViewHolder.getTitleView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
        int[] iArrResolveColors$default = ColorsKt.resolveColors$default(this.dialog, new int[]{R.attr.md_color_widget, R.attr.md_color_widget_unchecked}, null, 2, null);
        CompoundButtonCompat.setButtonTintList(multiChoiceViewHolder.getControlView(), MDUtil.INSTANCE.createColorSelector(this.dialog.getWindowContext(), iArrResolveColors$default[1], iArrResolveColors$default[0]));
        return multiChoiceViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        holder.setEnabled(!ArraysKt.contains(this.disabledIndices, position));
        holder.getControlView().setChecked(ArraysKt.contains(this.currentSelection, position));
        holder.getTitleView().setText(this.items.get(position));
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        view.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        if (this.dialog.getBodyFont() != null) {
            holder.getTitleView().setTypeface(this.dialog.getBodyFont());
        }
    }

    public void onBindViewHolder(com.afollestad.materialdialogs.internal.list.MultiChoiceViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        if (Intrinsics.areEqual(objFirstOrNull, CheckPayload.INSTANCE)) {
            holder.getControlView().setChecked(true);
        } else {
            if (Intrinsics.areEqual(objFirstOrNull, UncheckPayload.INSTANCE)) {
                holder.getControlView().setChecked(false);
                return;
            }
            MultiChoiceViewHolder multiChoiceViewHolder = holder;
            super.onBindViewHolder(multiChoiceViewHolder, position, payloads);
            super.onBindViewHolder(multiChoiceViewHolder, position, payloads);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void positiveButtonClicked() {
        if (!this.allowEmptySelection) {
            if (!(!(this.currentSelection.length == 0))) {
                return;
            }
        }
        List<? extends CharSequence> list = this.items;
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(list.get(i));
        }
        Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3 = this.selection;
        if (function3 != null) {
            function3.invoke(this.dialog, this.currentSelection, arrayList);
        }
    }

    /* JADX INFO: renamed from: replaceItems, reason: avoid collision after fix types in other method */
    public void replaceItems2(List<? extends CharSequence> items, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(items, "items");
        this.items = items;
        if (listener != null) {
            this.selection = listener;
        }
        notifyDataSetChanged();
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void disableItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        this.disabledIndices = indices;
        notifyDataSetChanged();
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void checkItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        int length = indices.length;
        for (int i = 0; i < length; i++) {
            int i2 = indices[i];
            if (!(i2 >= 0 && i2 < this.items.size())) {
                throw new IllegalStateException(("Index " + i2 + " is out of range for this adapter of " + this.items.size() + " items.").toString());
            }
            if (true ^ ArraysKt.contains(iArr, i2)) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        setCurrentSelection(IntArraysKt.appendAll(this.currentSelection, arrayList));
        if (iArr.length == 0) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void uncheckItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        int length = indices.length;
        int i = 0;
        while (true) {
            if (i < length) {
                int i2 = indices[i];
                if (!(i2 >= 0 && i2 < this.items.size())) {
                    throw new IllegalStateException(("Index " + i2 + " is out of range for this adapter of " + this.items.size() + " items.").toString());
                }
                if (ArraysKt.contains(iArr, i2)) {
                    arrayList.add(Integer.valueOf(i2));
                }
                i++;
            } else {
                int[] iArrRemoveAll = IntArraysKt.removeAll(this.currentSelection, arrayList);
                if (iArrRemoveAll.length == 0) {
                    DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, this.allowEmptySelection);
                }
                setCurrentSelection(iArrRemoveAll);
                return;
            }
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void toggleItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        List<Integer> mutableList = ArraysKt.toMutableList(this.currentSelection);
        for (int i : indices) {
            if (!ArraysKt.contains(this.disabledIndices, i)) {
                if (mutableList.contains(Integer.valueOf(i))) {
                    mutableList.remove(Integer.valueOf(i));
                } else {
                    mutableList.add(Integer.valueOf(i));
                }
            }
        }
        int[] intArray = CollectionsKt.toIntArray(mutableList);
        DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, intArray.length == 0 ? this.allowEmptySelection : true);
        setCurrentSelection(intArray);
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void checkAllItems() {
        int[] iArr = this.currentSelection;
        int itemCount = getItemCount();
        int[] iArr2 = new int[itemCount];
        for (int i = 0; i < itemCount; i++) {
            iArr2[i] = i;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < itemCount; i2++) {
            int i3 = iArr2[i2];
            if (true ^ ArraysKt.contains(iArr, i3)) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        setCurrentSelection(IntArraysKt.appendAll(this.currentSelection, arrayList));
        if (iArr.length == 0) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void uncheckAllItems() {
        setCurrentSelection(new int[0]);
        DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, this.allowEmptySelection);
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public void toggleAllChecked() {
        if (this.currentSelection.length == 0) {
            checkAllItems();
        } else {
            uncheckAllItems();
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public boolean isItemChecked(int index) {
        return ArraysKt.contains(this.currentSelection, index);
    }
}
