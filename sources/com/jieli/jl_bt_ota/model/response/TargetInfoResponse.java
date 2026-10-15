package com.jieli.jl_bt_ota.model.response;

import A.a;
import android.bluetooth.BluetoothAdapter;
import com.jieli.jl_bt_ota.interfaces.command.IDataOp;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.base.LtvBean;
import com.jieli.jl_bt_ota.model.response.device.BleInfo;
import com.jieli.jl_bt_ota.model.response.device.ClassicBtInfo;
import com.jieli.jl_bt_ota.model.response.device.ExpandFunc;
import com.jieli.jl_bt_ota.model.response.device.FunctionConfiguration;
import com.jieli.jl_bt_ota.model.response.device.OTASettings;
import com.jieli.jl_bt_ota.model.response.device.OTAState;
import com.jieli.jl_bt_ota.model.response.device.ProductInfo;
import com.jieli.jl_bt_ota.model.response.device.ProtocolMTU;
import com.jieli.jl_bt_ota.model.response.device.ProtocolVersion;
import com.jieli.jl_bt_ota.model.response.device.SystemInfo;
import com.jieli.jl_bt_ota.model.response.device.Version;
import com.jieli.jl_bt_ota.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class TargetInfoResponse extends CommonResponse implements IDataOp {
    private int allowConnectFlag;
    private String authKey;
    private String customVersionMsg;
    private String projectCode;
    private int sdkType;
    public final ProtocolVersion protocolVersion = new ProtocolVersion();
    public final SystemInfo systemInfo = new SystemInfo();
    public final ClassicBtInfo classicBtInfo = new ClassicBtInfo();
    public final FunctionConfiguration functionConfiguration = new FunctionConfiguration();
    public final Version version = new Version();
    public final Version uBootVersion = new Version();
    public final OTASettings otaSettings = new OTASettings();
    public final OTAState otaState = new OTAState();
    public final ProductInfo productInfo = new ProductInfo();
    public final ProtocolMTU protocolMtu = new ProtocolMTU();
    public final BleInfo bleInfo = new BleInfo();
    public final ExpandFunc expandFunc = new ExpandFunc();

    private static byte[] stringToData(String str) {
        return str == null ? new byte[0] : str.getBytes();
    }

    public int getAllowConnectFlag() {
        return this.allowConnectFlag;
    }

    public String getAuthKey() {
        return this.authKey;
    }

    public String getBleAddr() {
        return this.bleInfo.getBleAddr();
    }

    public int getCurFunction() {
        return this.functionConfiguration.getCurFunction();
    }

    public String getCustomVersionMsg() {
        return this.customVersionMsg;
    }

    public String getEdrAddr() {
        return this.classicBtInfo.getEdrAddr();
    }

    public int getEdrProfile() {
        return this.classicBtInfo.getEdrProfile();
    }

    public int getEdrStatus() {
        return this.classicBtInfo.getEdrStatus();
    }

    public int getExpandMode() {
        return this.otaState.getExpandMode();
    }

    public int getFunctionMask() {
        return this.functionConfiguration.getFunctionMask();
    }

    public int getLowPowerLimit() {
        return this.systemInfo.getLowPowerLimit();
    }

    public int getMandatoryUpgradeFlag() {
        return this.otaState.getMandatoryUpgradeFlag();
    }

    public int getMaxVol() {
        return this.systemInfo.getMaxVol();
    }

    public int getPid() {
        return this.productInfo.getPid();
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public String getProtocolVersion() {
        return this.protocolVersion.getVersionName();
    }

    public int getQuantity() {
        return this.systemInfo.getQuantity();
    }

    public int getReceiveMtu() {
        return this.protocolMtu.getReceiveMtu();
    }

    public int getRequestOtaFlag() {
        return this.otaState.getRequestOtaFlag();
    }

    public int getSdkType() {
        return this.sdkType;
    }

    public int getSendMtu() {
        return this.protocolMtu.getSendMtu();
    }

    public int getSingleBackupOtaWay() {
        return this.otaSettings.getSingleBackupOtaWay();
    }

    public int getUbootVersionCode() {
        return this.uBootVersion.getVersionCode();
    }

    public String getUbootVersionName() {
        return this.uBootVersion.getVersionName();
    }

    public int getUid() {
        return this.productInfo.getUid();
    }

    public int getVersionCode() {
        return this.version.getVersionCode();
    }

    public String getVersionName() {
        return this.version.getVersionName();
    }

    public int getVid() {
        return this.productInfo.getVid();
    }

    public int getVolume() {
        return this.systemInfo.getVolume();
    }

    public boolean isBLEToSppWay() {
        return this.bleInfo.isBLEToSppWay();
    }

    public boolean isBanEq() {
        return this.expandFunc.isBanEq();
    }

    public boolean isBleOnly() {
        return this.bleInfo.isBleOnly();
    }

    public boolean isGameMode() {
        return this.expandFunc.isGameMode();
    }

    public boolean isHideNetRadio() {
        return this.functionConfiguration.isHideNetRadio();
    }

    public boolean isMandatoryUpgrade() {
        return getMandatoryUpgradeFlag() == 1;
    }

    public boolean isNeedBootLoader() {
        return this.otaSettings.isNeedBootLoader();
    }

    public boolean isSupportAdaptiveANC() {
        return this.expandFunc.isSupportAdaptiveANC();
    }

    public boolean isSupportAnc() {
        return this.expandFunc.isSupportAnc();
    }

    public boolean isSupportDevConfigure() {
        return this.expandFunc.isSupportDevConfigure();
    }

    public boolean isSupportDoubleBackup() {
        return this.otaSettings.isSupportDoubleBackup();
    }

    public boolean isSupportDoubleConnection() {
        return this.expandFunc.isSupportDoubleConnection();
    }

    public boolean isSupportExternalFlashTransfer() {
        return this.expandFunc.isSupportExternalFlashTransfer();
    }

    public boolean isSupportHearingAssist() {
        return this.expandFunc.isSupportHearingAssist();
    }

    public boolean isSupportMD5() {
        return this.expandFunc.isSupportMD5();
    }

    public boolean isSupportOfflineShow() {
        return this.functionConfiguration.isSupportOfflineShow();
    }

    public boolean isSupportReadErrorMSg() {
        return this.expandFunc.isSupportReadErrorMSg();
    }

    public boolean isSupportReuseSpaceOTA() {
        return this.otaSettings.isSupportReuseSpaceOTA();
    }

    public boolean isSupportSceneDenoising() {
        return this.expandFunc.isSupportSceneDenoising();
    }

    public boolean isSupportSd0() {
        return this.functionConfiguration.isSupportSd0();
    }

    public boolean isSupportSd1() {
        return this.functionConfiguration.isSupportSd1();
    }

    public boolean isSupportSearchDevice() {
        return this.expandFunc.isSupportSearchDevice();
    }

    public boolean isSupportSmartNoPick() {
        return this.expandFunc.isSupportSmartNoPick();
    }

    public boolean isSupportSoundCard() {
        return this.expandFunc.isSupportSoundCard();
    }

    public boolean isSupportUsb() {
        return this.functionConfiguration.isSupportUsb();
    }

    public boolean isSupportVocalBooster() {
        return this.expandFunc.isSupportVocalBooster();
    }

    public boolean isSupportVolumeSync() {
        return this.systemInfo.isSupportVolumeSync();
    }

    public boolean isSupportWindNoiseDetection() {
        return this.expandFunc.isSupportWindNoiseDetection();
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        for (LtvBean ltvBean : LtvBean.parseLTVData(bArr)) {
            byte[] data = ltvBean.getData();
            int type = ltvBean.getType();
            if (type != 0) {
                boolean z8 = true;
                if (type == 1) {
                    this.systemInfo.parse(data);
                } else if (type == 2) {
                    this.classicBtInfo.parse(data);
                } else if (type == 17) {
                    this.bleInfo.parse(data);
                } else if (type == 19) {
                    this.expandFunc.parse(data);
                } else if (type != 31) {
                    switch (type) {
                        case 4:
                            this.functionConfiguration.parse(data);
                            break;
                        case 5:
                            this.version.parse(data);
                            break;
                        case 6:
                            if (data != null && data.length != 0) {
                                setSdkType(CHexConver.byteToInt(data[0]));
                                if (!isSupportVolumeSync()) {
                                    SystemInfo systemInfo = this.systemInfo;
                                    if (getSdkType() != 2 && getSdkType() != 4) {
                                        z8 = false;
                                    }
                                    systemInfo.setSupportVolumeSync(z8);
                                }
                            }
                            break;
                        case 7:
                            this.uBootVersion.parse(data);
                            break;
                        case 8:
                            this.otaSettings.parse(data);
                            break;
                        case 9:
                            this.otaState.parse(data);
                            break;
                        case 10:
                            this.productInfo.parse(data);
                            break;
                        case 11:
                            if (data != null) {
                                try {
                                    setAuthKey(new String(data));
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                }
                            }
                            break;
                        case 12:
                            if (data != null) {
                                try {
                                    setProjectCode(new String(data));
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                            break;
                        case 13:
                            this.protocolMtu.parse(data);
                            break;
                        case 14:
                            if (data != null && data.length != 0) {
                                setAllowConnectFlag(CHexConver.byteToInt(data[0]));
                            }
                            break;
                    }
                } else if (data != null) {
                    try {
                        setCustomVersionMsg(new String(data));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            } else {
                this.protocolVersion.parse(data);
            }
        }
        return bArr.length;
    }

    public TargetInfoResponse setAllowConnectFlag(int i9) {
        this.allowConnectFlag = i9;
        return this;
    }

    public TargetInfoResponse setAuthKey(String str) {
        this.authKey = str;
        return this;
    }

    public TargetInfoResponse setCurFunction(int i9) {
        this.functionConfiguration.setCurFunction(i9);
        return this;
    }

    public TargetInfoResponse setCustomVersionMsg(String str) {
        this.customVersionMsg = str;
        return this;
    }

    public TargetInfoResponse setProjectCode(String str) {
        this.projectCode = str;
        return this;
    }

    public TargetInfoResponse setSdkType(int i9) {
        this.sdkType = i9;
        return this;
    }

    public TargetInfoResponse setVolume(int i9) {
        this.systemInfo.setVolume(i9);
        return this;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (this.protocolVersion.getVersionName() != null && !this.protocolVersion.getVersionName().isEmpty()) {
                byteArrayOutputStream.write(new LtvBean(0, this.protocolVersion.toData()).toData());
            }
            byteArrayOutputStream.write(new LtvBean(1, this.systemInfo.toData()).toData());
            if (BluetoothAdapter.checkBluetoothAddress(this.classicBtInfo.getEdrAddr())) {
                byteArrayOutputStream.write(new LtvBean(2, this.classicBtInfo.toData()).toData());
            }
            byteArrayOutputStream.write(new LtvBean(4, this.functionConfiguration.toData()).toData());
            if (this.version.getVersionName() != null && !this.version.getVersionName().isEmpty()) {
                byteArrayOutputStream.write(new LtvBean(5, this.version.toData()).toData());
            }
            byteArrayOutputStream.write(new LtvBean(6, new byte[]{CHexConver.intToByte(this.sdkType)}).toData());
            if (this.uBootVersion.getVersionName() != null && !this.uBootVersion.getVersionName().isEmpty()) {
                byteArrayOutputStream.write(new LtvBean(7, this.uBootVersion.toData()).toData());
            }
            byteArrayOutputStream.write(new LtvBean(8, this.otaSettings.toData()).toData());
            byteArrayOutputStream.write(new LtvBean(9, this.otaState.toData()).toData());
            byteArrayOutputStream.write(new LtvBean(10, this.productInfo.toData()).toData());
            String str = this.authKey;
            if (str != null && !str.isEmpty()) {
                byteArrayOutputStream.write(new LtvBean(11, stringToData(this.authKey)).toData());
            }
            String str2 = this.projectCode;
            if (str2 != null && !str2.isEmpty()) {
                byteArrayOutputStream.write(new LtvBean(12, stringToData(this.projectCode)).toData());
            }
            byteArrayOutputStream.write(new LtvBean(13, this.protocolMtu.toData()).toData());
            byteArrayOutputStream.write(new LtvBean(14, new byte[]{CHexConver.intToByte(this.allowConnectFlag)}).toData());
            if (BluetoothAdapter.checkBluetoothAddress(this.bleInfo.getBleAddr())) {
                byteArrayOutputStream.write(new LtvBean(17, this.bleInfo.toData()).toData());
            }
            byteArrayOutputStream.write(new LtvBean(19, this.expandFunc.toData()).toData());
            String str3 = this.customVersionMsg;
            if (str3 != null && !str3.isEmpty()) {
                byteArrayOutputStream.write(new LtvBean(31, stringToData(this.customVersionMsg)).toData());
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        StringBuilder sb = new StringBuilder("TargetInfoResponse{protocolVersion=");
        sb.append(this.protocolVersion);
        sb.append(", \nsystemInfo=");
        sb.append(this.systemInfo);
        sb.append(", \nclassicBtInfo=");
        sb.append(this.classicBtInfo);
        sb.append(", \nfunctionConfiguration=");
        sb.append(this.functionConfiguration);
        sb.append(", \nversion=");
        sb.append(this.version);
        sb.append(", \nsdkType=");
        sb.append(this.sdkType);
        sb.append(", \nuBootVersion=");
        sb.append(this.uBootVersion);
        sb.append(", \notaSettings=");
        sb.append(this.otaSettings);
        sb.append(", \notaState=");
        sb.append(this.otaState);
        sb.append(", \nproductInfo=");
        sb.append(this.productInfo);
        sb.append(", \nauthKey='");
        sb.append(this.authKey);
        sb.append("', \nprojectCode='");
        sb.append(this.projectCode);
        sb.append("', \nprotocolMtu=");
        sb.append(this.protocolMtu);
        sb.append(", \nallowConnectFlag=");
        sb.append(this.allowConnectFlag);
        sb.append(", \nbleInfo=");
        sb.append(this.bleInfo);
        sb.append(", \nexpandFunc=");
        sb.append(this.expandFunc);
        sb.append(", \ncustomVersionMsg='");
        return a.j(sb, this.customVersionMsg, "'}");
    }
}
