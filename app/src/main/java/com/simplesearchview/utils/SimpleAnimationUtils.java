package com.simplesearchview.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleAnimationUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002#$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J&\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0018J\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\"\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\"\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J,\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J$\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\"\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J2\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\"\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\"\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J,\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J$\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J\"\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J2\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0007J,\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J4\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006%"}, d2 = {"Lcom/ferfalk/simplesearchview/utils/SimpleAnimationUtils;", "", "()V", "ANIMATION_DURATION_DEFAULT", "", "defaultInterpolator", "Landroid/view/animation/Interpolator;", "getDefaultInterpolator$simplesearchview_release$annotations", "getDefaultInterpolator$simplesearchview_release", "()Landroid/view/animation/Interpolator;", "distance", "", "first", "Landroid/graphics/Point;", "second", "fadeIn", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "listener", "Lcom/ferfalk/simplesearchview/utils/SimpleAnimationUtils$AnimationListener;", "duration", "fadeOut", "getDefaultCenter", "getDefaultCenter$simplesearchview_release", "getRevealRadius", "center", "getRevealRadius$simplesearchview_release", "hide", "hideOrFadeOut", "reveal", "revealOrFadeIn", "verticalSlideView", "fromHeight", "toHeight", "AnimationListener", "DefaultActionAnimationListener", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
public final class SimpleAnimationUtils {
    public static final int ANIMATION_DURATION_DEFAULT = 250;
    public static final SimpleAnimationUtils INSTANCE = new SimpleAnimationUtils();

    /* JADX INFO: compiled from: SimpleAnimationUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ferfalk/simplesearchview/utils/SimpleAnimationUtils$AnimationListener;", "", "onAnimationCancel", "", "view", "Landroid/view/View;", "onAnimationEnd", "onAnimationStart", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
    public interface AnimationListener {
        boolean onAnimationCancel(View view);

        boolean onAnimationEnd(View view);

        boolean onAnimationStart(View view);
    }

    @JvmStatic
    public static final Animator fadeIn(View view) {
        return fadeIn$default(view, 0, null, 6, null);
    }

    @JvmStatic
    public static final Animator fadeIn(View view, int i) {
        return fadeIn$default(view, i, null, 4, null);
    }

    @JvmStatic
    public static final Animator fadeOut(View view) {
        return fadeOut$default(view, 0, null, 6, null);
    }

    @JvmStatic
    public static final Animator fadeOut(View view, int i) {
        return fadeOut$default(view, i, null, 4, null);
    }

    @JvmStatic
    public static /* synthetic */ void getDefaultInterpolator$simplesearchview_release$annotations() {
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view) {
        return hideOrFadeOut$default(view, 0, null, null, 14, null);
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view, int i) {
        return hideOrFadeOut$default(view, i, null, null, 12, null);
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view, int i, AnimationListener animationListener) {
        return hideOrFadeOut$default(view, i, animationListener, null, 8, null);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view) {
        return revealOrFadeIn$default(view, 0, null, null, 14, null);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view, int i) {
        return revealOrFadeIn$default(view, i, null, null, 12, null);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view, int i, AnimationListener animationListener) {
        return revealOrFadeIn$default(view, i, animationListener, null, 8, null);
    }

    @JvmStatic
    public static final Animator verticalSlideView(View view, int i, int i2) {
        return verticalSlideView$default(view, i, i2, null, 8, null);
    }

    @JvmStatic
    public static final Animator verticalSlideView(View view, int i, int i2, int i3) {
        return verticalSlideView$default(view, i, i2, i3, null, 16, null);
    }

    private SimpleAnimationUtils() {
    }

