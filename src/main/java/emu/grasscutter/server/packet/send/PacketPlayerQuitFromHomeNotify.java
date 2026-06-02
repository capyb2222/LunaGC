package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerQuitFromHomeNotify;

public class PacketPlayerQuitFromHomeNotify extends BasePacket {
    public PacketPlayerQuitFromHomeNotify(
            PlayerQuitFromHomeNotify.QuitReason reason) {
        super(PacketOpcodes.PlayerQuitFromHomeNotify);

        this.setData(
                PlayerQuitFromHomeNotify.newBuilder().setReason(reason));
    }
}
