package com.tbuonomo.viewpagerdotsindicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DotsIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0007H\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/DotsIndicator;", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "dotsElevation", "", "dotsWidthFactor", "linearLayout", "Landroid/widget/LinearLayout;", "progressMode", "", "value", "selectedDotColor", "getSelectedDotColor", "()I", "setSelectedDotColor", "(I)V", "type", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "getType", "()Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "addDot", "", "index", "buildOnPageChangedListener", "Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "init", "refreshDotColor", "removeDot", "setSelectedPointColor", "color", "Companion", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 4, 2})
public final class DotsIndicator extends BaseDotsIndicator {
    public static final float DEFAULT_WIDTH_FACTOR = 2.5f;
    private HashMap _$_findViewCache;
    private final ArgbEvaluator argbEvaluator;
    private float dotsElevation;
    private float dotsWidthFactor;
    private LinearLayout linearLayout;
    private boolean progressMode;
    private int selectedDotColor;

    public DotsIndicator(Context context) {
        this(context, null, 0, 6, null);
    }

    public DotsIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
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

    public /* synthetic */ DotsIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotsIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.argbEvaluator = new ArgbEvaluator();
        init(attributeSet);
    }

    public final int getSelectedDotColor() {
        return this.selectedDotColor;
    }

    public final void setSelectedDotColor(int i) {
        this.selectedDotColor = i;
        refreshDotsColors();
    }

    private final void init(AttributeSet attrs) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout linearLayout2 = this.linearLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        }
        addView(linearLayout2, -2, -2);
        this.dotsWidthFactor = 2.5f;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.DotsIndicator);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….styleable.DotsIndicator)");
            setSelectedDotColor(typedArrayObtainStyledAttributes.getColor(R.styleable.DotsIndicator_selectedDotColor, BaseDotsIndicator.DEFAULT_POINT_COLOR));
            float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.DotsIndicator_dotsWidthFactor, 2.5f);
            this.dotsWidthFactor = f;
            if (f < 1) {
                this.dotsWidthFactor = 2.5f;
            }
            this.progressMode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DotsIndicator_progressMode, false);
            this.dotsElevation = typedArrayObtainStyledAttributes.getDimension(R.styleable.DotsIndicator_dotsElevation, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (isInEditMode()) {
            addDots(5);
            refreshDots();
        }
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void addDot(final int index) {
        View dot = LayoutInflater.from(getContext()).inflate(R.layout.dot_layout, (ViewGroup) this, false);
        ImageView imageView = (ImageView) dot.findViewById(R.id.dot);
        Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (Build.VERSION.SDK_INT >= 17) {
            Intrinsics.checkNotNullExpressionValue(dot, "dot");
            dot.setLayoutDirection(0);
        }
        layoutParams2.height = (int) getDotsSize();
        layoutParams2.width = layoutParams2.height;
        layoutParams2.setMargins((int) getDotsSpacing(), 0, (int) getDotsSpacing(), 0);
        DotsGradientDrawable dotsGradientDrawable = new DotsGradientDrawable();
        dotsGradientDrawable.setCornerRadius(getDotsCornerRadius());
        if (isInEditMode()) {
            dotsGradientDrawable.setColor(index == 0 ? this.selectedDotColor : getDotsColor());
        } else {
            BaseDotsIndicator.Pager pager = getPager();
            Intrinsics.checkNotNull(pager);
            dotsGradientDrawable.setColor(pager.getCurrentItem() == index ? this.selectedDotColor : getDotsColor());
        }
        imageView.setBackgroundDrawable(dotsGradientDrawable);
        dot.setOnClickListener(new View.OnClickListener() { // from class: com.tbuonomo.viewpagerdotsindicator.DotsIndicator.addDot.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (DotsIndicator.this.getDotsClickable()) {
                    int i = index;
                    BaseDotsIndicator.Pager pager2 = DotsIndicator.this.getPager();
                    if (i < (pager2 != null ? pager2.getCount() : 0)) {
                        BaseDotsIndicator.Pager pager3 = DotsIndicator.this.getPager();
                        Intrinsics.checkNotNull(pager3);
                        pager3.setCurrentItem(index, true);
                    }
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Intrinsics.checkNotNullExpressionValue(dot, "dot");
            ViewExtKt.setPaddingHorizontal(dot, (int) (this.dotsElevation * 0.8f));
            ViewExtKt.setPaddingVertical(dot, (int) (this.dotsElevation * 2));
            imageView.setElevation(this.dotsElevation);
        }
        this.dots.add(imageView);
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        }
        linearLayout.addView(dot);
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void removeDot(int index) {
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        }
        LinearLayout linearLayout2 = this.linearLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        }
        linearLayout.removeViewAt(linearLayout2.getChildCount() - 1);
        this.dots.remove(this.dots.size() - 1);
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public OnPageChangeListenerHelper buildOnPageChangedListener() {
        return new OnPageChangeListenerHelper() { // from class: com.tbuonomo.viewpagerdotsindicator.DotsIndicator.buildOnPageChangedListener.1
            /* JADX WARN: Code duplicated, block: B:11:0x0100  */
            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public void onPageScrolled$viewpagerdotsindicator_release(int selectedPosition, int nextPosition, float positionOffset) {
                ImageView imageView = DotsIndicator.this.dots.get(selectedPosition);
                Intrinsics.checkNotNullExpressionValue(imageView, "dots[selectedPosition]");
                ImageView imageView2 = imageView;
                float f = 1;
                DotsIndicator.this.setWidth(imageView2, (int) (DotsIndicator.this.getDotsSize() + (DotsIndicator.this.getDotsSize() * (DotsIndicator.this.dotsWidthFactor - f) * (f - positionOffset))));
                DotsIndicator dotsIndicator = DotsIndicator.this;
                if (dotsIndicator.isInBounds(dotsIndicator.dots, nextPosition)) {
                    ImageView imageView3 = DotsIndicator.this.dots.get(nextPosition);
                    Intrinsics.checkNotNullExpressionValue(imageView3, "dots[nextPosition]");
                    ImageView imageView4 = imageView3;
                    DotsIndicator.this.setWidth(imageView4, (int) (DotsIndicator.this.getDotsSize() + (DotsIndicator.this.getDotsSize() * (DotsIndicator.this.dotsWidthFactor - f) * positionOffset)));
                    Drawable background = imageView2.getBackground();
                    Objects.requireNonNull(background, "null cannot be cast to non-null type com.tbuonomo.viewpagerdotsindicator.DotsGradientDrawable");
                    DotsGradientDrawable dotsGradientDrawable = (DotsGradientDrawable) background;
                    Drawable background2 = imageView4.getBackground();
                    Objects.requireNonNull(background2, "null cannot be cast to non-null type com.tbuonomo.viewpagerdotsindicator.DotsGradientDrawable");
                    DotsGradientDrawable dotsGradientDrawable2 = (DotsGradientDrawable) background2;
                    if (DotsIndicator.this.getSelectedDotColor() != DotsIndicator.this.getDotsColor()) {
                        Object objEvaluate = DotsIndicator.this.argbEvaluator.evaluate(positionOffset, Integer.valueOf(DotsIndicator.this.getSelectedDotColor()), Integer.valueOf(DotsIndicator.this.getDotsColor()));
                        Objects.requireNonNull(objEvaluate, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue = ((Integer) objEvaluate).intValue();
                        Object objEvaluate2 = DotsIndicator.this.argbEvaluator.evaluate(positionOffset, Integer.valueOf(DotsIndicator.this.getDotsColor()), Integer.valueOf(DotsIndicator.this.getSelectedDotColor()));
                        Objects.requireNonNull(objEvaluate2, "null cannot be cast to non-null type kotlin.Int");
                        dotsGradientDrawable2.setColor(((Integer) objEvaluate2).intValue());
                        if (DotsIndicator.this.progressMode) {
                            BaseDotsIndicator.Pager pager = DotsIndicator.this.getPager();
                            Intrinsics.checkNotNull(pager);
                            if (selectedPosition <= pager.getCurrentItem()) {
                                dotsGradientDrawable.setColor(DotsIndicator.this.getSelectedDotColor());
                            } else {
                                dotsGradientDrawable.setColor(iIntValue);
                            }
                        } else {
                            dotsGradientDrawable.setColor(iIntValue);
                        }
                    }
                }
                DotsIndicator.this.invalidate();
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public void resetPosition$viewpagerdotsindicator_release(int position) {
                DotsIndicator dotsIndicator = DotsIndicator.this;
                ImageView imageView = dotsIndicator.dots.get(position);
                Intrinsics.checkNotNullExpressionValue(imageView, "dots[position]");
                dotsIndicator.setWidth(imageView, (int) DotsIndicator.this.getDotsSize());
                DotsIndicator.this.refreshDotColor(position);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public int getPageCount$viewpagerdotsindicator_release() {
                return DotsIndicator.this.dots.size();
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void refreshDotColor(int index) {
        ImageView imageView = this.dots.get(index);
        Intrinsics.checkNotNullExpressionValue(imageView, "dots[index]");
        ImageView imageView2 = imageView;
        Drawable background = imageView2.getBackground();
        if (!(background instanceof DotsGradientDrawable)) {
            background = null;
        }
        DotsGradientDrawable dotsGradientDrawable = (DotsGradientDrawable) background;
        if (dotsGradientDrawable != null) {
            BaseDotsIndicator.Pager pager = getPager();
            Intrinsics.checkNotNull(pager);
            if (index == pager.getCurrentItem()) {
                dotsGradientDrawable.setColor(this.selectedDotColor);
            } else {
                if (this.progressMode) {
                    BaseDotsIndicator.Pager pager2 = getPager();
                    Intrinsics.checkNotNull(pager2);
                    if (index < pager2.getCurrentItem()) {
                        dotsGradientDrawable.setColor(this.selectedDotColor);
                    }
                }
                dotsGradientDrawable.setColor(getDotsColor());
            }
        }
        imageView2.setBackgroundDrawable(dotsGradientDrawable);
        imageView2.invalidate();
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public BaseDotsIndicator.Type getType() {
        return BaseDotsIndicator.Type.DEFAULT;
    }

    @Deprecated(message = "Use setSelectedDotColor() instead", replaceWith = @ReplaceWith(expression = "setSelectedDotColor()", imports = {}))
    public final void setSelectedPointColor(int color) {
        setSelectedDotColor(color);
    }
}
