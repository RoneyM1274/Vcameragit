package com.hack.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class RefUtils {
    public static Field getField(Class cls, boolean z, String str) {
        if (cls != null && str != null) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
            }
        }
        return null;
    }

    public static Method getMethod(Class cls, boolean z, String str, Class[] clsArr) {
        if (cls != null && str != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
        }
        return null;
    }

    public static class FieldRef<T> {
        Field mField;
        boolean mIsStatic;

        public FieldRef(Class cls, boolean z, String str) {
            this.mIsStatic = z;
            Field field = RefUtils.getField(cls, z, str);
            this.mField = field;
            if (field != null) {
                field.setAccessible(true);
            }
        }

        public FieldRef(String str, boolean z, String str2) {
            try {
                this.mField = RefUtils.getField(Class.forName(str), z, str2);
            } catch (ClassNotFoundException unused) {
            }
            this.mIsStatic = z;
            Field field = this.mField;
            if (field != null) {
                field.setAccessible(true);
            }
        }

        public boolean isValid() {
            return this.mField != null;
        }

        public T get(Object obj) {
            try {
                return (T) this.mField.get(obj);
            } catch (Exception unused) {
                return null;
            }
        }

        public void set(Object obj, T t) {
            try {
                this.mField.set(obj, t);
            } catch (Exception unused) {
            }
        }
    }

    public static class MethodRef<T> {
        Method mMethod;

        public MethodRef(String str, boolean z, String str2, Class[] clsArr) {
            try {
                this.mMethod = RefUtils.getMethod(Class.forName(str), z, str2, clsArr);
            } catch (Exception unused) {
            }
            Method method = this.mMethod;
            if (method != null) {
                method.setAccessible(true);
            }
        }

        public MethodRef(Class cls, boolean z, String str, Class[] clsArr) {
            Method method = RefUtils.getMethod(cls, z, str, clsArr);
            this.mMethod = method;
            if (method != null) {
                method.setAccessible(true);
            }
        }

        public boolean isValid() {
            return this.mMethod != null;
        }

        public T invoke(Object obj, Object... objArr) {
            try {
                return (T) this.mMethod.invoke(obj, objArr);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
