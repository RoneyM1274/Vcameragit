package com.simplesearchview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

import com.ferfalk.simplesearchview.SimpleOnTabSelectedListener;
import com.ferfalk.simplesearchview.SimpleTextWatcher;
import com.ferfalk.simplesearchview.databinding.SearchViewBinding;
import com.ferfalk.simplesearchview.utils.ContextUtils;
import com.ferfalk.simplesearchview.utils.DimensUtils;
import com.ferfalk.simplesearchview.utils.EditTextReflectionUtils;
import com.ferfalk.simplesearchview.utils.SimpleAnimationListener;
import com.ferfalk.simplesearchview.utils.SimpleAnimationUtils;
import com.google.android.material.tabs.TabLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleSearchView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 |2\u00020\u0001:\u0006|}~\u007f\u0080\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00108\u001a\u000209H\u0016J\u000f\u0010:\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010;J\u0019\u0010<\u001a\u0004\u0018\u0001092\b\b\u0002\u0010=\u001a\u00020\nH\u0007¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\nJ\u0012\u0010A\u001a\u0002092\b\b\u0002\u0010=\u001a\u00020\nH\u0007J\b\u0010B\u001a\u000209H\u0002J\b\u0010C\u001a\u000209H\u0002J\u001a\u0010D\u001a\u0002092\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J*\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020\nH\u0007J\u0006\u0010K\u001a\u00020\nJ\u0010\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020NH\u0016J\b\u0010P\u001a\u000209H\u0002J\u0010\u0010Q\u001a\u0002092\u0006\u0010R\u001a\u00020!H\u0002J\u001a\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u00072\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u000e\u0010W\u001a\u0002092\u0006\u0010X\u001a\u00020YJ\u0010\u0010Z\u001a\u0002092\b\b\u0001\u0010[\u001a\u00020\u0007J\u0010\u0010\\\u001a\u0002092\b\u0010]\u001a\u0004\u0018\u00010^J\u0010\u0010_\u001a\u0002092\b\u0010]\u001a\u0004\u0018\u00010^J\u0010\u0010`\u001a\u0002092\b\b\u0001\u0010[\u001a\u00020\u0007J\u0010\u0010a\u001a\u0002092\b\b\u0001\u0010]\u001a\u00020\u0007J\u0010\u0010b\u001a\u0002092\b\u0010c\u001a\u0004\u0018\u00010!J\u0010\u0010d\u001a\u0002092\b\b\u0001\u0010[\u001a\u00020\u0007J\u000e\u0010e\u001a\u0002092\u0006\u0010X\u001a\u00020YJ\u0010\u0010f\u001a\u0002092\b\b\u0001\u0010[\u001a\u00020\u0007J\u000e\u0010g\u001a\u0002092\u0006\u0010h\u001a\u00020\u0007J\u000e\u0010i\u001a\u0002092\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010j\u001a\u0002092\u0006\u0010k\u001a\u00020lJ\u0010\u0010m\u001a\u0002092\b\u0010n\u001a\u0004\u0018\u00010#J\u0010\u0010o\u001a\u0002092\b\u0010n\u001a\u0004\u0018\u00010-J\u0018\u0010p\u001a\u0002092\b\u0010q\u001a\u0004\u0018\u00010!2\u0006\u0010J\u001a\u00020\nJ\u0010\u0010r\u001a\u0002092\b\u0010s\u001a\u0004\u0018\u00010^J\u000e\u0010t\u001a\u0002092\u0006\u00102\u001a\u000201J\u0010\u0010u\u001a\u0002092\b\b\u0001\u0010[\u001a\u00020\u0007J\u0010\u0010v\u001a\u0002092\b\u0010]\u001a\u0004\u0018\u00010^J\u0010\u0010w\u001a\u0002092\b\u00106\u001a\u0004\u0018\u000107J\u0019\u0010x\u001a\u0004\u0018\u0001092\b\b\u0002\u0010=\u001a\u00020\nH\u0007¢\u0006\u0002\u0010>J\u0012\u0010y\u001a\u0002092\b\b\u0002\u0010=\u001a\u00020\nH\u0007J\u000e\u0010z\u001a\u0002092\u0006\u0010{\u001a\u00020\nJ\b\u0010@\u001a\u000209H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b/\u00100R\"\u00102\u001a\u0004\u0018\u0001012\b\u0010\u001b\u001a\u0004\u0018\u000101@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, d2 = {"Lcom/ferfalk/simplesearchview/SimpleSearchView;", "Landroid/widget/FrameLayout;", "creationContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowVoiceSearch", "", "animationDuration", "getAnimationDuration", "()I", "setAnimationDuration", "(I)V", "binding", "Lcom/ferfalk/simplesearchview/databinding/SearchViewBinding;", "value", "cardStyle", "getCardStyle", "setCardStyle", "cardStyleBackground", "Landroid/graphics/drawable/GradientDrawable;", "getCardStyleBackground", "()Landroid/graphics/drawable/GradientDrawable;", "isClearingFocus", "<set-?>", "isSearchOpen", "()Z", "isVoiceAvailable", "keepQuery", "oldQuery", "", "onQueryChangeListener", "Lcom/ferfalk/simplesearchview/SimpleSearchView$OnQueryTextListener;", "query", "revealAnimationCenter", "Landroid/graphics/Point;", "getRevealAnimationCenter", "()Landroid/graphics/Point;", "setRevealAnimationCenter", "(Landroid/graphics/Point;)V", "searchIsClosing", "searchViewListener", "Lcom/ferfalk/simplesearchview/SimpleSearchView$SearchViewListener;", "style", "getStyle$annotations", "()V", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "tabLayoutInitialHeight", "voiceSearchPrompt", "", "clearFocus", "", "clearSearch", "()Ljava/lang/Boolean;", "closeSearch", "animate", "(Z)Lkotlin/Unit;", "enableVoiceSearch", "voiceSearch", "hideTabLayout", "initClickListeners", "initSearchEditText", "initStyle", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "submit", "onBackPressed", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onSubmitQuery", "onTextChanged", "newText", "requestFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "setBackIconAlpha", "alpha", "", "setBackIconColor", "color", "setBackIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setClearIconDrawable", "setCursorColor", "setCursorDrawable", "setHint", "hint", "setHintTextColor", "setIconsAlpha", "setIconsColor", "setInputType", "inputType", "setKeepQuery", "setMenuItem", "menuItem", "Landroid/view/MenuItem;", "setOnQueryTextListener", "listener", "setOnSearchViewListener", "setQuery", "sequence", "setSearchBackground", "background", "setTabLayout", "setTextColor", "setVoiceIconDrawable", "setVoiceSearchPrompt", "showSearch", "showTabLayout", "showVoice", "show", "Companion", "OnQueryTextListener", "SavedState", "SearchViewListener", "Style", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
public final class SimpleSearchView extends FrameLayout {
    public static final int ANIMATION_CENTER_PADDING = 26;
    private static final float BACK_ICON_ALPHA_DEFAULT = 0.87f;
    public static final int CARD_CORNER_RADIUS = 4;
    private static final int CARD_ELEVATION = 2;
    private static final int CARD_PADDING = 6;
    private static final float ICONS_ALPHA_DEFAULT = 0.54f;
    public static final int REQUEST_VOICE_SEARCH = 735;
    public static final int STYLE_BAR = 0;
    public static final int STYLE_CARD = 1;
    private boolean allowVoiceSearch;
    private int animationDuration;
    private final SearchViewBinding binding;
    private boolean isClearingFocus;
    private boolean isSearchOpen;
    private boolean keepQuery;
    private CharSequence oldQuery;
    private OnQueryTextListener onQueryChangeListener;
    private CharSequence query;
    private Point revealAnimationCenter;
    private boolean searchIsClosing;
    private SearchViewListener searchViewListener;
    private int style;
    private TabLayout tabLayout;
    private int tabLayoutInitialHeight;
    private String voiceSearchPrompt;

    /* JADX INFO: compiled from: SimpleSearchView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/ferfalk/simplesearchview/SimpleSearchView$OnQueryTextListener;", "", "onQueryTextChange", "", "newText", "", "onQueryTextCleared", "onQueryTextSubmit", "query", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String newText);

        boolean onQueryTextCleared();

        boolean onQueryTextSubmit(String query);
    }

    /* JADX INFO: compiled from: SimpleSearchView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/ferfalk/simplesearchview/SimpleSearchView$SearchViewListener;", "", "onSearchViewClosed", "", "onSearchViewClosedAnimation", "onSearchViewShown", "onSearchViewShownAnimation", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
    public interface SearchViewListener {
        void onSearchViewClosed();

        void onSearchViewClosedAnimation();

        void onSearchViewShown();

        void onSearchViewShownAnimation();
    }

    /* JADX INFO: compiled from: SimpleSearchView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ferfalk/simplesearchview/SimpleSearchView$Style;", "", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Style {
    }

    public SimpleSearchView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SimpleSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private static /* synthetic */ void getStyle$annotations() {
    }

    public final Unit closeSearch() {
        return closeSearch$default(this, false, 1, null);
    }

    public final void hideTabLayout() {
        hideTabLayout$default(this, false, 1, null);
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return onActivityResult$default(this, i, i2, intent, false, 8, null);
    }

    public final Unit showSearch() {
        return showSearch$default(this, false, 1, null);
    }

    public final void showTabLayout() {
        showTabLayout$default(this, false, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleSearchView(Context creationContext, AttributeSet attributeSet, int i) {
        super(creationContext, attributeSet, i);
        Intrinsics.checkNotNullParameter(creationContext, "creationContext");
        this.animationDuration = 250;
        this.voiceSearchPrompt = "";
        SearchViewBinding searchViewBindingInflate = SearchViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(searchViewBindingInflate, "SearchViewBinding.inflat…rom(context), this, true)");
        this.binding = searchViewBindingInflate;
        initStyle(attributeSet, i);
        initSearchEditText();
        initClickListeners();
        showVoice(true);
        if (isInEditMode()) {
            return;
        }
        setVisibility(4);
    }

    public /* synthetic */ SimpleSearchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(int i) {
        this.animationDuration = i;
    }

    public final void setRevealAnimationCenter(Point point) {
        this.revealAnimationCenter = point;
    }

    public final Point getRevealAnimationCenter() {
        Point point = this.revealAnimationCenter;
        if (point != null) {
            return point;
        }
        int width = getWidth();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Point point2 = new Point(width - DimensUtils.convertDpToPx(26, context), getHeight() / 2);
        this.revealAnimationCenter = point2;
        return point2;
    }

    /* JADX INFO: renamed from: isSearchOpen, reason: from getter */
    public final boolean getIsSearchOpen() {
        return this.isSearchOpen;
    }

    public final TabLayout getTabLayout() {
        return this.tabLayout;
    }

    private final void initStyle(AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, com.ferfalk.simplesearchview.R.styleable.SimpleSearchView, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…rchView, defStyleAttr, 0)");
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_type)) {
            setCardStyle(typedArrayObtainStyledAttributes.getInt(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_type, this.style));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_backIconAlpha)) {
            setBackIconAlpha(typedArrayObtainStyledAttributes.getFloat(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_backIconAlpha, BACK_ICON_ALPHA_DEFAULT));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_iconsAlpha)) {
            setIconsAlpha(typedArrayObtainStyledAttributes.getFloat(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_iconsAlpha, 0.54f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_backIconTint)) {
            int i = com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_backIconTint;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setBackIconColor(typedArrayObtainStyledAttributes.getColor(i, ContextUtils.getPrimaryColor(context)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_iconsTint)) {
            setIconsColor(typedArrayObtainStyledAttributes.getColor(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_iconsTint, ViewCompat.MEASURED_STATE_MASK));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_cursorColor)) {
            int i2 = com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_cursorColor;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            setCursorColor(typedArrayObtainStyledAttributes.getColor(i2, ContextUtils.getAccentColor(context2)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_hintColor)) {
            setHintTextColor(typedArrayObtainStyledAttributes.getColor(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_hintColor, ContextCompat.getColor(getContext(), com.ferfalk.simplesearchview.R.color.default_textColorHint)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchBackground)) {
            setSearchBackground(typedArrayObtainStyledAttributes.getDrawable(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchBackground));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchBackIcon)) {
            setBackIconDrawable(typedArrayObtainStyledAttributes.getDrawable(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchBackIcon));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchClearIcon)) {
            setClearIconDrawable(typedArrayObtainStyledAttributes.getDrawable(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchClearIcon));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchVoiceIcon)) {
            setVoiceIconDrawable(typedArrayObtainStyledAttributes.getDrawable(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_searchVoiceIcon));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_voiceSearch)) {
            enableVoiceSearch(typedArrayObtainStyledAttributes.getBoolean(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_voiceSearch, this.allowVoiceSearch));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_voiceSearchPrompt)) {
            setVoiceSearchPrompt(typedArrayObtainStyledAttributes.getString(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_voiceSearchPrompt));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_android_hint)) {
            setHint(typedArrayObtainStyledAttributes.getString(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_android_hint));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_android_inputType)) {
            setInputType(typedArrayObtainStyledAttributes.getInt(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_android_inputType, 524288));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_android_textColor)) {
            setTextColor(typedArrayObtainStyledAttributes.getColor(com.ferfalk.simplesearchview.R.styleable.SimpleSearchView_android_textColor, ContextCompat.getColor(getContext(), com.ferfalk.simplesearchview.R.color.default_textColor)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void initSearchEditText() {
        final SearchViewBinding searchViewBinding = this.binding;
        searchViewBinding.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$initSearchEditText$$inlined$with$lambda$1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                this.this$0.onSubmitQuery();
                return true;
            }
        });
        searchViewBinding.searchEditText.addTextChangedListener(new SimpleTextWatcher() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$initSearchEditText$$inlined$with$lambda$2
            @Override // com.ferfalk.simplesearchview.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.this$0.searchIsClosing) {
                    return;
                }
                this.this$0.onTextChanged(s);
            }
        });
        EditText searchEditText = searchViewBinding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.setOnFocusChangeListener(new OnFocusChangeListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$initSearchEditText$1$3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    EditText searchEditText2 = searchViewBinding.searchEditText;
                    Intrinsics.checkNotNullExpressionValue(searchEditText2, "searchEditText");
                    ContextUtils.showKeyboard(searchEditText2);
                }
            }
        });
    }

    private final void initClickListeners() {
        SearchViewBinding searchViewBinding = this.binding;
        searchViewBinding.backButton.setOnClickListener(new OnClickListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$initClickListeners$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleSearchView.closeSearch$default(this.this$0, false, 1, null);
            }
        });
        searchViewBinding.clearButton.setOnClickListener(new OnClickListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$initClickListeners$$inlined$with$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.clearSearch();
            }
        });
        searchViewBinding.voiceButton.setOnClickListener(new OnClickListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$initClickListeners$$inlined$with$lambda$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.voiceSearch();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        SearchViewBinding searchViewBinding = this.binding;
        this.isClearingFocus = true;
        ContextUtils.hideKeyboard(this);
        super.clearFocus();
        searchViewBinding.searchEditText.clearFocus();
        this.isClearingFocus = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        SearchViewBinding searchViewBinding = this.binding;
        if (!this.isClearingFocus && isFocusable()) {
            return searchViewBinding.searchEditText.requestFocus(direction, previouslyFocusedRect);
        }
        return false;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence charSequence = this.query;
        savedState.setQuery(charSequence != null ? String.valueOf(charSequence) : null);
        savedState.setSearchOpen(this.isSearchOpen);
        savedState.setAnimationDuration(this.animationDuration);
        savedState.setKeepQuery(this.keepQuery);
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        this.query = savedState.getQuery();
        this.animationDuration = savedState.getAnimationDuration();
        this.voiceSearchPrompt = savedState.getVoiceSearchPrompt();
        this.keepQuery = savedState.getKeepQuery();
        if (savedState.getIsSearchOpen()) {
            showSearch(false);
            setQuery(savedState.getQuery(), false);
        }
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void voiceSearch() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityScanForActivity = ContextUtils.scanForActivity(context);
        if (activityScanForActivity != null) {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            String str = this.voiceSearchPrompt;
            if (!(str == null || str.length() == 0)) {
                intent.putExtra("android.speech.extra.PROMPT", this.voiceSearchPrompt);
            }
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
            intent.putExtra("android.speech.extra.MAX_RESULTS", 1);
            activityScanForActivity.startActivityForResult(intent, REQUEST_VOICE_SEARCH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean clearSearch() {
        EditText searchEditText = this.binding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.setText((CharSequence) null);
        OnQueryTextListener onQueryTextListener = this.onQueryChangeListener;
        if (onQueryTextListener != null) {
            return Boolean.valueOf(onQueryTextListener.onQueryTextCleared());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTextChanged(CharSequence newText) {
        OnQueryTextListener onQueryTextListener;
        SearchViewBinding searchViewBinding = this.binding;
        this.query = newText;
        if (!TextUtils.isEmpty(newText)) {
            ImageButton clearButton = searchViewBinding.clearButton;
            Intrinsics.checkNotNullExpressionValue(clearButton, "clearButton");
            clearButton.setVisibility(0);
            showVoice(false);
        } else {
            ImageButton clearButton2 = searchViewBinding.clearButton;
            Intrinsics.checkNotNullExpressionValue(clearButton2, "clearButton");
            clearButton2.setVisibility(8);
            showVoice(true);
        }
        if (!TextUtils.equals(newText, this.oldQuery) && (onQueryTextListener = this.onQueryChangeListener) != null) {
            onQueryTextListener.onQueryTextChange(newText.toString());
        }
        this.oldQuery = newText.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSubmitQuery() {
        SearchViewBinding searchViewBinding = this.binding;
        EditText searchEditText = searchViewBinding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        Editable text = searchEditText.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.onQueryChangeListener;
        if (onQueryTextListener != null) {
            Intrinsics.checkNotNull(onQueryTextListener);
            if (onQueryTextListener.onQueryTextSubmit(text.toString())) {
                return;
            }
        }
        closeSearch$default(this, false, 1, null);
        this.searchIsClosing = true;
        EditText searchEditText2 = searchViewBinding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText2, "searchEditText");
        searchEditText2.setText((CharSequence) null);
        this.searchIsClosing = false;
    }

    private final boolean isVoiceAvailable() {
        if (isInEditMode()) {
            return true;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "pm.queryIntentActivities…ION_RECOGNIZE_SPEECH), 0)");
        return !listQueryIntentActivities.isEmpty();
    }

    public final void setKeepQuery(boolean keepQuery) {
        this.keepQuery = keepQuery;
    }

    public static /* synthetic */ Unit showSearch$default(SimpleSearchView simpleSearchView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return simpleSearchView.showSearch(z);
    }

    public final Unit showSearch(final boolean animate) {
        SearchViewBinding searchViewBinding = this.binding;
        if (this.isSearchOpen) {
            return null;
        }
        searchViewBinding.searchEditText.setText(this.keepQuery ? this.query : null);
        searchViewBinding.searchEditText.requestFocus();
        if (animate) {
            SimpleAnimationUtils.revealOrFadeIn(this, this.animationDuration, new SimpleAnimationListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$showSearch$$inlined$with$lambda$1
                @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationListener, com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.AnimationListener
                public boolean onAnimationEnd(View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    SearchViewListener searchViewListener = this.this$0.searchViewListener;
                    if (searchViewListener == null) {
                        return false;
                    }
                    searchViewListener.onSearchViewShownAnimation();
                    return false;
                }
            }, getRevealAnimationCenter()).start();
        } else {
            setVisibility(0);
        }
        hideTabLayout(animate);
        this.isSearchOpen = true;
        SearchViewListener searchViewListener = this.searchViewListener;
        if (searchViewListener == null) {
            return null;
        }
        searchViewListener.onSearchViewShown();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit closeSearch$default(SimpleSearchView simpleSearchView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return simpleSearchView.closeSearch(z);
    }

    public final Unit closeSearch(final boolean animate) {
        SearchViewBinding searchViewBinding = this.binding;
        if (!this.isSearchOpen) {
            return null;
        }
        this.searchIsClosing = true;
        EditText searchEditText = searchViewBinding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.setText((CharSequence) null);
        this.searchIsClosing = false;
        clearFocus();
        if (animate) {
            SimpleAnimationUtils.hideOrFadeOut(this, this.animationDuration, new SimpleAnimationListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$closeSearch$$inlined$with$lambda$1
                @Override // com.ferfalk.simplesearchview.utils.SimpleAnimationListener, com.ferfalk.simplesearchview.utils.SimpleAnimationUtils.AnimationListener
                public boolean onAnimationEnd(View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    SearchViewListener searchViewListener = this.this$0.searchViewListener;
                    if (searchViewListener == null) {
                        return false;
                    }
                    searchViewListener.onSearchViewClosedAnimation();
                    return false;
                }
            }, getRevealAnimationCenter()).start();
        } else {
            setVisibility(4);
        }
        showTabLayout(animate);
        this.isSearchOpen = false;
        SearchViewListener searchViewListener = this.searchViewListener;
        if (searchViewListener == null) {
            return null;
        }
        searchViewListener.onSearchViewClosed();
        return Unit.INSTANCE;
    }

    public final void setTabLayout(final TabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.tabLayout = tabLayout;
        Intrinsics.checkNotNull(tabLayout);
        tabLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView.setTabLayout.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SimpleSearchView.this.tabLayoutInitialHeight = tabLayout.getHeight();
                tabLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        TabLayout tabLayout2 = this.tabLayout;
        Intrinsics.checkNotNull(tabLayout2);
        tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new SimpleOnTabSelectedListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView.setTabLayout.2
            @Override // com.ferfalk.simplesearchview.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                SimpleSearchView.closeSearch$default(SimpleSearchView.this, false, 1, null);
            }
        });
    }

    public static /* synthetic */ void showTabLayout$default(SimpleSearchView simpleSearchView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        simpleSearchView.showTabLayout(z);
    }

    public final void showTabLayout(boolean animate) {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            return;
        }
        if (animate) {
            Intrinsics.checkNotNull(tabLayout);
            SimpleAnimationUtils.verticalSlideView$default(tabLayout, 0, this.tabLayoutInitialHeight, this.animationDuration, null, 16, null).start();
        } else if (tabLayout != null) {
            tabLayout.setVisibility(0);
        }
    }

    public static /* synthetic */ void hideTabLayout$default(SimpleSearchView simpleSearchView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        simpleSearchView.hideTabLayout(z);
    }

    public final void hideTabLayout(boolean animate) {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            return;
        }
        if (animate) {
            Intrinsics.checkNotNull(tabLayout);
            TabLayout tabLayout2 = this.tabLayout;
            Intrinsics.checkNotNull(tabLayout2);
            SimpleAnimationUtils.verticalSlideView$default(tabLayout, tabLayout2.getHeight(), 0, this.animationDuration, null, 16, null).start();
            return;
        }
        Intrinsics.checkNotNull(tabLayout);
        tabLayout.setVisibility(8);
    }

    public final boolean onBackPressed() {
        if (!this.isSearchOpen) {
            return false;
        }
        closeSearch$default(this, false, 1, null);
        return true;
    }

    public static /* synthetic */ boolean onActivityResult$default(SimpleSearchView simpleSearchView, int i, int i2, Intent intent, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = true;
        }
        return simpleSearchView.onActivityResult(i, i2, intent, z);
    }

    public final boolean onActivityResult(int requestCode, int resultCode, Intent data, boolean submit) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (requestCode != 735 || resultCode != -1) {
            return false;
        }
        ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("android.speech.extra.RESULTS");
        ArrayList<String> arrayList = stringArrayListExtra;
        if (!(arrayList == null || arrayList.isEmpty())) {
            String str = stringArrayListExtra.get(0);
            if (!TextUtils.isEmpty(str)) {
                setQuery(str, submit);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: getCardStyle, reason: from getter */
    public final int getStyle() {
        return this.style;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0077  */
    /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
    public final void setCardStyle(int i) {
        float fConvertDpToPx;
        SearchViewBinding searchViewBinding = this.binding;
        this.style = i;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        if (i == 0) {
            searchViewBinding.searchContainer.setBackgroundColor(-1);
            View bottomLine = searchViewBinding.bottomLine;
            Intrinsics.checkNotNullExpressionValue(bottomLine, "bottomLine");
            bottomLine.setVisibility(0);
        } else {
            if (i == 1) {
                ConstraintLayout searchContainer = searchViewBinding.searchContainer;
                Intrinsics.checkNotNullExpressionValue(searchContainer, "searchContainer");
                searchContainer.setBackground(getCardStyleBackground());
                View bottomLine2 = searchViewBinding.bottomLine;
                Intrinsics.checkNotNullExpressionValue(bottomLine2, "bottomLine");
                bottomLine2.setVisibility(8);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                int iConvertDpToPx = DimensUtils.convertDpToPx(6, context);
                layoutParams.setMargins(iConvertDpToPx, iConvertDpToPx, iConvertDpToPx, iConvertDpToPx);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                fConvertDpToPx = DimensUtils.convertDpToPx(2, context2);
            } else {
                searchViewBinding.searchContainer.setBackgroundColor(-1);
                View bottomLine3 = searchViewBinding.bottomLine;
                Intrinsics.checkNotNullExpressionValue(bottomLine3, "bottomLine");
                bottomLine3.setVisibility(0);
            }
            ConstraintLayout searchContainer2 = searchViewBinding.searchContainer;
            Intrinsics.checkNotNullExpressionValue(searchContainer2, "searchContainer");
            searchContainer2.setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 21) {
                ConstraintLayout searchContainer3 = searchViewBinding.searchContainer;
                Intrinsics.checkNotNullExpressionValue(searchContainer3, "searchContainer");
                searchContainer3.setElevation(fConvertDpToPx);
            }
        }
        fConvertDpToPx = 0.0f;
        ConstraintLayout searchContainer4 = searchViewBinding.searchContainer;
        Intrinsics.checkNotNullExpressionValue(searchContainer4, "searchContainer");
        searchContainer4.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT >= 21) {
            ConstraintLayout searchContainer5 = searchViewBinding.searchContainer;
            Intrinsics.checkNotNullExpressionValue(searchContainer5, "searchContainer");
            searchContainer5.setElevation(fConvertDpToPx);
        }
    }

    private final GradientDrawable getCardStyleBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gradientDrawable.setCornerRadius(DimensUtils.convertDpToPx(4, context));
        return gradientDrawable;
    }

    public final void setIconsAlpha(float alpha) {
        SearchViewBinding searchViewBinding = this.binding;
        ImageButton clearButton = searchViewBinding.clearButton;
        Intrinsics.checkNotNullExpressionValue(clearButton, "clearButton");
        clearButton.setAlpha(alpha);
        ImageButton voiceButton = searchViewBinding.voiceButton;
        Intrinsics.checkNotNullExpressionValue(voiceButton, "voiceButton");
        voiceButton.setAlpha(alpha);
    }

    public final void setIconsColor(int color) {
        SearchViewBinding searchViewBinding = this.binding;
        ImageViewCompat.setImageTintList(searchViewBinding.clearButton, ColorStateList.valueOf(color));
        ImageViewCompat.setImageTintList(searchViewBinding.voiceButton, ColorStateList.valueOf(color));
    }

    public final void setBackIconAlpha(float alpha) {
        ImageButton backButton = this.binding.backButton;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        backButton.setAlpha(alpha);
    }

    public final void setBackIconColor(int color) {
        ImageViewCompat.setImageTintList(this.binding.backButton, ColorStateList.valueOf(color));
    }

    public final void setBackIconDrawable(Drawable drawable) {
        this.binding.backButton.setImageDrawable(drawable);
    }

    public final void setVoiceIconDrawable(Drawable drawable) {
        this.binding.voiceButton.setImageDrawable(drawable);
    }

    public final void setClearIconDrawable(Drawable drawable) {
        this.binding.clearButton.setImageDrawable(drawable);
    }

    public final void setSearchBackground(Drawable background) {
        ConstraintLayout searchContainer = this.binding.searchContainer;
        Intrinsics.checkNotNullExpressionValue(searchContainer, "searchContainer");
        searchContainer.setBackground(background);
    }

    public final void setTextColor(int color) {
        this.binding.searchEditText.setTextColor(color);
    }

    public final void setHintTextColor(int color) {
        this.binding.searchEditText.setHintTextColor(color);
    }

    public final void setHint(CharSequence hint) {
        EditText searchEditText = this.binding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.setHint(hint);
    }

    public final void setInputType(int inputType) {
        EditText searchEditText = this.binding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.setInputType(inputType);
    }

    public final void setCursorDrawable(int drawable) {
        EditText searchEditText = this.binding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        EditTextReflectionUtils.setCursorDrawable(searchEditText, drawable);
    }

    public final void setCursorColor(int color) {
        EditText searchEditText = this.binding.searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        EditTextReflectionUtils.setCursorColor(searchEditText, color);
    }

    public final void enableVoiceSearch(boolean voiceSearch) {
        this.allowVoiceSearch = voiceSearch;
    }

    public final void setQuery(CharSequence sequence, boolean submit) {
        SearchViewBinding searchViewBinding = this.binding;
        searchViewBinding.searchEditText.setText(sequence);
        if (sequence != null) {
            searchViewBinding.searchEditText.setSelection(searchViewBinding.searchEditText.length());
            this.query = sequence;
        }
        if (!submit || TextUtils.isEmpty(sequence)) {
            return;
        }
        onSubmitQuery();
    }

    public final void showVoice(boolean show) {
        SearchViewBinding searchViewBinding = this.binding;
        if (show && isVoiceAvailable() && this.allowVoiceSearch) {
            ImageButton voiceButton = searchViewBinding.voiceButton;
            Intrinsics.checkNotNullExpressionValue(voiceButton, "voiceButton");
            voiceButton.setVisibility(0);
        } else {
            ImageButton voiceButton2 = searchViewBinding.voiceButton;
            Intrinsics.checkNotNullExpressionValue(voiceButton2, "voiceButton");
            voiceButton2.setVisibility(8);
        }
    }

    public final void setMenuItem(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.ferfalk.simplesearchview.SimpleSearchView.setMenuItem.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem2) {
                SimpleSearchView.showSearch$default(SimpleSearchView.this, false, 1, null);
                return true;
            }
        });
    }

    public final void setOnQueryTextListener(OnQueryTextListener listener) {
        this.onQueryChangeListener = listener;
    }

    public final void setOnSearchViewListener(SearchViewListener listener) {
        this.searchViewListener = listener;
    }

    public final void setVoiceSearchPrompt(String voiceSearchPrompt) {
        this.voiceSearchPrompt = voiceSearchPrompt;
    }

    /* JADX INFO: compiled from: SimpleSearchView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006$"}, d2 = {"Lcom/ferfalk/simplesearchview/SimpleSearchView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "animationDuration", "", "getAnimationDuration", "()I", "setAnimationDuration", "(I)V", "isSearchOpen", "", "()Z", "setSearchOpen", "(Z)V", "keepQuery", "getKeepQuery", "setKeepQuery", "query", "", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "voiceSearchPrompt", "getVoiceSearchPrompt", "setVoiceSearchPrompt", "writeToParcel", "", "out", "flags", "Companion", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
    public static final class SavedState extends BaseSavedState {
        private int animationDuration;
        private boolean isSearchOpen;
        private boolean keepQuery;
        private String query;
        private String voiceSearchPrompt;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Creator<SavedState> CREATOR = new Creator<SavedState>() { // from class: com.ferfalk.simplesearchview.SimpleSearchView$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new SavedState(in, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public final String getQuery() {
            return this.query;
        }

        public final void setQuery(String str) {
            this.query = str;
        }

        /* JADX INFO: renamed from: isSearchOpen, reason: from getter */
        public final boolean getIsSearchOpen() {
            return this.isSearchOpen;
        }

        public final void setSearchOpen(boolean z) {
            this.isSearchOpen = z;
        }

        public final int getAnimationDuration() {
            return this.animationDuration;
        }

        public final void setAnimationDuration(int i) {
            this.animationDuration = i;
        }

        public final String getVoiceSearchPrompt() {
            return this.voiceSearchPrompt;
        }

        public final void setVoiceSearchPrompt(String str) {
            this.voiceSearchPrompt = str;
        }

        public final boolean getKeepQuery() {
            return this.keepQuery;
        }

        public final void setKeepQuery(boolean z) {
            this.keepQuery = z;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.query = parcel.readString();
            this.isSearchOpen = parcel.readInt() == 1;
            this.animationDuration = parcel.readInt();
            this.voiceSearchPrompt = parcel.readString();
            this.keepQuery = parcel.readInt() == 1;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            Intrinsics.checkNotNullParameter(out, "out");
            super.writeToParcel(out, flags);
            out.writeString(this.query);
            out.writeInt(this.isSearchOpen ? 1 : 0);
            out.writeInt(this.animationDuration);
            out.writeString(this.voiceSearchPrompt);
            out.writeInt(this.keepQuery ? 1 : 0);
        }

        /* JADX INFO: compiled from: SimpleSearchView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ferfalk/simplesearchview/SimpleSearchView$SavedState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ferfalk/simplesearchview/SimpleSearchView$SavedState;", "getCREATOR", "()Landroid/os/Parcelable$Creator;", "simplesearchview_release"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Creator<SavedState> getCREATOR() {
                return SavedState.CREATOR;
            }
        }
    }
}
