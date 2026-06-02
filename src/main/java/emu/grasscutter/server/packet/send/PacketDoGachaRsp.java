package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.game.gacha.*;
import emu.grasscutter.net.packet.*;
import java.util.List;
import emu.grasscutter.net.proto.DoGachaRsp;
import emu.grasscutter.net.proto.GachaItem;
import emu.grasscutter.net.proto.Retcode;

public class PacketDoGachaRsp extends BasePacket {

    public PacketDoGachaRsp(
            GachaBanner banner, List<GachaItem> list, PlayerGachaBannerInfo gachaInfo) {
        super(PacketOpcodes.DoGachaRsp);

        ItemParamData costItem = banner.getCost(1);
        ItemParamData costItem10 = banner.getCost(10);
        int gachaTimesLimit = banner.getGachaTimesLimit();
        int leftGachaTimes =
                switch (gachaTimesLimit) {
                    case Integer.MAX_VALUE -> Integer.MAX_VALUE;
                    default -> Math.max(gachaTimesLimit - gachaInfo.getTotalPulls(), 0);
                };
        DoGachaRsp.Builder rsp =
                DoGachaRsp.newBuilder()
                        .setGachaType(banner.getGachaType())
                        .setGachaScheduleId(banner.getScheduleId())
                        .setGachaTimes(list.size())
                        .setNewGachaRandom(12345)
                        .setLeftGachaTimes(leftGachaTimes)
                        .setGachaTimesLimit(gachaTimesLimit)
                        .setKIPDIEOHELN(costItem.getId()) // cost_item_id
                        .setCostItemNum(costItem.getCount())
                        .setIICCKKMBIIN(costItem10.getId()) // ten_cost_item_id
                        .setTenCostItemNum(costItem10.getCount())
                        .addAllGachaItemList(list);

        if (banner.hasEpitomized()) {
            rsp.setWishItemId(gachaInfo.getWishItemId())
                    .setWishProgress(gachaInfo.getFailedChosenItemPulls())
                    .setWishMaxProgress(banner.getWishMaxProgress());
        }

        this.setData(rsp.build());
    }

    public PacketDoGachaRsp() {
        super(PacketOpcodes.DoGachaRsp);

        DoGachaRsp p =
                DoGachaRsp.newBuilder().setRetcode(Retcode.RET_SVR_ERROR_VALUE).build();

        this.setData(p);
    }

    public PacketDoGachaRsp(Retcode retcode) {
        super(PacketOpcodes.DoGachaRsp);

        DoGachaRsp p = DoGachaRsp.newBuilder().setRetcode(retcode.getNumber()).build();

        this.setData(p);
    }
}
