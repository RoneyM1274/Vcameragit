package com.material.shape;

import android.graphics.RectF;

import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: loaded from: classes.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f, float f2, com.google.android.material.shape.ShapePath shapePath) {
    }

    public void getCornerPath(com.google.android.material.shape.ShapePath shapePath, float f, float f2, float f3) {
        getCornerPath(f, f2, shapePath);
    }

    public void getCornerPath(ShapePath shapePath, float f, float f2, RectF rectF, CornerSize cornerSize) {
        getCornerPath(shapePath, f, f2, cornerSize.getCornerSize(rectF));
    }
}
