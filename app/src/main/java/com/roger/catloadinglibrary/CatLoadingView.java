package com.roger.catloadinglibrary;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CatLoadingView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/roger/catloadinglibrary/CatLoadingView;", "Lcom/roger/catloadinglibrary/BaseDialogFragment;", "()V", "background", "Landroid/widget/RelativeLayout;", "color", "", "eyeLeft", "Landroid/view/View;", "eyeLeftAnim", "Landroid/view/animation/Animation;", "eyeRight", "eyeRightAnim", "eyelidLeft", "Lcom/roger/catloadinglibrary/EyelidView;", "eyelidRight", "graduallyTextView", "Lcom/roger/catloadinglibrary/GraduallyTextView;", "mainDialog", "Landroid/app/Dialog;", "mouse", "operatingAnim", "viewText", "", "onCreateDialog", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onPause", "onResume", "setBackgroundColor", "setClickCancelAble", "flag", "", "setText", "labelText", "catloadinglibrary_release"}, k = 1, mv = {1, 4, 1})
public final class CatLoadingView extends BaseDialogFragment {
    private HashMap _$_findViewCache;
    private RelativeLayout background;
    private int color;
    private View eyeLeft;
    private Animation eyeLeftAnim;
    private View eyeRight;
    private Animation eyeRightAnim;
    private EyelidView eyelidLeft;
    private EyelidView eyelidRight;
    private GraduallyTextView graduallyTextView;
    private Dialog mainDialog;
    private View mouse;
    private Animation operatingAnim;
    private String viewText;

    @Override // com.roger.catloadinglibrary.BaseDialogFragment
    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.roger.catloadinglibrary.BaseDialogFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public static final /* synthetic */ EyelidView access$getEyelidLeft$p(CatLoadingView catLoadingView) {
        EyelidView eyelidView = catLoadingView.eyelidLeft;
        if (eyelidView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyelidLeft");
        }
        return eyelidView;
    }

