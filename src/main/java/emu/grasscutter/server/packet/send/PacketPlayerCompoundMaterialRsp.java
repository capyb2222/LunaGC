package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.CompoundQueueData;
import emu.grasscutter.net.proto.PlayerCompoundMaterialRsp;
import emu.grasscutter.net.proto.Retcode;

public class PacketPlayerCompoundMaterialRsp extends BasePacket {
    /**
     * Builder for successful message.
     *
     * @param compoundQueueData new compound queue
     */
    public PacketPlayerCompoundMaterialRsp(CompoundQueueData compoundQueueData) {
        super(PacketOpcodes.PlayerCompoundMaterialRsp);
        PlayerCompoundMaterialRsp proto =
                PlayerCompoundMaterialRsp.newBuilder()
                        .setCompoundQueData(compoundQueueData)
                        .setRetcode(Retcode.RET_SUCC_VALUE)
                        .build();
        setData(proto);
    }

    /**
     * Builder for failed message.
     *
     * @param retcode error code
     */
    public PacketPlayerCompoundMaterialRsp(int retcode) {
        super(PacketOpcodes.PlayerCompoundMaterialRsp);
        PlayerCompoundMaterialRsp proto =
                PlayerCompoundMaterialRsp.newBuilder().setRetcode(retcode).build();
        setData(proto);
    }
}
