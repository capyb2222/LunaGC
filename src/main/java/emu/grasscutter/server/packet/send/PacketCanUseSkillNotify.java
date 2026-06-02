package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.CanUseSkillNotify;

public class PacketCanUseSkillNotify extends BasePacket {

    public PacketCanUseSkillNotify(boolean canUseSkill) {
        super(PacketOpcodes.CanUseSkillNotify);

        CanUseSkillNotify proto =
                CanUseSkillNotify.newBuilder()
                        .setIsCanUseSkill(canUseSkill)
                        .build();

        this.setData(proto);
    }
}
