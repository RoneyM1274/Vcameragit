package com.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes.dex */
final class CalendarStyle {
    final com.google.android.material.datepicker.CalendarItemStyle day;
    final com.google.android.material.datepicker.CalendarItemStyle invalidDay;
    final Paint rangeFill;
    final com.google.android.material.datepicker.CalendarItemStyle selectedDay;
    final com.google.android.material.datepicker.CalendarItemStyle selectedYear;
    final com.google.android.material.datepicker.CalendarItemStyle todayDay;
    final com.google.android.material.datepicker.CalendarItemStyle todayYear;
    final com.google.android.material.datepicker.CalendarItemStyle year;

    CalendarStyle(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.day = com.google.android.material.datepicker.CalendarItemStyle.create(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.invalidDay = com.google.android.material.datepicker.CalendarItemStyle.create(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.selectedDay = com.google.android.material.datepicker.CalendarItemStyle.create(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.todayDay = com.google.android.material.datepicker.CalendarItemStyle.create(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.year = com.google.android.material.datepicker.CalendarItemStyle.create(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.selectedYear = com.google.android.material.datepicker.CalendarItemStyle.create(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.todayYear = com.google.android.material.datepicker.CalendarItemStyle.create(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.rangeFill = paint;
        paint.setColor(colorStateList.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
