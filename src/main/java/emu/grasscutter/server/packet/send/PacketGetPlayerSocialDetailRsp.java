package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GetPlayerSocialDetailRsp;
import emu.grasscutter.net.proto.Retcode;
import emu.grasscutter.net.proto.SocialDetail;

public class PacketGetPlayerSocialDetailRsp extends BasePacket {

    public PacketGetPlayerSocialDetailRsp(SocialDetail.Builder detail) {
        super(PacketOpcodes.GetPlayerSocialDetailRsp);

        GetPlayerSocialDetailRsp.Builder proto = GetPlayerSocialDetailRsp.newBuilder();

        if (detail != null) {
            proto.setDetailData(detail);
        } else {
            proto.setRetcode(Retcode.RET_SVR_ERROR_VALUE);
        }

        this.setData(proto);
    }
}
