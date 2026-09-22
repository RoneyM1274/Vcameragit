package com.afollestad.materialdialogs.utils;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntArrays.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¨\u0006\u0006"}, d2 = {"appendAll", "", "values", "", "", "removeAll", "core"}, k = 2, mv = {1, 1, 16})
public final class IntArraysKt {
    public static final int[] appendAll(int[] appendAll, Collection<Integer> values) {
        Intrinsics.checkParameterIsNotNull(appendAll, "$this$appendAll");
        Intrinsics.checkParameterIsNotNull(values, "values");
        List<Integer> mutableList = kotlin.collections.ArraysKt.toMutableList(appendAll);
        mutableList.addAll(values);
        return CollectionsKt.toIntArray(mutableList);
    }

    public static final int[] removeAll(int[] removeAll, final Collection<Integer> values) {
        Intrinsics.checkParameterIsNotNull(removeAll, "$this$removeAll");
        Intrinsics.checkParameterIsNotNull(values, "values");
        List<Integer> mutableList = kotlin.collections.ArraysKt.toMutableList(removeAll);
        CollectionsKt.removeAll((List) mutableList, (Function1) new Function1<Integer, Boolean>() { // from class: com.afollestad.materialdialogs.utils.IntArraysKt$removeAll$$inlined$apply$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return Boolean.valueOf(invoke(num.intValue()));
            }

            public final boolean invoke(int i) {
                return values.contains(Integer.valueOf(i));
            }
        });
        return CollectionsKt.toIntArray(mutableList);
    }
}
