package com.simplesearchview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ferfalk.simplesearchview.R;

/* JADX INFO: loaded from: classes.dex */
public final class SearchViewBinding implements ViewBinding {
    public final ImageButton backButton;
    public final View bottomLine;
    public final ImageButton clearButton;
    private final FrameLayout rootView;
    public final ConstraintLayout searchContainer;
    public final EditText searchEditText;
    public final ImageButton voiceButton;

    private SearchViewBinding(FrameLayout frameLayout, ImageButton imageButton, View view, ImageButton imageButton2, ConstraintLayout constraintLayout, EditText editText, ImageButton imageButton3) {
        this.rootView = frameLayout;
        this.backButton = imageButton;
        this.bottomLine = view;
        this.clearButton = imageButton2;
        this.searchContainer = constraintLayout;
        this.searchEditText = editText;
        this.voiceButton = imageButton3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static SearchViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SearchViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.search_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SearchViewBinding bind(View view) {
        View viewFindViewById;
        int i = R.id.backButton;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null && (viewFindViewById = view.findViewById((i = R.id.bottomLine))) != null) {
            i = R.id.clearButton;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = R.id.searchContainer;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                if (constraintLayout != null) {
                    i = R.id.searchEditText;
                    EditText editText = (EditText) view.findViewById(i);
                    if (editText != null) {
                        i = R.id.voiceButton;
                        ImageButton imageButton3 = (ImageButton) view.findViewById(i);
                        if (imageButton3 != null) {
                            return new SearchViewBinding((FrameLayout) view, imageButton, viewFindViewById, imageButton2, constraintLayout, editText, imageButton3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
