package com.roger.catloadinglibrary;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseDialogFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/roger/catloadinglibrary/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnTouchListener;", "()V", "cancelable", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onTouch", "v", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setCancelable", "mCancelable", "catloadinglibrary_release"}, k = 1, mv = {1, 4, 1})
public class BaseDialogFragment extends DialogFragment implements View.OnTouchListener {
    private HashMap _$_findViewCache;
    private boolean cancelable = true;

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        Bundle bundle;
        Window window;
        View decorView;
        Dialog dialog;
        super.onActivityCreated(savedInstanceState);
        boolean showsDialog = getShowsDialog();
        setShowsDialog(false);
        setShowsDialog(showsDialog);
        View view = getView();
        if (view != null) {
            if (!(view.getParent() == null)) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view".toString());
            }
            Dialog dialog2 = getDialog();
            if (dialog2 != null) {
                dialog2.setContentView(view);
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (dialog = getDialog()) != null) {
            dialog.setOwnerActivity(activity);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setOnCancelListener(null);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setOnDismissListener(null);
        }
        Dialog dialog5 = getDialog();
        if (dialog5 != null) {
            dialog5.setCancelable(false);
        }
        Dialog dialog6 = getDialog();
        if (dialog6 != null && (window = dialog6.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.setOnTouchListener(this);
        }
        Dialog dialog7 = getDialog();
        if (dialog7 != null) {
            dialog7.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.roger.catloadinglibrary.BaseDialogFragment.onActivityCreated.2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 && i != 111) {
                        return false;
                    }
                    BaseDialogFragment.this.dismiss();
                    return true;
                }
            });
        }
        if (savedInstanceState == null || (bundle = savedInstanceState.getBundle("android:savedDialogState")) == null) {
            return;
        }
        Dialog dialog8 = getDialog();
        Intrinsics.checkNotNull(dialog8);
        dialog8.onRestoreInstanceState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean mCancelable) {
        this.cancelable = mCancelable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (!this.cancelable) {
            return false;
        }
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog!!");
        if (!dialog.isShowing()) {
            return false;
        }
        dismiss();
        return true;
    }
}
