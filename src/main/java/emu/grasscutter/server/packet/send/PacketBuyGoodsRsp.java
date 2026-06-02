package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketBuyGoodsRsp extends BasePacket {
    public PacketBuyGoodsRsp(int shopType, int boughtNum, ShopGoods sg) {
        super(PacketOpcodes.BuyGoodsRsp);

        BuyGoodsRsp buyGoodsRsp =
                BuyGoodsRsp.newBuilder()
                        .setShopType(shopType)
                        .setBuyCount(boughtNum)
                        .addGoodsList(
                                ShopGoods.newBuilder().mergeFrom(sg).setBoughtNum(boughtNum))
                        .build();

        this.setData(buyGoodsRsp);
    }
}
