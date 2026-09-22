package com.viewpagerdotsindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WormDotsIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0007J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/WormDotsIndicator;", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dotIndicatorColor", "dotIndicatorLayout", "Landroid/view/View;", "dotIndicatorView", "Landroid/widget/ImageView;", "dotIndicatorWidthSpring", "Landroidx/dynamicanimation/animation/SpringAnimation;", "dotIndicatorXSpring", "dotsStrokeColor", "dotsStrokeWidth", "strokeDotsLinearLayout", "Landroid/widget/LinearLayout;", "type", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "getType", "()Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "addDot", "", "index", "buildDot", "Landroid/view/ViewGroup;", "stroke", "", "buildOnPageChangedListener", "Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "refreshDotColor", "removeDot", "setDotIndicatorColor", "color", "setStrokeDotsIndicatorColor", "setUpDotBackground", "dotImageView", "setUpDotIndicator", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 4, 2})
public final class WormDotsIndicator extends BaseDotsIndicator {
    private HashMap _$_findViewCache;
    private int dotIndicatorColor;
    private View dotIndicatorLayout;
    private ImageView dotIndicatorView;
    private SpringAnimation dotIndicatorWidthSpring;
    private SpringAnimation dotIndicatorXSpring;
    private int dotsStrokeColor;
    private int dotsStrokeWidth;
    private final LinearLayout strokeDotsLinearLayout;

    public WormDotsIndicator(Context context) {
        this(context, null, 0, 6, null);
    }

