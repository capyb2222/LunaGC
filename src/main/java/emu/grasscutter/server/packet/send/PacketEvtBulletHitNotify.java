package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtBulletHitNotify;

public class PacketEvtBulletHitNotify extends BasePacket {
    public PacketEvtBulletHitNotify(EvtBulletHitNotify notify) {
        super(PacketOpcodes.EvtBulletHitNotify);

        this.setData(EvtBulletHitNotify.newBuilder(notify));
    }
}
