package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtBulletMoveNotify;

public class PacketEvtBulletMoveNotify extends BasePacket {
    public PacketEvtBulletMoveNotify(EvtBulletMoveNotify notify) {
        super(PacketOpcodes.EvtBulletMoveNotify);

        this.setData(EvtBulletMoveNotify.newBuilder(notify));
    }
}
