package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketBuyBattlePassLevelRsp extends BasePacket {
    public PacketBuyBattlePassLevelRsp(int buyLevel) {
        super(PacketOpcodes.BuyBattlePassLevelRsp);
    }
}
