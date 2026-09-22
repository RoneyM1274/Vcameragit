package com.hack.github.megatronking.stringfog;

/* JADX INFO: loaded from: classes.dex */
public interface IStringFog {
    String decrypt(byte[] bArr, byte[] bArr2);

    byte[] encrypt(String str, byte[] bArr);

    boolean shouldFog(String str);
}
