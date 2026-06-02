package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityBaseGadget;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.GadgetInteractRsp;
import emu.grasscutter.net.proto.InterOpType;
import emu.grasscutter.net.proto.InteractType;
import emu.grasscutter.net.proto.Retcode;

public class PacketGadgetInteractRsp extends BasePacket {
    public PacketGadgetInteractRsp(EntityBaseGadget gadget, InteractType interact) {
        this(gadget, interact, null);
    }

    public PacketGadgetInteractRsp(
            EntityBaseGadget gadget, InteractType interact, InterOpType opType) {
        super(PacketOpcodes.GadgetInteractRsp);

        var proto =
                GadgetInteractRsp.newBuilder()
                        .setGadgetEntityId(gadget.getId())
                        .setInteractType(interact)
                        .setGadgetId(gadget.getGadgetId());

        if (opType != null) {
            proto.setOpType(opType);
        }

        this.setData(proto.build());
    }

    public PacketGadgetInteractRsp() {
        super(PacketOpcodes.GadgetInteractRsp);

        GadgetInteractRsp proto =
                GadgetInteractRsp.newBuilder()
                        .setRetcode(Retcode.RET_SVR_ERROR_VALUE)
                        .build();

        this.setData(proto);
    }
}
