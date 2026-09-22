package com.hack.opensdk;

import com.hack.utils.RefUtils;
import com.hack.utils.Singleton;

/* JADX INFO: loaded from: classes.dex */
public class Cmd {
    private static final boolean DEBUG = false;
    private static final String ENGINE_CMD_CLASS = "com.core.hack.Cmd";
    private static final String TAG = "Cmd";
    private static Singleton<Cmd> singleton = new Singleton<Cmd>() { // from class: com.hack.opensdk.Cmd.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.hack.utils.Singleton
        public Cmd create() {
            return new Cmd();
        }
    };
    private RefUtils.MethodRef mEngineExecMethod;

    public static Cmd INSTANCE() {
        return singleton.get();
    }

    private Cmd() {
        Class clsLoadClass;
        try {
            clsLoadClass = Class.forName(ENGINE_CMD_CLASS);
        } catch (ClassNotFoundException unused) {
            clsLoadClass = null;
        }
        if (clsLoadClass == null) {
            try {
                clsLoadClass = HackRuntime.getHackClassLoader().loadClass(ENGINE_CMD_CLASS);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.mEngineExecMethod = new RefUtils.MethodRef(clsLoadClass, true, "exec", new Class[]{Integer.TYPE, Object[].class});
    }

    public Object exec(int i, Object... objArr) {
        return this.mEngineExecMethod.invoke(null, Integer.valueOf(i), objArr);
    }
}
