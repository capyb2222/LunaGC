package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;
import java.util.List;

public class PacketFurnitureMakeStartRsp extends BasePacket {
    public PacketFurnitureMakeStartRsp(int ret, List<?> furnitureMakeData) {
        super(PacketOpcodes.FurnitureMakeStartRsp);
    }
}
