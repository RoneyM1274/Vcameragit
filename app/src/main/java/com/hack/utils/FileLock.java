package com.hack.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class FileLock {
    private static FileLock singleton;
    private Map<String, FileLockCount> mRefCountMap = new ConcurrentHashMap();

    public static FileLock getInstance() {
        if (singleton == null) {
            singleton = new FileLock();
        }
        return singleton;
    }

    private int RefCntInc(String str, java.nio.channels.FileLock fileLock, RandomAccessFile randomAccessFile, FileChannel fileChannel) {
        if (this.mRefCountMap.containsKey(str)) {
            FileLockCount fileLockCount = this.mRefCountMap.get(str);
            int i = fileLockCount.mRefCount;
            fileLockCount.mRefCount = i + 1;
            return i;
        }
        this.mRefCountMap.put(str, new FileLockCount(fileLock, 1, randomAccessFile, fileChannel));
        return 1;
    }

    private int RefCntDec(String str) {
        if (!this.mRefCountMap.containsKey(str)) {
            return 0;
        }
        FileLockCount fileLockCount = this.mRefCountMap.get(str);
        int i = fileLockCount.mRefCount - 1;
        fileLockCount.mRefCount = i;
        if (i > 0) {
            return i;
        }
        this.mRefCountMap.remove(str);
        return i;
    }

    public boolean LockExclusive(File file) {
        if (file == null) {
            return false;
        }
        try {
            File file2 = new File(file.getParentFile().getAbsolutePath().concat("/lock"));
            if (!file2.exists()) {
                file2.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2.getAbsolutePath(), "rw");
            FileChannel channel = randomAccessFile.getChannel();
            java.nio.channels.FileLock fileLockLock = channel.lock();
            if (!fileLockLock.isValid()) {
                return false;
            }
            RefCntInc(file2.getAbsolutePath(), fileLockLock, randomAccessFile, channel);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void unLock(File file) {
        FileLockCount fileLockCount;
        File file2 = new File(file.getParentFile().getAbsolutePath().concat("/lock"));
        if (file2.exists() && this.mRefCountMap.containsKey(file2.getAbsolutePath()) && (fileLockCount = this.mRefCountMap.get(file2.getAbsolutePath())) != null) {
            java.nio.channels.FileLock fileLock = fileLockCount.mFileLock;
            RandomAccessFile randomAccessFile = fileLockCount.fOs;
            FileChannel fileChannel = fileLockCount.fChannel;
            try {
                if (RefCntDec(file2.getAbsolutePath()) <= 0) {
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class FileLockCount {
        FileChannel fChannel;
        RandomAccessFile fOs;
        java.nio.channels.FileLock mFileLock;
        int mRefCount;

        FileLockCount(java.nio.channels.FileLock fileLock, int i, RandomAccessFile randomAccessFile, FileChannel fileChannel) {
            this.mFileLock = fileLock;
            this.mRefCount = i;
            this.fOs = randomAccessFile;
            this.fChannel = fileChannel;
        }
    }
}
