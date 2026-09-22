package com.roger.catloadinglibrary;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EyelidView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\tH\u0014J\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u0017J\b\u0010&\u001a\u00020\rH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/roger/catloadinglibrary/EyelidView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "duration", "isFromFull", "", "isLoading", "isStop", "paint", "Landroid/graphics/Paint;", NotificationCompat.CATEGORY_PROGRESS, "", "valueAnimator", "Landroid/animation/ValueAnimator;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onVisibilityChanged", "changedView", "visibility", "resetAnimator", "setColor", "color", "setDuration", "setFromFull", "fromFull", "startLoading", "stopLoading", "whenStop", "catloadinglibrary_release"}, k = 1, mv = {1, 4, 1})
public final class EyelidView extends View {
    private HashMap _$_findViewCache;
    private int duration;
    private boolean isFromFull;
    private boolean isLoading;
    private boolean isStop;
    private Paint paint;
    private float progress;
    private ValueAnimator valueAnimator;

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
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public EyelidView(Context context) {
        super(context);
        this.isStop = true;
        this.duration = 1000;
        init();
    }

    public EyelidView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isStop = true;
        this.duration = 1000;
        init();
    }

    public EyelidView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isStop = true;
        this.duration = 1000;
        init();
    }

    private final void init() {
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint2 = this.paint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
        }
        paint2.setStyle(Paint.Style.FILL);
        setBackground((Drawable) null);
        setFocusable(false);
        setEnabled(false);
        setFocusableInTouchMode(false);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(this.duration);
        Intrinsics.checkNotNullExpressionValue(duration, "ValueAnimator.ofFloat(0f…ration(duration.toLong())");
        this.valueAnimator = duration;
        if (duration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        valueAnimator.setRepeatCount(-1);
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        valueAnimator2.setRepeatMode(2);
        ValueAnimator valueAnimator3 = this.valueAnimator;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.roger.catloadinglibrary.EyelidView.init.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator animation) {
                EyelidView eyelidView = EyelidView.this;
                Intrinsics.checkNotNullExpressionValue(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                eyelidView.progress = ((Float) animatedValue).floatValue();
                EyelidView.this.invalidate();
            }
        });
    }

    public final void setColor(int color) {
        Paint paint = this.paint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
        }
        paint.setColor(color);
    }

    public final void startLoading() {
        if (this.isStop) {
            this.isLoading = true;
            this.isStop = false;
            ValueAnimator valueAnimator = this.valueAnimator;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
            }
            valueAnimator.start();
        }
    }

    public final void resetAnimator() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        valueAnimator.start();
    }

    public final void stopLoading() {
        this.isLoading = false;
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        valueAnimator.end();
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        valueAnimator2.cancel();
        this.isStop = true;
    }

    public final void setDuration(int duration) {
        this.duration = duration;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (this.isLoading) {
            if (visibility == 0) {
                ValueAnimator valueAnimator = this.valueAnimator;
                if (valueAnimator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
                }
                valueAnimator.resume();
                return;
            }
            ValueAnimator valueAnimator2 = this.valueAnimator;
            if (valueAnimator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
            }
            valueAnimator2.pause();
        }
    }

    public final void setFromFull(boolean fromFull) {
        this.isFromFull = fromFull;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        int height;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isStop) {
            return;
        }
        if (!this.isFromFull) {
            f = this.progress;
            height = getHeight();
        } else {
            f = 1.0f - this.progress;
            height = getHeight();
        }
        float height2 = f * height;
        if (height2 >= getHeight() / 2) {
            height2 = getHeight() / 2;
        }
        float f2 = height2;
        float width = getWidth();
        Paint paint = this.paint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
        }
        canvas.drawRect(0.0f, 0.0f, width, f2, paint);
    }

    private final boolean whenStop() {
        return !this.isLoading && this.progress <= 0.001f;
    }
}
