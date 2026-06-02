package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.ForgeQueueManipulateRsp;
import emu.grasscutter.net.proto.ForgeQueueManipulateType;
import emu.grasscutter.net.proto.ItemParam;
import emu.grasscutter.net.proto.Retcode;
import java.util.List;

public class PacketForgeQueueManipulateRsp extends BasePacket {

    public PacketForgeQueueManipulateRsp(
            Retcode retcode,
            ForgeQueueManipulateType type,
            List<GameItem> output,
            List<GameItem> refund,
            List<GameItem> extra) {
        super(PacketOpcodes.ForgeQueueManipulateRsp);

        ForgeQueueManipulateRsp.Builder builder =
                ForgeQueueManipulateRsp.newBuilder()
                        .setRetcode(retcode.getNumber())
                        .setManipulateType(type);

        // ToDo: Add extra items when once we have handling for it.

        this.setData(builder.build());
    }
}
