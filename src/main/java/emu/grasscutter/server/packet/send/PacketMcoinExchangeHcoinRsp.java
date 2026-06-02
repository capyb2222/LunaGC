package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.McoinExchangeHcoinRsp;

public class PacketMcoinExchangeHcoinRsp extends BasePacket {

    public PacketMcoinExchangeHcoinRsp(int retCode) {
        super(PacketOpcodes.McoinExchangeHcoinRsp);

        McoinExchangeHcoinRsp proto =
                McoinExchangeHcoinRsp.newBuilder()
                        .setRetcode(retCode)
                        .build();

        this.setData(proto);
    }
}
