package com.kush.app.codecs;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

public class SendingCodec implements MessageCodec {
    @Override
    public void encodeToWire(Buffer buffer, Object o) {

    }

    @Override
    public Object decodeFromWire(int i, Buffer buffer) {
        return null;
    }

    @Override
    public Object transform(Object o) {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public byte systemCodecID() {
        return 0;
    }
}
