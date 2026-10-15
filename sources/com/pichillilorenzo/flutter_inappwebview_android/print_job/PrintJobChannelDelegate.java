package com.pichillilorenzo.flutter_inappwebview_android.print_job;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.PrintJobInfoExt;
import p096m7.j;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class PrintJobChannelDelegate extends ChannelDelegateImpl {
    private PrintJobController printJobController;

    public PrintJobChannelDelegate(PrintJobController printJobController, l lVar) {
        super(lVar);
        this.printJobController = printJobController;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.printJobController = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, m7.l.c
    public void onMethodCall(j jVar, l.d dVar) {
        String str = jVar.f20496a;
        str.getClass();
        switch (str) {
            case "cancel":
                PrintJobController printJobController = this.printJobController;
                if (printJobController == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    printJobController.cancel();
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "getInfo":
                PrintJobController printJobController2 = this.printJobController;
                if (printJobController2 == null) {
                    dVar.success(null);
                    break;
                } else {
                    PrintJobInfoExt info = printJobController2.getInfo();
                    dVar.success(info != null ? info.toMap() : null);
                    break;
                }
                break;
            case "restart":
                PrintJobController printJobController3 = this.printJobController;
                if (printJobController3 == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    printJobController3.restart();
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "dispose":
                PrintJobController printJobController4 = this.printJobController;
                if (printJobController4 == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    printJobController4.dispose();
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            default:
                dVar.notImplemented();
                break;
        }
    }
}
