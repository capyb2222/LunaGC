package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketCombineRsp extends BasePacket {

    public PacketCombineRsp() {
        super(PacketOpcodes.CombineRsp);

        CombineRsp proto =
                CombineRsp.newBuilder()
                        .setRetcode(Retcode.RET_SVR_ERROR_VALUE)
                        .build();

        this.setData(proto);
    }

    public PacketCombineRsp(int retcode) {
        super(PacketOpcodes.CombineRsp);

        CombineRsp proto =
                CombineRsp.newBuilder().setRetcode(retcode).build();

        this.setData(proto);
    }

    public PacketCombineRsp(
            CombineReq combineReq,
            Iterable<ItemParam> costItemList,
            Iterable<ItemParam> resultItemList,
            Iterable<ItemParam> totalRandomItemList,
            Iterable<ItemParam> totalReturnItemList,
            Iterable<ItemParam> totalExtraItemList) {

        super(PacketOpcodes.CombineRsp);

        CombineRsp proto =
                CombineRsp.newBuilder()
                        .setRetcode(Retcode.RET_SUCC_VALUE)
                        .setCombineId(combineReq.getCombineId())
                        .setCombineCount(combineReq.getCombineCount())
                        .setAvatarGuid(combineReq.getAvatarGuid())
                        .addAllCostItemList(costItemList)
                        .addAllResultItemList(resultItemList)
                        .addAllTotalReturnItemList(totalReturnItemList)
                        .addAllTotalExtraItemList(totalExtraItemList)
                        .build();

        this.setData(proto);
    }
}
