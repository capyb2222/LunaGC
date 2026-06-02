package emu.grasscutter.game.entity;

import emu.grasscutter.GameConstants;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.config.ConfigEntityGadget;
import emu.grasscutter.data.excels.GadgetData;
import emu.grasscutter.data.excels.avatar.VehicleData;
import emu.grasscutter.game.ability.*;
import emu.grasscutter.data.binout.config.fields.ConfigAbilityData;
import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.*;
import emu.grasscutter.game.world.*;
import emu.grasscutter.utils.helpers.ProtoHelper;
import it.unimi.dsi.fastutil.ints.*;
import java.util.*;
import javax.annotation.Nullable;
import lombok.*;
import emu.grasscutter.net.proto.AbilityAppliedAbility;
import emu.grasscutter.net.proto.AbilityAppliedModifier;
import emu.grasscutter.net.proto.AbilityControlBlock;
import emu.grasscutter.net.proto.AbilityScalarValueEntry;
import emu.grasscutter.net.proto.AbilityString;
import emu.grasscutter.net.proto.AbilitySyncStateInfo;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPair;
import emu.grasscutter.net.proto.EntityAuthorityInfo;
import emu.grasscutter.net.proto.EntityRendererChangedInfo;
import emu.grasscutter.net.proto.MotionInfo;
import emu.grasscutter.net.proto.PropPair;
import emu.grasscutter.net.proto.ProtEntityType;
import emu.grasscutter.net.proto.SceneEntityAiInfo;
import emu.grasscutter.net.proto.SceneEntityInfo;
import emu.grasscutter.net.proto.SceneGadgetInfo;
import emu.grasscutter.net.proto.Vector;
import emu.grasscutter.net.proto.VehicleInfo;
import emu.grasscutter.net.proto.VehicleMember;

public class EntityVehicle extends EntityBaseGadget {

    @Getter private final Player owner;

    @Getter
    private final Int2FloatMap fightProperties;

    @Getter private final int pointId;
    @Getter private final int gadgetId;

    @Getter @Setter private float curStamina;
    @Getter @Setter private VehicleData vehicleDataA;
    @Getter @Setter public float curPhlogiston;
    @Getter private List<VehicleMember> vehicleMembers;
    @Nullable @Getter private ConfigEntityGadget configGadget;
    public int transformEntityId;
    public EntityVehicle(
            Scene scene, Player player, int gadgetId, int pointId, Position pos, Position rot) {
                super(scene, pos, rot);
                this.owner = player;
                this.id = getScene().getWorld().getNextEntityId(EntityIdType.GADGET);
                this.fightProperties = new Int2FloatOpenHashMap();
                this.gadgetId = gadgetId;
                this.pointId = pointId;
                this.curStamina = 240; // might be in configGadget.GCALKECLLLP.JBAKBEFIMBN.ANBMPHPOALP
                this.curPhlogiston = 50;
                this.vehicleMembers = new ArrayList<>();
                GadgetData data = GameData.getGadgetDataMap().get(gadgetId);
                if (data != null && data.getJsonName() != null) {
                        this.configGadget = GameData.getGadgetConfigData().get(data.getJsonName());
                }

                fillFightProps(configGadget);
                this.initAbilities();
    }

    @Override
    protected void fillFightProps(ConfigEntityGadget configGadget) {
        super.fillFightProps(configGadget);
        this.addFightProperty(FightProperty.FIGHT_PROP_CUR_SPEED, 0);
        this.addFightProperty(FightProperty.FIGHT_PROP_CHARGE_EFFICIENCY, 0);
    }

    private void addConfigAbility(ConfigAbilityData abilityData) {
        var data = GameData.getAbilityData(abilityData.getAbilityName());

        if (data != null)
            this.getScene().getWorld().getHost().getAbilityManager().addAbilityToEntity(this, data);
    }

    @Override
    public SceneEntityInfo toProto() {

        VehicleInfo vehicle =
                VehicleInfo.newBuilder()
                        .setOwnerUid(this.owner.getUid())
                        .setCurStamina(getCurStamina())
                        .setCurPhlogiston(getCurPhlogiston())
                        .setTransformEntityId(transformEntityId)
                        .build();

        EntityAuthorityInfo authority =
                EntityAuthorityInfo.newBuilder()
                        .setAbilityInfo(AbilitySyncStateInfo.newBuilder())
                        .setRendererChangedInfo(EntityRendererChangedInfo.newBuilder())
                        .setAiInfo(
                                SceneEntityAiInfo.newBuilder()
                                        )
                        .setBornPos(getPosition().toProto())
                        .build();

        SceneGadgetInfo.Builder gadgetInfo =
                SceneGadgetInfo.newBuilder()
                        .setGadgetId(this.getGadgetId())
                        .setAuthorityPeerId(this.getOwner().getPeerId())
                        .setIsEnableInteract(true)
                        .setVehicleInfo(vehicle);

        SceneEntityInfo.Builder entityInfo =
                SceneEntityInfo.newBuilder()
                        .setEntityId(getId())
                        .setEntityType(ProtEntityType.PROT_ENTITY_GADGET)
                        .setMotionInfo(
                                MotionInfo.newBuilder()
                                        .setPos(getPosition().toProto())
                                        .setRot(getRotation().toProto())
                                        .setSpeed(Vector.newBuilder()))
                        .addAnimatorParaList(AnimatorParameterValueInfoPair.newBuilder())
                        .setGadget(gadgetInfo)
                        .setEntityAuthorityInfo(authority)
                        .setLifeState(1);

        PropPair pair =
                PropPair.newBuilder()
                        .setType(PlayerProperty.PROP_LEVEL.getId())
                        .setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, 90))
                        .build();

        this.addAllFightPropsToEntityInfo(entityInfo);
        entityInfo.addPropList(pair);

        return entityInfo.build();
    }

    @Override
    public void initAbilities() {
        // TODO Auto-generated method stub
        if (this.configGadget != null && this.configGadget.getAbilities() != null) {
            for (var ability : this.configGadget.getAbilities()) {
                this.addConfigAbility(ability);
            }
        }
    }
}
