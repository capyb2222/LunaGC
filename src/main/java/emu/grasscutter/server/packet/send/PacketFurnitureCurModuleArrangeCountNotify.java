package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketFurnitureCurModuleArrangeCountNotify extends BasePacket {
    public PacketFurnitureCurModuleArrangeCountNotify() {
        super(PacketOpcodes.FurnitureCurModuleArrangeCountNotify);
    }
}
