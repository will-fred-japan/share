package com.jieli.jl_bt_ota.tool.data_handler;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.interfaces.bt.IBtProxy;
import com.jieli.jl_bt_ota.interfaces.command.OnDataHandlerListener;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.data.ReceivedDataInfo;
import com.jieli.jl_bt_ota.model.data.SendDataInfo;
import com.jieli.jl_bt_ota.tool.ParseHelper;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RcspDataHandler implements IDataHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IBtProxy f16290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OnDataHandlerListener f16291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CommandCache f16292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RcspParser f16293e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HandlerThread f16295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f16296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f16297i;
    private CommandBase j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16289a = "RcspDataHandler";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<SendDataInfo<?>> f16294f = new CopyOnWriteArrayList<>();

    public class TimeOutCheck implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SendDataInfo<?> f16298a;

        public TimeOutCheck(SendDataInfo<?> sendDataInfo) {
            this.f16298a = sendDataInfo;
            sendDataInfo.setSendTime(System.currentTimeMillis());
        }

        @Override // java.lang.Runnable
        public void run() {
            int opCode = this.f16298a.getOpCode();
            int sn = this.f16298a.getSn();
            int reSendMax = this.f16298a.getReSendMax();
            int reSendCount = this.f16298a.getReSendCount();
            JL_Log.w(RcspDataHandler.this.f16289a, "COMMAND TIMEOUT", CommonUtil.formatString("Waiting for reply command timeout. opCode : %s, sn : %s, reSendMax : %d,  reSendCount : %d.", CommonUtil.formatInt(opCode), CommonUtil.formatInt(sn), Integer.valueOf(reSendMax), Integer.valueOf(reSendCount)));
            if (reSendCount < reSendMax) {
                this.f16298a.setReSendCount(reSendCount + 1);
                RcspDataHandler.this.addSendData(this.f16298a);
            } else {
                RcspDataHandler.this.f16294f.remove(this.f16298a);
                RcspDataHandler.this.a(this.f16298a.getDevice(), opCode, sn);
                RcspDataHandler.this.a(this.f16298a, OTAError.buildError(ErrorCode.SUB_ERR_SEND_TIMEOUT).setOpCode(opCode));
            }
        }
    }

    public RcspDataHandler(IBtProxy iBtProxy, OnDataHandlerListener onDataHandlerListener) {
        HandlerThread handlerThread = new HandlerThread("RcspDataHandler");
        this.f16295g = handlerThread;
        this.f16297i = new Handler(Looper.getMainLooper());
        this.f16290b = (IBtProxy) CommonUtil.checkNotNull(iBtProxy, "IBtProxy can not be null.");
        this.f16291c = onDataHandlerListener;
        this.f16292d = new CommandCache();
        this.f16293e = new RcspParser();
        handlerThread.start();
        this.f16296h = new Handler(handlerThread.getLooper(), new f());
        JL_Log.i("RcspDataHandler", TCPTimingCache.P_INIT, "" + this);
    }

    @Override // com.jieli.jl_bt_ota.tool.data_handler.IDataHandler
    public void addRecvData(ReceivedDataInfo receivedDataInfo) {
        this.f16296h.post(new e(this, receivedDataInfo, 1));
    }

    @Override // com.jieli.jl_bt_ota.tool.data_handler.IDataHandler
    public void addSendData(SendDataInfo<?> sendDataInfo) {
        this.f16296h.post(new a(this, sendDataInfo, 2));
    }

    @Override // com.jieli.jl_bt_ota.tool.data_handler.IDataHandler
    public void release() {
        this.j = null;
        this.f16296h.removeCallbacksAndMessages(null);
        this.f16297i.removeCallbacksAndMessages(null);
        this.f16292d.release();
        this.f16293e.release();
        this.f16294f.clear();
        if (!this.f16295g.isInterrupted()) {
            this.f16295g.quitSafely();
        }
        JL_Log.i(this.f16289a, "release", "" + this);
    }

    private boolean c(SendDataInfo<?> sendDataInfo) {
        byte[] sendData = sendDataInfo.getSendData();
        if (sendData == null || sendData.length == 0) {
            JL_Log.i(this.f16289a, "sendData", "Failed to pack data.");
            return false;
        }
        int deviceReceiveMtu = sendDataInfo.getDeviceReceiveMtu();
        if (sendData.length > deviceReceiveMtu) {
            JL_Log.e(this.f16289a, "sendData", CommonUtil.formatString("Data size(%d) exceeds communication mtu(%d).", Integer.valueOf(sendData.length), Integer.valueOf(deviceReceiveMtu)));
            return false;
        }
        boolean zWriteData = false;
        for (int i9 = 0; i9 < 3 && !(zWriteData = this.f16290b.writeData(sendDataInfo.getDevice(), sendData)); i9++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e9) {
                e9.printStackTrace();
            }
        }
        JL_Log.i(this.f16289a, "sendData", "" + zWriteData);
        return zWriteData;
    }

    private int d(SendDataInfo<?> sendDataInfo) {
        if (sendDataInfo == null) {
            return Integer.MAX_VALUE;
        }
        return sendDataInfo.getOpCode() | (sendDataInfo.getSn() << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(SendDataInfo sendDataInfo) {
        if (!c(sendDataInfo)) {
            a((SendDataInfo<?>) sendDataInfo, OTAError.buildError(12290));
            return;
        }
        BluetoothDevice device = sendDataInfo.getDevice();
        JL_Log.d(this.f16289a, "TX", "device : " + device + ", " + sendDataInfo.getCommand());
        sendDataInfo.setSendTime(a());
        if (sendDataInfo.getBasePacket().getHasResponse() == 1) {
            this.f16292d.putCommandBase(device, sendDataInfo.getCommand());
            if (!this.f16294f.contains(sendDataInfo)) {
                this.f16294f.add(sendDataInfo);
            }
            int iD = d((SendDataInfo<?>) sendDataInfo);
            this.f16296h.removeMessages(iD);
            Handler handler = this.f16296h;
            handler.sendMessageDelayed(handler.obtainMessage(iD, new TimeOutCheck(sendDataInfo)), sendDataInfo.getTimeoutMs());
            return;
        }
        sendDataInfo.getCommand().setStatus(0);
        a(sendDataInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Runnable)) {
            return true;
        }
        ((Runnable) obj).run();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ReceivedDataInfo receivedDataInfo) {
        BluetoothDevice device = receivedDataInfo.getDevice();
        byte[] data = receivedDataInfo.getData();
        ArrayList<BasePacket> arrayListFindPacketData = this.f16293e.findPacketData(receivedDataInfo.getDeviceSendMtu(), data);
        if (arrayListFindPacketData != null && !arrayListFindPacketData.isEmpty()) {
            int size = arrayListFindPacketData.size();
            int i9 = 0;
            while (i9 < size) {
                BasePacket basePacket = arrayListFindPacketData.get(i9);
                i9++;
                BasePacket basePacket2 = basePacket;
                if (basePacket2.getType() == 1) {
                    a(device, ParseHelper.convert2Command(basePacket2, null));
                } else {
                    SendDataInfo<?> sendDataInfoA = a(device, basePacket2);
                    if (sendDataInfoA == null) {
                        JL_Log.w(this.f16289a, "addRecvData", "Not found cache send data. " + basePacket2);
                    } else {
                        CommandBase<?, ?> commandBaseConvert2Command = ParseHelper.convert2Command(basePacket2, b(device, basePacket2));
                        if (commandBaseConvert2Command == null) {
                            a(sendDataInfoA, OTAError.buildError(ErrorCode.SUB_ERR_PARSE_DATA).setOpCode(basePacket2.getOpCode()));
                        } else {
                            a(device, commandBaseConvert2Command);
                            sendDataInfoA.setCommand(commandBaseConvert2Command);
                            a(sendDataInfoA);
                        }
                        this.f16294f.remove(sendDataInfoA);
                        this.f16296h.removeMessages(d(sendDataInfoA));
                        a(device, basePacket2.getOpCode(), basePacket2.getOpCodeSn());
                    }
                }
            }
            return;
        }
        JL_Log.w(this.f16289a, "addRecvData", "Not found Command. data : " + CHexConver.byte2HexStr(data));
    }

    private CommandBase<?, ?> b(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null) {
            return null;
        }
        return this.f16292d.getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
    }

    private long a() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluetoothDevice bluetoothDevice, int i9, int i10) {
        this.f16292d.removeCommandBase(bluetoothDevice, i9, i10);
    }

    private SendDataInfo<?> a(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (!this.f16294f.isEmpty() && basePacket != null) {
            for (SendDataInfo<?> sendDataInfo : this.f16294f) {
                CommandBase command = sendDataInfo.getCommand();
                if (command != null && command.getId() == basePacket.getOpCode() && command.getOpCodeSn() == basePacket.getOpCodeSn() && BluetoothUtil.deviceEquals(bluetoothDevice, sendDataInfo.getDevice())) {
                    return sendDataInfo;
                }
            }
        }
        return null;
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f16297i.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SendDataInfo<?> sendDataInfo, BaseError baseError) {
        if (sendDataInfo == null) {
            return;
        }
        if (baseError == null) {
            JL_Log.d(this.f16289a, "callError", "error is null");
            return;
        }
        baseError.setOpCode(sendDataInfo.getOpCode()).setCmdSn(sendDataInfo.getSn());
        Object callback = sendDataInfo.getCallback();
        JL_Log.w(this.f16289a, "callError", "device : " + sendDataInfo.getDevice() + ", " + baseError);
        a(new g(this, callback, baseError, sendDataInfo, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CommandCallback commandCallback, BaseError baseError, SendDataInfo sendDataInfo) {
        if (commandCallback != null) {
            commandCallback.onErrCode(baseError);
        }
        OnDataHandlerListener onDataHandlerListener = this.f16291c;
        if (onDataHandlerListener != null) {
            onDataHandlerListener.onRCSPError(sendDataInfo.getDevice(), baseError);
        }
    }

    private <C extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> void a(SendDataInfo<C> sendDataInfo) {
        CommandCallback<C> callback;
        if (sendDataInfo == null || (callback = sendDataInfo.getCallback()) == null) {
            return;
        }
        a(new a(callback, sendDataInfo, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(CommandCallback commandCallback, SendDataInfo sendDataInfo) {
        commandCallback.onCommandResponse(sendDataInfo.getCommand());
    }

    private void a(BluetoothDevice bluetoothDevice, CommandBase<?, ?> commandBase) {
        if (commandBase == null) {
            return;
        }
        JL_Log.d(this.f16289a, "RX", "device : " + bluetoothDevice + ", " + commandBase);
        if (!commandBase.isResponseCmd()) {
            if (commandBase.equals(this.j)) {
                JL_Log.w(this.f16289a, "RX", "Same as the previous command, skip this commands. opCode : " + CommonUtil.formatInt(commandBase.getId()) + ", sn : " + CommonUtil.formatInt(commandBase.getOpCodeSn()));
                return;
            }
            this.j = commandBase;
        }
        OnDataHandlerListener onDataHandlerListener = this.f16291c;
        if (onDataHandlerListener != null) {
            onDataHandlerListener.onReceivedCmd(bluetoothDevice, commandBase);
        }
    }
}
