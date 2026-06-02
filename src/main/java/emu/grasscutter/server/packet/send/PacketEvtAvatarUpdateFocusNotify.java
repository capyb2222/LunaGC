package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtAvatarUpdateFocusNotify;

public class PacketEvtAvatarUpdateFocusNotify extends BasePacket {
    public PacketEvtAvatarUpdateFocusNotify(
            EvtAvatarUpdateFocusNotify notify) {
        super(PacketOpcodes.EvtAvatarUpdateFocusNotify);

        this.setData(
                EvtAvatarUpdateFocusNotify.newBuilder(notify));
    }
}
