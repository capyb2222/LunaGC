package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GetShopRsp;
import java.util.List;

public class PacketGetShopRsp extends BasePacket {

    public PacketGetShopRsp(int param) {
        super(PacketOpcodes.GetShopRsp);
        GetShopRsp proto = GetShopRsp.newBuilder().setRetcode(0).build();
        this.setData(proto);
    }

    public PacketGetShopRsp(int param, List<Integer> availableShops) {
        super(PacketOpcodes.GetShopRsp);
        GetShopRsp proto = GetShopRsp.newBuilder().setRetcode(0).build();
        this.setData(proto);
    }
}
