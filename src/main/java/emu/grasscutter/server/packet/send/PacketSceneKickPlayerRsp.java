package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketSceneKickPlayerRsp extends BasePacket {
    public PacketSceneKickPlayerRsp(int targetUid) {
        super(PacketOpcodes.SceneKickPlayerRsp);
    }
    public PacketSceneKickPlayerRsp() {
        super(PacketOpcodes.SceneKickPlayerRsp);
    }
}
