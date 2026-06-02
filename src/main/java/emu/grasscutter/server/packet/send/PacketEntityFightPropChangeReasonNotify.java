package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.packet.*;
import java.util.*;
import lombok.Getter;
import java.util.List;
import emu.grasscutter.net.proto._ChangeHpDebtsReason;
import emu.grasscutter.net.proto._DetailAbilityInfo;
import emu.grasscutter.net.proto.AbilityString;
import emu.grasscutter.net.proto.ChangeEnergyReason;
import emu.grasscutter.net.proto.EntityFightPropChangeReasonNotify;
import emu.grasscutter.net.proto.PropChangeReason;

import emu.grasscutter.net.proto.ChangHpReason;

public class PacketEntityFightPropChangeReasonNotify extends BasePacket {
    @Getter private Ability ability;
    public PacketEntityFightPropChangeReasonNotify(
            GameEntity entity,
            FightProperty prop,
            Float value,
            List<Integer> param,
            PropChangeReason reason,
            ChangHpReason changeHpReason) {
        super(PacketOpcodes.EntityFightPropChangeReasonNotify);

        EntityFightPropChangeReasonNotify.Builder proto =
                EntityFightPropChangeReasonNotify.newBuilder()
                        .setEntityId(entity.getId())
                        .setPropType(prop.getId())
                        .setPropDelta(value)
                        .setReason(reason)
                        .setChangeHpReason(changeHpReason);

        for (int p : param) {
            proto.addParamList(p);
        }

        this.setData(proto);
    }

    public PacketEntityFightPropChangeReasonNotify(
            GameEntity entity,
            FightProperty prop,
            Float value,
            PropChangeReason reason,
            ChangHpReason changeHpReason) {
        super(PacketOpcodes.EntityFightPropChangeReasonNotify);

        var detailAbility = entity.getDetailAbilityInfo();

        var proto =
                EntityFightPropChangeReasonNotify.newBuilder()
                        .setEntityId(entity.getId())
                        .setPropType(prop.getId())
                        .setPropDelta(value)
                        .setReason(reason)
                        //.setDetailInfo(detailInfo != null ? detailInfo : PropChangeDetailInfo.getDefaultInstance())  // Only set if not null
                        .setChangeHpReason(changeHpReason)
                        .build();

        this.setData(proto);
    }

    public PacketEntityFightPropChangeReasonNotify(
            GameEntity entity, FightProperty prop, Float value, PropChangeReason reason) {
        super(PacketOpcodes.EntityFightPropChangeReasonNotify);

        EntityFightPropChangeReasonNotify proto =
                EntityFightPropChangeReasonNotify.newBuilder()
                        .setEntityId(entity.getId())
                        .setPropType(prop.getId())
                        .setPropDelta(value)
                        .setReason(reason)
                        .build();

        this.setData(proto);
    }

    public PacketEntityFightPropChangeReasonNotify(
            GameEntity entity, FightProperty prop, Float value, ChangeEnergyReason reason) {
        super(PacketOpcodes.EntityFightPropChangeReasonNotify);


        EntityFightPropChangeReasonNotify proto =
                EntityFightPropChangeReasonNotify.newBuilder()
                        .setEntityId(entity.getId())
                        .setPropType(prop.getId())
                        .setPropDelta(value)
                        .setChangeEnergyReson(reason)
                        .build();

        this.setData(proto);
    }

    public PacketEntityFightPropChangeReasonNotify(
            GameEntity entity,
            FightProperty prop,
            Float value,
            PropChangeReason reason,
            _ChangeHpDebtsReason changeHpDebts) {
        super(PacketOpcodes.EntityFightPropChangeReasonNotify);

        var detailAbility = entity.getDetailAbilityInfo();
        var proto =
                EntityFightPropChangeReasonNotify.newBuilder()
                        .setEntityId(entity.getId())
                        .setPropType(prop.getId())
                        .setPropDelta(value)
                        //.setPaidHpDebts(value)
                        .setReason(reason)
                        //.setDetailInfo(detailInfo != null ? detailInfo : PropChangeDetailInfo.getDefaultInstance())  // Only set if not null
                        .setChangeHpDebtsReason(changeHpDebts)
                        .build();
        this.setData(proto);
    }


    public PacketEntityFightPropChangeReasonNotify(
        GameEntity entity, FightProperty prop, Float value, PropChangeReason reason, ChangeEnergyReason energyReason) {
    super(PacketOpcodes.EntityFightPropChangeReasonNotify);

    var detailAbility = entity.getDetailAbilityInfo();
    EntityFightPropChangeReasonNotify proto =
            EntityFightPropChangeReasonNotify.newBuilder()
                    .setEntityId(entity.getId())
                    .setPropType(prop.getId())
                    .setPropDelta(value)
                    .setReason(reason)
                    //.setDetailInfo(detailInfo != null ? detailInfo : PropChangeDetailInfo.getDefaultInstance())  // Only set if not null
                    .setChangeEnergyReson(energyReason)
                    .build();

    this.setData(proto);
}

}
