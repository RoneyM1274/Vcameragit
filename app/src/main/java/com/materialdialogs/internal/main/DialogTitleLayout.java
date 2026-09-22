package com.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.main.BaseSubLayout;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DialogTitleLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0014J0\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0014J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0014J\u0006\u0010(\u001a\u00020 R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;", "Lcom/afollestad/materialdialogs/internal/main/BaseSubLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frameMarginHorizontal", "", "frameMarginVertical", "iconMargin", "iconSize", "iconView", "Landroid/widget/ImageView;", "getIconView$core", "()Landroid/widget/ImageView;", "setIconView$core", "(Landroid/widget/ImageView;)V", "titleMarginBottom", "titleView", "Landroid/widget/TextView;", "getTitleView$core", "()Landroid/widget/TextView;", "setTitleView$core", "(Landroid/widget/TextView;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onFinishInflate", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "shouldNotBeVisible", "core"}, k = 1, mv = {1, 1, 16})
public final class DialogTitleLayout extends BaseSubLayout {
    private final int frameMarginHorizontal;
    private final int frameMarginVertical;
    private final int iconMargin;
    private final int iconSize;
    public ImageView iconView;
    private final int titleMarginBottom;
    public TextView titleView;

    public /* synthetic */ DialogTitleLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? (AttributeSet) null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.frameMarginVertical = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_frame_margin_vertical);
        this.titleMarginBottom = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_title_layout_margin_bottom);
        this.frameMarginHorizontal = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_frame_margin_horizontal);
        this.iconMargin = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_icon_margin);
        this.iconSize = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_icon_size);
    }

    public final ImageView getIconView$core() {
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        return imageView;
    }

    public final void setIconView$core(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.iconView = imageView;
    }

    public final TextView getTitleView$core() {
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        return textView;
    }

    public final void setTitleView$core(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.titleView = textView;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(R.id.md_icon_title);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById, "findViewById(R.id.md_icon_title)");
        this.iconView = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.md_text_title);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById2, "findViewById(R.id.md_text_title)");
        this.titleView = (TextView) viewFindViewById2;
    }

    public final boolean shouldNotBeVisible() {
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        if (ViewsKt.isNotVisible(imageView)) {
            TextView textView = this.titleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            }
            if (ViewsKt.isNotVisible(textView)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight = 0;
        if (shouldNotBeVisible()) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int measuredWidth = size - (this.frameMarginHorizontal * 2);
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        if (ViewsKt.isVisible(imageView)) {
            ImageView imageView2 = this.iconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconView");
            }
            imageView2.measure(MeasureSpec.makeMeasureSpec(this.iconSize, BasicMeasure.EXACTLY), MeasureSpec.makeMeasureSpec(this.iconSize, BasicMeasure.EXACTLY));
            ImageView imageView3 = this.iconView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconView");
            }
            measuredWidth -= imageView3.getMeasuredWidth() + this.iconMargin;
        }
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        textView.measure(MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        ImageView imageView4 = this.iconView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        if (ViewsKt.isVisible(imageView4)) {
            ImageView imageView5 = this.iconView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconView");
            }
            measuredHeight = imageView5.getMeasuredHeight();
        }
        TextView textView2 = this.titleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        setMeasuredDimension(size, RangesKt.coerceAtLeast(measuredHeight, textView2.getMeasuredHeight()) + this.frameMarginVertical + this.titleMarginBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredWidth;
        int measuredWidth2;
        int measuredWidth3;
        int i;
        if (shouldNotBeVisible()) {
            return;
        }
        int i2 = this.frameMarginVertical;
        int measuredHeight = getMeasuredHeight() - this.titleMarginBottom;
        int i3 = measuredHeight - ((measuredHeight - i2) / 2);
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        int measuredHeight2 = textView.getMeasuredHeight() / 2;
        int i4 = i3 - measuredHeight2;
        int i5 = measuredHeight2 + i3;
        MDUtil mDUtil = MDUtil.INSTANCE;
        TextView textView2 = this.titleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        int iAdditionalPaddingForFont = i5 + mDUtil.additionalPaddingForFont(textView2);
        if (ViewsKt.isRtl(this)) {
            measuredWidth2 = getMeasuredWidth() - this.frameMarginHorizontal;
            TextView textView3 = this.titleView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            }
            measuredWidth = measuredWidth2 - textView3.getMeasuredWidth();
        } else {
            measuredWidth = this.frameMarginHorizontal;
            TextView textView4 = this.titleView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            }
            measuredWidth2 = textView4.getMeasuredWidth() + measuredWidth;
        }
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        if (ViewsKt.isVisible(imageView)) {
            ImageView imageView2 = this.iconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconView");
            }
            int measuredHeight3 = imageView2.getMeasuredHeight() / 2;
            int i6 = i3 - measuredHeight3;
            int i7 = i3 + measuredHeight3;
            if (ViewsKt.isRtl(this)) {
                ImageView imageView3 = this.iconView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconView");
                }
                measuredWidth = measuredWidth2 - imageView3.getMeasuredWidth();
                i = measuredWidth - this.iconMargin;
                TextView textView5 = this.titleView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                }
                measuredWidth3 = i - textView5.getMeasuredWidth();
            } else {
                ImageView imageView4 = this.iconView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconView");
                }
                measuredWidth2 = imageView4.getMeasuredWidth() + measuredWidth;
                int i8 = this.iconMargin + measuredWidth2;
                TextView textView6 = this.titleView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                }
                int measuredWidth4 = textView6.getMeasuredWidth() + i8;
                measuredWidth3 = i8;
                i = measuredWidth4;
            }
            ImageView imageView5 = this.iconView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconView");
            }
            imageView5.layout(measuredWidth, i6, measuredWidth2, i7);
            measuredWidth2 = i;
            measuredWidth = measuredWidth3;
        }
        TextView textView7 = this.titleView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        textView7.layout(measuredWidth, i4, measuredWidth2, iAdditionalPaddingForFont);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        if (getDrawDivider()) {
            canvas.drawLine(0.0f, getMeasuredHeight() - getDividerHeight(), getMeasuredWidth(), getMeasuredHeight(), dividerPaint());
        }
    }
}
