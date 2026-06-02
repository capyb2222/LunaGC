package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketHomeSceneJumpRsp extends BasePacket {
    public PacketHomeSceneJumpRsp(boolean enterRoomScene) {
        super(PacketOpcodes.HomeSceneJumpRsp);
    }
}
