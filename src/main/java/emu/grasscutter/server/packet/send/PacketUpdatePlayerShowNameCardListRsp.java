package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.UpdatePlayerShowNameCardListRsp;
import java.util.List;

public class PacketUpdatePlayerShowNameCardListRsp extends BasePacket {
    public PacketUpdatePlayerShowNameCardListRsp(List<Integer> cardIds) {
        super(PacketOpcodes.UpdatePlayerShowNameCardListRsp);

        var rsp =
                UpdatePlayerShowNameCardListRsp.newBuilder()
                        .addAllShowNameCardIdList(cardIds)
                        .setRetcode(0)
                        .build();

        this.setData(rsp);
    }
}
