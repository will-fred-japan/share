package com.jieli.jl_bt_ota.model.response.device;

import H2.a;
import com.jieli.jl_bt_ota.interfaces.command.IDataOp;
import com.jieli.jl_bt_ota.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ProtocolMTU implements IDataOp {
    private int sendMtu = 530;
    private int receiveMtu = 530;

    public int getReceiveMtu() {
        return this.receiveMtu;
    }

    public int getSendMtu() {
        return this.sendMtu;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (bArr.length == 2) {
            short s8 = byteBufferWrap.getShort();
            setSendMtu(s8).setReceiveMtu(s8);
        } else {
            setSendMtu(byteBufferWrap.getShort()).setReceiveMtu(byteBufferWrap.getShort());
        }
        return byteBufferWrap.position();
    }

    public ProtocolMTU setReceiveMtu(int i9) {
        this.receiveMtu = i9;
        return this;
    }

    public ProtocolMTU setSendMtu(int i9) {
        this.sendMtu = i9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(CHexConver.int2byte2(this.sendMtu));
            byteArrayOutputStream.write(CHexConver.int2byte2(this.receiveMtu));
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProtocolMTU{sendMtu=");
        sb.append(this.sendMtu);
        sb.append(", receiveMtu=");
        return a.a(sb, this.receiveMtu, '}');
    }
}
