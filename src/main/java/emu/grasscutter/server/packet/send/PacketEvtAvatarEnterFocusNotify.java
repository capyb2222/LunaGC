package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtAvatarEnterFocusNotify;

public class PacketEvtAvatarEnterFocusNotify extends BasePacket {
    public PacketEvtAvatarEnterFocusNotify(
            EvtAvatarEnterFocusNotify notify) {
        super(PacketOpcodes.EvtAvatarEnterFocusNotify);

        this.setData(EvtAvatarEnterFocusNotify.newBuilder(notify));
    }
}
