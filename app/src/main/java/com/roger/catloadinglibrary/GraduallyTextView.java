package com.roger.catloadinglibrary;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraduallyTextView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH\u0014J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/roger/catloadinglibrary/GraduallyTextView;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "charSequence", "", "duration", "isLoading", "", "isStop", "localScaleX", "", "paint", "Landroid/graphics/Paint;", NotificationCompat.CATEGORY_PROGRESS, "singleDuration", "startY", "textLength", "valueAnimator", "Landroid/animation/ValueAnimator;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "setDuration", "startLoading", "stopLoading", "catloadinglibrary_release"}, k = 1, mv = {1, 4, 1})
public final class GraduallyTextView extends AppCompatEditText {
    private HashMap _$_findViewCache;
    private CharSequence charSequence;
    private int duration;
    private boolean isLoading;
    private boolean isStop;
    private float localScaleX;
    private Paint paint;
    private float progress;
    private float singleDuration;
    private int startY;
    private int textLength;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraduallyTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isStop = true;
        this.duration = 2000;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraduallyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isStop = true;
        this.duration = 2000;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraduallyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isStop = true;
        this.duration = 2000;
        init();
    }

    private final void init() {
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        setBackground((Drawable) null);
        setCursorVisible(false);
        setFocusable(false);
        setEnabled(false);
        setFocusableInTouchMode(false);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(this.duration);
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
        valueAnimator2.setRepeatMode(1);
        ValueAnimator valueAnimator3 = this.valueAnimator;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
        }
        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.roger.catloadinglibrary.GraduallyTextView.init.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator animation) {
                GraduallyTextView graduallyTextView = GraduallyTextView.this;
                Intrinsics.checkNotNullExpressionValue(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                graduallyTextView.progress = ((Float) animatedValue).floatValue();
                GraduallyTextView.this.invalidate();
            }
        });
    }

    public final void startLoading() {
        if (this.isStop) {
            Editable text = getText();
            Intrinsics.checkNotNull(text);
            this.textLength = text.length();
            if (String.valueOf(getText()).length() == 0) {
                return;
            }
            this.isLoading = true;
            this.isStop = false;
            Editable text2 = getText();
            Intrinsics.checkNotNull(text2);
            this.charSequence = text2;
            this.localScaleX = getTextScaleX() * 10;
            this.startY = getLineHeight();
            Paint paint = this.paint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            paint.setColor(getCurrentTextColor());
            Paint paint2 = this.paint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            paint2.setTextSize(getTextSize());
            setMinWidth(getWidth());
            setText("");
            setHint("");
            ValueAnimator valueAnimator = this.valueAnimator;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueAnimator");
            }
            valueAnimator.start();
            this.singleDuration = 100.0f / this.textLength;
        }
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
        CharSequence charSequence = this.charSequence;
        if (charSequence == null) {
            Intrinsics.throwUninitializedPropertyAccessException("charSequence");
        }
        setText(charSequence);
    }

    public final void setDuration(int duration) {
        this.duration = duration;
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isStop) {
            return;
        }
        Paint paint = this.paint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
        }
        paint.setAlpha(255);
        if (this.progress / this.singleDuration >= 1) {
            CharSequence charSequence = this.charSequence;
            if (charSequence == null) {
                Intrinsics.throwUninitializedPropertyAccessException("charSequence");
            }
            String string = charSequence.toString();
            int i = (int) (this.progress / this.singleDuration);
            float f = this.localScaleX;
            float f2 = this.startY;
            Paint paint2 = this.paint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            canvas.drawText(string, 0, i, f, f2, paint2);
        }
        Paint paint3 = this.paint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
        }
        float f3 = this.progress;
        float f4 = this.singleDuration;
        paint3.setAlpha((int) (255 * ((f3 % f4) / f4)));
        int i2 = (int) (this.progress / this.singleDuration);
        if (i2 < this.textLength) {
            CharSequence charSequence2 = this.charSequence;
            if (charSequence2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("charSequence");
            }
            String strValueOf = String.valueOf(charSequence2.charAt(i2));
            float f5 = this.localScaleX;
            Paint paint4 = this.paint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            CharSequence charSequence3 = this.charSequence;
            if (charSequence3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("charSequence");
            }
            float fMeasureText = f5 + paint4.measureText(charSequence3.subSequence(0, i2).toString());
            float height = getHeight() / 2;
            Paint paint5 = this.paint;
            if (paint5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            canvas.drawText(strValueOf, 0, 1, fMeasureText, height, paint5);
        }
    }
}