    public static /* synthetic */ Animator revealOrFadeIn$default(View view, int i, AnimationListener animationListener, Point point, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 250;
        }
        if ((i2 & 4) != 0) {
            animationListener = (AnimationListener) null;
        }
        if ((i2 & 8) != 0) {
            point = (Point) null;
        }
        return revealOrFadeIn(view, i, animationListener, point);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view, int duration, AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 21) {
            return reveal(view, duration, listener, center);
        }
        return fadeIn(view, duration, listener);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view, int duration, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return revealOrFadeIn(view, duration, null, center);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return revealOrFadeIn(view, 250, listener, null);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return revealOrFadeIn(view, 250, null, center);
    }

    @JvmStatic
    public static final Animator revealOrFadeIn(View view, AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return revealOrFadeIn(view, 250, listener, center);
    }

    public static /* synthetic */ Animator hideOrFadeOut$default(View view, int i, AnimationListener animationListener, Point point, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 250;
        }
        if ((i2 & 4) != 0) {
            animationListener = (AnimationListener) null;
        }
        if ((i2 & 8) != 0) {
            point = (Point) null;
        }
        return hideOrFadeOut(view, i, animationListener, point);
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view, int duration, AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 21) {
            return hide(view, duration, listener, center);
        }
        return fadeOut(view, duration, listener);
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view, int duration, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hideOrFadeOut(view, duration, null, center);
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hideOrFadeOut(view, 250, listener, null);
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hideOrFadeOut(view, 250, null, center);
    }

    @JvmStatic
    public static final Animator hideOrFadeOut(View view, AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hideOrFadeOut(view, 250, listener, center);
    }

    @JvmStatic
    public static final Animator reveal(View view, int duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        return reveal(view, duration, null, null);
    }

    @JvmStatic
    public static final Animator reveal(View view, int duration, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return reveal(view, duration, null, center);
    }

    @JvmStatic
    public static final Animator reveal(View view, int duration, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return reveal(view, duration, listener, null);
    }

    @JvmStatic
    public static final Animator reveal(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return reveal(view, 250);
    }

    @JvmStatic
    public static final Animator reveal(View view, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return reveal(view, 250, listener, null);
    }

    @JvmStatic
    public static final Animator reveal(View view, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return reveal(view, 250, null, center);
    }

    @JvmStatic
    public static final Animator reveal(View view, AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return reveal(view, 250, listener, center);
    }

    @JvmStatic
    public static final Animator reveal(final View view, int duration, final AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (center == null) {
            center = getDefaultCenter$simplesearchview_release(view);
        }
        Animator anim = ViewAnimationUtils.createCircularReveal(view, center.x, center.y, 0.0f, getRevealRadius$simplesearchview_release(center, view));
        anim.addListener(new DefaultActionAnimationListener(view, listener) { // from class: com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.reveal.1
            @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.DefaultActionAnimationListener
            public void defaultOnAnimationStart(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                view2.setVisibility(0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setDuration(duration);
        anim.setInterpolator(getDefaultInterpolator$simplesearchview_release());
        return anim;
    }

    @JvmStatic
    public static final Animator hide(View view, int duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hide(view, duration, null, null);
    }

    @JvmStatic
    public static final Animator hide(View view, int duration, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hide(view, duration, null, center);
    }

    @JvmStatic
    public static final Animator hide(View view, int duration, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hide(view, duration, listener, null);
    }

    @JvmStatic
    public static final Animator hide(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hide(view, 250);
    }

    @JvmStatic
    public static final Animator hide(View view, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hide(view, 250, listener, null);
    }

    @JvmStatic
    public static final Animator hide(View view, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hide(view, 250, null, center);
    }

    @JvmStatic
    public static final Animator hide(View view, AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        return hide(view, 250, listener, center);
    }

    @JvmStatic
    public static final Animator hide(final View view, int duration, final AnimationListener listener, Point center) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (center == null) {
            center = getDefaultCenter$simplesearchview_release(view);
        }
        Animator anim = ViewAnimationUtils.createCircularReveal(view, center.x, center.y, getRevealRadius$simplesearchview_release(center, view), 0.0f);
        anim.addListener(new DefaultActionAnimationListener(view, listener) { // from class: com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.hide.1
            @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.DefaultActionAnimationListener
            public void defaultOnAnimationEnd(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                view2.setVisibility(8);
            }
        });
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setDuration(duration);
        anim.setInterpolator(getDefaultInterpolator$simplesearchview_release());
        return anim;
    }

    @JvmStatic
    public static final Point getDefaultCenter$simplesearchview_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new Point(view.getWidth() / 2, view.getHeight() / 2);
    }

    @JvmStatic
    public static final int getRevealRadius$simplesearchview_release(Point center, View view) {
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Point(view.getLeft(), view.getTop()));
        arrayList.add(new Point(view.getRight(), view.getTop()));
        arrayList.add(new Point(view.getLeft(), view.getBottom()));
        arrayList.add(new Point(view.getRight(), view.getBottom()));
        Iterator it = arrayList.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            float fDistance = distance(center, (Point) it.next());
            if (fDistance > f) {
                f = fDistance;
            }
        }
        return (int) Math.ceil(f);
    }

    @JvmStatic
    public static final float distance(Point first, Point second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        return (float) Math.sqrt(Math.pow(((double) first.x) - ((double) second.x), 2.0d) + Math.pow(((double) first.y) - ((double) second.y), 2.0d));
    }

    @JvmStatic
    public static final Animator fadeIn(View view, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return fadeIn(view, 250, listener);
    }

    public static /* synthetic */ Animator fadeIn$default(View view, int i, AnimationListener animationListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 250;
        }
        if ((i2 & 4) != 0) {
            animationListener = (AnimationListener) null;
        }
        return fadeIn(view, i, animationListener);
    }

    @JvmStatic
    public static final Animator fadeIn(final View view, int duration, final AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getAlpha() == 1.0f) {
            view.setAlpha(0.0f);
        }
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        anim.addListener(new DefaultActionAnimationListener(view, listener) { // from class: com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.fadeIn.1
            @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.DefaultActionAnimationListener
            public void defaultOnAnimationStart(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                view2.setVisibility(0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setDuration(duration);
        anim.setInterpolator(getDefaultInterpolator$simplesearchview_release());
        return anim;
    }

    @JvmStatic
    public static final Animator fadeOut(View view, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return fadeOut(view, 250, listener);
    }

    public static /* synthetic */ Animator fadeOut$default(View view, int i, AnimationListener animationListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 250;
        }
        if ((i2 & 4) != 0) {
            animationListener = (AnimationListener) null;
        }
        return fadeOut(view, i, animationListener);
    }

    @JvmStatic
    public static final Animator fadeOut(final View view, int duration, final AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        anim.addListener(new DefaultActionAnimationListener(view, listener) { // from class: com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.fadeOut.1
            @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.DefaultActionAnimationListener
            public void defaultOnAnimationEnd(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                view2.setVisibility(8);
            }
        });
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setDuration(duration);
        anim.setInterpolator(getDefaultInterpolator$simplesearchview_release());
        return anim;
    }

    public static /* synthetic */ Animator verticalSlideView$default(View view, int i, int i2, AnimationListener animationListener, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            animationListener = (AnimationListener) null;
        }
        return verticalSlideView(view, i, i2, animationListener);
    }

    @JvmStatic
    public static final Animator verticalSlideView(View view, int fromHeight, int toHeight, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        return verticalSlideView(view, fromHeight, toHeight, 250, listener);
    }

    public static /* synthetic */ Animator verticalSlideView$default(View view, int i, int i2, int i3, AnimationListener animationListener, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            animationListener = (AnimationListener) null;
        }
        return verticalSlideView(view, i, i2, i3, animationListener);
    }

    @JvmStatic
    public static final Animator verticalSlideView(final View view, int fromHeight, int toHeight, int duration, AnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        ValueAnimator anim = ValueAnimator.ofInt(fromHeight, toHeight);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.verticalSlideView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Object animatedValue = animation.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                layoutParams.height = ((Integer) animatedValue).intValue();
                view.requestLayout();
            }
        });
        anim.addListener(new DefaultActionAnimationListener(view, listener));
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setDuration(duration);
        anim.setInterpolator(getDefaultInterpolator$simplesearchview_release());
        return anim;
    }

    public static final Interpolator getDefaultInterpolator$simplesearchview_release() {
        return new FastOutSlowInInterpolator();
    }

    /* JADX INFO: compiled from: SimpleAnimationUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ferfalk/simplesearchview/utils/SimpleAnimationUtils$DefaultActionAnimationListener;", "Landroid/animation/AnimatorListenerAdapter;", "view", "Landroid/view/View;", "listener", "Lcom/ferfalk/simplesearchview/utils/SimpleAnimationUtils$AnimationListener;", "(Landroid/view/View;Lcom/ferfalk/simplesearchview/utils/SimpleAnimationUtils$AnimationListener;)V", "defaultOnAnimationCancel", "", "defaultOnAnimationEnd", "defaultOnAnimationStart", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
    private static class DefaultActionAnimationListener extends AnimatorListenerAdapter {
        private final AnimationListener listener;
        private final View view;

        public final void defaultOnAnimationCancel(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public void defaultOnAnimationEnd(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public void defaultOnAnimationStart(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public DefaultActionAnimationListener(View view, AnimationListener animationListener) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.listener = animationListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimationListener animationListener = this.listener;
            if (animationListener == null || !animationListener.onAnimationStart(this.view)) {
                defaultOnAnimationStart(this.view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimationListener animationListener = this.listener;
            if (animationListener == null || !animationListener.onAnimationEnd(this.view)) {
                defaultOnAnimationEnd(this.view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimationListener animationListener = this.listener;
            if (animationListener == null || !animationListener.onAnimationCancel(this.view)) {
                defaultOnAnimationCancel(this.view);
            }
        }
    }
}
