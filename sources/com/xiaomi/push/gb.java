package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
final class gb {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        fx f17510a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f461a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m398a(Exception exc) {
        exc.getClass();
    }

    public static a b(Exception exc) {
        Throwable cause;
        m398a(exc);
        boolean z8 = exc instanceof gx;
        Throwable thA = exc;
        if (z8) {
            gx gxVar = (gx) exc;
            if (gxVar.a() != null) {
                thA = exc;
                thA = gxVar.a();
            }
        }
        thA = exc;
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = gr.a(thA);
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA != 0) {
            fx fxVarA = fx.a(fx.CONN_SUCCESS.a() + iA);
            aVar.f17510a = fxVarA;
            if (fxVarA == fx.CONN_BOSH_ERR && (cause = thA.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f17510a = fx.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f17510a = fx.CONN_XMPP_ERR;
        }
        fx fxVar = aVar.f17510a;
        if (fxVar != fx.CONN_TCP_ERR_OTHER && fxVar != fx.CONN_XMPP_ERR && fxVar != fx.CONN_BOSH_ERR) {
            return aVar;
        }
        aVar.f461a = str;
        return aVar;
    }

    public static a c(Exception exc) {
        m398a(exc);
        boolean z8 = exc instanceof gx;
        Throwable thA = exc;
        if (z8) {
            gx gxVar = (gx) exc;
            if (gxVar.a() != null) {
                thA = exc;
                thA = gxVar.a();
            }
        }
        thA = exc;
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = gr.a(thA);
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.f17510a = fx.BIND_TCP_READ_TIMEOUT;
        } else if (iA == 199) {
            aVar.f17510a = fx.BIND_TCP_ERR;
        } else if (iA == 499) {
            aVar.f17510a = fx.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f17510a = fx.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (iA == 109) {
            aVar.f17510a = fx.BIND_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f17510a = fx.BIND_XMPP_ERR;
        } else {
            aVar.f17510a = fx.BIND_TCP_BROKEN_PIPE;
        }
        fx fxVar = aVar.f17510a;
        if (fxVar != fx.BIND_TCP_ERR && fxVar != fx.BIND_XMPP_ERR && fxVar != fx.BIND_BOSH_ERR) {
            return aVar;
        }
        aVar.f461a = str;
        return aVar;
    }

    public static a d(Exception exc) {
        m398a(exc);
        boolean z8 = exc instanceof gx;
        Throwable thA = exc;
        if (z8) {
            gx gxVar = (gx) exc;
            if (gxVar.a() != null) {
                thA = exc;
                thA = gxVar.a();
            }
        }
        thA = exc;
        a aVar = new a();
        String message = thA.getMessage();
        int iA = gr.a(thA);
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.f17510a = fx.CHANNEL_TCP_READTIMEOUT;
        } else if (iA == 199) {
            aVar.f17510a = fx.CHANNEL_TCP_ERR;
        } else if (iA == 499) {
            aVar.f17510a = fx.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f17510a = fx.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (iA == 109) {
            aVar.f17510a = fx.CHANNEL_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f17510a = fx.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.f17510a = fx.CHANNEL_TCP_BROKEN_PIPE;
        }
        fx fxVar = aVar.f17510a;
        if (fxVar != fx.CHANNEL_TCP_ERR && fxVar != fx.CHANNEL_XMPPEXCEPTION && fxVar != fx.CHANNEL_BOSH_EXCEPTION) {
            return aVar;
        }
        aVar.f461a = str;
        return aVar;
    }

    public static a a(Exception exc) {
        m398a(exc);
        boolean z8 = exc instanceof gx;
        Throwable thA = exc;
        if (z8) {
            gx gxVar = (gx) exc;
            if (gxVar.a() != null) {
                thA = exc;
                thA = gxVar.a();
            }
        }
        thA = exc;
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int iA = gr.a(thA);
        if (iA != 0) {
            aVar.f17510a = fx.a(fx.GSLB_REQUEST_SUCCESS.a() + iA);
        }
        if (aVar.f17510a == null) {
            aVar.f17510a = fx.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f17510a == fx.GSLB_TCP_ERR_OTHER) {
            aVar.f461a = str;
        }
        return aVar;
    }
}
