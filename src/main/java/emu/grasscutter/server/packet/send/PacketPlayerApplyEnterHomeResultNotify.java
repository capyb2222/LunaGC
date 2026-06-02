package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.PlayerApplyEnterHomeResultNotify;

public class PacketPlayerApplyEnterHomeResultNotify extends BasePacket {
    public PacketPlayerApplyEnterHomeResultNotify(
            int targetUid,
            String nickname,
            boolean agreed,
            PlayerApplyEnterHomeResultNotify.Reason reason) {
        super(PacketOpcodes.PlayerApplyEnterHomeResultNotify);

        this.setData(
                PlayerApplyEnterHomeResultNotify.newBuilder()
                        .setTargetUid(targetUid)
                        .setTargetNickname(nickname)
                        .setIsAgreed(agreed)
                        .setReason(reason));
    }
}
