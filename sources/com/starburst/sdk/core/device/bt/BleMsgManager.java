package com.starburst.sdk.core.device.bt;

import A1.b;
import J6.c;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.a;
import com.starburst.sdk.business.a56;
import com.starburst.sdk.business.b89;
import com.starburst.sdk.common.utils.ByteTools;
import com.starburst.sdk.core.asr.cc;
import com.starburst.sdk.core.device.bt.api.IBtMsgCallback;
import com.starburst.sdk.core.device.bt.api.IOnBtInitStateListener;
import com.starburst.sdk.core.device.bt.entity.BleFileDataAck;
import com.starburst.sdk.core.device.bt.http.StripWidthTestManage;
import com.starburst.sdk.core.ntp.NtpTimeSync;
import com.starburst.sdk.utils.j;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class BleMsgManager {
    public static boolean FEATURE_IS_SYNC_TEXT = false;
    public static final String KEY_BLUETOOTH_DEVICE = "BluetoothDeviceBean";
    private static final String TAG = "BleMsgManager";
    private static boolean isTextSplitNumInited = false;
    public static int sBaseCmdAppDeviceAuth = 79;
    private static BleMsgManager sInstance = null;
    private static int textSplitNum = 48;
    private IBtMsgCallback mIBtMsgCallback;
    private IOnBtInitStateListener mInitStateListener;
    private volatile BluetoothDeviceBean mLastInitTargetDevice;
    private Handler mSendMsgHandle;
    private MsgLooperThread msgLooperThread;
    private ArrayList<byte[]> msgList = new ArrayList<>();
    private int sendInitNum = -1;
    private ArrayList<byte[]> msgSplitList = new ArrayList<>();
    private int msgSendPage = 0;
    private HashMap<Integer, ArrayList<byte[]>> msgSplitMap = new HashMap<>();
    private HashMap<Integer, Integer> splitIdMap = new HashMap<>();
    private HashMap<Integer, ArrayList<byte[]>> msgListMap = new HashMap<>();
    private boolean isSplitSend = false;
    private int msgMtu = 498;
    private int msgId = 0;
    private final int MSG_SEND = 101;
    private final int MSG_CHECKSENDMSG = 102;
    private final int MSG_CHECKSLPITSENDMSG = 105;
    private final int MSG_SENDSPLIT_TIMEOUT = 106;
    private final int MSG_SENDINIT = 107;
    private final int MSG_RESEND = 108;
    private final int INIT_TIMEOUT = 109;
    private int msgInterval = 6;
    public boolean btInitSuccess = false;

    public class MsgLooperThread extends Thread {
        private MsgLooperThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            BleMsgManager.this.mSendMsgHandle = new Handler() { // from class: com.starburst.sdk.core.device.bt.BleMsgManager.MsgLooperThread.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    Bundle data = message.getData();
                    BluetoothDeviceBean bluetoothDeviceBean = data != null ? (BluetoothDeviceBean) data.getSerializable(BleMsgManager.KEY_BLUETOOTH_DEVICE) : null;
                    switch (message.what) {
                        case 101:
                            byte[] bArr = (byte[]) message.obj;
                            if (bArr != null) {
                                j.f(BleMsgManager.TAG, "MSG_SEND---" + ByteTools.byteArrToHex(bArr));
                                if (BleMsgManager.this.mIBtMsgCallback != null) {
                                    BleMsgManager.this.mIBtMsgCallback.toSend(bluetoothDeviceBean, bArr);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 102:
                            if (BleMsgManager.this.msgList.size() > 0) {
                                Message message2 = new Message();
                                message2.what = 101;
                                message2.obj = BleMsgManager.this.msgList.get(0);
                                BleMsgManager.this.mSendMsgHandle.sendMessage(message2);
                                BleMsgManager.this.msgList.remove(0);
                            }
                            j.f(BleMsgManager.TAG, "MSG_CHECKSENDMSG---" + BleMsgManager.this.msgList.size());
                            if (BleMsgManager.this.msgList.size() <= 0) {
                                BleMsgManager.this.mSendMsgHandle.removeMessages(102);
                                return;
                            } else {
                                BleMsgManager.this.mSendMsgHandle.removeMessages(102);
                                BleMsgManager.this.mSendMsgHandle.sendEmptyMessage(102);
                                return;
                            }
                        case 103:
                        case 104:
                        default:
                            return;
                        case 105:
                            BleMsgManager.this.mSendMsgHandle.removeMessages(106);
                            BleMsgManager.this.mSendMsgHandle.sendEmptyMessageDelayed(106, a.f14256r);
                            j.k(BleMsgManager.TAG, "msgInterval---" + BleMsgManager.this.msgInterval + "--size--" + BleMsgManager.this.msgSplitList.size());
                            if (BleMsgManager.this.msgSplitList.size() > 0) {
                                int i9 = -1;
                                while (i9 < BleMsgManager.this.msgSplitList.size() - 1) {
                                    i9++;
                                    if (BleMsgManager.this.mIBtMsgCallback != null) {
                                        BleMsgManager.this.mIBtMsgCallback.toSend(bluetoothDeviceBean, (byte[]) BleMsgManager.this.msgSplitList.get(i9));
                                    }
                                    if (i9 < BleMsgManager.this.msgSplitList.size()) {
                                        try {
                                            Thread.sleep(BleMsgManager.this.msgInterval);
                                        } catch (InterruptedException e9) {
                                            throw new RuntimeException(e9);
                                        }
                                    }
                                }
                                BleMsgManager.this.isSplitSend = false;
                                BleMsgManager.this.msgSplitList.clear();
                                j.f(BleMsgManager.TAG, "msgSendSize---" + (i9 + 1));
                                return;
                            }
                            return;
                        case 106:
                            j.f(BleMsgManager.TAG, "MSG_SENDSPLIT_TIMEOUT");
                            return;
                        case 107:
                            j.f(BleMsgManager.TAG, "---MSG_SENDINIT---" + BleMsgManager.this.btInitSuccess);
                            if (BleMsgManager.this.sendInitNum >= 10) {
                                if (BleMsgManager.this.mInitStateListener != null) {
                                    BleMsgManager.this.mInitStateListener.onFail(BleMsgManager.this.resolveInitCallbackDevice(bluetoothDeviceBean));
                                }
                                j.f(BleMsgManager.TAG, "---init fail---");
                                BleMsgManager.this.mSendMsgHandle.removeMessages(107);
                                BleMsgManager.this.sendInitNum = 0;
                                return;
                            }
                            BleMsgManager.access$608(BleMsgManager.this);
                            int i10 = BleMsgManager.sBaseCmdAppDeviceAuth;
                            if (i10 == 96) {
                                BleMsgManager.this.sendRequestMsgNoEncryption(bluetoothDeviceBean, i10, ByteTools.hexToByteArr("0100"));
                            } else {
                                BleMsgManager.this.sendRequestMsgNoEncryption(bluetoothDeviceBean, i10, ByteTools.hexToByteArr("0000"));
                            }
                            BleMsgManager.this.mSendMsgHandle.removeMessages(107);
                            BleMsgManager.this.mSendMsgHandle.sendEmptyMessageDelayed(107, 1000L);
                            return;
                        case 108:
                            if (BleMsgManager.this.isSplitSend) {
                                return;
                            }
                            int i11 = message.arg1;
                            BleFileDataAck bleFileDataAck = (BleFileDataAck) message.obj;
                            ArrayList<String> ackFlag = bleFileDataAck.getAckFlag();
                            if (!BleMsgManager.this.msgListMap.containsKey(Integer.valueOf(i11))) {
                                cc.a56("resendMsg----没有找到该msgId的数据记录-", i11, BleMsgManager.TAG);
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) BleMsgManager.this.msgListMap.get(Integer.valueOf(i11));
                            j.f(BleMsgManager.TAG, "resendMsg---resendMsgList---");
                            for (int i12 = 0; i12 < ackFlag.size(); i12++) {
                                char[] charArray = ackFlag.get(i12).toCharArray();
                                for (int i13 = 0; i13 < charArray.length; i13++) {
                                    if (Integer.parseInt(charArray[i13] + "") == 0) {
                                        int i14 = (i12 * 8) + i13;
                                        if (arrayList2 != null && i14 < arrayList2.size()) {
                                            j.f(BleMsgManager.TAG, "resendMsg---index---" + i14);
                                            arrayList.add((byte[]) arrayList2.get(i14));
                                        }
                                    }
                                }
                            }
                            j.f(BleMsgManager.TAG, "resendMsg---resendMsgList---" + arrayList2.size());
                            if (arrayList.size() > 0) {
                                BleMsgManager.this.isSplitSend = true;
                                BleMsgManager.this.msgSplitList.addAll(arrayList);
                                BleMsgManager.this.mSendMsgHandle.removeMessages(105);
                                BleMsgManager.this.mSendMsgHandle.sendEmptyMessage(105);
                                return;
                            }
                            j.f(BleMsgManager.TAG, "resendMsg---无需重发--" + BleMsgManager.this.msgSendPage);
                            BleMsgManager.this.sendAckrsp(bluetoothDeviceBean, bleFileDataAck, i11);
                            try {
                                Thread.sleep(3L);
                                BleMsgManager.access$1008(BleMsgManager.this);
                                if (BleMsgManager.this.msgSplitMap.containsKey(Integer.valueOf(BleMsgManager.this.msgSendPage))) {
                                    j.f(BleMsgManager.TAG, "resendMsg---无需重发--111");
                                    BleMsgManager.this.msgSplitList.addAll((Collection) BleMsgManager.this.msgSplitMap.get(Integer.valueOf(BleMsgManager.this.msgSendPage)));
                                    BleMsgManager.this.msgListMap.put((Integer) BleMsgManager.this.splitIdMap.get(Integer.valueOf(BleMsgManager.this.msgSendPage)), (ArrayList) BleMsgManager.this.msgSplitMap.get(Integer.valueOf(BleMsgManager.this.msgSendPage)));
                                    if (BleMsgManager.this.msgSplitList.size() != 0) {
                                        BleMsgManager.this.isSplitSend = true;
                                        BleMsgManager.this.mSendMsgHandle.removeMessages(105);
                                        BleMsgManager.this.mSendMsgHandle.sendEmptyMessage(105);
                                        return;
                                    }
                                    return;
                                }
                                if (StripWidthTestManage.getInstance().isStripWidthTestStart) {
                                    HashMap<Integer, ArrayList<byte[]>> msgSplitNextMap = StripWidthTestManage.getInstance().getMsgSplitNextMap();
                                    j.k(BleMsgManager.TAG, "resendMsg---无需重发--msgSplitNextMap--" + msgSplitNextMap.size());
                                    if (msgSplitNextMap.size() > 0) {
                                        BleMsgManager.this.msgSendPage = 0;
                                        BleMsgManager.this.msgSplitMap.clear();
                                        BleMsgManager.this.msgSplitMap.putAll(msgSplitNextMap);
                                        msgSplitNextMap.clear();
                                        BleMsgManager.this.dosendMsg(StripWidthTestManage.getInstance().getNextId());
                                        StripWidthTestManage.getInstance().readyNext();
                                    } else {
                                        StripWidthTestManage.getInstance().next();
                                    }
                                }
                                BleMsgManager.this.msgListMap.remove(Integer.valueOf(i11));
                                return;
                            } catch (InterruptedException e10) {
                                throw new RuntimeException(e10);
                            }
                        case 109:
                            j.f(BleMsgManager.TAG, "---INIT_TIMEOUT---");
                            if (BleMsgManager.this.mInitStateListener != null) {
                                BleMsgManager.this.mInitStateListener.onFail(BleMsgManager.this.resolveInitCallbackDevice(bluetoothDeviceBean));
                                return;
                            }
                            return;
                    }
                }
            };
            Looper.loop();
        }
    }

    public BleMsgManager() {
        j.f(TAG, "-----BleMsgManager---creat--" + this.msgLooperThread);
        if (this.msgLooperThread == null) {
            MsgLooperThread msgLooperThread = new MsgLooperThread();
            this.msgLooperThread = msgLooperThread;
            msgLooperThread.start();
        }
    }

    public static /* synthetic */ int access$1008(BleMsgManager bleMsgManager) {
        int i9 = bleMsgManager.msgSendPage;
        bleMsgManager.msgSendPage = i9 + 1;
        return i9;
    }

    public static /* synthetic */ int access$608(BleMsgManager bleMsgManager) {
        int i9 = bleMsgManager.sendInitNum;
        bleMsgManager.sendInitNum = i9 + 1;
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dosendMsg(int i9) {
        this.msgSplitList.addAll(this.msgSplitMap.get(Integer.valueOf(this.msgSendPage)));
        this.msgListMap.put(Integer.valueOf(i9), this.msgSplitMap.get(Integer.valueOf(this.msgSendPage)));
        if (this.msgSplitList.size() != 0) {
            this.isSplitSend = true;
            j.f(TAG, "fram-msgSplitList-222-" + this.msgSplitList.size());
            this.mSendMsgHandle.sendEmptyMessage(105);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6, types: [int] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void fillData(byte[] bArr, int i9, HashMap<Integer, ArrayList<byte[]>> map) {
        byte[] bArr2 = bArr;
        int i10 = 0;
        int i11 = 1;
        String str = "--split send--" + bArr2.length;
        String str2 = TAG;
        j.f(TAG, str);
        b89.a56(new StringBuilder("sendFileData----需要分包发送--"), bArr2.length, TAG);
        int i12 = this.msgMtu - 8;
        int deviceMemory = BtMsgReceiverHandler.getInstance().getBleDeviceInfo().getDeviceMemory();
        int length = bArr2.length / deviceMemory;
        if (bArr2.length % deviceMemory != 0) {
            length++;
        }
        new ArrayList();
        j.f(TAG, "start--frame-bytes--groupPage--" + length + "--maxSize--" + deviceMemory);
        int i13 = 0;
        while (i13 < length) {
            int iAddMsgId = addMsgId();
            StringBuffer stringBufferA1 = b.a1(iAddMsgId, i11);
            byte[] bArr3 = new byte[deviceMemory];
            if (bArr2.length % deviceMemory != 0 && i13 == length - 1) {
                bArr3 = new byte[bArr2.length - (i13 * deviceMemory)];
            }
            System.arraycopy(bArr2, i13 * deviceMemory, bArr3, i10, bArr3.length);
            byte[] bArr4 = new byte[i11];
            bArr4[i10] = ByteTools.int2Bytes(i9, i11)[i10];
            byte[] bArrAddBytes = ByteTools.addBytes(bArr4, bArr3);
            j.f(str2, "fram-bytes-pageall-" + bArrAddBytes.length);
            ArrayList<byte[]> arrayList = new ArrayList<>();
            int length2 = bArrAddBytes.length / i12;
            int i14 = length2;
            if (bArrAddBytes.length % i12 != 0 && i13 == length - 1) {
                i14 = length2;
                i14 = length2 + i11;
            }
            i14 = length2;
            j.f(str2, "fram-key--" + i13 + "--frameTotal--" + i14);
            int i15 = 0;
            int length3 = 0;
            ?? r8 = i11;
            while (i15 < i14) {
                String str3 = str2;
                int i16 = i14 - 1;
                int i17 = deviceMemory;
                byte[] bArrAddBytes2 = ByteTools.addBytes(ByteTools.addBytes(ByteTools.hexToByteArr(stringBufferA1.toString()), ByteTools.int2Bytes(i16, r8)), ByteTools.int2Bytes(i15, r8));
                byte[] bArr5 = new byte[i12];
                ?? r18 = r8;
                if (bArrAddBytes.length % i12 != 0 && i15 == i16 && i13 == length - 1) {
                    bArr5 = new byte[bArrAddBytes.length % i12];
                }
                System.arraycopy(bArrAddBytes, length3, bArr5, 0, bArr5.length);
                length3 += bArr5.length;
                arrayList.add(ByteTools.addBytes(bArrAddBytes2, bArr5));
                i15++;
                str2 = str3;
                deviceMemory = i17;
                r8 = r18 == true ? 1 : 0;
            }
            map.put(Integer.valueOf(i13), arrayList);
            this.splitIdMap.put(Integer.valueOf(i13), Integer.valueOf(iAddMsgId));
            i13++;
            bArr2 = bArr;
            i10 = 0;
            str2 = str2;
            deviceMemory = deviceMemory;
            i11 = r8 == true ? 1 : 0;
        }
    }

    private byte[] getHead(int i9) {
        byte[] bArr = {0, (byte) (i9 & 255), 0};
        String[] strArrSplit = new SimpleDateFormat("yy-MM-dd-HH-mm-ss").format(Long.valueOf(NtpTimeSync.getAdjustedTime())).split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return ByteTools.concatAll(bArr, new byte[]{(byte) (Integer.parseInt(strArrSplit[0]) & 255), (byte) (Integer.parseInt(strArrSplit[1]) & 255), (byte) (Integer.parseInt(strArrSplit[2]) & 255), (byte) (Integer.parseInt(strArrSplit[3]) & 255), (byte) (Integer.parseInt(strArrSplit[4]) & 255), (byte) (Integer.parseInt(strArrSplit[5]) & 255)});
    }

    public static BleMsgManager getInstance() {
        if (sInstance == null) {
            synchronized (BleMsgManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new BleMsgManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluetoothDeviceBean resolveInitCallbackDevice(BluetoothDeviceBean bluetoothDeviceBean) {
        if (bluetoothDeviceBean != null) {
            return bluetoothDeviceBean;
        }
        return this.mLastInitTargetDevice != null ? this.mLastInitTargetDevice : ConnectedDeviceManager.getInstance().getMasterDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAckrsp(BluetoothDeviceBean bluetoothDeviceBean, BleFileDataAck bleFileDataAck, int i9) {
        j.k(TAG, "sendAckrsp--");
        StringBuffer stringBuffer = new StringBuffer("11");
        stringBuffer.append(bleFileDataAck.getAckSeq());
        sendAnswerMsgNoEncryption(bluetoothDeviceBean, 255, i9, ByteTools.addBytes(ByteTools.little_intToByte(bleFileDataAck.getAckCmdType(), 1), new byte[]{ByteTools.bitToByte(stringBuffer.substring(8, 16)), ByteTools.bitToByte(stringBuffer.substring(0, 8))}));
    }

    private synchronized void synchronizedMsgToDevice2_2(int i9, int i10, int i11, boolean z8, int i12, int i13, String str) {
        j.f(TAG, "enableCang--" + c.f().d() + "--" + str);
        if (c.f().d()) {
            byte[] bArrLittle_intToByte = ByteTools.little_intToByte(i10, 2);
            byte[] bytes = str.getBytes();
            com.starburst.sdk.core.asr.b89.a56(this, 75, ByteTools.concatAll(getHead(2), ByteTools.concatAll(new byte[]{(byte) (i9 & 255)}, ByteTools.little_intToByte(i11, 2)), new byte[]{z8 ? (byte) 1 : (byte) 0}, new byte[]{(byte) (i12 & 255)}, new byte[]{(byte) (i13 & 255)}, bArrLittle_intToByte, ByteTools.little_intToByte(bytes.length, 2), bytes));
        }
    }

    public int addMsgId() {
        int i9 = this.msgId + 1;
        this.msgId = i9;
        if (i9 > 65535) {
            this.msgId = 0;
        }
        return this.msgId;
    }

    public void closeAllTask() {
        this.btInitSuccess = false;
        this.sendInitNum = 0;
        sBaseCmdAppDeviceAuth = 79;
        this.msgId = 0;
        this.msgList.clear();
        this.msgListMap.clear();
        this.msgSplitList.clear();
        this.isSplitSend = false;
        Handler handler = this.mSendMsgHandle;
        if (handler == null) {
            return;
        }
        handler.removeMessages(101);
        this.mSendMsgHandle.removeMessages(105);
        this.mSendMsgHandle.removeMessages(102);
        this.mSendMsgHandle.removeCallbacksAndMessages(null);
    }

    public void continueSendMsg() {
        j.f(TAG, "continueSendMsg----");
        if (this.msgList.size() > 0) {
            this.mSendMsgHandle.removeMessages(102);
            this.mSendMsgHandle.sendEmptyMessage(102);
        }
    }

    public void getDeviceInit(BluetoothDeviceBean bluetoothDeviceBean) {
        this.mLastInitTargetDevice = bluetoothDeviceBean;
        getInstance().sendRequestMsgNoEncryption2(bluetoothDeviceBean, sBaseCmdAppDeviceAuth, ByteTools.hexToByteArr("F10000"));
        this.mSendMsgHandle.removeMessages(109);
        Message messageObtainMessage = this.mSendMsgHandle.obtainMessage(107);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_BLUETOOTH_DEVICE, bluetoothDeviceBean);
        messageObtainMessage.setData(bundle);
        this.mSendMsgHandle.sendMessageDelayed(messageObtainMessage, 6000L);
    }

    public int getMsgMtu() {
        b89.a56(new StringBuilder("BleMsgManager getMsgMtu---"), this.msgMtu, TAG);
        return this.msgMtu;
    }

    public void init(IBtMsgCallback iBtMsgCallback) {
        j.f(TAG, "-----BleMsgManager---init--" + this.msgLooperThread);
        if (this.msgLooperThread == null) {
            MsgLooperThread msgLooperThread = new MsgLooperThread();
            this.msgLooperThread = msgLooperThread;
            msgLooperThread.start();
        }
        this.mIBtMsgCallback = iBtMsgCallback;
    }

    public void initSuccess(BluetoothDeviceBean bluetoothDeviceBean) {
        IOnBtInitStateListener iOnBtInitStateListener = this.mInitStateListener;
        if (iOnBtInitStateListener != null) {
            iOnBtInitStateListener.onSuccess(resolveInitCallbackDevice(bluetoothDeviceBean));
        }
        j.f(TAG, "---init success---");
        this.btInitSuccess = true;
        this.mSendMsgHandle.removeMessages(107);
        this.sendInitNum = 0;
    }

    public synchronized void initTextSplitNum() {
        if (!isTextSplitNumInited) {
            isTextSplitNumInited = true;
            textSplitNum = (getMsgMtu() - 24) / 3;
            StringBuilder sb = new StringBuilder("initTextSplitNum Mtu is ");
            sb.append(getMsgMtu());
            sb.append("textSplitNum is ");
            b89.a56(sb, textSplitNum, TAG);
        }
    }

    public void resendMsg(int i9, ArrayList<String> arrayList, BleFileDataAck bleFileDataAck) {
        j.f(TAG, "resendMsg----" + arrayList.toString() + "--isSplitSend--" + this.isSplitSend + "--msgId--" + i9);
        Message message = new Message();
        message.obj = bleFileDataAck;
        message.arg1 = i9;
        message.what = 108;
        this.mSendMsgHandle.sendMessage(message);
    }

    public void sendAnswerMsgNoEncryption(BluetoothDeviceBean bluetoothDeviceBean, int i9, int i10, byte[] bArr) {
        int i11;
        if (i9 == 79 || i9 == 96 || this.btInitSuccess) {
            StringBuilder sb = new StringBuilder("sendAnswerMsgNoEncryption--cmdType-222--");
            sb.append(ByteTools.byteArrToHex(ByteTools.int2Bytes(i9, 1)));
            sb.append("--msg--");
            b89.a56(sb, bArr.length, TAG);
            int length = bArr.length;
            int i12 = this.msgMtu;
            if (length < i12 - 6) {
                byte[] bArrHexToByteArr = ByteTools.hexToByteArr(b.a1(i10, false).toString());
                if (i9 != -1) {
                    bArrHexToByteArr = ByteTools.addBytes(bArrHexToByteArr, ByteTools.little_intToByte(i9, 1));
                }
                byte[] bArrAddBytes = ByteTools.addBytes(bArrHexToByteArr, bArr);
                if (i9 == 255) {
                    j.f(TAG, "ack--send--" + ByteTools.byteArrToHex(bArrAddBytes));
                    IBtMsgCallback iBtMsgCallback = this.mIBtMsgCallback;
                    if (iBtMsgCallback != null) {
                        iBtMsgCallback.toSend(bluetoothDeviceBean, bArrAddBytes);
                        return;
                    }
                    return;
                }
                StringBuilder sb2 = new StringBuilder("sendAnswerMsgNoEncryption--无需分包--send--");
                sb2.append(bArrAddBytes.length > 100 ? Integer.valueOf(bArrAddBytes.length) : ByteTools.byteArrToHex(bArrAddBytes));
                j.f(TAG, sb2.toString());
                this.msgList.add(bArrAddBytes);
                j.f(TAG, "msgList---" + this.msgList.size());
                if (this.msgList.size() != 0) {
                    this.mSendMsgHandle.removeMessages(102);
                    this.mSendMsgHandle.sendEmptyMessage(102);
                    return;
                }
                return;
            }
            int i13 = i12 - 8;
            int i14 = i12 - 9;
            int length2 = bArr.length - i14;
            int i15 = length2 / i13;
            int i16 = i15 + 1;
            int i17 = length2 % i13;
            if (i17 != 0) {
                i16 = i15 + 2;
            }
            j.f(TAG, "frameTotal---" + i16);
            byte[] bArrHexToByteArr2 = ByteTools.hexToByteArr(b.a1(i10, true).toString());
            ArrayList<byte[]> arrayList = new ArrayList<>();
            int i18 = 0;
            int length3 = 0;
            while (i18 < i16) {
                int i19 = i16 - 1;
                byte[] bArrAddBytes2 = ByteTools.addBytes(ByteTools.addBytes(bArrHexToByteArr2, ByteTools.int2Bytes(i19, 1)), ByteTools.int2Bytes(i18, 1));
                byte[] bArr2 = new byte[i13];
                if (i18 == 0) {
                    bArr2 = new byte[i14];
                    i11 = i14;
                    if (i9 != -1) {
                        bArrAddBytes2 = ByteTools.addBytes(bArrAddBytes2, ByteTools.int2Bytes(i9, 1));
                    }
                } else {
                    i11 = i14;
                }
                if (i17 != 0 && i18 == i19) {
                    bArr2 = new byte[i17];
                }
                System.arraycopy(bArr, length3, bArr2, 0, bArr2.length);
                length3 += bArr2.length;
                byte[] bArrAddBytes3 = ByteTools.addBytes(bArrAddBytes2, bArr2);
                j.f(TAG, "splitMsgData----" + bArrAddBytes3.length);
                arrayList.add(bArrAddBytes3);
                this.msgSplitList.add(bArrAddBytes3);
                i18++;
                i14 = i11;
            }
            this.msgListMap.put(Integer.valueOf(i10), arrayList);
            j.f(TAG, "msgSplitList---" + this.msgSplitList.size() + "--mFileTransmissionState--");
            if (this.msgSplitList.size() != 0) {
                this.isSplitSend = true;
                this.mSendMsgHandle.removeMessages(105);
                this.mSendMsgHandle.sendEmptyMessage(105);
            }
        }
    }

    public void sendDeviceInit(IOnBtInitStateListener iOnBtInitStateListener) {
        this.mInitStateListener = iOnBtInitStateListener;
    }

    public void sendInit(BluetoothDeviceBean bluetoothDeviceBean) {
        this.mLastInitTargetDevice = bluetoothDeviceBean;
        this.mSendMsgHandle.removeMessages(109);
        this.mSendMsgHandle.removeMessages(107);
        Message messageObtainMessage = this.mSendMsgHandle.obtainMessage(107);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_BLUETOOTH_DEVICE, bluetoothDeviceBean);
        messageObtainMessage.setData(bundle);
        this.mSendMsgHandle.sendMessage(messageObtainMessage);
    }

    public void sendRequestMsgNoEncryption(BluetoothDeviceBean bluetoothDeviceBean, int i9, int i10, byte[] bArr) {
        if (i9 == 79 || i9 == 96 || this.btInitSuccess) {
            j.f(TAG, "sendRequestMsgNoEncryption--with datatype---cmdType-222--" + ByteTools.byteArrToHex(ByteTools.int2Bytes(i9, 1)) + "--msg--" + bArr.length);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(ByteTools.byteArrToHex(ByteTools.little_intToByte(i10, 1)));
            stringBuffer.append(ByteTools.byteArrToHex(bArr));
            sendRequestMsgNoEncryption(bluetoothDeviceBean, i9, ByteTools.hexToByteArr(stringBuffer.toString()));
        }
    }

    public synchronized void sendRequestMsgNoEncryption2(BluetoothDeviceBean bluetoothDeviceBean, int i9, byte[] bArr) {
        if (i9 != 79 && i9 != 96) {
            if (!this.btInitSuccess) {
                return;
            }
        }
        int i10 = this.msgId + 1;
        this.msgId = i10;
        if (i10 > 65535) {
            this.msgId = 0;
        }
        StringBuilder sb = new StringBuilder("sendRequestMsgNoEncryption--cmdType-222--");
        sb.append(ByteTools.byteArrToHex(ByteTools.int2Bytes(i9, 1)));
        sb.append("--msg--");
        b89.a56(sb, bArr.length, TAG);
        if (bArr.length < this.msgMtu - 6) {
            byte[] bArrAddBytes = ByteTools.addBytes(ByteTools.addBytes(ByteTools.hexToByteArr(b.a1(this.msgId, false).toString()), ByteTools.little_intToByte(i9, 1)), bArr);
            StringBuilder sb2 = new StringBuilder("sendRequestMsgNoEncryption--无需分包--send--");
            sb2.append(bArrAddBytes.length > 100 ? Integer.valueOf(bArrAddBytes.length) : ByteTools.byteArrToHex(bArrAddBytes));
            j.f(TAG, sb2.toString());
            this.msgList.add(bArrAddBytes);
            j.f(TAG, "msgList---" + this.msgList.size() + "--mFileTransmissionState--");
            if (this.msgList.size() != 0) {
                this.mSendMsgHandle.removeMessages(102);
                this.mSendMsgHandle.sendEmptyMessage(102);
            }
        } else {
            this.msgSplitMap.clear();
            this.splitIdMap.clear();
            this.msgSendPage = 0;
            fillData(bArr, i9, this.msgSplitMap);
            dosendMsg(this.splitIdMap.containsKey(Integer.valueOf(this.msgSendPage)) ? this.splitIdMap.get(Integer.valueOf(this.msgSendPage)).intValue() : this.msgId);
        }
    }

    public void setMsgInterval(int i9) {
        this.msgInterval = i9;
    }

    public void setMsgMtu(int i9) {
        cc.a56("BleMsgManager setMsgMtu---", i9, TAG);
        if (i9 > 515) {
            i9 = 515;
        }
        this.msgMtu = i9;
    }

    public synchronized void synchronizedMsgToDevice0(String str, int i9, boolean z8, int i10, int i11, int i12) throws Throwable {
        Throwable th;
        String strSubstring;
        try {
            try {
                initTextSplitNum();
                if (!c.f().d()) {
                    return;
                }
                try {
                    if (str.length() <= textSplitNum) {
                        synchronizedMsgToDevice0_2(str, i9, z8, i10, i11, i12);
                    } else {
                        int length = str.length() / textSplitNum;
                        if (str.length() % textSplitNum != 0) {
                            length++;
                        }
                        int i13 = length;
                        for (int i14 = 0; i14 < i13; i14++) {
                            int length2 = str.length();
                            int i15 = textSplitNum;
                            if (length2 % i15 == 0 || i14 != i13 - 1) {
                                strSubstring = str.substring(i14 * i15, (i14 + 1) * i15);
                            } else {
                                int i16 = i15 * i14;
                                strSubstring = str.substring(i16, (str.length() % textSplitNum) + i16);
                            }
                            String str2 = strSubstring;
                            a56.a56("synchronizedMsgToDevice0--", str2, TAG);
                            int i17 = i9;
                            boolean z9 = z8;
                            int i18 = i10;
                            synchronizedMsgToDevice0_2(str2, i17, z9, i18, i14, i13);
                            i9 = i17;
                            z8 = z9;
                            i10 = i18;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
        }
        throw th;
    }

    public synchronized void synchronizedMsgToDevice0_2(String str, int i9, boolean z8, int i10, int i11, int i12) {
        j.f(TAG, "enableCang--" + c.f().d() + "--" + str);
        if (c.f().d()) {
            byte[] bArrLittle_intToByte = ByteTools.little_intToByte(i9, 2);
            byte[] bytes = str.getBytes();
            com.starburst.sdk.core.asr.b89.a56(this, 75, ByteTools.concatAll(getHead(0), new byte[]{0}, ByteTools.little_intToByte(i10, 2), new byte[]{z8 ? (byte) 1 : (byte) 0}, new byte[]{(byte) (i11 & 255)}, new byte[]{(byte) (i12 & 255)}, bArrLittle_intToByte, ByteTools.little_intToByte(bytes.length, 2), bytes));
        }
    }

    public synchronized void synchronizedMsgToDevice1(boolean z8, String str, boolean z9, int i9, int i10, int i11) {
        String strSubstring;
        try {
            initTextSplitNum();
            if (c.f().d()) {
                if (!TextUtils.isEmpty(str) || z9) {
                    if (str == null) {
                        str = "";
                    }
                    String str2 = str;
                    if (str2.length() < textSplitNum) {
                        synchronizedMsgToDevice1_2(z8, str2, z9, i9, i10, i11);
                    } else {
                        int length = str2.length() / textSplitNum;
                        if (str2.length() % textSplitNum != 0) {
                            length++;
                        }
                        int i12 = length;
                        for (int i13 = 0; i13 < i12; i13++) {
                            int length2 = str2.length();
                            int i14 = textSplitNum;
                            if (length2 % i14 == 0 || i13 != i12 - 1) {
                                strSubstring = str2.substring(i13 * i14, (i13 + 1) * i14);
                            } else {
                                int i15 = i14 * i13;
                                strSubstring = str2.substring(i15, (str2.length() % textSplitNum) + i15);
                            }
                            String str3 = strSubstring;
                            a56.a56("synchronizedMsgToDevice1--", str3, TAG);
                            synchronizedMsgToDevice1_2(z8, str3, z9, i9, i13, i12);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void synchronizedMsgToDevice1_2(boolean z8, String str, boolean z9, int i9, int i10, int i11) {
        j.f(TAG, "enableCang--" + c.f().d() + "--" + str);
        if (c.f().d()) {
            byte[] bArrLittle_intToByte = ByteTools.little_intToByte(0, 2);
            byte[] bytes = str.getBytes();
            com.starburst.sdk.core.asr.b89.a56(this, 75, ByteTools.concatAll(getHead(1), new byte[]{!z8 ? 1 : 0}, ByteTools.little_intToByte(i9, 2), new byte[]{z9 ? (byte) 1 : (byte) 0}, new byte[]{(byte) (i10 & 255)}, new byte[]{(byte) (i11 & 255)}, bArrLittle_intToByte, ByteTools.little_intToByte(bytes.length, 2), bytes));
        }
    }

    public synchronized void synchronizedMsgToDevice2(int i9, int i10, int i11, boolean z8, int i12, int i13, String str) {
        String strSubstring;
        try {
            initTextSplitNum();
            if (c.f().d()) {
                if (!TextUtils.isEmpty(str) || z8) {
                    String str2 = str == null ? "" : str;
                    if (str2.length() < textSplitNum) {
                        synchronizedMsgToDevice2_2(i9, i10, i11, z8, i12, i13, str2);
                    } else {
                        int length = str2.length() / textSplitNum;
                        if (str2.length() % textSplitNum != 0) {
                            length++;
                        }
                        int i14 = length;
                        for (int i15 = 0; i15 < i14; i15++) {
                            int length2 = str2.length();
                            int i16 = textSplitNum;
                            if (length2 % i16 == 0 || i15 != i14 - 1) {
                                strSubstring = str2.substring(i15 * i16, (i15 + 1) * i16);
                            } else {
                                int i17 = i16 * i15;
                                strSubstring = str2.substring(i17, (str2.length() % textSplitNum) + i17);
                            }
                            a56.a56("synchronizedMsgToDevice2--", strSubstring, TAG);
                            synchronizedMsgToDevice2_2(i9, i10, i11, z8, i15, i14, strSubstring);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void synchronizedMsgToDevice3(String str, int i9, boolean z8, int i10, int i11, int i12) throws Throwable {
        Throwable th;
        String strSubstring;
        try {
            try {
                initTextSplitNum();
                if (!c.f().d()) {
                    return;
                }
                try {
                    if (str.length() <= textSplitNum) {
                        synchronizedMsgToDevice3_2(str, i9, z8, i10, i11, i12);
                        j.f(TAG, "synchronizedMsgToDevice3--".concat(str));
                    } else {
                        int length = str.length() / textSplitNum;
                        if (str.length() % textSplitNum != 0) {
                            length++;
                        }
                        int i13 = length;
                        for (int i14 = 0; i14 < i13; i14++) {
                            int length2 = str.length();
                            int i15 = textSplitNum;
                            if (length2 % i15 == 0 || i14 != i13 - 1) {
                                strSubstring = str.substring(i14 * i15, (i14 + 1) * i15);
                            } else {
                                int i16 = i15 * i14;
                                strSubstring = str.substring(i16, (str.length() % textSplitNum) + i16);
                            }
                            String str2 = strSubstring;
                            a56.a56("synchronizedMsgToDevice3--", str2, TAG);
                            int i17 = i9;
                            boolean z9 = z8;
                            int i18 = i10;
                            synchronizedMsgToDevice3_2(str2, i17, z9, i18, i14, i13);
                            i9 = i17;
                            z8 = z9;
                            i10 = i18;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
        }
        throw th;
    }

    public synchronized void synchronizedMsgToDevice3_2(String str, int i9, boolean z8, int i10, int i11, int i12) {
        j.f(TAG, "enableCang--" + c.f().d() + "--" + str);
        if (c.f().d()) {
            byte[] bArrLittle_intToByte = ByteTools.little_intToByte(i9, 2);
            byte[] bytes = str.getBytes();
            com.starburst.sdk.core.asr.b89.a56(this, 75, ByteTools.concatAll(getHead(3), new byte[]{0}, ByteTools.little_intToByte(i10, 2), new byte[]{z8 ? (byte) 1 : (byte) 0}, new byte[]{(byte) (i11 & 255)}, new byte[]{(byte) (i12 & 255)}, bArrLittle_intToByte, ByteTools.little_intToByte(bytes.length, 2), bytes));
        }
    }

    public synchronized void sendRequestMsgNoEncryption(BluetoothDeviceBean bluetoothDeviceBean, int i9, byte[] bArr) {
        j.f(TAG, "sendRequestMsgNoEncryption--btInitState--" + this.btInitSuccess);
        if (i9 == 79 || i9 == 96 || this.btInitSuccess) {
            addMsgId();
            StringBuilder sb = new StringBuilder("sendRequestMsgNoEncryption--cmdType-222--");
            sb.append(ByteTools.byteArrToHex(ByteTools.int2Bytes(i9, 1)));
            sb.append("--msg--");
            b89.a56(sb, bArr.length, TAG);
            if (bArr.length < this.msgMtu - 6) {
                byte[] bArrAddBytes = ByteTools.addBytes(ByteTools.addBytes(ByteTools.hexToByteArr(b.a1(this.msgId, false).toString()), ByteTools.little_intToByte(i9, 1)), bArr);
                StringBuilder sb2 = new StringBuilder("sendRequestMsgNoEncryption--无需分包--send--");
                sb2.append(bArrAddBytes.length > 100 ? Integer.valueOf(bArrAddBytes.length) : ByteTools.byteArrToHex(bArrAddBytes));
                j.f(TAG, sb2.toString());
                this.msgList.add(bArrAddBytes);
                j.f(TAG, "msgList---" + this.msgList.size() + "--mFileTransmissionState--");
                if (this.msgList.size() != 0) {
                    this.mSendMsgHandle.removeMessages(102);
                    this.mSendMsgHandle.sendEmptyMessage(102);
                }
                if (i9 == 127 && bArr[0] == 0) {
                    byte b9 = bArr[1];
                }
            } else {
                b89.a56(new StringBuilder("--split send--"), bArr.length, TAG);
                int length = bArr.length;
                int i10 = this.msgMtu;
                int i11 = i10 - 8;
                int i12 = i10 - 9;
                int i13 = length - i12;
                int i14 = i13 / i11;
                int i15 = i14 + 1;
                int i16 = i13 % i11;
                if (i16 != 0) {
                    i15 = i14 + 2;
                }
                cc.a56("frameTotal---", i15, TAG);
                byte[] bArrHexToByteArr = ByteTools.hexToByteArr(b.a1(this.msgId, true).toString());
                ArrayList<byte[]> arrayList = new ArrayList<>();
                int length2 = 0;
                for (int i17 = 0; i17 < i15; i17++) {
                    int i18 = i15 - 1;
                    byte[] bArrAddBytes2 = ByteTools.addBytes(ByteTools.addBytes(bArrHexToByteArr, ByteTools.int2Bytes(i18, 1)), ByteTools.int2Bytes(i17, 1));
                    byte[] bArr2 = new byte[i11];
                    if (i17 == 0) {
                        bArr2 = new byte[i12];
                        bArrAddBytes2 = ByteTools.addBytes(bArrAddBytes2, ByteTools.int2Bytes(i9, 1));
                    }
                    if (i16 != 0 && i17 == i18) {
                        bArr2 = new byte[i16];
                    }
                    System.arraycopy(bArr, length2, bArr2, 0, bArr2.length);
                    length2 += bArr2.length;
                    byte[] bArrAddBytes3 = ByteTools.addBytes(bArrAddBytes2, bArr2);
                    j.f(TAG, "splitMsgData----len-" + bArrAddBytes3.length);
                    arrayList.add(bArrAddBytes3);
                    this.msgSplitList.add(bArrAddBytes3);
                }
                this.msgListMap.put(Integer.valueOf(this.msgId), arrayList);
                j.f(TAG, "msgSplitList---" + this.msgSplitList.size() + "--mFileTransmissionState--");
                if (this.msgSplitList.size() != 0) {
                    this.isSplitSend = true;
                    this.mSendMsgHandle.removeMessages(105);
                    this.mSendMsgHandle.sendEmptyMessage(105);
                }
            }
        }
    }
}
