package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.MassiveEntityElementOpBatchNotify;

public class PacketMassiveEntityElementOpBatchNotify extends BasePacket {
    public PacketMassiveEntityElementOpBatchNotify(
            MassiveEntityElementOpBatchNotify notify) {
        super(PacketOpcodes.MassiveEntityElementOpBatchNotify);

        this.setData(
                MassiveEntityElementOpBatchNotify.newBuilder(
                        notify));
    }
}
