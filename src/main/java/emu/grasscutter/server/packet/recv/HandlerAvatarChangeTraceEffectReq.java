package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto._AvatarChangeTraceEffectReq;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarChangeTraceEffectRsp;

@Opcodes(PacketOpcodes.AvatarChangeTraceEffectReq)
public class HandlerAvatarChangeTraceEffectReq
extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        _AvatarChangeTraceEffectReq req = _AvatarChangeTraceEffectReq.parseFrom(payload);
        boolean success = session.getPlayer().getAvatars().changeTraceEffect(req.getAvatarGuid(), req.getTraceEffectId());
        if (success) {
            session.getPlayer().sendPacket(new PacketAvatarChangeTraceEffectRsp(req.getAvatarGuid(), req.getTraceEffectId()));
        }
    }
}

