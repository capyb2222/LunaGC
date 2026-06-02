package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.SceneAudioNotify;
import java.util.List;

public class PacketSceneAudioNotify extends BasePacket {

    public PacketSceneAudioNotify(
            int sourceUid, List<Float> param2, List<String> param3, int type, List<Integer> param1) {
        super(PacketOpcodes.SceneAudioNotify);

        SceneAudioNotify proto =
                SceneAudioNotify.newBuilder()
                        .setSourceUid(sourceUid)
                        .addAllParam2(param2)
                        .addAllParam3(param3)
                        .setType(type)
                        .addAllParam1(param1)
                        .build();

        this.setData(proto);
    }
}
