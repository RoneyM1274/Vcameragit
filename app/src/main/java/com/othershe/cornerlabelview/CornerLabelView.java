package com.othershe.cornerlabelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public class CornerLabelView extends View {
    private int bgColor;
    private int mHalfWidth;
    private Paint mPaint;
    private Path mPath;
    private TextPaint mTextPaint;
    private int marginLeanSide;
    private int position;
    private int sideLength;
    private String text;
    private int textColor;
    private int textSize;

    public CornerLabelView(Context context) {
        this(context, null);
    }

    public CornerLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sideLength = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        this.textSize = (int) TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics());
        this.textColor = -1;
        this.bgColor = SupportMenu.CATEGORY_MASK;
        this.marginLeanSide = -1;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornerLabelView, 0, 0);
        for (int i = 0; i < typedArrayObtainStyledAttributes.getIndexCount(); i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CornerLabelView_position) {
                this.position = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == R.styleable.CornerLabelView_side_length) {
                this.sideLength = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.sideLength);
            } else if (index == R.styleable.CornerLabelView_text_size) {
                this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.textSize);
            } else if (index == R.styleable.CornerLabelView_text_color) {
                this.textColor = typedArrayObtainStyledAttributes.getColor(index, this.textColor);
            } else if (index == R.styleable.CornerLabelView_text) {
                this.text = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.CornerLabelView_bg_color) {
                this.bgColor = typedArrayObtainStyledAttributes.getColor(index, this.bgColor);
            } else if (index == R.styleable.CornerLabelView_margin_lean_side) {
                this.marginLeanSide = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.marginLeanSide);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void init() {
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(this.bgColor);
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setColor(this.textColor);
        this.mTextPaint.setTextSize(this.textSize);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            int i3 = this.sideLength;
            setMeasuredDimension(i3 * 2, i3 * 2);
        } else {
            if (mode == Integer.MIN_VALUE) {
                setMeasuredDimension(size2, size2);
                return;
            }
            if (mode2 == Integer.MIN_VALUE) {
                setMeasuredDimension(size, size);
            } else if (size != size2) {
                int iMin = Math.min(size, size2);
                setMeasuredDimension(iMin, iMin);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHalfWidth = Math.min(i, i2) / 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int i2 = this.mHalfWidth;
        canvas.translate(i2, i2);
        canvas.rotate(this.position * 90);
        int i3 = this.sideLength;
        int i4 = this.mHalfWidth;
        if (i3 > i4 * 2) {
            this.sideLength = i4 * 2;
        }
        this.mPath.moveTo(-i4, -i4);
        Path path = this.mPath;
        int i5 = this.sideLength;
        int i6 = this.mHalfWidth;
        path.lineTo(i5 - i6, -i6);
        Path path2 = this.mPath;
        int i7 = this.mHalfWidth;
        path2.lineTo(i7, i7 - this.sideLength);
        Path path3 = this.mPath;
        int i8 = this.mHalfWidth;
        path3.lineTo(i8, i8);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.rotate(45.0f);
        int iSqrt = (int) ((Math.sqrt(2.0d) / 2.0d) * ((double) this.sideLength));
        int i9 = (int) (-(this.mTextPaint.ascent() + this.mTextPaint.descent()));
        int i10 = ((int) (-this.mTextPaint.measureText(this.text))) / 2;
        int i11 = this.marginLeanSide;
        if (i11 >= 0) {
            int i12 = this.position;
            if (i12 == 1 || i12 == 2) {
                float f = iSqrt;
                int i13 = iSqrt - i9;
                if (f - (i11 - this.mTextPaint.ascent()) < i13 / 2) {
                    i = (-i13) / 2;
                } else {
                    i = (int) (-(f - (this.marginLeanSide - this.mTextPaint.ascent())));
                }
            } else {
                if (i11 < this.mTextPaint.descent()) {
                    this.marginLeanSide = (int) this.mTextPaint.descent();
                }
                int i14 = (iSqrt - i9) / 2;
                if (this.marginLeanSide > i14) {
                    this.marginLeanSide = i14;
                }
                i = -this.marginLeanSide;
            }
        } else {
            int i15 = this.sideLength;
            int i16 = this.mHalfWidth;
            if (i15 > i16) {
                this.sideLength = i16;
            }
            i = ((int) ((((-Math.sqrt(2.0d)) / 2.0d) * ((double) this.sideLength)) + ((double) i9))) / 2;
        }
        int i17 = this.position;
        if (i17 == 1 || i17 == 2) {
            canvas.translate(0.0f, (float) (((-Math.sqrt(2.0d)) / 2.0d) * ((double) this.sideLength)));
            canvas.scale(-1.0f, -1.0f);
        }
        canvas.drawText(this.text, i10, i, this.mTextPaint);
    }

    public CornerLabelView setBgColorId(int i) {
        int color = getResources().getColor(i);
        this.bgColor = color;
        this.mPaint.setColor(color);
        invalidate();
        return this;
    }

    public CornerLabelView setBgColor(int i) {
        this.mPaint.setColor(i);
        invalidate();
        return this;
    }

    public CornerLabelView setTextColorId(int i) {
        int color = getResources().getColor(i);
        this.textColor = color;
        this.mTextPaint.setColor(color);
        invalidate();
        return this;
    }

    public CornerLabelView setTextColor(int i) {
        this.mTextPaint.setColor(i);
        invalidate();
        return this;
    }

    public CornerLabelView setText(int i) {
        this.text = getResources().getString(i);
        invalidate();
        return this;
    }

    public CornerLabelView setText(String str) {
        this.text = str;
        invalidate();
        return this;
    }
}
