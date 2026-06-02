package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtAvatarExitFocusNotify;

public class PacketEvtAvatarExitFocusNotify extends BasePacket {
    public PacketEvtAvatarExitFocusNotify(
            EvtAvatarExitFocusNotify notify) {
        super(PacketOpcodes.EvtAvatarExitFocusNotify);

        this.setData(EvtAvatarExitFocusNotify.newBuilder(notify));
    }
}
