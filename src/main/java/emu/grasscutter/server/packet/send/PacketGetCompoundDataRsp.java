package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.CompoundQueueData;
import emu.grasscutter.net.proto.GetCompoundDataRsp;
import emu.grasscutter.net.proto.Retcode;
import java.util.*;

public class PacketGetCompoundDataRsp extends BasePacket {
    public PacketGetCompoundDataRsp(
            Set<Integer> unlockedCompounds, List<CompoundQueueData> compoundQueueData) {
        super(PacketOpcodes.GetCompoundDataRsp);
        var proto =
                GetCompoundDataRsp.newBuilder()
                        .addAllUnlockCompoundList(unlockedCompounds)
                        .addAllCompoundQueDataList(compoundQueueData)
                        .setRetcode(Retcode.RET_SUCC_VALUE)
                        .build();
        setData(proto);
    }
}
