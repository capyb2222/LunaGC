package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.home.*;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketFurnitureMakeRsp extends BasePacket {

    public PacketFurnitureMakeRsp(GameHome home) {
        super(PacketOpcodes.FurnitureMakeRsp);

        var proto = FurnitureMakeRsp.newBuilder();

        proto.setFurnitureMakeSlot(
                FurnitureMakeSlot.newBuilder()
                        .addAllFurnitureMakeDataList(
                                home.getFurnitureMakeSlotItemList().stream()
                                        .map(FurnitureMakeSlotItem::toProto)
                                        .toList())
                        .build());

        this.setData(proto);
    }
}