    public static final /* synthetic */ EyelidView access$getEyelidRight$p(CatLoadingView catLoadingView) {
        EyelidView eyelidView = catLoadingView.eyelidRight;
        if (eyelidView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyelidRight");
        }
        return eyelidView;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Window window;
        View view;
        Dialog dialog = new Dialog(requireActivity(), R.style.cart_dialog);
        dialog.setContentView(R.layout.catloading_main);
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setGravity(17);
        }
        Unit unit = Unit.INSTANCE;
        this.mainDialog = dialog;
        RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.operatingAnim = rotateAnimation;
        rotateAnimation.setRepeatCount(-1);
        Animation animation = this.operatingAnim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatingAnim");
        }
        animation.setDuration(2000L);
        RotateAnimation rotateAnimation2 = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.eyeLeftAnim = rotateAnimation2;
        rotateAnimation2.setRepeatCount(-1);
        Animation animation2 = this.eyeLeftAnim;
        if (animation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeLeftAnim");
        }
        animation2.setDuration(2000L);
        RotateAnimation rotateAnimation3 = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.eyeRightAnim = rotateAnimation3;
        rotateAnimation3.setRepeatCount(-1);
        Animation animation3 = this.eyeRightAnim;
        if (animation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeRightAnim");
        }
        animation3.setDuration(2000L);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        Animation animation4 = this.operatingAnim;
        if (animation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatingAnim");
        }
        LinearInterpolator linearInterpolator2 = linearInterpolator;
        animation4.setInterpolator(linearInterpolator2);
        Animation animation5 = this.eyeLeftAnim;
        if (animation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeLeftAnim");
        }
        animation5.setInterpolator(linearInterpolator2);
        Animation animation6 = this.eyeRightAnim;
        if (animation6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeRightAnim");
        }
        animation6.setInterpolator(linearInterpolator2);
        Dialog dialog2 = this.mainDialog;
        if (dialog2 != null && (window = dialog2.getWindow()) != null && (view = window.getDecorView()) != null) {
            View viewFindViewById = view.findViewById(R.id.background);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.background)");
            this.background = (RelativeLayout) viewFindViewById;
            if (this.color != 0) {
                Intrinsics.checkNotNullExpressionValue(view, "view");
                Drawable drawable = AppCompatResources.getDrawable(view.getContext(), R.drawable.background);
                if (drawable != null) {
                    Drawable drawableWrap = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTint(drawableWrap, ContextCompat.getColor(view.getContext(), this.color));
                    RelativeLayout relativeLayout = this.background;
                    if (relativeLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("background");
                    }
                    relativeLayout.setBackground(drawableWrap);
                }
            }
            View viewFindViewById2 = view.findViewById(R.id.mouse);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.mouse)");
            this.mouse = viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.eye_left);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.eye_left)");
            this.eyeLeft = viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.eye_right);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.eye_right)");
            this.eyeRight = viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.eyelid_left);
            Objects.requireNonNull(viewFindViewById5, "null cannot be cast to non-null type com.roger.catloadinglibrary.EyelidView");
            EyelidView eyelidView = (EyelidView) viewFindViewById5;
            this.eyelidLeft = eyelidView;
            if (eyelidView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eyelidLeft");
            }
            eyelidView.setColor(ContextCompat.getColor(requireContext(), R.color.eyelid));
            EyelidView eyelidView2 = this.eyelidLeft;
            if (eyelidView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eyelidLeft");
            }
            eyelidView2.setFromFull(true);
            View viewFindViewById6 = view.findViewById(R.id.eyelid_right);
            Objects.requireNonNull(viewFindViewById6, "null cannot be cast to non-null type com.roger.catloadinglibrary.EyelidView");
            EyelidView eyelidView3 = (EyelidView) viewFindViewById6;
            this.eyelidRight = eyelidView3;
            if (eyelidView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eyelidRight");
            }
            eyelidView3.setColor(ContextCompat.getColor(requireContext(), R.color.eyelid));
            EyelidView eyelidView4 = this.eyelidRight;
            if (eyelidView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eyelidRight");
            }
            eyelidView4.setFromFull(true);
            View viewFindViewById7 = view.findViewById(R.id.graduallyTextView);
            Objects.requireNonNull(viewFindViewById7, "null cannot be cast to non-null type com.roger.catloadinglibrary.GraduallyTextView");
            this.graduallyTextView = (GraduallyTextView) viewFindViewById7;
            if (!TextUtils.isEmpty(this.viewText)) {
                GraduallyTextView graduallyTextView = this.graduallyTextView;
                if (graduallyTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graduallyTextView");
                }
                graduallyTextView.setText(this.viewText);
            }
            Animation animation7 = this.operatingAnim;
            if (animation7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operatingAnim");
            }
            animation7.setAnimationListener(new Animation.AnimationListener() { // from class: com.roger.catloadinglibrary.CatLoadingView$onCreateDialog$$inlined$let$lambda$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation8) {
                    Intrinsics.checkNotNullParameter(animation8, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation8) {
                    Intrinsics.checkNotNullParameter(animation8, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation8) {
                    Intrinsics.checkNotNullParameter(animation8, "animation");
                    CatLoadingView.access$getEyelidLeft$p(this.this$0).resetAnimator();
                    CatLoadingView.access$getEyelidRight$p(this.this$0).resetAnimator();
                }
            });
        }
        Dialog dialog3 = this.mainDialog;
        Intrinsics.checkNotNull(dialog3);
        return dialog3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        View view = this.mouse;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mouse");
        }
        Animation animation = this.operatingAnim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatingAnim");
        }
        view.setAnimation(animation);
        View view2 = this.eyeLeft;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeLeft");
        }
        Animation animation2 = this.eyeLeftAnim;
        if (animation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeLeftAnim");
        }
        view2.setAnimation(animation2);
        View view3 = this.eyeRight;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeRight");
        }
        Animation animation3 = this.eyeRightAnim;
        if (animation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeRightAnim");
        }
        view3.setAnimation(animation3);
        EyelidView eyelidView = this.eyelidLeft;
        if (eyelidView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyelidLeft");
        }
        eyelidView.startLoading();
        EyelidView eyelidView2 = this.eyelidRight;
        if (eyelidView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyelidRight");
        }
        eyelidView2.startLoading();
        GraduallyTextView graduallyTextView = this.graduallyTextView;
        if (graduallyTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graduallyTextView");
        }
        graduallyTextView.startLoading();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        View view = this.mouse;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mouse");
        }
        view.clearAnimation();
        View view2 = this.eyeLeft;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeLeft");
        }
        view2.clearAnimation();
        View view3 = this.eyeRight;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyeRight");
        }
        view3.clearAnimation();
        EyelidView eyelidView = this.eyelidLeft;
        if (eyelidView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyelidLeft");
        }
        eyelidView.stopLoading();
        EyelidView eyelidView2 = this.eyelidRight;
        if (eyelidView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eyelidRight");
        }
        eyelidView2.stopLoading();
        GraduallyTextView graduallyTextView = this.graduallyTextView;
        if (graduallyTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graduallyTextView");
        }
        graduallyTextView.stopLoading();
        super.onPause();
    }

    @Override // com.roger.catloadinglibrary.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = this.mainDialog;
        if (dialog != null && dialog.isShowing()) {
            Dialog dialog2 = this.mainDialog;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            this.mainDialog = (Dialog) null;
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setText(String labelText) {
        this.viewText = labelText;
    }

    public final void setClickCancelAble(boolean flag) {
        setCancelable(flag);
    }

    public final void setBackgroundColor(int color) {
        this.color = color;
    }
}
