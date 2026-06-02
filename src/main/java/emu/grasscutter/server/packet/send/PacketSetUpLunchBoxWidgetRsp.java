package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketSetUpLunchBoxWidgetRsp extends BasePacket {

    public PacketSetUpLunchBoxWidgetRsp(LunchBoxData lunchBoxData) {
        super(PacketOpcodes.SetUpLunchBoxWidgetRsp);
        var rsp = SetUpLunchBoxWidgetRsp.newBuilder();
        rsp.setLunchBoxData(lunchBoxData);

        setData(rsp.build());
    }
}
