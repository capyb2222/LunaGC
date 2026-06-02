package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto._AvatarChangeTraceEffectNotify;

public class PacketAvatarTraceEffectChangeNotify extends BasePacket {

    public PacketAvatarTraceEffectChangeNotify(EntityAvatar entity) {
        super(PacketOpcodes._AvatarChangeTraceEffectNotify);

        // Create the proto message and set the traceEffectId
        _AvatarChangeTraceEffectNotify proto = _AvatarChangeTraceEffectNotify.newBuilder()
        .setEntityInfo(entity.toProto()).build();

        // Set the data for the packet
        this.setData(proto);
    }
}
