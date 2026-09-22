package com.tbuonomo.viewpagerdotsindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseDotsIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 Z2\u00020\u0001:\u0003Z[\\B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0007H&J\u0010\u00108\u001a\u0002062\u0006\u00109\u001a\u00020\u0007H\u0004J\b\u0010:\u001a\u00020;H&J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0004J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u001aH\u0004J\b\u0010?\u001a\u000206H\u0014J0\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0014J\u0010\u0010F\u001a\u0002062\u0006\u00107\u001a\u00020\u0007H&J\u0006\u0010G\u001a\u000206J\b\u0010H\u001a\u000206H\u0004J\b\u0010I\u001a\u000206H\u0002J\b\u0010J\u001a\u000206H\u0002J\b\u0010K\u001a\u000206H\u0002J\u0010\u0010L\u001a\u0002062\u0006\u00107\u001a\u00020\u0007H&J\u0010\u0010M\u001a\u0002062\u0006\u00109\u001a\u00020\u0007H\u0002J\u0010\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020\u0007H\u0007J\u000e\u0010P\u001a\u0002062\u0006\u0010Q\u001a\u000200J\u000e\u0010R\u001a\u0002062\u0006\u0010S\u001a\u000202J\n\u0010T\u001a\u00020\u0007*\u00020\u0003J(\u0010U\u001a\u00020\u000e\"\u0004\b\u0000\u0010V*\u0012\u0012\u0004\u0012\u0002HV0\nj\b\u0012\u0004\u0012\u0002HV`\f2\u0006\u00107\u001a\u00020\u0007J\u0012\u0010W\u001a\u000206*\u00020X2\u0006\u0010Y\u001a\u00020\u0007R \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u000e*\u0004\u0018\u0001008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b/\u00101R\u001a\u0010/\u001a\u00020\u000e*\u0004\u0018\u0001028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b/\u00103R\u0018\u00104\u001a\u00020\u000e*\u0002008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b4\u00101R\u0018\u00104\u001a\u00020\u000e*\u0002028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b4\u00103¨\u0006]"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dots", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "dotsClickable", "", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", "value", "dotsColor", "getDotsColor", "()I", "setDotsColor", "(I)V", "dotsCornerRadius", "", "getDotsCornerRadius", "()F", "setDotsCornerRadius", "(F)V", "dotsSize", "getDotsSize", "setDotsSize", "dotsSpacing", "getDotsSpacing", "setDotsSpacing", "pager", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "getPager", "()Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "setPager", "(Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;)V", "type", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "getType", "()Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "isEmpty", "Landroidx/viewpager/widget/ViewPager;", "(Landroidx/viewpager/widget/ViewPager;)Z", "Landroidx/viewpager2/widget/ViewPager2;", "(Landroidx/viewpager2/widget/ViewPager2;)Z", "isNotEmpty", "addDot", "", "index", "addDots", "count", "buildOnPageChangedListener", "Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "dpToPx", "dp", "dpToPxF", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "refreshDotColor", "refreshDots", "refreshDotsColors", "refreshDotsCount", "refreshDotsSize", "refreshOnPageChangedListener", "removeDot", "removeDots", "setPointsColor", "color", "setViewPager", "viewPager", "setViewPager2", "viewPager2", "getThemePrimaryColor", "isInBounds", "T", "setWidth", "Landroid/view/View;", "width", "Companion", "Pager", "Type", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseDotsIndicator extends FrameLayout {
    public static final int DEFAULT_POINT_COLOR = -16711681;
    private HashMap _$_findViewCache;
    protected final ArrayList<ImageView> dots;
    private boolean dotsClickable;
    private int dotsColor;
    private float dotsCornerRadius;
    private float dotsSize;
    private float dotsSpacing;
    private Pager pager;

    /* JADX INFO: compiled from: BaseDotsIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "", "count", "", "getCount", "()I", "currentItem", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "addOnPageChangeListener", "", "onPageChangeListenerHelper", "Lcom/tbuonomo/viewpagerdotsindicator/OnPageChangeListenerHelper;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 4, 2})
    public interface Pager {
        void addOnPageChangeListener(OnPageChangeListenerHelper onPageChangeListenerHelper);

        int getCount();

        int getCurrentItem();

        boolean isEmpty();

        boolean isNotEmpty();

        void removeOnPageChangeListener();

        void setCurrentItem(int item, boolean smoothScroll);
    }

    public BaseDotsIndicator(Context context) {
        this(context, null, 0, 6, null);
    }

    public BaseDotsIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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

    public abstract void addDot(int index);

    public abstract OnPageChangeListenerHelper buildOnPageChangedListener();

    public abstract Type getType();

    public abstract void refreshDotColor(int index);

    public abstract void removeDot(int index);

    public /* synthetic */ BaseDotsIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDotsIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dots = new ArrayList<>();
        this.dotsClickable = true;
        this.dotsColor = DEFAULT_POINT_COLOR;
        float fDpToPxF = dpToPxF(getType().getDefaultSize());
        this.dotsSize = fDpToPxF;
        this.dotsCornerRadius = fDpToPxF / 2.0f;
        this.dotsSpacing = dpToPxF(getType().getDefaultSpacing());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, getType().getStyleableId());
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…(attrs, type.styleableId)");
            setDotsColor(typedArrayObtainStyledAttributes.getColor(getType().getDotsColorId(), DEFAULT_POINT_COLOR));
            this.dotsSize = typedArrayObtainStyledAttributes.getDimension(getType().getDotsSizeId(), this.dotsSize);
            this.dotsCornerRadius = typedArrayObtainStyledAttributes.getDimension(getType().getDotsCornerRadiusId(), this.dotsCornerRadius);
            this.dotsSpacing = typedArrayObtainStyledAttributes.getDimension(getType().getDotsSpacingId(), this.dotsSpacing);
            this.dotsClickable = typedArrayObtainStyledAttributes.getBoolean(getType().getDotsClickableId(), true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DEFAULT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: BaseDotsIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BS\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\b\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b\u0012\b\b\u0001\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Type;", "", "defaultSize", "", "defaultSpacing", "styleableId", "", "dotsColorId", "", "dotsSizeId", "dotsSpacingId", "dotsCornerRadiusId", "dotsClickableId", "(Ljava/lang/String;IFF[IIIIII)V", "getDefaultSize", "()F", "getDefaultSpacing", "getDotsClickableId", "()I", "getDotsColorId", "getDotsCornerRadiusId", "getDotsSizeId", "getDotsSpacingId", "getStyleableId", "()[I", "DEFAULT", "SPRING", "WORM", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 4, 2})
    public static final class Type {
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type DEFAULT;
        public static final Type SPRING;
        public static final Type WORM;
        private final float defaultSize;
        private final float defaultSpacing;
        private final int dotsClickableId;
        private final int dotsColorId;
        private final int dotsCornerRadiusId;
        private final int dotsSizeId;
        private final int dotsSpacingId;
        private final int[] styleableId;

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i, float f, float f2, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
            super(str, i);
            this.defaultSize = f;
            this.defaultSpacing = f2;
            this.styleableId = iArr;
            this.dotsColorId = i2;
            this.dotsSizeId = i3;
            this.dotsSpacingId = i4;
            this.dotsCornerRadiusId = i5;
            this.dotsClickableId = i6;
        }

        public final float getDefaultSize() {
            return this.defaultSize;
        }

        public final float getDefaultSpacing() {
            return this.defaultSpacing;
        }

        public final int[] getStyleableId() {
            return this.styleableId;
        }

        public final int getDotsColorId() {
            return this.dotsColorId;
        }

        public final int getDotsSizeId() {
            return this.dotsSizeId;
        }

        public final int getDotsSpacingId() {
            return this.dotsSpacingId;
        }

        public final int getDotsCornerRadiusId() {
            return this.dotsCornerRadiusId;
        }

        public final int getDotsClickableId() {
            return this.dotsClickableId;
        }

        static {
            int[] iArr = R.styleable.SpringDotsIndicator;
            Intrinsics.checkNotNullExpressionValue(iArr, "R.styleable.SpringDotsIndicator");
            Type type = new Type("DEFAULT", 0, 16.0f, 8.0f, iArr, R.styleable.SpringDotsIndicator_dotsColor, R.styleable.SpringDotsIndicator_dotsSize, R.styleable.SpringDotsIndicator_dotsSpacing, R.styleable.SpringDotsIndicator_dotsCornerRadius, R.styleable.SpringDotsIndicator_dotsClickable);
            DEFAULT = type;
            int[] iArr2 = R.styleable.DotsIndicator;
            Intrinsics.checkNotNullExpressionValue(iArr2, "R.styleable.DotsIndicator");
            Type type2 = new Type("SPRING", 1, 16.0f, 4.0f, iArr2, R.styleable.DotsIndicator_dotsColor, R.styleable.DotsIndicator_dotsSize, R.styleable.DotsIndicator_dotsSpacing, R.styleable.DotsIndicator_dotsCornerRadius, R.styleable.SpringDotsIndicator_dotsClickable);
            SPRING = type2;
            int[] iArr3 = R.styleable.WormDotsIndicator;
            Intrinsics.checkNotNullExpressionValue(iArr3, "R.styleable.WormDotsIndicator");
            Type type3 = new Type("WORM", 2, 16.0f, 4.0f, iArr3, R.styleable.WormDotsIndicator_dotsColor, R.styleable.WormDotsIndicator_dotsSize, R.styleable.WormDotsIndicator_dotsSpacing, R.styleable.WormDotsIndicator_dotsCornerRadius, R.styleable.SpringDotsIndicator_dotsClickable);
            WORM = type3;
            $VALUES = new Type[]{type, type2, type3};
        }
    }

    public final boolean getDotsClickable() {
        return this.dotsClickable;
    }

    public final void setDotsClickable(boolean z) {
        this.dotsClickable = z;
    }

    public final int getDotsColor() {
        return this.dotsColor;
    }

    public final void setDotsColor(int i) {
        this.dotsColor = i;
        refreshDotsColors();
    }

    protected final float getDotsSize() {
        return this.dotsSize;
    }

    protected final void setDotsSize(float f) {
        this.dotsSize = f;
    }

    protected final float getDotsCornerRadius() {
        return this.dotsCornerRadius;
    }

    protected final void setDotsCornerRadius(float f) {
        this.dotsCornerRadius = f;
    }

    protected final float getDotsSpacing() {
        return this.dotsSpacing;
    }

    protected final void setDotsSpacing(float f) {
        this.dotsSpacing = f;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshDots();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshDotsCount() {
        int size = this.dots.size();
        Pager pager = this.pager;
        Intrinsics.checkNotNull(pager);
        if (size < pager.getCount()) {
            Pager pager2 = this.pager;
            Intrinsics.checkNotNull(pager2);
            addDots(pager2.getCount() - this.dots.size());
            return;
        }
        int size2 = this.dots.size();
        Pager pager3 = this.pager;
        Intrinsics.checkNotNull(pager3);
        if (size2 > pager3.getCount()) {
            int size3 = this.dots.size();
            Pager pager4 = this.pager;
            Intrinsics.checkNotNull(pager4);
            removeDots(size3 - pager4.getCount());
        }
    }

    protected final void refreshDotsColors() {
        int size = this.dots.size();
        for (int i = 0; i < size; i++) {
            refreshDotColor(i);
        }
    }

    protected final int dpToPx(int dp) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return (int) (resources.getDisplayMetrics().density * dp);
    }

    protected final float dpToPxF(float dp) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources.getDisplayMetrics().density * dp;
    }

    protected final void addDots(int count) {
        for (int i = 0; i < count; i++) {
            addDot(i);
        }
    }

    private final void removeDots(int count) {
        for (int i = 0; i < count; i++) {
            removeDot(i);
        }
    }

    public final void refreshDots() {
        if (this.pager == null) {
            return;
        }
        post(new Runnable() { // from class: com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.refreshDots.1
            @Override // java.lang.Runnable
            public final void run() {
                BaseDotsIndicator.this.refreshDotsCount();
                BaseDotsIndicator.this.refreshDotsColors();
                BaseDotsIndicator.this.refreshDotsSize();
                BaseDotsIndicator.this.refreshOnPageChangedListener();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshOnPageChangedListener() {
        Pager pager = this.pager;
        Intrinsics.checkNotNull(pager);
        if (pager.isNotEmpty()) {
            Pager pager2 = this.pager;
            Intrinsics.checkNotNull(pager2);
            pager2.removeOnPageChangeListener();
            OnPageChangeListenerHelper onPageChangeListenerHelperBuildOnPageChangedListener = buildOnPageChangedListener();
            Pager pager3 = this.pager;
            Intrinsics.checkNotNull(pager3);
            pager3.addOnPageChangeListener(onPageChangeListenerHelperBuildOnPageChangedListener);
            Pager pager4 = this.pager;
            Intrinsics.checkNotNull(pager4);
            onPageChangeListenerHelperBuildOnPageChangedListener.onPageScrolled(pager4.getCurrentItem(), 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshDotsSize() {
        Pager pager = this.pager;
        Intrinsics.checkNotNull(pager);
        int currentItem = pager.getCurrentItem();
        for (int i = 0; i < currentItem; i++) {
            ImageView imageView = this.dots.get(i);
            Intrinsics.checkNotNullExpressionValue(imageView, "dots[i]");
            setWidth(imageView, (int) this.dotsSize);
        }
    }

    @Deprecated(message = "Use setDotsColors() instead")
    public final void setPointsColor(int color) {
        setDotsColor(color);
        refreshDotsColors();
    }

    public final void setViewPager(final ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("You have to set an adapter to the view pager before initializing the dots indicator !");
        }
        PagerAdapter adapter = viewPager.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.registerDataSetObserver(new DataSetObserver() { // from class: com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.setViewPager.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                BaseDotsIndicator.this.refreshDots();
            }
        });
        this.pager = new Pager() { // from class: com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.setViewPager.2
            private ViewPager.OnPageChangeListener onPageChangeListener;

            public final ViewPager.OnPageChangeListener getOnPageChangeListener() {
                return this.onPageChangeListener;
            }

            public final void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
                this.onPageChangeListener = onPageChangeListener;
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public boolean isNotEmpty() {
                return BaseDotsIndicator.this.isNotEmpty(viewPager);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public int getCurrentItem() {
                return viewPager.getCurrentItem();
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public boolean isEmpty() {
                return BaseDotsIndicator.this.isEmpty(viewPager);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public int getCount() {
                PagerAdapter adapter2 = viewPager.getAdapter();
                if (adapter2 != null) {
                    return adapter2.getCount();
                }
                return 0;
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void setCurrentItem(int item, boolean smoothScroll) {
                viewPager.setCurrentItem(item, smoothScroll);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void removeOnPageChangeListener() {
                ViewPager.OnPageChangeListener onPageChangeListener = this.onPageChangeListener;
                if (onPageChangeListener != null) {
                    viewPager.removeOnPageChangeListener(onPageChangeListener);
                }
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void addOnPageChangeListener(final OnPageChangeListenerHelper onPageChangeListenerHelper) {
                Intrinsics.checkNotNullParameter(onPageChangeListenerHelper, "onPageChangeListenerHelper");
                ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator$setViewPager$2$addOnPageChangeListener$1
                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int state) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int position) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        onPageChangeListenerHelper.onPageScrolled(position, positionOffset);
                    }
                };
                this.onPageChangeListener = onPageChangeListener;
                ViewPager viewPager2 = viewPager;
                Intrinsics.checkNotNull(onPageChangeListener);
                viewPager2.addOnPageChangeListener(onPageChangeListener);
            }
        };
        refreshDots();
    }

    public final void setViewPager2(final ViewPager2 viewPager2) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        if (viewPager2.getAdapter() == null) {
            throw new IllegalStateException("You have to set an adapter to the view pager before initializing the dots indicator !");
        }
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.setViewPager2.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                BaseDotsIndicator.this.refreshDots();
            }
        });
        this.pager = new Pager() { // from class: com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.setViewPager2.2
            private ViewPager2.OnPageChangeCallback onPageChangeCallback;

            public final ViewPager2.OnPageChangeCallback getOnPageChangeCallback() {
                return this.onPageChangeCallback;
            }

            public final void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
                this.onPageChangeCallback = onPageChangeCallback;
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public boolean isNotEmpty() {
                return BaseDotsIndicator.this.isNotEmpty(viewPager2);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public int getCurrentItem() {
                return viewPager2.getCurrentItem();
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public boolean isEmpty() {
                return BaseDotsIndicator.this.isEmpty(viewPager2);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public int getCount() {
                RecyclerView.Adapter adapter2 = viewPager2.getAdapter();
                if (adapter2 != null) {
                    return adapter2.getItemCount();
                }
                return 0;
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void setCurrentItem(int item, boolean smoothScroll) {
                viewPager2.setCurrentItem(item, smoothScroll);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void removeOnPageChangeListener() {
                ViewPager2.OnPageChangeCallback onPageChangeCallback = this.onPageChangeCallback;
                if (onPageChangeCallback != null) {
                    viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
                }
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void addOnPageChangeListener(final OnPageChangeListenerHelper onPageChangeListenerHelper) {
                Intrinsics.checkNotNullParameter(onPageChangeListenerHelper, "onPageChangeListenerHelper");
                ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator$setViewPager2$2$addOnPageChangeListener$1
                    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                        onPageChangeListenerHelper.onPageScrolled(position, positionOffset);
                    }
                };
                this.onPageChangeCallback = onPageChangeCallback;
                ViewPager2 viewPager3 = viewPager2;
                Intrinsics.checkNotNull(onPageChangeCallback);
                viewPager3.registerOnPageChangeCallback(onPageChangeCallback);
            }
        };
        refreshDots();
    }

    public final void setWidth(View setWidth, int i) {
        Intrinsics.checkNotNullParameter(setWidth, "$this$setWidth");
        setWidth.getLayoutParams().width = i;
        setWidth.requestLayout();
    }

    public final <T> boolean isInBounds(ArrayList<T> isInBounds, int i) {
        Intrinsics.checkNotNullParameter(isInBounds, "$this$isInBounds");
        return i >= 0 && isInBounds.size() > i;
    }

    public final int getThemePrimaryColor(Context getThemePrimaryColor) {
        Intrinsics.checkNotNullParameter(getThemePrimaryColor, "$this$getThemePrimaryColor");
        TypedValue typedValue = new TypedValue();
        getThemePrimaryColor.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    protected final boolean isNotEmpty(ViewPager isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        PagerAdapter adapter = isNotEmpty.getAdapter();
        Intrinsics.checkNotNull(adapter);
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter!!");
        return adapter.getCount() > 0;
    }

    protected final boolean isNotEmpty(ViewPager2 isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        RecyclerView.Adapter adapter = isNotEmpty.getAdapter();
        Intrinsics.checkNotNull(adapter);
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter!!");
        return adapter.getItemCount() > 0;
    }

    protected final boolean isEmpty(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            PagerAdapter adapter = viewPager.getAdapter();
            Intrinsics.checkNotNull(adapter);
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter!!");
            if (adapter.getCount() == 0) {
                return true;
            }
        }
        return false;
    }

    protected final boolean isEmpty(ViewPager2 viewPager2) {
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            RecyclerView.Adapter adapter = viewPager2.getAdapter();
            Intrinsics.checkNotNull(adapter);
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter!!");
            if (adapter.getItemCount() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (Build.VERSION.SDK_INT < 17 || getLayoutDirection() != 1) {
            return;
        }
        setLayoutDirection(0);
        setRotation(180.0f);
        requestLayout();
    }
}
