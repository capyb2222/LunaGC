package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityVehicle;
import emu.grasscutter.net.packet.*;
import emu.grasscutter.net.proto._VehiclePhlogistonNotify;

public class PacketVehiclePhlogistonPointsNotify extends BasePacket {

    public PacketVehiclePhlogistonPointsNotify(EntityVehicle vehicle) {
        super(PacketOpcodes.VehiclePhlogistonPointsNotify);

        _VehiclePhlogistonNotify notify = _VehiclePhlogistonNotify.newBuilder()
                .setCurPhlogiston(vehicle.getCurPhlogiston())
                .setEntityId(vehicle.getId())
                .build();


        this.setData(notify);
    }
}
