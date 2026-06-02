package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtBulletDeactiveNotify;

public class PacketEvtBulletDeactiveNotify extends BasePacket {
    public PacketEvtBulletDeactiveNotify(
            EvtBulletDeactiveNotify notify) {
        super(PacketOpcodes.EvtBulletDeactiveNotify);

        this.setData(EvtBulletDeactiveNotify.newBuilder(notify));
    }
}
