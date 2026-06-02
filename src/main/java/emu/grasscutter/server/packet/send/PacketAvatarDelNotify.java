package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import java.util.List;

public class PacketAvatarDelNotify extends BasePacket {

    public PacketAvatarDelNotify(List<Long> avatarGuidList) {
        super(PacketOpcodes.AvatarDelNotify);
    }
}
