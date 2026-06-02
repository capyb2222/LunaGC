package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.*;

public class PacketQueryPathRsp extends BasePacket {

    public PacketQueryPathRsp(QueryPathReq req) {
        super(PacketOpcodes.QueryPathRsp);

        var proto = QueryPathRsp.newBuilder();

        proto
                .addCorners(req.getSourcePos())
                .addCorners(req.getDestinationPos(0))
                .setQueryId(req.getQueryId())
                .setQueryStatus(QueryPathRsp.PathStatusType.STATUS_SUCC);

        this.setData(proto);
    }
}
