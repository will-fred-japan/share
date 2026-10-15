package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class ClobSerializer implements ObjectSerializer {
    public static final ClobSerializer instance = new ClobSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i9) throws IOException {
        try {
            if (obj == null) {
                jSONSerializer.writeNull();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringBuilder sb = new StringBuilder();
            try {
                char[] cArr = new char[OpusCodecConfig.APPLICATION_VOIP];
                while (true) {
                    int i10 = characterStream.read(cArr, 0, OpusCodecConfig.APPLICATION_VOIP);
                    if (i10 < 0) {
                        String string = sb.toString();
                        characterStream.close();
                        jSONSerializer.write(string);
                        return;
                    }
                    sb.append(cArr, 0, i10);
                }
            } catch (Exception e9) {
                throw new JSONException("read string from reader error", e9);
            }
        } catch (SQLException e10) {
            throw new IOException("write clob error", e10);
        }
    }
}
