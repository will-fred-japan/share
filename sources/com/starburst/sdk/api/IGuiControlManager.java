package com.starburst.sdk.api;

import com.starburst.sdk.req.GuiAppInfo;
import com.starburst.sdk.req.GuiControlRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IGuiControlManager {
    void close();

    GuiControlRequest createRequest();

    void next(String str, IGuiControlCallback iGuiControlCallback);

    void next(String str, String str2, IGuiControlCallback iGuiControlCallback);

    void next(String str, String str2, String str3, IGuiControlCallback iGuiControlCallback);

    void next(String str, String str2, String str3, String str4, IGuiControlCallback iGuiControlCallback);

    void next(String str, String str2, String str3, String str4, List<GuiAppInfo> list, IGuiControlCallback iGuiControlCallback);

    void next(String str, String str2, List<GuiAppInfo> list, IGuiControlCallback iGuiControlCallback);

    void reset(IGuiControlCallback iGuiControlCallback);

    void send(GuiControlRequest guiControlRequest, IGuiControlCallback iGuiControlCallback);

    void setGuiConfig(GuiControlConfig guiControlConfig);

    void start(String str, String str2, String str3, String str4, List<GuiAppInfo> list, IGuiControlCallback iGuiControlCallback);

    void start(String str, String str2, List<GuiAppInfo> list, IGuiControlCallback iGuiControlCallback);
}
