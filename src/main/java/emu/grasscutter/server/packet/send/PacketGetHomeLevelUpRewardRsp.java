package emu.grasscutter.server.packet.send;
import emu.grasscutter.net.packet.*;

public class PacketGetHomeLevelUpRewardRsp extends BasePacket {
    public PacketGetHomeLevelUpRewardRsp(int level, int rewardId) {
        super(PacketOpcodes.GetHomeLevelUpRewardRsp);
    }
}
