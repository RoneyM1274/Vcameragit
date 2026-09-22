package com.simplesearchview;

import com.ferfalk.simplesearchview.SimpleSearchView;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleOnQueryTextListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/ferfalk/simplesearchview/SimpleOnQueryTextListener;", "Lcom/ferfalk/simplesearchview/SimpleSearchView$OnQueryTextListener;", "()V", "onQueryTextChange", "", "newText", "", "onQueryTextCleared", "onQueryTextSubmit", "query", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
public abstract class SimpleOnQueryTextListener implements SimpleSearchView.OnQueryTextListener {
    @Override // com.ferfalk.simplesearchview.SimpleSearchView.OnQueryTextListener
    public boolean onQueryTextChange(String newText) {
        Intrinsics.checkNotNullParameter(newText, "newText");
        return false;
    }

    @Override // com.ferfalk.simplesearchview.SimpleSearchView.OnQueryTextListener
    public boolean onQueryTextCleared() {
        return false;
    }

    @Override // com.ferfalk.simplesearchview.SimpleSearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return false;
    }
}
