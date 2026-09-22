package com.hack.assist;

import android.app.Activity;
import android.os.Bundle;
import com.hack.opensdk.Cmd;
import com.hack.opensdk.CmdConstants;

/* JADX INFO: loaded from: classes.dex */
public class AssistActivity extends Activity {

    public static class P0 extends BaseActivity {
    }

    public static class P1 extends BaseActivity {
    }

    public static class P10 extends BaseActivity {
    }

    public static class P11 extends BaseActivity {
    }

    public static class P12 extends BaseActivity {
    }

    public static class P13 extends BaseActivity {
    }

    public static class P14 extends BaseActivity {
    }

    public static class P15 extends BaseActivity {
    }

    public static class P16 extends BaseActivity {
    }

    public static class P17 extends BaseActivity {
    }

    public static class P18 extends BaseActivity {
    }

    public static class P19 extends BaseActivity {
    }

    public static class P2 extends BaseActivity {
    }

    public static class P3 extends BaseActivity {
    }

    public static class P4 extends BaseActivity {
    }

    public static class P5 extends BaseActivity {
    }

    public static class P6 extends BaseActivity {
    }

    public static class P7 extends BaseActivity {
    }

    public static class P8 extends BaseActivity {
    }

    public static class P9 extends BaseActivity {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Cmd.INSTANCE().exec(CmdConstants.CMD_ASSIST_ACTIVITY_CALL, this);
    }

    public static class BaseActivity extends Activity {
        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            Cmd.INSTANCE().exec(CmdConstants.CMD_ASSIST_ACTIVITY_CALL2, this);
        }
    }
}
