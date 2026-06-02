package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtBulletHitNotify;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtBulletHitNotify;

@Opcodes(PacketOpcodes.EvtBulletHitNotify)
public class HandlerEvtBulletHitNotify extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session
                .getPlayer()
                .getScene()
                .broadcastPacketToOthers(
                        session.getPlayer(),
                        new PacketEvtBulletHitNotify(
                                EvtBulletHitNotify.parseFrom(payload)));
    }
}
