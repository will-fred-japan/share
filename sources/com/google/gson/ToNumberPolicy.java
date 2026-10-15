package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import defpackage.f;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE { // from class: com.google.gson.ToNumberPolicy.1
        @Override // com.google.gson.ToNumberStrategy
        public Double readNumber(JsonReader jsonReader) {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.google.gson.ToNumberPolicy.2
        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE { // from class: com.google.gson.ToNumberPolicy.3
        private Number parseAsDouble(String str, JsonReader jsonReader) throws MalformedJsonException {
            try {
                Double dValueOf = Double.valueOf(str);
                if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                    if (!jsonReader.isLenient()) {
                        throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.getPreviousPath());
                    }
                }
                return dValueOf;
            } catch (NumberFormatException e9) {
                StringBuilder sbI = f.i("Cannot parse ", str, "; at path ");
                sbI.append(jsonReader.getPreviousPath());
                throw new JsonParseException(sbI.toString(), e9);
            }
        }

        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            if (strNextString.indexOf(46) >= 0) {
                return parseAsDouble(strNextString, jsonReader);
            }
            try {
                return Long.valueOf(Long.parseLong(strNextString));
            } catch (NumberFormatException unused) {
                return parseAsDouble(strNextString, jsonReader);
            }
        }
    },
    BIG_DECIMAL { // from class: com.google.gson.ToNumberPolicy.4
        @Override // com.google.gson.ToNumberStrategy
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            try {
                return NumberLimits.parseBigDecimal(strNextString);
            } catch (NumberFormatException e9) {
                StringBuilder sbI = f.i("Cannot parse ", strNextString, "; at path ");
                sbI.append(jsonReader.getPreviousPath());
                throw new JsonParseException(sbI.toString(), e9);
            }
        }
    }
}
