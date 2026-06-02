package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;
import java.util.List;

public class PacketTakeFurnitureMakeRsp extends BasePacket {

    public PacketTakeFurnitureMakeRsp(
            int ret,
            int makeId,
            List<ItemParam> output,
            List<FurnitureMakeData> others) {
        super(PacketOpcodes.TakeFurnitureMakeRsp);

        var proto = TakeFurnitureMakeRsp.newBuilder();

        proto.setRetcode(ret).setMakeId(makeId);

        if (output != null) {
            proto.addAllOutputItemList(output);
        }

        if (others != null) {
            proto.setFurnitureMakeSlot(
                    FurnitureMakeSlot.newBuilder()
                            .addAllFurnitureMakeDataList(others)
                            .build());
        }

        this.setData(proto);
    }
}
