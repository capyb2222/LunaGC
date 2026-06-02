package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.PlayerApplyEnterHomeResultRsp;

public class PacketPlayerApplyEnterHomeResultRsp extends BasePacket {
    public PacketPlayerApplyEnterHomeResultRsp(int uid, boolean agreed) {
        super(PacketOpcodes.PlayerApplyEnterHomeResultRsp);

        this.setData(
                PlayerApplyEnterHomeResultRsp.newBuilder()
                        .setApplyUid(uid)
                        .setIsAgreed(agreed));
    }
}
