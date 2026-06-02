package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.WeaponPromoteRsp;

public class PacketWeaponPromoteRsp extends BasePacket {

    public PacketWeaponPromoteRsp(GameItem item, int oldPromoteLevel) {
        super(PacketOpcodes.WeaponPromoteRsp);

        WeaponPromoteRsp proto =
                WeaponPromoteRsp.newBuilder()
                        .setTargetWeaponGuid(item.getGuid())
                        .setNPMKDPKBKEL(item.getPromoteLevel())
                        .setJGKCKCGLOII(oldPromoteLevel)
                        .build();

        this.setData(proto);
    }
}
