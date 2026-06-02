package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtEntityRenderersChangedNotify;

public class PacketEvtEntityRenderersChangedNotify extends BasePacket {

    public PacketEvtEntityRenderersChangedNotify(
            EvtEntityRenderersChangedNotify req) {
        super(PacketOpcodes.EvtEntityRenderersChangedNotify, true);

        this.setData(req);
    }
}
