/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto._AvatarChangeTraceEffectRsp;

public class PacketAvatarChangeTraceEffectRsp
extends BasePacket {
    public PacketAvatarChangeTraceEffectRsp(long avatarGuid, int traceEffectId) {
        super(PacketOpcodes.AvatarChangeTraceEffectRsp);
        _AvatarChangeTraceEffectRsp proto = _AvatarChangeTraceEffectRsp.newBuilder().setAvatarGuid(avatarGuid).setTraceEffectId(traceEffectId).build();
        this.setData(proto);
    }

    public PacketAvatarChangeTraceEffectRsp() {
        super(PacketOpcodes.AvatarChangeTraceEffectRsp);
        _AvatarChangeTraceEffectRsp proto = _AvatarChangeTraceEffectRsp.newBuilder().setRetcode(1).build();
        this.setData(proto);
    }
}

