package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto.EvtBulletMoveNotify;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtBulletMoveNotify;

@Opcodes(PacketOpcodes.EvtBulletMoveNotify)
public class HandlerEvtBulletMoveNotify extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session
                .getPlayer()
                .getScene()
                .broadcastPacketToOthers(
                        session.getPlayer(),
                        new PacketEvtBulletMoveNotify(
                                EvtBulletMoveNotify.parseFrom(payload)));
    }
}
