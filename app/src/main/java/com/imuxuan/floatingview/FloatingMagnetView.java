package com.imuxuan.floatingview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.imuxuan.floatingview.utils.SystemUtils;

/* JADX INFO: loaded from: classes.dex */
public class FloatingMagnetView extends FrameLayout {
    public static final int MARGIN_EDGE = 13;
    private static final int TOUCH_TIME_THRESHOLD = 150;
    private boolean isNearestLeft;
    private long mLastTouchDownTime;
    private MagnetViewListener mMagnetViewListener;
    protected MoveAnimator mMoveAnimator;
    private float mOriginalRawX;
    private float mOriginalRawY;
    private float mOriginalX;
    private float mOriginalY;
    private float mPortraitY;
    private int mScreenHeight;
    protected int mScreenWidth;
    private int mStatusBarHeight;

    public void setMagnetViewListener(MagnetViewListener magnetViewListener) {
        this.mMagnetViewListener = magnetViewListener;
    }

    public FloatingMagnetView(Context context) {
        this(context, null);
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingMagnetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isNearestLeft = true;
        init();
    }

    private void init() {
        this.mMoveAnimator = new MoveAnimator();
        this.mStatusBarHeight = SystemUtils.getStatusBarHeight(getContext());
        setClickable(true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            changeOriginalTouchParams(motionEvent);
            updateSize();
            this.mMoveAnimator.stop();
        } else if (action == 1) {
            clearPortraitY();
            moveToEdge();
            if (isOnClickEvent()) {
                dealClickEvent();
            }
        } else if (action == 2) {
            updateViewPosition(motionEvent);
        }
        return true;
    }

    protected void dealClickEvent() {
        MagnetViewListener magnetViewListener = this.mMagnetViewListener;
        if (magnetViewListener != null) {
            magnetViewListener.onClick(this);
        }
    }

    protected boolean isOnClickEvent() {
        return System.currentTimeMillis() - this.mLastTouchDownTime < 150;
    }

    private void updateViewPosition(MotionEvent motionEvent) {
        setX((this.mOriginalX + motionEvent.getRawX()) - this.mOriginalRawX);
        float rawY = (this.mOriginalY + motionEvent.getRawY()) - this.mOriginalRawY;
        int i = this.mStatusBarHeight;
        if (rawY < i) {
            rawY = i;
        }
        if (rawY > this.mScreenHeight - getHeight()) {
            rawY = this.mScreenHeight - getHeight();
        }
        setY(rawY);
    }

    private void changeOriginalTouchParams(MotionEvent motionEvent) {
        this.mOriginalX = getX();
        this.mOriginalY = getY();
        this.mOriginalRawX = motionEvent.getRawX();
        this.mOriginalRawY = motionEvent.getRawY();
        this.mLastTouchDownTime = System.currentTimeMillis();
    }

    protected void updateSize() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            this.mScreenWidth = viewGroup.getWidth() - getWidth();
            this.mScreenHeight = viewGroup.getHeight();
        }
    }

    public void moveToEdge() {
        moveToEdge(isNearestLeft(), false);
    }

    public void moveToEdge(boolean z, boolean z2) {
        float f = z ? 13.0f : this.mScreenWidth - 13;
        float y = getY();
        if (!z2) {
            float f2 = this.mPortraitY;
            if (f2 != 0.0f) {
                clearPortraitY();
                y = f2;
            }
        }
        this.mMoveAnimator.start(f, Math.min(Math.max(0.0f, y), this.mScreenHeight - getHeight()));
    }

    private void clearPortraitY() {
        this.mPortraitY = 0.0f;
    }

    protected boolean isNearestLeft() {
        boolean z = getX() < ((float) (this.mScreenWidth / 2));
        this.isNearestLeft = z;
        return z;
    }

    public void onRemove() {
        MagnetViewListener magnetViewListener = this.mMagnetViewListener;
        if (magnetViewListener != null) {
            magnetViewListener.onRemove(this);
        }
    }

    protected class MoveAnimator implements Runnable {
        private float destinationX;
        private float destinationY;
        private Handler handler = new Handler(Looper.getMainLooper());
        private long startingTime;

        protected MoveAnimator() {
        }

        void start(float f, float f2) {
            this.destinationX = f;
            this.destinationY = f2;
            this.startingTime = System.currentTimeMillis();
            this.handler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingMagnetView.this.getRootView() == null || FloatingMagnetView.this.getRootView().getParent() == null) {
                return;
            }
            float fMin = Math.min(1.0f, (System.currentTimeMillis() - this.startingTime) / 400.0f);
            FloatingMagnetView.this.move((this.destinationX - FloatingMagnetView.this.getX()) * fMin, (this.destinationY - FloatingMagnetView.this.getY()) * fMin);
            if (fMin < 1.0f) {
                this.handler.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            this.handler.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void move(float f, float f2) {
        setX(getX() + f);
        setY(getY() + f2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getParent() != null) {
            final boolean z = configuration.orientation == 2;
            markPortraitY(z);
            ((ViewGroup) getParent()).post(new Runnable() { // from class: com.imuxuan.floatingview.FloatingMagnetView.1
                @Override // java.lang.Runnable
                public void run() {
                    FloatingMagnetView.this.updateSize();
                    FloatingMagnetView floatingMagnetView = FloatingMagnetView.this;
                    floatingMagnetView.moveToEdge(floatingMagnetView.isNearestLeft, z);
                }
            });
        }
    }

    private void markPortraitY(boolean z) {
        if (z) {
            this.mPortraitY = getY();
        }
    }
}
