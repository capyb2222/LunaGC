package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.ServerAnnounceRevokeNotify;

public class PacketServerAnnounceRevokeNotify extends BasePacket {

    public PacketServerAnnounceRevokeNotify(int tplId) {
        super(PacketOpcodes.ServerAnnounceRevokeNotify);

        var proto = ServerAnnounceRevokeNotify.newBuilder();

        proto.addConfigIdList(tplId);

        this.setData(proto);
    }
}
