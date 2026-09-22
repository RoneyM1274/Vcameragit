package com.github.nukc.stateview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.collection.ArraySet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 W2\u00020\u0001:\u0004WXYZB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0001H\u0002J\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\u0012\u0010E\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0017J\u0010\u0010F\u001a\u00020B2\u0006\u0010G\u001a\u00020\u0001H\u0002J\u001a\u0010H\u001a\u00020\u00012\b\b\u0001\u0010I\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0002J\u0018\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH\u0014J\u0012\u0010M\u001a\u00020B2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010N\u001a\u00020B2\u0006\u0010=\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010O\u001a\u00020B2\b\u0010@\u001a\u0004\u0018\u00010\u00012\u0006\u0010P\u001a\u00020\tH\u0002J\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020\tH\u0016J\b\u0010Q\u001a\u00020BH\u0002J\u0006\u0010R\u001a\u00020BJ\u0006\u0010S\u001a\u00020\u0001J\u0006\u0010T\u001a\u00020\u0001J\u0006\u0010U\u001a\u00020\u0001J\u0010\u0010G\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\tH\u0002J\u0010\u0010V\u001a\u00020B2\u0006\u0010@\u001a\u00020\u0001H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R(\u0010'\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R(\u00109\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001d¨\u0006["}, d2 = {"Lcom/github/nukc/stateview/StateView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addSet", "Landroidx/collection/ArraySet;", "value", "Lcom/github/nukc/stateview/AnimatorProvider;", "animatorProvider", "getAnimatorProvider", "()Lcom/github/nukc/stateview/AnimatorProvider;", "setAnimatorProvider", "(Lcom/github/nukc/stateview/AnimatorProvider;)V", "emptyResource", "getEmptyResource", "()I", "setEmptyResource", "(I)V", "emptyView", "getEmptyView", "()Landroid/view/View;", "setEmptyView", "(Landroid/view/View;)V", "inflater", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "setInflater", "(Landroid/view/LayoutInflater;)V", "loadingResource", "getLoadingResource", "setLoadingResource", "loadingView", "getLoadingView", "setLoadingView", "onInflateListener", "Lcom/github/nukc/stateview/StateView$OnInflateListener;", "getOnInflateListener", "()Lcom/github/nukc/stateview/StateView$OnInflateListener;", "setOnInflateListener", "(Lcom/github/nukc/stateview/StateView$OnInflateListener;)V", "onRetryClickListener", "Lcom/github/nukc/stateview/StateView$OnRetryClickListener;", "getOnRetryClickListener", "()Lcom/github/nukc/stateview/StateView$OnRetryClickListener;", "setOnRetryClickListener", "(Lcom/github/nukc/stateview/StateView$OnRetryClickListener;)V", "retryResource", "getRetryResource", "setRetryResource", "retryView", "getRetryView", "setRetryView", "addToParent", "viewType", "viewParent", "Landroid/view/ViewGroup;", "view", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "draw", "hideViews", "showView", "inflate", "layoutResource", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "reset", "setView", "setVisibility", "visibility", "setupRetryClickListener", "showContent", "showEmpty", "showLoading", "showRetry", "startAnimation", "Companion", "OnInflateListener", "OnRetryClickListener", "ViewType", "kotlin_release"}, k = 1, mv = {1, 1, 16})
public final class StateView extends View {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int EMPTY = 0;
    public static final int LOADING = 2;
    public static final int RETRY = 1;
    private static final String TAG;
    private HashMap _$_findViewCache;
    private final ArraySet<Integer> addSet;
    private com.github.nukc.stateview.AnimatorProvider animatorProvider;
    private int emptyResource;
    private View emptyView;
    private LayoutInflater inflater;
    private int loadingResource;
    private View loadingView;
    private OnInflateListener onInflateListener;
    private OnRetryClickListener onRetryClickListener;
    private int retryResource;
    private View retryView;

    /* JADX INFO: compiled from: StateView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/github/nukc/stateview/StateView$OnInflateListener;", "", "onInflate", "", "viewType", "", "view", "Landroid/view/View;", "kotlin_release"}, k = 1, mv = {1, 1, 16})
    public interface OnInflateListener {
        void onInflate(int viewType, View view);
    }

    /* JADX INFO: compiled from: StateView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/github/nukc/stateview/StateView$OnRetryClickListener;", "", "onRetryClick", "", "kotlin_release"}, k = 1, mv = {1, 1, 16})
    public interface OnRetryClickListener {
        void onRetryClick();
    }

    /* JADX INFO: compiled from: StateView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/github/nukc/stateview/StateView$ViewType;", "", "kotlin_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ViewType {
    }

    @JvmStatic
    public static final StateView inject(Activity activity) {
        return INSTANCE.inject(activity);
    }

    @JvmStatic
    public static final StateView inject(View view) {
        return INSTANCE.inject(view);
    }

    @JvmStatic
    public static final StateView inject(ViewGroup viewGroup) {
        return INSTANCE.inject(viewGroup);
    }

    @JvmStatic
    public static final StateView wrap(View view) {
        return INSTANCE.wrap(view);
    }

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

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public final int getEmptyResource() {
        return this.emptyResource;
    }

    public final void setEmptyResource(int i) {
        this.emptyResource = i;
    }

    public final int getRetryResource() {
        return this.retryResource;
    }

    public final void setRetryResource(int i) {
        this.retryResource = i;
    }

    public final int getLoadingResource() {
        return this.loadingResource;
    }

    public final void setLoadingResource(int i) {
        this.loadingResource = i;
    }

    public final View getEmptyView() {
        return this.emptyView;
    }

    public final void setEmptyView(View view) {
        setView(0, view);
        this.emptyView = view;
    }

    public final View getRetryView() {
        return this.retryView;
    }

    public final void setRetryView(View view) {
        setView(1, view);
        this.retryView = view;
        setupRetryClickListener();
    }

    public final View getLoadingView() {
        return this.loadingView;
    }

    public final void setLoadingView(View view) {
        setView(2, view);
        this.loadingView = view;
    }

    public final LayoutInflater getInflater() {
        return this.inflater;
    }

    public final void setInflater(LayoutInflater layoutInflater) {
        this.inflater = layoutInflater;
    }

    public final OnRetryClickListener getOnRetryClickListener() {
        return this.onRetryClickListener;
    }

    public final void setOnRetryClickListener(OnRetryClickListener onRetryClickListener) {
        this.onRetryClickListener = onRetryClickListener;
    }

    public final OnInflateListener getOnInflateListener() {
        return this.onInflateListener;
    }

    public final void setOnInflateListener(OnInflateListener onInflateListener) {
        this.onInflateListener = onInflateListener;
    }

    public final AnimatorProvider getAnimatorProvider() {
        return this.animatorProvider;
    }

    public final void setAnimatorProvider(AnimatorProvider animatorProvider) {
        this.animatorProvider = animatorProvider;
        reset(this.emptyView);
        reset(this.loadingView);
        reset(this.retryView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateView(Context context) {
        this(context, null);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.addSet = new ArraySet<>();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StateView);
        this.emptyResource = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateView_emptyResource, 0);
        this.retryResource = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateView_retryResource, 0);
        this.loadingResource = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateView_loadingResource, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (this.emptyResource == 0) {
            this.emptyResource = R.layout.base_empty;
        }
        if (this.retryResource == 0) {
            this.retryResource = R.layout.base_retry;
        }
        if (this.loadingResource == 0) {
            this.loadingResource = R.layout.base_loading;
        }
        setVisibility(View.GONE);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        setVisibility(this.emptyView, visibility);
        setVisibility(this.retryView, visibility);
        setVisibility(this.loadingView, visibility);
    }

    private final void setVisibility(View view, int visibility) {
        if (view == null || visibility == view.getVisibility()) {
            return;
        }
        if (this.animatorProvider != null) {
            startAnimation(view);
        } else {
            view.setVisibility(visibility);
        }
    }

    public final void showContent() {
        setVisibility(View.GONE);
    }

    public final View showEmpty() {
        return showView(0);
    }

    public final View showRetry() {
        return showView(1);
    }

    public final View showLoading() {
        return showView(2);
    }

    private final View showView(int viewType) {
        View viewInflate;
        int i;
        if (viewType == 0) {
            viewInflate = this.emptyView;
        } else if (viewType == 1) {
            viewInflate = this.retryView;
        } else if (viewType == 2) {
            viewInflate = this.loadingView;
        } else {
            throw new IllegalArgumentException("Invalid viewType: " + viewType);
        }
        if (viewInflate == null) {
            if (viewType == 0) {
                i = this.emptyResource;
            } else if (viewType == 1) {
                i = this.retryResource;
            } else {
                i = viewType != 2 ? -1 : this.loadingResource;
            }
            viewInflate = inflate(i, viewType);
            if (viewType == 0) {
                setEmptyView(viewInflate);
            } else if (viewType == 1) {
                setRetryView(viewInflate);
            } else if (viewType == 2) {
                setLoadingView(viewInflate);
            }
        } else if (this.addSet.contains(Integer.valueOf(viewType))) {
            ViewParent parent = getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            addToParent(viewType, (ViewGroup) parent, viewInflate);
        }
        setVisibility(viewInflate, 0);
        hideViews(viewInflate);
        return viewInflate;
    }

    private final void hideViews(View showView) {
        View view = this.emptyView;
        if (view == showView) {
            setVisibility(this.loadingView, 8);
            setVisibility(this.retryView, 8);
        } else if (this.loadingView == showView) {
            setVisibility(view, 8);
            setVisibility(this.retryView, 8);
        } else {
            setVisibility(view, 8);
            setVisibility(this.loadingView, 8);
        }
    }

    private final void startAnimation(final View view) {
        Animator animatorHideAnimation;
        final boolean z = view.getVisibility() == View.GONE;
        AnimatorProvider animatorProvider = this.animatorProvider;
        if (z) {
            if (animatorProvider == null) {
                Intrinsics.throwNpe();
            }
            animatorHideAnimation = animatorProvider.showAnimation(view);
        } else {
            if (animatorProvider == null) {
                Intrinsics.throwNpe();
            }
            animatorHideAnimation = animatorProvider.hideAnimation(view);
        }
        if (animatorHideAnimation == null) {
            view.setVisibility(z ? View.VISIBLE : View.GONE);
        } else {
            animatorHideAnimation.addListener(new AnimatorListenerAdapter() { // from class: com.github.nukc.stateview.StateView.startAnimation.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkParameterIsNotNull(animation, "animation");
                    super.onAnimationEnd(animation);
                    if (z) {
                        return;
                    }
                    view.setVisibility(View.GONE);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkParameterIsNotNull(animation, "animation");
                    super.onAnimationStart(animation);
                    if (z) {
                        view.setVisibility(View.VISIBLE);
                    }
                }
            });
            animatorHideAnimation.start();
        }
    }

    private final void reset(View view) {
        if (view != null) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setAlpha(1.0f);
            view.setRotation(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
    }

    private final void setView(int viewType, View view) {
        View view2;
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.indexOfChild(view) > -1) {
                return;
            }
            if (viewType == 0) {
                view2 = this.emptyView;
            } else if (viewType == 1) {
                view2 = this.retryView;
            } else if (viewType == 2) {
                view2 = this.loadingView;
            } else {
                throw new IllegalArgumentException("Invalid viewType: " + viewType);
            }
            if (view2 != null) {
                viewGroup.removeViewInLayout(view2);
            }
            this.addSet.add(Integer.valueOf(viewType));
        }
    }

    private final View inflate(int layoutResource, int viewType) {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("StateView must have a non-null ViewGroup viewParent");
        }
        if (layoutResource != 0) {
            LayoutInflater layoutInflaterFrom = this.inflater;
            if (layoutInflaterFrom == null) {
                layoutInflaterFrom = LayoutInflater.from(getContext());
                Intrinsics.checkExpressionValueIsNotNull(layoutInflaterFrom, "LayoutInflater.from(context)");
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            View view = layoutInflaterFrom.inflate(layoutResource, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            return addToParent(viewType, viewGroup, view);
        }
        throw new IllegalArgumentException("StateView must have a valid layoutResource");
    }

    private final View addToParent(int viewType, ViewGroup viewParent, View view) {
        RelativeLayout.LayoutParams layoutParams;
        this.addSet.remove(Integer.valueOf(viewType));
        StateView stateView = this;
        int iIndexOfChild = viewParent.indexOfChild(stateView);
        view.setClickable(true);
        view.setVisibility(8);
        ViewCompat.setZ(view, ViewCompat.getZ(stateView));
        if (getLayoutParams() != null) {
            if (viewParent instanceof RelativeLayout) {
                if (Build.VERSION.SDK_INT >= 19) {
                    ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                    if (layoutParams2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    }
                    layoutParams = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams) layoutParams2);
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(getLayoutParams());
                }
                viewParent.addView(view, iIndexOfChild, layoutParams);
            } else if (Injector.INSTANCE.getConstraintLayoutAvailable() && (viewParent instanceof ConstraintLayout)) {
                ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
                if (layoutParams3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
                if (layoutParams5 != null) {
                    ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(layoutParams5);
                    layoutParams6.leftToLeft = layoutParams4.leftToLeft;
                    layoutParams6.rightToRight = layoutParams4.rightToRight;
                    layoutParams6.topToTop = layoutParams4.topToTop;
                    layoutParams6.bottomToBottom = layoutParams4.bottomToBottom;
                    viewParent.addView(view, iIndexOfChild, layoutParams6);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            } else {
                viewParent.addView(view, iIndexOfChild, getLayoutParams());
            }
        } else {
            viewParent.addView(view, iIndexOfChild);
        }
        if (this.loadingView != null && this.retryView != null && this.emptyView != null) {
            viewParent.removeViewInLayout(stateView);
        }
        OnInflateListener onInflateListener = this.onInflateListener;
        if (onInflateListener != null) {
            onInflateListener.onInflate(viewType, view);
        }
        return view;
    }

    private final void setupRetryClickListener() {
        View view = this.retryView;
        if (view != null) {
            view.setOnClickListener(new OnClickListener() { // from class: com.github.nukc.stateview.StateView.setupRetryClickListener.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (StateView.this.getOnRetryClickListener() != null) {
                        StateView.this.showLoading();
                        View retryView = StateView.this.getRetryView();
                        if (retryView == null) {
                            Intrinsics.throwNpe();
                        }
                        retryView.postDelayed(new Runnable() { // from class: com.github.nukc.stateview.StateView.setupRetryClickListener.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                OnRetryClickListener onRetryClickListener = StateView.this.getOnRetryClickListener();
                                if (onRetryClickListener != null) {
                                    onRetryClickListener.onRetryClick();
                                }
                            }
                        }, 400L);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: StateView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/github/nukc/stateview/StateView$Companion;", "", "()V", "EMPTY", "", "LOADING", "RETRY", "TAG", "", "getTAG$kotlin_release", "()Ljava/lang/String;", "inject", "Lcom/github/nukc/stateview/StateView;", "activity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "wrap", "kotlin_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG$kotlin_release() {
            return StateView.TAG;
        }

        @JvmStatic
        public final StateView inject(Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Window window = activity.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "activity.window");
            View viewFindViewById = window.getDecorView().findViewById(android.R.id.content);
            Intrinsics.checkExpressionValueIsNotNull(viewFindViewById, "activity.window.decorVie…ew>(android.R.id.content)");
            return inject(viewFindViewById);
        }

        @JvmStatic
        public final StateView inject(View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            return view instanceof ViewGroup ? inject((ViewGroup) view) : wrap(view);
        }

        @JvmStatic
        public final StateView inject(ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "viewGroup");
            if ((viewGroup instanceof LinearLayout) || (viewGroup instanceof ScrollView) || (viewGroup instanceof AdapterView) || (((viewGroup instanceof ScrollingView) && (viewGroup instanceof NestedScrollingChild)) || ((viewGroup instanceof NestedScrollingParent) && (viewGroup instanceof NestedScrollingChild)))) {
                if (viewGroup.getParent() instanceof ViewGroup) {
                    return wrap(viewGroup);
                }
                return Injector.INSTANCE.wrapChild(viewGroup);
            }
            Context context = viewGroup.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "viewGroup.context");
            StateView stateView = new StateView(context);
            viewGroup.addView(stateView, -1, -1);
            return stateView;
        }

        @JvmStatic
        public final StateView wrap(View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                if (Injector.INSTANCE.getConstraintLayoutAvailable() && (parent instanceof ConstraintLayout)) {
                    return Injector.INSTANCE.matchViewIfParentIsConstraintLayout((ConstraintLayout) parent, view);
                }
                if (parent instanceof RelativeLayout) {
                    return Injector.INSTANCE.matchViewIfParentIsRelativeLayout((RelativeLayout) parent, view);
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                viewGroup.addView(frameLayout, view.getLayoutParams());
                frameLayout.addView(view, -1, -1);
                Context context = view.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
                StateView stateView = new StateView(context);
                frameLayout.addView(stateView, -1, -1);
                Injector.INSTANCE.setStateListAnimator(stateView, view);
                return stateView;
            }
            throw new ClassCastException("view.getParent() must be ViewGroup");
        }
    }

    static {
        Intrinsics.checkExpressionValueIsNotNull("StateView", "StateView::class.java.simpleName");
        TAG = "StateView";
    }
}
