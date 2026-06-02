package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import java.util.List;

public class PacketDelTeamEntityNotify extends BasePacket {

    public PacketDelTeamEntityNotify(int sceneId, int teamEntityId) {
        super(PacketOpcodes.DelTeamEntityNotify);
    }

    public PacketDelTeamEntityNotify(int sceneId, List<Integer> list) {
        super(PacketOpcodes.DelTeamEntityNotify);
    }
}
