package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.FireworksLaunchDataNotify;
import emu.grasscutter.net.proto.FireworksLaunchSchemeData;

public class PacketFireworksLaunchDataNotify extends BasePacket {
    public PacketFireworksLaunchDataNotify(FireworksLaunchSchemeData data) {
        super(PacketOpcodes.FireworksLaunchDataNotify);

        this.setData(FireworksLaunchDataNotify.newBuilder().addSchemeDataList(data));
    }
}