    public WormDotsIndicator(Context context, AttributeSet attributeSet) {
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

    public /* synthetic */ WormDotsIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WormDotsIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        this.strokeDotsLinearLayout = linearLayout;
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        int iDpToPx = dpToPx(24);
        setPadding(iDpToPx, 0, iDpToPx, 0);
        setClipToPadding(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        addView(linearLayout);
        this.dotsStrokeWidth = dpToPx(2);
        int themePrimaryColor = getThemePrimaryColor(context);
        this.dotIndicatorColor = themePrimaryColor;
        this.dotsStrokeColor = themePrimaryColor;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tbuonomo.viewpagerdotsindicator.R.styleable.WormDotsIndicator);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "getContext().obtainStyle…leable.WormDotsIndicator)");
            this.dotIndicatorColor = typedArrayObtainStyledAttributes.getColor(com.tbuonomo.viewpagerdotsindicator.R.styleable.WormDotsIndicator_dotsColor, this.dotIndicatorColor);
            this.dotsStrokeColor = typedArrayObtainStyledAttributes.getColor(com.tbuonomo.viewpagerdotsindicator.R.styleable.WormDotsIndicator_dotsStrokeColor, this.dotIndicatorColor);
            this.dotsStrokeWidth = (int) typedArrayObtainStyledAttributes.getDimension(com.tbuonomo.viewpagerdotsindicator.R.styleable.WormDotsIndicator_dotsStrokeWidth, this.dotsStrokeWidth);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (isInEditMode()) {
            addDots(5);
            addView(buildDot(false));
        }
        setUpDotIndicator();
    }

    private final void setUpDotIndicator() {
        Pager pager = getPager();
        if (pager == null || !pager.isEmpty()) {
            ImageView imageView = this.dotIndicatorView;
            if (imageView != null && indexOfChild(imageView) != -1) {
                removeView(this.dotIndicatorView);
            }
            ViewGroup viewGroupBuildDot = buildDot(false);
            this.dotIndicatorLayout = viewGroupBuildDot;
            Intrinsics.checkNotNull(viewGroupBuildDot);
            this.dotIndicatorView = (ImageView) viewGroupBuildDot.findViewById(com.tbuonomo.viewpagerdotsindicator.R.id.worm_dot);
            addView(this.dotIndicatorLayout);
            this.dotIndicatorXSpring = new SpringAnimation(this.dotIndicatorLayout, SpringAnimation.TRANSLATION_X);
            SpringForce springForce = new SpringForce(0.0f);
            springForce.setDampingRatio(1.0f);
            springForce.setStiffness(300.0f);
            SpringAnimation springAnimation = this.dotIndicatorXSpring;
            Intrinsics.checkNotNull(springAnimation);
            springAnimation.setSpring(springForce);
            final String str = "DotsWidth";
            this.dotIndicatorWidthSpring = new SpringAnimation(this.dotIndicatorLayout, new FloatPropertyCompat<View>(str) { // from class: com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator$setUpDotIndicator$floatPropertyCompat$1
                @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
                public float getValue(View object) {
                    Intrinsics.checkNotNullParameter(object, "object");
                    ImageView imageView2 = this.this$0.dotIndicatorView;
                    Intrinsics.checkNotNull(imageView2);
                    return imageView2.getLayoutParams().width;
                }

                @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
                public void setValue(View object, float value) {
                    Intrinsics.checkNotNullParameter(object, "object");
                    ImageView imageView2 = this.this$0.dotIndicatorView;
                    Intrinsics.checkNotNull(imageView2);
                    imageView2.getLayoutParams().width = (int) value;
                    ImageView imageView3 = this.this$0.dotIndicatorView;
                    Intrinsics.checkNotNull(imageView3);
                    imageView3.requestLayout();
                }
            });
            SpringForce springForce2 = new SpringForce(0.0f);
            springForce2.setDampingRatio(1.0f);
            springForce2.setStiffness(300.0f);
            SpringAnimation springAnimation2 = this.dotIndicatorWidthSpring;
            Intrinsics.checkNotNull(springAnimation2);
            springAnimation2.setSpring(springForce2);
        }
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void addDot(final int index) {
        ViewGroup viewGroupBuildDot = buildDot(true);
        viewGroupBuildDot.setOnClickListener(new OnClickListener() { // from class: com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator.addDot.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (WormDotsIndicator.this.getDotsClickable()) {
                    int i = index;
                    Pager pager = WormDotsIndicator.this.getPager();
                    if (i < (pager != null ? pager.getCount() : 0)) {
                        Pager pager2 = WormDotsIndicator.this.getPager();
                        Intrinsics.checkNotNull(pager2);
                        pager2.setCurrentItem(index, true);
                    }
                }
            }
        });
        ArrayList<ImageView> arrayList = this.dots;
        View viewFindViewById = viewGroupBuildDot.findViewById(com.tbuonomo.viewpagerdotsindicator.R.id.worm_dot);
        Objects.requireNonNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
        arrayList.add((ImageView) viewFindViewById);
        this.strokeDotsLinearLayout.addView(viewGroupBuildDot);
    }

    private final ViewGroup buildDot(boolean stroke) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(com.tbuonomo.viewpagerdotsindicator.R.layout.worm_dot_layout, (ViewGroup) this, false);
        Objects.requireNonNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        if (Build.VERSION.SDK_INT >= 17) {
            viewGroup.setLayoutDirection(0);
        }
        View dotImageView = viewGroup.findViewById(com.tbuonomo.viewpagerdotsindicator.R.id.worm_dot);
        dotImageView.setBackgroundResource(stroke ? com.tbuonomo.viewpagerdotsindicator.R.drawable.worm_dot_stroke_background : com.tbuonomo.viewpagerdotsindicator.R.drawable.worm_dot_background);
        Intrinsics.checkNotNullExpressionValue(dotImageView, "dotImageView");
        ViewGroup.LayoutParams layoutParams = dotImageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = (int) getDotsSize();
        layoutParams2.width = layoutParams2.height;
        layoutParams2.addRule(15, -1);
        layoutParams2.setMargins((int) getDotsSpacing(), 0, (int) getDotsSpacing(), 0);
        setUpDotBackground(stroke, dotImageView);
        return viewGroup;
    }

    private final void setUpDotBackground(boolean stroke, View dotImageView) {
        Drawable background = dotImageView.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (stroke) {
            gradientDrawable.setStroke(this.dotsStrokeWidth, this.dotsStrokeColor);
        } else {
            gradientDrawable.setColor(this.dotIndicatorColor);
        }
        gradientDrawable.setCornerRadius(getDotsCornerRadius());
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void refreshDotColor(int index) {
        ImageView imageView = this.dots.get(index);
        Intrinsics.checkNotNullExpressionValue(imageView, "dots[index]");
        setUpDotBackground(true, imageView);
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public void removeDot(int index) {
        LinearLayout linearLayout = this.strokeDotsLinearLayout;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
        this.dots.remove(this.dots.size() - 1);
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper buildOnPageChangedListener() {
        return new OnPageChangeListenerHelper() { // from class: com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator.buildOnPageChangedListener.1
            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public void resetPosition$viewpagerdotsindicator_release(int position) {
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public int getPageCount$viewpagerdotsindicator_release() {
                return WormDotsIndicator.this.dots.size();
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper
            public void onPageScrolled$viewpagerdotsindicator_release(int selectedPosition, int nextPosition, float positionOffset) {
                float dotsSize;
                ImageView imageView = WormDotsIndicator.this.dots.get(selectedPosition);
                Intrinsics.checkNotNullExpressionValue(imageView, "dots[selectedPosition]");
                ViewParent parent = imageView.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                float left = ((ViewGroup) parent).getLeft();
                ArrayList<ImageView> arrayList = WormDotsIndicator.this.dots;
                if (nextPosition != -1) {
                    selectedPosition = nextPosition;
                }
                ImageView imageView2 = arrayList.get(selectedPosition);
                Intrinsics.checkNotNullExpressionValue(imageView2, "dots[if (nextPosition ==…sition else nextPosition]");
                ViewParent parent2 = imageView2.getParent();
                Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                float left2 = ((ViewGroup) parent2).getLeft();
                if (positionOffset >= 0.0f && positionOffset <= 0.1f) {
                    dotsSize = WormDotsIndicator.this.getDotsSize();
                } else if (positionOffset >= 0.1f && positionOffset <= 0.9f) {
                    dotsSize = (left2 - left) + WormDotsIndicator.this.getDotsSize();
                } else {
                    left = left2;
                    dotsSize = WormDotsIndicator.this.getDotsSize();
                }
                SpringAnimation springAnimation = WormDotsIndicator.this.dotIndicatorXSpring;
                if (springAnimation != null) {
                    springAnimation.animateToFinalPosition(left);
                }
                SpringAnimation springAnimation2 = WormDotsIndicator.this.dotIndicatorWidthSpring;
                if (springAnimation2 != null) {
                    springAnimation2.animateToFinalPosition(dotsSize);
                }
            }
        };
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator
    public Type getType() {
        return Type.WORM;
    }

    public final void setDotIndicatorColor(int color) {
        ImageView imageView = this.dotIndicatorView;
        if (imageView != null) {
            this.dotIndicatorColor = color;
            Intrinsics.checkNotNull(imageView);
            setUpDotBackground(false, imageView);
        }
    }

    public final void setStrokeDotsIndicatorColor(int color) {
        this.dotsStrokeColor = color;
        for (ImageView v : this.dots) {
            Intrinsics.checkNotNullExpressionValue(v, "v");
            setUpDotBackground(true, v);
        }
    }
}
