package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.AddNoGachaAvatarCardNotify;

public class PacketAddNoGachaAvatarCardNotify extends BasePacket {

    public PacketAddNoGachaAvatarCardNotify(Avatar avatar, ActionReason reason) {
        super(PacketOpcodes.AddNoGachaAvatarCardNotify, true);

        AddNoGachaAvatarCardNotify proto =
                AddNoGachaAvatarCardNotify.newBuilder()
                        .setAvatarId(avatar.getAvatarId())
                        .setReason(reason.getValue())
                        .setItemId(1000 + (avatar.getAvatarId() % 10000000))
                        .build();

        this.setData(proto);
    }

    public PacketAddNoGachaAvatarCardNotify(int avatarId, ActionReason reason, GameItem item) {
        super(PacketOpcodes.AddNoGachaAvatarCardNotify, true);

        AddNoGachaAvatarCardNotify proto =
                AddNoGachaAvatarCardNotify.newBuilder()
                        .setAvatarId(avatarId)
                        .setReason(reason.getValue())
                        .setItemId(item.getItemId())
                        .build();

        this.setData(proto);
    }
}
