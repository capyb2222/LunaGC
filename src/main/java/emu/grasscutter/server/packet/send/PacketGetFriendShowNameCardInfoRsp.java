package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GetFriendShowNameCardInfoRsp;
import java.util.List;

public class PacketGetFriendShowNameCardInfoRsp extends BasePacket {
    public PacketGetFriendShowNameCardInfoRsp(int uid, List<Integer> cardIds) {
        super(PacketOpcodes.GetFriendShowNameCardInfoRsp);

        var rsp =
                GetFriendShowNameCardInfoRsp.newBuilder()
                        .setUid(uid)
                        .addAllShowNameCardIdList(cardIds)
                        .setRetcode(0)
                        .build();

        this.setData(rsp);
    }
}
